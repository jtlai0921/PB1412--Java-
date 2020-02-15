-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.67-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema db_database21
--

CREATE DATABASE IF NOT EXISTS db_database21;
USE db_database21;

--
-- Definition of table `sdf`
--

DROP TABLE IF EXISTS `sdf`;
CREATE TABLE `sdf` (
  `s` int(10) unsigned NOT NULL auto_increment,
  PRIMARY KEY  (`s`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

--
-- Dumping data for table `sdf`
--

/*!40000 ALTER TABLE `sdf` DISABLE KEYS */;
/*!40000 ALTER TABLE `sdf` ENABLE KEYS */;


--
-- Definition of table `tb_eee`
--

DROP TABLE IF EXISTS `tb_eee`;
CREATE TABLE `tb_eee` (
  `s` int(10) unsigned NOT NULL auto_increment,
  PRIMARY KEY  (`s`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

--
-- Dumping data for table `tb_eee`
--

/*!40000 ALTER TABLE `tb_eee` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_eee` ENABLE KEYS */;


--
-- Definition of table `tb_emp`
--

DROP TABLE IF EXISTS `tb_emp`;
CREATE TABLE `tb_emp` (
  `id` int(10) unsigned NOT NULL auto_increment,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=gbk;

--
-- Dumping data for table `tb_emp`
--

/*!40000 ALTER TABLE `tb_emp` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_emp` ENABLE KEYS */;


--
-- Definition of table `tb_student`
--

DROP TABLE IF EXISTS `tb_student`;
CREATE TABLE `tb_student` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `name` varchar(45) NOT NULL,
  `sex` varchar(45) NOT NULL,
  `className` varchar(45) NOT NULL,
  `math` float NOT NULL,
  `english` float NOT NULL,
  `chinese` float NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=gbk;

--
-- Dumping data for table `tb_student`
--

/*!40000 ALTER TABLE `tb_student` DISABLE KEYS */;
INSERT INTO `tb_student` (`id`,`name`,`sex`,`className`,`math`,`english`,`chinese`) VALUES 
 (1,'李雪','女','五年二班',89,92,83),
 (2,'王梅','女','五年一班',88,98,86),
 (3,'陈玉','男','五年三班',94,81,90),
 (4,'刘秀','男','五年五班',80,90,86),
 (5,'陈雷','男','五年三班',85,84,82),
 (6,'赵四','男','五年一班',87,88,95);
/*!40000 ALTER TABLE `tb_student` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
