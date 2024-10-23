INSERT INTO nave (
    nome,
    cor,
    local_queda,
    armamento,
    tipo_combustivel,
    grau_avaria,
    potencial_tecnologico,
    total_tripulante_bem,
    total_tripulante_ferido,
    total_tripulante_foi_com_deus,
    criado_em,
    atualizado_em
)
VALUES
    ('Nave Fênix', 'VERMELHA', 'AFRICA', 'BOMBA', 'ESPRESSO_QUANTICO', 'PERDA_TOTAL', 'DIVINA', 10, 5, 0, now(), now()),
    ('Estrela da Manhã', 'LARANJA', 'AMERICA', 'CANHAO_LAVA', 'FALHA_GRAVITACIONAL', 'MUITO_DESTRUIDA', 'SOBERANA', 8, 2, 3, now(), now()),
    ('Vento Estelar', 'AZUL', 'ASIA', 'LASER', 'GERADOR_PROBABILIDADE_INFINITA', 'PARCIALMENTE_DESTRUIDA', 'AVANCADA', 15, 1, 4, now(), now()),
    ('Dragão Cósmico', 'ANIL', 'EUROPA', 'MISSEL', 'LAGRIMAS_DE_UNICORNIO', 'PRATICAMENTE_INTACTA', 'TRANSCENDENTE', 12, 0, 1, now(), now()),
    ('Sentinela Espacial', 'VERDE', 'OCEANIA', 'OGIVA_NUCLEAR', 'MATERIA_ESCURA', 'SEM_AVARIAS', 'PRIMITIVA', 7, 0, 0, now(), now()),
    ('Luz Celeste', 'VIOLETA', 'OCEANO_ATLANTICO', 'BOMBA', 'PLUTONIO', 'MUITO_DESTRUIDA', 'SOBERANA', 9, 2, 5,now(), now()),
    ('Sombras do Espaço', 'AMARELA', 'OCEANO_GLACIAL_ANTARTICO', 'CANHAO_LAVA', 'LAGRIMAS_DE_UNICORNIO', 'PERDA_TOTAL', 'DIVINA', 5, 1, 3,now(), now()),
    ('Guardião da Galáxia', 'VERMELHA', 'OCEANO_GLACIAL_ARTICO', 'LASER', 'FALHA_GRAVITACIONAL', 'PARCIALMENTE_DESTRUIDA', 'AVANCADA', 13, 4, 1,now(), now()),
    ('Corvo Cósmico', 'AMARELA', 'OCEANO_INDICO', 'MISSEL', 'FALHA_GRAVITACIONAL', 'SEM_AVARIAS', 'TRANSCENDENTE', 8, 0, 0,now(), now()),
    ('Meteoro Negro', 'AZUL', 'OCEANO_PACIFICO', 'OGIVA_NUCLEAR', 'LAGRIMAS_DE_UNICORNIO', 'PERDA_TOTAL', 'DIVINA', 6, 2, 4,now(), now()),
    ('Lâmina Solar', 'VERDE', 'AFRICA', 'BOMBA', 'MATERIA_ESCURA', 'MUITO_DESTRUIDA', 'SOBERANA', 10, 1, 0,now(), now()),
    ('Brilho Estelar', 'ANIL', 'AMERICA', 'CANHAO_LAVA', 'PLUTONIO', 'PRATICAMENTE_INTACTA', 'AVANCADA', 9, 0, 1,now(), now());

