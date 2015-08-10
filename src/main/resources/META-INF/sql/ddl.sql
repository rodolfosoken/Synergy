SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema sistema_gestao
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `sistema_gestao` ;
CREATE SCHEMA IF NOT EXISTS `sistema_gestao` DEFAULT CHARACTER SET utf8 ;
USE `sistema_gestao` ;

-- -----------------------------------------------------
-- Table `sistema_gestao`.`fornecedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sistema_gestao`.`fornecedor` (
  `cnpj` VARCHAR(18) NOT NULL,
  `nome` VARCHAR(255) NULL,
  `contato` VARCHAR(255) NULL,
  `cargo` VARCHAR(255) NULL,
  `email` VARCHAR(255) NULL,
  `link_sharepoint` VARCHAR(255) NULL,
  `obs` VARCHAR(255) NULL,
  `celular` VARCHAR(45) NULL,
  `telefone` VARCHAR(45) NULL,
  `site` VARCHAR(255) NULL,
  `idfornecedor` BIGINT NOT NULL AUTO_INCREMENT,
  `logradouro` VARCHAR(255) NULL,
  `numero` VARCHAR(45) NULL,
  `complemento` VARCHAR(255) NULL,
  `bairro` VARCHAR(255) NULL,
  `cep` VARCHAR(10) NULL,
  `estado` VARCHAR(45) NULL,
  `TIPO_FORNECEDOR` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idfornecedor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sistema_gestao`.`cotacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sistema_gestao`.`cotacao` (
  `idcotacao` BIGINT NOT NULL AUTO_INCREMENT,
  `responsavel` VARCHAR(255) NULL,
  `data_inicio` DATE NULL,
  `data_termino` DATE NULL,
  `descricao` VARCHAR(45) NOT NULL,
  `concluida` TINYINT(1) NULL,
  PRIMARY KEY (`idcotacao`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sistema_gestao`.`Conta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sistema_gestao`.`Conta` (
  `idConta` BIGINT NOT NULL,
  `numero_conta` VARCHAR(45) NULL,
  PRIMARY KEY (`idConta`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sistema_gestao`.`pep`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sistema_gestao`.`pep` (
  `idpep` BIGINT NOT NULL,
  `Conta_idConta` BIGINT NOT NULL,
  `valor` DOUBLE NULL,
  `numero` VARCHAR(45) NULL,
  PRIMARY KEY (`idpep`, `Conta_idConta`),
  INDEX `fk_pep_Conta1_idx` (`Conta_idConta` ASC),
  CONSTRAINT `fk_pep_Conta1`
    FOREIGN KEY (`Conta_idConta`)
    REFERENCES `sistema_gestao`.`Conta` (`idConta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sistema_gestao`.`compra_ferramenta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sistema_gestao`.`compra_ferramenta` (
  `idfornecimento_ferramenta` BIGINT NOT NULL AUTO_INCREMENT,
  `ok_prazo` TINYINT(1) NULL,
  `ok_espec` TINYINT(1) NULL,
  `ok_visita` TINYINT(1) NULL,
  `ok_assist` TINYINT(1) NULL,
  `data_aquisicao` DATE NULL,
  `preco` DOUBLE NULL,
  `pep_idpep` BIGINT NOT NULL,
  `pep_Conta_idConta` BIGINT NOT NULL,
  `ferramenta_idferramenta` BIGINT NOT NULL,
  PRIMARY KEY (`idfornecimento_ferramenta`),
  INDEX `fk_fornecimento_ferramenta_pep1_idx` (`pep_idpep` ASC, `pep_Conta_idConta` ASC),
  INDEX `fk_compra_ferramenta_ferramenta1_idx` (`ferramenta_idferramenta` ASC),
  CONSTRAINT `fk_fornecimento_ferramenta_pep1`
    FOREIGN KEY (`pep_idpep` , `pep_Conta_idConta`)
    REFERENCES `sistema_gestao`.`pep` (`idpep` , `Conta_idConta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_compra_ferramenta_ferramenta1`
    FOREIGN KEY (`ferramenta_idferramenta`)
    REFERENCES `sistema_gestao`.`ferramenta` (`idferramenta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sistema_gestao`.`cotacao_ferramenta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sistema_gestao`.`cotacao_ferramenta` (
  `cotacao_idcotacao` BIGINT NOT NULL AUTO_INCREMENT,
  `compra_ferramenta_idfornecimento_ferramenta` BIGINT NULL,
  PRIMARY KEY (`cotacao_idcotacao`),
  INDEX `fk_cotacao_ferramenta_compra_ferramenta1_idx` (`compra_ferramenta_idfornecimento_ferramenta` ASC),
  CONSTRAINT `fk_cotacao_ferramenta_cotacao1`
    FOREIGN KEY (`cotacao_idcotacao`)
    REFERENCES `sistema_gestao`.`cotacao` (`idcotacao`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cotacao_ferramenta_compra_ferramenta1`
    FOREIGN KEY (`compra_ferramenta_idfornecimento_ferramenta`)
    REFERENCES `sistema_gestao`.`compra_ferramenta` (`idfornecimento_ferramenta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sistema_gestao`.`participante_ferramenta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sistema_gestao`.`participante_ferramenta` (
  `idparticipante_ferramenta` BIGINT NOT NULL AUTO_INCREMENT,
  `fornecedor_idfornecedor` BIGINT NOT NULL,
  `cotacao_ferramenta_cotacao_idcotacao` BIGINT NOT NULL,
  PRIMARY KEY (`idparticipante_ferramenta`),
  INDEX `fk_participante_ferramenta_fornecedor1_idx` (`fornecedor_idfornecedor` ASC),
  INDEX `fk_participante_ferramenta_cotacao_ferramenta1_idx` (`cotacao_ferramenta_cotacao_idcotacao` ASC),
  CONSTRAINT `fk_participante_ferramenta_fornecedor1`
    FOREIGN KEY (`fornecedor_idfornecedor`)
    REFERENCES `sistema_gestao`.`fornecedor` (`idfornecedor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_participante_ferramenta_cotacao_ferramenta1`
    FOREIGN KEY (`cotacao_ferramenta_cotacao_idcotacao`)
    REFERENCES `sistema_gestao`.`cotacao_ferramenta` (`cotacao_idcotacao`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sistema_gestao`.`ferramenta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sistema_gestao`.`ferramenta` (
  `idferramenta` BIGINT NOT NULL AUTO_INCREMENT,
  `idparticipante_ferramenta` BIGINT NOT NULL,
  `id_equipament` VARCHAR(255) NOT NULL,
  `nome` VARCHAR(255) NULL,
  `length` DOUBLE NULL,
  `height` DOUBLE NULL,
  `width` DOUBLE NULL,
  `part_per_hour` DOUBLE NULL,
  `utilidade` VARCHAR(255) NULL,
  `cycle` INT NULL,
  `area_stack` DOUBLE NULL,
  `area` DOUBLE NULL,
  `max_stack` INT NULL,
  `descricao` VARCHAR(255) NULL,
  `disponibilidade` TINYINT(1) NULL,
  `valor` DOUBLE NULL,
  PRIMARY KEY (`idferramenta`),
  INDEX `fk_ferramenta_participante_ferramenta1_idx` (`idparticipante_ferramenta` ASC),
  CONSTRAINT `fk_ferramenta_participante_ferramenta1`
    FOREIGN KEY (`idparticipante_ferramenta`)
    REFERENCES `sistema_gestao`.`participante_ferramenta` (`idparticipante_ferramenta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = '		';


-- -----------------------------------------------------
-- Table `sistema_gestao`.`compra_material`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sistema_gestao`.`compra_material` (
  `idfornecimento_material` INT NOT NULL AUTO_INCREMENT,
  `ok_prazo` TINYINT(1) NULL,
  `ok_espec` TINYINT(1) NULL,
  `ok_visita` TINYINT(1) NULL,
  `ok_assist` TINYINT(1) NULL,
  `data_aquisicao` DATE NULL,
  `preco` DOUBLE NULL,
  `pep_idpep` BIGINT NOT NULL,
  `pep_Conta_idConta` BIGINT NOT NULL,
  `material_idmaterial` BIGINT NOT NULL,
  PRIMARY KEY (`idfornecimento_material`),
  INDEX `fk_fornecimento_material_pep1_idx` (`pep_idpep` ASC, `pep_Conta_idConta` ASC),
  INDEX `fk_compra_material_material1_idx` (`material_idmaterial` ASC),
  CONSTRAINT `fk_fornecimento_material_pep1`
    FOREIGN KEY (`pep_idpep` , `pep_Conta_idConta`)
    REFERENCES `sistema_gestao`.`pep` (`idpep` , `Conta_idConta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_compra_material_material1`
    FOREIGN KEY (`material_idmaterial`)
    REFERENCES `sistema_gestao`.`material` (`idmaterial`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sistema_gestao`.`cotacao_material`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sistema_gestao`.`cotacao_material` (
  `cotacao_idcotacao` BIGINT NOT NULL AUTO_INCREMENT,
  `compra_material_idfornecimento_material` INT NULL,
  PRIMARY KEY (`cotacao_idcotacao`),
  INDEX `fk_cotacao_material_compra_material1_idx` (`compra_material_idfornecimento_material` ASC),
  CONSTRAINT `fk_cotacao_material_cotacao1`
    FOREIGN KEY (`cotacao_idcotacao`)
    REFERENCES `sistema_gestao`.`cotacao` (`idcotacao`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cotacao_material_compra_material1`
    FOREIGN KEY (`compra_material_idfornecimento_material`)
    REFERENCES `sistema_gestao`.`compra_material` (`idfornecimento_material`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sistema_gestao`.`participante_material`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sistema_gestao`.`participante_material` (
  `idparticipante` BIGINT NOT NULL AUTO_INCREMENT,
  `fornecedor_idfornecedor` BIGINT NOT NULL,
  `cotacao_material_cotacao_idcotacao` BIGINT NOT NULL,
  PRIMARY KEY (`idparticipante`),
  INDEX `fk_participacao_fornecedor1_idx` (`fornecedor_idfornecedor` ASC),
  INDEX `fk_participante_material_cotacao_material1_idx` (`cotacao_material_cotacao_idcotacao` ASC),
  CONSTRAINT `fk_participacao_fornecedor1`
    FOREIGN KEY (`fornecedor_idfornecedor`)
    REFERENCES `sistema_gestao`.`fornecedor` (`idfornecedor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_participante_material_cotacao_material1`
    FOREIGN KEY (`cotacao_material_cotacao_idcotacao`)
    REFERENCES `sistema_gestao`.`cotacao_material` (`cotacao_idcotacao`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sistema_gestao`.`material`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sistema_gestao`.`material` (
  `idmaterial` BIGINT NOT NULL AUTO_INCREMENT,
  `participante_material_idparticipante` BIGINT NOT NULL,
  `material_espc` VARCHAR(255) NOT NULL,
  `material` VARCHAR(255) NULL,
  `descricao` VARCHAR(255) NULL,
  `disponibilidade` TINYINT(1) NULL,
  `valor` DOUBLE NULL,
  PRIMARY KEY (`idmaterial`),
  INDEX `fk_material_participante_material1_idx` (`participante_material_idparticipante` ASC),
  CONSTRAINT `fk_material_participante_material1`
    FOREIGN KEY (`participante_material_idparticipante`)
    REFERENCES `sistema_gestao`.`participante_material` (`idparticipante`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sistema_gestao`.`cotacao_peca`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sistema_gestao`.`cotacao_peca` (
  `cotacao_idcotacao` BIGINT NOT NULL AUTO_INCREMENT,
  `compra_peca_idfornecimento_peca` BIGINT NULL,
  PRIMARY KEY (`cotacao_idcotacao`),
  INDEX `fk_cotacao_peca_compra_peca1_idx` (`compra_peca_idfornecimento_peca` ASC),
  CONSTRAINT `fk_cotacao_peca_cotacao1`
    FOREIGN KEY (`cotacao_idcotacao`)
    REFERENCES `sistema_gestao`.`cotacao` (`idcotacao`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cotacao_peca_compra_peca1`
    FOREIGN KEY (`compra_peca_idfornecimento_peca`)
    REFERENCES `sistema_gestao`.`compra_peca` (`idfornecimento_peca`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sistema_gestao`.`participante_peca`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sistema_gestao`.`participante_peca` (
  `idparticipante_peca` BIGINT NOT NULL AUTO_INCREMENT,
  `fornecedor_idfornecedor` BIGINT NOT NULL,
  `cotacao_peca_cotacao_idcotacao` BIGINT NOT NULL,
  PRIMARY KEY (`idparticipante_peca`),
  INDEX `fk_participante_peca_fornecedor1_idx` (`fornecedor_idfornecedor` ASC),
  INDEX `fk_participante_peca_cotacao_peca1_idx` (`cotacao_peca_cotacao_idcotacao` ASC),
  CONSTRAINT `fk_participante_peca_fornecedor1`
    FOREIGN KEY (`fornecedor_idfornecedor`)
    REFERENCES `sistema_gestao`.`fornecedor` (`idfornecedor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_participante_peca_cotacao_peca1`
    FOREIGN KEY (`cotacao_peca_cotacao_idcotacao`)
    REFERENCES `sistema_gestao`.`cotacao_peca` (`cotacao_idcotacao`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sistema_gestao`.`peca`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sistema_gestao`.`peca` (
  `idpeca` BIGINT NOT NULL AUTO_INCREMENT,
  `material_idmaterial` BIGINT NOT NULL,
  `participante_peca_idparticipante_peca` BIGINT NULL,
  `pn` VARCHAR(255) NULL,
  `part_name` VARCHAR(255) NULL,
  `descricao` VARCHAR(255) NULL,
  `upc_fna` VARCHAR(255) NULL,
  `disponibilidade` TINYINT(1) NULL,
  `valor` DOUBLE NULL,
  PRIMARY KEY (`idpeca`),
  INDEX `fk_peca_material1_idx` (`material_idmaterial` ASC),
  INDEX `fk_peca_participante_peca1_idx` (`participante_peca_idparticipante_peca` ASC),
  CONSTRAINT `fk_peca_material1`
    FOREIGN KEY (`material_idmaterial`)
    REFERENCES `sistema_gestao`.`material` (`idmaterial`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_peca_participante_peca1`
    FOREIGN KEY (`participante_peca_idparticipante_peca`)
    REFERENCES `sistema_gestao`.`participante_peca` (`idparticipante_peca`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sistema_gestao`.`compra_peca`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sistema_gestao`.`compra_peca` (
  `idfornecimento_peca` BIGINT NOT NULL AUTO_INCREMENT,
  `ok_prazo` TINYINT(1) NULL,
  `ok_espec` TINYINT(1) NULL,
  `ok_visita` TINYINT(1) NULL,
  `ok_assist` TINYINT(1) NULL,
  `data_aquisicao` DATE NULL,
  `preco` DOUBLE NULL,
  `pep_idpep` BIGINT NOT NULL,
  `pep_Conta_idConta` BIGINT NOT NULL,
  `peca_idpeca` BIGINT NOT NULL,
  PRIMARY KEY (`idfornecimento_peca`),
  INDEX `fk_fornecimento_peca_pep1_idx` (`pep_idpep` ASC, `pep_Conta_idConta` ASC),
  INDEX `fk_compra_peca_peca1_idx` (`peca_idpeca` ASC),
  CONSTRAINT `fk_fornecimento_peca_pep1`
    FOREIGN KEY (`pep_idpep` , `pep_Conta_idConta`)
    REFERENCES `sistema_gestao`.`pep` (`idpep` , `Conta_idConta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_compra_peca_peca1`
    FOREIGN KEY (`peca_idpeca`)
    REFERENCES `sistema_gestao`.`peca` (`idpeca`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sistema_gestao`.`conjunto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sistema_gestao`.`conjunto` (
  `pn` VARCHAR(255) NOT NULL,
  `descricao` VARCHAR(255) NULL,
  `upc_fna` VARCHAR(255) NULL,
  `fna_descricao` VARCHAR(255) NULL,
  `idconjunto` BIGINT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idconjunto`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sistema_gestao`.`montagem`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sistema_gestao`.`montagem` (
  `idmontagem` BIGINT NOT NULL AUTO_INCREMENT,
  `peca_idpeca` BIGINT NOT NULL,
  `ferramenta_idferramenta` BIGINT NOT NULL,
  `conjunto_idconjunto` BIGINT NOT NULL,
  PRIMARY KEY (`idmontagem`),
  INDEX `fk_montagem_peca1_idx` (`peca_idpeca` ASC),
  INDEX `fk_montagem_ferramenta1_idx` (`ferramenta_idferramenta` ASC),
  INDEX `fk_montagem_conjunto1_idx` (`conjunto_idconjunto` ASC),
  CONSTRAINT `fk_montagem_peca1`
    FOREIGN KEY (`peca_idpeca`)
    REFERENCES `sistema_gestao`.`peca` (`idpeca`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_montagem_ferramenta1`
    FOREIGN KEY (`ferramenta_idferramenta`)
    REFERENCES `sistema_gestao`.`ferramenta` (`idferramenta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_montagem_conjunto1`
    FOREIGN KEY (`conjunto_idconjunto`)
    REFERENCES `sistema_gestao`.`conjunto` (`idconjunto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sistema_gestao`.`projeto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sistema_gestao`.`projeto` (
  `idprojeto` BIGINT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(255) NULL,
  PRIMARY KEY (`idprojeto`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sistema_gestao`.`risk_assesment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sistema_gestao`.`risk_assesment` (
  `id_risk_assesment` BIGINT NOT NULL AUTO_INCREMENT,
  `risk_assesmentcol` VARCHAR(255) NULL,
  `conjunto_idconjunto` BIGINT NOT NULL,
  PRIMARY KEY (`id_risk_assesment`),
  INDEX `fk_risk_assesment_conjunto1_idx` (`conjunto_idconjunto` ASC),
  CONSTRAINT `fk_risk_assesment_conjunto1`
    FOREIGN KEY (`conjunto_idconjunto`)
    REFERENCES `sistema_gestao`.`conjunto` (`idconjunto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sistema_gestao`.`pfmea`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sistema_gestao`.`pfmea` (
  `id_pfmea` INT NOT NULL AUTO_INCREMENT,
  `responsavel` VARCHAR(255) NULL,
  `link` VARCHAR(255) NULL,
  `risk_assesment_id_risk_assesment` BIGINT NOT NULL,
  PRIMARY KEY (`id_pfmea`),
  INDEX `fk_pfmea_risk_assesment1_idx` (`risk_assesment_id_risk_assesment` ASC),
  CONSTRAINT `fk_pfmea_risk_assesment1`
    FOREIGN KEY (`risk_assesment_id_risk_assesment`)
    REFERENCES `sistema_gestao`.`risk_assesment` (`id_risk_assesment`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sistema_gestao`.`projeto_has_conjunto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sistema_gestao`.`projeto_has_conjunto` (
  `projeto_idprojeto` BIGINT NOT NULL,
  `conjunto_idconjunto` BIGINT NOT NULL,
  PRIMARY KEY (`projeto_idprojeto`, `conjunto_idconjunto`),
  INDEX `fk_projeto_has_conjunto_conjunto1_idx` (`conjunto_idconjunto` ASC),
  INDEX `fk_projeto_has_conjunto_projeto1_idx` (`projeto_idprojeto` ASC),
  CONSTRAINT `fk_projeto_has_conjunto_projeto1`
    FOREIGN KEY (`projeto_idprojeto`)
    REFERENCES `sistema_gestao`.`projeto` (`idprojeto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_projeto_has_conjunto_conjunto1`
    FOREIGN KEY (`conjunto_idconjunto`)
    REFERENCES `sistema_gestao`.`conjunto` (`idconjunto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
