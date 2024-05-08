-- Table: public.Cursos

-- DROP TABLE IF EXISTS public."Cursos";

CREATE TABLE IF NOT EXISTS public."Cursos"
(
    nombre character varying(100) COLLATE pg_catalog."default" NOT NULL,
    abreviatura character varying(10) COLLATE pg_catalog."default" NOT NULL,
    aula character varying(10) COLLATE pg_catalog."default" NOT NULL,
    nivel numeric NOT NULL,
    turno numeric NOT NULL,
    id_curso integer NOT NULL DEFAULT nextval('"Cursos_id_curso_seq"'::regclass),
    CONSTRAINT "Cursos_pkey" PRIMARY KEY (id_curso)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public."Cursos"
    OWNER to postgres;