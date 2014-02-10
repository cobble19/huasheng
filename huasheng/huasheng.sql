-- MySQL dump 10.13  Distrib 5.6.15, for linux-glibc2.5 (i686)
--
-- Host: localhost    Database: huasheng
-- ------------------------------------------------------
-- Server version	5.6.15-log

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
-- Table structure for table `authorities`
--

DROP TABLE IF EXISTS `authorities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `authorities` (
  `AUTHORITY` varchar(255) NOT NULL,
  `USERNAME` varchar(255) NOT NULL,
  PRIMARY KEY (`AUTHORITY`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authorities`
--

LOCK TABLES `authorities` WRITE;
/*!40000 ALTER TABLE `authorities` DISABLE KEYS */;
INSERT INTO `authorities` (`AUTHORITY`, `USERNAME`) VALUES ('ROLE_ADMIN','admin'),('ROLE_USER','admin');
/*!40000 ALTER TABLE `authorities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `b_category`
--

DROP TABLE IF EXISTS `b_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `b_category` (
  `CATEGORY_ID` bigint(20) NOT NULL,
  `NAME` varchar(255) NOT NULL,
  `TOPIC_ID` bigint(20) DEFAULT NULL,
  `ORDER_NO` int(11) DEFAULT NULL,
  PRIMARY KEY (`CATEGORY_ID`),
  KEY `FK_mlg9eib194u83nirvlupv7m6w` (`TOPIC_ID`),
  CONSTRAINT `FK_mlg9eib194u83nirvlupv7m6w` FOREIGN KEY (`TOPIC_ID`) REFERENCES `b_topic` (`TOPIC_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `b_category`
--

LOCK TABLES `b_category` WRITE;
/*!40000 ALTER TABLE `b_category` DISABLE KEYS */;
INSERT INTO `b_category` (`CATEGORY_ID`, `NAME`, `TOPIC_ID`, `ORDER_NO`) VALUES (9,'家庭都市',1,1),(10,'青春偶像',1,2),(11,'宫廷穿越',1,3),(12,'历史战争',1,4),(13,'武侠神话',1,5),(14,'警匪悬疑',1,6),(15,'幽默搞笑',1,7),(16,'爱情',2,1),(17,'科幻',2,2);
/*!40000 ALTER TABLE `b_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `b_item`
--

DROP TABLE IF EXISTS `b_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `b_item` (
  `ITEM_ID` bigint(20) NOT NULL,
  `NAME` varchar(255) NOT NULL,
  `HITS` bigint(20) DEFAULT NULL,
  `AREA_NAME` varchar(255) DEFAULT NULL,
  `SHOW_DATE` datetime DEFAULT NULL,
  `SCORE` double DEFAULT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `ACTOR_NAME` varchar(255) DEFAULT NULL,
  `ITEM_TYPE` varchar(255) DEFAULT NULL,
  `CATEGORY_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ITEM_ID`),
  KEY `FK_jwasq83pr8jvkqv5vej2m84tw` (`CATEGORY_ID`),
  CONSTRAINT `FK_jwasq83pr8jvkqv5vej2m84tw` FOREIGN KEY (`CATEGORY_ID`) REFERENCES `b_category` (`CATEGORY_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `b_item`
--

LOCK TABLES `b_item` WRITE;
/*!40000 ALTER TABLE `b_item` DISABLE KEYS */;
INSERT INTO `b_item` (`ITEM_ID`, `NAME`, `HITS`, `AREA_NAME`, `SHOW_DATE`, `SCORE`, `DESCRIPTION`, `ACTOR_NAME`, `ITEM_TYPE`, `CATEGORY_ID`) VALUES (19,'咱们结婚吧',14,'内地',NULL,0,'杨桃是一家四星级酒店的大堂经理，由于在感情中受过伤，三十岁的她依然单身一人。三十三岁的果然在婚姻登记处做离婚登记办事员，父母婚姻的阴影使他成为典型恐婚族。在朋友的撮合下，桃子和果然很不情愿地见了面。没想到，俩人竟然都对彼此留下好感。关闭已久的心门刚刚打开，桃子却发现果然是恐婚男，她愤然撤离。桃子面对现实，毅然投入到相亲大军中。桃子的相亲举动刺激了果然，他使出浑身解数，成功地将桃子的相亲一次次搅黄，最后有情人终成眷属。','高圆圆 黄海波 凯丽 王彤 大左 傅迦 柳岩 王策 田岷 白志迪','爱情 现代 家庭',9),(21,'小爸爸',6,'内地',NULL,0,'在某汽修厂悠哉游哉过着舒服生活的于果，突然被从天而降的儿子夏天搞得晕头转向。原来当年他和好哥们齐大胜去美国交流，与作为地陪的斯坦福高才生夏小白共谱了一段短暂的恋情。此去经年，小白车祸身亡，夏天从妈妈遗物中得知于果的信息，于是自作主张来北京找爸爸。原以为签名断绝关系就能了事，谁知小白的哥哥决定暂时将外甥留在于果身边。在此期间，他跟女友的关系越搞越僵，还被迫和之前吵过架的空港值机员李三妹惹出无数的纠缠。夏天的到来，改变了于果既定的人生路，也让他和周围人的生活悄悄发生了变化。','文章 马伊琍 王耀庆 张子萱 朱佳煜','情感 家庭 爱情 现代 喜剧',9),(22,'蜗居 ',5,'内地',NULL,0,'郭海藻、郭海萍两姐妹前后来到江州这个大城市寻求安定的生活。海萍有一份稳定的工作，好好先生的老公，还有一个因为房子太小而不能放在身边的女儿，她开始为了一套房子日思夜想。妹妹海藻一直过着简单幸福的小生活，和男友小贝感情稳定，虽然不停的跳槽却乐此不疲。海藻看着姐姐生活艰辛，一心想帮助姐姐姐夫，但自己能力却又远远不够，直到碰到成熟感性的政府官员宋思明。已婚的宋思明看上了海藻的单纯，海藻也无法抵御宋思明成功人士的诱惑，一段不伦的恋情展开。到底姐妹两人能有怎样的结局','海清 李念 郝平 张嘉译 文章','剧情 都市 家庭 爱情',9),(23,'夏家三千金',NULL,'内地',NULL,0,'《夏家三千金》翻拍自台湾三立电视台15周年大戏《天下父母心》。讲述亲情和爱情的故事，探讨为人父母应该如何引导子女追求真正的幸福，展现子女人生旅途中父母真情的感召力量。夏正松和于靓结婚20多年，抱养了大女儿友善，生育了小女儿天美，和睦的家庭。大女儿友善遇到了心仪的对象皓天，但对方已有青梅竹马的女友杨真真（她其实是夏正松与杨柳的女儿），夏正松坚决反对女儿友善介入他人情感关系，而友善却用尽一切手段来阻止皓天和真真，父女之间产生冲突。','唐嫣 张檬 戚薇 邱泽 陈楚河','内地都市言情剧',9),(24,'男人帮',NULL,'内地','2011-10-22 00:00:00',0,'剧情 爱情 励志','孙红雷 黄磊 王珞丹 汪俊','这是关于三个都市男人情感历程的故事，他们是无话不谈的好哥们，他们都是事业有成的单身好男人，但他们感情故事却迥然不同。顾小白是一名情景剧作家。在杂志情感专栏里教别人如何恋爱，但现实中他经常把自己的感情弄的一团糟。莫小闵是他第一个真正爱上的女人却因爱情理念不同而分手。虽然珊莉年龄比他大，但顾小白还是决定抓住机会不让真爱离开。罗书全是培训中心电脑老师，对爱情执着理性。当他和AMY要结婚时才知道AMY并不爱他。他毅然放手爱情，但仍旧给AMY一个完美婚礼，两人最终和平分手。公关公司客户总监左永邦，典型钻石王老五。',9),(25,'北京爱情故事',NULL,'内地','2012-01-08 00:00:00',0,'这是讲述几个八零后年轻人在北京的爱情故事，同时还围绕着亲情、友情……','李晨 陈思成 张译 杨幂 张歆艺 佟丽娅','现代 都市 爱情',10),(26,'放羊的星星',1,'中国台湾','2007-03-10 00:00:00',0,'夏之星，23岁的女诈欺犯，准予假释。一个为爱入狱的女子，终于等待到了今日，与她情人十三见面，她还特地到六星级饭店，挑选礼物。今天是E-shine集团二少爷仲天骐昔日情人欧雅若与哥哥仲天骏的婚礼，同时也是母亲家传蓝钻的Queen Mary的切割拍卖会。刻意避开婚礼的仲天骐硬是被老K从机场押回来，来到会台的他溜进婚礼后台，将雅若扯入怀，天骐吻了她。同时，窃走Queen Mary。一来为了报复雅若，二来不愿妈妈的遗物Queen Mary成为拍卖物。','林志颖 刘荷娜 洪小玲 立威廉 李威','偶像 搞笑 浪漫 爱情',10),(27,'情深深雨濛濛',0,'中国台湾 中国大陆','2001-04-03 00:00:00',0,'陆振华的九姨太雪琴为人专横，飞扬跋扈。九姨太雪琴，把八姨太文佩母女、李副官一家逐出陆家。文佩母女一时失去经济来源，日子贫困窘迫。文佩的女儿依萍向父亲讨生活费，与雪琴发生冲突，遭父亲鞭打，就此立下复仇志。依萍瞒过母亲去大上海舞厅当歌女。在舞厅，依萍与申报记者何书桓相识。依萍得知书桓是九姨太女儿如萍的男友，顿生夺人所爱之念。不料交往之中，依萍陷入情网，与书桓真诚相爱了。','赵薇 古巨基 林心如 苏有朋 高鑫 李郁','爱情 剧情 民国',10),(28,'幸福最晴天',NULL,'内地',NULL,0,'肩负家族企业命脉、事事都掌握的很好的项允杰，令人不解的是身边竟没有一个论及婚嫁的对象。原来在大学刚毕业的那年，他曾经有过轰轰烈烈的恋爱，恋爱的结果，是他和女友结婚又离婚了。事隔多年之后，一个小男孩（汪念杰）闯进了项允杰的世界，几番兜转，允杰发现，原来当年前妻并没有拿掉他们的孩子，这个八岁的小男孩竟是他的儿子！','贺军翔 张钧甯 李易峰 周子涵 李智楠 李金铭 郑伟 廖慧珍','都市爱情',10),(29,'彩虹甜心',NULL,'',NULL,0,'','','',10),(30,'寻秦记',1,'',NULL,0,'','','',11),(31,'步步惊心',NULL,'',NULL,0,'','','',11),(32,'宫',0,'',NULL,0,'','','',11),(33,'宫心计',NULL,'',NULL,0,'','','',11),(34,'甄嬛传',NULL,'',NULL,0,'','','',11),(35,'楚汉传奇',1,'',NULL,0,'','','',12),(36,'新水浒传',0,'',NULL,0,'','','',12),(37,'雪豹',NULL,'',NULL,0,'','','',12),(38,'神话',0,'',NULL,0,'','','',13),(39,'三国演义',NULL,'',NULL,0,'','','',12),(40,'天龙八部',NULL,'',NULL,0,'','','',13),(41,'一代枭雄',NULL,'',NULL,0,'','','',12),(42,'西游记',NULL,'',NULL,0,'','','',13),(43,'神雕侠侣',NULL,'',NULL,0,'','','',13),(44,'笑傲江湖',NULL,'',NULL,0,'','','',13),(45,'鹿鼎记',NULL,'',NULL,0,'','','',13),(46,'神枪狙击',NULL,'',NULL,0,'','','',14),(47,'法网狙击',NULL,'',NULL,0,'','','',14),(48,'法证先锋 I',0,'',NULL,0,'','','',14),(49,'刑事侦缉档案 I',0,'',NULL,0,'','','',14),(50,'陀枪师姐 I',0,'',NULL,0,'','','',14),(51,'爱情公寓 I',NULL,'',NULL,0,'','','',15),(52,'爱情公寓 II',NULL,'',NULL,0,'','','',15),(53,'爱情公寓 III',NULL,'',NULL,0,'','','',15),(54,'武林外传',NULL,'',NULL,0,'','','',15),(55,'龙门镖局',0,'',NULL,0,'','','',15),(56,'刑事侦缉档案 II',NULL,'',NULL,0,'','','',14),(57,'亮剑',NULL,'',NULL,0,'','','',12);
/*!40000 ALTER TABLE `b_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `b_topic`
--

DROP TABLE IF EXISTS `b_topic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `b_topic` (
  `TOPIC_ID` bigint(20) NOT NULL,
  `NAME` varchar(255) NOT NULL,
  PRIMARY KEY (`TOPIC_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `b_topic`
--

LOCK TABLES `b_topic` WRITE;
/*!40000 ALTER TABLE `b_topic` DISABLE KEYS */;
INSERT INTO `b_topic` (`TOPIC_ID`, `NAME`) VALUES (1,'电视剧'),(2,'电影'),(3,'动画片'),(4,'综艺');
/*!40000 ALTER TABLE `b_topic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `b_user`
--

DROP TABLE IF EXISTS `b_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `b_user` (
  `USER_ID` bigint(20) NOT NULL,
  `ACCOUNT_NO` varchar(255) NOT NULL,
  `PASSWORD` varchar(255) DEFAULT NULL,
  `NAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `b_user`
--

LOCK TABLES `b_user` WRITE;
/*!40000 ALTER TABLE `b_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `b_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `b_video`
--

DROP TABLE IF EXISTS `b_video`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `b_video` (
  `VIDEO_ID` bigint(20) NOT NULL,
  `URL` varchar(255) NOT NULL,
  `ORDER_NUM` int(11) NOT NULL,
  `ITEM_ID` bigint(20) DEFAULT NULL,
  `VIDEO_SRC_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`VIDEO_ID`),
  KEY `FK_9gpkp4sr4kng28yuekljwjjcy` (`ITEM_ID`),
  KEY `FK_39qud3fkkiaes5qe7u7w6enba` (`VIDEO_SRC_ID`),
  CONSTRAINT `FK_39qud3fkkiaes5qe7u7w6enba` FOREIGN KEY (`VIDEO_SRC_ID`) REFERENCES `b_video_src` (`VIDEO_SRC_ID`),
  CONSTRAINT `FK_9gpkp4sr4kng28yuekljwjjcy` FOREIGN KEY (`ITEM_ID`) REFERENCES `b_item` (`ITEM_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `b_video`
--

LOCK TABLES `b_video` WRITE;
/*!40000 ALTER TABLE `b_video` DISABLE KEYS */;
/*!40000 ALTER TABLE `b_video` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `b_video_src`
--

DROP TABLE IF EXISTS `b_video_src`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `b_video_src` (
  `VIDEO_SRC_ID` bigint(20) NOT NULL,
  `NAME` varchar(255) NOT NULL,
  PRIMARY KEY (`VIDEO_SRC_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `b_video_src`
--

LOCK TABLES `b_video_src` WRITE;
/*!40000 ALTER TABLE `b_video_src` DISABLE KEYS */;
/*!40000 ALTER TABLE `b_video_src` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `r_item_video_src`
--

DROP TABLE IF EXISTS `r_item_video_src`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `r_item_video_src` (
  `ITEM_ID` bigint(20) NOT NULL,
  `VIDEO_SRC_ID` bigint(20) NOT NULL,
  KEY `FK_4jap6sodxhyakge2f0aylof2s` (`VIDEO_SRC_ID`),
  KEY `FK_e2i2n2bonrlu3rp93vmf5brxy` (`ITEM_ID`),
  CONSTRAINT `FK_e2i2n2bonrlu3rp93vmf5brxy` FOREIGN KEY (`ITEM_ID`) REFERENCES `b_item` (`ITEM_ID`),
  CONSTRAINT `FK_4jap6sodxhyakge2f0aylof2s` FOREIGN KEY (`VIDEO_SRC_ID`) REFERENCES `b_video_src` (`VIDEO_SRC_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `r_item_video_src`
--

LOCK TABLES `r_item_video_src` WRITE;
/*!40000 ALTER TABLE `r_item_video_src` DISABLE KEYS */;
/*!40000 ALTER TABLE `r_item_video_src` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `USERNAME` varchar(255) NOT NULL,
  `PASSWORD` varchar(255) NOT NULL,
  `ENABLED` tinyint(1) NOT NULL,
  PRIMARY KEY (`USERNAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`USERNAME`, `PASSWORD`, `ENABLED`) VALUES ('admin','7742d0d7d6d4f11fcdf7de446903da30',1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-02-11  5:41:06
