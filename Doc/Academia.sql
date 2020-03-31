create database Academia;

create table Aluno (pnome varchar(20) not null,
                    unome varchar(30) not null,
                    telefone varchar(20),
                    matricula varchar(10) not null primary key);

create table Pacote (nome varchar(20) not null  primary key,
                    preco float8 not null);

create table Contrata (numeroContrato SERIAL not null primary key,
                        matricula varchar(10), CONSTRAINT fk_Aluno_matricula foreign key (matricula) references Aluno(matricula) ON delete Cascade,
                        nomepacote varchar(20), CONSTRAINT fk_Pacote_nome foreign key (nomepacote) references Pacote(nome) ON delete Cascade,
                        dataInicio date not null default current_date,
                        dataFim date not null);

create table Servicos (id integer not null primary key,
                        nome varchar(50));

create table Funcionario (pnome varchar(20) not null,
                            unome varchar(30) not null,
                            cpf varchar(15) not null primary key,
                            cref varchar(15) not null);

create table Contem  (id integer not null, CONSTRAINT fk_Servicos_id foreign key  (id) references  Servicos(id) ON delete Cascade,
                        nome varchar(20) not null, CONSTRAINT fk_Pacote_Nome foreign key (nome) references Pacote(nome) ON delete Cascade);

create table TrabalhaEm (cpf varchar(15) not null, CONSTRAINT fk_Funcionarios_cpf foreign key (cpf) references Funcionario(cpf) ON delete Cascade,
                        id integer not null, CONSTRAINT fk_Servicos_id foreign key (id) references Servicos(id) ON delete Cascade);

create table AvalicaoFisica (data date not null default current_date,
                            matricula varchar(10) not null, CONSTRAINT fk_Aluno_matricula foreign key (matricula) references Aluno(matricula) ON delete Cascade,
                            numAvaliacao SERIAL primary key,
                            cpf varchar(15) not null, CONSTRAINT fk_Funcionario_cpf foreign key (cpf) references Funcionario(cpf) ON delete Cascade,
                            altura float8 not null,
                            objetivoAluno varchar(50) not null,
                            totalGordura float8 not null,
                            peso float8 not null,
                            dobraTricipical float8 not null,
                            dobraSubescapular float8 not null,
                            dobraAxiliarMedia float8 not null,
                            dobraAbdominal float8 not null,
                            dobraCoxa float8 not null,
                            dobraPeitoral float8 not null,
                            dobraSupraIliaca float8 not null,
                            circunferenciaTorax float8 not null,
                            circunferenciaQuadril float8 not null,
                            circunferenciaCintura float8 not null,
                            circunferenciaAbdomen float8 not null,
                            circunferenciaCoxaDir float8 not null,
                            circunferenciaCoxaEsq float8 not null,
                            circunferenciaBracoDir float8 not null,
                            circunferenciaBracoEsq float8 not null
                            );

create table Pagamento (data date not null default current_date,
                        valor float8 not null,
                        formaPagamento varchar(20),
                        matricula varchar(10) not null, CONSTRAINT fk_Aluno_matricula foreign key (matricula) references Aluno(matricula) on delete cascade);

insert into Aluno(pnome, unome, telefone, matricula) values('Daniel', 'Magalhães', '031900000000', '18.1.8042');
insert into Aluno(pnome, unome, telefone, matricula) values ('Alan', 'Pessoa', '031922222222', '18.1.8001');
insert into Aluno(pnome, unome, telefone, matricula) values ('Paula', 'Gomes', '031911111111', '18.1.5908');
insert into Aluno(pnome, unome, telefone, matricula) values ('Pedro', 'Augusto', '031933333333', '18.1.6908');
insert into Aluno(pnome, unome, telefone, matricula) values ('João', 'Pedro', '031944444444', '19.1.6909');
insert into Aluno(pnome, unome, telefone, matricula) values ('José', 'Rosa', '031955555555', '19.1.2783');
insert into Aluno(pnome, unome, telefone, matricula) values ('Lucas', 'Rocha', '031966666666', '19.1.1234');
insert into Aluno(pnome, unome, telefone, matricula) values ('João', 'José', '031977777777', '19.1.4321');

