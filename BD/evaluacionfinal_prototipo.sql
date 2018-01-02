-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 25-08-2017 a las 18:23:55
-- Versión del servidor: 5.6.21
-- Versión de PHP: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `evaluacionfinal`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `administrador`
--

CREATE TABLE IF NOT EXISTS `administrador` (
  `idadministrador` int(11) NOT NULL,
  `nombadmin` varchar(45) DEFAULT NULL,
  `idadmin` varchar(45) DEFAULT NULL,
  `contraadmin` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `administrador`
--

INSERT INTO `administrador` (`idadministrador`, `nombadmin`, `idadmin`, `contraadmin`) VALUES
(1, 'giampieer24', 'giampieer24', '1111');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumno`
--

CREATE TABLE IF NOT EXISTS `alumno` (
  `codalumno` int(11) NOT NULL,
  `nombalumno` varchar(45) DEFAULT NULL,
  `idalumno` varchar(45) DEFAULT NULL,
  `contraalumno` varchar(45) DEFAULT NULL,
  `administrador_idadministrador` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `alumno`
--

INSERT INTO `alumno` (`codalumno`, `nombalumno`, `idalumno`, `contraalumno`, `administrador_idadministrador`) VALUES
(1, 'giampieer24', 'giampieer24', '1111', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `camiones`
--

CREATE TABLE IF NOT EXISTS `camiones` (
  `idcamiones` int(11) NOT NULL,
  `marca` varchar(45) DEFAULT NULL,
  `modelo` varchar(45) DEFAULT NULL,
  `matricula` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `camiones`
--

INSERT INTO `camiones` (`idcamiones`, `marca`, `modelo`, `matricula`) VALUES
(1, 'Volvo', 'Faw CA5313CLXYP7K2L11T4El', 'AA 1234'),
(2, 'Volvo', 'Faw CA5313CLXYP7K2L11T4El', 'BB 223'),
(3, 'Volvo', 'Faw CA5313CLWEW7K2L11T4El', 'AA 7642'),
(4, 'Volvo', 'Faw CA5313CLXYP7K2L11T4El', 'GG1223'),
(5, 'Volvo', 'Faw CA5313CLXYP7K2L11T4El', 'GH23232'),
(6, 'Volvo', 'Faw CA5313CLXYP7K2L11T4El', 'K34334'),
(7, 'Volvo', 'Faw CA5313CLWEW7K2L11T4El', 'LL32232'),
(8, 'Volvo', 'Faw CA5313CLXYP7K2L11T4El', 'NH232');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `examen`
--

CREATE TABLE IF NOT EXISTS `examen` (
  `codexamen` int(11) NOT NULL,
  `nombexamen` varchar(45) DEFAULT NULL,
  `profesor_idporfesor` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `examenresuelto`
--

CREATE TABLE IF NOT EXISTS `examenresuelto` (
  `idexamenresuelto` int(11) NOT NULL,
  `codexamen` int(11) DEFAULT NULL,
  `alumno_codalumno` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `horario`
--

CREATE TABLE IF NOT EXISTS `horario` (
  `codhoraio` int(11) NOT NULL,
  `fecha` varchar(45) DEFAULT NULL,
  `lugar` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `horario`
--

INSERT INTO `horario` (`codhoraio`, `fecha`, `lugar`) VALUES
(1, '08/07/2017', 'CALLE A'),
(2, '08/07/2017', 'CALLE B'),
(3, '08/07/2017', 'CALLE C'),
(4, '08/07/2017', 'CALLE E'),
(5, '08/07/2017', 'CALLE F'),
(6, '08/07/2017', 'CALLE G'),
(7, '08/07/2017', 'CALLE H'),
(8, '08/07/2017', 'CALLE J');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `nota`
--

CREATE TABLE IF NOT EXISTS `nota` (
  `idnota` int(11) NOT NULL,
  `puntajealumno` varchar(45) DEFAULT NULL,
  `respuestas_preguntas_numpregunta` int(11) DEFAULT NULL,
  `respuestas_alumno_codalumno` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `notaprof`
--

CREATE TABLE IF NOT EXISTS `notaprof` (
  `idnotaprof` int(11) NOT NULL,
  `puntaje` varchar(45) DEFAULT NULL,
  `respuestasprof_idrespuestasprof` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `notaxexamen`
--

CREATE TABLE IF NOT EXISTS `notaxexamen` (
  `codexamen` int(11) NOT NULL,
  `puntaje` varchar(45) DEFAULT NULL,
  `examenresuelto_idexamenresuelto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `preguntas`
--

CREATE TABLE IF NOT EXISTS `preguntas` (
  `numpregunta` int(11) NOT NULL,
  `pregunta` varchar(45) DEFAULT NULL,
  `examen_codexamen` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `profesor`
--

CREATE TABLE IF NOT EXISTS `profesor` (
  `idporfesor` int(11) NOT NULL,
  `nombprofesor` varchar(45) DEFAULT NULL,
  `idprofesor` varchar(45) DEFAULT NULL,
  `contraprofesor` varchar(45) DEFAULT NULL,
  `administrador_idadministrador` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `profesor`
--

INSERT INTO `profesor` (`idporfesor`, `nombprofesor`, `idprofesor`, `contraprofesor`, `administrador_idadministrador`) VALUES
(1, 'giampieer24', 'giampieer24', '1111', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `respuestas`
--

CREATE TABLE IF NOT EXISTS `respuestas` (
  `preguntas_numpregunta` int(11) NOT NULL,
  `alumno_codalumno` int(11) NOT NULL,
  `respuesta` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `respuestasprof`
--

CREATE TABLE IF NOT EXISTS `respuestasprof` (
  `idrespuestasprof` int(11) NOT NULL,
  `respuestasprofcol` varchar(45) DEFAULT NULL,
  `preguntas_numpregunta` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `administrador`
--
ALTER TABLE `administrador`
 ADD PRIMARY KEY (`idadministrador`);

--
-- Indices de la tabla `alumno`
--
ALTER TABLE `alumno`
 ADD PRIMARY KEY (`codalumno`), ADD KEY `fk_ALUMNO_administrador1_idx` (`administrador_idadministrador`);

--
-- Indices de la tabla `camiones`
--
ALTER TABLE `camiones`
 ADD PRIMARY KEY (`idcamiones`);

--
-- Indices de la tabla `examen`
--
ALTER TABLE `examen`
 ADD PRIMARY KEY (`codexamen`), ADD KEY `fk_EXAMEN_PROFESOR1_idx` (`profesor_idporfesor`);

--
-- Indices de la tabla `examenresuelto`
--
ALTER TABLE `examenresuelto`
 ADD PRIMARY KEY (`idexamenresuelto`), ADD KEY `fk_examenresuelto_ALUMNO1_idx` (`alumno_codalumno`);

--
-- Indices de la tabla `horario`
--
ALTER TABLE `horario`
 ADD PRIMARY KEY (`codhoraio`);

--
-- Indices de la tabla `nota`
--
ALTER TABLE `nota`
 ADD PRIMARY KEY (`idnota`), ADD KEY `fk_NOTA_respuestas1_idx` (`respuestas_preguntas_numpregunta`,`respuestas_alumno_codalumno`);

--
-- Indices de la tabla `notaprof`
--
ALTER TABLE `notaprof`
 ADD PRIMARY KEY (`idnotaprof`), ADD KEY `fk_notaprof_respuestasprof1_idx` (`respuestasprof_idrespuestasprof`);

--
-- Indices de la tabla `notaxexamen`
--
ALTER TABLE `notaxexamen`
 ADD PRIMARY KEY (`codexamen`), ADD KEY `fk_notaxexamen_examenresuelto1_idx` (`examenresuelto_idexamenresuelto`);

--
-- Indices de la tabla `preguntas`
--
ALTER TABLE `preguntas`
 ADD PRIMARY KEY (`numpregunta`), ADD KEY `fk_preguntas_EXAMEN1_idx` (`examen_codexamen`);

--
-- Indices de la tabla `profesor`
--
ALTER TABLE `profesor`
 ADD PRIMARY KEY (`idporfesor`), ADD KEY `fk_PROFESOR_administrador1_idx` (`administrador_idadministrador`);

--
-- Indices de la tabla `respuestas`
--
ALTER TABLE `respuestas`
 ADD PRIMARY KEY (`preguntas_numpregunta`,`alumno_codalumno`), ADD KEY `fk_preguntas_has_ALUMNO_ALUMNO1_idx` (`alumno_codalumno`), ADD KEY `fk_preguntas_has_ALUMNO_preguntas1_idx` (`preguntas_numpregunta`);

--
-- Indices de la tabla `respuestasprof`
--
ALTER TABLE `respuestasprof`
 ADD PRIMARY KEY (`idrespuestasprof`), ADD KEY `fk_respuestasprof_preguntas1_idx` (`preguntas_numpregunta`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `alumno`
--
ALTER TABLE `alumno`
ADD CONSTRAINT `fk_ALUMNO_administrador1` FOREIGN KEY (`administrador_idadministrador`) REFERENCES `administrador` (`idadministrador`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `examen`
--
ALTER TABLE `examen`
ADD CONSTRAINT `fk_EXAMEN_PROFESOR1` FOREIGN KEY (`profesor_idporfesor`) REFERENCES `profesor` (`idporfesor`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `examenresuelto`
--
ALTER TABLE `examenresuelto`
ADD CONSTRAINT `fk_examenresuelto_ALUMNO1` FOREIGN KEY (`alumno_codalumno`) REFERENCES `alumno` (`codalumno`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `nota`
--
ALTER TABLE `nota`
ADD CONSTRAINT `fk_NOTA_respuestas1` FOREIGN KEY (`respuestas_preguntas_numpregunta`, `respuestas_alumno_codalumno`) REFERENCES `respuestas` (`preguntas_numpregunta`, `alumno_codalumno`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `notaprof`
--
ALTER TABLE `notaprof`
ADD CONSTRAINT `fk_notaprof_respuestasprof1` FOREIGN KEY (`respuestasprof_idrespuestasprof`) REFERENCES `respuestasprof` (`idrespuestasprof`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `notaxexamen`
--
ALTER TABLE `notaxexamen`
ADD CONSTRAINT `fk_notaxexamen_examenresuelto1` FOREIGN KEY (`examenresuelto_idexamenresuelto`) REFERENCES `examenresuelto` (`idexamenresuelto`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `preguntas`
--
ALTER TABLE `preguntas`
ADD CONSTRAINT `fk_preguntas_EXAMEN1` FOREIGN KEY (`examen_codexamen`) REFERENCES `examen` (`codexamen`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `profesor`
--
ALTER TABLE `profesor`
ADD CONSTRAINT `fk_PROFESOR_administrador1` FOREIGN KEY (`administrador_idadministrador`) REFERENCES `administrador` (`idadministrador`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `respuestas`
--
ALTER TABLE `respuestas`
ADD CONSTRAINT `fk_preguntas_has_ALUMNO_ALUMNO1` FOREIGN KEY (`alumno_codalumno`) REFERENCES `alumno` (`codalumno`) ON DELETE NO ACTION ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_preguntas_has_ALUMNO_preguntas1` FOREIGN KEY (`preguntas_numpregunta`) REFERENCES `preguntas` (`numpregunta`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `respuestasprof`
--
ALTER TABLE `respuestasprof`
ADD CONSTRAINT `fk_respuestasprof_preguntas1` FOREIGN KEY (`preguntas_numpregunta`) REFERENCES `preguntas` (`numpregunta`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
