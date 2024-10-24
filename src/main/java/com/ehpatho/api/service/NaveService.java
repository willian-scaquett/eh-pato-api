package com.ehpatho.api.service;

import com.ehpatho.api.dto.ListsValoresSelectDTO;
import com.ehpatho.api.dto.NaveRequestDTO;
import com.ehpatho.api.dto.NaveResponseDTO;
import com.ehpatho.api.dto.ValoresSelectDTO;
import com.ehpatho.api.entity.Nave;
import com.ehpatho.api.enumerated.*;
import com.patos.alens.demo.enumerated.*;
import com.ehpatho.api.repository.NaveRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * A classe NaveService é responsável por disponibilizar a regra de negócio do CRUD de nave
 *
 * @author Kaique Queiros kaique_q@outlook.com
 */
@Service
public class NaveService {

    private final NaveRepository naveRepository;

    public NaveService(NaveRepository naveRepository) {
        this.naveRepository = naveRepository;
    }

    public List<NaveResponseDTO> listaNaves() {
        //Busca todos os registros da entidade Nave e retorna numa lista de NaveResponseDTO
        List<NaveResponseDTO> response = new ArrayList<>();
        naveRepository.findAll().forEach(nave -> response.add(new NaveResponseDTO(nave)));
        return response;
    }

    public NaveResponseDTO criarNave(NaveRequestDTO naveRequestDTO) throws BadRequestException {
        //Verifica se nome já existe
        if (naveRepository.existsByNome(naveRequestDTO.getNome())) {
            throw new BadRequestException();
        }

        //Define os atributos categoria e periculosidade da nave criada conforme o DTO
        Nave nave = definirCategoriaEPericulosidade(new Nave(naveRequestDTO));

        //Salva a nova nave no banco e a retorna em um DTO
        return new NaveResponseDTO(naveRepository.save(nave));
    }

    public void apagarNave(Long id) throws BadRequestException {
        //Busca a nave a ser apagada
        Nave nave = this.naveRepository.findById(id).orElse(null);
        //Caso ela não exista, retorna um bad request
        if (nave == null) {
            throw new BadRequestException();
        }
        //Apaga a nave
        naveRepository.deleteById(id);
    }

    public NaveResponseDTO editarNave(Long idNave, NaveRequestDTO naveRequestDTO) throws BadRequestException {
        //Busca a nave a ser editada
        Nave nave = this.naveRepository.findById(idNave).orElse(null);

        //Caso a nave não exista ou o novo nome da nave já existir, retorna um bad request
        if (nave == null && naveRepository.existsByNomeAndIdNot(naveRequestDTO.getNome(), idNave)) {
            throw new BadRequestException();
        }

        //Define novos dados da nave
        nave.editarNave(naveRequestDTO);
        //Reclassifica a nave com os novos dados
        nave = definirCategoriaEPericulosidade(nave);

        //Salva a nave editada no banco e a retorna em um DTO
        return new NaveResponseDTO(naveRepository.save(nave));
    }

    public Nave buscaNavePeloId(Long id) throws BadRequestException {
        //Busca nave pelo ID
        Nave nave = this.naveRepository.findById(id).orElse(null);
        //Caso ela não exista, retorna um bad request
        if (nave == null) {
            throw new BadRequestException();
        }
        return nave;
    }

    /**
     * Define os atributos classificao e periculosidade da entidade Nave conforme
     * as características informadas.
     */
    private Nave definirCategoriaEPericulosidade(Nave nave) {
        float potencialArmas = 0;
        float potencialCombustivel = 0;
        float perigo = 0;

        /**
         *  A nossa base de operações é no Brasil. Quanto mais longe o continente, mais perigosa é a missão de recolhimento da nave.
         *  No caso dos Oceanos, segue-se a lógica da distância dos continentes, porém, operações no mar sempre serão
         *  mais perigosas
         */
        perigo += nave.getLocalQueda().getPerigo();

        /**
         * Quanto mais poderosa a arma, maior o seu potencial.
         * Contudo, a sua instabilidade aumenta o perigo.
         */
        potencialArmas += nave.getArmamento().getPoder();
        perigo += nave.getArmamento().getPerigo();

        /**
         * Seguindo a lógica do armamento, o potencial do combustível é a sua capacidade de geração
         * de energia e o seu perigo são os riscos de manipulá-lo
         */
        potencialCombustivel += nave.getTipoCombustivel().getPoder();
        perigo += nave.getTipoCombustivel().getPerigo();

        /**
         * O tamanho da nave dá um bônus para o potencial das armas e do combustível.
         * Quanto maior o tamanho, maior a quantidade que esperamos encontrar.
         */
        potencialArmas += nave.getTamanho().getBonus();
        potencialCombustivel += nave.getTamanho().getBonus();

        /**
         * O potencial tecnológico influência na tecnologia usada nas armas e na forma
         * de manipulação das fontes energéticas. Portanto, causa um bônus para ambos.
         */
        potencialArmas += nave.getPotencialTecnologico().getBonus();
        potencialCombustivel += nave.getPotencialTecnologico().getBonus();

        /**
         * O grau de avaria causa uma punição no potencial de armas e combustível.
         * Quanto mais destruída a nave, maior a chance das tecnologias e fontes energéticas
         * também estarem destruídas.
         */
        potencialArmas -= nave.getGrauAvaria().getPunicao();
        potencialCombustivel -= nave.getGrauAvaria().getPunicao();

        /**
         * O xenófagos tripulantes que sobreviveram ainda devem estar ao redor do local da queda,
         * portanto, isso causa um aumento do perigo. Os feridos impactam menos que os que estão bem.
         * Já os que fora com Deus, ainda impactam minimamente, pois os seus corpos emitem toxinas, o que
         * pode ser um risco para os nossos agentes.
         */
        perigo += nave.getTotalTripulanteBem();
        perigo += nave.getTotalTripulanteFerido() != 0 ? Float.valueOf(nave.getTotalTripulanteFerido()) / 2 : 0;
        perigo += nave.getTotalTripulanteFoiComDeus() != 0 ? Float.valueOf(nave.getTotalTripulanteFoiComDeus()) / 10 : 0;

        nave.setPericulosidade(classificarPerigo(perigo));
        nave.setClassificacao(classificarNave(potencialArmas, potencialCombustivel, nave.getTotalTripulanteBem(), nave.getTotalTripulanteFerido()));

        return nave;
    }