insert into Pacote(nome, preco) values ('Monster', 60);
insert into Pacote(nome, preco) values ('fitness', 120);
insert into Pacote(nome, preco) values ('Brill', 140);

insert into Servicos(id, nome) values (01, 'Musculação');
insert into Servicos(id, nome) values (02, 'Aerobicos');
insert into Servicos(id, nome) values (03, 'Jump');
insert into Servicos(id, nome) values (04,  'Localizada');
insert into Servicos(id, nome) values (05,  'Zumba');

insert into Contem(id, nome) values (01, 'Monster');
insert into Contem(id, nome) values (02, 'fitness');
insert into Contem(id, nome) values (03, 'fitness');
insert into Contem(id, nome) values (05, 'fitness');
insert into Contem(id, nome) values (01, 'Brill');
insert into Contem(id, nome) values (02, 'Brill');
insert into Contem(id, nome) values (04, 'Brill');

insert into Contrata(matricula, nomepacote, dataInicio, dataFim) values ('18.1.8042', 'Monster', '2019-11-08', '2020-04-08');
insert into Contrata(matricula, nomepacote, dataInicio, dataFim) values ('18.1.8001', 'fitness', '2019-09-15', '2020-02-15');
insert into Contrata(matricula, nomepacote, dataInicio, dataFim) values ('18.1.5908', 'fitness', '2019-12-20', '2020-05-20');
insert into Contrata(matricula, nomepacote, datainicio, dataFim) values ('18.1.6908', 'Brill', '2019-07-10', '2019-12-10');
insert into Contrata(matricula, nomepacote, datainicio, dataFim) values ('19.1.6909', 'Monster', '2019-09-08', '2020-02-08');
insert into Contrata(matricula, nomepacote, dataFim) values ('19.1.2783', 'Brill', '2020-05-29');
insert into Contrata(matricula, nomepacote, datainicio, dataFim) values ('19.1.1234', 'Brill', '2019-06-30', '2019-11-30');
insert into Contrata(matricula, nomepacote, datainicio, dataFim) values ('19.1.4321', 'Monster', '2019-09-08', '2020-02-08');


insert into Funcionario(pnome, unome, cpf, cref) values ('Leticia', 'Araujo', '000.000.000-00', '001022-G/MG');
insert into Funcionario(pnome, unome, cpf, cref) values ('Luiz', 'Silva', '111.000.000-11', '001547-P/MG');
insert into Funcionario(pnome, unome, cpf, cref) values ('Jonatas', 'Silverio', '333.000.000-33', '001785-G/MG');
insert into Funcionario(pnome, unome, cpf, cref) values ('Ana', 'Pinto', '444.000.000-44', '001033-P/MG');
insert into Funcionario(pnome, unome, cpf, cref) values ('Alex', 'Pessoa', '111.111.111-11', '111111-G/MG');
insert into Funcionario(pnome, unome, cpf, cref) values ('Cassia', 'Linhares', '222.222.222-22', '221133-P/BA');
insert into Funcionario(pnome, unome, cpf, cref) values ('Natan', 'Melo', '333.333.333-33', '112233-G/ES');
insert into Funcionario(pnome, unome, cpf, cref) values ('Janaina', 'Silva', '444.444.444-44', '222222-P/MG');
insert into Funcionario(pnome, unome, cpf, cref) values ('Arthur', 'Cunha', '555.555.555-55', '333333-P/MG');



insert into TrabalhaEm(cpf, id) values ('000.000.000-00', 01);
insert into TrabalhaEm(cpf, id) values ('111.111.111-11', 01);
insert into TrabalhaEm(cpf, id) values ('111.000.000-11', 02);
insert into TrabalhaEm(cpf, id) values ('444.000.000-44', 02);
insert into TrabalhaEm(cpf, id) values ('333.000.000-33', 03);
insert into TrabalhaEm(cpf, id) values ('222.222.222-22', 03);
insert into TrabalhaEm(cpf, id) values ('333.333.333-33', 04);
insert into TrabalhaEm(cpf, id) values ('444.444.444-44', 04);
insert into TrabalhaEm(cpf, id) values ('555.555.555-55', 05);


