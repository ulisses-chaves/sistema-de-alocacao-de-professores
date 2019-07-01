-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jul 01, 2019 at 06:37 AM
-- Server version: 5.7.24
-- PHP Version: 7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sap`
--
CREATE DATABASE IF NOT EXISTS `sap` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `sap`;

-- --------------------------------------------------------

--
-- Table structure for table `afastamento`
--

DROP TABLE IF EXISTS `afastamento`;
CREATE TABLE IF NOT EXISTS `afastamento` (
  `Tipo` enum('Pessoal','Saude') NOT NULL,
  `Data_inicio` date NOT NULL,
  `Data_Termino` date DEFAULT NULL,
  `Motivo` varchar(50) NOT NULL,
  `FK_CPF_professor` int(11) NOT NULL,
  PRIMARY KEY (`FK_CPF_professor`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `curso`
--

DROP TABLE IF EXISTS `curso`;
CREATE TABLE IF NOT EXISTS `curso` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(30) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `nome` (`nome`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `disciplina`
--

DROP TABLE IF EXISTS `disciplina`;
CREATE TABLE IF NOT EXISTS `disciplina` (
  `ID` int(5) NOT NULL AUTO_INCREMENT,
  `Nome` varchar(30) NOT NULL,
  `Tipo` enum('Obrigatoria','Externa','Optativa') NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `horario_disciplinas`
--

DROP TABLE IF EXISTS `horario_disciplinas`;
CREATE TABLE IF NOT EXISTS `horario_disciplinas` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `numero` int(11) NOT NULL,
  `FK_ID_disciplinas` int(11) NOT NULL,
  `FK_ID_slots` int(11) NOT NULL,
  `horario1` time NOT NULL,
  `horario2` time DEFAULT NULL,
  `dia1` enum('Segunda','Terca','Quarta','Quinta','Sexta','Sabado') NOT NULL,
  `dia2` enum('Segunda','Terca','Quarta','Quinta','Sexta','Sabado') DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `horario_disciplinas_ibfk_1` (`FK_ID_slots`),
  KEY `horario_disciplinas_ibfk_2` (`FK_ID_disciplinas`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `ministra`
--

DROP TABLE IF EXISTS `ministra`;
CREATE TABLE IF NOT EXISTS `ministra` (
  `FK_CPF_professor` int(11) NOT NULL,
  `FK_ID_disciplina` int(5) NOT NULL,
  PRIMARY KEY (`FK_CPF_professor`,`FK_ID_disciplina`),
  KEY `FK_ID_disciplina` (`FK_ID_disciplina`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `periodo`
--

DROP TABLE IF EXISTS `periodo`;
CREATE TABLE IF NOT EXISTS `periodo` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `FK_ID_curso` int(11) NOT NULL,
  `FK_ID_slot` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `horario_disciplinas_idfk_1` (`FK_ID_curso`),
  KEY `horario_disciplinas_idfk_2` (`FK_ID_slot`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `prerequisito`
--

DROP TABLE IF EXISTS `prerequisito`;
CREATE TABLE IF NOT EXISTS `prerequisito` (
  `FK_ID_disciplina` int(5) NOT NULL,
  `FK_ID_disciplina_pre` int(5) NOT NULL,
  PRIMARY KEY (`FK_ID_disciplina`,`FK_ID_disciplina_pre`),
  KEY `FK_ID_disciplina_pre` (`FK_ID_disciplina_pre`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `professor`
--

DROP TABLE IF EXISTS `professor`;
CREATE TABLE IF NOT EXISTS `professor` (
  `CPF` int(11) NOT NULL,
  `Nome` varchar(40) NOT NULL,
  `Area` enum('FC','Arc','Ensiso') NOT NULL,
  `FK_Disciplina_Preferencia_1` int(5) DEFAULT NULL,
  `FK_Disciplina_Preferencia_2` int(5) DEFAULT NULL,
  `login` varchar(30) NOT NULL,
  `cargo` enum('PROFESSOR','COORDENADOR','SUPERVISOR') DEFAULT NULL,
  `senha` varchar(150) NOT NULL,
  PRIMARY KEY (`CPF`),
  UNIQUE KEY `login` (`login`),
  KEY `FK_Disciplina_Preferencia_1` (`FK_Disciplina_Preferencia_1`),
  KEY `FK_Disciplina_Preferencia_2` (`FK_Disciplina_Preferencia_2`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `professor`
--

INSERT INTO `professor` (`CPF`, `Nome`, `Area`, `FK_Disciplina_Preferencia_1`, `FK_Disciplina_Preferencia_2`, `login`, `cargo`, `senha`) VALUES
(1232, 'NOME', 'Ensiso', NULL, NULL, 'prof', 'PROFESSOR', '$2a$10$NktDIbpJMyAv2yNzuipqzu4kSGy.8jYtYVsRV140MAyR8VSrvlRR.');

-- --------------------------------------------------------

--
-- Table structure for table `slots`
--

DROP TABLE IF EXISTS `slots`;
CREATE TABLE IF NOT EXISTS `slots` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
