INSERT INTO public.users(username, password, role) VALUES ('admin', '{bcrypt}$2a$10$w72sMdWHUBbkYzl1BSwaU.AmxYY7tcY6UBRVttJUbW1HrR78IDlAW', 'ROLE_ADMIN');

INSERT INTO public.users(username, password, role) VALUES ('serveur', '{bcrypt}$2a$10$vLRzSgdw/yZf7zTdlo4ZTurcwXnbctMgUA895vZ.ThCpDxe.edqpm', 'ROLE_SERVEUR');

INSERT INTO public.roles(id, name) VALUES(1, 'ROLE_USER');
INSERT INTO public.roles(id, name) VALUES(2, 'ROLE_ADMIN');