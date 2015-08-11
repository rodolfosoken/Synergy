CREATE DATABASE  IF NOT EXISTS `sistema_gestao` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `sistema_gestao`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: localhost    Database: sistema_gestao
-- ------------------------------------------------------
-- Server version	5.6.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `compra_ferramenta`
--

DROP TABLE IF EXISTS `compra_ferramenta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `compra_ferramenta` (
  `idfornecimento_ferramenta` bigint(20) NOT NULL AUTO_INCREMENT,
  `ok_prazo` tinyint(1) DEFAULT NULL,
  `ok_espec` tinyint(1) DEFAULT NULL,
  `ok_visita` tinyint(1) DEFAULT NULL,
  `ok_assist` tinyint(1) DEFAULT NULL,
  `data_aquisicao` date DEFAULT NULL,
  `preco` double DEFAULT NULL,
  `pep_idpep` bigint(20) NOT NULL,
  `pep_Conta_idConta` bigint(20) NOT NULL,
  `ferramenta_idferramenta` bigint(20) NOT NULL,
  PRIMARY KEY (`idfornecimento_ferramenta`),
  KEY `fk_fornecimento_ferramenta_pep1_idx` (`pep_idpep`,`pep_Conta_idConta`),
  KEY `fk_compra_ferramenta_ferramenta1_idx` (`ferramenta_idferramenta`),
  CONSTRAINT `fk_fornecimento_ferramenta_pep1` FOREIGN KEY (`pep_idpep`, `pep_Conta_idConta`) REFERENCES `pep` (`idpep`, `Conta_idConta`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_compra_ferramenta_ferramenta1` FOREIGN KEY (`ferramenta_idferramenta`) REFERENCES `ferramenta` (`idferramenta`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compra_ferramenta`
--

LOCK TABLES `compra_ferramenta` WRITE;
/*!40000 ALTER TABLE `compra_ferramenta` DISABLE KEYS */;
/*!40000 ALTER TABLE `compra_ferramenta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compra_material`
--

DROP TABLE IF EXISTS `compra_material`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `compra_material` (
  `idfornecimento_material` int(11) NOT NULL AUTO_INCREMENT,
  `ok_prazo` tinyint(1) DEFAULT NULL,
  `ok_espec` tinyint(1) DEFAULT NULL,
  `ok_visita` tinyint(1) DEFAULT NULL,
  `ok_assist` tinyint(1) DEFAULT NULL,
  `data_aquisicao` date DEFAULT NULL,
  `preco` double DEFAULT NULL,
  `pep_idpep` bigint(20) NOT NULL,
  `pep_Conta_idConta` bigint(20) NOT NULL,
  `material_idmaterial` bigint(20) NOT NULL,
  PRIMARY KEY (`idfornecimento_material`),
  KEY `fk_fornecimento_material_pep1_idx` (`pep_idpep`,`pep_Conta_idConta`),
  KEY `fk_compra_material_material1_idx` (`material_idmaterial`),
  CONSTRAINT `fk_fornecimento_material_pep1` FOREIGN KEY (`pep_idpep`, `pep_Conta_idConta`) REFERENCES `pep` (`idpep`, `Conta_idConta`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_compra_material_material1` FOREIGN KEY (`material_idmaterial`) REFERENCES `material` (`idmaterial`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compra_material`
--

LOCK TABLES `compra_material` WRITE;
/*!40000 ALTER TABLE `compra_material` DISABLE KEYS */;
/*!40000 ALTER TABLE `compra_material` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compra_peca`
--

DROP TABLE IF EXISTS `compra_peca`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `compra_peca` (
  `idfornecimento_peca` bigint(20) NOT NULL AUTO_INCREMENT,
  `ok_prazo` tinyint(1) DEFAULT NULL,
  `ok_espec` tinyint(1) DEFAULT NULL,
  `ok_visita` tinyint(1) DEFAULT NULL,
  `ok_assist` tinyint(1) DEFAULT NULL,
  `data_aquisicao` date DEFAULT NULL,
  `preco` double DEFAULT NULL,
  `pep_idpep` bigint(20) NOT NULL,
  `pep_Conta_idConta` bigint(20) NOT NULL,
  `peca_idpeca` bigint(20) NOT NULL,
  PRIMARY KEY (`idfornecimento_peca`),
  KEY `fk_fornecimento_peca_pep1_idx` (`pep_idpep`,`pep_Conta_idConta`),
  KEY `fk_compra_peca_peca1_idx` (`peca_idpeca`),
  CONSTRAINT `fk_fornecimento_peca_pep1` FOREIGN KEY (`pep_idpep`, `pep_Conta_idConta`) REFERENCES `pep` (`idpep`, `Conta_idConta`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_compra_peca_peca1` FOREIGN KEY (`peca_idpeca`) REFERENCES `peca` (`idpeca`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compra_peca`
--

LOCK TABLES `compra_peca` WRITE;
/*!40000 ALTER TABLE `compra_peca` DISABLE KEYS */;
/*!40000 ALTER TABLE `compra_peca` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `conjunto`
--

DROP TABLE IF EXISTS `conjunto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `conjunto` (
  `pn` varchar(255) NOT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `upc_fna` varchar(255) DEFAULT NULL,
  `fna_descricao` varchar(255) DEFAULT NULL,
  `idconjunto` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idconjunto`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `conjunto`
--

LOCK TABLES `conjunto` WRITE;
/*!40000 ALTER TABLE `conjunto` DISABLE KEYS */;
INSERT INTO `conjunto` VALUES ('CO123','Conjunto Locomotivo','UPC_CAR','1C4M',1);
/*!40000 ALTER TABLE `conjunto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `conta`
--

DROP TABLE IF EXISTS `conta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `conta` (
  `idConta` bigint(20) NOT NULL,
  `numero_conta` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idConta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `conta`
--

LOCK TABLES `conta` WRITE;
/*!40000 ALTER TABLE `conta` DISABLE KEYS */;
/*!40000 ALTER TABLE `conta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cotacao`
--

DROP TABLE IF EXISTS `cotacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cotacao` (
  `idcotacao` bigint(20) NOT NULL AUTO_INCREMENT,
  `responsavel` varchar(255) DEFAULT NULL,
  `data_inicio` date DEFAULT NULL,
  `data_termino` date DEFAULT NULL,
  `descricao` varchar(45) NOT NULL,
  `concluida` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`idcotacao`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cotacao`
--

LOCK TABLES `cotacao` WRITE;
/*!40000 ALTER TABLE `cotacao` DISABLE KEYS */;
INSERT INTO `cotacao` VALUES (1,'João','2015-08-09','2015-08-09','Borracha',NULL),(2,'Roberto','2015-08-10','2015-08-10','Ferro',NULL),(3,'Carla','2015-08-10','2015-08-10','Parafusadeira Pneumática ',NULL),(4,'Carla','2015-08-10','2015-08-19','Garra',NULL);
/*!40000 ALTER TABLE `cotacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cotacao_ferramenta`
--

DROP TABLE IF EXISTS `cotacao_ferramenta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cotacao_ferramenta` (
  `cotacao_idcotacao` bigint(20) NOT NULL AUTO_INCREMENT,
  `compra_ferramenta_idfornecimento_ferramenta` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`cotacao_idcotacao`),
  KEY `fk_cotacao_ferramenta_compra_ferramenta1_idx` (`compra_ferramenta_idfornecimento_ferramenta`),
  CONSTRAINT `fk_cotacao_ferramenta_cotacao1` FOREIGN KEY (`cotacao_idcotacao`) REFERENCES `cotacao` (`idcotacao`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_cotacao_ferramenta_compra_ferramenta1` FOREIGN KEY (`compra_ferramenta_idfornecimento_ferramenta`) REFERENCES `compra_ferramenta` (`idfornecimento_ferramenta`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cotacao_ferramenta`
--

LOCK TABLES `cotacao_ferramenta` WRITE;
/*!40000 ALTER TABLE `cotacao_ferramenta` DISABLE KEYS */;
INSERT INTO `cotacao_ferramenta` VALUES (3,NULL),(4,NULL);
/*!40000 ALTER TABLE `cotacao_ferramenta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cotacao_material`
--

DROP TABLE IF EXISTS `cotacao_material`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cotacao_material` (
  `cotacao_idcotacao` bigint(20) NOT NULL AUTO_INCREMENT,
  `compra_material_idfornecimento_material` int(11) DEFAULT NULL,
  PRIMARY KEY (`cotacao_idcotacao`),
  KEY `fk_cotacao_material_compra_material1_idx` (`compra_material_idfornecimento_material`),
  CONSTRAINT `fk_cotacao_material_cotacao1` FOREIGN KEY (`cotacao_idcotacao`) REFERENCES `cotacao` (`idcotacao`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_cotacao_material_compra_material1` FOREIGN KEY (`compra_material_idfornecimento_material`) REFERENCES `compra_material` (`idfornecimento_material`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cotacao_material`
--

LOCK TABLES `cotacao_material` WRITE;
/*!40000 ALTER TABLE `cotacao_material` DISABLE KEYS */;
INSERT INTO `cotacao_material` VALUES (1,NULL),(2,NULL);
/*!40000 ALTER TABLE `cotacao_material` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cotacao_peca`
--

DROP TABLE IF EXISTS `cotacao_peca`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cotacao_peca` (
  `cotacao_idcotacao` bigint(20) NOT NULL AUTO_INCREMENT,
  `compra_peca_idfornecimento_peca` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`cotacao_idcotacao`),
  KEY `fk_cotacao_peca_compra_peca1_idx` (`compra_peca_idfornecimento_peca`),
  CONSTRAINT `fk_cotacao_peca_cotacao1` FOREIGN KEY (`cotacao_idcotacao`) REFERENCES `cotacao` (`idcotacao`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_cotacao_peca_compra_peca1` FOREIGN KEY (`compra_peca_idfornecimento_peca`) REFERENCES `compra_peca` (`idfornecimento_peca`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cotacao_peca`
--

LOCK TABLES `cotacao_peca` WRITE;
/*!40000 ALTER TABLE `cotacao_peca` DISABLE KEYS */;
/*!40000 ALTER TABLE `cotacao_peca` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ferramenta`
--

DROP TABLE IF EXISTS `ferramenta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ferramenta` (
  `idferramenta` bigint(20) NOT NULL AUTO_INCREMENT,
  `idparticipante_ferramenta` bigint(20) NOT NULL,
  `id_equipament` varchar(255) NOT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `length` double DEFAULT NULL,
  `height` double DEFAULT NULL,
  `width` double DEFAULT NULL,
  `part_per_hour` double DEFAULT NULL,
  `utilidade` varchar(255) DEFAULT NULL,
  `cycle` int(11) DEFAULT NULL,
  `area_stack` double DEFAULT NULL,
  `area` double DEFAULT NULL,
  `max_stack` int(11) DEFAULT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `disponibilidade` tinyint(1) DEFAULT NULL,
  `valor` double DEFAULT NULL,
  PRIMARY KEY (`idferramenta`),
  KEY `fk_ferramenta_participante_ferramenta1_idx` (`idparticipante_ferramenta`),
  CONSTRAINT `fk_ferramenta_participante_ferramenta1` FOREIGN KEY (`idparticipante_ferramenta`) REFERENCES `participante_ferramenta` (`idparticipante_ferramenta`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='		';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ferramenta`
--

LOCK TABLES `ferramenta` WRITE;
/*!40000 ALTER TABLE `ferramenta` DISABLE KEYS */;
INSERT INTO `ferramenta` VALUES (1,1,'PAR_PNEU1','Parafusadeira Pneumática 677Nm Stanley',NULL,NULL,NULL,NULL,'Parafusar rodas',NULL,NULL,NULL,NULL,'Chave de impacto pneumática',NULL,NULL),(2,2,'p-78987','Garra',NULL,NULL,NULL,NULL,'Transportar grade do radiador',NULL,NULL,NULL,NULL,'Garra para transporte de peças',NULL,NULL),(3,2,'p-2845','Garra Plus',NULL,NULL,NULL,NULL,'Aproxima com exatidão a posição da peça',NULL,NULL,NULL,NULL,'Garra para transporte de peças com precisão aprimorada',NULL,NULL),(4,3,'p273','Garra AC',NULL,NULL,NULL,NULL,'',NULL,NULL,NULL,NULL,'Garra de suporte',NULL,NULL);
/*!40000 ALTER TABLE `ferramenta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fornecedor`
--

DROP TABLE IF EXISTS `fornecedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fornecedor` (
  `cnpj` varchar(18) NOT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `contato` varchar(255) DEFAULT NULL,
  `cargo` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `link_sharepoint` varchar(255) DEFAULT NULL,
  `obs` varchar(255) DEFAULT NULL,
  `celular` varchar(45) DEFAULT NULL,
  `telefone` varchar(45) DEFAULT NULL,
  `site` varchar(255) DEFAULT NULL,
  `idfornecedor` bigint(20) NOT NULL AUTO_INCREMENT,
  `logradouro` varchar(255) DEFAULT NULL,
  `numero` varchar(45) DEFAULT NULL,
  `complemento` varchar(255) DEFAULT NULL,
  `bairro` varchar(255) DEFAULT NULL,
  `cep` varchar(10) DEFAULT NULL,
  `estado` varchar(45) DEFAULT NULL,
  `TIPO_FORNECEDOR` varchar(45) NOT NULL,
  PRIMARY KEY (`idfornecedor`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fornecedor`
--

LOCK TABLES `fornecedor` WRITE;
/*!40000 ALTER TABLE `fornecedor` DISABLE KEYS */;
INSERT INTO `fornecedor` VALUES ('15.456.465/4656-45','AF Braco Automacao Ferramentas','Arthur','Gerente de Vendas','arthur@af.com.br','sharepoint/af','','(11) 95465-4564','(11) 4392-6456','www.afautomacao.com.br',1,'Av. dos Estados','1000','','Bangu','09726-430','SP','FERRAMENTA'),('21.234.564/6546-54','RRV Automações Ferramentas','Armando','Gerente','armando@gmail.com','sharepoint/rrv','','(12) 13213-2131','(12) 3113-3132','www.rrvautomacao.com.br',2,'Rua Flávio Fongaro','300','','','09726-430','SP','FERRAMENTA'),('13.241.564/6545-46','Defense Agency Ferramentas','Carnival','CEO','defense@agency.com','sharepoint/ag','','(45) 64564-6545','(12) 1212-3112','www.agency.com.br',3,'Av. Barão de Mauá','546','','Centro','09726-000','Sp','FERRAMENTA'),('54.654.564/0001-45','ACME Peças','Coiote',' Gerente de vendas','buddy@acme.com','sharepoint/acme','','(54) 56465-4654','(11) 1454-6545','www.acme.com',4,' Rua Triângulo Austral','25','','Jardim Indaiá','09726-430','SP','PECA'),('45.646.546/5465-46','Evil Corp Peças','Wesley','Gerente ','wesley@ecompany.com','sharepoint/wesley','','','(12) 3132-1231','www.wesley.com',5,'Gregório Tagle','301','BL 27 AP 21','','','','PECA'),('45.564.489/0001-46','General Products','Larry','CEO','larry@general.com','sharepoint/general','','(56) 46546-5465','(56) 4654-6545','www.geprod.com',6,'Serra da Bocaina','22','AP32','Três Montanhas','06278-110','SP','PECA'),('45.646.546/5456-45','Ace Chemicals Materiais','Paul Dini','Fundador','paul@ace.com','sharepoint/ace','','(99) 54564-6544','(11) 4654-5646','www.ace.com',7,'Major Walter Carlson','800','','Jardim São Jorge ','05555-210','SP','MATERIAL'),('56.465.465/4654-65','Wayne Enterprises Materiais Especiais','Batman','Vigilante','Wayne@wayne.com','sharepoint/wayne','','(89) 87987-9878','(11) 1546-5465','www.wayne.com',8,'Gotham City','1231','','--','21546-545','AM','MATERIAL'),('46.546.546/5465-46','ACME Ferramentas','Coiote','Gerente','coiote@acme.com','sharepoint/acme','','(54) 64654-6545','(46) 5465-4654','http://www.acmemarkets.com/',9,'Rua Ártico','154','','','','','FERRAMENTA'),('46.546.546/5465-46','ACME Materiais','Coiote','Gerente de vendas','coiote@acme.com','sharepoint/acme','','(54) 65465-4654','(12) 3132-1321','www.acme.com',10,'','','','','','','MATERIAL');
/*!40000 ALTER TABLE `fornecedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `material`
--

DROP TABLE IF EXISTS `material`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `material` (
  `idmaterial` bigint(20) NOT NULL AUTO_INCREMENT,
  `participante_material_idparticipante` bigint(20) NOT NULL,
  `material_espc` varchar(255) NOT NULL,
  `material` varchar(255) DEFAULT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `disponibilidade` tinyint(1) DEFAULT NULL,
  `valor` double DEFAULT NULL,
  PRIMARY KEY (`idmaterial`),
  KEY `fk_material_participante_material1_idx` (`participante_material_idparticipante`),
  CONSTRAINT `fk_material_participante_material1` FOREIGN KEY (`participante_material_idparticipante`) REFERENCES `participante_material` (`idparticipante`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `material`
--

LOCK TABLES `material` WRITE;
/*!40000 ALTER TABLE `material` DISABLE KEYS */;
INSERT INTO `material` VALUES (1,1,'Borracha Branca','borracha','borracha',NULL,456),(2,3,'Ferro Fundido','Ferro','Ferro com grande teor de carbono',NULL,120),(3,4,'Aço','Ferro','Ferro com baixo teor de carbono',NULL,450);
/*!40000 ALTER TABLE `material` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `montagem`
--

DROP TABLE IF EXISTS `montagem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `montagem` (
  `idmontagem` bigint(20) NOT NULL AUTO_INCREMENT,
  `peca_idpeca` bigint(20) NOT NULL,
  `ferramenta_idferramenta` bigint(20) NOT NULL,
  `conjunto_idconjunto` bigint(20) NOT NULL,
  PRIMARY KEY (`idmontagem`),
  KEY `fk_montagem_peca1_idx` (`peca_idpeca`),
  KEY `fk_montagem_ferramenta1_idx` (`ferramenta_idferramenta`),
  KEY `fk_montagem_conjunto1_idx` (`conjunto_idconjunto`),
  CONSTRAINT `fk_montagem_peca1` FOREIGN KEY (`peca_idpeca`) REFERENCES `peca` (`idpeca`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_montagem_ferramenta1` FOREIGN KEY (`ferramenta_idferramenta`) REFERENCES `ferramenta` (`idferramenta`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_montagem_conjunto1` FOREIGN KEY (`conjunto_idconjunto`) REFERENCES `conjunto` (`idconjunto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `montagem`
--

LOCK TABLES `montagem` WRITE;
/*!40000 ALTER TABLE `montagem` DISABLE KEYS */;
INSERT INTO `montagem` VALUES (1,1,2,1),(2,3,1,1);
/*!40000 ALTER TABLE `montagem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `participante_ferramenta`
--

DROP TABLE IF EXISTS `participante_ferramenta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `participante_ferramenta` (
  `idparticipante_ferramenta` bigint(20) NOT NULL AUTO_INCREMENT,
  `fornecedor_idfornecedor` bigint(20) NOT NULL,
  `cotacao_ferramenta_cotacao_idcotacao` bigint(20) NOT NULL,
  PRIMARY KEY (`idparticipante_ferramenta`),
  KEY `fk_participante_ferramenta_fornecedor1_idx` (`fornecedor_idfornecedor`),
  KEY `fk_participante_ferramenta_cotacao_ferramenta1_idx` (`cotacao_ferramenta_cotacao_idcotacao`),
  CONSTRAINT `fk_participante_ferramenta_fornecedor1` FOREIGN KEY (`fornecedor_idfornecedor`) REFERENCES `fornecedor` (`idfornecedor`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_participante_ferramenta_cotacao_ferramenta1` FOREIGN KEY (`cotacao_ferramenta_cotacao_idcotacao`) REFERENCES `cotacao_ferramenta` (`cotacao_idcotacao`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `participante_ferramenta`
--

LOCK TABLES `participante_ferramenta` WRITE;
/*!40000 ALTER TABLE `participante_ferramenta` DISABLE KEYS */;
INSERT INTO `participante_ferramenta` VALUES (1,1,3),(2,9,4),(3,3,4);
/*!40000 ALTER TABLE `participante_ferramenta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `participante_material`
--

DROP TABLE IF EXISTS `participante_material`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `participante_material` (
  `idparticipante` bigint(20) NOT NULL AUTO_INCREMENT,
  `fornecedor_idfornecedor` bigint(20) NOT NULL,
  `cotacao_material_cotacao_idcotacao` bigint(20) NOT NULL,
  PRIMARY KEY (`idparticipante`),
  KEY `fk_participacao_fornecedor1_idx` (`fornecedor_idfornecedor`),
  KEY `fk_participante_material_cotacao_material1_idx` (`cotacao_material_cotacao_idcotacao`),
  CONSTRAINT `fk_participacao_fornecedor1` FOREIGN KEY (`fornecedor_idfornecedor`) REFERENCES `fornecedor` (`idfornecedor`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_participante_material_cotacao_material1` FOREIGN KEY (`cotacao_material_cotacao_idcotacao`) REFERENCES `cotacao_material` (`cotacao_idcotacao`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `participante_material`
--

LOCK TABLES `participante_material` WRITE;
/*!40000 ALTER TABLE `participante_material` DISABLE KEYS */;
INSERT INTO `participante_material` VALUES (1,7,1),(2,8,1),(3,8,2),(4,10,2);
/*!40000 ALTER TABLE `participante_material` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `participante_peca`
--

DROP TABLE IF EXISTS `participante_peca`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `participante_peca` (
  `idparticipante_peca` bigint(20) NOT NULL AUTO_INCREMENT,
  `fornecedor_idfornecedor` bigint(20) NOT NULL,
  `cotacao_peca_cotacao_idcotacao` bigint(20) NOT NULL,
  PRIMARY KEY (`idparticipante_peca`),
  KEY `fk_participante_peca_fornecedor1_idx` (`fornecedor_idfornecedor`),
  KEY `fk_participante_peca_cotacao_peca1_idx` (`cotacao_peca_cotacao_idcotacao`),
  CONSTRAINT `fk_participante_peca_fornecedor1` FOREIGN KEY (`fornecedor_idfornecedor`) REFERENCES `fornecedor` (`idfornecedor`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_participante_peca_cotacao_peca1` FOREIGN KEY (`cotacao_peca_cotacao_idcotacao`) REFERENCES `cotacao_peca` (`cotacao_idcotacao`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `participante_peca`
--

LOCK TABLES `participante_peca` WRITE;
/*!40000 ALTER TABLE `participante_peca` DISABLE KEYS */;
/*!40000 ALTER TABLE `participante_peca` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `peca`
--

DROP TABLE IF EXISTS `peca`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `peca` (
  `idpeca` bigint(20) NOT NULL AUTO_INCREMENT,
  `material_idmaterial` bigint(20) NOT NULL,
  `participante_peca_idparticipante_peca` bigint(20) DEFAULT NULL,
  `pn` varchar(255) DEFAULT NULL,
  `part_name` varchar(255) DEFAULT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `upc_fna` varchar(255) DEFAULT NULL,
  `disponibilidade` tinyint(1) DEFAULT NULL,
  `valor` double DEFAULT NULL,
  PRIMARY KEY (`idpeca`),
  KEY `fk_peca_material1_idx` (`material_idmaterial`),
  KEY `fk_peca_participante_peca1_idx` (`participante_peca_idparticipante_peca`),
  CONSTRAINT `fk_peca_material1` FOREIGN KEY (`material_idmaterial`) REFERENCES `material` (`idmaterial`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_peca_participante_peca1` FOREIGN KEY (`participante_peca_idparticipante_peca`) REFERENCES `participante_peca` (`idparticipante_peca`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `peca`
--

LOCK TABLES `peca` WRITE;
/*!40000 ALTER TABLE `peca` DISABLE KEYS */;
INSERT INTO `peca` VALUES (1,1,NULL,'212_Pneu','pneu','usa borracha','1465',NULL,NULL),(2,2,NULL,'AP_124','Radiador','sistema de arrefecimento','12_UC2',NULL,NULL),(3,3,NULL,'ROD_123','TRD_Roda','roda traseira direita','ROTRD',NULL,NULL);
/*!40000 ALTER TABLE `peca` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pep`
--

DROP TABLE IF EXISTS `pep`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pep` (
  `idpep` bigint(20) NOT NULL,
  `Conta_idConta` bigint(20) NOT NULL,
  `valor` double DEFAULT NULL,
  `numero` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idpep`,`Conta_idConta`),
  KEY `fk_pep_Conta1_idx` (`Conta_idConta`),
  CONSTRAINT `fk_pep_Conta1` FOREIGN KEY (`Conta_idConta`) REFERENCES `conta` (`idConta`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pep`
--

LOCK TABLES `pep` WRITE;
/*!40000 ALTER TABLE `pep` DISABLE KEYS */;
/*!40000 ALTER TABLE `pep` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pfmea`
--

DROP TABLE IF EXISTS `pfmea`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pfmea` (
  `id_pfmea` int(11) NOT NULL AUTO_INCREMENT,
  `responsavel` varchar(255) DEFAULT NULL,
  `link` varchar(255) DEFAULT NULL,
  `risk_assesment_id_risk_assesment` bigint(20) NOT NULL,
  PRIMARY KEY (`id_pfmea`),
  KEY `fk_pfmea_risk_assesment1_idx` (`risk_assesment_id_risk_assesment`),
  CONSTRAINT `fk_pfmea_risk_assesment1` FOREIGN KEY (`risk_assesment_id_risk_assesment`) REFERENCES `risk_assesment` (`id_risk_assesment`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pfmea`
--

LOCK TABLES `pfmea` WRITE;
/*!40000 ALTER TABLE `pfmea` DISABLE KEYS */;
/*!40000 ALTER TABLE `pfmea` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `projeto`
--

DROP TABLE IF EXISTS `projeto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `projeto` (
  `idprojeto` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idprojeto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projeto`
--

LOCK TABLES `projeto` WRITE;
/*!40000 ALTER TABLE `projeto` DISABLE KEYS */;
/*!40000 ALTER TABLE `projeto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `projeto_has_conjunto`
--

DROP TABLE IF EXISTS `projeto_has_conjunto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `projeto_has_conjunto` (
  `projeto_idprojeto` bigint(20) NOT NULL,
  `conjunto_idconjunto` bigint(20) NOT NULL,
  PRIMARY KEY (`projeto_idprojeto`,`conjunto_idconjunto`),
  KEY `fk_projeto_has_conjunto_conjunto1_idx` (`conjunto_idconjunto`),
  KEY `fk_projeto_has_conjunto_projeto1_idx` (`projeto_idprojeto`),
  CONSTRAINT `fk_projeto_has_conjunto_projeto1` FOREIGN KEY (`projeto_idprojeto`) REFERENCES `projeto` (`idprojeto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_projeto_has_conjunto_conjunto1` FOREIGN KEY (`conjunto_idconjunto`) REFERENCES `conjunto` (`idconjunto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projeto_has_conjunto`
--

LOCK TABLES `projeto_has_conjunto` WRITE;
/*!40000 ALTER TABLE `projeto_has_conjunto` DISABLE KEYS */;
/*!40000 ALTER TABLE `projeto_has_conjunto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `risk_assesment`
--

DROP TABLE IF EXISTS `risk_assesment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `risk_assesment` (
  `id_risk_assesment` bigint(20) NOT NULL AUTO_INCREMENT,
  `risk_assesmentcol` varchar(255) DEFAULT NULL,
  `conjunto_idconjunto` bigint(20) NOT NULL,
  PRIMARY KEY (`id_risk_assesment`),
  KEY `fk_risk_assesment_conjunto1_idx` (`conjunto_idconjunto`),
  CONSTRAINT `fk_risk_assesment_conjunto1` FOREIGN KEY (`conjunto_idconjunto`) REFERENCES `conjunto` (`idconjunto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `risk_assesment`
--

LOCK TABLES `risk_assesment` WRITE;
/*!40000 ALTER TABLE `risk_assesment` DISABLE KEYS */;
/*!40000 ALTER TABLE `risk_assesment` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-08-10  0:48:05
