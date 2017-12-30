# Reps
AngularJS and Spring proto for recording reps at gym

## This is a proto

- No security
- No proper environment setup

## In case you want to try it

- Setup PostgreSQL database (database "routine", schema "public")

```
CREATE TABLE public.rep_set
(
    id bigint NOT NULL DEFAULT nextval('rep_set_id_seq'::regclass),
    CONSTRAINT rep_set_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.rep_set
    OWNER to postgres;

CREATE TABLE public.rep
(
    id bigint NOT NULL DEFAULT nextval('rep_id_seq'::regclass),
    times integer NOT NULL,
    rep_set_id bigint NOT NULL DEFAULT nextval('rep_rep_set_id_seq'::regclass),
    CONSTRAINT rep_pkey PRIMARY KEY (id),
    CONSTRAINT rep_rep_set_id_foreign FOREIGN KEY (rep_set_id)
        REFERENCES public.rep_set (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.rep
    OWNER to postgres;
```

- Install and run

```
$ npm install
$ mvn spring-boot:run
$ npm start
```

