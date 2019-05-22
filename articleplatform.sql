/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : articleplatform

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2019-05-22 14:45:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'article id',
  `uid` int(11) NOT NULL COMMENT '外键 user id ',
  `author` varchar(255) DEFAULT NULL COMMENT '作者昵称',
  `title` varchar(100) DEFAULT NULL COMMENT '文章标题',
  `introduction` varchar(200) DEFAULT NULL COMMENT '文章简介',
  `content` text COMMENT '文章内容',
  `comment_count` int(11) DEFAULT '0',
  `like_count` int(11) DEFAULT '0',
  `read_count` int(11) DEFAULT '0',
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `url` varchar(100) DEFAULT NULL COMMENT '文章图片url',
  PRIMARY KEY (`id`),
  KEY `fk_article_user` (`uid`),
  CONSTRAINT `fk_article_user` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('1', '1', 'rzc', '去年9月到今年4月，我记录下了旅途中的这些小惊喜', '从去年9月到现在，转改有半年多了。\r\n\r\n细细数来，也走过了很多地方，城市和乡野，古镇和寺庙，大山和湖泊。\r\n\r\n说走就走的旅行，不是不管不顾不闻不问的去往某一个地方，而是今晚决定了，就妥善处理好工作，再做好攻略，明天一早就启程。', '<p><img alt=\"\" src=\"http://localhost:8080/upload/article-2019-05-12.19.08.20.jpg\"></p>\n\n<blockquote><p>回过头来才发现，原来那些当时用心记录下来的画面，都是流逝时光里不可多得的小美好。</p></blockquote>\n\n<p>2019年4月11日 星期四 阴</p>\n\n<p>文/杨小蟹</p>\n\n<p>从去年9月到现在，转改有半年多了。</p>\n\n<p>细细数来，也走过了很多地方，城市和乡野，古镇和寺庙，大山和湖泊。</p>\n\n<p>说走就走的旅行，不是不管不顾不闻不问的去往某一个地方，而是今晚决定了，就妥善处理好工作，再做好攻略，明天一早就启程。</p>\n\n<p><img alt=\"\" src=\"http://localhost:8080/upload/article-2019-05-12.19.09.11.jpg\"></p>\n\n<p>喜欢在高铁上听着喜欢的歌，看着窗外发呆，想到些什么就记下来。</p>\n\n<p>我喜欢走累了，就坐在湖边，听着民谣，静看夕阳西下。</p>\n\n<p>喜欢夜里独自在街头游荡，或者去逛夜市，记录下那些各自忙碌的身影。</p>\n\n<p><img alt=\"\" src=\"http://localhost:8080/upload/article-2019-05-12.19.09.44.jpg\"></p>\n\n<p>也特别喜欢旅途中遇到的那些个萌娃，微笑打个招呼，逗逗乐。</p>\n\n<p>为什么喜欢小孩子？</p>\n\n<p>因为她们的世界干净，天真童心，思维简单，心灵单纯，相处很舒服很放松。</p>\n\n<p><img alt=\"\" src=\"http://localhost:8080/upload/article-2019-05-12.19.10.19.jpg\"></p>\n\n<p><img alt=\"\" src=\"http://localhost:8080/upload/article-2019-05-12.19.10.34.jpg\"></p>\n\n<p>回过头来才发现，原来那些当时用心记录下来的画面，都是流逝时光里不可多得的小美好。</p>\n\n<p>很多东西，转瞬即逝，即使放进记忆里，时间久了也会淡忘。</p>\n\n<p>恰好文字和照片可以帮我们记得。</p>\n\n<p>做一个用心记录生活的人，将来一定可以转化为某种“财富”。</p>', '27', '0', '5', '2019-05-12 14:55:32', null);
