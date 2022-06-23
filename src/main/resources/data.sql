INSERT INTO escola.endereco VALUES ('1');
INSERT INTO escola.endereco (id) VALUES ('2');

INSERT INTO escola.curso (id, nome, sigla) VALUES ('1', 'Ciência da computação', 'CCP');
INSERT INTO escola.curso (id, nome, sigla) VALUES ('2', 'Nutrição', 'NUT');

INSERT INTO escola.aluno (id, nome, status, endereco_id) VALUES ('1', 'Patricia', 'INICIADO', '1');
INSERT INTO escola.aluno (id, nome, status, endereco_id) VALUES ('2', 'Osvaldo', 'INICIADO', '2');
INSERT INTO escola.aluno (id, nome, status, endereco_id) VALUES ('3', 'Joaozinho', 'INICIADO', '1');

INSERT INTO escola.professor VALUES ('1', null, 'Prof Rochedo', '1');
INSERT INTO escola.professor VALUES ('2', null, 'Prof Maria', '1');
INSERT INTO escola.professor VALUES ('3', null, 'Prof Jose', '1');