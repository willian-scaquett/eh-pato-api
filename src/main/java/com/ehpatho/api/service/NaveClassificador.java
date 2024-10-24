package com.ehpatho.api.service;

import com.ehpatho.api.entity.Nave;
import com.ehpatho.api.enumerated.Classificacao;
import com.ehpatho.api.enumerated.Periculosidade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class NaveClassificador {

    /**
     * Define os atributos classificao e periculosidade da entidade Nave conforme
     * as características informadas.
     */
    public Nave definirCategoriaEPericulosidade(Nave nave) {
        log.info("Definindo categoria e periculosidade para a nave: {}", nave);
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

        log.debug("Periculosidade definida: {}, Classificação definida: {}", nave.getPericulosidade(), nave.getClassificacao());
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
}