insert into pagamento(valor, formaPagamento, matricula) values (120.0, 'Dinheiro', '18.1.5908');
insert into pagamento(valor, formaPagamento, matricula) values (60.0, 'Dinheiro', '18.1.8042');
insert into pagamento(valor, formaPagamento, matricula) values (120.0, 'Dinheiro', '18.1.8001');
insert into pagamento(valor, formaPagamento, matricula) values (140.0, 'Dinheiro', '18.1.6908');
insert into pagamento(valor, formaPagamento, matricula) values (60.0, 'Dinheiro', '19.1.6909');
insert into pagamento(valor, formaPagamento, matricula) values (140.0, 'Cartão Debito', '19.1.2783');
insert into pagamento(valor, formaPagamento, matricula) values (140.0, 'Cartão Crédito', '19.1.1234');
insert into pagamento(valor, formaPagamento, matricula) values (60.0, 'Debito', '19.1.4321');


insert into avalicaofisica(matricula, cpf, altura, objetivoAluno,totalGordura, peso, dobraTricipical, dobraSubescapular, dobraAxiliarMedia, dobraAbdominal, dobraCoxa, dobraPeitoral, dobraSupraIliaca, circunferenciaTorax, circunferenciaQuadril, circunferenciaCintura, circunferenciaAbdomen, circunferenciaCoxaDir, circunferenciaCoxaEsq, circunferenciaBracoDir, circunferenciaBracoEsq)
values  ('18.1.8001', '000.000.000-00', 1.75, 'Emagrecer', 25.0, 88.5, 2, 5, 8, 11, 8, 9, 8, 50, 35, 55, 50, 24, 23.5, 14, 14);
insert into avalicaofisica(matricula, cpf, altura, objetivoAluno,totalGordura, peso, dobraTricipical, dobraSubescapular, dobraAxiliarMedia, dobraAbdominal, dobraCoxa, dobraPeitoral, dobraSupraIliaca, circunferenciaTorax, circunferenciaQuadril, circunferenciaCintura, circunferenciaAbdomen, circunferenciaCoxaDir, circunferenciaCoxaEsq, circunferenciaBracoDir, circunferenciaBracoEsq)
values  ('18.1.8042', '000.000.000-00', 1.63, 'Ganho de massa muscular', 20.0, 78.5, 4, 6, 6, 8, 5, 5, 3, 45, 35, 35, 37, 20, 20, 12, 12);
insert into avalicaofisica(matricula, cpf, altura, objetivoAluno,totalGordura, peso, dobraTricipical, dobraSubescapular, dobraAxiliarMedia, dobraAbdominal, dobraCoxa, dobraPeitoral, dobraSupraIliaca, circunferenciaTorax, circunferenciaQuadril, circunferenciaCintura, circunferenciaAbdomen, circunferenciaCoxaDir, circunferenciaCoxaEsq, circunferenciaBracoDir, circunferenciaBracoEsq)
values  ('18.1.5908', '000.000.000-00', 1.60, 'Definição', 20.0, 63.5, 2, 2, 3, 4, 2, 5, 3, 25, 30, 33, 30, 25, 25, 13, 13);
insert into avalicaofisica(matricula, cpf, altura, objetivoAluno,totalGordura, peso, dobraTricipical, dobraSubescapular, dobraAxiliarMedia, dobraAbdominal, dobraCoxa, dobraPeitoral, dobraSupraIliaca, circunferenciaTorax, circunferenciaQuadril, circunferenciaCintura, circunferenciaAbdomen, circunferenciaCoxaDir, circunferenciaCoxaEsq, circunferenciaBracoDir, circunferenciaBracoEsq)
values  ('18.1.6908', '000.000.000-00', 1.80, 'Definição e ganho de massa magra', 23.0, 83.0, 4, 2, 5, 1, 2, 7, 3, 49, 38.5, 40.8, 42, 21, 22, 25.7, 25.5);
insert into avalicaofisica(matricula, cpf, altura, objetivoAluno,totalGordura, peso, dobraTricipical, dobraSubescapular, dobraAxiliarMedia, dobraAbdominal, dobraCoxa, dobraPeitoral, dobraSupraIliaca, circunferenciaTorax, circunferenciaQuadril, circunferenciaCintura, circunferenciaAbdomen, circunferenciaCoxaDir, circunferenciaCoxaEsq, circunferenciaBracoDir, circunferenciaBracoEsq)
values  ('19.1.6909', '000.000.000-00', 1.75, 'Ganho de massa magra', 25.0, 65.0, 4, 2, 5, 1, 2, 7, 3, 35, 28.5, 30.4, 33, 15, 15, 17, 17.5);
insert into avalicaofisica(matricula, cpf, altura, objetivoAluno,totalGordura, peso, dobraTricipical, dobraSubescapular, dobraAxiliarMedia, dobraAbdominal, dobraCoxa, dobraPeitoral, dobraSupraIliaca, circunferenciaTorax, circunferenciaQuadril, circunferenciaCintura, circunferenciaAbdomen, circunferenciaCoxaDir, circunferenciaCoxaEsq, circunferenciaBracoDir, circunferenciaBracoEsq)
values  ('19.1.2783', '000.000.000-00', 1.88, 'Definição', 20.0, 88.7, 4, 2, 5, 1, 2, 7, 3, 49, 38.5, 40.8, 42, 21, 22, 25.7, 25.5);
insert into avalicaofisica(matricula, cpf, altura, objetivoAluno,totalGordura, peso, dobraTricipical, dobraSubescapular, dobraAxiliarMedia, dobraAbdominal, dobraCoxa, dobraPeitoral, dobraSupraIliaca, circunferenciaTorax, circunferenciaQuadril, circunferenciaCintura, circunferenciaAbdomen, circunferenciaCoxaDir, circunferenciaCoxaEsq, circunferenciaBracoDir, circunferenciaBracoEsq)
values  ('19.1.1234', '000.000.000-00', 1.77, 'Ganho de massa magra', 23.0, 83, 2, 5, 3, 6, 3, 4, 8, 39, 32.5, 38.8, 39.9, 23.7, 23, 18.7, 18.3);
insert into avalicaofisica(matricula, cpf, altura, objetivoAluno,totalGordura, peso, dobraTricipical, dobraSubescapular, dobraAxiliarMedia, dobraAbdominal, dobraCoxa, dobraPeitoral, dobraSupraIliaca, circunferenciaTorax, circunferenciaQuadril, circunferenciaCintura, circunferenciaAbdomen, circunferenciaCoxaDir, circunferenciaCoxaEsq, circunferenciaBracoDir, circunferenciaBracoEsq)
values  ('19.1.4321', '000.000.000-00', 1.72, 'Ganho de massa magra', 22.0, 81, 2, 4, 3, 3, 4, 6, 1, 39, 32.5, 38.8, 39.9, 23.7, 23, 18.7, 18.3);


