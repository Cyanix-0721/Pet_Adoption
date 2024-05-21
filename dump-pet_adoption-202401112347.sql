-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: pet_adoption
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `id` int NOT NULL AUTO_INCREMENT,
  `adminName` varchar(20) NOT NULL,
  `adminPwd` varchar(20) NOT NULL,
  `realName` varchar(20) NOT NULL,
  `telephone` varchar(20) NOT NULL,
  `email` varchar(20) NOT NULL,
  `age` int DEFAULT NULL,
  `sex` varchar(3) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `pic` varchar(100),
  `remark` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'白白','123456','林北','88888888','1111@qq.com',NULL,'男',NULL,'领导'),(2,'拜拜','111111','吴亦凡','11111111','2222@qq.com',NULL,'男',NULL,'员工'),(3,'掰掰','222222','蔡徐坤','22222222','33332qq.com',NULL,'男',NULL,'员工'),(4,'摆摆','333333','林南','33333333','4444@qq.com',NULL,'男',NULL,'员工');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `adoption`
--

DROP TABLE IF EXISTS `adoption`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `adoption` (
  `state` tinyint(1) DEFAULT '0',
  `id` int NOT NULL AUTO_INCREMENT COMMENT '领养ID',
  `userId` int NOT NULL COMMENT '领养人ID',
  `petId` int NOT NULL COMMENT '宠物ID',
  `adoptTime` date NOT NULL COMMENT '领养时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adoption`
--

LOCK TABLES `adoption` WRITE;
/*!40000 ALTER TABLE `adoption` DISABLE KEYS */;
INSERT INTO `adoption` VALUES (0,1,3,5,'2023-11-30'),(0,2,5,4,'2023-12-01');
/*!40000 ALTER TABLE `adoption` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `apply`
--

DROP TABLE IF EXISTS `apply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `apply` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(10) NOT NULL,
  `email` varchar(20) NOT NULL,
  `age` int NOT NULL,
  `telephone` varchar(12) NOT NULL,
  `message` varchar(100) NOT NULL,
  `applyTime` date NOT NULL,
  `state` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `apply`
--

LOCK TABLES `apply` WRITE;
/*!40000 ALTER TABLE `apply` DISABLE KEYS */;
INSERT INTO `apply` VALUES (1,'孤独','666.@qq.com',18,'123456789','我想要领养yy','2023-10-31',1),(2,'爱猫人士','777.@qq.com',22,'111111111','我想要领养泡泡','2023-10-25',1);
/*!40000 ALTER TABLE `apply` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `blog`
--

DROP TABLE IF EXISTS `blog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `blog` (
  `id` int NOT NULL AUTO_INCREMENT,
  `actionTime` date NOT NULL,
  `address` varchar(100) NOT NULL,
  `people` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `event` varchar(100) NOT NULL,
  `title` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blog`
--

LOCK TABLES `blog` WRITE;
/*!40000 ALTER TABLE `blog` DISABLE KEYS */;
INSERT INTO `blog` VALUES (1,'2023-05-10','福州烟台山','管理员','猫猫和狗狗展览','猫猫狗狗观赏会'),(2,'2023-06-07','厦门沙坡尾','管理员和用户','一起遛狗吧','与狗狗的亲密体验');
/*!40000 ALTER TABLE `blog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comments`
--

DROP TABLE IF EXISTS `comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comments` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '评论ID',
  `userId` int DEFAULT NULL,
  `adminId` int DEFAULT NULL,
  `petId` int DEFAULT NULL,
  `commentTime` date NOT NULL,
  `content` varchar(300) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comments`
--

LOCK TABLES `comments` WRITE;
/*!40000 ALTER TABLE `comments` DISABLE KEYS */;
INSERT INTO `comments` VALUES (1,1,1,1,'2023-06-01','小胖有被领养吗？'),(2,2,2,2,'2023-07-04','它乖嘛？'),(3,3,3,3,'2023-08-08','还有其他的金毛吗？');
/*!40000 ALTER TABLE `comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pet`
--

DROP TABLE IF EXISTS `pet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pet` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `petName` varchar(20) NOT NULL COMMENT '宠物的名称',
  `petType` varchar(20) NOT NULL COMMENT '宠物类型',
  `sex` varchar(3) NOT NULL COMMENT '宠物性别',
  `birthday` date NOT NULL COMMENT '宠物的出生日期',
  `pic` varchar(100) DEFAULT NULL COMMENT '图片',
  `state` int NOT NULL COMMENT '领养状态 0未领养 1被申请领养 2已经被领养',
  `remark` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pet`
--

LOCK TABLES `pet` WRITE;
/*!40000 ALTER TABLE `pet` DISABLE KEYS */;
INSERT INTO `pet` VALUES (1,'小胖','哈士奇','雌性','2023-01-01','',0,'活泼'),(2,'小百','阿拉斯加','雄性','2023-01-09','',0,'安静'),(3,'墩墩','金毛','雌性','2022-01-20','',0,'调皮'),(4,'忽忽','马尔济斯','雄性','2023-01-08','',1,'好动'),(5,'零零','泰迪','雌性','2022-01-26','',2,'活泼'),(6,'紧紧','拉布拉多','雄性','2022-01-10','',0,'安静'),(7,'kk','恶霸','雄性','2022-01-11','',0,'安静'),(8,'霍霍','柯基','雌性','2023-01-10','',0,'胆小'),(9,'yy','边牧','雄性','2022-01-29',NULL,1,'亲人'),(10,'顿顿','银渐层','雄性','2023-04-18',NULL,2,'活泼'),(11,'偶偶','波斯猫','雌性','2023-03-06',NULL,1,'好动'),(12,'泡泡','蓝猫','雄性','2023-02-06',NULL,1,'贪吃'),(13,'涛涛','蓝白','雌性','2023-04-02',NULL,2,'亲人'),(14,'琪琪','加菲猫','雄性','2022-04-12',NULL,1,'喜欢晒太阳'),(15,'威威','美短','雄性','2023-03-07',NULL,0,'喜欢吓唬人'),(16,'哼哼','布偶','雄性','2023-04-03',NULL,0,'有点小凶'),(17,'dd','哈士奇','雌性','2024-06-02',NULL,0,'活泼'),(18,'奈娜','雪纳瑞','雄性','2022-07-12',NULL,1,'好动'),(19,'uu','边牧','雌性','2023-03-14',NULL,2,'好动');
/*!40000 ALTER TABLE `pet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reply`
--

DROP TABLE IF EXISTS `reply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reply` (
  `id` int NOT NULL AUTO_INCREMENT,
  `userId` int DEFAULT NULL,
  `replyId` int DEFAULT NULL,
  `commentId` int NOT NULL,
  `answerTime` date NOT NULL,
  `content` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reply`
--

LOCK TABLES `reply` WRITE;
/*!40000 ALTER TABLE `reply` DISABLE KEYS */;
INSERT INTO `reply` VALUES (1,1,1,1,'2023-06-02','亲!还没呢！'),(2,2,2,2,'2023-07-04','非常安静，很乖的呢！'),(3,3,3,3,'2023-08-09','亲！很抱歉暂时没有。');
/*!40000 ALTER TABLE `reply` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `userName` varchar(20) NOT NULL COMMENT '用户名',
  `userPwd` varchar(30) NOT NULL COMMENT '用户密码',
  `sex` varchar(2) DEFAULT NULL COMMENT '性别',
  `age` int DEFAULT NULL COMMENT '年龄',
  `telephone` varchar(20) DEFAULT NULL COMMENT '联系方式',
  `email` varchar(30) DEFAULT NULL COMMENT '邮箱',
  `address` varchar(50) DEFAULT NULL COMMENT '地址',
  `pic` varchar(100) DEFAULT NULL COMMENT '头像',
  `state` tinyint(1) DEFAULT '0' COMMENT '领养宠物的经历 0没有 1有领养经验',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'孤独','123','男',18,'123456789','666.@qq.com','福州',NULL,0),(2,'爱猫人士','333','女',22,'111111111','777.@qq.com','厦门',NULL,0),(12,'asd','asd','女',22,'1251153','777.@qq.com','厦门',NULL,0),(13,'asdasd','asdasd','女',22,'1251153','777.@qq.com','厦门',NULL,0),(14,'asdasdas','asdasdas','女',22,'1251153','777.@qq.com','厦门',NULL,0),(15,'asd','asd','女',22,'1251153','777.@qq.com','厦门',NULL,0),(16,'asd','asd','女',22,'1251153','777.@qq.com','厦门',NULL,0),(22,'asdasd','asdasd','女',22,'1251153','777.@qq.com','厦门',NULL,0),(27,'asd','asd','男',111,'11111111111','wryyyy4444@outlook.com','asd','',0),(28,'asd','asd','男',41,'11111122223','wryyyy4444@outlook.com','asd','',0),(30,'asdasd','asdasd','男',124,'11145578822','wryyyy4444@outlook.com','asfas','',0),(31,'asda','asdasd','男',51,'11111111111','wryyyy4444@outlook.com','afasfsa','',0),(32,'asd','asd','男',123,'11111111111','wryyyy4444@outlook.com','asd','',0),(33,'asd','asd','男',76,'12312312312','123@qq.com','asd','',0),(34,'zxc','zxc','男',86,'11111111117','98863@qq.com','mgh','',0),(37,'asfsaf','asdasdas','男',64,'63253277777','wryyyy4444@outlook.com','fasas','C:\\fakepath\\wallpaper.jpg',0),(38,'xqc','asf','男',5,'33333333333','pvz@outlook.com','gas','',1),(39,'asdasdas','safasfas','男',33,'77777777777','wryyyy4444@outlook.com','asd','',0),(40,'asd','asdasd','男',32,'11111111111','wryyyy4444@outlook.com','sa','',0),(42,'test','123456','男',18,'13913913913','','test','test',1),(43,'test','test',NULL,0,NULL,NULL,NULL,NULL,0),(44,'asdasdas','asdasdas','男',88,'11111111111','wryyyy4444@outlook.com','gagsa','',0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'pet_adoption'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-01-11 23:47:54
