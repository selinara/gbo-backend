/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.7.15 : Database - shuqian_db
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`shuqian_db` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `shuqian_db`;

/*Table structure for table `tb_authority` */

CREATE TABLE `tb_authority` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `dataUrl` varchar(100) DEFAULT NULL COMMENT '连接路径或方法',
  `menuClass` varchar(50) DEFAULT NULL COMMENT '菜单样式',
  `menuCode` varchar(50) NOT NULL COMMENT '菜单编码',
  `menuName` varchar(50) NOT NULL COMMENT '菜单名称',
  `icon` varchar(60) DEFAULT NULL COMMENT '菜单图标',
  `parentMenucode` varchar(50) DEFAULT NULL COMMENT '上级菜单编码',
  `sequence` bigint(20) DEFAULT '0' COMMENT '排序',
  `menuType` varchar(2) DEFAULT '1' COMMENT '菜单类型(1是左导航菜单 2是按钮权限)',
  `createTime` varchar(30) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_tb_authority_menu_code` (`menuCode`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8 COMMENT='菜单表';

/*Data for the table `tb_authority` */

insert  into `tb_authority`(`id`,`dataUrl`,`menuClass`,`menuCode`,`menuName`,`icon`,`parentMenucode`,`sequence`,`menuType`,`createTime`) values (1,'',NULL,'A','后台系统','fa fa-desktop','',1,'1','2019-07-22 14:03:27'),(2,'/system/user',NULL,'A1','用户管理',NULL,'A',2,'1','2019-07-19 17:43:20'),(3,'/system/role',NULL,'A2','角色管理',NULL,'A',3,'1','2019-07-19 17:43:45'),(4,'/system/auth',NULL,'A3','权限管理',NULL,'A',4,'1','2019-07-19 17:44:14'),(5,'/system/user/add',NULL,'A1A','用户管理-增加',NULL,'',100,'2','2019-07-19 17:49:56'),(6,'/system/user/edit',NULL,'A1B','用户管理-修改',NULL,'',101,'2','2019-07-19 17:50:03'),(7,'/system/user/del',NULL,'A1C','用户管理-删除',NULL,'',102,'2','2019-07-19 17:49:32'),(8,'/system/role/gear',NULL,'A2A','角色管理-权限设置',NULL,'',200,'2','2019-07-19 18:05:41'),(9,'/system/role/add',NULL,'A2B','角色管理-增加',NULL,'',201,'2','2019-07-19 17:51:22'),(10,'/system/role/edit',NULL,'A2C','角色管理-修改',NULL,'',202,'2','2019-07-19 17:51:53'),(11,'/system/role/del',NULL,'A2D','角色管理-删除',NULL,'',203,'2','2019-07-19 17:52:15'),(12,'/system/auth/add',NULL,'A3A','权限管理-增加',NULL,'',300,'2','2019-07-19 17:52:51'),(13,'/system/auth/edit',NULL,'A3B','权限管理-修改',NULL,'',301,'2','2019-07-19 17:53:49'),(14,'/system/auth/del',NULL,'A3C','权限管理-删除',NULL,'',303,'2','2019-07-19 17:54:24'),(40,'',NULL,'B','test','fa fa-heart','',5,'1','2019-07-22 14:07:03'),(41,'/test/1',NULL,'B1','test1','','B',6,'1','2019-07-22 14:08:01'),(42,'/test/2',NULL,'B2','test2','','B',7,'1','2019-07-22 14:07:50');

/*Table structure for table `tb_book` */

CREATE TABLE `tb_book` (
  `id` int(11) NOT NULL,
  `author` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double NOT NULL,
  `publication` varchar(255) DEFAULT NULL,
  `publicationdate` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_book` */

insert  into `tb_book`(`id`,`author`,`image`,`name`,`price`,`publication`,`publicationdate`,`remark`) values (1,'sdf','sdf','asdf',12.66,'asdf','sdf','asdf'),(2,'sadf','dd','dd',23.36,'asd','dd','ff');

/*Table structure for table `tb_role` */

