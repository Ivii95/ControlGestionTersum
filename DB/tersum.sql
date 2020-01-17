-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 27-12-2019 a las 09:50:13
-- Versión del servidor: 10.1.36-MariaDB
-- Versión de PHP: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `tersum`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `centros`
--

CREATE TABLE `centros` (
  `id` int(11) NOT NULL,
  `codigo` varchar(9) COLLATE utf8_spanish_ci NOT NULL,
  `codigo_cliente` varchar(9) COLLATE utf8_spanish_ci NOT NULL,
  `nombre` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  `direccion` varchar(150) COLLATE utf8_spanish_ci DEFAULT NULL,
  `poblacion` varchar(150) COLLATE utf8_spanish_ci DEFAULT NULL,
  `telefono` int(9) DEFAULT NULL,
  `contacto` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `email` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  `horas_semana` int(4) DEFAULT NULL,
  `facturacion_mes` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `centros`
--

INSERT INTO `centros` (`id`, `codigo`, `codigo_cliente`, `nombre`, `direccion`, `poblacion`, `telefono`, `contacto`, `email`, `horas_semana`, `facturacion_mes`) VALUES
(11, '22', '1', 'Sede Sepad', 'C/Nebrija 8', 'Badajoz', 0, '', '', 0, NULL),
(12, '15', '1', 'Sede Diputacion', 'C/Ambroz 34', 'Caceres', 0, '', '', 0, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `centrostrabajadores`
--

CREATE TABLE `centrostrabajadores` (
  `id` int(11) NOT NULL,
  `codigo_trabajadores` varchar(9) COLLATE utf8_spanish_ci NOT NULL,
  `codigo_centro` varchar(9) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `centrostrabajadores`
--

INSERT INTO `centrostrabajadores` (`id`, `codigo_trabajadores`, `codigo_centro`) VALUES
(1, '14', '22'),
(2, '25', '22'),
(4, '4001', '22'),
(5, '65', '22'),
(6, '22', '22'),
(7, '65', '22'),
(10, '23', '22'),
(13, '66', '22');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `id` int(11) NOT NULL,
  `codigo` varchar(9) COLLATE utf8_spanish_ci NOT NULL,
  `cif` varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  `nombre_fiscal` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `nombre_comercial` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `contacto` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `telefono` int(9) DEFAULT NULL,
  `fax` int(9) DEFAULT NULL,
  `movil` int(9) DEFAULT NULL,
  `email` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `fecha_alta` date DEFAULT NULL,
  `fecha_baja` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`id`, `codigo`, `cif`, `nombre_fiscal`, `nombre_comercial`, `contacto`, `telefono`, `fax`, `movil`, `email`, `fecha_alta`, `fecha_baja`) VALUES
(5, '1', 'A78865441', 'CORPORACION DE MEDIOS DE EXTREMADURA, SA', 'CORPORACION DE MEDIOS DE EXTREMADURA, SA', 'Antonio Pitera', 924214300, 924205320, NULL, 'apiterac@hoy.es', NULL, NULL),
(6, '3', 'B84193168', 'CONTEPLAST, SL', 'CONTEPLAST, SL', 'Pedro Piñero', 987654321, 987654321, 654321987, 'pedro@conteplast.com', '2019-11-05', NULL),
(7, '4', 'B10219913', 'FISSA FINALIDAD SOCIAL, SL', 'FISSA FINALIDAD SOCIAL, SL', 'Juan Diaz', 987654321, 987654321, 654321987, 'juan@fissafinalidadsocial.com', '2019-11-04', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `contratos`
--

CREATE TABLE `contratos` (
  `id` int(11) NOT NULL,
  `codigo_tipo_contrato` int(11) DEFAULT NULL,
  `codigo_trabajador` int(11) DEFAULT NULL,
  `fechainicio` date DEFAULT NULL,
  `fechafin` date DEFAULT NULL,
  `horas` decimal(10,0) DEFAULT NULL,
  `situacion` tinyint(1) DEFAULT NULL,
  `asegurado` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `contratos`
--

INSERT INTO `contratos` (`id`, `codigo_tipo_contrato`, `codigo_trabajador`, `fechainicio`, `fechafin`, `horas`, `situacion`, `asegurado`) VALUES
(18, 200, 23, '2019-09-18', '2019-09-19', '25', 1, 1),
(19, 200, 400001, '2019-09-18', '2019-09-19', '36', 1, 1),
(20, 200, 25, '2019-09-18', '2019-09-19', '25', 1, 1),
(21, 209, 66, '2019-09-18', '2019-09-20', '5', 1, 1),
(22, 100, 22, '2019-09-18', '2019-09-19', '40', 1, 1),
(23, 200, 32, '2019-10-11', '2019-10-12', '5', 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `faltas`
--

CREATE TABLE `faltas` (
  `id` int(11) NOT NULL,
  `codigo` varchar(9) COLLATE utf8_spanish_ci NOT NULL,
  `codigo_trabajador_faltas` varchar(9) COLLATE utf8_spanish_ci NOT NULL,
  `fecha_inicio` date NOT NULL,
  `fecha_fin` date NOT NULL,
  `motivo` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `faltas`
--

INSERT INTO `faltas` (`id`, `codigo`, `codigo_trabajador_faltas`, `fecha_inicio`, `fecha_fin`, `motivo`) VALUES
(3, 'BA18', '66', '2019-11-11', '2019-11-18', 'Se tiene que ir al hospital con su madre'),
(4, 'BA17', '66', '2019-11-02', '2019-11-05', 'Estuvo de competicion con su hijo'),
(5, 'CC1', '14', '2019-11-04', '2019-11-05', 'Tuvo un problema con el coche'),
(6, 'CC2', '14', '2019-11-12', '2019-11-13', 'Estuvo todo el dia en el hospital'),
(7, 'CC3', '14', '2019-11-11', '2019-11-12', 'Estuvo en el hospital');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `horarios`
--

CREATE TABLE `horarios` (
  `id` int(11) NOT NULL,
  `id_centrotrabajadores` int(11) NOT NULL,
  `dia_semana` varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  `hora_inicio` time NOT NULL,
  `hora_fin` time NOT NULL,
  `horas_totales` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `horarios`
--

INSERT INTO `horarios` (`id`, `id_centrotrabajadores`, `dia_semana`, `hora_inicio`, `hora_fin`, `horas_totales`) VALUES
(1, 1, 'Lunes', '00:00:00', '04:00:00', 5),
(2, 4, 'Lunes', '00:00:00', '02:00:00', 3),
(3, 4, 'Sabado', '04:00:00', '06:00:00', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `incidencias`
--

CREATE TABLE `incidencias` (
  `id` int(11) NOT NULL,
  `codigo` varchar(9) COLLATE utf8_spanish_ci NOT NULL,
  `codigo_trabajador_incidencia` varchar(9) COLLATE utf8_spanish_ci NOT NULL,
  `descripcion` varchar(200) COLLATE utf8_spanish_ci NOT NULL,
  `fecha_inicio` date DEFAULT NULL,
  `fecha_fin` date DEFAULT NULL,
  `extras` int(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `incidencias`
--

INSERT INTO `incidencias` (`id`, `codigo`, `codigo_trabajador_incidencia`, `descripcion`, `fecha_inicio`, `fecha_fin`, `extras`) VALUES
(6, '7', '14', 'Estuvo en la diputacion de Badajoz por que Antonio se tuvo que ir corriendo a por su hijo al colegio', '2019-10-01', NULL, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `nominas`
--

CREATE TABLE `nominas` (
  `id` int(11) NOT NULL,
  `codigo_trabajador` varchar(9) COLLATE utf8_spanish_ci NOT NULL,
  `fecha_inicio` date NOT NULL,
  `fecha_fin` date DEFAULT NULL,
  `importe` decimal(10,0) NOT NULL,
  `activo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `nominas`
--

INSERT INTO `nominas` (`id`, `codigo_trabajador`, `fecha_inicio`, `fecha_fin`, `importe`, `activo`) VALUES
(1, '25', '2019-09-25', '2019-09-27', '1500', 0),
(2, '66', '2019-10-08', '2019-10-15', '33', 1),
(3, '66', '2019-10-01', '2019-10-31', '60', 1),
(4, '35', '2019-11-04', '2019-11-05', '1200', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipos_de_contrato`
--

CREATE TABLE `tipos_de_contrato` (
  `codigo` int(11) NOT NULL,
  `denominacion` varchar(200) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `tipos_de_contrato`
--

INSERT INTO `tipos_de_contrato` (`codigo`, `denominacion`) VALUES
(100, 'INDEFINIDO - TIEMPO COMPLETO - ORDINARIO'),
(109, 'INDEFINIDO - TIEMPO COMPLETO - FOMENTO CONTRATACIÓN - TRANSFORMACIÓN CONTRATO TEMPORAL'),
(130, 'INDEFINIDO - TIEMPO COMPLETO - MINUSVÁLIDOS'),
(139, 'INDEFINIDO TIEMPO COMPLETO – DISCAPACITADOS TRANSFORMACIÓN CONTRATO TEMPORAL'),
(150, 'INDEFINIDO - TIEMPO COMPLETO - FOMENTO CONTRATACIÓN INDEFINIDA/EMPLEO - INICIAL'),
(189, 'INDEFINIDO - TIEMPO COMPLETO - TRANSFORMACIÓN CONTRATO TEMPORAL'),
(200, 'INDEFINIDO - TIEMPO PARCIAL - ORDINARIO'),
(209, 'INDEFINIDO - TIEMPO PARCIAL - FOMENTO CONTRATACIÓN INDEFINIDA/EMPLEO - TRANSFORMACIÓN CONTRATO TEMPORAL'),
(230, 'INDEFINIDO - TIEMPO PARCIAL - MINUSVÁLIDOS'),
(239, 'INDEFINIDO - TIEMPO PARCIAL - MINUSVÁLIDOS - TRANSFORMACIÓN CONTRATO TEMPORAL'),
(250, 'INDEFINIDO - TIEMPO PARCIAL - FOMENTO CONTRATACIÓN INDEFINIDA/EMPLEO - INICIAL'),
(289, 'INDEFINIDO - TIEMPO PARCIAL - TRANSFORMACIÓN CONTRATO TEMPORAL'),
(300, 'INDEFINIDO - FIJO/DISCONTINUO'),
(309, 'INDEFINIDO FIJO/DISCONTINUO – FOMENTO CONTRATACIÓN INDEFINIDA/EMPLEO ESTABLE TRANSFORMACIÓN CONTRATO TEMPORAL \r\n '),
(330, 'INDEFINIDO FIJO/DISCONTINUO - DISCAPACITADOS'),
(339, 'INDEFINIDO FIJO/DISCONTINUO – DISCAPACITADO. TRANSFORMACION '),
(350, 'INDEFINIDO FIJO/DISCONTINUO – FOMENTO CONTRATACIÓN INDEFINIDA/EMPLEO ESTABLE INICIAL '),
(389, 'INDEFINIDO FIJO/DISCONTINUO – TRANSFORMACIÓN CONTRATO TEMPORAL. '),
(401, 'DURACIÓN DETERMINADA TIEMPO COMPLETO – OBRA O SERVICIO DETERMINADO '),
(402, 'DURACIÓN DETERMINADA TIEMPO COMPLETO – EVENTUAL POR CIRCUNSTANCIAS DE LA PRODUCCIÓN '),
(403, 'DURACIÓN DETERMINADA TIEMPO COMPLETO – INSERCIÓN'),
(408, 'DURACIÓN DETERMINADA TIEMPO COMPLETO – CARÁCTER ADMINISTRATIVO '),
(410, 'DURACIÓN DETERMINADA TIEMPO COMPLETO – INTERINIDAD '),
(418, 'DURACIÓN DETERMINADA TIEMPO COMPLETO – INTERINIDAD CARÁCTER ADMINISTRATIVO '),
(420, 'DURACIÓN DETERMINADA TIEMPO COMPLETO – PRÁCTICAS '),
(421, 'DURACIÓN DETERMINADA TIEMPO COMPLETO – FORMACIÓN '),
(430, 'DURACIÓN DETERMINADA TIEMPO COMPLETO – DISCAPACITADOS'),
(441, 'DURACIÓN DETERMINADA TIEMPO COMPLETO – RELEVO '),
(450, 'DURACIÓN DETERMINADA TIEMPO COMPLETO – FOMENTO CONTRATACIÓN INDEFINIDA/EMPLEO ESTABLE'),
(452, 'DURACIÓN DETERMINADA TIEMPO COMPLETO – TRABAJADORES DESEMPLEADOS CONTRATADOS POR EMPRESAS DE INSERCIÓN\r\n'),
(501, 'DURACIÓN DETERMINADA TIEMPO PARCIAL – OBRA O SERVICIO DETERMINADO '),
(502, 'DURACIÓN DETERMINADA TIEMPO PARCIAL – EVENTUAL POR CIRCUNSTANCIAS DE LA PRODUCCIÓN '),
(503, 'DURACIÓN DETERMINADA TIEMPO PARCIAL – INSERCIÓN'),
(508, 'DURACIÓN DETERMINADA TIEMPO PARCIAL – CARÁCTER ADMINISTRATIVO '),
(510, 'DURACIÓN DETERMINADA TIEMPO PARCIAL – INTERINIDAD '),
(518, 'DURACIÓN DETERMINADA TIEMPO PARCIAL – INTERINIDAD CARÁCTER ADMINISTRATIVO '),
(520, 'DURACIÓN DETERMINADA TIEMPO PARCIAL – PRÁCTICAS'),
(530, 'DURACIÓN DETERMINADA TIEMPO PARCIAL – DISCAPACITADOS '),
(540, 'DURACIÓN DETERMINADA TIEMPO PARCIAL – JUBILACIÓN PARCIAL \r\n '),
(541, 'DURACIÓN DETERMINADA TIEMPO PARCIAL – RELEVO'),
(550, 'DURACIÓN DETERMINADA TIEMPO PARCIAL – FOMENTO CONTRATACIÓN INDEFINIDA/EMPLEO ESTABLE'),
(552, 'DURACIÓN DETERMINADA TIEMPO PARCIAL – TRABAJADORES DESEMPLEADOS CONTRATADOS POR EMPRESAS DE INSERCIÓN ');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `trabajadores`
--

CREATE TABLE `trabajadores` (
  `id` int(11) NOT NULL,
  `codigo` varchar(9) COLLATE utf8_spanish_ci NOT NULL,
  `codigo_tipo_contrato` int(11) DEFAULT NULL,
  `apellido1` varchar(200) COLLATE utf8_spanish_ci DEFAULT NULL,
  `apellido2` varchar(200) COLLATE utf8_spanish_ci DEFAULT NULL,
  `nombre` varchar(200) COLLATE utf8_spanish_ci DEFAULT NULL,
  `direccion` varchar(200) COLLATE utf8_spanish_ci DEFAULT NULL,
  `poblacion` varchar(200) COLLATE utf8_spanish_ci DEFAULT NULL,
  `fechanacimiento` date DEFAULT NULL,
  `categoria` varchar(200) COLLATE utf8_spanish_ci DEFAULT NULL,
  `antiguedad` date DEFAULT NULL,
  `telefono` int(9) DEFAULT NULL,
  `email` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `fecha_alta` date DEFAULT NULL,
  `fecha_baja` date DEFAULT NULL,
  `horas_semana_alta` int(5) DEFAULT NULL,
  `horas_semana_reales` int(5) DEFAULT NULL,
  `coste_mes` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `trabajadores`
--

INSERT INTO `trabajadores` (`id`, `codigo`, `codigo_tipo_contrato`, `apellido1`, `apellido2`, `nombre`, `direccion`, `poblacion`, `fechanacimiento`, `categoria`, `antiguedad`, `telefono`, `email`, `fecha_alta`, `fecha_baja`, `horas_semana_alta`, `horas_semana_reales`, `coste_mes`) VALUES
(6, '14', 100, 'valle', 'martinez', 'ismael', 'prueba', 'prueba', '1992-03-08', 'prueba', NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL),
(29, '25', 100, 'gomez', 'juez', 'juan', '', '', '2019-07-15', '', NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL),
(33, '66', 100, 'gomez', 'gonzalez', 'juan', '', '', '2019-07-15', '', NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL),
(38, '65', 100, 'gomez', 'perez', 'juan', '', '', '2019-07-15', '', NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL),
(39, '23', 200, 'hurtado', 'lopez', 'ismael', '', '', '2019-07-19', '', NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL),
(40, '22', 109, 'hurtado', 'garcia', 'ismael', '', '', '2019-07-17', '', NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL),
(41, '4001', 100, 'perez', 'jimenez', 'Isabel', 'C/sanlucas', 'Antequera', '2019-07-21', 'Limpiadora', NULL, 0, 'Isabel@contribucion.com', '2019-11-04', NULL, 0, 0, 0),
(42, '777777', 100, 'ruiz ', 'mateos', 'pepe', '', 'mérida', '2019-11-04', 'senior', NULL, 666666, 's@x.es', '2019-11-06', NULL, 1, 0, 2000);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `centros`
--
ALTER TABLE `centros`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `codigo` (`codigo`),
  ADD KEY `codigo_cliente` (`codigo_cliente`);

--
-- Indices de la tabla `centrostrabajadores`
--
ALTER TABLE `centrostrabajadores`
  ADD PRIMARY KEY (`id`),
  ADD KEY `codigo_centro` (`codigo_centro`),
  ADD KEY `codigo_trabajadores` (`codigo_trabajadores`);

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `codigo` (`codigo`);

--
-- Indices de la tabla `contratos`
--
ALTER TABLE `contratos`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `faltas`
--
ALTER TABLE `faltas`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `codigo` (`codigo`),
  ADD KEY `codigo_trabajador_faltas` (`codigo_trabajador_faltas`);

--
-- Indices de la tabla `horarios`
--
ALTER TABLE `horarios`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_centrotrabajadores` (`id_centrotrabajadores`);

--
-- Indices de la tabla `incidencias`
--
ALTER TABLE `incidencias`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `codigo` (`codigo`),
  ADD KEY `codigo_trabajador_incidencia` (`codigo_trabajador_incidencia`);

--
-- Indices de la tabla `nominas`
--
ALTER TABLE `nominas`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `tipos_de_contrato`
--
ALTER TABLE `tipos_de_contrato`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `trabajadores`
--
ALTER TABLE `trabajadores`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `codigo` (`codigo`),
  ADD KEY `codigo_tipo_contrato` (`codigo_tipo_contrato`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `centros`
--
ALTER TABLE `centros`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `centrostrabajadores`
--
ALTER TABLE `centrostrabajadores`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT de la tabla `clientes`
--
ALTER TABLE `clientes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `contratos`
--
ALTER TABLE `contratos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT de la tabla `faltas`
--
ALTER TABLE `faltas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `horarios`
--
ALTER TABLE `horarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `incidencias`
--
ALTER TABLE `incidencias`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `nominas`
--
ALTER TABLE `nominas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `trabajadores`
--
ALTER TABLE `trabajadores`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=43;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `centros`
--
ALTER TABLE `centros`
  ADD CONSTRAINT `codigo_cliente` FOREIGN KEY (`codigo_cliente`) REFERENCES `clientes` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `centrostrabajadores`
--
ALTER TABLE `centrostrabajadores`
  ADD CONSTRAINT `codigo_centro` FOREIGN KEY (`codigo_centro`) REFERENCES `centros` (`codigo`),
  ADD CONSTRAINT `codigo_trabajadores` FOREIGN KEY (`codigo_trabajadores`) REFERENCES `trabajadores` (`codigo`);

--
-- Filtros para la tabla `faltas`
--
ALTER TABLE `faltas`
  ADD CONSTRAINT `faltas_ibfk_1` FOREIGN KEY (`codigo_trabajador_faltas`) REFERENCES `trabajadores` (`codigo`);

--
-- Filtros para la tabla `horarios`
--
ALTER TABLE `horarios`
  ADD CONSTRAINT `horarios_ibfk_1` FOREIGN KEY (`id_centrotrabajadores`) REFERENCES `centrostrabajadores` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `incidencias`
--
ALTER TABLE `incidencias`
  ADD CONSTRAINT `codigo_trabajador_incidencia` FOREIGN KEY (`codigo_trabajador_incidencia`) REFERENCES `trabajadores` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
