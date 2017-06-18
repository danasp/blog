CREATE SEQUENCE IF NOT EXISTS public.account_generator
INCREMENT 1
MINVALUE 1
MAXVALUE 9223372036854775807
START 1
CACHE 1;
ALTER TABLE public.account_generator
OWNER TO postgres;

INSERT INTO account (id, email, firstname, lastname, password, username, roles)
  VALUES (1, 'dvereschakov@gmail.com', 'Данила', 'Верещаков', '$2a$10$f3tgC8zcEMZYX0U0wgl71u0wdbh34xMT3Zq39WALoDFTsAXNDgtSy', 'danila', 'ADMIN');


INSERT INTO ROLES (account_id, roles) VALUES (1, 'ADMIN')