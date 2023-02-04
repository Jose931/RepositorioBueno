-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 03-02-2023 a las 21:49:27
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `examen`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `examenes`
--

CREATE TABLE `examenes` (
  `id_examen` int(11) NOT NULL,
  `pregunta1` varchar(500) NOT NULL,
  `respuesta1` varchar(500) NOT NULL,
  `pregunta2` varchar(500) NOT NULL,
  `respuesta2` varchar(500) NOT NULL,
  `pregunta3` varchar(500) NOT NULL,
  `respuesta3` varchar(500) NOT NULL,
  `puntuacion` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `preguntas`
--

CREATE TABLE `preguntas` (
  `id_pregunta` int(11) NOT NULL,
  `pregunta` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `preguntas`
--

INSERT INTO `preguntas` (`id_pregunta`, `pregunta`) VALUES
(1, '¿Cual de los siguientes seres vivos son considerados animales?'),
(2, '¿Cual de las siguientes series es de animación?'),
(3, '¿Cual de estos músicos se dedica a hacer bandas sonoras?'),
(4, '¿Cual es el mejor equipo de futbol del mundo?'),
(5, '¿Cual de estas películas NO ha obtenido ningún Oscar?'),
(6, '¿En que año se descubrió América?'),
(7, '¿Cuales de estos elementos de la tabla periódica forman la molécula del agua?'),
(8, '¿Cuales de estos animales son mamíferos?'),
(9, '¿Cuales de estos colores forman la bandera de Alemania?'),
(10, '¿En que año empezó la II Guerra Mundial?'),
(11, '¿Cual de estos lenguajes de programación NO es un lenguaje de marcas?'),
(12, '¿Cual de los suiguientes actores y actrices aparecen en Star Wars?'),
(13, '¿Que lago es el mas grande del mundo?'),
(14, '¿Cuales de estos instrumentos NO es de cuerda?'),
(15, '¿Cual de estas palabras es sinónimo de agarrar? '),
(16, 'El único cuñado del hermano de tu madre esta durmiendo en el sillón. ¿Quien esta durmiendo en el sillón?'),
(17, 'Atraviesa ciudades y campos, pero nunca se mueve de lugar. ¿Que es?'),
(18, 'Cuanto da la raíz cuadrada de 144 multiplicado por 3?'),
(19, '¿Cual de las siguiente frutas se consideran ácidas?'),
(20, '¿Cual es el rio mas largo del mundo?');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `respuestas`
--

CREATE TABLE `respuestas` (
  `id_respuesta` int(11) NOT NULL,
  `respuesta` varchar(50) NOT NULL,
  `id_pregunta` int(3) DEFAULT NULL,
  `valida` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `respuestas`
--

INSERT INTO `respuestas` (`id_respuesta`, `respuesta`, `id_pregunta`, `valida`) VALUES
(92, 'Amapola', 1, 0),
(93, 'El Lobo de Wall Street', 2, 0),
(94, ' Los serrano', 2, 0),
(95, 'Los Simpson', 2, 1),
(96, 'Ana y los siete', 2, 0),
(97, 'Hans Zimmer', 3, 1),
(98, 'Michael Jackson', 3, 0),
(99, 'John Williams', 3, 1),
(100, 'Ennio Morricone', 3, 1),
(101, 'RoLa Xavinetasa', 4, 0),
(102, 'Er Beti', 4, 0),
(103, 'Patetico de Madrid', 4, 0),
(104, 'El Gran Real de Madrid', 4, 1),
(105, 'Psicosis', 5, 1),
(106, 'Titanic', 5, 0),
(107, 'Mejor imposible', 5, 0),
(108, 'Toy Story', 5, 1),
(109, '1942', 6, 0),
(110, '1842', 6, 0),
(111, '1492', 6, 1),
(112, '492', 6, 0),
(113, 'Oxigeno', 7, 1),
(114, 'Helio', 7, 0),
(115, 'Carbono', 7, 0),
(116, 'Hidrógeno', 7, 1),
(117, 'C++', 11, 1),
(118, 'XML', 11, 0),
(119, 'HTML', 11, 0),
(120, 'Python', 11, 1),
(121, 'Perro', 8, 1),
(122, 'Foca', 8, 1),
(123, 'Vaca', 8, 1),
(124, 'Comadreja', 8, 1),
(125, 'Verde', 9, 0),
(126, 'Rojo', 9, 1),
(127, 'Amarillo', 9, 1),
(128, 'Negro', 9, 1),
(129, '1939', 10, 1),
(130, '1914', 10, 0),
(131, '1941', 10, 0),
(132, '1929', 10, 0),
(133, 'Ewan McGregor', 12, 1),
(134, 'Charlize Theron', 12, 0),
(135, 'Carrie Fisher', 12, 1),
(136, 'Ray Park', 12, 1),
(137, 'Lago Victoria', 13, 0),
(138, 'Lago Michigan', 13, 0),
(139, 'Lago Taganica', 13, 0),
(140, 'Mar Caspio', 13, 1),
(141, 'Arpa', 14, 0),
(142, 'Piano', 14, 0),
(143, 'Bandurrria', 14, 0),
(144, 'Ninguna es correcta', 14, 1),
(145, 'Coger', 15, 1),
(146, 'Cautivar', 15, 1),
(147, 'Aferrar', 15, 0),
(148, 'Ninguna es correcta', 15, 0),
(149, 'Tu tío', 16, 0),
(150, 'Tu primo segundo', 16, 0),
(151, 'Tu padre', 16, 1),
(152, 'Tu suegro', 16, 0),
(153, 'El rio', 17, 0),
(154, 'El aire', 17, 0),
(155, 'El camino', 17, 1),
(156, 'Ninguna es correcta', 17, 0),
(157, '3*3*2*2', 18, 1),
(158, '36', 18, 1),
(159, '148 / 4', 18, 0),
(160, 'Ninguna es correcta', 18, 0),
(161, 'Piña', 19, 1),
(162, 'Melocotón', 19, 0),
(163, 'Fresa', 19, 1),
(164, 'Limón', 19, 1),
(165, 'Misisipi', 20, 0),
(166, 'Nilo', 20, 0),
(167, 'Amazonas', 20, 1),
(168, 'Yangtsé', 20, 0),
(169, 'Rosa', 1, 0),
(170, 'Calamar', 1, 1),
(171, 'León', 1, 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `examenes`
--
ALTER TABLE `examenes`
  ADD PRIMARY KEY (`id_examen`);

--
-- Indices de la tabla `preguntas`
--
ALTER TABLE `preguntas`
  ADD PRIMARY KEY (`id_pregunta`);

--
-- Indices de la tabla `respuestas`
--
ALTER TABLE `respuestas`
  ADD PRIMARY KEY (`id_respuesta`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `examenes`
--
ALTER TABLE `examenes`
  MODIFY `id_examen` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `preguntas`
--
ALTER TABLE `preguntas`
  MODIFY `id_pregunta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT de la tabla `respuestas`
--
ALTER TABLE `respuestas`
  MODIFY `id_respuesta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=172;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
