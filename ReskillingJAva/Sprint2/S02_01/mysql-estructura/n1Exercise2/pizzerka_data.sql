CREATE DATABASE  IF NOT EXISTS `pizzeria` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `pizzeria`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: pizzeria
-- ------------------------------------------------------
-- Server version	8.0.37

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (1,1,'08001','Carrer de Balmes','123',NULL,NULL),(2,2,'17001','Carrer de la Barca','12',NULL,NULL),(3,3,'25001','Rambla de Ferran','78',NULL,NULL),(4,4,'43002','Carrer de Sant Magí','78',NULL,NULL),(5,1,'08003','Carrer de Provença','56','1','2'),(6,1,'08004','Avinguda Paral·lel','23','3','4'),(7,1,'08005','Plaça de Catalunya','12','5','3'),(8,2,'17003','Carrer de la Força','56','1','2'),(9,2,'17004','Avinguda Jaume I','23','5','3'),(10,2,'17005','Carrer de Santa Clara','12','6','7'),(11,3,'25003','Carrer Major','56','6','8'),(12,3,'25004','Avinguda Blondel','23','7','8'),(13,3,'25005','Carrer de la Unió','12','6','4'),(14,4,'43003','Rambla Nova','56','4','3'),(15,4,'43004','Avinguda de Catalunya','23','3','3'),(16,4,'43005','Carrer Major','12','2','2');
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` VALUES (1,'Barcelona',1),(2,'Girona',2),(3,'Lleida',3),(4,'Tarragona',4);
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES (1,'Marc','García','654321987',5),(2,'Sandra','Martínez','678945612',6),(3,'Jorge','López','612345678',7),(4,'Lucía','Fernández','689745123',8),(5,'Pablo','Pérez','666111222',9),(6,'Ana','García','633444555',10),(7,'Elena','Rodríguez','677888999',11),(8,'Sergio','Martínez','688999000',12),(9,'Laura','Hernández','699000111',13),(10,'David','Ruiz','633888777',14),(11,'María','Gómez','655777888',15),(12,'Manuel','Sánchez','677444555',16);
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,1,'cook','Juan','García','López','12345678A','123456789'),(2,1,'delivery_person','Laura','Sánchez','Fernández','32167854D','789123456'),(3,2,'cook','Pedro','Fernández','Ruiz','65478912E','321654987'),(4,2,'delivery_person','Ana','Díaz','Martínez','23456789H','789654321'),(5,3,'cook','Elena','Torres','Rodríguez','54321678J','321987654'),(6,3,'delivery_person','Sofía','Vázquez','Jiménez','56789123L','654321987'),(7,4,'cook','Miguel','Moreno','López','67891234M','987321456'),(8,4,'delivery_person','Carmen','Serrano','García','89012345P','987321456');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
INSERT INTO `order` VALUES (1,1,1,1,'pickup',21.98,'2023-06-10 14:00:00'),(2,1,2,2,'delivery',22.98,'2023-11-11 23:10:00'),(3,1,3,1,'pickup',2.99,'2023-10-20 12:00:00'),(4,2,4,3,'pickup',5.98,'2023-05-04 14:35:20'),(5,2,5,4,'delivery',29.97,'2024-03-02 13:35:00'),(6,2,6,4,'delivery',14.99,'2022-05-05 21:19:00'),(7,3,7,5,'pickup',7.98,'2023-07-08 22:30:14'),(8,3,8,5,'pickup',14.99,'2023-12-12 20:30:00'),(9,3,9,6,'delivery',14.99,'2022-04-08 17:52:00'),(10,4,10,7,'pickup',11.96,'2024-05-05 17:23:00'),(11,4,11,7,'pickup',15.49,'2023-04-09 17:10:00'),(12,4,12,8,'delivery',20.43,'2023-05-08 14:10:00');
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `order_has_product`
--

LOCK TABLES `order_has_product` WRITE;
/*!40000 ALTER TABLE `order_has_product` DISABLE KEYS */;
INSERT INTO `order_has_product` VALUES (1,1,2,2),(2,1,10,1),(3,2,3,2),(4,3,3,2),(5,3,5,1),(6,3,6,1),(7,4,14,1),(8,4,7,2),(9,5,1,3),(10,6,12,1),(11,7,10,1),(12,7,5,2),(13,8,12,1),(14,9,12,1),(15,10,14,1),(16,10,6,4),(17,11,13,1),(18,12,12,1),(19,12,5,2),(20,12,6,1),(21,12,4,1);
/*!40000 ALTER TABLE `order_has_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `pizza_category`
--

LOCK TABLES `pizza_category` WRITE;
/*!40000 ALTER TABLE `pizza_category` DISABLE KEYS */;
INSERT INTO `pizza_category` VALUES (1,'Vegetariana'),(2,'Carnes'),(3,'Mariscos'),(4,'Especiales');
/*!40000 ALTER TABLE `pizza_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'burguer','Classic Burger','A classic beef burger with cheese and pickles','classic_burger.jpg',9.99,NULL),(2,'burguer','BBQ Bacon Burger','A juicy burger topped with BBQ sauce and crispy bacon','bbq_bacon_burger.jpg',10.99,NULL),(3,'burguer','Mushroom Swiss Burger','Beef patty with sautéed mushrooms and Swiss cheese','mushroom_swiss_burger.jpg',11.49,NULL),(4,'drink','Cola','Classic cola soda','cola.jpg',2.49,NULL),(5,'drink','Orange Juice','Freshly squeezed orange juice','orange_juice.jpg',3.99,NULL),(6,'drink','Lemonade','Refreshing lemonade','lemonade.jpg',2.99,NULL),(7,'drink','Iced Tea','Sweetened iced tea','iced_tea.jpg',2.99,NULL),(8,'drink','Mineral Water','Natural mineral water','mineral_water.jpg',1.99,NULL),(9,'drink','Mango Smoothie','Creamy mango smoothie','mango_smoothie.jpg',4.49,NULL),(10,'pizza','Margarita','Classic pizza with tomato sauce, mozzarella, and basil','margarita_pizza.jpg',12.99,1),(11,'pizza','Vegetariana','Pizza con variedad de vegetales frescos','vegetariana_pizza.jpg',13.49,1),(12,'pizza','Pepperoni','Pizza con pepperoni y queso mozzarella','pepperoni_pizza.jpg',14.99,2),(13,'pizza','Barbacoa','Pizza con salsa barbacoa, carne y cebolla','barbacoa_pizza.jpg',15.49,2),(14,'pizza','Marinera','Pizza con variedad de mariscos','marinera_pizza.jpg',16.99,3),(15,'pizza','Gambas y Calamares','Pizza con gambas y calamares','gambas_calamares_pizza.jpg',17.49,3),(16,'pizza','Cuatro Quesos','Pizza con cuatro tipos de quesos','cuatro_quesos_pizza.jpg',18.99,4),(17,'pizza','Bufala','Pizza con mozzarella de búfala y tomate fresco','bufala_pizza.jpg',19.49,4);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `province`
--

LOCK TABLES `province` WRITE;
/*!40000 ALTER TABLE `province` DISABLE KEYS */;
INSERT INTO `province` VALUES (1,'Barcelona'),(2,'Girona'),(3,'Lleida'),(4,'Tarragona');
/*!40000 ALTER TABLE `province` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `store`
--

LOCK TABLES `store` WRITE;
/*!40000 ALTER TABLE `store` DISABLE KEYS */;
INSERT INTO `store` VALUES (1,1),(2,2),(3,3),(4,4);
/*!40000 ALTER TABLE `store` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-07-08 18:50:16
