-- Table: public.Matriculas

-- DROP TABLE IF EXISTS public."Matriculas";

CREATE TABLE IF NOT EXISTS public."Matriculas"
(
    dni character varying(9) COLLATE pg_catalog."default" NOT NULL,
    fechamatricula date NOT NULL,
    repetidor boolean NOT NULL DEFAULT false,
    estado character varying(30) COLLATE pg_catalog."default" NOT NULL DEFAULT 'Cursando'::character varying,
    id_matricula integer NOT NULL DEFAULT nextval('"Matriculas_id_matricula_seq"'::regclass),
    idcurso integer,
    CONSTRAINT "Matriculas_pkey" PRIMARY KEY (id_matricula),
    CONSTRAINT curso FOREIGN KEY (idcurso)
        REFERENCES public."Cursos" (id_curso) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT dni FOREIGN KEY (dni)
        REFERENCES public."Alumnos" (dni) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public."Matriculas"
    OWNER to postgres;