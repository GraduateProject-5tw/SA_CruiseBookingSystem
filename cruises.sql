-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- 主機： 127.0.0.1
-- 產生時間： 2020-12-21 12:17:02
-- 伺服器版本： 10.4.14-MariaDB
-- PHP 版本： 7.4.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- 資料庫： `missa`
--

-- --------------------------------------------------------

--
-- 資料表結構 `cruises`
--

CREATE TABLE `cruises` (
  `id` int(11) NOT NULL,
  `stop_port` varchar(250) CHARACTER SET utf8 NOT NULL,
  `name` varchar(250) CHARACTER SET utf8 DEFAULT NULL,
  `price` double DEFAULT NULL,
  `image` varchar(250) CHARACTER SET utf8 DEFAULT NULL,
  `describe` varchar(1024) CHARACTER SET utf8 DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- 傾印資料表的資料 `cruises`
--

INSERT INTO `cruises` (`id`, `stop_port`, `name`, `price`, `image`, `describe`) VALUES
(1, '基隆台南屏東', '蘿娜號~西部輕旅行4天', 4999, 'desktop/lorna.jpg', '啟航: 2026/1/1~2026/1/5\r\n停靠: 基隆、台南、屏東\r\n隸屬於郵輪業翹楚THIRTEEN集團的台灣MMIS郵輪公司。以”義大利風情”為品牌定位，旗下的豪華郵輪無論在外觀還是內部裝潢，都瀰漫著義大利的浪漫氣息。現役16艘豪華郵輪，巡弋在地中海、北歐、加勒比海、南美、阿拉伯海灣與遠東。每艘郵輪都以絕黃明亮色調的煙囪，搭配象徵企業識別標誌的英文字母M，航行所到之處總是掀起人們驚豔的目光！\r\n\r\n \r\n\r\n1948年創立\r\n已營運68年\r\n提供多元化的郵輪假期，獨有的義式款待、美食佳餚及風格\r\n首間國際郵輪公司於2006年開始在亞洲地區設立母港');

--
-- 已傾印資料表的索引
--

--
-- 資料表索引 `cruises`
--
ALTER TABLE `cruises`
  ADD PRIMARY KEY (`id`);

--
-- 在傾印的資料表使用自動遞增(AUTO_INCREMENT)
--

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `cruises`
--
ALTER TABLE `cruises`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
