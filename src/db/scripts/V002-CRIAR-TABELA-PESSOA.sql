CREATE TABLE IF NOT EXISTS "pessoa" (
  "id_pessoa" SERIAL PRIMARY KEY NOT NULL,
  "nome" varchar(50) NOT NULL,
  "data_nascimento" date  NOT NULL,
  "email" varchar(50) NOT NULL,
  "celular" varchar(11)
);