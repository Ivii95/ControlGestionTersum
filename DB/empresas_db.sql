-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 27-12-2019 a las 10:40:00
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
-- Base de datos: `empresas_db`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empresas`
--

CREATE TABLE `empresas` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `conexion` varchar(200) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `empresas`
--

INSERT INTO `empresas` (`id`, `nombre`, `conexion`) VALUES
(1, 'Tersum', 'jdbc:mysql://localhost:3306/tersum');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `lista_permisos`
--

CREATE TABLE `lista_permisos` (
  `id` int(11) NOT NULL,
  `nombre` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `lista_permisos`
--

INSERT INTO `lista_permisos` (`id`, `nombre`) VALUES
(1, 'acceso_empresa'),
(2, 'acceso_archivos'),
(3, 'acceso_procesos'),
(4, 'acceso_listado'),
(5, 'acceso_configuracion'),
(6, 'archivos_usuarios'),
(7, 'archivos_usuarios_añadir'),
(8, 'archivos_usuarios_modificar'),
(9, 'archivos_usuarios_borrar'),
(10, 'archivos_trabajadores'),
(11, 'archivos_trabajadores_añadir'),
(12, 'archivos_trabajadores_modificar'),
(13, 'archivos_trabajadores_borrar'),
(14, 'archivos_centros'),
(15, 'archivos_centros_añadir'),
(16, 'archivos_centros_modificar'),
(17, 'archivos_centros_borrar'),
(18, 'archivos_contratos'),
(19, 'archivos_contratos_añadir'),
(20, 'archivos_contratos_modificar'),
(21, 'archivos_contratos_borrar'),
(22, 'archivos_clientes'),
(23, 'archivos_clientes_añadir'),
(24, 'archivos_clientes_modificar'),
(25, 'archivos_clientes_borrar'),
(26, 'procesos_uno'),
(27, 'procesos_uno_añadir'),
(28, 'procesos_uno_modificar'),
(29, 'procesos_uno_borrar'),
(30, 'procesos_dos'),
(31, 'procesos_dos_añadir'),
(32, 'procesos_dos_modificar'),
(33, 'procesos_dos_borrar'),
(34, 'procesos_tres'),
(35, 'procesos_tres_añadir'),
(36, 'procesos_tres_modificar'),
(37, 'procesos_tres_borrar'),
(38, 'listado_uno'),
(39, 'listado_uno_añadir'),
(40, 'listado_uno_modificar'),
(41, 'listado_uno_borrar'),
(42, 'listado_dos'),
(43, 'listado_dos_añadir'),
(44, 'listado_dos_modificar'),
(45, 'listado_dos_borrar'),
(46, 'listado_tres'),
(47, 'listado_tres_añadir'),
(48, 'listado_tres_modificar'),
(49, 'listado_tres_borrar'),
(50, 'configuracion_uno'),
(51, 'configuracion_uno_añadir'),
(52, 'configuracion_uno_modificar'),
(53, 'configuracion_uno_borrar'),
(54, 'configuracion_dos'),
(55, 'configuracion_dos_añadir'),
(56, 'configuracion_dos_modificar'),
(57, 'configuracion_dos_borrar'),
(58, 'configuracion_tres'),
(59, 'configuracion_tres_añadir'),
(60, 'configuracion_tres_modificar'),
(61, 'configuracion_tres_borrar');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `permisos_usuarios`
--

CREATE TABLE `permisos_usuarios` (
  `id` int(11) NOT NULL,
  `id_permiso` int(11) NOT NULL,
  `id_empresa` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `activo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `permisos_usuarios`
--

