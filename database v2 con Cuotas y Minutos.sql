-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 11-12-2016 a las 02:11:04
-- Versión del servidor: 10.1.13-MariaDB
-- Versión de PHP: 5.6.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `dejmobile`
--
CREATE DATABASE IF NOT EXISTS `dejmobile` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `dejmobile`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

DROP TABLE IF EXISTS `cliente`;
CREATE TABLE `cliente` (
  `rut` int(11) NOT NULL,
  `clave` varchar(45) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellidoPaterno` varchar(45) NOT NULL,
  `apellidoMaterno` varchar(45) NOT NULL,
  `direccion` varchar(45) NOT NULL,
  `numeracion` int(11) NOT NULL,
  `comuna` varchar(45) NOT NULL,
  `telefono` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`rut`, `clave`, `nombre`, `apellidoPaterno`, `apellidoMaterno`, `direccion`, `numeracion`, `comuna`, `telefono`) VALUES
(111, '111', 'el Uno', 'sin Padre', 'sin Madre', 'Huerfanos', 111, 'Santiago', 111);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuota`
--

DROP TABLE IF EXISTS `cuota`;
CREATE TABLE `cuota` (
  `idCuota` int(11) NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  `precio` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `cuota`
--

INSERT INTO `cuota` (`idCuota`, `descripcion`, `precio`) VALUES
(1, '5 Gigas', 4000),
(2, '7 Gigas', 6000),
(3, '10 Gigas', 8000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `minutos`
--

DROP TABLE IF EXISTS `minutos`;
CREATE TABLE `minutos` (
  `idMinutos` int(11) NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  `precio` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `minutos`
--

INSERT INTO `minutos` (`idMinutos`, `descripcion`, `precio`) VALUES
(1, '800 Minutos', 1000),
(2, '2000 Minutos', 3000),
(3, '3000 Minutos', 5000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `solicitud`
--

DROP TABLE IF EXISTS `solicitud`;
CREATE TABLE `solicitud` (
  `codigo` int(11) NOT NULL,
  `entrega` tinyint(1) DEFAULT NULL,
  `total` int(11) DEFAULT NULL,
  `fechaHora` datetime DEFAULT NULL,
  `Cliente_rut` int(11) NOT NULL,
  `Cuota_idCuota` int(11) NOT NULL,
  `Minutos_idMinutos` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`rut`);

--
-- Indices de la tabla `cuota`
--
ALTER TABLE `cuota`
  ADD PRIMARY KEY (`idCuota`);

--
-- Indices de la tabla `minutos`
--
ALTER TABLE `minutos`
  ADD PRIMARY KEY (`idMinutos`);

--
-- Indices de la tabla `solicitud`
--
ALTER TABLE `solicitud`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `fk_Solicitud_Cliente_idx` (`Cliente_rut`),
  ADD KEY `fk_Solicitud_Cuota1_idx` (`Cuota_idCuota`),
  ADD KEY `fk_Solicitud_Minutos1_idx` (`Minutos_idMinutos`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cuota`
--
ALTER TABLE `cuota`
  MODIFY `idCuota` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `minutos`
--
ALTER TABLE `minutos`
  MODIFY `idMinutos` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `solicitud`
--
ALTER TABLE `solicitud`
  ADD CONSTRAINT `fk_Solicitud_Cliente` FOREIGN KEY (`Cliente_rut`) REFERENCES `cliente` (`rut`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Solicitud_Cuota1` FOREIGN KEY (`Cuota_idCuota`) REFERENCES `cuota` (`idCuota`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Solicitud_Minutos1` FOREIGN KEY (`Minutos_idMinutos`) REFERENCES `minutos` (`idMinutos`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