--Pesquisas utilizadas no software

--Seleciona todos os alunos
select  *
from    aluno;

--Deleta um aluno
delete
from    aluno
where   matricula = '18.1.5908';

--Seleciona a Ultima avaliação do Aluno
select  a.* from avalicaofisica a, aluno al
where   a.matricula = al.matricula and al.matricula = '18.1.5908' group by a.data, a.matricula, a.numAvaliacao
having  a.data = (select max(a1.data) from avalicaofisica a1, aluno al1
                    where a1.matricula = al1.matricula and al1.matricula = '18.1.5908');

--Seleciona uma avaliação por data
select *
from    AvalicaoFisica
where   data=current_date and matricula = '18.1.8001'; --Está como current_date só para teste

--Deleta avaliação física
DELETE
FROM    avalicaofisica
WHERE   matricula= '18.1.8001';

-- Retorna o nome e numero dos serviços de determinado pacote
select  s.nome, s.id
from    servicos s
where   s.id in(select c.id from contem c where c.nome = 'Brill');

--Deleta um contrato
DELETE
FROM    contrata
WHERE   matricula= '18.1.8001';

--Seleciona todos os funcionarios
SELECT *
FROM    funcionario;

--Deleta um funcionario
DELETE
FROM    Funcionario
WHERE   cpf='000.000.000-00';