INSERT INTO `article` VALUES ('2', '2', 'qwer', '第一篇文章', '第一篇文章\n\n\n\n第一段\n\n第二段\n\n正文寥寥几笔没了', '<h1>第一篇文章</h1>\n\n<p><img alt=\"\" src=\"http://localhost:8080/upload/article-2019-05-11.17.17.04.jpg\"></p>\n\n<p>第一段</p>\n\n<p>第二段</p>\n\n<p>正文寥寥几笔没了</p>', '0', '0', '0', '2019-05-11 19:57:01', '/upload/article-2019-05-11.17.17.04.jpg');
INSERT INTO `article` VALUES ('3', '3', 'abc', '测试文章', '测试文章\n\n\n\n第一段\n\n第二段\n\n以及一个以用', '<h1>测试文章</h1>\n\n<p><img alt=\"\" src=\"http://localhost:8080/upload/article-2019-05-11.19.55.25.jpg\"></p>\n\n<p>第一段</p>\n\n<p>第二段</p>\n\n<blockquote><p>以及一个以用</p></blockquote>', '0', '0', '2', '2019-05-12 14:55:38', '/upload/article-2019-05-11.19.55.25.jpg');
INSERT INTO `article` VALUES ('4', '1', 'rzc', '这次认真写文章', '这次认真写文章\n\n\n\n我的markdown不是只能从http', '<h1>这次认真写文章</h1>\n\n<p><img alt=\"\" src=\"http://localhost:8080/upload/article-2019-05-11.20.57.23.jpg\"></p>\n\n<p>我的markdown不是只能从http里找到ip访问嘛，不能直接访问到文件系统。</p>\n\n<p>像显示的时候，可以直接&lt;img src=”file:/C:/…”&gt;可以访问</p>\n\n<p>并且 localhost:8080/.. 如果上传到web路径下的某个文件夹，需要刷新项目才可以访问到对应的新上传的文件/图片，这时候我的Markdown是没有作用的（要对用户头像和文章头像分开来做），那么解决办法来了：</p>\n\n<blockquote><p>https://www.cnblogs.com/magic101/p/7756402.html</p></blockquote>', '3', '1', '8', '2019-05-12 14:56:50', '/upload/article-2019-05-11.20.57.23.jpg');
INSERT INTO `article` VALUES ('5', '4', 'riven', '光速qa秘籍', '光速qa秘籍连招1：erfwaqrq 最快连招2：erwar', '<h1>光速qa秘籍</h1><p>连招1：erfwaqrq 最快连招2：erwarq 最实用</p><p>剩下就自己玩吧。hhhhhhh</p><blockquote><p>what is broken can be reforged </p></blockquote>', '0', '0', '0', '2019-05-11 21:15:57', null);
INSERT INTO `article` VALUES ('6', '4', 'riven', '湖人总冠军', '湖人总冠军姚麦的火箭科比08.09.10的湖人勒布朗骑士詹姆', '<h1>湖人总冠军</h1><p>姚麦的火箭</p><p>科比08.09.10的湖人</p><p>勒布朗骑士</p><p>詹姆斯，波什，韦德热火</p><p>詹姆斯骑士</p><p>詹姆斯湖人</p><blockquote><p>老詹看一年少一年</p></blockquote>', '0', '0', '2', '2019-05-11 21:20:39', null);
INSERT INTO `article` VALUES ('7', '1', 'rzc', '南京大学人工智能学院', '南京大学人工智能学院从书目目录来看，《培养体系》的主体内容实', '<h1>南京大学人工智能学院</h1><p><img alt=\"\" src=\"http://localhost:8080/upload/article-2019-05-11.21.24.35.jpeg\"></p><p>从书目目录来看，《培养体系》的主体内容实际上是由一系列课程教学大纲组成的合集。本书前2章主要介绍对AI本科教育的思考和南大人工智能学院本科培养方案。然后进入主体部分，即课程设置和教学大纲，按课程类别分为数学基础课程、学科基础课程、专业方向课程和专业选修课程（本书3-6章）。</p><p>第三章是数学基础课程，包括数学分析、高等代数、离散数学、概率论与数理统计、最优化方法和数理逻辑。微博网友表示，从课程设置上来看，实际上并不那么基础，上来就是数学分析，已经接近数学系本科课程设置了。这部分可以大致看成是为进入AI领域打好数学基础的先修课程。</p><p><img alt=\"\" src=\"http://localhost:8080/upload/article-2019-05-11.21.25.23.jpeg\"></p><p>第四章是学科基础课程，大致相当于专业必修课，从课程设置上看，除了入门性质人工智能导引、导论之外，以及计算机类专业基础课“数据结构和算法分析”、“程序设计基础”、“计算机系统基础、”“操作系统”等课程之外，这部分课程基本涵盖AI领域的几个基本研究方向，如知识表示、NLP、模式识别和计算机视觉等。</p><p><img alt=\"\" src=\"http://localhost:8080/upload/article-2019-05-11.21.24.58.jpeg\"></p><p>第五章是专业方向课程，从设置上看应该是为中高年级学生指明更加具体的方向，并进行必要的训练。这部分课程除了计算机学科之外，还交叉涵盖了数学、电子、自动控制等多学科的专业课程。</p><p>第六章是专业选修课程，本章篇幅最长、课程数目最多，共分为数学拓展类、学科拓展类、专业拓展类、交叉复合类和应用实践类。从学科内走向学科间，最终迈向自己感兴趣的应用实践领域。现在想学什么，将来想干什么，这里都有。</p>', '5', '3', '14', '2019-05-12 14:55:57', '/upload/article-2019-05-11.21.24.35.jpeg');

