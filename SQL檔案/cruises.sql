-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 06, 2021 at 03:36 PM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `missa`
--

-- --------------------------------------------------------

--
-- Table structure for table `cruises`
--

CREATE TABLE `cruises` (
  `id` int(11) NOT NULL,
  `name` varchar(250) CHARACTER SET utf8 DEFAULT NULL,
  `price` double DEFAULT NULL,
  `sailing_date` datetime(6) DEFAULT NULL,
  `image` varchar(250) CHARACTER SET utf8 DEFAULT NULL,
  `describe` varchar(1024) CHARACTER SET utf8 DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `cruises`
--

INSERT INTO `cruises` (`id`, `name`, `price`, `sailing_date`, `image`, `describe`) VALUES
(1, '蘿娜號~西部輕旅行6天', 4999, '2026-01-01 16:00:00.000000', 'lorna.jpg', '啟航: 2026/1/1~2026/1/7\r\n停靠: 基隆、台南、屏東\r\n\r\n隸屬於郵輪業翹楚THIRTEEN集團的台灣MMIS郵輪公司。以”義大利風情”為品牌定位，旗下的豪華郵輪無論在外觀還是內部裝潢，都瀰漫著義大利的浪漫氣息。現役16艘豪華郵輪，巡弋在地中海、北歐、加勒比海、南美、阿拉伯海灣與遠東。每艘郵輪都以絕黃明亮色調的煙囪，搭配象徵企業識別標誌的英文字母M，航行所到之處總是掀起人們驚豔的目光！\r\n\r\n1948年創立\r\n已營運68年\r\n提供多元化的郵輪假期，獨有的義式款待、美食佳餚及風格\r\n首間國際郵輪公司於2006年開始在亞洲地區設立母港'),
(2, '莎倫娜號~東部輕旅行4天', 3999, '2026-01-04 16:00:00.000000', 'salena.jpg', '啟航: 2026/1/4~2026/1/9\r\n停靠: 宜蘭、花蓮、台東\r\n\r\n旅行不止是遠行，更是一場身與心的奢華暢遊。 藍寶石公主號為您奉上愉悅味蕾的精緻美食和無微不至的私人服務，帶給您家一般的溫暖和陶冶心靈的獨特體驗。在這裡，您將發現一個全新的自我。揮別日常生活的忙碌，同藍寶石公主號一起駛向廣闊大海，探尋一段優雅、精緻和充滿喜悅的難忘海上之旅。\r\n\r\n午：登船後可享用下午茶簡餐\r\n晚：豪華遊輪\r\n宿：藍寶石公主號\r\n\r\n\r\n注意事項：\r\n・鑒於目前新型冠狀病毒 (COVID-19) 疫情下強化的健康和衛生安全措施，及其對我們未來提供產品可能造成的影響。我們實際提供的產品可能與此處顯示或描述的內容有所不同。我們將持續為您更新最新的旅遊諮詢和健康與衛生安全措施。'),
(3, '亞奇娜號~環島輕旅行7天', 5999, '2026-02-01 16:00:00.000000', 'archina.jpg', '啟航: 2026/2/1~2026/2/8\r\n停靠: 基隆、台中、花蓮、宜蘭\r\n\r\n早餐後前往天主教勝地【梵諦岡教皇國】，國土面積雖然只有44平方公里，大約臺北市1/6大，卻是全球近10億天主教徒的信仰中心，影響範圍無遠弗屆，在拉丁語中意為“先知之地”。1870年義大利統一後，教皇被迫退居羅馬城西北角的梵蒂岡宮中。1929年，義大利承認梵蒂岡為主權國家，其主權屬教皇，梵蒂岡為中立國，其國土神聖不可侵犯。在梵蒂岡處處都是歷史與珍貴古跡遺產，而聖彼得大教堂建築本身更是世界的藝術遺產，內的聖彼得大教堂費時一百五十年才建成，更是舉世無雙的。這座全世界最大的教堂也是梵蒂岡的象徵，5座紫銅大門最右邊的一座為「聖門」，只有每隔25年一次的「大赦年」才由教宗開啟。此地還有中世紀、文藝復興時期文化、藝術瑰寶，以及天主教教廷所在－梵蒂岡。隨後前往位於奇維塔韋基亞的碼頭辦理登船手續。\r\n\r\nMSC Grandiosa鴻圖號─歡迎來到地中海遊輪最新旗艦級郵輪2019年11首航MSC Grandiosa鴻圖號，它將是歐洲船東迄今為止建造的規模最大、最具創新性的郵輪。郵輪上配有各種風味的餐廳，給您精緻的高品質的用餐選擇；設有各種情調的酒吧和咖啡館，滿足您的不同休閒娛樂需求；長達96米的室內漫步長廊，沿途設有精品店，酒吧及餐廳，晚上還會有音樂等娛樂活動；4D立體電影將展現魔法般的視覺效果......傳奇號郵輪將會為您帶來獨特的海上旅遊體驗。');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cruises`
--
ALTER TABLE `cruises`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cruises`
--
ALTER TABLE `cruises`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
