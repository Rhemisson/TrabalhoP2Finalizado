/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Hemis
 * Created: 16/06/2016
 */
--DROP TABLE USUARIOS
CREATE TABLE USUARIOS (
  ID INT NOT NULL GENERATED ALWAYS AS IDENTITY,
  LOGIN VARCHAR(50) NOT NULL UNIQUE,
  SENHA VARCHAR(50) NOT NULL,
  PRIMARY KEY  (ID));

CREATE TABLE INSTRUMENTOS (
  ID INT NOT NULL GENERATED ALWAYS AS IDENTITY,
  NOME VARCHAR(50) NOT NULL UNIQUE,
  DESCRICAO VARCHAR(50) NOT NULL,
  IMAGEM VARCHAR(50) NOT NULL,
  PRECO DOUBLE NOT NULL,
  PRIMARY KEY  (ID));

INSERT INTO USUARIOS VALUES(DEFAULT,'Administrador','123');

INSERT INTO INSTRUMENTOS 
VALUES(DEFAULT,'Guitarra ','Striberg - Uma ótima Guitar ','guitarra.png',59.99,9.0);
INSERT INTO INSTRUMENTOS 
VALUES(DEFAULT,'Contra Baixo','O melhor Contra-Baixo do Mercado','contra-baixo.png',91.99,10.0);
INSERT INTO INSTRUMENTOS 
VALUES(DEFAULT,'Bateria','A melhor Bateria do Mercado','Bateria.gif',159.99,9.0);
INSERT INTO INSTRUMENTOS 
VALUES(DEFAULT,'Violão','O melhor Vioão do Mercado','Violão.jpg',59.99,10.0);
INSERT INTO INSTRUMENTOS 
VALUES(DEFAULT,'Afinador de Instrumentos','Afinador para (guitarra,violao e baixo)','Afinador.gif',179.99,10.0);
