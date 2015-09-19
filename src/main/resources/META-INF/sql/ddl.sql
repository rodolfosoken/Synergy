-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema sistema_gestao
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `sistema_gestao` ;

-- -----------------------------------------------------
-- Schema sistema_gestao
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `sistema_gestao` DEFAULT CHARACTER SET utf8 ;
USE `sistema_gestao` ;

-- -----------------------------------------------------
-- Table `sistema_gestao`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sistema_gestao`.`usuario` (
  `idusuario` BIGINT NOT NULL AUTO_INCREMENT COMMENT '',
  `nome` VARCHAR(45) NULL COMMENT '',
  `sobrenome` VARCHAR(255) NULL COMMENT '',
  `email` VARCHAR(45) NULL COMMENT '',
  `senha` VARCHAR(45) NULL COMMENT '',
  `registro` INT NULL COMMENT '',
  `id` VARCHAR(255) NULL COMMENT '',
  PRIMARY KEY (`idusuario`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sistema_gestao`.`ferramenta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sistema_gestao`.`ferramenta` (
  `idferramenta` BIGINT NOT NULL AUTO_INCREMENT COMMENT '',
  `id_equipament` VARCHAR(255) NOT NULL COMMENT '',
  `nome` VARCHAR(255) NULL COMMENT '',
  `length` DOUBLE NULL COMMENT '',
  `height` DOUBLE NULL COMMENT '',
  `width` DOUBLE NULL COMMENT '',
  `part_per_hour` DOUBLE NULL COMMENT '',
  `utilidade` VARCHAR(255) NULL COMMENT '',
  `cycle` INT NULL COMMENT '',
  `area_stack` DOUBLE NULL COMMENT '',
  `area` DOUBLE NULL COMMENT '',
  `max_stack` INT NULL COMMENT '',
  `descricao` VARCHAR(255) NULL COMMENT '',
  `disponibilidade` TINYINT(1) NULL COMMENT '',
  `valor` DOUBLE NULL COMMENT '',
  `usuario_planejador` BIGINT NOT NULL COMMENT '',
  PRIMARY KEY (`idferramenta`)  COMMENT '',
  INDEX `fk_ferramenta_usuario1_idx` (`usuario_planejador` ASC)  COMMENT '',
  CONSTRAINT `fk_ferramenta_usuario1`
    FOREIGN KEY (`usuario_planejador`)
    REFERENCES `sistema_gestao`.`usuario` (`idusuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = '		';


-- -----------------------------------------------------
-- Table `sistema_gestao`.`cotacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sistema_gestao`.`cotacao` (
  `idcotacao` BIGINT NOT NULL AUTO_INCREMENT COMMENT '',
  `usuario_idusuario` BIGINT NOT NULL COMMENT '',
  `data_inicio` DATE NULL COMMENT '',
  `data_previsao` DATE NULL COMMENT '',
  `data_termino` DATE NULL COMMENT '',
  `descricao` VARCHAR(255) NULL COMMENT '',
  `concluida` TINYINT(1) NULL COMMENT '',
  `comprado` TINYINT(1) NULL COMMENT '',
  `usuario_responsavel` BIGINT NOT NULL COMMENT '',
  `sor` VARCHAR(255) NULL COMMENT '',
  `bdc` VARCHAR(255) NULL COMMENT '',
  PRIMARY KEY (`idcotacao`)  COMMENT '',
  INDEX `fk_cotacao_usuario1_idx` (`usuario_idusuario` ASC)  COMMENT '',
  INDEX `fk_cotacao_usuario2_idx` (`usuario_responsavel` ASC)  COMMENT '',
  CONSTRAINT `fk_cotacao_usuario1`
    FOREIGN KEY (`usuario_idusuario`)
    REFERENCES `sistema_gestao`.`usuario` (`idusuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cotacao_usuario2`
    FOREIGN KEY (`usuario_responsavel`)
    REFERENCES `sistema_gestao`.`usuario` (`idusuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sistema_gestao`.`Conta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sistema_gestao`.`Conta` (
  `idConta` BIGINT NOT NULL AUTO_INCREMENT COMMENT '',
  `numero_conta` VARCHAR(45) NULL COMMENT '',
  `descricao` VARCHAR(255) NULL COMMENT '',
  PRIMARY KEY (`idConta`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sistema_gestao`.`pep`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sistema_gestao`.`pep` (
  `idpep` BIGINT NOT NULL AUTO_INCREMENT COMMENT '',
  `valor` DOUBLE NULL COMMENT '',
  `numero` VARCHAR(45) NULL COMMENT '',
  `descricao` VARCHAR(255) NULL COMMENT '',
  `Conta_idConta` BIGINT NOT NULL COMMENT '',
  PRIMARY KEY (`idpep`)  COMMENT '',
  INDEX `fk_pep_Conta1_idx` (`Conta_idConta` ASC)  COMMENT '',
  CONSTRAINT `fk_pep_Conta1`
    FOREIGN KEY (`Conta_idConta`)
    REFERENCES `sistema_gestao`.`Conta` (`idConta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sistema_gestao`.`fornecedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sistema_gestao`.`fornecedor` (
  `cnpj` VARCHAR(18) NOT NULL COMMENT '',
  `nome` VARCHAR(255) NULL COMMENT '',
  `contato` VARCHAR(255) NULL COMMENT '',
  `cargo` VARCHAR(255) NULL COMMENT '',
  `email` VARCHAR(255) NULL COMMENT '',
  `link_sharepoint` VARCHAR(255) NULL COMMENT '',
  `obs` VARCHAR(255) NULL COMMENT '',
  `celular` VARCHAR(45) NULL COMMENT '',
  `telefone` VARCHAR(45) NULL COMMENT '',
  `site` VARCHAR(255) NULL COMMENT '',
  `idfornecedor` BIGINT NOT NULL AUTO_INCREMENT COMMENT '',
  `logradouro` VARCHAR(255) NULL COMMENT '',
  `numero` VARCHAR(45) NULL COMMENT '',
  `complemento` VARCHAR(255) NULL COMMENT '',
  `bairro` VARCHAR(255) NULL COMMENT '',
  `cep` VARCHAR(10) NULL COMMENT '',
  `estado` VARCHAR(45) NULL COMMENT '',
  `TIPO_FORNECEDOR` VARCHAR(45) NOT NULL COMMENT '',
  `nota` INT(11) NULL COMMENT '',
  PRIMARY KEY (`idfornecedor`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sistema_gestao`.`participante_ferramenta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sistema_gestao`.`participante_ferramenta` (
  `idparticipante_ferramenta` BIGINT NOT NULL AUTO_INCREMENT COMMENT '',
  `fornecedor_idfornecedor` BIGINT NOT NULL COMMENT '',
  `cotacao_ferramenta_cotacao_idcotacao` BIGINT NOT NULL COMMENT '',
  `valor` DOUBLE NULL COMMENT '',
  PRIMARY KEY (`idparticipante_ferramenta`)  COMMENT '',
  INDEX `fk_participante_ferramenta_fornecedor1_idx` (`fornecedor_idfornecedor` ASC)  COMMENT '',
  INDEX `fk_participante_ferramenta_cotacao_ferramenta1_idx` (`cotacao_ferramenta_cotacao_idcotacao` ASC)  COMMENT '',
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
-- Table `sistema_gestao`.`compra_ferramenta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sistema_gestao`.`compra_ferramenta` (
  `idcompra_ferramenta` BIGINT NOT NULL AUTO_INCREMENT COMMENT '',
  `ok_prazo` TINYINT(1) NULL COMMENT '',
  `ok_espec` TINYINT(1) NULL COMMENT '',
  `ok_visita` TINYINT(1) NULL COMMENT '',
  `ok_assist` TINYINT(1) NULL COMMENT '',
  `data_aquisicao` DATE NULL COMMENT '',
  `preco` DOUBLE NULL COMMENT '',
  `pep_idpep` BIGINT NOT NULL COMMENT '',
  `idparticipante` BIGINT NOT NULL COMMENT '',
  PRIMARY KEY (`idcompra_ferramenta`)  COMMENT '',
  INDEX `fk_fornecimento_ferramenta_pep1_idx` (`pep_idpep` ASC)  COMMENT '',
  INDEX `fk_compra_ferramenta_participante_ferramenta1_idx` (`idparticipante` ASC)  COMMENT '',
  CONSTRAINT `fk_fornecimento_ferramenta_pep1`
    FOREIGN KEY (`pep_idpep`)
    REFERENCES `sistema_gestao`.`pep` (`idpep`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_compra_ferramenta_participante_ferramenta1`
    FOREIGN KEY (`idparticipante`)
    REFERENCES `sistema_gestao`.`participante_ferramenta` (`idparticipante_ferramenta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sistema_gestao`.`cotacao_ferramenta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sistema_gestao`.`cotacao_ferramenta` (
  `cotacao_idcotacao` BIGINT NOT NULL AUTO_INCREMENT COMMENT '',
  `ferramenta_idferramenta` BIGINT NOT NULL COMMENT '',
  `SOR` VARCHAR(255) NULL COMMENT '',
  `compra_ferramenta_idcompra_ferramenta` BIGINT NULL COMMENT '',
  PRIMARY KEY (`cotacao_idcotacao`)  COMMENT '',
  INDEX `fk_cotacao_ferramenta_ferramenta1_idx` (`ferramenta_idferramenta` ASC)  COMMENT '',
  INDEX `fk_cotacao_ferramenta_compra_ferramenta1_idx` (`compra_ferramenta_idcompra_ferramenta` ASC)  COMMENT '',
  CONSTRAINT `fk_cotacao_ferramenta_cotacao1`
    FOREIGN KEY (`cotacao_idcotacao`)
    REFERENCES `sistema_gestao`.`cotacao` (`idcotacao`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cotacao_ferramenta_ferramenta1`
    FOREIGN KEY (`ferramenta_idferramenta`)
    REFERENCES `sistema_gestao`.`ferramenta` (`idferramenta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cotacao_ferramenta_compra_ferramenta1`
    FOREIGN KEY (`compra_ferramenta_idcompra_ferramenta`)
    REFERENCES `sistema_gestao`.`compra_ferramenta` (`idcompra_ferramenta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sistema_gestao`.`material`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sistema_gestao`.`material` (
  `idmaterial` BIGINT NOT NULL AUTO_INCREMENT COMMENT '',
  `material_espc` VARCHAR(255) NOT NULL COMMENT '',
  `material` VARCHAR(255) NULL COMMENT '',
  `descricao` VARCHAR(255) NULL COMMENT '',
  `disponibilidade` TINYINT(1) NULL COMMENT '',
  `valor` DOUBLE NULL COMMENT '',
  `kardex` VARCHAR(45) NULL COMMENT '',
  `qk` VARCHAR(45) NULL COMMENT '',
  `cor` VARCHAR(45) NULL COMMENT '',
  `textura` VARCHAR(45) NULL COMMENT '',
  `contracao` DOUBLE NULL COMMENT '',
  `matl_recup` DOUBLE NULL COMMENT '',
  `espessura` DOUBLE NULL COMMENT '',
  `erro_espessura` DOUBLE NULL COMMENT '',
  PRIMARY KEY (`idmaterial`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sistema_gestao`.`cotacao_material`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sistema_gestao`.`cotacao_material` (
  `cotacao_idcotacao` BIGINT NOT NULL AUTO_INCREMENT COMMENT '',
  `material_idmaterial` BIGINT NOT NULL COMMENT '',
  `compra_material_idcompra_material` BIGINT NULL COMMENT '',
  PRIMARY KEY (`cotacao_idcotacao`)  COMMENT '',
  INDEX `fk_cotacao_material_material1_idx` (`material_idmaterial` ASC)  COMMENT '',
  INDEX `fk_cotacao_material_compra_material1_idx` (`compra_material_idcompra_material` ASC)  COMMENT '',
  CONSTRAINT `fk_cotacao_material_cotacao1`
    FOREIGN KEY (`cotacao_idcotacao`)
    REFERENCES `sistema_gestao`.`cotacao` (`idcotacao`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cotacao_material_material1`
    FOREIGN KEY (`material_idmaterial`)
    REFERENCES `sistema_gestao`.`material` (`idmaterial`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cotacao_material_compra_material1`
    FOREIGN KEY (`compra_material_idcompra_material`)
    REFERENCES `sistema_gestao`.`compra_material` (`idcompra_material`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sistema_gestao`.`participante_material`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sistema_gestao`.`participante_material` (
  `idparticipante` BIGINT NOT NULL AUTO_INCREMENT COMMENT '',
  `fornecedor_idfornecedor` BIGINT NOT NULL COMMENT '',
  `cotacao_material_cotacao_idcotacao` BIGINT NOT NULL COMMENT '',
  `valor` DOUBLE NULL COMMENT '',
  PRIMARY KEY (`idparticipante`)  COMMENT '',
  INDEX `fk_participacao_fornecedor1_idx` (`fornecedor_idfornecedor` ASC)  COMMENT '',
  INDEX `fk_participante_material_cotacao_material1_idx` (`cotacao_material_cotacao_idcotacao` ASC)  COMMENT '',
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
-- Table `sistema_gestao`.`compra_material`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sistema_gestao`.`compra_material` (
  `idcompra_material` BIGINT NOT NULL AUTO_INCREMENT COMMENT '',
  `ok_prazo` TINYINT(1) NULL COMMENT '',
  `ok_espec` TINYINT(1) NULL COMMENT '',
  `ok_visita` TINYINT(1) NULL COMMENT '',
  `ok_assist` TINYINT(1) NULL COMMENT '',
  `data_aquisicao` DATE NULL COMMENT '',
  `preco` DOUBLE NULL COMMENT '',
  `pep_idpep` BIGINT NOT NULL COMMENT '',
  `idparticipante` BIGINT NOT NULL COMMENT '',
  PRIMARY KEY (`idcompra_material`)  COMMENT '',
  INDEX `fk_fornecimento_material_pep1_idx` (`pep_idpep` ASC)  COMMENT '',
  INDEX `fk_compra_material_participante_material1_idx` (`idparticipante` ASC)  COMMENT '',
  CONSTRAINT `fk_fornecimento_material_pep1`
    FOREIGN KEY (`pep_idpep`)
    REFERENCES `sistema_gestao`.`pep` (`idpep`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_compra_material_participante_material1`
    FOREIGN KEY (`idparticipante`)
    REFERENCES `sistema_gestao`.`participante_material` (`idparticipante`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sistema_gestao`.`conjunto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sistema_gestao`.`conjunto` (
  `idconjunto` BIGINT NOT NULL AUTO_INCREMENT COMMENT '',
  `pn` VARCHAR(255) NOT NULL COMMENT '',
  `descricao` VARCHAR(255) NULL COMMENT '',
  `upc_fna` VARCHAR(255) NULL COMMENT '',
  `fna_descricao` VARCHAR(255) NULL COMMENT '',
  PRIMARY KEY (`idconjunto`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sistema_gestao`.`montagem`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sistema_gestao`.`montagem` (
  `idmontagem` BIGINT NOT NULL AUTO_INCREMENT COMMENT '',
  `conjunto_idconjunto` BIGINT NOT NULL COMMENT '',
  PRIMARY KEY (`idmontagem`)  COMMENT '',
  INDEX `fk_montagem_conjunto1_idx` (`conjunto_idconjunto` ASC)  COMMENT '',
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
  `idprojeto` BIGINT NOT NULL AUTO_INCREMENT COMMENT '',
  `nome` VARCHAR(255) NULL COMMENT '',
  PRIMARY KEY (`idprojeto`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sistema_gestao`.`risk_assesment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sistema_gestao`.`risk_assesment` (
  `id_risk_assesment` BIGINT NOT NULL AUTO_INCREMENT COMMENT '',
  `risk_assesmentcol` VARCHAR(255) NULL COMMENT '',
  `conjunto_idconjunto` BIGINT NOT NULL COMMENT '',
  PRIMARY KEY (`id_risk_assesment`)  COMMENT '',
  INDEX `fk_risk_assesment_conjunto1_idx` (`conjunto_idconjunto` ASC)  COMMENT '',
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
  `id_pfmea` BIGINT NOT NULL AUTO_INCREMENT COMMENT '',
  `responsavel` VARCHAR(255) NULL COMMENT '',
  `link` VARCHAR(255) NULL COMMENT '',
  `risk_assesment_id_risk_assesment` BIGINT NOT NULL COMMENT '',
  PRIMARY KEY (`id_pfmea`)  COMMENT '',
  INDEX `fk_pfmea_risk_assesment1_idx` (`risk_assesment_id_risk_assesment` ASC)  COMMENT '',
  CONSTRAINT `fk_pfmea_risk_assesment1`
    FOREIGN KEY (`risk_assesment_id_risk_assesment`)
    REFERENCES `sistema_gestao`.`risk_assesment` (`id_risk_assesment`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sistema_gestao`.`peca`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sistema_gestao`.`peca` (
  `idpeca` BIGINT NOT NULL AUTO_INCREMENT COMMENT '',
  `fornecedor_idfornecedor` BIGINT NOT NULL COMMENT '',
  `material_idmaterial` BIGINT NOT NULL COMMENT '',
  `pn` VARCHAR(255) NULL COMMENT '',
  `part_name` VARCHAR(255) NULL COMMENT '',
  `descricao` VARCHAR(255) NULL COMMENT '',
  `upc` VARCHAR(255) NULL COMMENT '',
  `disponibilidade` TINYINT(1) NULL COMMENT '',
  `valor` DOUBLE NULL COMMENT '',
  `responsavel` VARCHAR(255) NULL COMMENT '',
  `fna` VARCHAR(255) NULL COMMENT '',
  PRIMARY KEY (`idpeca`)  COMMENT '',
  INDEX `fk_peca_material1_idx` (`material_idmaterial` ASC)  COMMENT '',
  INDEX `fk_peca_fornecedor1_idx` (`fornecedor_idfornecedor` ASC)  COMMENT '',
  CONSTRAINT `fk_peca_material1`
    FOREIGN KEY (`material_idmaterial`)
    REFERENCES `sistema_gestao`.`material` (`idmaterial`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_peca_fornecedor1`
    FOREIGN KEY (`fornecedor_idfornecedor`)
    REFERENCES `sistema_gestao`.`fornecedor` (`idfornecedor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sistema_gestao`.`projeto_has_conjunto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sistema_gestao`.`projeto_has_conjunto` (
  `projeto_idprojeto` BIGINT NOT NULL COMMENT '',
  `conjunto_idconjunto` BIGINT NOT NULL COMMENT '',
  PRIMARY KEY (`projeto_idprojeto`, `conjunto_idconjunto`)  COMMENT '',
  INDEX `fk_projeto_has_conjunto_conjunto1_idx` (`conjunto_idconjunto` ASC)  COMMENT '',
  INDEX `fk_projeto_has_conjunto_projeto1_idx` (`projeto_idprojeto` ASC)  COMMENT '',
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


-- -----------------------------------------------------
-- Table `sistema_gestao`.`cargo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sistema_gestao`.`cargo` (
  `idcargo` BIGINT NOT NULL AUTO_INCREMENT COMMENT '',
  `nome` VARCHAR(45) NULL COMMENT '',
  `descricao` VARCHAR(255) NULL COMMENT '',
  PRIMARY KEY (`idcargo`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sistema_gestao`.`usuario_has_cargo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sistema_gestao`.`usuario_has_cargo` (
  `usuario_idusuario` BIGINT NOT NULL COMMENT '',
  `cargo_idcargo` BIGINT NOT NULL COMMENT '',
  PRIMARY KEY (`usuario_idusuario`, `cargo_idcargo`)  COMMENT '',
  INDEX `fk_usuario_has_cargo_cargo1_idx` (`cargo_idcargo` ASC)  COMMENT '',
  INDEX `fk_usuario_has_cargo_usuario1_idx` (`usuario_idusuario` ASC)  COMMENT '',
  CONSTRAINT `fk_usuario_has_cargo_usuario1`
    FOREIGN KEY (`usuario_idusuario`)
    REFERENCES `sistema_gestao`.`usuario` (`idusuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuario_has_cargo_cargo1`
    FOREIGN KEY (`cargo_idcargo`)
    REFERENCES `sistema_gestao`.`cargo` (`idcargo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sistema_gestao`.`componente_peca`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sistema_gestao`.`componente_peca` (
  `idcomponente_peca` BIGINT NOT NULL AUTO_INCREMENT COMMENT '',
  `quantidade` INT(11) NULL COMMENT '',
  `peca_idpeca` BIGINT NOT NULL COMMENT '',
  `conjunto_idconjunto` BIGINT NOT NULL COMMENT '',
  PRIMARY KEY (`idcomponente_peca`)  COMMENT '',
  INDEX `fk_componente_peca_peca1_idx` (`peca_idpeca` ASC)  COMMENT '',
  INDEX `fk_componente_peca_conjunto1_idx` (`conjunto_idconjunto` ASC)  COMMENT '',
  CONSTRAINT `fk_componente_peca_peca1`
    FOREIGN KEY (`peca_idpeca`)
    REFERENCES `sistema_gestao`.`peca` (`idpeca`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_componente_peca_conjunto1`
    FOREIGN KEY (`conjunto_idconjunto`)
    REFERENCES `sistema_gestao`.`conjunto` (`idconjunto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sistema_gestao`.`componente_ferramenta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sistema_gestao`.`componente_ferramenta` (
  `idcomponente_ferramenta` BIGINT NOT NULL AUTO_INCREMENT COMMENT '',
  `quantidade` INT(11) NULL COMMENT '',
  `ferramenta_idferramenta` BIGINT NOT NULL COMMENT '',
  `conjunto_idconjunto` BIGINT NOT NULL COMMENT '',
  PRIMARY KEY (`idcomponente_ferramenta`)  COMMENT '',
  INDEX `fk_componente_ferramenta_ferramenta1_idx` (`ferramenta_idferramenta` ASC)  COMMENT '',
  INDEX `fk_componente_ferramenta_conjunto1_idx` (`conjunto_idconjunto` ASC)  COMMENT '',
  CONSTRAINT `fk_componente_ferramenta_ferramenta1`
    FOREIGN KEY (`ferramenta_idferramenta`)
    REFERENCES `sistema_gestao`.`ferramenta` (`idferramenta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_componente_ferramenta_conjunto1`
    FOREIGN KEY (`conjunto_idconjunto`)
    REFERENCES `sistema_gestao`.`conjunto` (`idconjunto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sistema_gestao`.`montagem_has_componente_ferramenta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sistema_gestao`.`montagem_has_componente_ferramenta` (
  `montagem_idmontagem` BIGINT NOT NULL COMMENT '',
  `componente_ferramenta_idcomponente_ferramenta` BIGINT NOT NULL COMMENT '',
  PRIMARY KEY (`montagem_idmontagem`, `componente_ferramenta_idcomponente_ferramenta`)  COMMENT '',
  INDEX `fk_montagem_has_componente_ferramenta_componente_ferramenta_idx` (`componente_ferramenta_idcomponente_ferramenta` ASC)  COMMENT '',
  INDEX `fk_montagem_has_componente_ferramenta_montagem1_idx` (`montagem_idmontagem` ASC)  COMMENT '',
  CONSTRAINT `fk_montagem_has_componente_ferramenta_montagem1`
    FOREIGN KEY (`montagem_idmontagem`)
    REFERENCES `sistema_gestao`.`montagem` (`idmontagem`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_montagem_has_componente_ferramenta_componente_ferramenta1`
    FOREIGN KEY (`componente_ferramenta_idcomponente_ferramenta`)
    REFERENCES `sistema_gestao`.`componente_ferramenta` (`idcomponente_ferramenta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sistema_gestao`.`montagem_has_componente_peca`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sistema_gestao`.`montagem_has_componente_peca` (
  `montagem_idmontagem` BIGINT NOT NULL COMMENT '',
  `componente_peca_idcomponente_peca` BIGINT NOT NULL COMMENT '',
  PRIMARY KEY (`montagem_idmontagem`, `componente_peca_idcomponente_peca`)  COMMENT '',
  INDEX `fk_montagem_has_componente_peca_componente_peca1_idx` (`componente_peca_idcomponente_peca` ASC)  COMMENT '',
  INDEX `fk_montagem_has_componente_peca_montagem1_idx` (`montagem_idmontagem` ASC)  COMMENT '',
  CONSTRAINT `fk_montagem_has_componente_peca_montagem1`
    FOREIGN KEY (`montagem_idmontagem`)
    REFERENCES `sistema_gestao`.`montagem` (`idmontagem`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_montagem_has_componente_peca_componente_peca1`
    FOREIGN KEY (`componente_peca_idcomponente_peca`)
    REFERENCES `sistema_gestao`.`componente_peca` (`idcomponente_peca`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
