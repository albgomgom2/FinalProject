-- Table: public.Asignaturas

-- DROP TABLE IF EXISTS public."Asignaturas";

CREATE TABLE IF NOT EXISTS public."Asignaturas"
(
    nombre character varying(100) COLLATE pg_catalog."default" NOT NULL,
    horas numeric NOT NULL,
    id_asignaturas integer NOT NULL DEFAULT nextval('"Asignaturas_id_asignaturas_seq"'::regclass),
    CONSTRAINT "Asignaturas_pkey" PRIMARY KEY (id_asignaturas)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public."Asignaturas"
    OWNER to postgres;