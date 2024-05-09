-- Table: public.Pagos

-- DROP TABLE IF EXISTS public."Pagos";

CREATE TABLE IF NOT EXISTS public."Pagos"
(
    idpago integer NOT NULL DEFAULT nextval('"Pagos_idpago_seq"'::regclass),
    dni character varying(9) COLLATE pg_catalog."default" NOT NULL,
    cuenta character varying COLLATE pg_catalog."default" NOT NULL,
    cantidad numeric NOT NULL,
    "Operacion" character varying(10) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT "Pagos_pkey" PRIMARY KEY (idpago),
    CONSTRAINT dni FOREIGN KEY (dni)
        REFERENCES public."Alumnos" (dni) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public."Pagos"
    OWNER to postgres;