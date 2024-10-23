INSERT INTO nave (
    nome,
    cor,
    tamanho,
    local_queda,
    armamento,
    tipo_combustivel,
    grau_avaria,
    potencial_tecnologico,
    total_tripulante_bem,
    total_tripulante_ferido,
    total_tripulante_foi_com_deus,
    periculosidade,
    classificacao,
    criado_em,
    atualizado_em
)
VALUES
    ('Nave Fênix', 'VERMELHA', 'COLOSSAL', 'AFRICA', 'BOMBA', 'ESPRESSO_QUANTICO', 'PERDA_TOTAL', 'DIVINA', 10, 5, 0, 'ALTA', 'AMEACA_EM_POTENCIAL', now(), now()),
    ('Estrela da Manhã', 'LARANJA', 'GRANDE', 'AMERICA', 'CANHAO_LAVA', 'FALHA_GRAVITACIONAL', 'MUITO_DESTRUIDA', 'SOBERANA', 8, 2, 3, 'ALTISSIMA', 'ARSENAL_ALIENIGENA', now(), now()),
    ('Vento Estelar', 'AZUL', 'MEDIA', 'ASIA', 'LASER', 'GERADOR_PROBABILIDADE_INFINITA', 'PARCIALMENTE_DESTRUIDA', 'AVANCADA', 15, 1, 4, 'BAIXA', 'FONTE_DE_ENERGIA', now(), now()),
    ('Dragão Cósmico', 'ANIL', 'PEQUENA', 'EUROPA', 'MISSEL', 'LAGRIMAS_DE_UNICORNIO', 'PRATICAMENTE_INTACTA', 'TRANSCENDENTE', 12, 0, 1, 'BAIXISSIMA', 'JOIA_TECNOLOGICA', now(), now()),
    ('Sentinela Espacial', 'VERDE', 'COLOSSAL', 'OCEANIA', 'OGIVA_NUCLEAR', 'MATERIA_ESCURA', 'SEM_AVARIAS', 'PRIMITIVA', 7, 0, 0, 'MEDIA', 'SUCATA_ESPACIAL', now(), now()),
    ('Luz Celeste', 'VIOLETA', 'GRANDE', 'OCEANO_ATLANTICO', 'BOMBA', 'PLUTONIO', 'MUITO_DESTRUIDA', 'SOBERANA', 9, 2, 5, 'ALTA', 'AMEACA_EM_POTENCIAL',  now(), now()),
    ('Sombras do Espaço', 'AMARELA', 'MEDIA', 'OCEANO_GLACIAL_ANTARTICO', 'CANHAO_LAVA', 'LAGRIMAS_DE_UNICORNIO', 'PERDA_TOTAL', 'DIVINA', 5, 1, 3, 'ALTISSIMA', 'ARSENAL_ALIENIGENA', now(), now()),
    ('Guardião da Galáxia', 'VERMELHA', 'PEQUENA', 'OCEANO_GLACIAL_ARTICO', 'LASER', 'FALHA_GRAVITACIONAL', 'PARCIALMENTE_DESTRUIDA', 'AVANCADA', 13, 4, 1, 'BAIXA', 'FONTE_DE_ENERGIA', now(), now()),
    ('Corvo Cósmico', 'AMARELA', 'COLOSSAL', 'OCEANO_INDICO', 'MISSEL', 'FALHA_GRAVITACIONAL', 'SEM_AVARIAS', 'TRANSCENDENTE', 8, 0, 0, 'BAIXISSIMA', 'JOIA_TECNOLOGICA', now(), now()),
    ('Meteoro Negro', 'AZUL', 'GRANDE', 'OCEANO_PACIFICO', 'OGIVA_NUCLEAR', 'LAGRIMAS_DE_UNICORNIO', 'PERDA_TOTAL', 'DIVINA', 6, 2, 4, 'MEDIA', 'SUCATA_ESPACIAL', now(), now()),
    ('Lâmina Solar', 'VERDE', 'MEDIA', 'AFRICA', 'BOMBA', 'MATERIA_ESCURA', 'MUITO_DESTRUIDA', 'SOBERANA', 10, 1, 0, 'ALTISSIMA', 'SUCATA_ESPACIAL', now(), now()),
    ('Brilho Estelar', 'ANIL', 'PEQUENA', 'AMERICA', 'CANHAO_LAVA', 'PLUTONIO', 'PRATICAMENTE_INTACTA', 'AVANCADA', 9, 0, 1, 'MEDIA', 'ARSENAL_ALIENIGENA', now(), now());

