
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bocateria`
--
CREATE DATABASE IF NOT EXISTS `bocateria` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `bocateria`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bebidas`
--

CREATE TABLE `bebidas` (
  `id_bebida` bigint(20) UNSIGNED NOT NULL,
  `nombre_bebida` varchar(20) NOT NULL,
  `precio` decimal(4,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `bebidas`
--

INSERT INTO `bebidas` (`id_bebida`, `nombre_bebida`, `precio`) VALUES
(1, 'Agua', '1.00'),
(2, 'Cerveza', '1.50'),
(3, 'Coca cola', '1.50'),
(4, 'Naranza', '1.50'),
(5, 'Limón', '1.50'),
(6, 'Zumo', '1.50');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bocadillos`
--

CREATE TABLE `bocadillos` (
  `id_bocadillo` bigint(20) UNSIGNED NOT NULL,
  `nombre_bocadillo` varchar(30) NOT NULL,
  `precio` decimal(4,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `bocadillos`
--

INSERT INTO `bocadillos` (`id_bocadillo`, `nombre_bocadillo`, `precio`) VALUES
(1, 'Jamón serrano', '3.50'),
(2, 'York queso', '2.50'),
(3, 'Tortilla patata', '2.00'),
(4, 'Salchichas', '2.00'),
(5, 'Vegetal', '2.75'),
(6, 'Pollo', '3.00'),
(7, 'Lomo pimiento', '3.50');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleados`
--

CREATE TABLE `empleados` (
  `id_empleado` varchar(3) NOT NULL,
  `nombre_empleado` varchar(30) NOT NULL,
  `comision` decimal(5,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `empleados`
--

INSERT INTO `empleados` (`id_empleado`, `nombre_empleado`, `comision`) VALUES
('E1', 'Luis', '15.75'),
('E2', 'Marta', '5.15'),
('E3', 'Carlos', '3.25');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `otros`
--

CREATE TABLE `otros` (
  `id_producto` bigint(20) UNSIGNED NOT NULL,
  `nombre_producto` varchar(30) NOT NULL,
  `precio` decimal(4,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `otros`
--

INSERT INTO `otros` (`id_producto`, `nombre_producto`, `precio`) VALUES
(1, 'Ensalada', '3.50'),
(2, 'Patatas', '1.50'),
(3, 'Aros cebolla', '1.00'),
(4, 'Postre', '3.50');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventas`
--

CREATE TABLE `ventas` (
  `id_venta` int(11) NOT NULL,
  `fecha` date NOT NULL COMMENT 'fecha y hora de la venta',
  `empleado` varchar(3) DEFAULT NULL COMMENT 'ID del empleado',
  `totalVenta` decimal(5,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `ventas`
--

INSERT INTO `ventas` (`id_venta`, `fecha`, `empleado`, `totalVenta`) VALUES
(1, '2022-05-01', 'E1', '25.50'),
(2, '2022-05-02', 'E2', '6.00');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `bebidas`
--
ALTER TABLE `bebidas`
  ADD PRIMARY KEY (`id_bebida`),
  ADD UNIQUE KEY `id_bebida` (`id_bebida`);

--
-- Indices de la tabla `bocadillos`
--
ALTER TABLE `bocadillos`
  ADD PRIMARY KEY (`id_bocadillo`),
  ADD UNIQUE KEY `id_bocadillo` (`id_bocadillo`);

--
-- Indices de la tabla `empleados`
--
ALTER TABLE `empleados`
  ADD PRIMARY KEY (`id_empleado`);

--
-- Indices de la tabla `otros`
--
ALTER TABLE `otros`
  ADD PRIMARY KEY (`id_producto`),
  ADD UNIQUE KEY `id_producto` (`id_producto`);

--
-- Indices de la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD PRIMARY KEY (`id_venta`),
  ADD KEY `empleado` (`empleado`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `bebidas`
--
ALTER TABLE `bebidas`
  MODIFY `id_bebida` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `bocadillos`
--
ALTER TABLE `bocadillos`
  MODIFY `id_bocadillo` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `otros`
--
ALTER TABLE `otros`
  MODIFY `id_producto` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `ventas`
--
ALTER TABLE `ventas`
  MODIFY `id_venta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD CONSTRAINT `ventas_ibfk_1` FOREIGN KEY (`empleado`) REFERENCES `empleados` (`id_empleado`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
