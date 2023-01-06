/*
 Navicat Premium Data Transfer

 Source Server         : root
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : pls

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 02/01/2023 17:05:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for addressinfo
-- ----------------------------
DROP TABLE IF EXISTS `addressinfo`;
CREATE TABLE `addressinfo`  (
  `address_id` int(0) NOT NULL AUTO_INCREMENT,
  `address_province` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address_city` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`address_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 57 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of addressinfo
-- ----------------------------
INSERT INTO `addressinfo` VALUES (1, '重庆市', '重庆市', '沙坪坝区');
INSERT INTO `addressinfo` VALUES (2, '四川省', '成都市', '春熙路');
INSERT INTO `addressinfo` VALUES (3, '湖北', '武汉', '武汉大学');
INSERT INTO `addressinfo` VALUES (31, '修改了', '678768', 'sdsfasf');
INSERT INTO `addressinfo` VALUES (36, '四川', '自贡', '地区0');
INSERT INTO `addressinfo` VALUES (37, '四川', '自贡', '地区1');
INSERT INTO `addressinfo` VALUES (38, '四川', '自贡', '地区2');
INSERT INTO `addressinfo` VALUES (39, '四川', '自贡', '地区3');
INSERT INTO `addressinfo` VALUES (40, '四川', '自贡', '地区4');
INSERT INTO `addressinfo` VALUES (41, '湖北', '荆州', '地区0');
INSERT INTO `addressinfo` VALUES (42, '湖北', '荆州', '地区1');
INSERT INTO `addressinfo` VALUES (43, '湖北', '荆州', '地区2');
INSERT INTO `addressinfo` VALUES (44, '湖北', '荆州', '地区3');
INSERT INTO `addressinfo` VALUES (45, '湖北', '荆州', '地区4');
INSERT INTO `addressinfo` VALUES (46, '上海', '上海', '地区0');
INSERT INTO `addressinfo` VALUES (47, '上海', '上海', '地区1');
INSERT INTO `addressinfo` VALUES (48, '上海', '上海', '地区2');
INSERT INTO `addressinfo` VALUES (49, '上海', '上海', '地区333');
INSERT INTO `addressinfo` VALUES (57, '海南省', '三亚市', '不知道');

-- ----------------------------
-- Table structure for advertisementinfo
-- ----------------------------
DROP TABLE IF EXISTS `advertisementinfo`;
CREATE TABLE `advertisementinfo`  (
  `ad_id` int(0) NOT NULL AUTO_INCREMENT,
  `ad_content` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ad_money` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ad_adviser` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ad_start` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ad_end` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ad_images` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`ad_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of advertisementinfo
-- ----------------------------
INSERT INTO `advertisementinfo` VALUES (3, '送礼就送脑白金', '1100', '脑白金', '2022', '2024', 'http://localhost:8080/2022/07/12/9ee03b0a-2a7e-458f-a7e6-a208249d8a40.jpg');
INSERT INTO `advertisementinfo` VALUES (4, '宫廷玉液酒，一百八一杯', '998', '王大锤', '2022', '2099', 'http://120.25.249.178:8080/2022/07/03/728d5c1e-1530-40f4-b5d9-40f3d845fcac.jpg');
INSERT INTO `advertisementinfo` VALUES (7, '测试广告', '2600', '测试人员', '2022', '2023', 'http://120.25.249.178:8080/2022/07/03/9515bd67-388c-4978-b86f-1f6ea99aa343.jpg');

-- ----------------------------
-- Table structure for authority
-- ----------------------------
DROP TABLE IF EXISTS `authority`;
CREATE TABLE `authority`  (
  `authority_id` int(0) NOT NULL AUTO_INCREMENT,
  `authority_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`authority_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of authority
-- ----------------------------
INSERT INTO `authority` VALUES (1, '普通用户');
INSERT INTO `authority` VALUES (2, '管理员');

-- ----------------------------
-- Table structure for buildinfo
-- ----------------------------
DROP TABLE IF EXISTS `buildinfo`;
CREATE TABLE `buildinfo`  (
  `build_id` int(0) NOT NULL AUTO_INCREMENT,
  `address_id` int(0) NULL DEFAULT NULL,
  `bulid_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `build_style` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `build_rent` int(0) NOT NULL,
  `build_area` int(0) NULL DEFAULT NULL,
  `build_person` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`build_id`) USING BTREE,
  INDEX `FK_Relationship_11`(`address_id`) USING BTREE,
  CONSTRAINT `FK_Relationship_11` FOREIGN KEY (`address_id`) REFERENCES `addressinfo` (`address_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 107 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of buildinfo
-- ----------------------------
INSERT INTO `buildinfo` VALUES (6, 1, '第1凤凰楼', '公司', 1, 408, '第1负责人');
INSERT INTO `buildinfo` VALUES (8, 3, '第1凤凰楼', '公司', 0, 467, '第1负责人');
INSERT INTO `buildinfo` VALUES (9, 2, '第2凤凰楼', '物流站', 0, 406, '第2负责人');
INSERT INTO `buildinfo` VALUES (10, 2, '第3凤凰楼', '公司', 0, 55, '第3负责人');
INSERT INTO `buildinfo` VALUES (11, 3, '第4凤凰楼', '仓库', 0, 460, '第4负责人');
INSERT INTO `buildinfo` VALUES (12, 2, '第5凤凰楼', '公司', 0, 22, '第5负责人');
INSERT INTO `buildinfo` VALUES (13, 1, '第6凤凰楼', '公司', 0, 193, '第6负责人');
INSERT INTO `buildinfo` VALUES (14, 1, '第7凤凰楼', '公司', 0, 434, '第7负责人');
INSERT INTO `buildinfo` VALUES (15, 1, '第8凤凰楼', '公司', 0, 40, '第8负责人');
INSERT INTO `buildinfo` VALUES (16, 2, '第9凤凰楼', '仓库', 0, 180, '第9负责人');
INSERT INTO `buildinfo` VALUES (17, 2, '第10凤凰楼', '仓库', 0, 156, '第10负责人');
INSERT INTO `buildinfo` VALUES (18, 2, '第11凤凰楼', '仓库', 0, 202, '第11负责人');
INSERT INTO `buildinfo` VALUES (19, 2, '第12凤凰楼', '物流站', 0, 284, '第12负责人');
INSERT INTO `buildinfo` VALUES (20, 3, '第13凤凰楼', '公司', 0, 176, '第13负责人');
INSERT INTO `buildinfo` VALUES (21, 3, '第14凤凰楼', '公司', 0, 86, '第14负责人');
INSERT INTO `buildinfo` VALUES (22, 1, '第15凤凰楼', '物流站', 0, 225, '第15负责人');
INSERT INTO `buildinfo` VALUES (23, 2, '第16凤凰楼', '仓库', 0, 115, '第16负责人');
INSERT INTO `buildinfo` VALUES (24, 3, '第17凤凰楼', '物流站', 0, 477, '第17负责人');
INSERT INTO `buildinfo` VALUES (25, 3, '第18凤凰楼', '公司', 0, 94, '第18负责人');
INSERT INTO `buildinfo` VALUES (26, 3, '第19凤凰楼', '仓库', 0, 493, '第19负责人');
INSERT INTO `buildinfo` VALUES (27, 3, '第20凤凰楼', '公司', 0, 177, '第20负责人');
INSERT INTO `buildinfo` VALUES (28, 1, '第21凤凰楼', '公司', 0, 260, '第21负责人');
INSERT INTO `buildinfo` VALUES (29, 1, '第22凤凰楼', '公司', 0, 176, '第22负责人');
INSERT INTO `buildinfo` VALUES (30, 3, '第23凤凰楼', '物流站', 0, 127, '第23负责人');
INSERT INTO `buildinfo` VALUES (31, 1, '第24凤凰楼', '公司', 0, 31, '第24负责人');
INSERT INTO `buildinfo` VALUES (32, 3, '第25凤凰楼', '物流站', 0, 373, '第25负责人');
INSERT INTO `buildinfo` VALUES (33, 1, '第26凤凰楼', '公司', 0, 354, '第26负责人');
INSERT INTO `buildinfo` VALUES (34, 2, '第27凤凰楼', '公司', 0, 463, '第27负责人');
INSERT INTO `buildinfo` VALUES (35, 2, '第28凤凰楼', '公司', 0, 15, '第28负责人');
INSERT INTO `buildinfo` VALUES (36, 3, '第29凤凰楼', '仓库', 0, 457, '第29负责人');
INSERT INTO `buildinfo` VALUES (37, 1, '第30凤凰楼', '物流站', 0, 156, '第30负责人');
INSERT INTO `buildinfo` VALUES (38, 3, '第31凤凰楼', '物流站', 0, 274, '第31负责人');
INSERT INTO `buildinfo` VALUES (39, 3, '第32凤凰楼', '仓库', 0, 252, '第32负责人');
INSERT INTO `buildinfo` VALUES (40, 1, '第33凤凰楼', '物流站', 0, 232, '第33负责人');
INSERT INTO `buildinfo` VALUES (41, 3, '第34凤凰楼', '仓库', 0, 258, '第34负责人');
INSERT INTO `buildinfo` VALUES (42, 1, '第35凤凰楼', '仓库', 0, 221, '第35负责人');
INSERT INTO `buildinfo` VALUES (43, 3, '第36凤凰楼', '物流站', 0, 170, '第36负责人');
INSERT INTO `buildinfo` VALUES (44, 1, '第37凤凰楼', '公司', 0, 34, '第37负责人');
INSERT INTO `buildinfo` VALUES (45, 3, '第38凤凰楼', '仓库', 0, 425, '第38负责人');
INSERT INTO `buildinfo` VALUES (46, 1, '第39凤凰楼', '公司', 0, 472, '第39负责人');
INSERT INTO `buildinfo` VALUES (47, 1, '第40凤凰楼', '物流站', 0, 208, '第40负责人');
INSERT INTO `buildinfo` VALUES (48, 2, '第41凤凰楼', '物流站', 0, 157, '第41负责人');
INSERT INTO `buildinfo` VALUES (49, 3, '第42凤凰楼', '物流站', 0, 197, '第42负责人');
INSERT INTO `buildinfo` VALUES (50, 1, '第43凤凰楼', '公司', 0, 483, '第43负责人');
INSERT INTO `buildinfo` VALUES (51, 3, '第44凤凰楼', '物流站', 0, 492, '第44负责人');
INSERT INTO `buildinfo` VALUES (52, 1, '第45凤凰楼', '物流站', 0, 445, '第45负责人');
INSERT INTO `buildinfo` VALUES (53, 3, '第46凤凰楼', '物流站', 0, 231, '第46负责人');
INSERT INTO `buildinfo` VALUES (54, 3, '第47凤凰楼', '公司', 0, 403, '第47负责人');
INSERT INTO `buildinfo` VALUES (55, 2, '第48凤凰楼', '物流站', 0, 442, '第48负责人');
INSERT INTO `buildinfo` VALUES (56, 2, '第49凤凰楼', '仓库', 0, 321, '第49负责人');
INSERT INTO `buildinfo` VALUES (57, 2, '第50凤凰楼', '仓库', 0, 119, '第50负责人');
INSERT INTO `buildinfo` VALUES (58, 2, '第51凤凰楼', '仓库', 0, 308, '第51负责人');
INSERT INTO `buildinfo` VALUES (59, 1, '第52凤凰楼', '仓库', 0, 371, '第52负责人');
INSERT INTO `buildinfo` VALUES (60, 2, '第53凤凰楼', '仓库', 0, 472, '第53负责人');
INSERT INTO `buildinfo` VALUES (61, 1, '第54凤凰楼', '物流站', 0, 327, '第54负责人');
INSERT INTO `buildinfo` VALUES (62, 2, '第55凤凰楼', '公司', 0, 296, '第55负责人');
INSERT INTO `buildinfo` VALUES (63, 2, '第56凤凰楼', '公司', 0, 115, '第56负责人');
INSERT INTO `buildinfo` VALUES (64, 3, '第57凤凰楼', '公司', 0, 248, '第57负责人');
INSERT INTO `buildinfo` VALUES (65, 1, '第58凤凰楼', '公司', 0, 449, '第58负责人');
INSERT INTO `buildinfo` VALUES (66, 2, '第59凤凰楼', '物流站', 1, 261, '第59负责人');
INSERT INTO `buildinfo` VALUES (67, 2, '第60凤凰楼', '仓库', 0, 278, '第60负责人');
INSERT INTO `buildinfo` VALUES (68, 2, '第61凤凰楼', '公司', 0, 128, '第61负责人');
INSERT INTO `buildinfo` VALUES (69, 2, '第62凤凰楼', '仓库', 1, 127, '第62负责人');
INSERT INTO `buildinfo` VALUES (70, 3, '第63凤凰楼', '仓库', 0, 458, '第63负责人');
INSERT INTO `buildinfo` VALUES (71, 3, '第64凤凰楼', '仓库', 1, 109, '第64负责人');
INSERT INTO `buildinfo` VALUES (72, 3, '第65凤凰楼', '仓库', 0, 2, '第65负责人');
INSERT INTO `buildinfo` VALUES (73, 2, '第66凤凰楼', '物流站', 0, 294, '第66负责人');
INSERT INTO `buildinfo` VALUES (74, 2, '第67凤凰楼', '物流站', 0, 371, '第67负责人');
INSERT INTO `buildinfo` VALUES (75, 2, '第68凤凰楼', '公司', 1, 449, '第68负责人');
INSERT INTO `buildinfo` VALUES (76, 1, '第69凤凰楼', '公司', 1, 456, '第69负责人');
INSERT INTO `buildinfo` VALUES (77, 1, '第70凤凰楼', '公司', 0, 313, '第70负责人');
INSERT INTO `buildinfo` VALUES (78, 1, '第71凤凰楼', '物流站', 0, 491, '第71负责人');
INSERT INTO `buildinfo` VALUES (79, 2, '第72凤凰楼', '仓库', 0, 390, '第72负责人');
INSERT INTO `buildinfo` VALUES (80, 2, '第73凤凰楼', '仓库', 0, 135, '第73负责人');
INSERT INTO `buildinfo` VALUES (81, 1, '第74凤凰楼', '仓库', 0, 98, '第74负责人');
INSERT INTO `buildinfo` VALUES (82, 1, '第75凤凰楼', '公司', 0, 251, '第75负责人');
INSERT INTO `buildinfo` VALUES (83, 1, '第76凤凰楼', '仓库', 0, 225, '第76负责人');
INSERT INTO `buildinfo` VALUES (84, 3, '第77凤凰楼', '物流站', 0, 362, '第77负责人');
INSERT INTO `buildinfo` VALUES (85, 1, '第78凤凰楼', '物流站', 0, 433, '第78负责人');
INSERT INTO `buildinfo` VALUES (86, 3, '第79凤凰楼', '仓库', 1, 73, '第79负责人');
INSERT INTO `buildinfo` VALUES (87, 2, '第80凤凰楼', '物流站', 0, 170, '第80负责人');
INSERT INTO `buildinfo` VALUES (88, 3, '第81凤凰楼', '公司', 0, 74, '第81负责人');
INSERT INTO `buildinfo` VALUES (89, 3, '第82凤凰楼', '仓库', 0, 6, '第82负责人');
INSERT INTO `buildinfo` VALUES (90, 3, '第83凤凰楼', '物流站', 1, 256, '第83负责人');
INSERT INTO `buildinfo` VALUES (91, 3, '第84凤凰楼', '仓库', 0, 149, '第84负责人');
INSERT INTO `buildinfo` VALUES (92, 1, '第85凤凰楼', '公司', 0, 196, '第85负责人');
INSERT INTO `buildinfo` VALUES (93, 3, '第86凤凰楼', '仓库', 1, 10, '第86负责人');
INSERT INTO `buildinfo` VALUES (94, 2, '第87凤凰楼', '物流站', 0, 373, '第87负责人');
INSERT INTO `buildinfo` VALUES (95, 2, '第88凤凰楼', '公司', 0, 175, '第88负责人');
INSERT INTO `buildinfo` VALUES (96, 1, '第89凤凰楼', '仓库', 0, 292, '第89负责人');
INSERT INTO `buildinfo` VALUES (97, 3, '第90凤凰楼', '物流站', 0, 336, '第90负责人');
INSERT INTO `buildinfo` VALUES (98, 3, '第91凤凰楼', '仓库', 1, 468, '第91负责人');
INSERT INTO `buildinfo` VALUES (99, 3, '第92凤凰楼', '公司', 0, 397, '第92负责人');
INSERT INTO `buildinfo` VALUES (100, 3, '第93凤凰楼', '公司', 1, 131, '第93负责人');
INSERT INTO `buildinfo` VALUES (101, 1, '第94凤凰楼', '公司', 1, 439, '第94负责人');
INSERT INTO `buildinfo` VALUES (102, 1, '第95凤凰楼', '物流站', 0, 291, '第95负责人');
INSERT INTO `buildinfo` VALUES (103, 2, '第96凤凰楼', '公司', 0, 415, '第96负责人');
INSERT INTO `buildinfo` VALUES (104, 1, '第97凤凰楼', '仓库', 0, 413, '第97负责人');
INSERT INTO `buildinfo` VALUES (105, 2, '第98凤凰楼', '仓库', 1, 70, '第98负责人');
INSERT INTO `buildinfo` VALUES (106, 3, '第99凤凰楼', '仓库', 0, 373, '第99负责人');
INSERT INTO `buildinfo` VALUES (107, 1, '第100凤凰楼', '物流站', 1, 261, '第100负责人');

-- ----------------------------
-- Table structure for carchange
-- ----------------------------
DROP TABLE IF EXISTS `carchange`;
CREATE TABLE `carchange`  (
  `car_change_id` int(0) NOT NULL AUTO_INCREMENT,
  `car_id` int(0) NULL DEFAULT NULL,
  `car_change_type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `operation` int(0) NOT NULL,
  PRIMARY KEY (`car_change_id`) USING BTREE,
  INDEX `FK_Relationship_7`(`car_id`) USING BTREE,
  CONSTRAINT `FK_Relationship_7` FOREIGN KEY (`car_id`) REFERENCES `carinfo` (`car_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 43 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of carchange
-- ----------------------------
INSERT INTO `carchange` VALUES (1, 21, '货车', 0);
INSERT INTO `carchange` VALUES (2, 43, '货车', 0);
INSERT INTO `carchange` VALUES (3, 79, '货车', 1);
INSERT INTO `carchange` VALUES (4, 43, '货车', 0);
INSERT INTO `carchange` VALUES (5, 24, '货车', 0);
INSERT INTO `carchange` VALUES (6, 74, '货车', 1);
INSERT INTO `carchange` VALUES (7, 48, '货车', 0);
INSERT INTO `carchange` VALUES (8, 27, '货车', 1);
INSERT INTO `carchange` VALUES (9, 102, '货车', 1);
INSERT INTO `carchange` VALUES (10, 98, '货车', 1);
INSERT INTO `carchange` VALUES (11, 53, '货车', 0);
INSERT INTO `carchange` VALUES (12, 121, '货车', 0);
INSERT INTO `carchange` VALUES (13, 133, '货车', 0);
INSERT INTO `carchange` VALUES (14, 102, '货车', 1);
INSERT INTO `carchange` VALUES (15, 37, '货车', 1);
INSERT INTO `carchange` VALUES (16, 66, '货车', 0);
INSERT INTO `carchange` VALUES (17, 76, '货车', 1);
INSERT INTO `carchange` VALUES (18, 52, '货车', 1);
INSERT INTO `carchange` VALUES (19, 72, '货车', 0);
INSERT INTO `carchange` VALUES (20, 67, '货车', 0);
INSERT INTO `carchange` VALUES (21, 78, '货车', 0);
INSERT INTO `carchange` VALUES (22, 130, '货车', 1);
INSERT INTO `carchange` VALUES (23, 31, '货车', 0);
INSERT INTO `carchange` VALUES (24, 46, '货车', 0);
INSERT INTO `carchange` VALUES (25, 67, '货车', 0);
INSERT INTO `carchange` VALUES (26, 92, '货车', 1);
INSERT INTO `carchange` VALUES (27, 39, '货车', 1);
INSERT INTO `carchange` VALUES (28, 85, '货车', 1);
INSERT INTO `carchange` VALUES (29, 26, '货车', 1);
INSERT INTO `carchange` VALUES (30, 99, '货车', 1);
INSERT INTO `carchange` VALUES (31, 102, '货车', 0);
INSERT INTO `carchange` VALUES (32, 110, '货车', 1);
INSERT INTO `carchange` VALUES (34, 163, '皮卡', 1);
INSERT INTO `carchange` VALUES (36, 164, 'suv', 1);
INSERT INTO `carchange` VALUES (39, 169, '货车', 1);
INSERT INTO `carchange` VALUES (42, 171, '货车', 1);
INSERT INTO `carchange` VALUES (43, 172, '货车', 1);

-- ----------------------------
-- Table structure for carinfo
-- ----------------------------
DROP TABLE IF EXISTS `carinfo`;
CREATE TABLE `carinfo`  (
  `car_id` int(0) NOT NULL AUTO_INCREMENT,
  `car_number` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `car_style` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `car_load` decimal(10, 2) NULL DEFAULT NULL,
  `car_mileage` decimal(10, 2) NULL DEFAULT NULL,
  `car_brand` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`car_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 182 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of carinfo
-- ----------------------------
INSERT INTO `carinfo` VALUES (14, '渝AH5ST8', '货车', 19.00, 1363.00, 'JAC江淮');
INSERT INTO `carinfo` VALUES (15, '渝AA33FS', '货车', 12.00, 21865.00, 'ISUZU五十铃');
INSERT INTO `carinfo` VALUES (17, '渝A6SN94', '货车', 20.00, 10489.00, 'ISUZU五十铃');
INSERT INTO `carinfo` VALUES (18, '渝AHH36B', '货车', 4.00, 47885.00, '江铃汽车JMC');
INSERT INTO `carinfo` VALUES (19, '渝A45N07', '货车', 489.00, 12215.00, 'JAC江淮');
INSERT INTO `carinfo` VALUES (20, '渝AW12A0', '货车', 20.00, 43697.00, 'FOTON福田');
INSERT INTO `carinfo` VALUES (21, '渝A5MZ0B', '货车', 32.00, 6616.00, '长安');
INSERT INTO `carinfo` VALUES (22, '渝A8TRNA', '货车', 49.00, 5786.00, '江铃汽车JMC');
INSERT INTO `carinfo` VALUES (23, '渝A5V567', '货车', 35.00, 14588.00, '江铃汽车JMC');
INSERT INTO `carinfo` VALUES (24, '川A783UL', '货车', 23.00, 32277.00, 'DFM东风');
INSERT INTO `carinfo` VALUES (25, '川A423D7', '货车', 2.00, 20888.00, 'JAC江淮');
INSERT INTO `carinfo` VALUES (26, '川AP735B', '货车', 44.00, 3198.00, '一汽解放');
INSERT INTO `carinfo` VALUES (27, '川A7ZZ0P', '货车', 23.00, 5087.00, 'CNHTC中国重汽');
INSERT INTO `carinfo` VALUES (28, '川A552D0', '货车', 42.00, 17319.00, '长安');
INSERT INTO `carinfo` VALUES (29, '川AM6ZQM', '货车', 35.00, 35371.00, '长安');
INSERT INTO `carinfo` VALUES (30, '川A975MV', '货车', 9.00, 25023.00, '金杯');
INSERT INTO `carinfo` VALUES (31, '川AVM45G', '货车', 17.00, 20143.00, 'ISUZU五十铃');
INSERT INTO `carinfo` VALUES (32, '川AUR0MT', '货车', 35.00, 30043.00, '长安');
INSERT INTO `carinfo` VALUES (33, '川AB4171', '货车', 48.00, 15794.00, '江铃汽车JMC');
INSERT INTO `carinfo` VALUES (34, '湘A669R1', '货车', 4.00, 26076.00, '一汽解放');
INSERT INTO `carinfo` VALUES (35, '湘A7NGP8', '货车', 20.00, 43275.00, 'ISUZU五十铃');
INSERT INTO `carinfo` VALUES (36, '湘ADG16L', '货车', 8.00, 23338.00, 'DFM东风');
INSERT INTO `carinfo` VALUES (37, '湘AT3K46', '货车', 43.00, 45892.00, 'DFM东风');
INSERT INTO `carinfo` VALUES (38, '湘A60ZME', '货车', 45.00, 7655.00, '长安');
INSERT INTO `carinfo` VALUES (39, '湘A9NE93', '货车', 29.00, 14284.00, 'ISUZU五十铃');
INSERT INTO `carinfo` VALUES (40, '湘AMV407', '货车', 1.00, 46221.00, 'ISUZU五十铃');
INSERT INTO `carinfo` VALUES (41, '湘AUM67V', '货车', 16.00, 32793.00, 'CNHTC中国重汽');
INSERT INTO `carinfo` VALUES (42, '湘A6K775', '货车', 40.00, 10427.00, 'CNHTC中国重汽');
INSERT INTO `carinfo` VALUES (43, '湘AX5308', '货车', 18.00, 5596.00, '跃进');
INSERT INTO `carinfo` VALUES (44, '粤AJ9245', '货车', 49.00, 20206.00, 'CNHTC中国重汽');
INSERT INTO `carinfo` VALUES (45, '粤A08E2L', '货车', 43.00, 26541.00, 'JAC江淮');
INSERT INTO `carinfo` VALUES (46, '粤AD349S', '货车', 5.00, 4558.00, '一汽解放');
INSERT INTO `carinfo` VALUES (47, '粤AD4S4T', '货车', 28.00, 16601.00, '金杯');
INSERT INTO `carinfo` VALUES (48, '粤AWV77P', '货车', 32.00, 48254.00, '长安');
INSERT INTO `carinfo` VALUES (49, '粤A3MZ2N', '货车', 29.00, 8526.00, '跃进');
INSERT INTO `carinfo` VALUES (50, '粤AD8FE7', '货车', 7.00, 44611.00, '跃进');
INSERT INTO `carinfo` VALUES (51, '粤A05E54', '货车', 33.00, 40228.00, '金杯');
INSERT INTO `carinfo` VALUES (52, '粤A52A24', '货车', 4.00, 15644.00, 'ISUZU五十铃');
INSERT INTO `carinfo` VALUES (53, '粤A42L78', '货车', 6.00, 37252.00, '跃进');
INSERT INTO `carinfo` VALUES (54, '渝C3X6XC', '货车', 3.00, 31140.00, 'FOTON福田');
INSERT INTO `carinfo` VALUES (55, '渝CPT7L4', '货车', 40.00, 49282.00, '长安');
INSERT INTO `carinfo` VALUES (56, '渝C4ZA4L', '货车', 49.00, 14865.00, '跃进');
INSERT INTO `carinfo` VALUES (57, '渝CLU0B8', '货车', 39.00, 46723.00, 'FOTON福田');
INSERT INTO `carinfo` VALUES (58, '渝C792B6', '货车', 49.00, 4356.00, 'ISUZU五十铃');
INSERT INTO `carinfo` VALUES (59, '渝CN7Z19', '货车', 47.00, 13128.00, 'JAC江淮');
INSERT INTO `carinfo` VALUES (60, '渝C375BF', '货车', 15.00, 4856.00, '一汽解放');
INSERT INTO `carinfo` VALUES (61, '渝C907C5', '货车', 27.00, 49614.00, 'FOTON福田');
INSERT INTO `carinfo` VALUES (62, '渝C78VDJ', '货车', 2.00, 21900.00, '金杯');
INSERT INTO `carinfo` VALUES (63, '渝CA2X77', '货车', 35.00, 30177.00, '长安');
INSERT INTO `carinfo` VALUES (64, '渝BAAFW2', '货车', 2.00, 5775.00, '江铃汽车JMC');
INSERT INTO `carinfo` VALUES (65, '渝B5K433', '货车', 40.00, 6110.00, 'CNHTC中国重汽');
INSERT INTO `carinfo` VALUES (66, '渝BB6VJZ', '货车', 8.00, 32796.00, '江铃汽车JMC');
INSERT INTO `carinfo` VALUES (67, '渝BET39Q', '货车', 20.00, 23972.00, 'JAC江淮');
INSERT INTO `carinfo` VALUES (68, '渝B031D2', '货车', 22.00, 19844.00, 'JAC江淮');
INSERT INTO `carinfo` VALUES (69, '渝B034G8', '货车', 45.00, 33768.00, '跃进');
INSERT INTO `carinfo` VALUES (70, '渝B8Z16T', '货车', 23.00, 47297.00, 'CNHTC中国重汽');
INSERT INTO `carinfo` VALUES (71, '渝B10MHA', '货车', 35.00, 45412.00, '长安');
INSERT INTO `carinfo` VALUES (72, '渝B3XHS3', '货车', 22.00, 7830.00, 'FOTON福田');
INSERT INTO `carinfo` VALUES (74, '沪AY5K1H', '货车', 19.00, 17629.00, '长安');
INSERT INTO `carinfo` VALUES (75, '沪ACU2H6', '货车', 49.00, 36776.00, '跃进');
INSERT INTO `carinfo` VALUES (76, '沪AV905J', '货车', 0.00, 44276.00, '一汽解放');
INSERT INTO `carinfo` VALUES (77, '沪A9JZT4', '货车', 19.00, 16104.00, 'JAC江淮');
INSERT INTO `carinfo` VALUES (78, '沪AL585C', '货车', 22.00, 30831.00, '江铃汽车JMC');
INSERT INTO `carinfo` VALUES (79, '沪A5CTCY', '货车', 42.00, 14339.00, '跃进');
INSERT INTO `carinfo` VALUES (81, '沪AY2RFS', '货车', 28.00, 25646.00, '跃进');
INSERT INTO `carinfo` VALUES (82, '沪AG4B44', '货车', 26.00, 21179.00, 'JAC江淮');
INSERT INTO `carinfo` VALUES (83, '沪A96E71', '货车', 12.00, 16356.00, 'JAC江淮');
INSERT INTO `carinfo` VALUES (84, '鄂AR974K', '货车', 28.00, 22581.00, '金杯');
INSERT INTO `carinfo` VALUES (85, '鄂A9G19Q', '货车', 27.00, 26850.00, 'ISUZU五十铃');
INSERT INTO `carinfo` VALUES (86, '鄂ANC5EX', '货车', 1.00, 13033.00, 'FOTON福田');
INSERT INTO `carinfo` VALUES (87, '鄂AU5D8E', '货车', 10.00, 21211.00, 'FOTON福田');
INSERT INTO `carinfo` VALUES (88, '鄂AXK62X', '货车', 18.00, 42689.00, '长安');
INSERT INTO `carinfo` VALUES (89, '鄂AJ3VNM', '货车', 38.00, 25755.00, 'DFM东风');
INSERT INTO `carinfo` VALUES (90, '鄂AM9W7R', '货车', 35.00, 18870.00, 'FOTON福田');
INSERT INTO `carinfo` VALUES (91, '鄂AS3U05', '货车', 45.00, 38419.00, '长安');
INSERT INTO `carinfo` VALUES (92, '鄂AQ7090', '货车', 4.00, 16652.00, '跃进');
INSERT INTO `carinfo` VALUES (93, '鄂A0P930', '货车', 44.00, 8332.00, 'FOTON福田');
INSERT INTO `carinfo` VALUES (94, '京A6YYE6', '货车', 31.00, 48830.00, '江铃汽车JMC');
INSERT INTO `carinfo` VALUES (95, '京ACE5KM', '货车', 17.00, 11191.00, 'ISUZU五十铃');
INSERT INTO `carinfo` VALUES (96, '京A219T2', '货车', 25.00, 29697.00, 'DFM东风');
INSERT INTO `carinfo` VALUES (97, '京A00D4V', '货车', 35.00, 41179.00, '跃进');
INSERT INTO `carinfo` VALUES (98, '京A56923', '货车', 25.00, 28537.00, 'FOTON福田');
INSERT INTO `carinfo` VALUES (99, '京AZVU4W', '货车', 27.00, 26911.00, 'JAC江淮');
INSERT INTO `carinfo` VALUES (100, '京AUL248', '货车', 45.00, 5063.00, 'ISUZU五十铃');
INSERT INTO `carinfo` VALUES (101, '京AGL108', '货车', 10.00, 43778.00, 'FOTON福田');
INSERT INTO `carinfo` VALUES (102, '京A45H2P', '货车', 11.00, 16065.00, 'JAC江淮');
INSERT INTO `carinfo` VALUES (103, '京A2T4P4', '货车', 34.00, 46778.00, '金杯');
INSERT INTO `carinfo` VALUES (104, '赣AJSA1R', '货车', 7.00, 8324.00, '一汽解放');
INSERT INTO `carinfo` VALUES (105, '赣AVP2DW', '货车', 6.00, 33155.00, '长安');
INSERT INTO `carinfo` VALUES (106, '赣A1K5P6', '货车', 33.00, 27830.00, 'FOTON福田');
INSERT INTO `carinfo` VALUES (107, '赣A9899J', '货车', 39.00, 34314.00, 'DFM东风');
INSERT INTO `carinfo` VALUES (108, '赣AKQ07U', '货车', 47.00, 24504.00, '长安');
INSERT INTO `carinfo` VALUES (109, '赣AQZPLL', '货车', 6.00, 45680.00, '长安');
INSERT INTO `carinfo` VALUES (110, '赣A85235', '货车', 14.00, 12453.00, 'DFM东风');
INSERT INTO `carinfo` VALUES (111, '赣AZ4X91', '货车', 10.00, 6013.00, 'ISUZU五十铃');
INSERT INTO `carinfo` VALUES (112, '赣A499WE', '货车', 14.00, 38230.00, 'FOTON福田');
INSERT INTO `carinfo` VALUES (113, '赣A2XH2R', '货车', 23.00, 23408.00, '长安');
INSERT INTO `carinfo` VALUES (114, '桂ATR8J3', '货车', 27.00, 12213.00, 'CNHTC中国重汽');
INSERT INTO `carinfo` VALUES (115, '桂A6B4S8', '货车', 46.00, 26993.00, 'CNHTC中国重汽');
INSERT INTO `carinfo` VALUES (116, '桂A3HK2Z', '货车', 28.00, 49836.00, '金杯');
INSERT INTO `carinfo` VALUES (117, '桂AZE390', '货车', 29.00, 23738.00, '江铃汽车JMC');
INSERT INTO `carinfo` VALUES (118, '桂A01628', '货车', 19.00, 6052.00, '长安');
INSERT INTO `carinfo` VALUES (119, '桂AD8133', '货车', 19.00, 15385.00, 'CNHTC中国重汽');
INSERT INTO `carinfo` VALUES (120, '桂AY1KT8', '货车', 210.00, 39310.00, 'DFM东风');
INSERT INTO `carinfo` VALUES (121, '桂ARW65P', '货车', 12.00, 22683.00, 'ISUZU五十铃');
INSERT INTO `carinfo` VALUES (122, '桂AUZR60', '货车', 17.00, 9296.00, 'ISUZU五十铃');
INSERT INTO `carinfo` VALUES (123, '桂AQHJMZ', '货车', 42.00, 29379.00, '一汽解放');
INSERT INTO `carinfo` VALUES (124, '冀AESDW0', '货车', 0.00, 21969.00, 'JAC江淮');
INSERT INTO `carinfo` VALUES (125, '冀A6M7Z1', '货车', 40.00, 15066.00, 'DFM东风');
INSERT INTO `carinfo` VALUES (126, '冀ABY4B4', '货车', 13.00, 30244.00, '长安');
INSERT INTO `carinfo` VALUES (127, '冀A2YV45', '货车', 21.00, 14663.00, 'CNHTC中国重汽');
INSERT INTO `carinfo` VALUES (128, '冀AN7GLH', '货车', 5.00, 7461.00, '长安');
INSERT INTO `carinfo` VALUES (129, '冀AX819M', '货车', 33.00, 46066.00, '金杯');
INSERT INTO `carinfo` VALUES (130, '冀AMNEAN', '货车', 22.00, 20839.00, '一汽解放');
INSERT INTO `carinfo` VALUES (131, '冀AR2R71', '货车', 1.00, 1788.00, 'FOTON福田');
INSERT INTO `carinfo` VALUES (132, '冀AP9T94', '货车', 25.00, 39744.00, 'ISUZU五十铃');
INSERT INTO `carinfo` VALUES (133, '冀A03Z7F', '货车', 17.00, 30974.00, '一汽解放');
INSERT INTO `carinfo` VALUES (134, '苏AQ7T54', '货车', 35.00, 39240.00, '长安');
INSERT INTO `carinfo` VALUES (135, '苏AK752M', '货车', 2.00, 474.00, 'FOTON福田');
INSERT INTO `carinfo` VALUES (136, '苏AUFA5M', '货车', 22.00, 37633.00, '跃进');
INSERT INTO `carinfo` VALUES (137, '苏A24FSC', '货车', 4.00, 9078.00, 'ISUZU五十铃');
INSERT INTO `carinfo` VALUES (138, '苏AA6173', '货车', 26.00, 41535.00, 'DFM东风');
INSERT INTO `carinfo` VALUES (139, '苏AHM1NS', '货车', 15.00, 8673.00, 'CNHTC中国重汽');
INSERT INTO `carinfo` VALUES (140, '苏A01059', '货车', 36.00, 33672.00, '金杯');
INSERT INTO `carinfo` VALUES (141, '苏A14K20', '货车', 26.00, 5057.00, 'JAC江淮');
INSERT INTO `carinfo` VALUES (142, '苏A3K29T', '货车', 16.00, 42356.00, '跃进');
INSERT INTO `carinfo` VALUES (143, '苏A54569', '货车', 15.00, 11966.00, 'JAC江淮');
INSERT INTO `carinfo` VALUES (144, '鲁AV84CL', '货车', 26.00, 18400.00, 'ISUZU五十铃');
INSERT INTO `carinfo` VALUES (145, '鲁AN1K6L', '货车', 30.00, 14860.00, 'FOTON福田');
INSERT INTO `carinfo` VALUES (146, '鲁A528NW', '货车', 43.00, 20017.00, 'CNHTC中国重汽');
INSERT INTO `carinfo` VALUES (147, '鲁AT7H2L', '货车', 19.00, 49076.00, '长安');
INSERT INTO `carinfo` VALUES (148, '鲁AG1XQ3', '货车', 27.00, 22255.00, '江铃汽车JMC');
INSERT INTO `carinfo` VALUES (149, '鲁AJAXL4', '货车', 20.00, 29223.00, '一汽解放');
INSERT INTO `carinfo` VALUES (150, '鲁AL082C', '货车', 12.00, 32137.00, 'JAC江淮');
INSERT INTO `carinfo` VALUES (151, '鲁APY08Z', '货车', 22.00, 43602.00, '长安');
INSERT INTO `carinfo` VALUES (152, '鲁APBTD2', '货车', 29.00, 5167.00, 'JAC江淮');
INSERT INTO `carinfo` VALUES (153, '鲁A1U633', '货车', 29.00, 3753.00, 'CNHTC中国重汽');
INSERT INTO `carinfo` VALUES (154, '渝A66666', '货车', 50.00, 12600.00, 'JAC江淮');
INSERT INTO `carinfo` VALUES (161, '黑', '123', 123.00, 123.00, '123');
INSERT INTO `carinfo` VALUES (163, '川A58WSB', '皮卡', 10.00, 100.00, '长安');
INSERT INTO `carinfo` VALUES (164, '渝D6A888', 'suv', 8.00, 1000.00, '大众');
INSERT INTO `carinfo` VALUES (165, '0.0.10', '10', 10.00, 10.00, '10');
INSERT INTO `carinfo` VALUES (166, 'asdfsdfasdf', '', NULL, NULL, '');
INSERT INTO `carinfo` VALUES (167, '123456', '哈哈哈', 123.00, 123.00, '去微软');
INSERT INTO `carinfo` VALUES (168, '45612', '风格和', 123.00, 123.00, '亚热带');
INSERT INTO `carinfo` VALUES (169, '川DAE868', '货车', 24.00, 1231.00, '东风');
INSERT INTO `carinfo` VALUES (170, '123', '丰田', 12.00, 123.00, '123');
INSERT INTO `carinfo` VALUES (171, '渝AH5ST8', '货车', 100.00, 1000.00, 'JAC江淮');
INSERT INTO `carinfo` VALUES (172, '渝AH5ST8', '货车', 200.00, 2000.00, 'JAC江淮');
INSERT INTO `carinfo` VALUES (173, '陕AS43KC', '货车', 11.00, 8881.00, '长安');
INSERT INTO `carinfo` VALUES (174, '陕A40K1B', '货车', 13.00, 21876.00, 'DFM东风');
INSERT INTO `carinfo` VALUES (175, '陕ACZ6H4', '货车', 40.00, 2203.00, 'ISUZU五十铃');
INSERT INTO `carinfo` VALUES (176, '陕A787Q2', '货车', 33.00, 7987.00, 'DFM东风');
INSERT INTO `carinfo` VALUES (177, '陕AS3ETQ', '货车', 40.00, 17670.00, '一汽解放');
INSERT INTO `carinfo` VALUES (178, '陕AT932E', '货车', 15.00, 15020.00, 'CNHTC中国重汽');
INSERT INTO `carinfo` VALUES (179, '陕A220GR', '货车', 49.00, 38557.00, 'JAC江淮');
INSERT INTO `carinfo` VALUES (180, '陕AK0L08', '货车', 25.00, 47613.00, 'ISUZU五十铃');
INSERT INTO `carinfo` VALUES (181, '陕AC181X', '货车', 42.00, 782.00, '长安');
INSERT INTO `carinfo` VALUES (182, '陕A20U81', '货车', 26.00, 26525.00, 'JAC江淮');

-- ----------------------------
-- Table structure for certificateinfo
-- ----------------------------
DROP TABLE IF EXISTS `certificateinfo`;
CREATE TABLE `certificateinfo`  (
  `certificate_id` int(0) NOT NULL AUTO_INCREMENT,
  `employee_id` int(0) NULL DEFAULT NULL,
  `certificate_code` int(0) NULL DEFAULT NULL,
  `certificate_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `certificate_start_time` date NULL DEFAULT NULL,
  `certificate_end_time` date NULL DEFAULT NULL,
  `certificate_agent` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`certificate_id`) USING BTREE,
  INDEX `FK_qwe`(`employee_id`) USING BTREE,
  CONSTRAINT `FK_qwe` FOREIGN KEY (`employee_id`) REFERENCES `employeeinfo` (`employee_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1042 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of certificateinfo
-- ----------------------------
INSERT INTO `certificateinfo` VALUES (1030, 34, 1101, '结婚证', '2022-06-26', '2026-06-23', '民政局');
INSERT INTO `certificateinfo` VALUES (1031, 35, 1011, '身份证', '2022-06-26', '2023-06-06', '法院');
INSERT INTO `certificateinfo` VALUES (1032, NULL, NULL, '', NULL, NULL, '');
INSERT INTO `certificateinfo` VALUES (1042, 50, 5, '许可证', '2022-07-08', '2022-07-08', '重庆大学');

-- ----------------------------
-- Table structure for communicationinfo
-- ----------------------------
DROP TABLE IF EXISTS `communicationinfo`;
CREATE TABLE `communicationinfo`  (
  `communication_id` int(0) NOT NULL AUTO_INCREMENT,
  `employee_id` int(0) NULL DEFAULT NULL,
  `communication_title` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `communication_context` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `communication_time` date NULL DEFAULT NULL,
  PRIMARY KEY (`communication_id`) USING BTREE,
  INDEX `FK_fabu`(`employee_id`) USING BTREE,
  CONSTRAINT `FK_fabu` FOREIGN KEY (`employee_id`) REFERENCES `employeeinfo` (`employee_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 72 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of communicationinfo
-- ----------------------------
INSERT INTO `communicationinfo` VALUES (7, 57, '伙挨打的份2', '疽哈', '2022-05-11');
INSERT INTO `communicationinfo` VALUES (8, 34, '须', '允er', '2022-05-11');
INSERT INTO `communicationinfo` VALUES (9, 34, '筷', '抉', '2022-05-11');
INSERT INTO `communicationinfo` VALUES (10, 34, '嚏', '寡', '2022-05-11');
INSERT INTO `communicationinfo` VALUES (11, 34, '贫', '锡', '2022-05-11');
INSERT INTO `communicationinfo` VALUES (12, 34, '倚', '训', '2022-05-11');
INSERT INTO `communicationinfo` VALUES (13, 34, '燕', '蔡', '2022-05-11');
INSERT INTO `communicationinfo` VALUES (14, 34, '侄', '衡', '2022-05-11');
INSERT INTO `communicationinfo` VALUES (15, 34, '屁', '养', '2022-05-11');
INSERT INTO `communicationinfo` VALUES (16, 34, '乡', '钳', '2022-05-11');
INSERT INTO `communicationinfo` VALUES (17, 34, '随', '拜', '2022-05-11');
INSERT INTO `communicationinfo` VALUES (18, 34, '牵', '壕', '2022-05-11');
INSERT INTO `communicationinfo` VALUES (19, 34, '谰', '圃', '2022-05-11');
INSERT INTO `communicationinfo` VALUES (20, 34, '杏', '稽', '2022-05-11');
INSERT INTO `communicationinfo` VALUES (21, 34, '窃', '绽', '2022-05-11');
INSERT INTO `communicationinfo` VALUES (22, 34, '叶', '蠢', '2022-05-11');
INSERT INTO `communicationinfo` VALUES (23, 34, '版', '囚', '2022-05-11');
INSERT INTO `communicationinfo` VALUES (24, 34, '凄', '玻', '2022-05-11');
INSERT INTO `communicationinfo` VALUES (25, 34, '123', '掏', '2022-05-11');
INSERT INTO `communicationinfo` VALUES (26, 34, '潍', '媚', '2022-05-11');
INSERT INTO `communicationinfo` VALUES (27, 34, '畦', '砌', '2022-05-11');
INSERT INTO `communicationinfo` VALUES (28, 34, '递', '届', '2022-05-11');
INSERT INTO `communicationinfo` VALUES (29, 34, '党', '茎', '2022-05-11');
INSERT INTO `communicationinfo` VALUES (30, 34, '塘', '费', '2022-05-11');
INSERT INTO `communicationinfo` VALUES (31, 34, '驭', '惠', '2022-05-11');
INSERT INTO `communicationinfo` VALUES (32, 34, '忽', '苏', '2022-05-11');
INSERT INTO `communicationinfo` VALUES (33, 34, '叛', '浑', '2022-05-11');
INSERT INTO `communicationinfo` VALUES (34, 34, '磺', '垛', '2022-05-11');
INSERT INTO `communicationinfo` VALUES (35, 34, '厌', '糯', '2022-05-11');
INSERT INTO `communicationinfo` VALUES (36, 34, '谷', '枚', '2022-05-11');
INSERT INTO `communicationinfo` VALUES (37, 34, '碱', '喝', '2022-05-11');
INSERT INTO `communicationinfo` VALUES (38, 34, '水', '歉', '2022-05-11');
INSERT INTO `communicationinfo` VALUES (39, 34, '亩', '丑', '2022-05-11');
INSERT INTO `communicationinfo` VALUES (40, 34, '牧', '差', '2022-05-11');
INSERT INTO `communicationinfo` VALUES (41, 34, '弱', '踊', '2022-05-11');
INSERT INTO `communicationinfo` VALUES (42, 34, '爹', '奠', '2022-05-11');
INSERT INTO `communicationinfo` VALUES (43, 34, '越', '执', '2022-05-11');
INSERT INTO `communicationinfo` VALUES (44, 34, '卢', '嚣', '2022-05-11');
INSERT INTO `communicationinfo` VALUES (45, 34, '啤', '奈', '2022-05-11');
INSERT INTO `communicationinfo` VALUES (46, 34, '乌', '嫡', '2022-05-11');
INSERT INTO `communicationinfo` VALUES (47, 34, '于', '虾', '2022-05-11');
INSERT INTO `communicationinfo` VALUES (48, 34, '返', '识', '2022-05-11');
INSERT INTO `communicationinfo` VALUES (49, 34, '样', '肮', '2022-05-11');
INSERT INTO `communicationinfo` VALUES (50, 34, '洱', '胸', '2022-05-11');
INSERT INTO `communicationinfo` VALUES (51, 34, '峰', '杨', '2022-05-11');
INSERT INTO `communicationinfo` VALUES (52, 34, '砷', '磷', '2022-05-11');
INSERT INTO `communicationinfo` VALUES (53, 34, '功', '巴', '2022-05-11');
INSERT INTO `communicationinfo` VALUES (54, 34, '享', '韦', '2022-05-11');
INSERT INTO `communicationinfo` VALUES (55, 34, '栖', '捏', '2022-05-11');
INSERT INTO `communicationinfo` VALUES (56, 34, '囤', '眩', '2022-05-11');
INSERT INTO `communicationinfo` VALUES (57, 34, '蔑', '等', '2022-05-11');
INSERT INTO `communicationinfo` VALUES (58, 34, '王', '连', '2022-05-11');
INSERT INTO `communicationinfo` VALUES (59, 34, '沼', '及', '2022-05-11');
INSERT INTO `communicationinfo` VALUES (60, 34, '错', '颂', '2022-05-11');
INSERT INTO `communicationinfo` VALUES (61, 34, '峙', '肿', '2022-05-11');
INSERT INTO `communicationinfo` VALUES (62, 34, '驱', '选', '2022-05-11');
INSERT INTO `communicationinfo` VALUES (63, 34, '街', '采', '2022-05-11');
INSERT INTO `communicationinfo` VALUES (64, 34, '偿', '掘', '2022-05-11');
INSERT INTO `communicationinfo` VALUES (65, NULL, '哈', '哈哈哈123', '2022-06-06');
INSERT INTO `communicationinfo` VALUES (72, 54, '哈哈哈', '哈哈哈', '2022-07-04');

-- ----------------------------
-- Table structure for companyinfo
-- ----------------------------
DROP TABLE IF EXISTS `companyinfo`;
CREATE TABLE `companyinfo`  (
  `company_id` int(0) NOT NULL AUTO_INCREMENT,
  `company_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `company_time` date NULL DEFAULT NULL,
  `company_city` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `company_number` int(0) NULL DEFAULT NULL,
  `company_webside` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `company_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `company_person` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `company_mobile` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`company_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 202 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of companyinfo
-- ----------------------------
INSERT INTO `companyinfo` VALUES (1, '攀枝花物流公司', '2022-06-24', '深圳', 1364, 'pls.com', '101', 'dym', '19923860123');
INSERT INTO `companyinfo` VALUES (2, '虎牙', '2022-06-01', '重庆', 1000, 'huya.com', '102', 'dym', '19946434836');
INSERT INTO `companyinfo` VALUES (4, '抖音', '2001-03-06', '北京', 1234, 'douyin.com', '103', 'afdaf', '1237183712');
INSERT INTO `companyinfo` VALUES (5, '天启技术', '2022-06-28', '吕梁市', 999, 'www.baidu.com', 'code0', 'wlt', '13982316547');
INSERT INTO `companyinfo` VALUES (6, '保利联合', '2022-06-28', '大同市', 1001, 'www.baidu.com', 'code1', 'qf', '13982316547');
INSERT INTO `companyinfo` VALUES (7, '斗鱼', '2022-06-28', '阳泉市', 1003, 'douyu.com', 'code2', 'dym', '13982316547');
INSERT INTO `companyinfo` VALUES (8, '粤水电', '2022-06-10', '唐山市', 1005, 'www.woshi250.com', 'code3', 'qf', '13982316547');
INSERT INTO `companyinfo` VALUES (9, 'test公司4', '2022-06-01', '晋城市', 1007, 'www.baidu.com', 'code4', 'fzg', '13982316547');
INSERT INTO `companyinfo` VALUES (10, 'test公司5', '2022-06-08', '巴彦淖尔市', 1009, 'www.baidu.com', 'code5', 'wlt', '13982316547');
INSERT INTO `companyinfo` VALUES (11, 'test公司6', '2022-06-16', '太原市', 1011, 'www.baidu.com', 'code6', 'wlt', '13982316547');
INSERT INTO `companyinfo` VALUES (12, 'test公司7', '2022-06-28', '阳泉市', 1013, 'www.baidu.com', 'code7', 'qf', '13982316547');
INSERT INTO `companyinfo` VALUES (13, 'test公司8', '2022-06-28', '吕梁市', 1015, 'www.baidu.com', 'code8', 'fzg', '13982316547');
INSERT INTO `companyinfo` VALUES (14, 'test公司9', '2022-06-28', '呼和浩特市', 1017, 'www.baidu.com', 'code9', 'fzg', '13982316547');
INSERT INTO `companyinfo` VALUES (15, 'test公司10', '2022-06-28', '衡水市', 1019, 'www.baidu.com', 'code10', 'qf', '13982316547');
INSERT INTO `companyinfo` VALUES (16, 'test公司11', '2022-06-28', '兴安盟', 1021, 'www.baidu.com', 'code11', 'fzg', '13982316547');
INSERT INTO `companyinfo` VALUES (17, 'test公司12', '2022-06-28', '晋中市', 1023, 'www.baidu.com', 'code12', 'wlt', '13982316547');
INSERT INTO `companyinfo` VALUES (18, 'test公司13', '2022-06-28', '省直辖县', 1025, 'www.baidu.com', 'code13', 'dym', '13982316547');
INSERT INTO `companyinfo` VALUES (19, 'test公司14', '2022-06-28', '石家庄市', 1027, 'www.baidu.com', 'code14', 'fzg', '13982316547');
INSERT INTO `companyinfo` VALUES (20, 'test公司15', '2022-06-28', '廊坊市', 1029, 'www.baidu.com', 'code15', 'wlt', '13982316547');
INSERT INTO `companyinfo` VALUES (21, 'test公司16', '2022-06-28', '乌兰察布市', 1031, 'www.baidu.com', 'code16', 'dym', '13982316547');
INSERT INTO `companyinfo` VALUES (22, 'test公司17', '2022-06-28', '阿拉善盟', 1033, 'www.baidu.com', 'code17', 'wyh', '13982316547');
INSERT INTO `companyinfo` VALUES (23, 'test公司18', '2022-06-28', '巴彦淖尔市', 1035, 'www.baidu.com', 'code18', 'wlt', '13982316547');
INSERT INTO `companyinfo` VALUES (24, 'test公司19', '2022-06-28', '晋中市', 1037, 'www.baidu.com', 'code19', 'dym', '13982316547');
INSERT INTO `companyinfo` VALUES (25, 'test公司20', '2022-06-28', '运城市', 1039, 'www.baidu.com', 'code20', 'wlt', '13982316547');
INSERT INTO `companyinfo` VALUES (26, 'test公司21', '2022-06-28', '承德市', 1041, 'www.baidu.com', 'code21', 'qf', '13982316547');
INSERT INTO `companyinfo` VALUES (27, 'test公司22', '2022-06-28', '保定市', 1043, 'www.baidu.com', 'code22', 'fzg', '13982316547');
INSERT INTO `companyinfo` VALUES (28, 'test公司23', '2022-06-28', '邯郸市', 1045, 'www.baidu.com', 'code23', 'wlt', '13982316547');
INSERT INTO `companyinfo` VALUES (29, 'test公司24', '2022-06-28', '晋城市', 1047, 'www.baidu.com', 'code24', 'wlt', '13982316547');
INSERT INTO `companyinfo` VALUES (30, 'test公司25', '2022-06-28', '临汾市', 1049, 'www.baidu.com', 'code25', 'dym', '13982316547');
INSERT INTO `companyinfo` VALUES (31, 'test公司26', '2022-06-28', '巴彦淖尔市', 1051, 'www.baidu.com', 'code26', 'dym', '13982316547');
INSERT INTO `companyinfo` VALUES (32, 'test公司27', '2022-06-28', '锡林郭勒盟', 1053, 'www.baidu.com', 'code27', 'dym', '13982316547');
INSERT INTO `companyinfo` VALUES (33, 'test公司28', '2022-06-28', '上海', 1055, 'www.baidu.com', 'code28', 'wyh', '13982316547');
INSERT INTO `companyinfo` VALUES (34, 'test公司29', '2022-06-28', '石家庄市', 1057, 'www.baidu.com', 'code29', 'dym', '13982316547');
INSERT INTO `companyinfo` VALUES (35, 'test公司30', '2022-06-28', '乌兰察布市', 1059, 'www.baidu.com', 'code30', 'qf', '13982316547');
INSERT INTO `companyinfo` VALUES (36, 'test公司31', '2022-06-28', '巴彦淖尔市', 1061, 'www.baidu.com', 'code31', 'wlt', '13982316547');
INSERT INTO `companyinfo` VALUES (37, 'test公司32', '2022-06-28', '大同市', 1063, 'www.baidu.com', 'code32', 'fzg', '13982316547');
INSERT INTO `companyinfo` VALUES (38, 'test公司33', '2022-06-28', '省直辖县', 1065, 'www.baidu.com', 'code33', 'qf', '13982316547');
INSERT INTO `companyinfo` VALUES (39, 'test公司34', '2022-06-28', '呼伦贝尔市', 1067, 'www.baidu.com', 'code34', 'qf', '13982316547');
INSERT INTO `companyinfo` VALUES (40, 'test公司35', '2022-06-28', '沧州市', 1069, 'www.baidu.com', 'code35', 'fzg', '13982316547');
INSERT INTO `companyinfo` VALUES (41, 'test公司36', '2022-06-28', '长治市', 1071, 'www.baidu.com', 'code36', 'dym', '13982316547');
INSERT INTO `companyinfo` VALUES (42, 'test公司37', '2022-06-28', '通辽市', 1073, 'www.baidu.com', 'code37', 'dym', '13982316547');
INSERT INTO `companyinfo` VALUES (43, 'test公司38', '2022-06-28', '沧州市', 1075, 'www.baidu.com', 'code38', 'fzg', '13982316547');
INSERT INTO `companyinfo` VALUES (44, 'test公司39', '2022-06-28', '秦皇岛市', 1077, 'www.baidu.com', 'code39', 'wyh', '13982316547');
INSERT INTO `companyinfo` VALUES (45, 'test公司40', '2022-06-28', '省直辖县', 1079, 'www.baidu.com', 'code40', 'fzg', '13982316547');
INSERT INTO `companyinfo` VALUES (46, 'test公司41', '2022-06-28', '唐山市', 1081, 'www.baidu.com', 'code41', 'wyh', '13982316547');
INSERT INTO `companyinfo` VALUES (47, 'test公司42', '2022-06-28', '晋中市', 1083, 'www.baidu.com', 'code42', 'wlt', '13982316547');
INSERT INTO `companyinfo` VALUES (48, 'test公司43', '2022-06-28', '鞍山市', 1085, 'www.baidu.com', 'code43', 'dym', '13982316547');
INSERT INTO `companyinfo` VALUES (49, 'test公司44', '2022-06-28', '太原市', 1087, 'www.baidu.com', 'code44', 'qf', '13982316547');
INSERT INTO `companyinfo` VALUES (50, 'test公司45', '2022-06-28', '石家庄市', 1089, 'www.baidu.com', 'code45', 'wlt', '13982316547');
INSERT INTO `companyinfo` VALUES (51, 'test公司46', '2022-06-28', '呼伦贝尔市', 1091, 'www.baidu.com', 'code46', 'dym', '13982316547');
INSERT INTO `companyinfo` VALUES (52, 'test公司47', '2022-06-28', '省直辖县', 1093, 'www.baidu.com', 'code47', 'fzg', '13982316547');
INSERT INTO `companyinfo` VALUES (53, 'test公司48', '2022-06-28', '廊坊市', 1095, 'www.baidu.com', 'code48', 'fzg', '13982316547');
INSERT INTO `companyinfo` VALUES (54, 'test公司49', '2022-06-28', '重庆', 1097, 'www.baidu.com', 'code49', 'dym', '13982316547');
INSERT INTO `companyinfo` VALUES (55, 'test公司50', '2022-06-28', '唐山市', 1099, 'www.baidu.com', 'code50', 'dym', '13982316547');
INSERT INTO `companyinfo` VALUES (56, 'test公司51', '2022-06-28', '北京市', 1101, 'www.baidu.com', 'code51', 'wyh', '13982316547');
INSERT INTO `companyinfo` VALUES (57, 'test公司52', '2022-06-28', '沈阳市', 1103, 'www.baidu.com', 'code52', 'fzg', '13982316547');
INSERT INTO `companyinfo` VALUES (58, 'test公司53', '2022-06-28', '阳泉市', 1105, 'www.baidu.com', 'code53', 'wyh', '13982316547');
INSERT INTO `companyinfo` VALUES (59, 'test公司54', '2022-06-28', '乌兰察布市', 1107, 'www.baidu.com', 'code54', 'fzg', '13982316547');
INSERT INTO `companyinfo` VALUES (60, 'test公司55', '2022-06-28', '邢台市', 1109, 'www.baidu.com', 'code55', 'fzg', '13982316547');
INSERT INTO `companyinfo` VALUES (61, 'test公司56', '2022-06-28', '赤峰市', 1111, 'www.baidu.com', 'code56', 'wlt', '13982316547');
INSERT INTO `companyinfo` VALUES (62, 'test公司57', '2022-06-28', '朔州市', 1113, 'www.baidu.com', 'code57', 'qf', '13982316547');
INSERT INTO `companyinfo` VALUES (63, 'test公司58', '2022-06-28', '保定市', 1115, 'www.baidu.com', 'code58', 'qf', '13982316547');
INSERT INTO `companyinfo` VALUES (64, 'test公司59', '2022-06-28', '锡林郭勒盟', 1117, 'www.baidu.com', 'code59', 'wlt', '13982316547');
INSERT INTO `companyinfo` VALUES (65, 'test公司60', '2022-06-28', '重庆', 1119, 'www.baidu.com', 'code60', 'qf', '13982316547');
INSERT INTO `companyinfo` VALUES (66, 'test公司61', '2022-06-28', '石家庄市', 1121, 'www.baidu.com', 'code61', 'qf', '13982316547');
INSERT INTO `companyinfo` VALUES (67, 'test公司62', '2022-06-28', '兴安盟', 1123, 'www.baidu.com', 'code62', 'wlt', '13982316547');
INSERT INTO `companyinfo` VALUES (68, 'test公司63', '2022-06-28', '北京市', 1125, 'www.baidu.com', 'code63', 'qf', '13982316547');
INSERT INTO `companyinfo` VALUES (69, 'test公司64', '2022-06-28', '太原市', 1127, 'www.baidu.com', 'code64', 'wyh', '13982316547');
INSERT INTO `companyinfo` VALUES (70, 'test公司65', '2022-06-28', '赤峰市', 1129, 'www.baidu.com', 'code65', 'wlt', '13982316547');
INSERT INTO `companyinfo` VALUES (71, 'test公司66', '2022-06-28', '阿拉善盟', 1131, 'www.baidu.com', 'code66', 'qf', '13982316547');
INSERT INTO `companyinfo` VALUES (72, 'test公司67', '2022-06-28', '北京市', 1133, 'www.baidu.com', 'code67', 'wlt', '13982316547');
INSERT INTO `companyinfo` VALUES (73, 'test公司68', '2022-06-28', '沧州市', 1135, 'www.baidu.com', 'code68', 'qf', '13982316547');
INSERT INTO `companyinfo` VALUES (74, 'test公司69', '2022-06-28', '沧州市', 1137, 'www.baidu.com', 'code69', 'wlt', '13982316547');
INSERT INTO `companyinfo` VALUES (75, 'test公司70', '2022-06-28', '沈阳市', 1139, 'www.baidu.com', 'code70', 'qf', '13982316547');
INSERT INTO `companyinfo` VALUES (76, 'test公司71', '2022-06-28', '赤峰市', 1141, 'www.baidu.com', 'code71', 'dym', '13982316547');
INSERT INTO `companyinfo` VALUES (77, 'test公司72', '2022-06-28', '太原市', 1143, 'www.baidu.com', 'code72', 'fzg', '13982316547');
INSERT INTO `companyinfo` VALUES (78, 'test公司73', '2022-06-28', '石家庄市', 1145, 'www.baidu.com', 'code73', 'wlt', '13982316547');
INSERT INTO `companyinfo` VALUES (79, 'test公司74', '2022-06-28', '临汾市', 1147, 'www.baidu.com', 'code74', 'fzg', '13982316547');
INSERT INTO `companyinfo` VALUES (80, 'test公司75', '2022-06-28', '运城市', 1149, 'www.baidu.com', 'code75', 'fzg', '13982316547');
INSERT INTO `companyinfo` VALUES (81, 'test公司76', '2022-06-28', '吕梁市', 1151, 'www.baidu.com', 'code76', 'fzg', '13982316547');
INSERT INTO `companyinfo` VALUES (82, 'test公司77', '2022-06-28', '上海', 1153, 'www.baidu.com', 'code77', 'wlt', '13982316547');
INSERT INTO `companyinfo` VALUES (83, 'test公司78', '2022-06-28', '朔州市', 1155, 'www.baidu.com', 'code78', 'dym', '13982316547');
INSERT INTO `companyinfo` VALUES (84, 'test公司79', '2022-06-28', '邢台市', 1157, 'www.baidu.com', 'code79', 'qf', '13982316547');
INSERT INTO `companyinfo` VALUES (85, 'test公司80', '2022-06-28', '兴安盟', 1159, 'www.baidu.com', 'code80', 'fzg', '13982316547');
INSERT INTO `companyinfo` VALUES (86, 'test公司81', '2022-06-28', '朔州市', 1161, 'www.baidu.com', 'code81', 'wlt', '13982316547');
INSERT INTO `companyinfo` VALUES (87, 'test公司82', '2022-06-28', '乌海市', 1163, 'www.baidu.com', 'code82', 'wlt', '13982316547');
INSERT INTO `companyinfo` VALUES (88, 'test公司83', '2022-06-28', '衡水市', 1165, 'www.baidu.com', 'code83', 'wyh', '13982316547');
INSERT INTO `companyinfo` VALUES (89, 'test公司84', '2022-06-28', '省直辖县', 1167, 'www.baidu.com', 'code84', 'wyh', '13982316547');
INSERT INTO `companyinfo` VALUES (90, 'test公司85', '2022-06-28', '赤峰市', 1169, 'www.baidu.com', 'code85', 'wyh', '13982316547');
INSERT INTO `companyinfo` VALUES (91, 'test公司86', '2022-06-28', '大连市', 1171, 'www.baidu.com', 'code86', 'wyh', '13982316547');
INSERT INTO `companyinfo` VALUES (92, 'test公司87', '2022-06-28', '唐山市', 1173, 'www.baidu.com', 'code87', 'qf', '13982316547');
INSERT INTO `companyinfo` VALUES (93, 'test公司88', '2022-06-28', '阿拉善盟', 1175, 'www.baidu.com', 'code88', 'wyh', '13982316547');
INSERT INTO `companyinfo` VALUES (94, 'test公司89', '2022-06-28', '运城市', 1177, 'www.baidu.com', 'code89', 'wlt', '13982316547');
INSERT INTO `companyinfo` VALUES (95, 'test公司90', '2022-06-28', '呼和浩特市', 1179, 'www.baidu.com', 'code90', 'fzg', '13982316547');
INSERT INTO `companyinfo` VALUES (96, 'test公司91', '2022-06-28', '晋中市', 1181, 'www.baidu.com', 'code91', 'fzg', '13982316547');
INSERT INTO `companyinfo` VALUES (97, 'test公司92', '2022-06-28', '天津市', 1183, 'www.baidu.com', 'code92', 'wlt', '13982316547');
INSERT INTO `companyinfo` VALUES (98, 'test公司93', '2022-06-28', '省直辖县', 1185, 'www.baidu.com', 'code93', 'qf', '13982316547');
INSERT INTO `companyinfo` VALUES (99, 'test公司94', '2022-06-28', '吕梁市', 1187, 'www.baidu.com', 'code94', 'qf', '13982316547');
INSERT INTO `companyinfo` VALUES (100, 'test公司95', '2022-06-28', '北京市', 1189, 'www.baidu.com', 'code95', 'fzg', '13982316547');
INSERT INTO `companyinfo` VALUES (101, 'test公司96', '2022-06-28', '沈阳市', 1191, 'www.baidu.com', 'code96', 'fzg', '13982316547');
INSERT INTO `companyinfo` VALUES (102, 'test公司97', '2022-06-28', '重庆', 1193, 'www.baidu.com', 'code97', 'qf', '13982316547');
INSERT INTO `companyinfo` VALUES (103, 'test公司98', '2022-06-28', '乌海市', 1195, 'www.baidu.com', 'code98', 'wlt', '13982316547');
INSERT INTO `companyinfo` VALUES (104, 'test公司99', '2022-06-28', '唐山市', 1197, 'www.baidu.com', 'code99', 'dym', '13982316547');
INSERT INTO `companyinfo` VALUES (105, 'test公司0', '2022-06-28', '吕梁市', 999, 'www.baidu.com', 'code0', 'dym', '13982316547');
INSERT INTO `companyinfo` VALUES (106, 'test公司1', '2022-06-28', '唐山市', 1001, 'www.baidu.com', 'code1', 'wlt', '13982316547');
INSERT INTO `companyinfo` VALUES (107, 'test公司2', '2022-06-28', '省直辖县', 1003, 'www.baidu.com', 'code2', 'fzg', '13982316547');
INSERT INTO `companyinfo` VALUES (108, 'test公司3', '2022-06-28', '上海', 1005, 'www.baidu.com', 'code3', 'qf', '13982316547');
INSERT INTO `companyinfo` VALUES (109, 'test公司4', '2022-06-28', '巴彦淖尔市', 1007, 'www.baidu.com', 'code4', 'wlt', '13982316547');
INSERT INTO `companyinfo` VALUES (110, 'test公司5', '2022-06-28', '保定市', 1009, 'www.baidu.com', 'code5', 'qf', '13982316547');
INSERT INTO `companyinfo` VALUES (111, 'test公司6', '2022-06-28', '忻州市', 1011, 'www.baidu.com', 'code6', 'wlt', '13982316547');
INSERT INTO `companyinfo` VALUES (112, 'test公司7', '2022-06-28', '邯郸市', 1013, 'www.baidu.com', 'code7', 'wlt', '13982316547');
INSERT INTO `companyinfo` VALUES (113, 'test公司8', '2022-06-28', '阿拉善盟', 1015, 'www.baidu.com', 'code8', 'fzg', '13982316547');
INSERT INTO `companyinfo` VALUES (114, 'test公司9', '2022-06-28', '呼伦贝尔市', 1017, 'www.baidu.com', 'code9', 'fzg', '13982316547');
INSERT INTO `companyinfo` VALUES (115, 'test公司10', '2022-06-28', '长治市', 1019, 'www.baidu.com', 'code10', 'fzg', '13982316547');
INSERT INTO `companyinfo` VALUES (116, 'test公司11', '2022-06-28', '临汾市', 1021, 'www.baidu.com', 'code11', 'qf', '13982316547');
INSERT INTO `companyinfo` VALUES (117, 'test公司12', '2022-06-28', '天津市', 1023, 'www.baidu.com', 'code12', 'wyh', '13982316547');
INSERT INTO `companyinfo` VALUES (118, 'test公司13', '2022-06-28', '呼和浩特市', 1025, 'www.baidu.com', 'code13', 'wlt', '13982316547');
INSERT INTO `companyinfo` VALUES (119, 'test公司14', '2022-06-28', '大连市', 1027, 'www.baidu.com', 'code14', 'qf', '13982316547');
INSERT INTO `companyinfo` VALUES (120, 'test公司15', '2022-06-28', '晋城市', 1029, 'www.baidu.com', 'code15', 'fzg', '13982316547');
INSERT INTO `companyinfo` VALUES (121, 'test公司16', '2022-06-28', '阳泉市', 1031, 'www.baidu.com', 'code16', 'fzg', '13982316547');
INSERT INTO `companyinfo` VALUES (122, 'test公司17', '2022-06-28', '赤峰市', 1033, 'www.baidu.com', 'code17', 'wyh', '13982316547');
INSERT INTO `companyinfo` VALUES (123, 'test公司18', '2022-06-28', '重庆', 1035, 'www.baidu.com', 'code18', 'dym', '13982316547');
INSERT INTO `companyinfo` VALUES (124, 'test公司19', '2022-06-28', '锡林郭勒盟', 1037, 'www.baidu.com', 'code19', 'wyh', '13982316547');
INSERT INTO `companyinfo` VALUES (125, 'test公司20', '2022-06-28', '廊坊市', 1039, 'www.baidu.com', 'code20', 'wlt', '13982316547');
INSERT INTO `companyinfo` VALUES (126, 'test公司21', '2022-06-28', '锡林郭勒盟', 1041, 'www.baidu.com', 'code21', 'wlt', '13982316547');
INSERT INTO `companyinfo` VALUES (127, 'test公司22', '2022-06-28', '晋中市', 1043, 'www.baidu.com', 'code22', 'fzg', '13982316547');
INSERT INTO `companyinfo` VALUES (128, 'test公司23', '2022-06-28', '重庆', 1045, 'www.baidu.com', 'code23', 'wyh', '13982316547');
INSERT INTO `companyinfo` VALUES (129, 'test公司24', '2022-06-28', '张家口市', 1047, 'www.baidu.com', 'code24', 'fzg', '13982316547');
INSERT INTO `companyinfo` VALUES (130, 'test公司25', '2022-06-28', '晋城市', 1049, 'www.baidu.com', 'code25', 'qf', '13982316547');
INSERT INTO `companyinfo` VALUES (131, 'test公司26', '2022-06-28', '呼伦贝尔市', 1051, 'www.baidu.com', 'code26', 'fzg', '13982316547');
INSERT INTO `companyinfo` VALUES (132, 'test公司27', '2022-06-28', '上海', 1053, 'www.baidu.com', 'code27', 'wlt', '13982316547');
INSERT INTO `companyinfo` VALUES (133, 'test公司28', '2022-06-28', '廊坊市', 1055, 'www.baidu.com', 'code28', 'fzg', '13982316547');
INSERT INTO `companyinfo` VALUES (134, 'test公司29', '2022-06-28', '锡林郭勒盟', 1057, 'www.baidu.com', 'code29', 'fzg', '13982316547');
INSERT INTO `companyinfo` VALUES (135, 'test公司30', '2022-06-28', '长治市', 1059, 'www.baidu.com', 'code30', 'fzg', '13982316547');
INSERT INTO `companyinfo` VALUES (136, 'test公司31', '2022-06-28', '沈阳市', 1061, 'www.baidu.com', 'code31', 'qf', '13982316547');
INSERT INTO `companyinfo` VALUES (137, 'test公司32', '2022-06-28', '鄂尔多斯市', 1063, 'www.baidu.com', 'code32', 'qf', '13982316547');
INSERT INTO `companyinfo` VALUES (138, 'test公司33', '2022-06-28', '阳泉市', 1065, 'www.baidu.com', 'code33', 'wyh', '13982316547');
INSERT INTO `companyinfo` VALUES (139, 'test公司34', '2022-06-28', '锡林郭勒盟', 1067, 'www.baidu.com', 'code34', 'dym', '13982316547');
INSERT INTO `companyinfo` VALUES (140, 'test公司35', '2022-06-28', '阿拉善盟', 1069, 'www.baidu.com', 'code35', 'qf', '13982316547');
INSERT INTO `companyinfo` VALUES (141, 'test公司36', '2022-06-28', '唐山市', 1071, 'www.baidu.com', 'code36', 'dym', '13982316547');
INSERT INTO `companyinfo` VALUES (142, 'test公司37', '2022-06-28', '朔州市', 1073, 'www.baidu.com', 'code37', 'dym', '13982316547');
INSERT INTO `companyinfo` VALUES (143, 'test公司38', '2022-06-28', '天津市', 1075, 'www.baidu.com', 'code38', 'wyh', '13982316547');
INSERT INTO `companyinfo` VALUES (144, 'test公司39', '2022-06-28', '秦皇岛市', 1077, 'www.baidu.com', 'code39', 'fzg', '13982316547');
INSERT INTO `companyinfo` VALUES (145, 'test公司40', '2022-06-28', '承德市', 1079, 'www.baidu.com', 'code40', 'wyh', '13982316547');
INSERT INTO `companyinfo` VALUES (146, 'test公司41', '2022-06-28', '晋中市', 1081, 'www.baidu.com', 'code41', 'wyh', '13982316547');
INSERT INTO `companyinfo` VALUES (147, 'test公司42', '2022-06-28', '上海', 1083, 'www.baidu.com', 'code42', 'wyh', '13982316547');
INSERT INTO `companyinfo` VALUES (148, 'test公司43', '2022-06-28', '沧州市', 1085, 'www.baidu.com', 'code43', 'fzg', '13982316547');
INSERT INTO `companyinfo` VALUES (149, 'test公司44', '2022-06-28', '太原市', 1087, 'www.baidu.com', 'code44', 'qf', '13982316547');
INSERT INTO `companyinfo` VALUES (150, 'test公司45', '2022-06-28', '忻州市', 1089, 'www.baidu.com', 'code45', 'qf', '13982316547');
INSERT INTO `companyinfo` VALUES (151, 'test公司46', '2022-06-28', '通辽市', 1091, 'www.baidu.com', 'code46', 'dym', '13982316547');
INSERT INTO `companyinfo` VALUES (152, 'test公司47', '2022-06-28', '阳泉市', 1093, 'www.baidu.com', 'code47', 'qf', '13982316547');
INSERT INTO `companyinfo` VALUES (153, 'test公司48', '2022-06-28', '张家口市', 1095, 'www.baidu.com', 'code48', 'dym', '13982316547');
INSERT INTO `companyinfo` VALUES (154, 'test公司49', '2022-06-28', '呼伦贝尔市', 1097, 'www.baidu.com', 'code49', 'wyh', '13982316547');
INSERT INTO `companyinfo` VALUES (155, 'test公司50', '2022-06-28', '衡水市', 1099, 'www.baidu.com', 'code50', 'qf', '13982316547');
INSERT INTO `companyinfo` VALUES (156, 'test公司51', '2022-06-28', '忻州市', 1101, 'www.baidu.com', 'code51', 'qf', '13982316547');
INSERT INTO `companyinfo` VALUES (157, 'test公司52', '2022-06-28', '包头市', 1103, 'www.baidu.com', 'code52', 'wlt', '13982316547');
INSERT INTO `companyinfo` VALUES (158, 'test公司53', '2022-06-28', '鞍山市', 1105, 'www.baidu.com', 'code53', 'qf', '13982316547');
INSERT INTO `companyinfo` VALUES (159, 'test公司54', '2022-06-28', '忻州市', 1107, 'www.baidu.com', 'code54', 'fzg', '13982316547');
INSERT INTO `companyinfo` VALUES (160, 'test公司55', '2022-06-28', '呼和浩特市', 1109, 'www.baidu.com', 'code55', 'wyh', '13982316547');
INSERT INTO `companyinfo` VALUES (161, 'test公司56', '2022-06-28', '大同市', 1111, 'www.baidu.com', 'code56', 'wyh', '13982316547');
INSERT INTO `companyinfo` VALUES (162, 'test公司57', '2022-06-28', '呼伦贝尔市', 1113, 'www.baidu.com', 'code57', 'fzg', '13982316547');
INSERT INTO `companyinfo` VALUES (163, 'test公司58', '2022-06-28', '呼伦贝尔市', 1115, 'www.baidu.com', 'code58', 'wlt', '13982316547');
INSERT INTO `companyinfo` VALUES (164, 'test公司59', '2022-06-28', '呼伦贝尔市', 1117, 'www.baidu.com', 'code59', 'qf', '13982316547');
INSERT INTO `companyinfo` VALUES (165, 'test公司60', '2022-06-28', '秦皇岛市', 1119, 'www.baidu.com', 'code60', 'dym', '13982316547');
INSERT INTO `companyinfo` VALUES (166, 'test公司61', '2022-06-28', '上海', 1121, 'www.baidu.com', 'code61', 'wyh', '13982316547');
INSERT INTO `companyinfo` VALUES (167, 'test公司62', '2022-06-28', '晋中市', 1123, 'www.baidu.com', 'code62', 'wlt', '13982316547');
INSERT INTO `companyinfo` VALUES (168, 'test公司63', '2022-06-28', '省直辖县', 1125, 'www.baidu.com', 'code63', 'qf', '13982316547');
INSERT INTO `companyinfo` VALUES (169, 'test公司64', '2022-06-28', '包头市', 1127, 'www.baidu.com', 'code64', 'fzg', '13982316547');
INSERT INTO `companyinfo` VALUES (170, 'test公司65', '2022-06-28', '秦皇岛市', 1129, 'www.baidu.com', 'code65', 'dym', '13982316547');
INSERT INTO `companyinfo` VALUES (171, 'test公司66', '2022-06-28', '天津市', 1131, 'www.baidu.com', 'code66', 'wlt', '13982316547');
INSERT INTO `companyinfo` VALUES (172, 'test公司67', '2022-06-28', '上海', 1133, 'www.baidu.com', 'code67', 'qf', '13982316547');
INSERT INTO `companyinfo` VALUES (173, 'test公司68', '2022-06-28', '衡水市', 1135, 'www.baidu.com', 'code68', 'dym', '13982316547');
INSERT INTO `companyinfo` VALUES (174, 'test公司69', '2022-06-28', '张家口市', 1137, 'www.baidu.com', 'code69', 'dym', '13982316547');
INSERT INTO `companyinfo` VALUES (175, 'test公司70', '2022-06-28', '天津市', 1139, 'www.baidu.com', 'code70', 'fzg', '13982316547');
INSERT INTO `companyinfo` VALUES (176, 'test公司71', '2022-06-28', '上海', 1141, 'www.baidu.com', 'code71', 'dym', '13982316547');
INSERT INTO `companyinfo` VALUES (177, 'test公司72', '2022-06-28', '沧州市', 1143, 'www.baidu.com', 'code72', 'fzg', '13982316547');
INSERT INTO `companyinfo` VALUES (178, 'test公司73', '2022-06-28', '石家庄市', 1145, 'www.baidu.com', 'code73', 'dym', '13982316547');
INSERT INTO `companyinfo` VALUES (179, 'test公司74', '2022-06-28', '吕梁市', 1147, 'www.baidu.com', 'code74', 'dym', '13982316547');
INSERT INTO `companyinfo` VALUES (180, 'test公司75', '2022-06-28', '吕梁市', 1149, 'www.baidu.com', 'code75', 'qf', '13982316547');
INSERT INTO `companyinfo` VALUES (181, 'test公司76', '2022-06-28', '衡水市', 1151, 'www.baidu.com', 'code76', 'dym', '13982316547');
INSERT INTO `companyinfo` VALUES (182, 'test公司77', '2022-06-28', '阿拉善盟', 1153, 'www.baidu.com', 'code77', 'dym', '13982316547');
INSERT INTO `companyinfo` VALUES (183, 'test公司78', '2022-06-28', '兴安盟', 1155, 'www.baidu.com', 'code78', 'dym', '13982316547');
INSERT INTO `companyinfo` VALUES (184, 'test公司79', '2022-06-28', '阿拉善盟', 1157, 'www.baidu.com', 'code79', 'dym', '13982316547');
INSERT INTO `companyinfo` VALUES (185, 'test公司80', '2022-06-28', '包头市', 1159, 'www.baidu.com', 'code80', 'dym', '13982316547');
INSERT INTO `companyinfo` VALUES (186, 'test公司81', '2022-06-28', '乌海市', 1161, 'www.baidu.com', 'code81', 'fzg', '13982316547');
INSERT INTO `companyinfo` VALUES (187, 'test公司82', '2022-06-28', '巴彦淖尔市', 1163, 'www.baidu.com', 'code82', 'qf', '13982316547');
INSERT INTO `companyinfo` VALUES (188, 'test公司83', '2022-06-28', '乌海市', 1165, 'www.baidu.com', 'code83', 'wlt', '13982316547');
INSERT INTO `companyinfo` VALUES (189, 'test公司84', '2022-06-28', '保定市', 1167, 'www.baidu.com', 'code84', 'wyh', '13982316547');
INSERT INTO `companyinfo` VALUES (190, 'test公司85', '2022-06-28', '大同市', 1169, 'www.baidu.com', 'code85', 'wyh', '13982316547');
INSERT INTO `companyinfo` VALUES (191, 'test公司86', '2022-06-28', '省直辖县', 1171, 'www.baidu.com', 'code86', 'wyh', '13982316547');
INSERT INTO `companyinfo` VALUES (192, 'test公司87', '2022-06-28', '唐山市', 1173, 'www.baidu.com', 'code87', 'qf', '13982316547');
INSERT INTO `companyinfo` VALUES (193, 'test公司88', '2022-06-28', '包头市', 1175, 'www.baidu.com', 'code88', 'qf', '13982316547');
INSERT INTO `companyinfo` VALUES (194, 'test公司89', '2022-06-28', '鄂尔多斯市', 1177, 'www.baidu.com', 'code89', 'wyh', '13982316547');
INSERT INTO `companyinfo` VALUES (195, 'test公司90', '2022-06-28', '包头市', 1179, 'www.baidu.com', 'code90', 'wlt', '13982316547');
INSERT INTO `companyinfo` VALUES (196, 'test公司91', '2022-06-28', '大同市', 1181, 'www.baidu.com', 'code91', 'wyh', '13982316547');
INSERT INTO `companyinfo` VALUES (197, 'test公司92', '2022-06-28', '巴彦淖尔市', 1183, 'www.baidu.com', 'code92', 'qf', '13982316547');
INSERT INTO `companyinfo` VALUES (198, 'test公司93', '2022-06-28', '保定市', 1185, 'www.baidu.com', 'code93', 'qf', '13982316547');
INSERT INTO `companyinfo` VALUES (199, 'test公司94', '2022-06-28', '邯郸市', 1187, 'www.baidu.com', 'code94', 'wlt', '13982316547');
INSERT INTO `companyinfo` VALUES (200, 'test公司95', '2022-06-28', '保定市', 1189, 'www.baidu.com', 'code95', 'qf', '13982316547');
INSERT INTO `companyinfo` VALUES (201, 'test公司96', '2022-06-28', '包头市', 1191, 'www.baidu.com', 'code96', 'fzg', '13982316547');
INSERT INTO `companyinfo` VALUES (202, 'test公司97', '2022-06-28', '唐山市', 1193, 'www.baidu.com', 'code97', 'wyh', '13982316547');

-- ----------------------------
-- Table structure for employeeinfo
-- ----------------------------
DROP TABLE IF EXISTS `employeeinfo`;
CREATE TABLE `employeeinfo`  (
  `employee_id` int(0) NOT NULL AUTO_INCREMENT,
  `company_id` int(0) NULL DEFAULT NULL,
  `employee_name` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `employee_gender` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `employee_address` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `employee_mobile` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `employee_date` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `employee_status` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `employee_number` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`employee_id`) USING BTREE,
  INDEX `FK_qq`(`company_id`) USING BTREE,
  CONSTRAINT `FK_qq` FOREIGN KEY (`company_id`) REFERENCES `companyinfo` (`company_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 220 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of employeeinfo
-- ----------------------------
INSERT INTO `employeeinfo` VALUES (34, 37, '闽困', '男', '地址02', '18025408727', '2022-06-28', '在职', '440231196107071376');
INSERT INTO `employeeinfo` VALUES (35, 50, '幸态诚', '男', '地址11', '16691094107', '2022-06-28', '离职', '31030819830816788');
INSERT INTO `employeeinfo` VALUES (36, 41, '许村', '女', '地址21', '16632948281', '2022-06-28', '在职', '50022720131105126');
INSERT INTO `employeeinfo` VALUES (37, 14, '束峰滤', '男', '地址31', '15338604812', '2022-06-28', '在职', '630332198705125982');
INSERT INTO `employeeinfo` VALUES (38, 41, '卞饥帘', '女', '地址41', '18069771274', '2022-06-28', '在职', '220632201601259144');
INSERT INTO `employeeinfo` VALUES (39, 25, '冉貌甘', '男', '地址51', '14775273342', '2022-06-28', '在职', '61240919900102727');
INSERT INTO `employeeinfo` VALUES (40, 82, '王扫', '男', '地址61', '18095782405', '2022-06-28', '在职', '220531193802175276');
INSERT INTO `employeeinfo` VALUES (41, 32, '薛午寻', '男', '地址71', '19929535052', '2022-06-28', '在职', '122237194206153309');
INSERT INTO `employeeinfo` VALUES (42, 27, '元筐', '男', '地址81', '15258932939', '2022-06-28', '在职', '442504194009152918');
INSERT INTO `employeeinfo` VALUES (43, 75, '戎删', '女', '地址91', '18161611954', '2022-06-28', '在职', '370801195402081530');
INSERT INTO `employeeinfo` VALUES (44, 79, '赵乞', '女', '地址01', '15396657164', '2022-06-28', '在职', '442724201605286090');
INSERT INTO `employeeinfo` VALUES (45, 63, '蓬奴', '女', '地址11', '17156880349', '2022-06-28', '在职', '432527200404076692');
INSERT INTO `employeeinfo` VALUES (46, 30, '薄俱竞', '男', '地址21', '14998162028', '2022-06-28', '在职', '312636198210078629');
INSERT INTO `employeeinfo` VALUES (47, 42, '席辩', '女', '地址31', '17539834679', '2022-06-28', '在职', '630829195309109680');
INSERT INTO `employeeinfo` VALUES (48, 8, '有计', '男', '地址41', '14948987571', '2022-06-28', '在职', '460810200001239731');
INSERT INTO `employeeinfo` VALUES (49, 100, '胥斤农', '女', '地址51', '14589126829', '2022-06-28', '在职', '212226193703286504');
INSERT INTO `employeeinfo` VALUES (50, 19, '井举铜', '女', '地址61', '14987316247', '2022-06-28', '在职', '372732197307057336');
INSERT INTO `employeeinfo` VALUES (51, 44, '钦里阔', '女', '地址71', '15301315083', '2022-06-28', '在职', '610131196504198268');
INSERT INTO `employeeinfo` VALUES (52, 1, '吕床污', '男', '地址81', '14753924372', '2022-06-28', '在职', '41243619410214416');
INSERT INTO `employeeinfo` VALUES (53, 31, '广瓶怀', '男', '地址91', '18955737163', '2022-06-28', '在职', '500228196111092497');
INSERT INTO `employeeinfo` VALUES (54, 4, '殳田倒', '女', '地址101', '15340387987', '2022-06-28', '在职', '210531195903264526');
INSERT INTO `employeeinfo` VALUES (55, 29, '融雀', '男', '地址111', '14929949442', '2022-06-28', '在职', '512109196111256569');
INSERT INTO `employeeinfo` VALUES (56, 4, '匡山懂', '男', '地址121', '17844065195', '2022-06-28', '在职', '542535200606291836');
INSERT INTO `employeeinfo` VALUES (57, 18, '劳嫌底', '男', '地址131', '16605332105', '2022-06-28', '在职', '140225193508039916');
INSERT INTO `employeeinfo` VALUES (58, 45, '邹笑', '男', '地址141', '18998332198', '2022-06-28', '在职', '500237193112022370');
INSERT INTO `employeeinfo` VALUES (59, 64, '朱材', '男', '地址151', '16611748293', '2022-06-28', '在职', '640810194510059784');
INSERT INTO `employeeinfo` VALUES (60, 19, '杨迎脑', '女', '地址161', '17343204724', '2022-06-28', '在职', '322324197311022515');
INSERT INTO `employeeinfo` VALUES (61, 81, '昝运', '女', '地址171', '19897722238', '2022-06-28', '在职', '440136198407291560');
INSERT INTO `employeeinfo` VALUES (62, 39, '牟扣', '女', '地址181', '18497032227', '2022-06-28', '在职', '430928197101218307');
INSERT INTO `employeeinfo` VALUES (63, 35, '柏朱', '男', '地址191', '14926764519', '2022-06-28', '在职', '360635194101273808');
INSERT INTO `employeeinfo` VALUES (64, 10, '周丛碑', '男', '地址201', '15893887541', '2022-06-28', '在职', '810827192412299162');
INSERT INTO `employeeinfo` VALUES (65, 95, '康晶', '女', '地址211', '13625386801', '2022-06-28', '在职', '450225192801035287');
INSERT INTO `employeeinfo` VALUES (66, 50, '祝债', '女', '地址221', '17238195358', '2022-06-28', '在职', '522509200311058634');
INSERT INTO `employeeinfo` VALUES (67, 90, '花讯误', '男', '地址231', '17605820959', '2022-06-28', '在职', '122502199705293937');
INSERT INTO `employeeinfo` VALUES (68, 1, '陆眼', '女', '地址241', '13486943964', '2022-06-28', '在职', '432233194303074301');
INSERT INTO `employeeinfo` VALUES (69, 31, '谭张', '女', '地址251', '15836610863', '2022-06-28', '在职', '530804199011272980');
INSERT INTO `employeeinfo` VALUES (70, 20, '许店', '女', '地址261', '13115004326', '2022-06-28', '在职', '332228198503305955');
INSERT INTO `employeeinfo` VALUES (71, 86, '景挡胁', '女', '地址271', '18047878820', '2022-06-28', '在职', '150137196101303200');
INSERT INTO `employeeinfo` VALUES (72, 79, '宋猜', '男', '地址281', '13103903676', '2022-06-28', '在职', '4324041973121969');
INSERT INTO `employeeinfo` VALUES (73, 51, '佘罩', '女', '地址291', '13370637079', '2022-06-28', '在职', '110625201303035146');
INSERT INTO `employeeinfo` VALUES (74, 46, '嵇冈', '男', '地址301', '19979871903', '2022-06-28', '在职', '530329196502115222');
INSERT INTO `employeeinfo` VALUES (75, 67, '魏醉肌', '女', '地址311', '13634141002', '2022-06-28', '在职', '37023419441223879');
INSERT INTO `employeeinfo` VALUES (76, 61, '柏涌', '男', '地址321', '15022450716', '2022-06-28', '在职', '530532200505042401');
INSERT INTO `employeeinfo` VALUES (77, 69, '湛虑浊', '女', '地址331', '17699884549', '2022-06-28', '在职', '340521201607285743');
INSERT INTO `employeeinfo` VALUES (78, 82, '韦雄', '女', '地址341', '15056446338', '2022-06-28', '在职', '130326194406194835');
INSERT INTO `employeeinfo` VALUES (79, 7, '茹非石', '女', '地址351', '18798585903', '2022-06-28', '在职', '120302192403206728');
INSERT INTO `employeeinfo` VALUES (80, 26, '终洞杯', '女', '地址361', '13333121257', '2022-06-28', '在职', '222403192304287034');
INSERT INTO `employeeinfo` VALUES (81, 26, '鱼操财', '男', '地址371', '18297047392', '2022-06-28', '在职', '44043020060119980');
INSERT INTO `employeeinfo` VALUES (82, 11, '柯途', '女', '地址381', '17214065191', '2022-06-28', '在职', '442234196504285616');
INSERT INTO `employeeinfo` VALUES (83, 8, '雷发垦', '女', '地址391', '16602430539', '2022-06-28', '在职', '450730192805191351');
INSERT INTO `employeeinfo` VALUES (84, 28, '刁认', '女', '地址401', '19943679648', '2022-06-28', '在职', '410524197606081964');
INSERT INTO `employeeinfo` VALUES (85, 76, '怀哪窗', '女', '地址411', '13344067361', '2022-06-28', '在职', '23030119910202795');
INSERT INTO `employeeinfo` VALUES (86, 5, '史汤呈', '女', '地址421', '13351024387', '2022-06-28', '在职', '370436201302273015');
INSERT INTO `employeeinfo` VALUES (87, 12, '祖泰泪', '女', '地址431', '18835995476', '2022-06-28', '在职', '431037200409266898');
INSERT INTO `employeeinfo` VALUES (88, 60, '松形', '男', '地址441', '18187397604', '2022-06-28', '在职', '340933192808212217');
INSERT INTO `employeeinfo` VALUES (89, 91, '解到', '女', '地址451', '14926511499', '2022-06-28', '在职', '712405200304165406');
INSERT INTO `employeeinfo` VALUES (90, 41, '阮蚕鱼', '女', '地址461', '19946847464', '2022-06-28', '在职', '630507195405197330');
INSERT INTO `employeeinfo` VALUES (91, 72, '穆泡性', '女', '地址471', '15512182173', '2022-06-28', '在职', '322431198109235200');
INSERT INTO `employeeinfo` VALUES (92, 27, '邴公', '男', '地址481', '18034300953', '2022-06-28', '在职', '440626194904089174');
INSERT INTO `employeeinfo` VALUES (93, 81, '封叛', '男', '地址491', '13181718332', '2022-06-28', '在职', '352401201902153050');
INSERT INTO `employeeinfo` VALUES (94, 16, '崔司', '男', '地址501', '16647994284', '2022-06-28', '在职', '610434197802142736');
INSERT INTO `employeeinfo` VALUES (95, 6, '解准', '男', '地址511', '13392159758', '2022-06-28', '在职', '210907197702131138');
INSERT INTO `employeeinfo` VALUES (96, 16, '冯扭钢', '男', '地址521', '13819561477', '2022-06-28', '在职', '500931192301068580');
INSERT INTO `employeeinfo` VALUES (97, 84, '申念俯', '男', '地址531', '15553114656', '2022-06-28', '在职', '14073619791212431');
INSERT INTO `employeeinfo` VALUES (98, 53, '阳害', '女', '地址541', '15613113398', '2022-06-28', '在职', '22070219961006364');
INSERT INTO `employeeinfo` VALUES (99, 16, '成糠满', '男', '地址551', '14960131912', '2022-06-28', '在职', '122303197306109055');
INSERT INTO `employeeinfo` VALUES (100, 99, '谈赶双', '男', '地址561', '15586852916', '2022-06-28', '在职', '422126200109144599');
INSERT INTO `employeeinfo` VALUES (101, 34, '贡佩', '男', '地址571', '17122246261', '2022-06-28', '在职', '41083519530327346');
INSERT INTO `employeeinfo` VALUES (102, 24, '龚饼', '男', '地址581', '14956273868', '2022-06-28', '在职', '461030198108132927');
INSERT INTO `employeeinfo` VALUES (103, 79, '单被', '男', '地址591', '18358684872', '2022-06-28', '在职', '1108221923112548');
INSERT INTO `employeeinfo` VALUES (104, 85, '丘肚邪', '女', '地址601', '19967983556', '2022-06-28', '在职', '500626201606143504');
INSERT INTO `employeeinfo` VALUES (105, 99, '昝亏', '女', '地址611', '16675812964', '2022-06-28', '在职', '310232200706254222');
INSERT INTO `employeeinfo` VALUES (106, 50, '盛待', '女', '地址621', '18601318746', '2022-06-28', '在职', '342227199003154169');
INSERT INTO `employeeinfo` VALUES (107, 5, '滑宝绩', '男', '地址631', '15697634125', '2022-06-28', '在职', '120427194609287689');
INSERT INTO `employeeinfo` VALUES (108, 7, '甄按', '女', '地址641', '17220407382', '2022-06-28', '在职', '410730193911113277');
INSERT INTO `employeeinfo` VALUES (109, 74, '骆怒', '女', '地址651', '19913464441', '2022-06-28', '在职', '362724200908125915');
INSERT INTO `employeeinfo` VALUES (110, 15, '夏够', '男', '地址661', '18340721922', '2022-06-28', '在职', '130125194104218293');
INSERT INTO `employeeinfo` VALUES (111, 55, '沙只', '女', '地址671', '13318956441', '2022-06-28', '在职', '122602195909054431');
INSERT INTO `employeeinfo` VALUES (112, 60, '劳瞒鹅', '男', '地址681', '18930665701', '2022-06-28', '在职', '640629199811087583');
INSERT INTO `employeeinfo` VALUES (113, 18, '樊锁', '男', '地址691', '18847910156', '2022-06-28', '在职', '230336195805067773');
INSERT INTO `employeeinfo` VALUES (114, 35, '巢估美', '女', '地址701', '16681865600', '2022-06-28', '在职', '230134201306056900');
INSERT INTO `employeeinfo` VALUES (115, 11, '梁拌', '男', '地址711', '18014431785', '2022-06-28', '在职', '540933193212258006');
INSERT INTO `employeeinfo` VALUES (116, 77, '米器昨', '男', '地址721', '18399024145', '2022-06-28', '在职', '152425193710161875');
INSERT INTO `employeeinfo` VALUES (118, 71, '宗惭灵', '女', '地址01', '13428758904', '2022-06-28', '在职', '620803200703172933');
INSERT INTO `employeeinfo` VALUES (119, 92, '周电', '男', '地址11', '17844660474', '2022-06-28', '在职', '442623194302284731');
INSERT INTO `employeeinfo` VALUES (120, 40, '匡使输', '男', '地址21', '19905149813', '2022-06-28', '在职', '332407201412176924');
INSERT INTO `employeeinfo` VALUES (121, 76, '逑脆攻', '女', '地址31', '16649934275', '2022-06-28', '在职', '450308195908046487');
INSERT INTO `employeeinfo` VALUES (122, 95, '边诸盟', '男', '地址41', '15237230979', '2022-06-28', '在职', '232229198403172613');
INSERT INTO `employeeinfo` VALUES (123, 70, '颜锤职', '女', '地址51', '15816324335', '2022-06-28', '在职', '63020419250823564');
INSERT INTO `employeeinfo` VALUES (124, 35, '叶全', '女', '地址61', '18256436693', '2022-06-28', '在职', '41222619751110640');
INSERT INTO `employeeinfo` VALUES (125, 69, '郏材', '男', '地址71', '15578959252', '2022-06-28', '在职', '220922197212033952');
INSERT INTO `employeeinfo` VALUES (126, 99, '须小', '女', '地址81', '15039287713', '2022-06-28', '在职', '430836195108235838');
INSERT INTO `employeeinfo` VALUES (127, 41, '魏松', '男', '地址91', '14970436519', '2022-06-28', '在职', '332426200910068392');
INSERT INTO `employeeinfo` VALUES (129, 75, '伯字', '女', '地址01', '18310295657', '2022-06-28', '在职', '710731200106014320');
INSERT INTO `employeeinfo` VALUES (130, 59, '佴申', '男', '地址11', '13483099879', '2022-06-28', '在职', '502306195811096611');
INSERT INTO `employeeinfo` VALUES (131, 90, '沃慨', '男', '地址21', '13231037498', '2022-06-28', '在职', '510202196504197963');
INSERT INTO `employeeinfo` VALUES (132, 29, '常蒙', '男', '地址31', '13877755538', '2022-06-28', '在职', '632404198909129306');
INSERT INTO `employeeinfo` VALUES (133, 53, '蒲图', '男', '地址41', '15249071718', '2022-06-28', '在职', '410432194404184363');
INSERT INTO `employeeinfo` VALUES (134, 99, '樊伤技', '女', '地址51', '14598555679', '2022-06-28', '在职', '362204201501192806');
INSERT INTO `employeeinfo` VALUES (135, 16, '阳佣周', '女', '地址61', '15351014054', '2022-06-28', '在职', '150231199211262417');
INSERT INTO `employeeinfo` VALUES (136, 58, '郎动', '男', '地址71', '18513145288', '2022-06-28', '在职', '511035192308135900');
INSERT INTO `employeeinfo` VALUES (137, 98, '竺竞孟', '女', '地址81', '13471436730', '2022-06-28', '在职', '502636192505161993');
INSERT INTO `employeeinfo` VALUES (138, 9, '曾排栋', '女', '地址91', '15993881888', '2022-06-28', '在职', '510505197201278317');
INSERT INTO `employeeinfo` VALUES (139, 14, '鱼妹', '女', '地址101', '15367085992', '2022-06-28', '在职', '640737194506286483');
INSERT INTO `employeeinfo` VALUES (140, 86, '都秃', '女', '地址111', '13395634302', '2022-06-28', '在职', '210127202010053603');
INSERT INTO `employeeinfo` VALUES (141, 94, '熊晒', '男', '地址121', '15341671202', '2022-06-28', '在职', '112232195605076269');
INSERT INTO `employeeinfo` VALUES (142, 47, '牧准绞', '女', '地址131', '16666611724', '2022-06-28', '在职', '152732192510011560');
INSERT INTO `employeeinfo` VALUES (143, 55, '岳翠', '男', '地址141', '14909279334', '2022-06-28', '在职', '650426195306251848');
INSERT INTO `employeeinfo` VALUES (144, 21, '陶袋', '女', '地址151', '14776817743', '2022-06-28', '在职', '432537194405256610');
INSERT INTO `employeeinfo` VALUES (145, 74, '曾箩', '女', '地址161', '18231594039', '2022-06-28', '在职', '54082320070608146');
INSERT INTO `employeeinfo` VALUES (146, 8, '伊锦', '女', '地址171', '15894864505', '2022-06-28', '在职', '320206197501204293');
INSERT INTO `employeeinfo` VALUES (147, 25, '庄脉帝', '女', '地址181', '16689663703', '2022-06-28', '在职', '511035201011272365');
INSERT INTO `employeeinfo` VALUES (148, 47, '翟裤', '女', '地址191', '18456024121', '2022-06-28', '在职', '422737201706286843');
INSERT INTO `employeeinfo` VALUES (149, 55, '居俭', '男', '地址201', '13374578750', '2022-06-28', '在职', '651001198709056770');
INSERT INTO `employeeinfo` VALUES (150, 58, '鄂锐', '女', '地址211', '15688297787', '2022-06-28', '在职', '810429192407291167');
INSERT INTO `employeeinfo` VALUES (151, 11, '范荣趁', '女', '地址221', '15762246924', '2022-06-28', '在职', '342525198707126831');
INSERT INTO `employeeinfo` VALUES (152, 33, '湛垃沸', '男', '地址231', '17624014527', '2022-06-28', '在职', '4124011942122985');
INSERT INTO `employeeinfo` VALUES (153, 36, '怀抓', '女', '地址241', '15377554880', '2022-06-28', '在职', '520305194710259564');
INSERT INTO `employeeinfo` VALUES (154, 19, '夏绪辟', '女', '地址251', '18313213368', '2022-06-28', '在职', '372637200605223667');
INSERT INTO `employeeinfo` VALUES (155, 43, '谢吩倡', '女', '地址261', '19996542860', '2022-06-28', '在职', '332710198003176332');
INSERT INTO `employeeinfo` VALUES (156, 78, '厉踢迫', '男', '地址271', '13530983230', '2022-06-28', '在职', '110922198805173504');
INSERT INTO `employeeinfo` VALUES (157, 63, '徐踢', '男', '地址281', '13306589297', '2022-06-28', '在职', '712235197509205745');
INSERT INTO `employeeinfo` VALUES (158, 19, '郭氏', '男', '地址291', '18567907841', '2022-06-28', '在职', '35053519650419198');
INSERT INTO `employeeinfo` VALUES (159, 66, '卓市', '女', '地址301', '15998258089', '2022-06-28', '在职', '652301194612219029');
INSERT INTO `employeeinfo` VALUES (160, 4, '刘翁恒', '男', '地址311', '14706995599', '2022-06-28', '在职', '530125199911302507');
INSERT INTO `employeeinfo` VALUES (161, 58, '茅骨', '女', '地址321', '17610945558', '2022-06-28', '在职', '43020920050526378');
INSERT INTO `employeeinfo` VALUES (162, 80, '黎何', '女', '地址331', '13957756772', '2022-06-28', '在职', '540922192801311898');
INSERT INTO `employeeinfo` VALUES (163, 53, '满左', '女', '地址341', '16612442166', '2022-06-28', '在职', '222530194806046623');
INSERT INTO `employeeinfo` VALUES (164, 4, '和叮救', '女', '地址351', '15910816977', '2022-06-28', '在职', '342423201312202336');
INSERT INTO `employeeinfo` VALUES (165, 36, '广现', '女', '地址361', '13489610841', '2022-06-28', '在职', '420810199306245188');
INSERT INTO `employeeinfo` VALUES (166, 28, '金师', '男', '地址371', '18128281468', '2022-06-28', '在职', '542501194206061409');
INSERT INTO `employeeinfo` VALUES (167, 93, '羊货', '女', '地址381', '18922420216', '2022-06-28', '在职', '450730199307293046');
INSERT INTO `employeeinfo` VALUES (168, 14, '通琴赛', '女', '地址391', '17534780399', '2022-06-28', '在职', '331010194105147999');
INSERT INTO `employeeinfo` VALUES (169, 19, '柯国眉', '男', '地址401', '13373016016', '2022-06-28', '在职', '220226193408136093');
INSERT INTO `employeeinfo` VALUES (170, 22, '郝携行', '女', '地址411', '15335959024', '2022-06-28', '在职', '510125199112277483');
INSERT INTO `employeeinfo` VALUES (171, 91, '农贷萝', '男', '地址421', '17602884447', '2022-06-28', '在职', '712410201808272885');
INSERT INTO `employeeinfo` VALUES (172, 11, '文起', '男', '地址431', '13038158355', '2022-06-28', '在职', '630810195311029669');
INSERT INTO `employeeinfo` VALUES (173, 50, '糜珍', '男', '地址441', '19875623055', '2022-06-28', '在职', '220736196609308877');
INSERT INTO `employeeinfo` VALUES (174, 41, '籍流棍', '男', '地址451', '13848253005', '2022-06-28', '在职', '442322194901253653');
INSERT INTO `employeeinfo` VALUES (175, 59, '桂献', '女', '地址461', '13974888570', '2022-06-28', '在职', '350237196008228193');
INSERT INTO `employeeinfo` VALUES (176, 17, '酆协', '男', '地址471', '13595938026', '2022-06-28', '在职', '62273719871229156');
INSERT INTO `employeeinfo` VALUES (177, 26, '封盖腹', '女', '地址481', '16620870401', '2022-06-28', '在职', '532421193807218907');
INSERT INTO `employeeinfo` VALUES (178, 9, '季廉箭', '女', '地址491', '15699700845', '2022-06-28', '在职', '340604200910132050');
INSERT INTO `employeeinfo` VALUES (179, 1, '通父帐', '女', '地址501', '14970043713', '2022-06-28', '在职', '110932197112165312');
INSERT INTO `employeeinfo` VALUES (180, 91, '郭吃冻', '男', '地址511', '15019893549', '2022-06-28', '在职', '140410193007083428');
INSERT INTO `employeeinfo` VALUES (181, 32, '殷店竟', '女', '地址521', '18093746074', '2022-06-28', '在职', '222403194707165853');
INSERT INTO `employeeinfo` VALUES (182, 1, '伊磨', '男', '地址531', '14719364222', '2022-06-28', '在职', '410524193311117005');
INSERT INTO `employeeinfo` VALUES (183, 40, '籍耀腾', '女', '地址541', '15399916178', '2022-06-28', '在职', '520734193507124631');
INSERT INTO `employeeinfo` VALUES (184, 40, '邰又币', '女', '地址551', '13201673610', '2022-06-28', '在职', '65212320050813140');
INSERT INTO `employeeinfo` VALUES (185, 24, '乐都', '男', '地址561', '13022210949', '2022-06-28', '在职', '352727193307299015');
INSERT INTO `employeeinfo` VALUES (186, 53, '涂公姐', '男', '地址571', '16639515260', '2022-06-28', '在职', '230128201804217751');
INSERT INTO `employeeinfo` VALUES (187, 42, '有沿', '男', '地址581', '14559168824', '2022-06-28', '在职', '372221193312113284');
INSERT INTO `employeeinfo` VALUES (188, 1, '古限', '男', '地址591', '18262542145', '2022-06-28', '在职', '312231193403185350');
INSERT INTO `employeeinfo` VALUES (189, 54, '邢港', '男', '地址601', '17375296132', '2022-06-28', '在职', '642121194107132234');
INSERT INTO `employeeinfo` VALUES (190, 10, '田脾', '男', '地址611', '18130316294', '2022-06-28', '在职', '652431194302142673');
INSERT INTO `employeeinfo` VALUES (192, 4, '陈咐触', '男', '地址1551', '17567280825', '2022-06-28', '在职', '23040319451214204');
INSERT INTO `employeeinfo` VALUES (193, 7, '吴悟', '女', '地址1561', '13444949191', '2022-06-28', '在职', '462407199802117572');
INSERT INTO `employeeinfo` VALUES (194, 50, '吴桶重', '女', '地址1571', '15552905024', '2022-06-28', '在职', '620108196002219574');
INSERT INTO `employeeinfo` VALUES (195, 65, '孙财税', '男', '地址1581', '15035174335', '2022-06-28', '在职', '310310196809197060');
INSERT INTO `employeeinfo` VALUES (196, 26, '王眯患', '男', '地址1591', '18586271925', '2022-06-28', '在职', '451024196808016954');
INSERT INTO `employeeinfo` VALUES (197, 24, '赵迟脖', '男', '地址1601', '159982', '2022-06-28', '在职', '230527193403034560');
INSERT INTO `employeeinfo` VALUES (198, 53, '冯下', '女', '地址1611', '17364160509', '2022-06-28', '在职', '331005197408023913');
INSERT INTO `employeeinfo` VALUES (199, 88, '孙丑指', '女', '地址1621', '13143602054', '2022-06-28', '在职', '650237199704051924');
INSERT INTO `employeeinfo` VALUES (200, 31, '钱位', '男', '地址1631999', '17771701889', '2022-06-28', '在职', '132533193805018309');
INSERT INTO `employeeinfo` VALUES (201, 56, '吴车腥', '男', '沙坪坝', '18526941390', '2022-06-28', '在职', '460601195001051898');
INSERT INTO `employeeinfo` VALUES (202, 69, '郑身破', '女', '重庆市', '17116961663', '2022-06-28', '在职', '622636200010307882');
INSERT INTO `employeeinfo` VALUES (212, NULL, '', '', '', '123', '', '', '');
INSERT INTO `employeeinfo` VALUES (213, NULL, '', '', '', '123213', '', '', '');
INSERT INTO `employeeinfo` VALUES (214, 1, '王耀辉', '女', '重庆大学', '110', '', '在职', '520125');
INSERT INTO `employeeinfo` VALUES (215, 44, '钱衬笑', '女', '地址1551', '18322867518', '2022-07-02', '在职', '462330201803056612');
INSERT INTO `employeeinfo` VALUES (216, 12, '孙鲁', '女', '地址1561', '18047393238', '2022-07-02', '在职', '432529193408085939');
INSERT INTO `employeeinfo` VALUES (217, 31, '陈解肾', '女', '地址1571', '13333257603', '2022-07-02', '在职', '522105196806099782');
INSERT INTO `employeeinfo` VALUES (218, 31, '钱谋榨', '女', '地址1581', '13832209543', '2022-07-02', '在职', '320323200606291718');
INSERT INTO `employeeinfo` VALUES (219, 84, '王厉', '女', '地址1591', '15514807580', '2022-07-02', '在职', '712502192708181596');
INSERT INTO `employeeinfo` VALUES (220, 98, '郑秆依', '男', '地址1601', '13350345472', '2022-07-02', '在职', '222129194410196789');

-- ----------------------------
-- Table structure for fixinfo
-- ----------------------------
DROP TABLE IF EXISTS `fixinfo`;
CREATE TABLE `fixinfo`  (
  `fix_id` int(0) NOT NULL AUTO_INCREMENT,
  `car_id` int(0) NULL DEFAULT NULL,
  `fix_starttime` date NULL DEFAULT NULL,
  `fix_endtime` date NULL DEFAULT NULL,
  `fix_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `fix_money` decimal(10, 2) NOT NULL,
  PRIMARY KEY (`fix_id`) USING BTREE,
  INDEX `FK_Relationship_8`(`car_id`) USING BTREE,
  CONSTRAINT `FK_Relationship_8` FOREIGN KEY (`car_id`) REFERENCES `carinfo` (`car_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 55 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of fixinfo
-- ----------------------------
INSERT INTO `fixinfo` VALUES (2, 18, '2022-06-16', '2022-06-24', '吴亦凡', 128.10);
INSERT INTO `fixinfo` VALUES (3, 28, '2021-10-24', '2022-06-29', '龚尧莞', 328.90);
INSERT INTO `fixinfo` VALUES (4, 47, '2022-06-14', '2022-06-15', '齐新燕', 918.05);
INSERT INTO `fixinfo` VALUES (5, 65, '2021-10-24', '2022-06-28', '龙宣霖', 480.25);
INSERT INTO `fixinfo` VALUES (6, 107, '2021-10-24', '2022-06-29', '龙家铸', 881.63);
INSERT INTO `fixinfo` VALUES (7, 93, '2022-06-23', '2022-06-29', '龙家锐', 463.76);
INSERT INTO `fixinfo` VALUES (8, 92, '2021-10-24', '2022-06-27', '宇文献花', 519.47);
INSERT INTO `fixinfo` VALUES (9, 101, '2022-05-10', '2022-05-11', '米培燕', 976.64);
INSERT INTO `fixinfo` VALUES (10, 39, '2022-06-23', '2022-06-29', '黄益泉', 511.99);
INSERT INTO `fixinfo` VALUES (12, 20, '2021-10-24', '2022-06-29', '黄益泉', 387.00);
INSERT INTO `fixinfo` VALUES (13, 100, '2021-10-24', '2022-06-29', '车少飞', 718.40);
INSERT INTO `fixinfo` VALUES (14, 103, '2021-10-24', '2022-06-29', '宇文献花', 416.73);
INSERT INTO `fixinfo` VALUES (15, 20, '2021-10-24', '2022-06-29', '齐新燕', 227.48);
INSERT INTO `fixinfo` VALUES (16, 35, '2021-10-24', '2022-06-29', '黄益泉', 545.52);
INSERT INTO `fixinfo` VALUES (17, 56, '2021-10-24', '2022-06-29', '黄相杰', 192.25);
INSERT INTO `fixinfo` VALUES (18, 86, '2021-10-24', '2022-06-29', '龚尧莞', 340.31);
INSERT INTO `fixinfo` VALUES (19, 78, '2021-10-24', '2022-06-29', '连传杰', 783.48);
INSERT INTO `fixinfo` VALUES (20, 91, '2021-10-24', '2022-06-29', '米培燕', 656.20);
INSERT INTO `fixinfo` VALUES (21, 31, '2021-10-24', '2022-06-29', '齐旺梅', 295.58);
INSERT INTO `fixinfo` VALUES (22, 35, '2021-10-24', '2022-06-29', '连俊勤', 650.20);
INSERT INTO `fixinfo` VALUES (23, 19, '2021-10-24', '2022-06-29', '连俊勤', 785.03);
INSERT INTO `fixinfo` VALUES (24, 46, '2021-10-24', '2022-06-29', '黄相杰', 88.40);
INSERT INTO `fixinfo` VALUES (25, 99, '2021-10-24', '2022-06-29', '车少飞', 160.02);
INSERT INTO `fixinfo` VALUES (48, 99, '2022-06-27', '2022-06-29', '蔡徐坤', 199.50);
INSERT INTO `fixinfo` VALUES (49, 88, '2022-06-14', '2022-06-30', '蔡徐坤', 120.80);
INSERT INTO `fixinfo` VALUES (50, 30, '2022-06-14', '2022-06-21', '张伟', 1221.00);
INSERT INTO `fixinfo` VALUES (55, 18, '2022-07-11', '2022-07-12', '是我', 200.00);

-- ----------------------------
-- Table structure for machineinfo
-- ----------------------------
DROP TABLE IF EXISTS `machineinfo`;
CREATE TABLE `machineinfo`  (
  `machine_id` int(0) NOT NULL AUTO_INCREMENT,
  `machine_name` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `machine_type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `machine_year` int(0) NULL DEFAULT NULL,
  `machine_power` decimal(10, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`machine_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of machineinfo
-- ----------------------------
INSERT INTO `machineinfo` VALUES (1, '挖掘机', '大车类', 6, 888.00);
INSERT INTO `machineinfo` VALUES (2, '大卡车', '大车类', 2, 666.00);
INSERT INTO `machineinfo` VALUES (3, '大卡车', '大车类', 2, 666.00);
INSERT INTO `machineinfo` VALUES (4, '大卡车', '大车类', 2, 666.00);
INSERT INTO `machineinfo` VALUES (5, '起重机', '中车类', 4, 254.00);

-- ----------------------------
-- Table structure for materialtype
-- ----------------------------
DROP TABLE IF EXISTS `materialtype`;
CREATE TABLE `materialtype`  (
  `materialtype_id` int(0) NOT NULL AUTO_INCREMENT,
  `materialtype_type` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`materialtype_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of materialtype
-- ----------------------------
INSERT INTO `materialtype` VALUES (1, '办公耗材');
INSERT INTO `materialtype` VALUES (2, '卫生耗材');
INSERT INTO `materialtype` VALUES (3, '人员耗材');
INSERT INTO `materialtype` VALUES (4, '团建耗材');

-- ----------------------------
-- Table structure for matetialinfo
-- ----------------------------
DROP TABLE IF EXISTS `matetialinfo`;
CREATE TABLE `matetialinfo`  (
  `material_id` int(0) NOT NULL AUTO_INCREMENT,
  `materialtype_id` int(0) NULL DEFAULT NULL,
  `material_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `material_price` decimal(10, 2) NULL DEFAULT NULL,
  `material_usage` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `material_count` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`material_id`) USING BTREE,
  INDEX `FK_qwwe`(`materialtype_id`) USING BTREE,
  CONSTRAINT `FK_qwwe` FOREIGN KEY (`materialtype_id`) REFERENCES `materialtype` (`materialtype_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 185 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of matetialinfo
-- ----------------------------
INSERT INTO `matetialinfo` VALUES (20, 2, '打扫用具', 8094.00, '办公', 15);
INSERT INTO `matetialinfo` VALUES (21, 2, '橡皮擦', 34798.00, '办公', 20);
INSERT INTO `matetialinfo` VALUES (22, 2, '杀虫剂', 33874.00, '办公', 11);
INSERT INTO `matetialinfo` VALUES (23, 3, '橡皮擦', 186.00, '办公', 19);
INSERT INTO `matetialinfo` VALUES (24, 1, '螺丝刀', 48844.00, '办公', 37);
INSERT INTO `matetialinfo` VALUES (25, 2, '杀虫剂', 44948.00, '办公', 8);
INSERT INTO `matetialinfo` VALUES (26, 2, '螺丝刀', 23377.00, '办公', 3);
INSERT INTO `matetialinfo` VALUES (27, 2, '打扫用具', 3676.00, '办公', 34);
INSERT INTO `matetialinfo` VALUES (28, 2, '杀虫剂', 5581.00, '办公', 22);
INSERT INTO `matetialinfo` VALUES (29, 2, '打扫用具', 27138.00, '办公', 33);
INSERT INTO `matetialinfo` VALUES (30, 1, '打扫用具', 32739.00, '办公', 26);
INSERT INTO `matetialinfo` VALUES (31, 2, '橡皮擦', 23017.00, '办公', 27);
INSERT INTO `matetialinfo` VALUES (32, 4, '螺丝刀', 36296.00, '办公', 1);
INSERT INTO `matetialinfo` VALUES (33, 2, '橡皮擦', 30375.00, '办公', 49);
INSERT INTO `matetialinfo` VALUES (34, 1, '铅笔', 41934.00, '办公', 15);
INSERT INTO `matetialinfo` VALUES (35, 4, '橡皮擦', 34020.00, '办公', 18);
INSERT INTO `matetialinfo` VALUES (36, 4, '杀虫剂', 31134.00, '办公', 11);
INSERT INTO `matetialinfo` VALUES (37, 1, '铅笔', 6399.00, '办公', 30);
INSERT INTO `matetialinfo` VALUES (38, 4, '打扫用具', 19808.00, '办公', 7);
INSERT INTO `matetialinfo` VALUES (39, 3, '打扫用具', 48843.00, '办公', 22);
INSERT INTO `matetialinfo` VALUES (40, 3, '打扫用具', 82.00, '办公', 2);
INSERT INTO `matetialinfo` VALUES (41, 1, '橡皮擦', 198.00, '办公', 32);
INSERT INTO `matetialinfo` VALUES (42, 3, '杀虫剂', 77.00, '办公', 20);
INSERT INTO `matetialinfo` VALUES (43, 1, '螺丝刀', 273.00, '办公', 49);
INSERT INTO `matetialinfo` VALUES (44, 1, '橡皮擦', 421.00, '办公', 16);
INSERT INTO `matetialinfo` VALUES (45, 3, '橡皮擦', 361.00, '办公', 21);
INSERT INTO `matetialinfo` VALUES (46, 1, '打扫用具', 388.00, '办公', 27);
INSERT INTO `matetialinfo` VALUES (47, 1, '杀虫剂', 222.00, '办公', 27);
INSERT INTO `matetialinfo` VALUES (48, 2, '打扫用具', 13.00, '办公', 20);
INSERT INTO `matetialinfo` VALUES (49, 1, '橡皮擦', 73.00, '办公', 35);
INSERT INTO `matetialinfo` VALUES (50, 2, '橡皮擦', 308.00, '办公', 15);
INSERT INTO `matetialinfo` VALUES (51, 1, '杀虫剂', 401.00, '办公', 45);
INSERT INTO `matetialinfo` VALUES (52, 1, '橡皮擦', 23.00, '办公', 37);
INSERT INTO `matetialinfo` VALUES (53, 4, '橡皮擦', 6.00, '办公', 13);
INSERT INTO `matetialinfo` VALUES (54, 3, '铅笔', 142.00, '办公', 9);
INSERT INTO `matetialinfo` VALUES (55, 1, '橡皮擦', 290.00, '办公', 33);
INSERT INTO `matetialinfo` VALUES (56, 1, '杀虫剂', 404.00, '办公', 47);
INSERT INTO `matetialinfo` VALUES (57, 2, '铅笔', 132.00, '办公', 16);
INSERT INTO `matetialinfo` VALUES (58, 2, '橡皮擦', 152.00, '办公', 7);
INSERT INTO `matetialinfo` VALUES (59, 2, '铅笔', 401.00, '办公', 17);
INSERT INTO `matetialinfo` VALUES (60, 2, '螺丝刀', 282.00, '办公', 44);
INSERT INTO `matetialinfo` VALUES (61, 4, '螺丝刀', 169.00, '办公', 29);
INSERT INTO `matetialinfo` VALUES (62, 2, '杀虫剂', 439.00, '办公', 29);
INSERT INTO `matetialinfo` VALUES (63, 2, '螺丝刀', 88.00, '办公', 42);
INSERT INTO `matetialinfo` VALUES (64, 4, '打扫用具', 63.00, '办公', 18);
INSERT INTO `matetialinfo` VALUES (65, 4, '杀虫剂', 122.00, '办公', 36);
INSERT INTO `matetialinfo` VALUES (66, 2, '螺丝刀', 128.00, '办公', 44);
INSERT INTO `matetialinfo` VALUES (67, 2, '铅笔', 186.00, '办公', 28);
INSERT INTO `matetialinfo` VALUES (68, 2, '铅笔', 221.00, '办公', 0);
INSERT INTO `matetialinfo` VALUES (69, 2, '杀虫剂', 497.00, '办公', 1);
INSERT INTO `matetialinfo` VALUES (70, 1, '橡皮擦', 99.00, '办公', 12);
INSERT INTO `matetialinfo` VALUES (71, 4, '铅笔', 94.00, '办公', 6);
INSERT INTO `matetialinfo` VALUES (72, 4, '螺丝刀', 183.00, '办公', 22);
INSERT INTO `matetialinfo` VALUES (73, 1, '杀虫剂', 169.00, '办公', 7);
INSERT INTO `matetialinfo` VALUES (74, 2, '螺丝刀', 7.00, '办公', 49);
INSERT INTO `matetialinfo` VALUES (75, 3, '铅笔', 273.00, '办公', 33);
INSERT INTO `matetialinfo` VALUES (76, 3, '铅笔', 167.00, '办公', 37);
INSERT INTO `matetialinfo` VALUES (77, 3, '螺丝刀', 5.00, '办公', 49);
INSERT INTO `matetialinfo` VALUES (78, 4, '打扫用具', 222.00, '办公', 32);
INSERT INTO `matetialinfo` VALUES (79, 3, '打扫用具', 240.00, '办公', 38);
INSERT INTO `matetialinfo` VALUES (80, 3, '杀虫剂', 288.00, '办公', 6);
INSERT INTO `matetialinfo` VALUES (81, 3, '橡皮擦', 390.00, '办公', 47);
INSERT INTO `matetialinfo` VALUES (82, 3, '铅笔', 265.00, '办公', 41);
INSERT INTO `matetialinfo` VALUES (83, 2, '铅笔', 452.00, '办公', 1);
INSERT INTO `matetialinfo` VALUES (84, 2, '橡皮擦', 311.00, '办公', 1);
INSERT INTO `matetialinfo` VALUES (85, 2, '橡皮擦', 310.00, '办公', 45);
INSERT INTO `matetialinfo` VALUES (86, 2, '杀虫剂', 130.00, '办公', 25);
INSERT INTO `matetialinfo` VALUES (87, 4, '打扫用具', 299.00, '办公', 38);
INSERT INTO `matetialinfo` VALUES (88, 1, '螺丝刀', 328.00, '办公', 35);
INSERT INTO `matetialinfo` VALUES (89, 1, '铅笔', 434.00, '办公', 2);
INSERT INTO `matetialinfo` VALUES (90, 4, '橡皮擦', 356.00, '办公', 27);
INSERT INTO `matetialinfo` VALUES (91, 1, '铅笔', 49.00, '办公', 46);
INSERT INTO `matetialinfo` VALUES (92, 2, '螺丝刀', 117.00, '办公', 27);
INSERT INTO `matetialinfo` VALUES (93, 2, '橡皮擦', 327.00, '办公', 21);
INSERT INTO `matetialinfo` VALUES (94, 1, '橡皮擦', 73.00, '办公', 38);
INSERT INTO `matetialinfo` VALUES (95, 1, '铅笔', 411.00, '办公', 22);
INSERT INTO `matetialinfo` VALUES (96, 2, '铅笔', 323.00, '办公', 3);
INSERT INTO `matetialinfo` VALUES (97, 2, '杀虫剂', 93.00, '办公', 35);
INSERT INTO `matetialinfo` VALUES (98, 1, '橡皮擦', 226.00, '办公', 13);
INSERT INTO `matetialinfo` VALUES (99, 2, '打扫用具', 240.00, '办公', 11);
INSERT INTO `matetialinfo` VALUES (100, 4, '打扫用具', 406.00, '办公', 47);
INSERT INTO `matetialinfo` VALUES (101, 2, '橡皮擦', 285.00, '办公', 1);
INSERT INTO `matetialinfo` VALUES (102, 2, '杀虫剂', 246.00, '办公', 16);
INSERT INTO `matetialinfo` VALUES (103, 1, '铅笔', 174.00, '办公', 22);
INSERT INTO `matetialinfo` VALUES (104, 2, '橡皮擦', 399.00, '办公', 10);
INSERT INTO `matetialinfo` VALUES (105, 2, '打扫用具', 313.00, '办公', 23);
INSERT INTO `matetialinfo` VALUES (106, 2, '螺丝刀', 98.00, '办公', 25);
INSERT INTO `matetialinfo` VALUES (107, 3, '铅笔', 295.00, '办公', 44);
INSERT INTO `matetialinfo` VALUES (108, 1, '螺丝刀', 234.00, '办公', 16);
INSERT INTO `matetialinfo` VALUES (109, 4, '打扫用具', 426.00, '办公', 46);
INSERT INTO `matetialinfo` VALUES (110, 2, '橡皮擦', 96.00, '办公', 29);
INSERT INTO `matetialinfo` VALUES (111, 1, '橡皮擦', 457.00, '办公', 37);
INSERT INTO `matetialinfo` VALUES (112, 1, '螺丝刀', 213.00, '办公', 31);
INSERT INTO `matetialinfo` VALUES (113, 4, '橡皮擦', 326.00, '办公', 29);
INSERT INTO `matetialinfo` VALUES (114, 1, '橡皮擦', 399.00, '办公', 37);
INSERT INTO `matetialinfo` VALUES (115, 2, '橡皮擦', 368.00, '办公', 42);
INSERT INTO `matetialinfo` VALUES (116, 4, '打扫用具', 172.00, '办公', 39);
INSERT INTO `matetialinfo` VALUES (117, 1, '打扫用具', 13.00, '办公', 40);
INSERT INTO `matetialinfo` VALUES (118, 2, '铅笔', 401.00, '办公', 14);
INSERT INTO `matetialinfo` VALUES (119, 1, '螺丝刀', 272.00, '办公', 36);
INSERT INTO `matetialinfo` VALUES (120, 1, '杀虫剂', 295.00, '办公', 19);
INSERT INTO `matetialinfo` VALUES (121, 2, '铅笔', 415.00, '办公', 4);
INSERT INTO `matetialinfo` VALUES (122, 4, '螺丝刀', 405.00, '办公', 45);
INSERT INTO `matetialinfo` VALUES (123, 4, '橡皮擦', 91.00, '办公', 39);
INSERT INTO `matetialinfo` VALUES (124, 4, '铅笔', 254.00, '办公', 4);
INSERT INTO `matetialinfo` VALUES (125, 1, '橡皮擦', 358.00, '办公', 39);
INSERT INTO `matetialinfo` VALUES (126, 3, '打扫用具', 253.00, '办公', 14);
INSERT INTO `matetialinfo` VALUES (127, 1, '杀虫剂', 153.00, '办公', 42);
INSERT INTO `matetialinfo` VALUES (128, 4, '杀虫剂', 265.00, '办公', 41);
INSERT INTO `matetialinfo` VALUES (129, 4, '铅笔', 489.00, '办公', 29);
INSERT INTO `matetialinfo` VALUES (130, 2, '打扫用具', 373.00, '办公', 12);
INSERT INTO `matetialinfo` VALUES (131, 4, '螺丝刀', 375.00, '办公', 35);
INSERT INTO `matetialinfo` VALUES (132, 4, '螺丝刀', 322.00, '办公', 43);
INSERT INTO `matetialinfo` VALUES (133, 4, '橡皮擦', 213.00, '办公', 24);
INSERT INTO `matetialinfo` VALUES (134, 3, '打扫用具', 489.00, '办公', 22);
INSERT INTO `matetialinfo` VALUES (135, 4, '橡皮擦', 174.00, '办公', 36);
INSERT INTO `matetialinfo` VALUES (136, 4, '螺丝刀', 120.00, '办公', 22);
INSERT INTO `matetialinfo` VALUES (137, 2, '螺丝刀', 45.00, '办公', 10);
INSERT INTO `matetialinfo` VALUES (138, 4, '打扫用具', 388.00, '办公', 10);
INSERT INTO `matetialinfo` VALUES (139, 3, '杀虫剂', 98.00, '办公', 24);
INSERT INTO `matetialinfo` VALUES (140, 4, '铅笔', 175.00, '办公', 49);
INSERT INTO `matetialinfo` VALUES (141, 4, '螺丝刀', 487.00, '办公', 23);
INSERT INTO `matetialinfo` VALUES (142, 3, '杀虫剂', 326.00, '办公', 24);
INSERT INTO `matetialinfo` VALUES (143, 3, '螺丝刀', 35.00, '办公', 30);
INSERT INTO `matetialinfo` VALUES (144, 3, '打扫用具', 375.00, '办公', 11);
INSERT INTO `matetialinfo` VALUES (145, 4, '橡皮擦', 178.00, '办公', 42);
INSERT INTO `matetialinfo` VALUES (146, 2, '杀虫剂', 280.00, '办公', 15);
INSERT INTO `matetialinfo` VALUES (147, 2, '铅笔', 379.00, '办公', 13);
INSERT INTO `matetialinfo` VALUES (148, 2, '铅笔', 455.00, '办公', 10);
INSERT INTO `matetialinfo` VALUES (149, 2, '打扫用具', 121.00, '办公', 37);
INSERT INTO `matetialinfo` VALUES (150, 3, '橡皮擦', 301.00, '办公', 1);
INSERT INTO `matetialinfo` VALUES (151, 4, '螺丝刀', 100.00, '办公', 40);
INSERT INTO `matetialinfo` VALUES (152, 3, '铅笔', 194.00, '办公', 48);
INSERT INTO `matetialinfo` VALUES (153, 3, '螺丝刀', 168.00, '办公', 24);
INSERT INTO `matetialinfo` VALUES (154, 3, '打扫用具', 298.00, '办公', 19);
INSERT INTO `matetialinfo` VALUES (155, 3, '螺丝刀', 398.00, '办公', 37);
INSERT INTO `matetialinfo` VALUES (156, 4, '铅笔', 326.00, '办公', 17);
INSERT INTO `matetialinfo` VALUES (157, 2, '螺丝刀', 21.00, '办公', 31);
INSERT INTO `matetialinfo` VALUES (158, 3, '打扫用具', 49.00, '办公', 11);
INSERT INTO `matetialinfo` VALUES (159, 4, '橡皮擦', 409.00, '办公', 14);
INSERT INTO `matetialinfo` VALUES (160, 3, '螺丝刀', 316.00, '办公', 34);
INSERT INTO `matetialinfo` VALUES (161, 4, '打扫用具', 339.00, '办公', 14);
INSERT INTO `matetialinfo` VALUES (162, 3, '铅笔', 88.00, '办公', 28);
INSERT INTO `matetialinfo` VALUES (163, 3, '螺丝刀', 303.00, '办公', 49);
INSERT INTO `matetialinfo` VALUES (184, 2, '厕纸1', 1211.00, '搽屁股', 10);
INSERT INTO `matetialinfo` VALUES (185, 4, '铅笔刀', -10.00, '啊啊啊啊', 66);

-- ----------------------------
-- Table structure for merchandiseinfo
-- ----------------------------
DROP TABLE IF EXISTS `merchandiseinfo`;
CREATE TABLE `merchandiseinfo`  (
  `merchandise_id` int(0) NOT NULL AUTO_INCREMENT,
  `build_id` int(0) NULL DEFAULT NULL,
  `purchasesale_id` int(0) NULL DEFAULT NULL,
  `merchandise_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `merchandise_type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `repository_count` int(0) NULL DEFAULT NULL,
  `merchandise_height` int(0) NULL DEFAULT NULL,
  `merchandise_size` int(0) NULL DEFAULT NULL,
  `merchandise_supplier` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `merchandise_count` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`merchandise_id`) USING BTREE,
  INDEX `FK_Relationship_3`(`build_id`) USING BTREE,
  INDEX `FK_Relationship_9`(`purchasesale_id`) USING BTREE,
  CONSTRAINT `FK_Relationship_3` FOREIGN KEY (`build_id`) REFERENCES `buildinfo` (`build_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 213 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of merchandiseinfo
-- ----------------------------
INSERT INTO `merchandiseinfo` VALUES (1, 6, 1, '鼠标', '电子设备', 5829, 200, 550, '罗技', 221);
INSERT INTO `merchandiseinfo` VALUES (3, NULL, NULL, '键盘', '外设', 52, 50, 2, '罗技', NULL);
INSERT INTO `merchandiseinfo` VALUES (4, 6, 1, 'RTX30600', '电子设备0', 100, 125, 0, '雷蛇xxx', 100);
INSERT INTO `merchandiseinfo` VALUES (5, 6, 1, 'RTX30601', '电子设备1', 100, 125, 1, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (6, 6, 1, 'RTX30602', '电子设备2', 100, 125, 2, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (7, 6, 1, 'RTX30603', '电子设备3', 100, 125, 3, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (8, 6, 1, 'RTX30604', '电子设备4', 100, 125, 4, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (9, 6, 1, 'RTX30605', '电子设备5', 100, 125, 5, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (10, 6, 1, 'RTX30606', '电子设备6', 100, 125, 6, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (11, 6, 1, 'RTX30607', '电子设备7', 100, 125, 7, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (12, 6, 1, 'RTX30608', '电子设备8', 100, 125, 8, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (13, 6, 1, 'RTX30609', '电子设备9', 100, 125, 9, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (14, 6, 1, 'RTX306010', '电子设备10', 100, 125, 10, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (15, 6, 1, 'RTX306011', '电子设备11', 100, 125, 11, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (16, 6, 1, 'RTX306012', '电子设备12', 100, 125, 12, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (17, 6, 1, 'RTX306013', '电子设备13', 100, 125, 13, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (18, 6, 1, 'RTX306014', '电子设备14', 100, 125, 14, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (19, 6, 1, 'RTX306015', '电子设备15', 100, 125, 15, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (20, 6, 1, 'RTX306016', '电子设备16', 100, 125, 16, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (21, 6, 1, 'RTX306017', '电子设备17', 100, 125, 17, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (22, 6, 1, 'RTX306018', '电子设备18', 100, 125, 18, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (23, 6, 1, 'RTX306019', '电子设备19', 100, 125, 19, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (24, 6, 1, 'RTX306020', '电子设备20', 100, 125, 20, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (25, 6, 1, 'RTX306021', '电子设备21', 100, 125, 21, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (26, 6, 1, 'RTX306022', '电子设备22', 100, 125, 22, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (27, 6, 1, 'RTX306023', '电子设备23', 100, 125, 23, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (28, 6, 1, 'RTX306024', '电子设备24', 100, 125, 24, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (29, 6, 1, 'RTX306025', '电子设备25', 100, 125, 25, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (30, 6, 1, 'RTX306026', '电子设备26', 100, 125, 26, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (31, 6, 1, 'RTX306027', '电子设备27', 100, 125, 27, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (32, 6, 1, 'RTX306028', '电子设备28', 100, 125, 28, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (33, 6, 1, 'RTX306029', '电子设备29', 100, 125, 29, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (34, 6, 1, 'RTX306030', '电子设备30', 100, 125, 30, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (35, 6, 1, 'RTX306031', '电子设备31', 100, 125, 31, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (36, 6, 1, 'RTX306032', '电子设备32', 100, 125, 32, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (37, 6, 1, 'RTX306033', '电子设备33', 100, 125, 33, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (38, 6, 1, 'RTX306034', '电子设备34', 100, 125, 34, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (39, 6, 1, 'RTX306035', '电子设备35', 100, 125, 35, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (40, 6, 1, 'RTX306036', '电子设备36', 100, 125, 36, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (41, 6, 1, 'RTX306037', '电子设备37', 100, 125, 37, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (42, 6, 1, 'RTX306038', '电子设备38', 100, 125, 38, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (43, 6, 1, 'RTX306039', '电子设备39', 100, 125, 39, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (44, 6, 1, 'RTX306040', '电子设备40', 100, 125, 40, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (45, 6, 1, 'RTX306041', '电子设备41', 100, 125, 41, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (46, 6, 1, 'RTX306042', '电子设备42', 100, 125, 42, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (47, 6, 1, 'RTX306043', '电子设备43', 100, 125, 43, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (48, 6, 1, 'RTX306044', '电子设备44', 100, 125, 44, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (49, 6, 1, 'RTX306045', '电子设备45', 100, 125, 45, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (50, 6, 1, 'RTX306046', '电子设备46', 100, 125, 46, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (51, 6, 1, 'RTX306047', '电子设备47', 100, 125, 47, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (52, 6, 1, 'RTX306048', '电子设备48', 100, 125, 48, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (53, 6, 1, 'RTX306049', '电子设备49', 100, 125, 49, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (54, 6, 1, 'RTX306050', '电子设备50', 100, 125, 50, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (55, 6, 1, 'RTX306051', '电子设备51', 100, 125, 51, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (56, 6, 1, 'RTX306052', '电子设备52', 100, 125, 52, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (57, 6, 1, 'RTX306053', '电子设备53', 100, 125, 53, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (58, 6, 1, 'RTX306054', '电子设备54', 100, 125, 54, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (59, 6, 1, 'RTX306055', '电子设备55', 100, 125, 55, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (60, 6, 1, 'RTX306056', '电子设备56', 100, 125, 56, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (61, 6, 1, 'RTX306057', '电子设备57', 100, 125, 57, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (62, 6, 1, 'RTX306058', '电子设备58', 100, 125, 58, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (63, 6, 1, 'RTX306059', '电子设备59', 100, 125, 59, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (64, 6, 1, 'RTX306060', '电子设备60', 100, 125, 60, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (65, 6, 1, 'RTX306061', '电子设备61', 100, 125, 61, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (66, 6, 1, 'RTX306062', '电子设备62', 100, 125, 62, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (67, 6, 1, 'RTX306063', '电子设备63', 100, 125, 63, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (68, 6, 1, 'RTX306064', '电子设备64', 100, 125, 64, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (69, 6, 1, 'RTX306065', '电子设备65', 100, 125, 65, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (70, 6, 1, 'RTX306066', '电子设备66', 100, 125, 66, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (71, 6, 1, 'RTX306067', '电子设备67', 100, 125, 67, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (72, 6, 1, 'RTX306068', '电子设备68', 100, 125, 68, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (73, 6, 1, 'RTX306069', '电子设备69', 100, 125, 69, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (74, 6, 1, 'RTX306070', '电子设备70', 100, 125, 70, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (75, 6, 1, 'RTX306071', '电子设备71', 100, 125, 71, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (76, 6, 1, 'RTX306072', '电子设备72', 100, 125, 72, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (77, 6, 1, 'RTX306073', '电子设备73', 100, 125, 73, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (78, 6, 1, 'RTX306074', '电子设备74', 100, 125, 74, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (79, 6, 1, 'RTX306075', '电子设备75', 100, 125, 75, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (80, 6, 1, 'RTX306076', '电子设备76', 100, 125, 76, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (81, 6, 1, 'RTX306077', '电子设备77', 100, 125, 77, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (82, 6, 1, 'RTX306078', '电子设备78', 100, 125, 78, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (83, 6, 1, 'RTX306079', '电子设备79', 100, 125, 79, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (84, 6, 1, 'RTX306080', '电子设备80', 100, 125, 80, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (85, 6, 1, 'RTX306081', '电子设备81', 100, 125, 81, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (86, 6, 1, 'RTX306082', '电子设备82', 100, 125, 82, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (87, 6, 1, 'RTX306083', '电子设备83', 100, 125, 83, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (88, 6, 1, 'RTX306084', '电子设备84', 100, 125, 84, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (89, 6, 1, 'RTX306085', '电子设备85', 100, 125, 85, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (90, 6, 1, 'RTX306086', '电子设备86', 100, 125, 86, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (91, 6, 1, 'RTX306087', '电子设备87', 100, 125, 87, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (92, 6, 1, 'RTX306088', '电子设备88', 100, 125, 88, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (93, 6, 1, 'RTX306089', '电子设备89', 100, 125, 89, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (94, 6, 1, 'RTX306090', '电子设备90', 100, 125, 90, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (95, 6, 1, 'RTX306091', '电子设备91', 100, 125, 91, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (96, 6, 1, 'RTX306092', '电子设备92', 100, 125, 92, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (97, 6, 1, 'RTX306093', '电子设备93', 100, 125, 93, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (98, 6, 1, 'RTX306094', '电子设备94', 100, 125, 94, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (99, 6, 1, 'RTX306095', '电子设备95', 100, 125, 95, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (100, 6, 1, 'RTX306096', '电子设备96', 100, 125, 96, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (101, 6, 1, 'RTX306097', '电子设备97', 100, 125, 97, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (102, 6, 1, 'RTX306098', '电子设备98', 100, 125, 98, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (103, 6, 1, 'RTX306099', '电子设备99', 100, 125, 99, '雷蛇', 100);
INSERT INTO `merchandiseinfo` VALUES (104, 6, 1, 'amd5800x0', 'cpu0', 100, 125, 0, 'amd', 100);
INSERT INTO `merchandiseinfo` VALUES (105, 6, 1, 'amd5800x1', 'cpu1', 100, 125, 1, 'amd', 100);
INSERT INTO `merchandiseinfo` VALUES (106, 6, 1, 'amd5800x2', 'cpu2', 100, 125, 2, 'amd', 100);
INSERT INTO `merchandiseinfo` VALUES (107, 6, 1, 'amd5800x3', 'cpu3', 100, 125, 3, 'amd', 100);
INSERT INTO `merchandiseinfo` VALUES (108, 6, 1, 'amd5800x4', 'cpu4', 100, 125, 4, 'amd', 100);
INSERT INTO `merchandiseinfo` VALUES (109, 6, 1, 'amd5800x5', 'cpu5', 100, 125, 5, 'amd', 100);
INSERT INTO `merchandiseinfo` VALUES (110, 6, 1, 'amd5800x6', 'cpu6', 100, 125, 6, 'amd', 100);
INSERT INTO `merchandiseinfo` VALUES (111, 6, 1, 'amd5800x7', 'cpu7', 100, 125, 7, 'amd', 100);
INSERT INTO `merchandiseinfo` VALUES (112, 6, 1, 'amd5800x8', 'cpu8', 100, 125, 8, 'amd', 100);
INSERT INTO `merchandiseinfo` VALUES (113, 6, 1, 'amd5800x9', 'cpu9', 100, 125, 9, 'amd', 100);
INSERT INTO `merchandiseinfo` VALUES (114, 6, 1, 'amd5800x10', 'cpu10', 100, 125, 10, 'amd', 100);
INSERT INTO `merchandiseinfo` VALUES (115, 6, 1, 'amd5800x11', 'cpu11', 100, 125, 11, 'amd', 100);
INSERT INTO `merchandiseinfo` VALUES (116, 6, 1, 'amd5800x12', 'cpu12', 100, 125, 12, 'amd', 100);
INSERT INTO `merchandiseinfo` VALUES (117, 6, 1, 'amd5800x13', 'cpu13', 100, 125, 13, 'amd', 100);
INSERT INTO `merchandiseinfo` VALUES (118, 6, 1, 'amd5800x14', 'cpu14', 100, 125, 14, 'amd', 100);
INSERT INTO `merchandiseinfo` VALUES (119, 6, 1, 'amd5800x15', 'cpu15', 100, 125, 15, 'amd', 100);
INSERT INTO `merchandiseinfo` VALUES (120, 6, 1, 'amd5800x16', 'cpu16', 100, 125, 16, 'amd', 100);
INSERT INTO `merchandiseinfo` VALUES (121, 6, 1, 'amd5800x17', 'cpu17', 100, 125, 17, 'amd', 100);
INSERT INTO `merchandiseinfo` VALUES (122, 6, 1, 'amd5800x18', 'cpu18', 100, 125, 18, 'amd', 100);
INSERT INTO `merchandiseinfo` VALUES (123, 6, 1, 'amd5800x19', 'cpu19', 100, 125, 19, 'amd', 100);
INSERT INTO `merchandiseinfo` VALUES (124, 6, 1, 'amd5800x20', 'cpu20', 100, 125, 20, 'amd', 100);
INSERT INTO `merchandiseinfo` VALUES (125, 6, 1, 'amd5800x21', 'cpu21', 100, 125, 21, 'amd', 100);
INSERT INTO `merchandiseinfo` VALUES (126, 6, 1, 'amd5800x22', 'cpu22', 100, 125, 22, 'amd', 100);
INSERT INTO `merchandiseinfo` VALUES (127, 6, 1, 'amd5800x23', 'cpu23', 100, 125, 23, 'amd', 100);
INSERT INTO `merchandiseinfo` VALUES (128, 6, 1, 'amd5800x24', 'cpu24', 100, 125, 24, 'amd', 100);
INSERT INTO `merchandiseinfo` VALUES (129, 6, 1, 'amd5800x25', 'cpu25', 100, 125, 25, 'amd', 100);
INSERT INTO `merchandiseinfo` VALUES (130, 6, 1, 'amd5800x26', 'cpu26', 100, 125, 26, 'amd', 100);
INSERT INTO `merchandiseinfo` VALUES (131, 6, 1, 'amd5800x27', 'cpu27', 100, 125, 27, 'amd', 100);
INSERT INTO `merchandiseinfo` VALUES (132, 6, 1, 'amd5800x28', 'cpu28', 100, 125, 28, 'amd', 100);
INSERT INTO `merchandiseinfo` VALUES (133, 6, 1, 'amd5800x29', 'cpu29', 100, 125, 29, 'amd', 100);
INSERT INTO `merchandiseinfo` VALUES (134, 6, 1, 'amd5800x30', 'cpu30', 100, 125, 30, 'amd', 100);
INSERT INTO `merchandiseinfo` VALUES (135, 6, 1, 'amd5800x31', 'cpu31', 100, 125, 31, 'amd', 100);
INSERT INTO `merchandiseinfo` VALUES (136, 6, 1, 'amd5800x32', 'cpu32', 100, 125, 32, 'amd', 100);
INSERT INTO `merchandiseinfo` VALUES (137, 6, 1, 'amd5800x33', 'cpu33', 100, 125, 33, 'amd', 100);
INSERT INTO `merchandiseinfo` VALUES (138, 6, 1, 'amd5800x34', 'cpu34', 100, 125, 34, 'amd', 100);
INSERT INTO `merchandiseinfo` VALUES (139, 6, 1, 'amd5800x35', 'cpu35', 100, 125, 35, 'amd', 100);
INSERT INTO `merchandiseinfo` VALUES (140, 6, 1, 'amd5800x36', 'cpu36', 100, 125, 36, 'amd', 100);
INSERT INTO `merchandiseinfo` VALUES (141, 6, 1, 'amd5800x37', 'cpu37', 100, 125, 37, 'amd', 100);
INSERT INTO `merchandiseinfo` VALUES (142, 6, 1, 'amd5800x38', 'cpu38', 100, 125, 38, 'amd', 100);
INSERT INTO `merchandiseinfo` VALUES (143, 6, 1, 'amd5800x39', 'cpu39', 100, 125, 39, 'amd', 100);
INSERT INTO `merchandiseinfo` VALUES (144, 6, 1, 'amd5800x40', 'cpu40', 100, 125, 40, 'amd', 100);
INSERT INTO `merchandiseinfo` VALUES (145, 6, 1, 'amd5800x41', 'cpu41', 100, 125, 41, 'amd', 100);
INSERT INTO `merchandiseinfo` VALUES (146, 6, 1, 'amd5800x42', 'cpu42', 100, 125, 42, 'amd', 100);
INSERT INTO `merchandiseinfo` VALUES (147, 6, 1, 'amd5800x43', 'cpu43', 100, 125, 43, 'amd', 100);
INSERT INTO `merchandiseinfo` VALUES (148, 6, 1, 'amd5800x44', 'cpu44', 100, 125, 44, 'amd', 100);
INSERT INTO `merchandiseinfo` VALUES (149, 6, 1, 'amd5800x45', 'cpu45', 100, 125, 45, 'amd', 100);
INSERT INTO `merchandiseinfo` VALUES (150, 6, 1, 'amd5800x46', 'cpu46', 100, 125, 46, 'amd', 100);
INSERT INTO `merchandiseinfo` VALUES (151, 6, 1, 'amd5800x47', 'cpu47', 100, 125, 47, 'amd', 100);
INSERT INTO `merchandiseinfo` VALUES (152, 6, 1, 'amd5800x48', 'cpu48', 100, 125, 48, 'amd', 100);
INSERT INTO `merchandiseinfo` VALUES (154, NULL, NULL, '我不知道', '我不知道', 1, 1, 1, '我不知道', NULL);
INSERT INTO `merchandiseinfo` VALUES (156, 6, 1, 'intel12900k50', 'cpu50', 100, 125, 50, 'intel', 100);
INSERT INTO `merchandiseinfo` VALUES (157, 6, 1, 'intel12900k51', 'cpu51', 100, 125, 51, 'intel', 100);
INSERT INTO `merchandiseinfo` VALUES (158, 6, 1, 'intel12900k52', 'cpu52', 100, 125, 52, 'intel', 100);
INSERT INTO `merchandiseinfo` VALUES (159, 6, 1, 'intel12900k53', 'cpu53', 100, 125, 53, 'intel', 100);
INSERT INTO `merchandiseinfo` VALUES (160, 6, 1, 'intel12900k54', 'cpu54', 100, 125, 54, 'intel', 100);
INSERT INTO `merchandiseinfo` VALUES (161, 6, 1, 'intel12900k55', 'cpu55', 100, 125, 55, 'intel', 100);
INSERT INTO `merchandiseinfo` VALUES (162, 6, 1, 'intel12900k56', 'cpu56', 100, 125, 56, 'intel', 100);
INSERT INTO `merchandiseinfo` VALUES (163, 6, 1, 'intel12900k57', 'cpu57', 100, 125, 57, 'intel', 100);
INSERT INTO `merchandiseinfo` VALUES (164, 6, 1, 'intel12900k58', 'cpu58', 100, 125, 58, 'intel', 100);
INSERT INTO `merchandiseinfo` VALUES (165, 6, 1, 'intel12900k59', 'cpu59', 100, 125, 59, 'intel', 100);
INSERT INTO `merchandiseinfo` VALUES (166, 6, 1, 'intel12900k60', 'cpu60', 100, 125, 60, 'intel', 100);
INSERT INTO `merchandiseinfo` VALUES (167, 6, 1, 'intel12900k61', 'cpu61', 100, 125, 61, 'intel', 100);
INSERT INTO `merchandiseinfo` VALUES (168, 6, 1, 'intel12900k62', 'cpu62', 100, 125, 62, 'intel', 100);
INSERT INTO `merchandiseinfo` VALUES (169, 6, 1, 'intel12900k63', 'cpu63', 100, 125, 63, 'intel', 100);
INSERT INTO `merchandiseinfo` VALUES (170, 6, 1, 'intel12900k64', 'cpu64', 100, 125, 64, 'intel', 100);
INSERT INTO `merchandiseinfo` VALUES (171, 6, 1, 'intel12900k65', 'cpu65', 100, 125, 65, 'intel', 100);
INSERT INTO `merchandiseinfo` VALUES (172, 6, 1, 'intel12900k66', 'cpu66', 100, 125, 66, 'intel', 100);
INSERT INTO `merchandiseinfo` VALUES (173, 6, 1, 'intel12900k67', 'cpu67', 100, 125, 67, 'intel', 100);
INSERT INTO `merchandiseinfo` VALUES (174, 6, 1, 'intel12900k68', 'cpu68', 100, 125, 68, 'intel', 100);
INSERT INTO `merchandiseinfo` VALUES (175, 6, 1, 'intel12900k69', 'cpu69', 100, 125, 69, 'intel', 100);
INSERT INTO `merchandiseinfo` VALUES (176, 6, 1, 'intel12900k70', 'cpu70', 100, 125, 70, 'intel', 100);
INSERT INTO `merchandiseinfo` VALUES (177, 6, 1, 'intel12900k71', 'cpu71', 100, 125, 71, 'intel', 100);
INSERT INTO `merchandiseinfo` VALUES (178, 6, 1, 'intel12900k72', 'cpu72', 100, 125, 72, 'intel', 100);
INSERT INTO `merchandiseinfo` VALUES (179, 6, 1, 'intel12900k73', 'cpu73', 100, 125, 73, 'intel', 100);
INSERT INTO `merchandiseinfo` VALUES (180, 6, 1, 'intel12900k74', 'cpu74', 100, 125, 74, 'intel', 100);
INSERT INTO `merchandiseinfo` VALUES (181, 6, 1, 'intel12900k75', 'cpu75', 100, 125, 75, 'intel', 100);
INSERT INTO `merchandiseinfo` VALUES (182, 6, 1, 'intel12900k76', 'cpu76', 100, 125, 76, 'intel', 100);
INSERT INTO `merchandiseinfo` VALUES (183, 6, 1, 'intel12900k77', 'cpu77', 100, 125, 77, 'intel', 100);
INSERT INTO `merchandiseinfo` VALUES (184, 6, 1, 'intel12900k78', 'cpu78', 100, 125, 78, 'intel', 100);
INSERT INTO `merchandiseinfo` VALUES (185, 6, 1, 'intel12900k79', 'cpu79', 100, 125, 79, 'intel', 100);
INSERT INTO `merchandiseinfo` VALUES (186, 6, 1, 'intel12900k80', 'cpu80', 100, 125, 80, 'intel', 100);
INSERT INTO `merchandiseinfo` VALUES (187, 6, 1, 'intel12900k81', 'cpu81', 100, 125, 81, 'intel', 100);
INSERT INTO `merchandiseinfo` VALUES (188, 6, 1, 'intel12900k82', 'cpu82', 100, 125, 82, 'intel', 100);
INSERT INTO `merchandiseinfo` VALUES (189, 6, 1, 'intel12900k83', 'cpu83', 100, 125, 83, 'intel', 100);
INSERT INTO `merchandiseinfo` VALUES (190, 6, 1, 'intel12900k84', 'cpu84', 100, 125, 84, 'intel', 100);
INSERT INTO `merchandiseinfo` VALUES (191, 6, 1, 'intel12900k85', 'cpu85', 100, 125, 85, 'intel', 100);
INSERT INTO `merchandiseinfo` VALUES (192, 6, 1, 'intel12900k86', 'cpu86', 100, 125, 86, 'intel', 100);
INSERT INTO `merchandiseinfo` VALUES (193, 6, 1, 'intel12900k87', 'cpu87', 100, 125, 87, 'intel', 100);
INSERT INTO `merchandiseinfo` VALUES (194, 6, 1, 'intel12900k88', 'cpu88', 100, 125, 88, 'intel', 100);
INSERT INTO `merchandiseinfo` VALUES (195, 6, 1, 'intel12900k89', 'cpu89', 100, 125, 89, 'intel', 100);
INSERT INTO `merchandiseinfo` VALUES (196, 6, 1, 'intel12900k90', 'cpu90', 100, 125, 90, 'intel', 100);
INSERT INTO `merchandiseinfo` VALUES (197, 6, 1, 'intel12900k91', 'cpu91', 100, 125, 91, 'intel', 100);
INSERT INTO `merchandiseinfo` VALUES (198, 6, 1, 'intel12900k92', 'cpu92', 100, 125, 92, 'intel', 100);
INSERT INTO `merchandiseinfo` VALUES (199, 6, 1, 'intel12900k93', 'cpu93', 100, 125, 93, 'intel', 100);
INSERT INTO `merchandiseinfo` VALUES (200, 6, 1, 'intel12900k94', 'cpu94', 100, 125, 94, 'intel', 100);
INSERT INTO `merchandiseinfo` VALUES (201, 6, 1, 'intel12900k95', 'cpu95', 100, 125, 95, 'intel', 100);
INSERT INTO `merchandiseinfo` VALUES (202, 6, 1, 'intel12900k96', 'cpu96', 100, 125, 96, 'intel', 100);
INSERT INTO `merchandiseinfo` VALUES (203, 6, 1, 'intel12900k97', 'cpu97', 100, 125, 97, 'intel', 100);
INSERT INTO `merchandiseinfo` VALUES (204, 6, 1, 'intel12900k98', 'cpu98', 100, 125, 98, 'intel', 100);
INSERT INTO `merchandiseinfo` VALUES (206, NULL, NULL, '拯救者', '电脑', 7, 21, 2, '联想', NULL);
INSERT INTO `merchandiseinfo` VALUES (208, NULL, NULL, 'qweqwe', '', NULL, NULL, NULL, '', NULL);
INSERT INTO `merchandiseinfo` VALUES (209, NULL, NULL, 'qwer', '', NULL, NULL, NULL, '', NULL);
INSERT INTO `merchandiseinfo` VALUES (210, NULL, NULL, 'er', '', NULL, NULL, NULL, '', NULL);
INSERT INTO `merchandiseinfo` VALUES (211, NULL, NULL, 'uio', '', NULL, NULL, NULL, '', NULL);
INSERT INTO `merchandiseinfo` VALUES (212, NULL, NULL, '456', '', NULL, NULL, NULL, '', NULL);
INSERT INTO `merchandiseinfo` VALUES (213, NULL, NULL, '789', '', NULL, NULL, NULL, '', NULL);

-- ----------------------------
-- Table structure for purchasesale
-- ----------------------------
DROP TABLE IF EXISTS `purchasesale`;
CREATE TABLE `purchasesale`  (
  `purchasesale_id` int(0) NOT NULL AUTO_INCREMENT,
  `purchasesale_type` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `purchasesale_price` decimal(10, 2) NULL DEFAULT NULL,
  `purchasesale_count` int(0) NULL DEFAULT NULL,
  `merchandise_id` int(0) NOT NULL,
  `merchandise_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`purchasesale_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of purchasesale
-- ----------------------------
INSERT INTO `purchasesale` VALUES (13, '购入', 100.00, 22, 1, '鼠标');
INSERT INTO `purchasesale` VALUES (14, '购入', 1200.00, 20, 1, '鼠标');
INSERT INTO `purchasesale` VALUES (15, '售出', 200.00, 1, 1, '鼠标');
INSERT INTO `purchasesale` VALUES (17, '购入', 2.00, 1, 1, '鼠标');
INSERT INTO `purchasesale` VALUES (18, '购入', 1.00, 11, 1, '鼠标');
INSERT INTO `purchasesale` VALUES (19, '售出', 11.00, 300, 1, '鼠标');
INSERT INTO `purchasesale` VALUES (21, '购入', 1.00, 1, 1, '1');
INSERT INTO `purchasesale` VALUES (22, '购入', 1.00, 1, 1, '1');
INSERT INTO `purchasesale` VALUES (23, '购入', 1.00, 1, 1, '1');
INSERT INTO `purchasesale` VALUES (24, '购入', 1.00, 1, 1, '111');

-- ----------------------------
-- Table structure for transportationinfo
-- ----------------------------
DROP TABLE IF EXISTS `transportationinfo`;
CREATE TABLE `transportationinfo`  (
  `transportation_id` bigint(0) NOT NULL AUTO_INCREMENT,
  `car_id` int(0) NULL DEFAULT NULL,
  `transportation_start_time` datetime(0) NULL DEFAULT NULL,
  `transportation_end_time` datetime(0) NULL DEFAULT NULL,
  `transportation_start_location` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `transportation_end_location` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `transportation_money` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`transportation_id`) USING BTREE,
  INDEX `FK_aaa`(`car_id`) USING BTREE,
  CONSTRAINT `FK_aaa` FOREIGN KEY (`car_id`) REFERENCES `carinfo` (`car_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 66 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of transportationinfo
-- ----------------------------
INSERT INTO `transportationinfo` VALUES (2, 15, '2022-10-02 13:40:06', '2022-10-29 01:01:46', '东仓库1', '西仓库1', '11000');
INSERT INTO `transportationinfo` VALUES (3, 17, '2022-10-03 13:40:06', '2022-10-29 01:02:46', '东仓库2', '西仓库2', '12000');
INSERT INTO `transportationinfo` VALUES (5, 14, '2022-10-05 01:40:06', '2022-10-29 01:04:46', '东仓库4', '西仓库4444', '750');
INSERT INTO `transportationinfo` VALUES (6, 14, '2022-10-06 13:40:06', '2022-10-29 13:05:46', '东仓库5', '西仓库5', '700');
INSERT INTO `transportationinfo` VALUES (7, 14, '2022-10-07 13:40:06', '2022-10-29 01:06:46', '东仓库6', '西西仓库6', '900');
INSERT INTO `transportationinfo` VALUES (8, 14, '2022-10-08 13:40:06', '2022-10-29 13:07:46', '东仓库7', '西仓库7', '80000');
INSERT INTO `transportationinfo` VALUES (9, 14, '2022-10-09 13:40:06', '2022-10-29 13:08:46', '东仓库8', '西仓库8', '1400');
INSERT INTO `transportationinfo` VALUES (10, 14, '2022-10-10 13:40:06', '2022-10-29 13:09:46', '东仓库9', '西仓库9', '15000');
INSERT INTO `transportationinfo` VALUES (11, 14, '2022-10-11 13:40:06', '2022-10-29 13:10:46', '东仓库10', '西仓库10', '1111');
INSERT INTO `transportationinfo` VALUES (12, 14, '2022-10-12 13:40:06', '2022-10-29 13:11:46', '东仓库11', '西仓库11', '1555');
INSERT INTO `transportationinfo` VALUES (13, 14, '2022-10-13 13:40:06', '2022-10-29 13:12:46', '东仓库12', '西仓库12', '17000');
INSERT INTO `transportationinfo` VALUES (14, 14, '2022-10-14 13:40:06', '2022-10-29 13:13:46', '东仓库13', '西仓库13', '18000');
INSERT INTO `transportationinfo` VALUES (15, 14, '2022-10-15 13:40:06', '2022-10-29 13:14:46', '东仓库14', '西仓库14', '1900');
INSERT INTO `transportationinfo` VALUES (16, 14, '2022-10-16 13:40:06', '2022-10-29 13:15:46', '东仓库15', '西仓库15', '2000');
INSERT INTO `transportationinfo` VALUES (17, 14, '2022-10-17 13:40:06', '2022-10-29 13:16:46', '东仓库16', '西仓库16', '1850');
INSERT INTO `transportationinfo` VALUES (18, 14, '2022-10-18 13:40:06', '2022-10-29 13:17:46', '东仓库17', '西仓库17', '2200');
INSERT INTO `transportationinfo` VALUES (19, 14, '2022-10-19 13:40:06', '2022-10-29 13:18:46', '东仓库18', '西仓库18', '2400');
INSERT INTO `transportationinfo` VALUES (20, 14, '2022-10-20 13:40:06', '2022-10-29 13:19:46', '东仓库19', '西仓库19', '2600');
INSERT INTO `transportationinfo` VALUES (21, 14, '2022-10-21 13:40:06', '2022-10-29 13:20:46', '东仓库20', '西仓库20', '30000');
INSERT INTO `transportationinfo` VALUES (22, 14, '2022-10-22 13:40:06', '2022-10-29 13:21:46', '东仓库21', '西仓库21', '2500');
INSERT INTO `transportationinfo` VALUES (23, 14, '2022-10-23 13:40:06', '2022-10-29 13:22:46', '东仓库22', '西仓库22', '2100');
INSERT INTO `transportationinfo` VALUES (24, 14, '2022-10-24 13:40:06', '2022-10-29 13:23:46', '东仓库23', '西仓库23', '4000');
INSERT INTO `transportationinfo` VALUES (25, 14, '2022-10-25 13:40:06', '2022-10-29 13:24:46', '东仓库24', '西仓库24', '3300');
INSERT INTO `transportationinfo` VALUES (26, 14, '2022-10-26 13:40:06', '2022-10-29 13:25:46', '东仓库25', '西仓库25', '3700');
INSERT INTO `transportationinfo` VALUES (27, 14, '2022-10-27 13:40:06', '2022-10-29 13:26:46', '东仓库26', '西仓库26', '4500');
INSERT INTO `transportationinfo` VALUES (28, 14, '2022-10-28 13:40:06', '2022-10-29 13:27:46', '东仓库27', '西仓库27', '17620');
INSERT INTO `transportationinfo` VALUES (29, 14, '2022-10-29 13:40:06', '2022-10-29 13:28:46', '东仓库28', '西仓库28', '3522');
INSERT INTO `transportationinfo` VALUES (30, 14, '2022-10-31 13:40:06', '2022-10-29 13:29:46', '东仓库29', '西仓库29', '4600');
INSERT INTO `transportationinfo` VALUES (31, 14, '2022-11-01 13:40:06', '2022-10-29 13:30:46', '东仓库30', '西仓库30', '8500');
INSERT INTO `transportationinfo` VALUES (32, 14, '2022-11-02 13:40:06', '2022-10-29 13:31:46', '东仓库31', '西仓库31', '7777');
INSERT INTO `transportationinfo` VALUES (33, 14, '2022-11-03 13:40:06', '2022-10-29 13:32:46', '东仓库32', '西仓库32', '6500');
INSERT INTO `transportationinfo` VALUES (34, 14, '2022-11-04 13:40:06', '2022-10-29 13:33:46', '东仓库33', '西仓库33', '5600');
INSERT INTO `transportationinfo` VALUES (35, 14, '2022-11-05 13:40:06', '2022-10-29 13:34:46', '东仓库34', '西仓库34', '6460');
INSERT INTO `transportationinfo` VALUES (36, 14, '2022-11-06 13:40:06', '2022-10-29 13:35:46', '东仓库35', '西仓库35', '2585');
INSERT INTO `transportationinfo` VALUES (37, 14, '2022-11-07 13:40:06', '2022-10-29 13:36:46', '东仓库36', '西仓库36', '9533');
INSERT INTO `transportationinfo` VALUES (38, 14, '2022-11-08 13:40:06', '2022-10-29 13:37:46', '东仓库37', '西仓库37', '4450');
INSERT INTO `transportationinfo` VALUES (39, 14, '2022-11-09 13:40:06', '2022-10-29 13:38:46', '东仓库38', '西仓库38', '3285');
INSERT INTO `transportationinfo` VALUES (40, 14, '2022-11-10 13:40:06', '2022-10-29 13:39:46', '东仓库39', '西仓库39', '10001');
INSERT INTO `transportationinfo` VALUES (41, 14, '2022-11-11 13:40:06', '2022-10-29 13:40:46', '东仓库40', '西仓库40', '7466');
INSERT INTO `transportationinfo` VALUES (42, 14, '2022-11-12 13:40:06', '2022-10-29 13:41:46', '东仓库41', '西仓库41', '8880');
INSERT INTO `transportationinfo` VALUES (43, 14, '2022-11-13 13:40:06', '2022-10-29 13:42:46', '东仓库42', '西仓库42', '5800');
INSERT INTO `transportationinfo` VALUES (44, 14, '2022-11-14 13:40:06', '2022-10-29 13:43:46', '东仓库43', '西仓库43', '5900');
INSERT INTO `transportationinfo` VALUES (45, 14, '2022-11-15 13:40:06', '2022-10-29 13:44:46', '东仓库44', '西仓库44', '4800');
INSERT INTO `transportationinfo` VALUES (46, 14, '2022-11-16 13:40:06', '2022-10-29 13:45:46', '东仓库45', '西仓库45', '4990');
INSERT INTO `transportationinfo` VALUES (47, 14, '2022-11-17 13:40:06', '2022-10-29 13:46:46', '东仓库46', '西仓库46', '19990');
INSERT INTO `transportationinfo` VALUES (48, 14, '2022-11-18 13:40:06', '2022-10-29 13:47:46', '东仓库47', '西仓库47', '36990');
INSERT INTO `transportationinfo` VALUES (49, 14, '2022-11-19 13:40:06', '2022-10-29 13:48:46', '东仓库48', '西仓库48', '8200');
INSERT INTO `transportationinfo` VALUES (50, 14, '2022-11-20 13:40:06', '2022-10-29 13:49:46', '东仓库49', '西仓库49', '81000');
INSERT INTO `transportationinfo` VALUES (51, 14, '2022-11-21 13:40:06', '2022-10-29 13:50:46', '东仓库50', '西仓库50', '7900');
INSERT INTO `transportationinfo` VALUES (52, 14, '2022-11-22 13:40:06', '2022-10-29 13:51:46', '东仓库51', '西仓库51', '39000');
INSERT INTO `transportationinfo` VALUES (53, 14, '2022-11-23 13:40:06', '2022-10-29 13:52:46', '东仓库52', '西仓库52', '9600');
INSERT INTO `transportationinfo` VALUES (54, 14, '2022-11-24 13:40:06', '2022-10-29 13:53:46', '东仓库53', '西仓库53', '9120');
INSERT INTO `transportationinfo` VALUES (55, 14, '2022-11-25 13:40:06', '2022-10-29 13:54:46', '东仓库54', '西仓库54', '8000');
INSERT INTO `transportationinfo` VALUES (56, 14, '2022-11-26 13:40:06', '2022-10-29 13:55:46', '东仓库55', '西仓库55', '7500');
INSERT INTO `transportationinfo` VALUES (57, 14, '2022-11-27 13:40:06', '2022-10-29 13:56:46', '东仓库56', '西仓库56', '6800');
INSERT INTO `transportationinfo` VALUES (62, 14, '2022-10-23 16:00:00', '2022-10-29 16:00:02', 'aaaa', 'aaa', '3111');
INSERT INTO `transportationinfo` VALUES (66, 50, '2022-07-01 16:00:00', '2022-07-08 16:00:00', '123', '123', '123');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int(0) NOT NULL AUTO_INCREMENT,
  `authority_id` int(0) NULL DEFAULT NULL,
  `user_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_pwd` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE,
  INDEX `FK_Relationship_12`(`authority_id`) USING BTREE,
  CONSTRAINT `FK_Relationship_12` FOREIGN KEY (`authority_id`) REFERENCES `authority` (`authority_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 43 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 1, '张三', 'f78e56eb70dfff0c76203fce2c52c234');
INSERT INTO `user` VALUES (3, 1, '张三', 'f78e56eb70dfff0c76203fce2c52c234');
INSERT INTO `user` VALUES (4, 1, '张三', 'f78e56eb70dfff0c76203fce2c52c234');
INSERT INTO `user` VALUES (5, 1, '张三', 'f78e56eb70dfff0c76203fce2c52c234');
INSERT INTO `user` VALUES (6, 1, '张三', 'f78e56eb70dfff0c76203fce2c52c234');
INSERT INTO `user` VALUES (7, 1, '张三', 'f78e56eb70dfff0c76203fce2c52c234');
INSERT INTO `user` VALUES (8, 1, '张三', 'f78e56eb70dfff0c76203fce2c52c234');
INSERT INTO `user` VALUES (9, 1, '张三', 'f78e56eb70dfff0c76203fce2c52c234');
INSERT INTO `user` VALUES (10, 1, '张三', 'f78e56eb70dfff0c76203fce2c52c234');
INSERT INTO `user` VALUES (11, 1, '张三', 'f78e56eb70dfff0c76203fce2c52c234');
INSERT INTO `user` VALUES (12, 1, '张三', 'f78e56eb70dfff0c76203fce2c52c234');
INSERT INTO `user` VALUES (13, 1, '张三', 'f78e56eb70dfff0c76203fce2c52c234');
INSERT INTO `user` VALUES (14, 1, '张三', 'f78e56eb70dfff0c76203fce2c52c234');
INSERT INTO `user` VALUES (15, 1, '张三', 'f78e56eb70dfff0c76203fce2c52c234');
INSERT INTO `user` VALUES (16, 1, '张三', 'f78e56eb70dfff0c76203fce2c52c234');
INSERT INTO `user` VALUES (17, 1, '张三', 'f78e56eb70dfff0c76203fce2c52c234');
INSERT INTO `user` VALUES (18, 1, '张三', 'f78e56eb70dfff0c76203fce2c52c234');
INSERT INTO `user` VALUES (19, 1, '张三', 'f78e56eb70dfff0c76203fce2c52c234');
INSERT INTO `user` VALUES (20, 1, '张三', 'f78e56eb70dfff0c76203fce2c52c234');
INSERT INTO `user` VALUES (21, 1, '张三', 'f78e56eb70dfff0c76203fce2c52c234');
INSERT INTO `user` VALUES (22, 1, '张三', 'f78e56eb70dfff0c76203fce2c52c234');
INSERT INTO `user` VALUES (23, 1, '张三', 'f78e56eb70dfff0c76203fce2c52c234');
INSERT INTO `user` VALUES (24, 1, '张三', 'f78e56eb70dfff0c76203fce2c52c234');
INSERT INTO `user` VALUES (25, 1, '张三', 'f78e56eb70dfff0c76203fce2c52c234');
INSERT INTO `user` VALUES (26, 2, '张三', 'f78e56eb70dfff0c76203fce2c52c234');
INSERT INTO `user` VALUES (27, 2, '张三', 'f78e56eb70dfff0c76203fce2c52c234');
INSERT INTO `user` VALUES (28, 2, '张三', 'f78e56eb70dfff0c76203fce2c52c234');
INSERT INTO `user` VALUES (29, 1, '张三', 'f78e56eb70dfff0c76203fce2c52c234');
INSERT INTO `user` VALUES (30, 2, '张三', 'f78e56eb70dfff0c76203fce2c52c234');
INSERT INTO `user` VALUES (31, 1, '张三', 'f78e56eb70dfff0c76203fce2c52c234');
INSERT INTO `user` VALUES (32, 2, '张三', 'f78e56eb70dfff0c76203fce2c52c234');
INSERT INTO `user` VALUES (33, 1, '张三', 'f78e56eb70dfff0c76203fce2c52c234');
INSERT INTO `user` VALUES (34, 2, '张三', 'f78e56eb70dfff0c76203fce2c52c234');
INSERT INTO `user` VALUES (35, 1, '张三', 'f78e56eb70dfff0c76203fce2c52c234');
INSERT INTO `user` VALUES (36, 1, '张三', 'f78e56eb70dfff0c76203fce2c52c234');
INSERT INTO `user` VALUES (37, 2, '张三', 'f78e56eb70dfff0c76203fce2c52c234');
INSERT INTO `user` VALUES (38, 1, '张三', 'f78e56eb70dfff0c76203fce2c52c234');
INSERT INTO `user` VALUES (39, 2, '张三', 'f78e56eb70dfff0c76203fce2c52c234');
INSERT INTO `user` VALUES (40, 2, '张三', 'f78e56eb70dfff0c76203fce2c52c234');
INSERT INTO `user` VALUES (41, 2, '张三', 'f78e56eb70dfff0c76203fce2c52c234');
INSERT INTO `user` VALUES (42, 1, '张三', 'f78e56eb70dfff0c76203fce2c52c234');
INSERT INTO `user` VALUES (43, 2, '张三', 'f78e56eb70dfff0c76203fce2c52c234');

SET FOREIGN_KEY_CHECKS = 1;
