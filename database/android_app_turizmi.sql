-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Sep 24, 2017 at 06:32 PM
-- Server version: 10.1.19-MariaDB
-- PHP Version: 5.6.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `android_app_turizmi`
--

-- --------------------------------------------------------

--
-- Table structure for table `administratori`
--
-- Creation: Sep 13, 2017 at 03:48 PM
--

CREATE TABLE `administratori` (
  `ID` int(11) NOT NULL,
  `Username` varchar(10) NOT NULL,
  `Password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- RELATIONS FOR TABLE `administratori`:
--

--
-- Dumping data for table `administratori`
--

INSERT INTO `administratori` (`ID`, `Username`, `Password`) VALUES
(1, 'admin', 'turizmi_shqiptar');

-- --------------------------------------------------------

--
-- Table structure for table `akomodimi`
--
-- Creation: Sep 13, 2017 at 03:55 PM
--

CREATE TABLE `akomodimi` (
  `ID_Resort` int(11) NOT NULL,
  `Resorti` varchar(30) NOT NULL,
  `Rankimi` varchar(10) NOT NULL,
  `Sherbimet` text NOT NULL,
  `ID_Vendi` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- RELATIONS FOR TABLE `akomodimi`:
--   `ID_Vendi`
--       `turizmi` -> `ID_Vendi`
--

--
-- Dumping data for table `akomodimi`
--

INSERT INTO `akomodimi` (`ID_Resort`, `Resorti`, `Rankimi`, `Sherbimet`, `ID_Vendi`) VALUES
(1, 'Aragosta Shengjin', '3-stars', 'Free Parking, Free WiFi, Family Rooms, Suites, Honeymoon Rooms, Restaurant, Pet Friendly, Airport Shuttle, Bar, Private Beach Area, Cleaning Services, Playground, Room Services, Babysitting\r\n', 1),
(2, 'Hotel Adria', '3-stars', 'Free Parking, Free WiFi, Family Rooms, Restaurant, Pet Friendly, Airport Shuttle, Bar', 1),
(3, 'Hotel Alba', '4-stars', 'Free Parking, Free WiFi, Family Rooms, Restaurant, Airport Shuttle, Bar.', 1),
(4, 'Hotel Vlora', '3-stars', 'Free Wi-Fi, Restaurant, family rooms, transport.', 3),
(5, 'Hotel Pavaresia', '2-stars', 'Free Wi-Fi, Restaurant, family rooms.', 3),
(6, 'Hotel Partner', '4-stars', 'Free Wi-Fi, free parking, family rooms, restaurant, bar', 3),
(7, 'Drymades Resort', '4-stars', 'Free Wi-Fi, free private parking, pet-friendly, playground, bar, family rooms, suite, ', 4),
(8, 'Stolis Hotel', '2-stars', 'wonderful view, terrace bar, free wifi', 4),
(9, 'Marilena Hotel', '3-stars', 'Bar, pool, barbecue, free Wifi, free parking, sea view. ', 6),
(10, 'Iliria Hotel', '3-stars', 'Free Wi-Fi, Restaurant, family rooms', 7),
(11, 'Saranda International Hotel', '4-stars', 'Free Wifi, Sea view, family rooms, free parking, children playground, water sport facilities', 7),
(12, 'Permeti Hotel', '2-stars', 'Double and single rooms, parking, bar', 14),
(13, 'Ramizi Hotel', '3-stars', 'Free Wi-Fi, restaurant, bar, free parking, 24-hour reception', 14),
(14, 'Buna Park Hotel', '4-stars', 'Free Wi-Fi, free parking, pool, restaurant, barbecue, water sport facilities', 15),
(15, 'Rozafa Hotel', '4-stars', 'Free parking, bar, free Wi-Fi, restaurant, cleaning services', 15),
(16, 'Hotel Colosseo', '4-stars', 'Fitness center, massage facilities, swimming pool, sauna, restaurant, free Wi-Fi, free parking, room services, cleaning services', 15),
(17, 'Osumi Hotel', '3-stars', 'Free Wi-Fi, bar, restaurant', 19),
(18, 'Castle Park Hotel', '3-stars', 'Restaurant, barbecue, playground', 19),
(19, 'Kalemi Hotel', '3-stars', 'Restaurant, bar, free Wi-Fi, free parking', 20),
(20, 'Cajupi Hotel', '3-stars', 'Restaurant, bar, conference room', 20),
(21, 'Zorgji', '3-stars', 'Restaurant, free Wi-fi, bar, free parking', 8),
(22, 'Guesthouse Polia', '4-stars', 'Restaurant, free Wi-fi, bar, free parking, terrace, hiking area', 8),
(23, 'Guesthouse Valbona', '3-stars', 'Restaurant, free Wi-fi, bar, free parking, mountain view', 9),
(24, 'Hotel Dini', '4-stars', 'Restaurant, free Wi-fi, bar, free parking, terrace, pet-friendly, table-tennis', 9),
(25, 'Vila Pepaj', '3-stars', 'Free Wi-fi, free parking, barbecue, restaurant, free use of bicycles', 10);

-- --------------------------------------------------------

--
-- Table structure for table `turizmi`
--
-- Creation: Sep 20, 2017 at 08:06 PM
--

CREATE TABLE `turizmi` (
  `ID_Vendi` int(11) NOT NULL,
  `Lloji` varchar(50) NOT NULL,
  `Vendi` varchar(30) NOT NULL,
  `Pershkrim` text NOT NULL,
  `Pika turistike` text NOT NULL,
  `Veprimtari` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- RELATIONS FOR TABLE `turizmi`:
--

--
-- Dumping data for table `turizmi`
--

INSERT INTO `turizmi` (`ID_Vendi`, `Lloji`, `Vendi`, `Pershkrim`, `Pika turistike`, `Veprimtari`) VALUES
(1, 'bregdetar', 'Shengjin', 'Shengjin is a tourist town located about 7 km west of Lezha district of northwestern Albania. The city is distinguished for its harbor and the wide beach.', 'port', 'swimming'),
(2, 'bregdetar', 'Pogradec', 'Pogradec is a town in southeastern Albania on the southwest coast of Lake Ohrid. Pogradec dominates a Mediterranean and partly continental Mediterranean climate with an average annual temperature of 12.3 ° C. The coldest month is January and the hottest month is August.', 'Drilon', 'swimming, dancing in open bars, boating'),
(3, 'bregdetar', 'Vlore', 'Vlora is a coastal city in the southwest of Albania. Vlora''s climate is typical of Mediterranean with a wet and warm winter and with a hot summer which reaches up to 40 degrees.', 'Kuz-Baba, The Cold Water, the Indipendence''s home, historical museum, National Park of Llogara', 'swimming, visiting'),
(4, 'bregdetar', 'Dhermi', 'Dhermi village Located on the Ionian Sea coast and on the slopes of the mountains, it is located 52 km south of Vlora, 72 km in Saranda and about 210 km from the capital of Tirana. Administratively, Dhërmi is part of Himara Municipality.', 'Pirates Cave, the bay of Gipse, Alevrat, Grama, Cika Mountain, St. Theodore''s Monastery, St. Mary''s Monastery.', 'swimming, visiting, sailing'),
(6, 'bregdetar', 'Ksamil', 'Ksamil is the small coastal village in southern Albania. It is located south of the city of Saranda, at the exit of the road to Butrint and is part of the Saranda District.', '', 'swimming'),
(7, 'bregdetar', 'Sarande', 'Saranda is a town in southern Albania located on the Ionian Sea coast. It is located on a mountain slope. Saranda has a typical Mediterranean climate.', 'Butrinti''s lagoon, port, Blue Eye', 'swimming, sailing, walking in nature'),
(8, 'malor-natyror', 'Theth', 'Theth is a village in the municipality of Shalë, in the district of Shkodra, Albania.', 'National Park, the mountains of the Alps, waterfalls, Grunas Canion', 'hiking, climbing, canoeing, walking in nature'),
(9, 'malor-natyror', 'Valbone', 'Valbona is a village in the Albanian Alps, 26 km from Bajram Curri, Tropoja District. The climate is quite cool during the summer.', 'the Valbona River, Valbona''s valley, the cave of Dragobi.', 'sailing, climbing, walking in nature, picnic'),
(10, 'malor-natyror', 'Razem', 'Razma is one of the tourist spots closest to the city of Shkodra. It is located in the commune of Shkrel, at a distance of 43 km from the city and 65 km from the coast (Velipoja). The area of Razma is about 900 m above sea level. This is very suitable for the development of summer and winter mountain tourism.', 'forest, the Cave of Lugjeve, water resources', 'skiing, horseback riding, hunting, bicycle riding'),
(11, 'malor-natyror', 'Gjinar', 'Gjinar is a village in Gjinar commune in the Elbasan District of Albania.', 'lake, forest', 'hiking, picnic, walking in nature, hunting'),
(12, 'malor-natyror', 'Dardhe', 'Dardhe village is 19 kilometers southeast of Korca, at a height above 1300 m.', 'forest, mountain', 'skiing, picnic, climbing'),
(13, 'malor-natyror', 'Voskopoje', 'Voskopoja is a municipality located about 21 km away from the city of Korca on a plateau 1160 meters above sea level.', 'churches, the bridge of Voskopoja, forests, the old village', 'skiing, climbing, walking, hunting, '),
(14, 'malor-natyror', 'Permet', 'Përmet is a city in the southeast of Albania and the center of the administrative unit with the same name Permet district.', 'Osumi''s canyons, churches, mosques', 'canoeing, picnic, walking'),
(15, 'historik-kulturor-arkeologjik', 'Shkoder', 'Shkodra (Shkodra) is a city and municipality in northwestern Albania. It is one of the geostrategic cities of proximity between the highlands, the lake, the sea and the important roads in the Western Balkans, with a millennium residential history in the city and the province.', 'castle, Buna river, Shkodra lake', 'visiting, swimming, bicycle riding'),
(16, 'historik-kulturor-arkeologjik', 'Kruje', 'Kruja is an Albanian town and lies 20 km north of Tirana Albanian capital.', 'castle, old bazaar, museum', 'shopping, visiting'),
(17, 'historik-kulturor-arkeologjik', 'Elbasan', 'The city of Elbasan is located in the Middle East. It lies in the Elbasan area, on the right-hand side of the middle flow of the Shkumbin River.', 'castle, Ethnographic museum, theater, Pedagogical school "Luigj Gurakuqi", Byshek, Shkumbini River, the hills of the Ullishte, the hills of Krasta', 'walking, visiting, picnic, swimming'),
(18, 'historik-kulturor-arkeologjik', 'Korce', 'Korça is a city in South East Albania. Korça has a Mediterranean continental climate. The hottest month is August (25 ° C), while the coldest month is January (2 ° C).', 'orthodox cathedral, Mesonjetorja school, bazaar, "Rinia" park', 'shopping, dancing, visiting'),
(19, 'historik-kulturor-arkeologjik', 'Berat', 'The city of Berat is set up as a fortress, on a rocky hill with a height of 187m above sea level on the right side of the Osumi River.', 'castle, Gorica''s bridge, orthodox cathedral, mosque, Osum River, Tomorri Mountain.', 'visiting the Cobo winery, walking, hiking, horse riding.'),
(20, 'historik-kulturor-arkeologjik', 'Gjirokaster', 'Gjirokastra is located on the side of Broad Mountain, on its northeastern slopes and on the left side of the Drino River valley.', 'castle, Drino River, Ethnographic museum, the Arms Museum, bazaar.', 'hiking, visiting');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `administratori`
--
ALTER TABLE `administratori`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `akomodimi`
--
ALTER TABLE `akomodimi`
  ADD PRIMARY KEY (`ID_Resort`),
  ADD KEY `ID_Vendi` (`ID_Vendi`);

--
-- Indexes for table `turizmi`
--
ALTER TABLE `turizmi`
  ADD PRIMARY KEY (`ID_Vendi`),
  ADD UNIQUE KEY `Vendi` (`Vendi`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `akomodimi`
--
ALTER TABLE `akomodimi`
  MODIFY `ID_Resort` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;
--
-- AUTO_INCREMENT for table `turizmi`
--
ALTER TABLE `turizmi`
  MODIFY `ID_Vendi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `akomodimi`
--
ALTER TABLE `akomodimi`
  ADD CONSTRAINT `akomodimi_ibfk_1` FOREIGN KEY (`ID_Vendi`) REFERENCES `turizmi` (`ID_Vendi`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