-- ----------------------------
-- Table structure for article_likes
-- ----------------------------
DROP TABLE IF EXISTS `article_likes`;
CREATE TABLE `article_likes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL COMMENT '用户id',
  `aid` int(11) DEFAULT NULL COMMENT '文章id',
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_alike_article` (`aid`),
  KEY `fk_alike_user` (`uid`),
  CONSTRAINT `fk_alike_article` FOREIGN KEY (`aid`) REFERENCES `article` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_alike_user` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article_likes
-- ----------------------------
INSERT INTO `article_likes` VALUES ('4', '1', '1', '2019-05-03 20:54:12');
INSERT INTO `article_likes` VALUES ('6', '3', '1', '2019-05-03 20:59:40');
INSERT INTO `article_likes` VALUES ('7', '2', '1', '2019-05-04 11:10:19');
INSERT INTO `article_likes` VALUES ('8', '4', '1', '2019-05-04 11:12:59');
INSERT INTO `article_likes` VALUES ('11', '2', '7', '2019-05-12 14:33:53');
INSERT INTO `article_likes` VALUES ('12', '3', '7', '2019-05-12 14:44:50');
INSERT INTO `article_likes` VALUES ('13', '4', '7', '2019-05-12 14:46:19');
INSERT INTO `article_likes` VALUES ('14', '1', '4', '2019-05-12 14:56:28');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `aid` int(11) DEFAULT NULL COMMENT '文章id',
  `comment_from` varchar(100) NOT NULL,
  `comment_to` varchar(100) DEFAULT NULL,
  `depth` int(11) DEFAULT NULL COMMENT '楼层数',
  `info` varchar(255) DEFAULT NULL COMMENT '评论内容',
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_comment_article` (`aid`),
  CONSTRAINT `fk_comment_article` FOREIGN KEY (`aid`) REFERENCES `article` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('2', '1', 'rzc', '', '2', '哦哈哈哈哈，呃呃呃', '2019-05-03 11:04:15');
