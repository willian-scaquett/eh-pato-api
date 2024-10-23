package com.patos.alens.demo.service;

import com.patos.alens.demo.dto.ListsValoresSelectDTO;
import com.patos.alens.demo.dto.NaveRequestDTO;
import com.patos.alens.demo.dto.NaveResponseDTO;
import com.patos.alens.demo.dto.ValoresSelectDTO;
import com.patos.alens.demo.entity.Nave;
import com.patos.alens.demo.enumerated.*;
import com.patos.alens.demo.repository.NaveRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public ResponseEntity<?> atualizaNave(Long idNave, NaveRequestDTO naveRequestDTO) throws BadRequestException {

        Nave nave = this.naveRepository.findById(idNave).orElse(null);

        if (nave == null) {
            return ResponseEntity.notFound().build();
        }

        boolean naveExiste = naveRepository.existsByNomeAndIdNot(naveRequestDTO.getNome(), idNave);

        if (naveExiste) {
            throw new BadRequestException();
        }
        nave.atualizaNave(naveRequestDTO);

        this.naveRepository.save(nave);
        return ResponseEntity.ok(nave);
    }

    public Nave buscaNavePeloId(Long id) throws BadRequestException {
        Nave nave = this.naveRepository.findById(id).orElse(null);
        if (nave == null) {
            throw new BadRequestException();
        }
        return nave;
    }

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

    /**
     * Define os atributos classificao e periculosidade da entidade Nave conforme
     * as características informadas.
     */
    private Nave definirCategoriaEPericulosidade(Nave nave) {
        float poderArmas = 0;
        float poderCombustivel = 0;
        float perigo = 0;

        /**
         *  A nossa base de operações é no Brasil. Quanto mais longe o continente, mais perigosa é a missão de recolhimento da nave.
         *  No caso dos Oceanos, segue-se a lógica da distância dos continentes, porém, operações no mar sempre serão
         *  mais perigosas
         */
        perigo += nave.getLocalQueda().getPerigo();

        /**
         * Quanto mais poderosa a arma, maior o seu poder.
         * Contudo, a instabilidade da arma aumenta o perigo.
         */
        poderArmas += nave.getArmamento().getPoder();
        perigo += nave.getArmamento().getPerigo();

        /**
         * Seguindo a lógica do armamento, o poder do combustível é a sua capacidade de geração
         * de energia e o seu perigo são os riscos de manipular aquele combustível
         */
        poderCombustivel += nave.getTipoCombustivel().getPoder();
        perigo += nave.getTipoCombustivel().getPerigo();

        /**
         * O tamanho da nave dá um bônus para o poder das armas e do combustível.
         * Quanto maior o tamanho, maior a quantidade que esperamos encontrar.
         */
        poderArmas += nave.getTamanho().getBonus();
        poderCombustivel += nave.getTamanho().getBonus();

        /**
         * O potencial tecnológico influência na tecnologia usada nas armas e na forma
         * de manipulação das fontes energéticas. Portanto, causa um bônus para ambos.
         */
        poderArmas += nave.getPotencialTecnologico().getBonus();
        poderCombustivel += nave.getPotencialTecnologico().getBonus();

        /**
         * O grau de avaria causa uma punição no poder de armas e combustível.
         * Quanto mais destruída a nave, maior a chance das tecnologias e fontes energéticas
         * também estarem destruídas.
         */
        poderArmas -= nave.getGrauAvaria().getPunicao();
        poderCombustivel -= nave.getGrauAvaria().getPunicao();

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
        nave.setClassificacao(classificarNave(poderArmas, poderCombustivel, nave.getTotalTripulanteBem(), nave.getTotalTripulanteFerido()));

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
    private Classificacao classificarNave(float poderArmas, float poderCombustivel, int totalTripulanteBem, int totalTripulanteFerido) {
        final int notaCorte = 18;

        if ((poderArmas > notaCorte || poderCombustivel > notaCorte)
                && (totalTripulanteBem + (totalTripulanteFerido > 0 ? totalTripulanteFerido / 2 : 0) >= 20)) {
            return Classificacao.AMEACA_EM_POTENCIAL;
        }

        if (poderArmas >= notaCorte && poderCombustivel >= notaCorte) {
            return Classificacao.JOIA_TECNOLOGICA;
        }
        if (poderArmas >= notaCorte) {
            return Classificacao.ARSENAL_ALIENIGENA;
        }
        if (poderCombustivel >= notaCorte) {
            return Classificacao.FONTE_DE_ENERGIA;
        }

        return Classificacao.SUCATA_ESPACIAL;
    }
}
