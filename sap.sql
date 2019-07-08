-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jul 08, 2019 at 10:41 PM
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
  `nome` varchar(100) CHARACTER SET utf8 NOT NULL,
  `sigla` varchar(10) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `nome` (`nome`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `curso`
--

INSERT INTO `curso` (`ID`, `nome`, `sigla`) VALUES
(1, 'Bacharel em Ciências da Computação', 'BCC');

-- --------------------------------------------------------

--
-- Table structure for table `disciplina`
--

DROP TABLE IF EXISTS `disciplina`;
CREATE TABLE IF NOT EXISTS `disciplina` (
  `ID` int(5) NOT NULL AUTO_INCREMENT,
  `Codigo` varchar(10) NOT NULL,
  `Nome` varchar(100) NOT NULL,
  `Area` enum('ARC','FC','ENSISO','EXTERNA') DEFAULT NULL,
  `Tipo` enum('OBRIGATORIA','OPTATIVA','ELETIVA') DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `Nome` (`Nome`)
) ENGINE=MyISAM AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `disciplina`
--

INSERT INTO `disciplina` (`ID`, `Codigo`, `Nome`, `Area`, `Tipo`) VALUES
(1, '06418', 'ÁLGEBRA VETORIAL E LINEAR PARA COMPUTAÇÃO', 'EXTERNA', 'OBRIGATORIA'),
(2, '06507', 'CÁLCULO NI', 'EXTERNA', 'OBRIGATORIA'),
(3, '14044', 'INTRODUÇÃO À CIÊNCIA DA COMPUTAÇÃO', 'ENSISO', 'OBRIGATORIA'),
(4, '14117', 'INTRODUÇÃO À PROGRAMAÇÃO I', 'ENSISO', 'OBRIGATORIA'),
(5, '14203', 'MATEMÁTICA DISCRETA I', 'FC', 'OBRIGATORIA'),
(6, '06214', 'ALGORITMOS E ESTRUTURAS DE DADOS', 'ENSISO', 'OBRIGATORIA'),
(7, '06508', 'CÁLCULO NII', 'EXTERNA', 'OBRIGATORIA'),
(8, '14118', 'INTRODUÇÃO À PROGRAMAÇÃO II', 'ENSISO', 'OBRIGATORIA'),
(9, '14204', 'MATEMÁTICA DISCRETA II', 'FC', 'OBRIGATORIA'),
(10, '14112', 'METODOLOGIA CIENTÍFICA APLICADA À COMPUTAÇÃO', 'ENSISO', 'OBRIGATORIA'),
(11, '14063', 'CIRCUITOS DIGITAIS', 'ARC', 'OBRIGATORIA'),
(12, '06243', 'ESTATÍSTICA EXPLORATÓRIA I', 'EXTERNA', 'OBRIGATORIA'),
(13, '06325', 'FÍSICA APLICADA À COMPUTAÇÃO', 'EXTERNA', 'OBRIGATORIA'),
(14, '14087', 'PROJETO E ANÁLISE DE ALGORITMOS', 'ENSISO', 'OBRIGATORIA'),
(15, '06223', 'TEORIA DA COMPUTAÇÃO', 'FC', 'OBRIGATORIA'),
(16, '14064', 'ARQUITETURA E ORGANIZAÇÃO DE COMPUTADORES', 'ARC', 'OBRIGATORIA'),
(17, '14088', 'BANCO DE DADOS S', 'ENSISO', 'OBRIGATORIA'),
(18, '06226', 'ENGENHARIA DE SOFTWARE', 'ENSISO', 'OBRIGATORIA'),
(19, '06252', 'PARADIGMAS DE PROGRAMAÇÃO', 'FC', 'OBRIGATORIA'),
(20, '14058', 'REDES DE COMPUTADORES', 'ARC', 'OBRIGATORIA'),
(21, '14090', 'COMPILADORES', 'ARC', 'OBRIGATORIA'),
(22, '14074', 'INTELIGÊNCIA ARTIFICIAL', 'FC', 'OBRIGATORIA'),
(23, '06251', 'PROJETO DE DESENVOLVIMENTO DE SOFTWARE', 'ENSISO', 'OBRIGATORIA'),
(24, '14059', 'SISTEMAS DISTRIBUÍDOS', 'ARC', 'OBRIGATORIA'),
(25, '14065', 'SISTEMAS OPERACIONAIS', 'ARC', 'OBRIGATORIA');

-- --------------------------------------------------------

--
-- Table structure for table `horario_disciplinas`
--

DROP TABLE IF EXISTS `horario_disciplinas`;
CREATE TABLE IF NOT EXISTS `horario_disciplinas` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `numero` int(11) NOT NULL,
  `FK_ID_disciplinas` int(11) NOT NULL,
  `FK_ID_periodo` int(11) NOT NULL,
  `cor` varchar(15) DEFAULT 'white',
  PRIMARY KEY (`ID`),
  KEY `horario_disciplinas_fk_ibfk_1` (`FK_ID_disciplinas`),
  KEY `horario_disciplinas_fkibk_2` (`FK_ID_periodo`)
) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `horario_disciplinas`
--