INSERT INTO `comment` VALUES ('3', '1', 'rzc', '', '2', '哦哈哈哈哈哈， 哈哈哈哈', '2019-05-03 11:04:15');
INSERT INTO `comment` VALUES ('4', '1', 'abc', '', '2', 'qwerdf，gg', '2019-05-03 11:04:15');
INSERT INTO `comment` VALUES ('5', '1', 'abc', 'rzc', '2', '测试depth', '2019-05-03 11:04:15');
INSERT INTO `comment` VALUES ('6', '1', 'qwer', '', '1', '这次depth应该为2了把^^', '2019-05-03 11:04:15');
INSERT INTO `comment` VALUES ('8', '1', 'rzc', '', '3', 'depth不是2我把手机屏吃了', '2019-05-03 11:04:15');
INSERT INTO `comment` VALUES ('9', '1', 'rzc', '', '4', 'depth不是3我把你的手机屏也吃了', '2019-05-03 11:04:15');
INSERT INTO `comment` VALUES ('10', '1', 'rzc', '', '5', '最后一条测试评论了', '2019-05-03 11:04:15');
INSERT INTO `comment` VALUES ('11', '1', 'rzc', 'abc', '2', '测试回复回复的回复', '2019-05-03 15:20:40');
INSERT INTO `comment` VALUES ('12', '1', 'rzc', 'rzc', '2', '回复一下我自己', '2019-05-03 15:21:53');
INSERT INTO `comment` VALUES ('13', '1', 'rzc', '', '2', '继续回复我自己', '2019-05-03 15:22:06');
INSERT INTO `comment` VALUES ('14', '1', 'rzc', '', '6', '那我再站一层楼吧', '2019-05-03 15:22:33');
INSERT INTO `comment` VALUES ('15', '1', 'rzc', '', '7', '强行多加一页', '2019-05-03 15:26:52');
INSERT INTO `comment` VALUES ('16', '1', 'qwer', '', '8', '单独成段', '2019-05-03 15:34:26');
INSERT INTO `comment` VALUES ('17', '1', 'qwer', '', '9', '再来一段', '2019-05-03 15:34:52');
INSERT INTO `comment` VALUES ('18', '1', 'abc', '', '10', '我也说点东西吧', '2019-05-03 15:36:08');
INSERT INTO `comment` VALUES ('19', '1', 'qwer', '', '11', '再来测试一下', '2019-05-03 15:39:09');
INSERT INTO `comment` VALUES ('20', '1', 'qwer', '', '10', '那我也说点把', '2019-05-03 15:39:29');
INSERT INTO `comment` VALUES ('21', '1', 'qwer', 'qwer', '10', '自己说自己^^', '2019-05-03 15:39:54');
INSERT INTO `comment` VALUES ('22', '1', 'abc', '', '10', '@qwe哈哈哈', '2019-05-03 15:44:07');
INSERT INTO `comment` VALUES ('23', '1', 'abc', '', '10', 'dada', '2019-05-03 15:52:38');
INSERT INTO `comment` VALUES ('24', '1', 'qwer', '', '10', '@abcqwerfd', '2019-05-03 16:02:17');
INSERT INTO `comment` VALUES ('26', '1', 'rzc', '', '9', null, '2019-05-03 16:04:45');
INSERT INTO `comment` VALUES ('27', '1', 'abc', 'rzc', '9', 'ig', '2019-05-03 16:07:35');
INSERT INTO `comment` VALUES ('28', '1', 'abc', '', '9', '@rz okoko', '2019-05-03 16:07:50');
INSERT INTO `comment` VALUES ('29', '1', 'abc', '', '9', '', '2019-05-03 16:07:56');
INSERT INTO `comment` VALUES ('30', '1', 'qwer', '', '10', 'ohayou', '2019-05-04 11:10:31');
INSERT INTO `comment` VALUES ('31', '7', 'riven', '', '1', '拜托，我西瓜书还没看呢。。', '2019-05-12 14:15:03');
INSERT INTO `comment` VALUES ('32', '7', 'qwer', '', '1', '还有统计学习方法', '2019-05-12 14:32:09');
INSERT INTO `comment` VALUES ('33', '7', 'abc', '', '2', '我还是觉得分布式会好一点，看个人把', '2019-05-12 14:43:17');
INSERT INTO `comment` VALUES ('34', '7', 'riven', '', '3', '我胡汉三过来插个眼', '2019-05-12 14:47:07');
INSERT INTO `comment` VALUES ('36', '7', 'riven', '', '5', '看看我在第几页', '2019-05-12 14:48:15');
INSERT INTO `comment` VALUES ('37', '4', 'rzc', '', '1', '占楼', '2019-05-12 14:56:38');
INSERT INTO `comment` VALUES ('38', '4', 'rzc', '', '2', '好可爱的猫o(=•ェ•=)m', '2019-05-12 14:56:49');
INSERT INTO `comment` VALUES ('39', '4', 'rzc', '', '3', '继续占楼', '2019-05-15 14:41:51');

