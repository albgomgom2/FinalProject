-- Table: public.Alumnos

-- DROP TABLE IF EXISTS public."Alumnos";

CREATE TABLE IF NOT EXISTS public."Alumnos"
(
    dni character varying(9) COLLATE pg_catalog."default" NOT NULL,
    nombre character varying(30) COLLATE pg_catalog."default" NOT NULL,
    apellidos character varying(50) COLLATE pg_catalog."default" NOT NULL,
    edad numeric NOT NULL,
    direccion character varying(100) COLLATE pg_catalog."default" NOT NULL,
    localidad character varying(30) COLLATE pg_catalog."default" NOT NULL,
    ciudad character varying(30) COLLATE pg_catalog."default" NOT NULL,
    pais character varying(30) COLLATE pg_catalog."default" NOT NULL,
    activo boolean NOT NULL DEFAULT true,
    telefono character varying(9) COLLATE pg_catalog."default" NOT NULL,
    email character varying(100) COLLATE pg_catalog."default" NOT NULL,
    "fechaNacimiento" date NOT NULL,
    usuario character varying(9) COLLATE pg_catalog."default" NOT NULL,
    "contraseña" character varying(100) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT "Alumnos_pkey" PRIMARY KEY (dni)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public."Alumnos"
    OWNER to postgres;