-- Table: public.Asignaturas_Cursos

-- DROP TABLE IF EXISTS public."Asignaturas_Cursos";

CREATE TABLE IF NOT EXISTS public."Asignaturas_Cursos"
(
    idcurso integer,
    asignatura integer,
    CONSTRAINT asignaturas FOREIGN KEY (asignatura)
        REFERENCES public."Asignaturas" (id_asignaturas) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT curso FOREIGN KEY (idcurso)
        REFERENCES public."Cursos" (id_curso) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public."Asignaturas_Cursos"
    OWNER to postgres;