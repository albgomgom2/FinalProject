-- Table: public.Notas

-- DROP TABLE IF EXISTS public."Notas";

CREATE TABLE IF NOT EXISTS public."Notas"
(
    dni character varying(9) COLLATE pg_catalog."default" NOT NULL,
    nota1 numeric,
    nota2 numeric,
    nota3 numeric,
    notafinal numeric,
    activo boolean NOT NULL DEFAULT true,
    estado character varying(30) COLLATE pg_catalog."default" NOT NULL DEFAULT 'Cursando'::character varying,
    asignatura integer,
    id_notas integer NOT NULL DEFAULT nextval('"Notas_id_notas_seq"'::regclass),
    CONSTRAINT "Notas_pkey" PRIMARY KEY (id_notas),
    CONSTRAINT asignatura FOREIGN KEY (asignatura)
        REFERENCES public."Asignaturas" (id_asignaturas) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT dni FOREIGN KEY (dni)
        REFERENCES public."Alumnos" (dni) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public."Notas"
    OWNER to postgres;