INSERT INTO `permisos_usuarios` (`id`, `id_permiso`, `id_empresa`, `id_usuario`, `activo`) VALUES
(83, 1, 1, 5, 1),
(84, 2, 1, 5, 1),
(85, 3, 1, 5, 1),
(86, 4, 1, 5, 1),
(87, 5, 1, 5, 1),
(88, 6, 1, 5, 1),
(89, 7, 1, 5, 1),
(90, 8, 1, 5, 1),
(91, 9, 1, 5, 1),
(92, 10, 1, 5, 1),
(93, 11, 1, 5, 1),
(94, 12, 1, 5, 1),
(95, 13, 1, 5, 1),
(96, 14, 1, 5, 1),
(97, 15, 1, 5, 1),
(98, 16, 1, 5, 1),
(99, 17, 1, 5, 1),
(100, 18, 1, 5, 1),
(101, 19, 1, 5, 1),
(102, 20, 1, 5, 1),
(103, 21, 1, 5, 1),
(104, 22, 1, 5, 1),
(105, 23, 1, 5, 1),
(106, 24, 1, 5, 1),
(107, 25, 1, 5, 1),
(108, 26, 1, 5, 1),
(109, 27, 1, 5, 1),
(110, 28, 1, 5, 1),
(111, 29, 1, 5, 1),
(112, 30, 1, 5, 1),
(113, 31, 1, 5, 1),
(114, 32, 1, 5, 1),
(115, 33, 1, 5, 1),
(116, 34, 1, 5, 1),
(117, 35, 1, 5, 1),
(118, 36, 1, 5, 1),
(119, 37, 1, 5, 1),
(120, 38, 1, 5, 1),
(121, 39, 1, 5, 1),
(122, 40, 1, 5, 1),
(123, 41, 1, 5, 1),
(124, 42, 1, 5, 1),
(125, 43, 1, 5, 1),
(126, 44, 1, 5, 1),
(127, 45, 1, 5, 1),
(128, 46, 1, 5, 1),
(129, 47, 1, 5, 1),
(130, 48, 1, 5, 1),
(131, 49, 1, 5, 1),
(132, 50, 1, 5, 1),
(133, 51, 1, 5, 1),
(134, 52, 1, 5, 1),
(135, 53, 1, 5, 1),
(136, 54, 1, 5, 1),
(137, 55, 1, 5, 1),
(138, 56, 1, 5, 1),
(139, 57, 1, 5, 1),
(140, 58, 1, 5, 1),
(141, 59, 1, 5, 1),
(142, 60, 1, 5, 1),
(143, 61, 1, 5, 1),
(144, 1, 1, 6, 1),
(145, 2, 1, 6, 1),
(146, 3, 1, 6, 1),
(147, 4, 1, 6, 1),
(148, 5, 1, 6, 1),
(149, 6, 1, 6, 1),
(150, 7, 1, 6, 1),
(151, 8, 1, 6, 1),
(152, 9, 1, 6, 1),
(153, 10, 1, 6, 1),
(154, 11, 1, 6, 1),
(155, 12, 1, 6, 1),
(156, 13, 1, 6, 1),
(157, 14, 1, 6, 1),
(158, 15, 1, 6, 1),
(159, 16, 1, 6, 1),
(160, 17, 1, 6, 1),
(161, 18, 1, 6, 1),
(162, 19, 1, 6, 1),
(163, 20, 1, 6, 1),
(164, 21, 1, 6, 1),
(165, 22, 1, 6, 1),
(166, 23, 1, 6, 1),
(167, 24, 1, 6, 1),
(168, 25, 1, 6, 1),
(169, 26, 1, 6, 1),
(170, 27, 1, 6, 1),
(171, 28, 1, 6, 1),
(172, 29, 1, 6, 1),
(173, 30, 1, 6, 1),
(174, 31, 1, 6, 1),
(175, 32, 1, 6, 1),
(176, 33, 1, 6, 1),
(177, 34, 1, 6, 1),
(178, 35, 1, 6, 1),
(179, 36, 1, 6, 1),
(180, 37, 1, 6, 1),
(181, 38, 1, 6, 1),
(182, 39, 1, 6, 1),
(183, 40, 1, 6, 1),
(184, 41, 1, 6, 1),
(185, 42, 1, 6, 1),
(186, 43, 1, 6, 1),
(187, 44, 1, 6, 1),
(188, 45, 1, 6, 1),
(189, 46, 1, 6, 1),
(190, 47, 1, 6, 1),
(191, 48, 1, 6, 1),
(192, 49, 1, 6, 1),
(193, 50, 1, 6, 1),
(194, 51, 1, 6, 1),
(195, 52, 1, 6, 1),
(196, 53, 1, 6, 1),
(197, 54, 1, 6, 1),
(198, 55, 1, 6, 1),
(199, 56, 1, 6, 1),
(200, 57, 1, 6, 1),
(201, 58, 1, 6, 1),
(202, 59, 1, 6, 1),
(203, 60, 1, 6, 1),
(204, 61, 1, 6, 1),
(205, 1, 1, 7, 1),
(206, 2, 1, 7, 1),
(207, 3, 1, 7, 1),
(208, 4, 1, 7, 1),
(209, 5, 1, 7, 1),
(210, 6, 1, 7, 1),
(211, 7, 1, 7, 1),
(212, 8, 1, 7, 1),
(213, 9, 1, 7, 1),
(214, 10, 1, 7, 1),
(215, 11, 1, 7, 1),
(216, 12, 1, 7, 1),
(217, 13, 1, 7, 1),
(218, 14, 1, 7, 1),
(219, 15, 1, 7, 1),
(220, 16, 1, 7, 1),
(221, 17, 1, 7, 1),
(222, 18, 1, 7, 1),
(223, 19, 1, 7, 1),
(224, 20, 1, 7, 1),
(225, 21, 1, 7, 1),
(226, 22, 1, 7, 1),
(227, 23, 1, 7, 1),
(228, 24, 1, 7, 1),
(229, 25, 1, 7, 1),
(230, 26, 1, 7, 1),
(231, 27, 1, 7, 1),
(232, 28, 1, 7, 1),
(233, 29, 1, 7, 1),
(234, 30, 1, 7, 1),
(235, 31, 1, 7, 1),
(236, 32, 1, 7, 1),
(237, 33, 1, 7, 1),
(238, 34, 1, 7, 1),
(239, 35, 1, 7, 1),
(240, 36, 1, 7, 1),
(241, 37, 1, 7, 1),
(242, 38, 1, 7, 1),
(243, 39, 1, 7, 1),
(244, 40, 1, 7, 1),
(245, 41, 1, 7, 1),
(246, 42, 1, 7, 1),
(247, 43, 1, 7, 1),
(248, 44, 1, 7, 1),
(249, 45, 1, 7, 1),
(250, 46, 1, 7, 1),
(251, 47, 1, 7, 1),
(252, 48, 1, 7, 1),
(253, 49, 1, 7, 1),
(254, 50, 1, 7, 1),
(255, 51, 1, 7, 1),
(256, 52, 1, 7, 1),
(257, 53, 1, 7, 1),
(258, 54, 1, 7, 1),
(259, 55, 1, 7, 1),
(260, 56, 1, 7, 1),
(261, 57, 1, 7, 1),
(262, 58, 1, 7, 1),
(263, 59, 1, 7, 1),
(264, 60, 1, 7, 1),
(265, 61, 1, 7, 1),
(266, 1, 1, 8, 1),
(267, 2, 1, 8, 1),
(268, 3, 1, 8, 1),
(269, 4, 1, 8, 1),
(270, 5, 1, 8, 1),
(271, 6, 1, 8, 1),
(272, 7, 1, 8, 1),
(273, 8, 1, 8, 1),
(274, 9, 1, 8, 1),
(275, 10, 1, 8, 1),
(276, 11, 1, 8, 1),
(277, 12, 1, 8, 1),
(278, 13, 1, 8, 1),
(279, 14, 1, 8, 1),
(280, 15, 1, 8, 1),
(281, 16, 1, 8, 1),
(282, 17, 1, 8, 1),
(283, 18, 1, 8, 1),
(284, 19, 1, 8, 1),
(285, 20, 1, 8, 1),
(286, 21, 1, 8, 1),
(287, 22, 1, 8, 1),
(288, 23, 1, 8, 1),
(289, 24, 1, 8, 1),
(290, 25, 1, 8, 1),
(291, 26, 1, 8, 1),
(292, 27, 1, 8, 1),
(293, 28, 1, 8, 1),
(294, 29, 1, 8, 1),
(295, 30, 1, 8, 1),
(296, 31, 1, 8, 1),
(297, 32, 1, 8, 1),
(298, 33, 1, 8, 1),
(299, 34, 1, 8, 1),
(300, 35, 1, 8, 1),
(301, 36, 1, 8, 1),
(302, 37, 1, 8, 1),
(303, 38, 1, 8, 1),
(304, 39, 1, 8, 1),
(305, 40, 1, 8, 1),
(306, 41, 1, 8, 1),
(307, 42, 1, 8, 1),
(308, 43, 1, 8, 1),
(309, 44, 1, 8, 1),
(310, 45, 1, 8, 1),
(311, 46, 1, 8, 1),
(312, 47, 1, 8, 1),
(313, 48, 1, 8, 1),
(314, 49, 1, 8, 1),
(315, 50, 1, 8, 1),
(316, 51, 1, 8, 1),
(317, 52, 1, 8, 1),
(318, 53, 1, 8, 1),
(319, 54, 1, 8, 1),
(320, 55, 1, 8, 1),
(321, 56, 1, 8, 1),
(322, 57, 1, 8, 1),
(323, 58, 1, 8, 1),
(324, 59, 1, 8, 1),
(325, 60, 1, 8, 1),
(326, 61, 1, 8, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `roles`
--

CREATE TABLE `roles` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `roles`
--

INSERT INTO `roles` (`id`, `nombre`) VALUES
(1, 'administrador'),
(2, 'encargado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `password` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `id_rol` int(11) NOT NULL,
  `ultima_sesion` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `nombre`, `password`, `id_rol`, `ultima_sesion`) VALUES
(5, 'ismael', '81dc9bdb52d04dc20036dbd8313ed055', 1, '2019-11-04 09:04:34'),
(6, 'ivan', '81dc9bdb52d04dc20036dbd8313ed055', 1, '2019-12-13 11:02:37'),
(7, 'pepe', '926e27eecdbc7a18858b3798ba99bddd', 1, '2019-12-13 11:03:44'),
(8, 'luis', '81dc9bdb52d04dc20036dbd8313ed055', 1, '2019-12-13 13:43:48');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `empresas`
--
ALTER TABLE `empresas`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `lista_permisos`
--
ALTER TABLE `lista_permisos`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `permisos_usuarios`
--
ALTER TABLE `permisos_usuarios`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `empresas`
--
ALTER TABLE `empresas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `lista_permisos`
--
ALTER TABLE `lista_permisos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=62;

--
-- AUTO_INCREMENT de la tabla `permisos_usuarios`
--
ALTER TABLE `permisos_usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=327;

--
-- AUTO_INCREMENT de la tabla `roles`
--
ALTER TABLE `roles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