INSERT INTO `horario_disciplinas` (`ID`, `numero`, `FK_ID_disciplinas`, `FK_ID_periodo`, `cor`) VALUES
(1, 1, 1, 1, '#373a07'),
(2, 2, 2, 1, '#700202'),
(3, 3, 3, 1, '#144b03'),
(4, 4, 4, 1, '#9e6105'),
(5, 5, 5, 1, '#140458'),
(6, 1, 6, 2, '#373a07'),
(7, 3, 7, 2, '#700202'),
(8, 2, 8, 2, '#144b03'),
(9, 4, 9, 2, '#9e6105'),
(10, 5, 10, 2, '#140458'),
(11, 1, 11, 3, '#373a07'),
(12, 2, 12, 3, '#700202'),
(13, 3, 13, 3, '#144b03'),
(14, 4, 14, 3, '#9e6105'),
(15, 5, 15, 3, '#140458'),
(16, 1, 16, 4, '#373a07'),
(17, 2, 17, 4, '#700202'),
(18, 3, 18, 4, '#144b03'),
(19, 4, 19, 4, '#9e6105'),
(20, 5, 20, 4, '#140458');

-- --------------------------------------------------------

--
-- Table structure for table `hora_aula`
--

DROP TABLE IF EXISTS `hora_aula`;
CREATE TABLE IF NOT EXISTS `hora_aula` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `dia_da_semana` enum('SEGUNDA','TERCA','QUARTA','QUINTA','SEXTA') NOT NULL,
  `numero` int(11) DEFAULT '0',
  `hora_inicio` int(11) NOT NULL,
  `FK_ID_slot` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `hora_aula_FKIBK_1` (`FK_ID_slot`)
) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hora_aula`
--

INSERT INTO `hora_aula` (`ID`, `dia_da_semana`, `numero`, `hora_inicio`, `FK_ID_slot`) VALUES
(1, 'SEGUNDA', 1, 14, 1),
(2, 'SEGUNDA', 1, 15, 1),
(3, 'SEGUNDA', 2, 16, 1),
(4, 'SEGUNDA', 2, 17, 1),
(5, 'TERCA', 3, 14, 1),
(6, 'TERCA', 3, 15, 1),
(7, 'TERCA', 4, 16, 1),
(8, 'TERCA', 4, 17, 1),
(9, 'QUARTA', 2, 14, 1),
(10, 'QUARTA', 2, 15, 1),
(11, 'QUARTA', 5, 16, 1),
(12, 'QUARTA', 5, 17, 1),
(13, 'QUINTA', 4, 14, 1),
(14, 'QUINTA', 4, 15, 1),
(15, 'QUINTA', 1, 16, 1),
(16, 'QUINTA', 1, 17, 1),
(17, 'SEXTA', 5, 14, 1),
(18, 'SEXTA', 5, 15, 1),
(19, 'SEXTA', 3, 16, 1),
(20, 'SEXTA', 3, 17, 1);

-- --------------------------------------------------------

--
-- Table structure for table `ministra`
--

DROP TABLE IF EXISTS `ministra`;
CREATE TABLE IF NOT EXISTS `ministra` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `FK_CPF_professor` int(11) NOT NULL,
  `FK_ID_disciplina` int(5) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `ministra_fkibk_1` (`FK_CPF_professor`),
  KEY `ministra_fkibk_2` (`FK_ID_disciplina`)
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
  `n_periodo` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `horario_disciplinas_idfk_1` (`FK_ID_curso`),
  KEY `horario_disciplinas_idfk_2` (`FK_ID_slot`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `periodo`
--

INSERT INTO `periodo` (`ID`, `FK_ID_curso`, `FK_ID_slot`, `n_periodo`) VALUES
(1, 1, 1, 1),
(2, 1, 1, 2),
(3, 1, 1, 3),
(4, 1, 1, 4);

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
(1232, 'NOME', 'Ensiso', NULL, NULL, 'prof', 'PROFESSOR', '$2a$10$NktDIbpJMyAv2yNzuipqzu4kSGy.8jYtYVsRV140MAyR8VSrvlRR.'),
(1234, 'rodemarck', 'Ensiso', NULL, NULL, 'rode', 'PROFESSOR', '$2a$10$xu8K04NpPutppxYwdgLrcuFAF3ptgyCsEKSRMP6WF7F.Wy0UnRo4i'),
(12323, '123123412321', 'Arc', NULL, NULL, '432423123', 'COORDENADOR', 'QWERT');

-- --------------------------------------------------------

--
-- Table structure for table `slots`
--

DROP TABLE IF EXISTS `slots`;
CREATE TABLE IF NOT EXISTS `slots` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `tipo_slot` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `tipo_slot` (`tipo_slot`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `slots`
--

INSERT INTO `slots` (`ID`, `tipo_slot`) VALUES
(1, 'padrao'),
(2, 'um_ai'),
(3, 'outro_ai');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