    //Classifica a periculosidade conforme a somatória calculada
    private Periculosidade classificarPerigo(float perigo) {
        if (perigo <= 8) {
            return Periculosidade.BAIXISSIMA;
        }
        if (perigo <= 16) {
            return Periculosidade.BAIXA;
        }
        if (perigo <= 24) {
            return Periculosidade.MEDIA;
        }
        if (perigo <= 32) {
            return Periculosidade.ALTA;
        }
        return Periculosidade.ALTISSIMA;
    }

    /**
     * A nave é classificada conforme os somatórios que atingiram a nota de corte e o total de tripulantes bem e feridos.
     * Naves que atingem a nota de corte em algum dos somatórios e têm pelo menos 20 tripulantes (sendo os feridos
     * considerados 0,5 tripulante nessa conta), são consideradas Ameaça em Potencial, pois podem voltar às operações
     * ou ser um foco de resistência dos invasores.
     * Quando não é o caso, a nave é classificada como Joia Tecnológica, Arsenal Alienígena ou Fonte de Energia Alternativa,
     * conforme os somatórios que atingem a nota de corte, ou como Sucata Espacial, quando nenhum deles atinge.
     */
    private Classificacao classificarNave(float potencialArmas, float potencialCombustivel, int totalTripulanteBem, int totalTripulanteFerido) {
        final int notaCorte = 18;

        if ((potencialArmas > notaCorte || potencialCombustivel > notaCorte)
                && (totalTripulanteBem + (totalTripulanteFerido > 0 ? totalTripulanteFerido / 2 : 0) >= 20)) {
            return Classificacao.AMEACA_EM_POTENCIAL;
        }

        if (potencialArmas >= notaCorte && potencialCombustivel >= notaCorte) {
            return Classificacao.JOIA_TECNOLOGICA;
        }
        if (potencialArmas >= notaCorte) {
            return Classificacao.ARSENAL_ALIENIGENA;
        }
        if (potencialCombustivel >= notaCorte) {
            return Classificacao.FONTE_DE_ENERGIA;
        }

        return Classificacao.SUCATA_ESPACIAL;
    }

    /**
     * Adiciona na lista de cada campo os valores dos enums a serem usados nos selects do front-end
     * Dessa forma, evitam-se informações duplicadas e facilita a manutenção
     */
    public ListsValoresSelectDTO getValoresSelectsCadastro() {
        ListsValoresSelectDTO response = new ListsValoresSelectDTO();

        for (Cor cor : Cor.values()) {
            response.getCores().add(new ValoresSelectDTO(cor.name(), cor.getNome()));
        }

        for (LocalQueda localQueda : LocalQueda.values()) {
            response.getLocais().add(new ValoresSelectDTO(localQueda.name(), localQueda.getNome()));
        }

        for (TipoCombustivel tipoCombustivel : TipoCombustivel.values()) {
            response.getCombustiveis().add(new ValoresSelectDTO(tipoCombustivel.name(), tipoCombustivel.getNome()));
        }

        for (GrauAvaria grauAvaria : GrauAvaria.values()) {
            response.getGraus().add(new ValoresSelectDTO(grauAvaria.name(), grauAvaria.getNome()));
        }

        for (PotencialTecnologico potencialTecnologico : PotencialTecnologico.values()) {
            response.getPotenciais().add(new ValoresSelectDTO(potencialTecnologico.name(), potencialTecnologico.getNome()));
        }

        for (Armamento armamento : Armamento.values()) {
            response.getArmamentos().add(new ValoresSelectDTO(armamento.name(), armamento.getNome()));
        }

        for (Tamanho tamanho : Tamanho.values()) {
            response.getTamanhos().add(new ValoresSelectDTO(tamanho.name(), tamanho.getNome()));
        }

        return response;
    }
}
