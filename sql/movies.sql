CREATE TABLE public.movies
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    name character varying(512) COLLATE pg_catalog."default" NOT NULL,
    type character varying(512) COLLATE pg_catalog."default" NOT NULL,
    director character varying(512) COLLATE pg_catalog."default" NOT NULL,
    year_of_construction date NOT NULL,
    description character varying(512) COLLATE pg_catalog."default",
    CONSTRAINT movies_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE public.movies
    OWNER to postgres;