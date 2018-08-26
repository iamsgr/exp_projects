/*
SQLyog Community v12.4.2 (32 bit)
MySQL - 5.7.11-log : Database - employee
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`employee` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `employee`;

/*Table structure for table `admindetails` */

DROP TABLE IF EXISTS `admindetails`;

CREATE TABLE `admindetails` (
  `adminID` int(3) unsigned NOT NULL AUTO_INCREMENT,
  `adminName` varchar(20) NOT NULL,
  `adminEmail` varchar(50) NOT NULL,
  `adminPassword` varchar(20) NOT NULL,
  `adminGender` varchar(6) NOT NULL,
  `adminDOB` varchar(20) NOT NULL,
  `adminAddress` varchar(50) DEFAULT NULL,
  `adminMobNo` varchar(20) NOT NULL,
  PRIMARY KEY (`adminID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `admindetails` */

insert  into `admindetails`(`adminID`,`adminName`,`adminEmail`,`adminPassword`,`adminGender`,`adminDOB`,`adminAddress`,`adminMobNo`) values 
(1,'Sagar','smpatil@gmail.com','123','male','30/03/1992','Karve Nagar, Pune','9689963392');

/*Table structure for table `empdetails` */

DROP TABLE IF EXISTS `empdetails`;

CREATE TABLE `empdetails` (
  `empID` int(4) unsigned NOT NULL AUTO_INCREMENT,
  `empName` varchar(40) NOT NULL,
  `empGender` varchar(6) NOT NULL,
  `empEmail` varchar(25) NOT NULL,
  `empMobNo` varchar(20) DEFAULT NULL,
  `empAddress` varchar(50) DEFAULT NULL,
  `empDOB` varchar(20) DEFAULT NULL,
  `empDOJ` varchar(20) DEFAULT NULL,
  `empPassword` varchar(10) NOT NULL,
  PRIMARY KEY (`empID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `empdetails` */

insert  into `empdetails`(`empID`,`empName`,`empGender`,`empEmail`,`empMobNo`,`empAddress`,`empDOB`,`empDOJ`,`empPassword`) values 
(1,'Sagar Mayappa Patil','male','smpatil@gmail.com','9689963392','Hingane Home Colony, Karve Nagar , Pune.','1992-03-30','2018-08-30','sagar123'),
(2,'Vaivbav Sambhaji Desai','male','vaibhav@gmail.com','9890952200','Lingnoor, Kolhapur.','1992-03-12','2018-09-10','vaibhav123'),
(3,'Priyanka Patil','female','priyanka@gmail.com','8889555550','Kolhapur.','1995-08-10','2018-08-28','priya123'),
(4,'Sachin Maruti Patil','male','sachin@gmail.com','8989555555','Hingne Colony, Karve Nagar, Pune.','1992-09-20','2018-05-05','sachin123'),
(5,'Pranav Dusane','male','pranav@gmail.com','9421485676','Vadgaon, Pune','1995-07-25','2018-07-20','pranav123'),
(7,'Sunil Gundu Patil','male','sunil@gmail.com','9890952201','Hingne Colony, Karve Nagar, Pune.','1992-08-28','2018-08-23','sunil123');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