CREATE TABLE `tb_role` (
  `roleId` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `roleKey` varchar(30) NOT NULL COMMENT '角色编码',
  `createTime` varchar(30) DEFAULT NULL COMMENT '创建时间',
  `description` varchar(200) DEFAULT NULL COMMENT '描述',
  `roleValue` varchar(40) NOT NULL COMMENT '角色名称',
  `companyId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`roleId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='角色表';

/*Data for the table `tb_role` */

insert  into `tb_role`(`roleId`,`roleKey`,`createTime`,`description`,`roleValue`,`companyId`) values (1,'admin','2019-07-19 17:32:30','拥有所有权限','超级管理员',NULL),(3,'normal','2019-07-19 17:33:26','只能有查看权限','普通用户',NULL),(4,'manage','2019-07-22 14:00:18','只能管理用户','用户管理员',NULL);

/*Table structure for table `tb_role_authority` */

CREATE TABLE `tb_role_authority` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键编号自增长',
  `menuCode` varchar(50) NOT NULL COMMENT '菜单编码',
  `roleKey` varchar(40) NOT NULL COMMENT '角色编码',
  `menuType` int(11) DEFAULT NULL COMMENT '菜单类型 1 导航 2 按钮',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=87 DEFAULT CHARSET=utf8 COMMENT='角色菜单表';

/*Data for the table `tb_role_authority` */

insert  into `tb_role_authority`(`id`,`menuCode`,`roleKey`,`menuType`) values (24,'test','test',1),(63,'A1','normal',1),(64,'A2','normal',1),(65,'A3','normal',1),(66,'Y','normal',1),(67,'A','normal',1),(68,'A','manage',1),(69,'A1','manage',1),(70,'A','admin',1),(71,'A1','admin',1),(72,'A2','admin',1),(73,'A3','admin',1),(74,'A1A','admin',1),(75,'A1B','admin',1),(76,'A1C','admin',1),(77,'A2A','admin',1),(78,'A2B','admin',1),(79,'A2C','admin',1),(80,'A2D','admin',1),(81,'A3A','admin',1),(82,'A3B','admin',1),(83,'A3C','admin',1),(84,'B','admin',1),(85,'B1','admin',1),(86,'B2','admin',1);

/*Table structure for table `tb_user` */

CREATE TABLE `tb_user` (
  `userId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `loginAccount` varchar(100) NOT NULL COMMENT '登录账号',
  `loginPass` varchar(65) DEFAULT NULL COMMENT '登录密码',
  `userName` varchar(100) DEFAULT NULL COMMENT '昵称',
  `userHead` varchar(1000) DEFAULT NULL COMMENT '头像',
  `userPhone` varchar(20) DEFAULT NULL COMMENT '手机',
  `userEmail` varchar(30) DEFAULT NULL COMMENT '邮箱',
  `userSex` int(1) DEFAULT NULL COMMENT '性别',
  `userBirthday` varchar(30) DEFAULT NULL COMMENT '生日',
  `registerTime` varchar(30) NOT NULL COMMENT '注册时间',
  `departmentKey` varchar(20) DEFAULT NULL COMMENT '部门编码',
  `roleIds` varchar(20) DEFAULT NULL,
  `roleNames` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`userId`),
  UNIQUE KEY `uk_tb_user_login_account` (`loginAccount`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COMMENT='用户表';

/*Data for the table `tb_user` */

insert  into `tb_user`(`userId`,`loginAccount`,`loginPass`,`userName`,`userHead`,`userPhone`,`userEmail`,`userSex`,`userBirthday`,`registerTime`,`departmentKey`,`roleIds`,`roleNames`) values (1,'shuqianyang','$2a$04$IsFSgPAcwvYDXve4QMm4Wu7hZYKcBErEfXiLCUknUO8pm/d9yAXLm',NULL,NULL,NULL,NULL,NULL,NULL,'2019-07-22 09:53:13',NULL,'1,3',NULL),(2,'hailianchen','$2a$04$NG2gilZciCZjMkrgSMEsRuo3rtBQrafe5wOFux7HtZfvCivXYoZlC',NULL,NULL,NULL,NULL,NULL,NULL,'2019-07-19 17:56:44',NULL,'2',NULL),(3,'yangbo','$2a$04$RW142SSwiXtU85RbCqDAo.C08luqMzAlitS5dn7Cnz6AGCJuI9VJK',NULL,NULL,NULL,NULL,NULL,NULL,'2019-07-19 17:56:55',NULL,'3',NULL),(16,'admin','$2a$04$m80bxuLe8Sh3WUZ0mBs3ROR0E5Vy/zV6xZUUUPvoC0FLdDuylEVzq',NULL,NULL,NULL,NULL,NULL,NULL,'2019-07-19 17:54:59',NULL,'1',NULL),(17,'zhangsan','$2a$04$eRemwdUb/o8EQSLn81cfION0ZgNJ6GvQLN7Pd7Jtzz/JLsl6b0xJS',NULL,NULL,NULL,NULL,NULL,NULL,'2019-07-22 14:01:05',NULL,'4',NULL);

/*Table structure for table `tb_user_role` */

CREATE TABLE `tb_user_role` (
  `userId` bigint(20) NOT NULL COMMENT '用户编号',
  `roleId` int(20) NOT NULL COMMENT '角色编号',
  PRIMARY KEY (`userId`,`roleId`),
  KEY `FKhh52n8vd4ny9ff4x9fb8v65qx` (`roleId`),
  CONSTRAINT `FKb40xxfch70f5qnyfw8yme1n1s` FOREIGN KEY (`userId`) REFERENCES `tb_user` (`userId`),
  CONSTRAINT `FKhh52n8vd4ny9ff4x9fb8v65qx` FOREIGN KEY (`roleId`) REFERENCES `tb_role` (`roleId`),
  CONSTRAINT `fk_tb_user_role_role_id` FOREIGN KEY (`roleId`) REFERENCES `tb_role` (`roleId`),
  CONSTRAINT `fk_tb_user_role_user_id` FOREIGN KEY (`userId`) REFERENCES `tb_user` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色映射表';

/*Data for the table `tb_user_role` */

insert  into `tb_user_role`(`userId`,`roleId`) values (1,1),(16,1),(1,3),(3,3),(17,4);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