--Retoana o pacote de determinado aluno, a forma de pagamento e quantos dias faltam para o pacote expirar
select  c.nomepacote, (c.dataFim - c.dataInicio) as tempo, pg.formaPagamento
from     pagamento pg, contrata c
where   c.matricula = pg.matricula and c.matricula = '18.1.8001';

--Retona os serviços de um pacote
SELECT  s.nome
FROM    servicos s
where   s.id in (select c.id from contem c where c.nome = 'Monster');

--Seleciona o preço de um pacote
Select  p.preco
from    pacote p
where   p.nome = 'Monster';

-- Pesquisas para futuras atualizações do software


--Pesquisa de todos os alunos da academia
select c.pnome || ' ' || c.unome as nomeCompleto
from aluno c
order by c.pnome;

--Pesquisa quais pacotes os alunso estão matriculados
select p.nomepacote
from contrata p
where '18.1.8001' = p.matricula
order by p.nomepacote;


--Pesquisa ultimo data de pagamento de um aluno, a partir de matricula
select  p.data
from    pagamento p
where   p.matricula = '18.1.5908';

--Pesquisa ultimo pagamento de um aluno por nome do aluno
select  p.data
from    pagamento p, aluno a
where   p.matricula = a.matricula and a.pnome = 'Daniel';

--Pesquisa numero de aluno matriculados por pacote
select  c.nomepacote, count(c.matricula)
from    Contrata c
group by    c.nomepacote;

--Pesquisa data de contratação de uma pessoa por matricula
select  a.pnome, a.unome, c.dataInicio
from    contrata c, aluno a
where   c.matricula = a.matricula and a.matricula = '18.1.8001';

--Pesquisa data de contratação de uma pessoa por nome
select  a.pnome, a.unome, c.dataInicio
from    contrata c, aluno a
where   c.matricula = a.matricula and a.pnome = 'Paula';

--pesquisar alunos inadimplentes
select  a.pnome||' '|| a.unome as nome, a.matricula
from    aluno a, pagamento p
where   (current_date - p.data) > 30 and a.matricula = p.matricula;

--Pesquisar professores de determinados servico
select  f.pnome ||' '||f.unome, s.nome
from    funcionario f, trabalhaem t, servicos s
where   f.cpf = t.cpf and s.id = t.id;

--Pesquisa funcionarios de um determinado servico
select  f.pnome ||' '||f.unome
from    funcionario f, trabalhaem t, servicos s
where   f.cpf = t.cpf and t.id = s.id and s.nome = 'musculação';

--pesquisa objetivo do aluno por matricula
select  a.objetivoAluno
from    avalicaofisica a
where   a.matricula = '18.1.8001';

--pesquisa retorna todas as avaliações de um aluno
select  *
from    avalicaofisica
where   matricula = '18.1.8001';

-- porcentagem de gordura por numero de matricula
select  (a.dobraAbdominal + a.dobraAxiliarMedia + a.dobraCoxa + a.dobraPeitoral + a.dobraSubescapular + a.dobraSupraIliaca + a.dobraTricipical) / 7 as mediaGordura
from    avalicaofisica a
where   a.matricula = '18.1.8001' and (select max(a1.data)
                                        from avalicaofisica a1
                                        where a.matricula = '18.1.8001') = a.data;

--Pesquisa Aluno com tempo de validade do pacote
select a.pnome||' '||a.unome as nome, a.matricula, (c.dataFim - c.dataInicio) as tempo
from aluno a, Contrata c
where a.matricula = c.matricula and a.matricula = '18.1.8001';

--Comandos para apagar o BD por completo
drop database Academia;
drop table aluno CASCADE;
drop table Funcionario CASCADE;
drop table TrabalhaEm CASCADE;
drop table AvalicaoFisica CASCADE;
drop table pagamento CASCADE;
drop table pacote CASCADE;
drop table contrata CASCADE;
drop table servicos CASCADE;
drop table contem CASCADE;

