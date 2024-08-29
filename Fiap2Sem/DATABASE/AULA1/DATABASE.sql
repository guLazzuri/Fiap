
CREATE TABLE T_ALUNO(
id_aluno int primary key,
nome_aluno varchar(60),
rm_aluno int not null,
data_nascimento date,
situacao boolean,
situacao_alumo int,
renda double,
id_turma int references T_Turma

);

Create table T_turma(
id_trma int primary key,
sg_tura varchar(6),
curo varchar(6),
periodo varchar(5) -- noturno, matutino, vespertino

);
