-- logs数据库中
CREATE TABLE `log_info` (
  `id` int(11) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `content` longtext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
