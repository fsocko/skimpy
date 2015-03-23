-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Mar 21, 2015 at 06:47 PM
-- Server version: 5.6.20
-- PHP Version: 5.5.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `skimpy`
--

-- --------------------------------------------------------

--
-- Table structure for table `asda`
--

CREATE TABLE IF NOT EXISTS `asda` (
`ID` int(11) unsigned NOT NULL,
  `ShopID` varchar(200) DEFAULT NULL,
  `Name` varchar(100) DEFAULT NULL,
  `Unit` varchar(5) DEFAULT NULL,
  `Mass` double DEFAULT NULL,
  `Price` double DEFAULT NULL,
  `PPUPrice` double DEFAULT NULL,
  `PPUUnit` varchar(5) DEFAULT NULL,
  `FoodCat` varchar(100) DEFAULT NULL,
  `FoodCat2` varchar(100) DEFAULT NULL,
  `SuperMarket` char(2) DEFAULT NULL,
  `Calories` double DEFAULT NULL,
  `Proteins` double DEFAULT NULL,
  `Carbs` double DEFAULT NULL,
  `Sugars` double DEFAULT NULL,
  `Fats` double DEFAULT NULL,
  `Saturates` double DEFAULT NULL,
  `Salt` double DEFAULT NULL,
  `Fibre` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `portion_sizes`
--

CREATE TABLE IF NOT EXISTS `portion_sizes` (
`ID` int(11) unsigned NOT NULL,
  `FoodCat` varchar(50) NOT NULL,
  `Item` varchar(600) NOT NULL,
  `Mass` double DEFAULT NULL,
  `Unit` varchar(5) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=179 ;

--
-- Dumping data for table `portion_sizes`
--

INSERT INTO `portion_sizes` (`ID`, `FoodCat`, `Item`, `Mass`, `Unit`) VALUES
(1, 'Bakery Products', 'Bagels, tea biscuits, scones, rolls, buns, croissants, tortillas, soft bread sticks, soft pretzels, corn bread', 55, 'g'),
(2, 'Bakery Products', 'Pita', 55, 'g'),
(3, 'Bakery Products', 'Brownies', 40, 'g'),
(4, 'Bakery Products', 'Cake (heavy weight), cheese cake, pineapple upside-down, cake', 125, 'g'),
(5, 'Bakery Products', 'Cake (medium weight)light weight cake icing, Boston cream pie, cupcakes, eclairs, cream puffs', 80, 'g'),
(6, 'Bakery Products', 'Cake (light weight), angel food, chiffon, sponge cake', 55, 'g'),
(7, 'Bakery Products', 'Coffee cake, doughnut, danish, sweet roll, sweet bread, muffins', 55, 'g'),
(8, 'Bakery Products', 'Cookies, wafers', 30, 'g'),
(9, 'Bakery Products', 'Crackers, hard bread sticks, melba toast', 20, 'g'),
(10, 'Bakery Products', 'Dry breads, matzo, rusks', 30, 'g'),
(11, 'Bakery Products', 'Flaky pastry', 55, 'g'),
(12, 'Bakery Products', 'Toaster pastries', 55, 'g'),
(13, 'Bakery Products', 'Ice cream cones', 5, 'g'),
(14, 'Bakery Products', 'Croutons', 7, 'g'),
(15, 'Bakery Products', 'French toast, pancakes, waffles', 75, 'g'),
(16, 'Bakery Products', 'Grain-based bars with filling', 40, 'g'),
(17, 'Bakery Products', 'Grain-based bars, without filling', 30, 'g'),
(18, 'Bakery Products', 'Rice cakes, corn cakes', 15, 'g'),
(19, 'Bakery Products', 'Pies, tarts, cobblers, turnovers, pastry', 110, 'g'),
(20, 'Bakery ProductsBakery Products', 'Pizza crust', 55, 'g'),
(21, 'Bakery Products', 'Taco shell', 30, 'g'),
(22, 'Bakery Products', 'drink, beverages, iced tea, wine coolers', 355, 'ml'),
(23, 'Bakery Products', 'Sports drinks and water', 500, 'ml'),
(24, 'Bakery Products', 'Coffee', 175, 'ml'),
(25, 'Bakery Products', 'regular and instant tea', 175, 'ml'),
(26, 'Bakery Products', 'flavoured and sweetened tea', 250, 'mL'),
(27, 'Bakery Products', 'Cocoa, chocolate milk', 175, 'ml'),
(28, 'Cereals and Other Grain Products', 'Dry Hot breakfast cereals, Dry oatmeal, Dry cream of wheat', 40, 'g'),
(29, 'Cereals and Other Grain Products', 'Prepared Hot breakfast cereals, prepared oatmeal, Prepared cream of wheat', 250, 'ml'),
(30, 'Cereals and Other Grain Products', 'breakfast cereals, puffed', 15, 'g'),
(31, 'Cereals and Other Grain Products', 'Ready-to-eat breakfast cereals, puffed and coated, flaked, extruded', 30, 'g'),
(32, 'Cereals and Other Grain Products', 'breakfast cereals, fruit and nut, granola', 55, 'g'),
(33, 'Cereals and Other Grain Products', 'Bran and wheat germ', 15, 'g'),
(34, 'Cereals and Other Grain Products', 'Milled flax seeds', 15, 'g'),
(35, 'Cereals and Other Grain Products', 'Milled hemp seeds', 15, 'g'),
(36, 'Cereals and Other Grain Products', 'Flour, cornmeal', 30, 'g'),
(37, 'Cereals and Other Grain Products', 'Grains, such as rice or barley', 45, 'g'),
(38, 'Cereals and Other Grain Products', 'Pastas without sauce', 85, 'g'),
(39, 'Cereals and Other Grain Products', 'Pastas, dry and ready-to-eat, such as fried canned chow mein noodles', 25, 'g'),
(40, 'Cereals and Other Grain Products', 'Starch, such as cornstarch, potato starch, tapioca starch or wheat starch', 10, 'g'),
(41, 'Cereals and Other Grain Products', 'Stuffing', 100, 'g'),
(42, 'Cereals and Other Grain Products', 'Cheese, cream cheese, cheese spread', 30, 'g'),
(43, 'Cereals and Other Grain Products', 'Cottage cheese', 125, 'g'),
(44, 'Cereals and Other Grain Products', 'Cheese used as an ingredient, such as dry cottage cheese or ricotta cheese', 55, 'g'),
(45, 'Cereals and Other Grain Products', 'Hard cheese, grated, such as parmesan or romano', 15, 'g'),
(46, 'Cereals and Other Grain Products', 'Quark, fresh cheese and fresh dairy desserts', 100, 'g'),
(47, 'Cereals and Other Grain Products', 'Cream and cream substitute', 15, 'ml'),
(48, 'Cereals and Other Grain Products', 'Cream and cream substitute, powder', 2, 'g'),
(49, 'Cereals and Other Grain Products', 'Cream and cream substitute, aerosol or whipped', 15, 'g'),
(50, 'Cereals and Other Grain Products', 'Eggnog', 125, 'ml'),
(51, 'Cereals and Other Grain Products', 'Milk, evaporated or condensed', 15, 'ml'),
(52, 'Cereals and Other Grain Products', 'Plant-based beverages, milk, buttermilk and milk-based drinks, such as chocolate milk', 250, 'ml'),
(53, 'Cereals and Other Grain Products', 'Smoothie (if whey/dairy is a main ingredient)', 250, 'ml'),
(54, 'Cereals and Other Grain Products', 'Drinkable yogurt', 250, 'ml'),
(55, 'Cereals and Other Grain Products', 'Shakes and shake substitutes such as dairy shake mix', 250, 'ml'),
(56, 'Cereals and Other Grain Products', 'Sour cream', 30, 'ml'),
(57, 'Cereals and Other Grain Products', 'Yogurt', 175, 'g'),
(58, 'Desserts', 'Ice cream, ice milk, frozen yogurt, sherbet', 125, 'ml'),
(59, 'Desserts', 'Non-dairy desserts sold in tub', 125, 'ml'),
(60, 'Desserts', 'Dairy desserts, frozen, such as cakes, bars, sandwiches or cones', 125, 'ml'),
(61, 'Desserts', 'Non-dairy desserts, frozen, such as flavoured and sweetened ice or pops, frozen fruit juices in bars or cups', 75, 'ml'),
(62, 'Desserts', 'Sundaes', 250, 'ml'),
(63, 'Desserts', 'Custard, gelatin and pudding', 125, 'ml'),
(64, 'Dessert Toppings and Fillings', 'Dessert toppings, maple butter and marshmallow cream', 30, 'g'),
(65, 'Dessert Toppings and Fillings', 'Cake frostings and icings', 35, 'g'),
(66, 'Dessert Toppings and Fillings', 'Streusal topping', 35, 'g'),
(67, 'Dessert Toppings and Fillings', 'Pie fillings', 75, 'ml'),
(68, 'Egg and Egg Substitutes', 'Egg mixtures, such as egg foo young, scrambled eggs, omelets', 110, 'g'),
(69, 'Egg and Egg Substitutes', 'Eggs,including eggs in the shell, liquid eggs and liquid egg whites', 50, 'g'),
(70, 'Egg and Egg Substitutes', 'Egg substitutes', 50, 'g'),
(71, 'Fats and Oils', 'Butter, margarine, shortening, lard', 10, 'g'),
(72, 'Fats and Oils', 'Butter-flavoured spread (mostly vegetable oil)', 10, 'g'),
(73, 'Fats and Oils', 'Vegetable oil', 10, 'ml'),
(74, 'Fats and Oils', 'Butter replacement, powder', 2, 'g'),
(75, 'Fats and Oils', 'Dressings for salad', 30, 'ml'),
(76, 'Fats and Oils', 'Mayonnaise, sandwich spread and mayonnaise-type dressing', 15, 'ml'),
(77, 'Fats and Oils', 'Oil, spray type', 0.5, 'g'),
(78, 'Marine and Fresh Water Animals', 'Canned anchovies, anchovy paste and caviar ', 15, 'g'),
(79, 'Marine and Fresh Water Animals', 'Marine and fresh water animals with sauce, such as fish with cream sauce or shrimp with lobster sauce', 125, 'g'),
(80, 'Marine and Fresh Water Animals', 'Raw fish with sauce', 125, 'g'),
(81, 'Marine and Fresh Water Animals', 'Marine and fresh water animals, canned', 55, 'g'),
(82, 'Marine and Fresh Water Animals', 'Marine and fresh water animals, smoked or pickled, or spreads ', 55, 'g'),
(83, 'Fruits and Fruit Juices', 'Fruit, fresh, canned or frozen, coated or uncoated', 140, 'g'),
(84, 'Fruits and Fruit Juices', 'Candied or pickled fruit ', 30, 'g'),
(85, 'Fruits and Fruit Juices', 'Dried fruit, such as raisins, dates or figs', 40, 'g'),
(86, 'Fruits and Fruit Juices', 'Fruit for garnish or flavour, such as maraschino cherries ', 4, 'g'),
(87, 'Fruits and Fruit Juices', 'Fruit relishes', 60, 'ml'),
(88, 'Fruits and Fruit Juices', 'Avocado, used as an ingredient', 30, 'g'),
(89, 'Fruits and Fruit Juices', 'Cranberries, lemons and limes, used as ingredients', 55, 'g'),
(90, 'Fruits and Fruit Juices', 'Watermelon, cantaloupe, honeydew and other melons', 150, 'g'),
(91, 'Fruits and Fruit Juices', 'Juices, nectars and fruit drinks represented for use as substitutes for fruit juices', 250, 'ml'),
(92, 'Fruits and Fruit Juices', 'Juices, used as ingredients, such as lemon juice or lime juice', 5, 'ml'),
(93, 'Legumes', 'Bean curd (tofu) or tempeh ', 85, 'g'),
(94, 'Legumes', 'Beans, peas and lentils, such as white beans, kidney beans, romano beans, soybeans or chick peas', 100, 'g'),
(95, 'Meat, Poultry, Their Products and Substitutes ', 'Pork rinds and bacon', 54, 'g'),
(96, 'Meat, Poultry, Their Products and Substitutes ', 'Beef, pork and poultry breakfast strips', 30, 'g'),
(97, 'Meat, Poultry, Their Products and Substitutes ', 'Dried meat and poultry, such as jerky, dried beef or parma ham, as well as sausage products with a water activity of 0.90 or less, such as salami, dried thuringer or cervelat', 30, 'g'),
(98, 'Meat, Poultry, Their Products and Substitutes ', 'Luncheon meats such as bologna, blood pudding, minced luncheon roll, liver sausage, mortadella, ham and cheese loaf or headcheese', 75, 'g'),
(99, 'Meat, Poultry, Their Products and Substitutes ', 'Sausage products, such as linked sausage, Vienna sausage, wieners, breakfast sausage, frankfurters, pork sausage, bratwurst, kielbasa, Polish sausage, summer sausage, smoked sausage, smoked country sausage, pepperoni, knackwurst, thuringer and cervelat', 75, 'g'),
(100, 'Meat, Poultry, Their Products and Substitutes ', 'Sausage made with combination of seafood and pork (mostly seafood)', 75, 'g'),
(101, 'Meat, Poultry, Their Products and Substitutes ', 'Cuts of meat and poultry without sauce, and ready-to-cook cuts, with or without breading or batter, including marinated, tenderized and injected cuts', 125, 'g'),
(102, 'Meat, Poultry, Their Products and Substitutes ', 'Shish kebab (only marinated meat, no vegetables)', 125, 'g'),
(103, 'Meat, Poultry, Their Products and Substitutes ', 'Whole chicken (no stuffing)', 125, 'g'),
(104, 'Meat, Poultry, Their Products and Substitutes ', 'Turkey roast (no stuffing)', 125, 'g'),
(105, 'Meat, Poultry, Their Products and Substitutes ', 'Patties (including veggie burger patties), cutlettes, chopettes, steakettes, meatballs, sausage meat and ground meat, with or without breading or batter', 100, 'g'),
(106, 'Meat, Poultry, Their Products and Substitutes ', 'Falafels', 100, 'g'),
(107, 'Meat, Poultry, Their Products and Substitutes ', 'Corn dog on a stick (breaded)', 100, 'g'),
(108, 'Meat, Poultry, Their Products and Substitutes ', 'Cured meat products such as cured ham, dry cured ham, back bacon, cured pork back, dry cured cappicolo, corned beef, pastrami, country ham, cured pork shoulder picnic, cured poultry ham products, smoked meat or pickled meat', 85, 'g'),
(109, 'Meat, Poultry, Their Products and Substitutes ', 'Canned meat and poultry ', 55, 'g'),
(110, 'Meat, Poultry, Their Products and Substitutes ', 'Meat and poultry with sauce, such as meat in barbecue sauce or turkey with gravy, but excluding combination dishes', 140, 'g'),
(111, 'Miscellaneous category', 'Baking powder, baking soda, pectinand yeast', 0.6, 'g'),
(112, 'Miscellaneous category', 'Baking decorations, such as coloured sugars or sprinkles for cookies', 4, 'g'),
(113, 'Miscellaneous category', 'Bread crumbs and batter mixes', 30, 'g'),
(114, 'Miscellaneous category', 'Cooking wine', 30, 'ml'),
(115, 'Miscellaneous category', 'Cocoa powder', 5, 'g'),
(116, 'Miscellaneous category', 'Non-alcoholic drink mixers, such as pina colada or daiquiri', 250, 'ml'),
(117, 'Miscellaneous category', 'Chewing gum', 3, 'g'),
(118, 'Miscellaneous category', 'Salad and potato toppers, such as salad crunchies, salad crispins or substitutes for bacon bits', 7, 'g'),
(119, 'Miscellaneous category', 'Salt and salt substitute, as well as seasoned salt such as garlic salt', 1, 'g'),
(120, 'Miscellaneous category', 'Spices and herbs (no salt)', 0.5, 'g'),
(121, 'Combination Dishes', 'Measurable with a cup, such as casserole, hash, macaroni and cheese with or without meat, pot pie, spaghetti with sauce, stir fry, meat or poultry casserole, baked or refried beans, wieners and beans, meat chili, chili with beans, creamed chipped beef, beef or poultry ravioli in sauce, beef stroganoff, poultry à la king, Brunswick stew, goulash, stew, ragout or poutine,rice and vegetables, butter chicken with rice', 250, 'ml'),
(122, 'Combination Dishes', 'Not measurable with a cup, such as burritos, egg rolls, enchiladas, pizza (considered to be without sauce), pizza rolls, sausage rolls, pastry rolls, cabbage rolls, quiche, sandwiches, crackers and meat or poultry lunch-type packages, gyros, burger on a bun, frank on a bun, calzones, tacos, pockets stuffed with meat, lasagna, chicken cordon bleu, stuffed vegetables with meat or poultry, shish kabobs (if combination of meat and vegetables), empanadas, fajitas, souvlaki (if combination of meat and vegetables), meat pie or tourtière', 140, 'g'),
(123, 'Combination Dishes', 'Meat-filled cannelloni, no sauce', 1.69, 'NULL'),
(124, 'Combination Dishes', 'Stuffed turkey roast', 140, 'g'),
(125, 'Combination Dishes', 'Stuffed chicken', 140, 'g'),
(126, 'Combination Dishes', 'Dish measurable with a cup but net quantity and serving size declared in grams', 140, 'g'),
(127, 'Combination Dishes', 'Hors d''oeuvres', 50, 'g'),
(128, 'Nuts and Seeds', 'Nuts and seeds, not for use as snacks: whole, chopped, sliced, slivered or ground', 30, 'g'),
(129, 'Nuts and Seeds', 'Butters, pastes and creams, other than peanut butter', 30, 'g'),
(130, 'Nuts and Seeds', 'Peanut butter', 15, 'g'),
(131, 'Nuts and Seeds', 'Flours, such as coconut flour', 15, 'g'),
(132, 'Potatoes, Sweet Potatoes and Yams', 'French fries, hash browns, skins and pancakes', 85, 'g'),
(133, 'Potatoes, Sweet Potatoes and Yams', 'Fresh Potato, Frozen Potato', 110, 'g'),
(134, 'Potatoes, Sweet Potatoes and Yams', 'Potato vacuum packed', 125, 'g'),
(135, 'Potatoes, Sweet Potatoes and Yams', 'Potato Canned', 160, 'g'),
(136, 'Salads', 'Salads, egg, fish, shellfish, bean, fruit, vegetable, meat, ham or poultry salad, except those listed as a separate item', 100, 'g'),
(137, 'Salads', 'Gelatin salad', 120, 'g'),
(138, 'Salads', 'Pasta or potato salad', 140, 'g'),
(139, 'Sauces, Dips, Gravies and Condiments', 'Sauces for dipping, such as barbecue, hollandaise, tartar, mustard or sweet and sour sauce', 30, 'ml'),
(140, 'Sauces, Dips, Gravies and Condiments', 'Dips, such as legume or dairy-based', 30, 'g'),
(141, 'Sauces, Dips, Gravies and Condiments', 'main entrée sauce, spaghetti sauce', 125, 'ml'),
(142, 'Sauces, Dips, Gravies and Condiments', 'Minor main entrée sauce, pizza sauce, pesto sauce, or other sauces used as toppings such as white sauce, cheese sauce, salsa, cocktail sauce or gravy', 60, 'ml'),
(143, 'Sauces, Dips, Gravies and Condiments', 'Major condiments, such as ketchup, steak sauce, soy sauce, vinegar, teriyaki sauce or marinades', 15, 'ml'),
(144, 'Sauces, Dips, Gravies and Condiments', 'Minor condiments, such as horseradish, hot sauce, mustard, or Worcestershire sauce', 5, 'ml'),
(145, 'Sauces, Dips, Gravies and Condiments', 'Liquid smoke', 1.69, 'NULL'),
(146, 'Snacks', 'Chips, pretzels, popcorn, extruded snacks, grain-based snack mixes and fruit-based snacks, such as fruit chips', 50, 'g'),
(147, 'Snacks', 'Pita chips', 50, 'g'),
(148, 'Snacks', 'Nuts or seeds for use as snacks, shelled', 50, 'g'),
(149, 'Snacks', 'Meat or poultry snack food sticks', 20, 'g'),
(150, 'Soups', 'Soup', 250, 'ml'),
(151, 'Sugars and Sweets', 'Candies, chocolate bars, other chocolate product', 40, 'g'),
(152, 'Sugars and Sweets', 'Hard candies', 15, 'g'),
(153, 'Sugars and Sweets', 'Baking candies, chocolate chips', 15, 'g'),
(154, 'Sugars and Sweets', 'Breath mints', 2, 'g'),
(155, 'Sugars and Sweets', 'mini hard candies', 5, 'g'),
(156, 'Sugars and Sweets', 'Confectioner''s sugar, icing sugar', 30, 'g'),
(157, 'Sugars and Sweets', 'Bread spreads, honey, molasses', 20, 'g'),
(158, 'Sugars and Sweets', 'Jams, jellies, marmalades, fruit butters, spreads', 15, 'ml'),
(159, 'Sugars and Sweets', 'Marshmallows', 30, 'g'),
(160, 'Sugars and Sweets', 'Sugars', 4, 'g'),
(161, 'Sugars and Sweets', 'Syrup, chocolate syrup, maple syrup, corn syrup', 50, 'ml'),
(162, 'Vegetables', 'Vegetables without sauce, including cream style corn and stewed tomatoes', 85, 'g'),
(163, 'Vegetables', 'Onion rings', 85, 'g'),
(164, 'Vegetables', 'Breaded zucchini sticks', 85, 'g'),
(165, 'Vegetables', 'Vegetables with sauce', 110, 'g'),
(166, 'Vegetables', 'Vegetables primarily used for garnish or flavouring, fresh, canned or frozen, but not dried, such as parsley or garlic', 4, 'g'),
(167, 'Vegetables', 'Chili pepper and green onion', 30, 'g'),
(168, 'Vegetables', 'Seaweed', 15, 'g'),
(169, 'Vegetables', 'Dehydrated mushrooms', 15, 'g'),
(170, 'Vegetables', 'Lettuce and sprouts', 65, 'g'),
(171, 'Vegetables', 'Vegetable juice and vegetable drink', 250, 'ml'),
(172, 'Vegetables', 'Olives', 15, 'g'),
(173, 'Vegetables', 'Sun-dried tomato packed in oil', 15, 'g'),
(174, 'Vegetables', 'Pickles', 30, 'g'),
(175, 'Vegetables', 'Artichoke hearts', 30, 'g'),
(176, 'Vegetables', 'Relish', 15, 'ml'),
(177, 'Vegetables', 'Vegetable paste', 30, 'ml'),
(178, 'Vegetables', 'Vegetable sauce or purée', 60, 'ml');

-- --------------------------------------------------------

--
-- Table structure for table `sains`
--

CREATE TABLE IF NOT EXISTS `sains` (
`ID` int(11) unsigned NOT NULL,
  `ShopID` varchar(200) DEFAULT NULL,
  `Name` varchar(100) DEFAULT NULL,
  `Unit` varchar(5) DEFAULT NULL,
  `Mass` double DEFAULT NULL,
  `Price` double DEFAULT NULL,
  `PPUPrice` double DEFAULT NULL,
  `PPUUnit` varchar(5) DEFAULT NULL,
  `FoodCat` varchar(100) DEFAULT NULL,
  `FoodCat2` varchar(100) DEFAULT NULL,
  `SuperMarket` char(2) DEFAULT NULL,
  `Calories` double DEFAULT NULL,
  `Proteins` double DEFAULT NULL,
  `Carbs` double DEFAULT NULL,
  `Sugars` double DEFAULT NULL,
  `Fats` double DEFAULT NULL,
  `Saturates` double DEFAULT NULL,
  `Salt` double DEFAULT NULL,
  `Fibre` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `tesco`
--

CREATE TABLE IF NOT EXISTS `tesco` (
`ID` int(11) unsigned NOT NULL,
  `ShopID` varchar(200) DEFAULT NULL,
  `Name` varchar(100) DEFAULT NULL,
  `Unit` varchar(5) DEFAULT NULL,
  `Mass` double DEFAULT NULL,
  `Price` double DEFAULT NULL,
  `PPUPrice` double DEFAULT NULL,
  `PPUUnit` varchar(5) DEFAULT NULL,
  `FoodCat` varchar(100) DEFAULT NULL,
  `FoodCat2` varchar(100) DEFAULT NULL,
  `SuperMarket` char(2) DEFAULT NULL,
  `Calories` double DEFAULT NULL,
  `Proteins` double DEFAULT NULL,
  `Carbs` double DEFAULT NULL,
  `Sugars` double DEFAULT NULL,
  `Fats` double DEFAULT NULL,
  `Saturates` double DEFAULT NULL,
  `Salt` double DEFAULT NULL,
  `Fibre` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `asda`
--
ALTER TABLE `asda`
 ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `portion_sizes`
--
ALTER TABLE `portion_sizes`
 ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `sains`
--
ALTER TABLE `sains`
 ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `tesco`
--
ALTER TABLE `tesco`
 ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `asda`
--
ALTER TABLE `asda`
MODIFY `ID` int(11) unsigned NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `portion_sizes`
--
ALTER TABLE `portion_sizes`
MODIFY `ID` int(11) unsigned NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=179;
--
-- AUTO_INCREMENT for table `sains`
--
ALTER TABLE `sains`
MODIFY `ID` int(11) unsigned NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tesco`
--
ALTER TABLE `tesco`
MODIFY `ID` int(11) unsigned NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
