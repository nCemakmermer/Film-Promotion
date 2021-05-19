CREATE TABLE public.users
(
    id bigint NOT NULL DEFAULT nextval('users_id_seq'::regclass),
    email character varying(45) COLLATE pg_catalog."default" NOT NULL,
    first_name character varying(20) COLLATE pg_catalog."default" NOT NULL,
    last_name character varying(20) COLLATE pg_catalog."default" NOT NULL,
    password character varying(64) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT users_pkey PRIMARY KEY (id),
    CONSTRAINT uk_6dotkott2kjsp8vw4d0m25fb7 UNIQUE (email)
)

TABLESPACE pg_default;

ALTER TABLE public.users
    OWNER to postgres;