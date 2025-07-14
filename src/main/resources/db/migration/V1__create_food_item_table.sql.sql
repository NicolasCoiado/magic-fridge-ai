-- 1. Criação do tipo ENUM
CREATE TYPE food_category AS ENUM (
    'CARNES',
    'LATICINIOS',
    'VEGETAIS',
    'FRUTAS',
    'BEBIDAS',
    'GRAOS_E_MASSAS',
    'DOCES',
    'OVOS',
    'TEMPEROS',
    'CONGELADOS',
    'ENLATADOS',
    'OUTROS'
);

-- 2. Criação da tabela
CREATE TABLE food_item (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255),
    categoria food_category NOT NULL,
    quantidade INTEGER,
    validade DATE
);