-- ----------------------------
-- Table structure for comment_likes
-- ----------------------------
DROP TABLE IF EXISTS `comment_likes`;
CREATE TABLE `comment_likes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL COMMENT '用户id',
  `cid` int(11) DEFAULT NULL COMMENT '评论id',
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_clike_user` (`uid`),
  KEY `fk_clike_comment` (`cid`),
  CONSTRAINT `fk_clike_comment` FOREIGN KEY (`cid`) REFERENCES `comment` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_clike_user` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment_likes
-- ----------------------------
INSERT INTO `comment_likes` VALUES ('2', '1', '19', '2019-05-04 10:58:58');
INSERT INTO `comment_likes` VALUES ('4', '3', '18', '2019-05-04 11:07:45');
INSERT INTO `comment_likes` VALUES ('5', '3', '19', '2019-05-04 11:07:51');
INSERT INTO `comment_likes` VALUES ('6', '2', '18', '2019-05-04 11:10:22');
INSERT INTO `comment_likes` VALUES ('7', '2', '31', '2019-05-12 14:31:42');

-- ----------------------------
-- Table structure for follow
-- ----------------------------
DROP TABLE IF EXISTS `follow`;
CREATE TABLE `follow` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `follow_from` int(11) DEFAULT NULL,
  `follow_to` int(11) DEFAULT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_follow_from_user` (`follow_from`),
  KEY `fk_follow_to_user` (`follow_to`),
  CONSTRAINT `fk_follow_from_user` FOREIGN KEY (`follow_from`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `fk_follow_to_user` FOREIGN KEY (`follow_to`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of follow
-- ----------------------------
INSERT INTO `follow` VALUES ('3', '2', '1', '2019-05-06 20:36:00');
INSERT INTO `follow` VALUES ('4', '2', '3', '2019-05-07 08:49:43');
INSERT INTO `follow` VALUES ('9', '3', '4', '2019-05-07 10:46:09');
INSERT INTO `follow` VALUES ('11', '1', '2', '2019-05-07 11:13:40');
INSERT INTO `follow` VALUES ('12', '1', '4', '2019-05-07 11:14:28');
INSERT INTO `follow` VALUES ('13', '4', '1', '2019-05-07 11:23:34');
INSERT INTO `follow` VALUES ('18', '3', '1', '2019-05-12 14:53:08');

-- ----------------------------
-- Table structure for search
-- ----------------------------
DROP TABLE IF EXISTS `search`;
CREATE TABLE `search` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL,
  `info` varchar(255) NOT NULL DEFAULT '' COMMENT '检索字段',
  `remove` int(11) DEFAULT '0',
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_search_user` (`uid`),
  CONSTRAINT `fk_search_user` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of search
-- ----------------------------
INSERT INTO `search` VALUES ('1', '4', 'hahah', '0', '2019-05-09 10:25:36');
INSERT INTO `search` VALUES ('2', '3', 'pass', '0', '2019-05-09 10:25:31');
INSERT INTO `search` VALUES ('3', '4', 'dadada', '1', '2019-05-09 11:18:33');
INSERT INTO `search` VALUES ('4', null, 'dadada', '0', '2019-05-09 10:08:08');
INSERT INTO `search` VALUES ('5', '2', '4月', '1', '2019-05-09 10:28:41');
INSERT INTO `search` VALUES ('6', '1', '这样', '0', '2019-05-09 10:25:03');
INSERT INTO `search` VALUES ('7', '1', 'hahah', '0', '2019-05-09 11:28:06');
INSERT INTO `search` VALUES ('8', '1', '最后一次测试', '1', '2019-05-09 11:29:02');
INSERT INTO `search` VALUES ('9', '1', '再来一次', '0', '2019-05-09 11:29:20');
INSERT INTO `search` VALUES ('10', null, 'papapap', '0', '2019-05-09 11:37:06');
INSERT INTO `search` VALUES ('12', null, '最后一次papapa', '0', '2019-05-09 11:38:56');
INSERT INTO `search` VALUES ('13', null, 'form的锅', '0', '2019-05-09 11:40:04');
INSERT INTO `search` VALUES ('14', null, '回答后', '0', '2019-05-09 11:49:05');
INSERT INTO `search` VALUES ('15', null, 'dasdasda', '0', '2019-05-09 11:57:56');
INSERT INTO `search` VALUES ('16', null, 'balabalabala', '0', '2019-05-09 12:03:47');
INSERT INTO `search` VALUES ('17', null, 'gg', '0', '2019-05-09 12:06:11');
INSERT INTO `search` VALUES ('18', '1', '拜拜拜', '0', '2019-05-09 12:06:25');
INSERT INTO `search` VALUES ('19', '1', '结束了', '0', '2019-05-09 12:06:29');
INSERT INTO `search` VALUES ('20', '1', 'oncick测试', '0', '2019-05-09 12:13:00');
INSERT INTO `search` VALUES ('21', '1', '南京', '0', '2019-05-19 20:11:32');
INSERT INTO `search` VALUES ('22', '1', '南京 r', '0', '2019-05-19 20:12:02');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID主键自增',
  `username` varchar(100) NOT NULL,
  `phone` varchar(20) NOT NULL COMMENT '手机号码',
  `passwd` varchar(255) DEFAULT NULL COMMENT '密码',
  `fan_count` int(11) DEFAULT '0',
  `follow_count` int(11) DEFAULT '0',
  `write_count` int(11) DEFAULT '0',
  `like_count` int(11) DEFAULT '0',
  `article_count` int(11) DEFAULT '0',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `info` varchar(255) DEFAULT NULL COMMENT '个人简介',
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('0', 'admin', 'admin', 'admin', '0', '0', '0', '0', '0', '2019-05-12 20:46:22', 'I\'m admin', '/upload/init.jpg');
INSERT INTO `user` VALUES ('1', 'rzc', '15804037293', '123456', '3', '1', '257', '8', '3', '2019-05-12 14:56:28', '=w= qwq ^^', '/upload/user-1.jpg');
INSERT INTO `user` VALUES ('2', 'qwer', 'phone1', 'passwd', '1', '2', '30', '0', '1', '2019-05-12 14:40:38', 'erfwarq!', '/upload/init.jpg');
INSERT INTO `user` VALUES ('3', 'abc', 'phone', '123456', '0', '2', '22', '0', '1', '2019-05-12 14:53:08', 'nullptr...', '/upload/init.jpg');
INSERT INTO `user` VALUES ('4', 'riven', '110', '123456', '2', '1', '749', '0', '2', '2019-05-12 14:40:38', null, '/upload/init.jpg');
