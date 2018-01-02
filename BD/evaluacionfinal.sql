-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 02-07-2017 a las 21:50:54
-- Versión del servidor: 10.1.21-MariaDB
-- Versión de PHP: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `evaluacionfinal`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `administrador`
--

CREATE TABLE `administrador` (
  `idadministrador` int(11) NOT NULL,
  `nombadmin` varchar(45) DEFAULT NULL,
  `idadmin` varchar(45) DEFAULT NULL,
  `contraadmin` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `administrador`
--

INSERT INTO `administrador` (`idadministrador`, `nombadmin`, `idadmin`, `contraadmin`) VALUES
(1, 'giampieer', 'giampieer24', '1111');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumno`
--

CREATE TABLE `alumno` (
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
(1, 'giampieer', 'giampieer24', '1111', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `examen`
--

CREATE TABLE `examen` (
  `codexamen` int(11) NOT NULL,
  `nombexamen` varchar(45) DEFAULT NULL,
  `profesor_idporfesor` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `examen`
--

INSERT INTO `examen` (`codexamen`, `nombexamen`, `profesor_idporfesor`) VALUES
(1, 'asdas', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `examenresuelto`
--

CREATE TABLE `examenresuelto` (
  `idexamenresuelto` int(11) NOT NULL,
  `codexamen` int(11) DEFAULT NULL,
  `alumno_codalumno` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `examenresuelto`
--

INSERT INTO `examenresuelto` (`idexamenresuelto`, `codexamen`, `alumno_codalumno`) VALUES
(1, 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `nota`
--

CREATE TABLE `nota` (
  `idnota` int(11) NOT NULL,
  `puntajealumno` varchar(45) DEFAULT NULL,
  `respuestas_preguntas_numpregunta` int(11) NOT NULL,
  `respuestas_ALUMNO_codalumno` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `notaprof`
--

CREATE TABLE `notaprof` (
  `idnotaprof` int(11) NOT NULL,
  `puntaje` varchar(45) DEFAULT NULL,
  `respuestasprof_idrespuestasprof` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `notaprof`
--

INSERT INTO `notaprof` (`idnotaprof`, `puntaje`, `respuestasprof_idrespuestasprof`) VALUES
(1, '0.0', 1),
(2, '20.0', 2),
(3, '0.0', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `notaxexamen`
--

CREATE TABLE `notaxexamen` (
  `codexamen` int(11) NOT NULL,
  `puntaje` varchar(45) DEFAULT NULL,
  `examenresuelto_idexamenresuelto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `preguntas`
--

CREATE TABLE `preguntas` (
  `numpregunta` int(11) NOT NULL,
  `pregunta` varchar(45) DEFAULT NULL,
  `examen_codexamen` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `preguntas`
--

INSERT INTO `preguntas` (`numpregunta`, `pregunta`, `examen_codexamen`) VALUES
(1, 'asdas', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `profesor`
--

CREATE TABLE `profesor` (
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
(1, 'giampieer', 'giampieer24', '1111', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `respuestas`
--

CREATE TABLE `respuestas` (
  `preguntas_numpregunta` int(11) NOT NULL,
  `alumno_codalumno` int(11) NOT NULL,
  `respuesta` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `respuestas`
--

INSERT INTO `respuestas` (`preguntas_numpregunta`, `alumno_codalumno`, `respuesta`) VALUES
(1, 1, '20.0');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `respuestasprof`
--

CREATE TABLE `respuestasprof` (
  `idrespuestasprof` int(11) NOT NULL,
  `respuestasprofcol` varchar(45) DEFAULT NULL,
  `preguntas_numpregunta` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `respuestasprof`
--

INSERT INTO `respuestasprof` (`idrespuestasprof`, `respuestasprofcol`, `preguntas_numpregunta`) VALUES
(1, 'sadsa', 1),
(2, 'sdaas', 1),
(3, 'asd', 1);

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
  ADD PRIMARY KEY (`codalumno`),
  ADD KEY `fk_ALUMNO_administrador1_idx` (`administrador_idadministrador`);

--
-- Indices de la tabla `examen`
--
ALTER TABLE `examen`
  ADD PRIMARY KEY (`codexamen`),
  ADD KEY `fk_EXAMEN_PROFESOR1_idx` (`profesor_idporfesor`);

--
-- Indices de la tabla `examenresuelto`
--
ALTER TABLE `examenresuelto`
  ADD PRIMARY KEY (`idexamenresuelto`),
  ADD KEY `fk_examenresuelto_ALUMNO1_idx` (`alumno_codalumno`);

--
-- Indices de la tabla `nota`
--
ALTER TABLE `nota`
  ADD PRIMARY KEY (`idnota`),
  ADD KEY `fk_NOTA_respuestas1_idx` (`respuestas_preguntas_numpregunta`,`respuestas_ALUMNO_codalumno`);

--
-- Indices de la tabla `notaprof`
--
ALTER TABLE `notaprof`
  ADD PRIMARY KEY (`idnotaprof`),
  ADD KEY `fk_notaprof_respuestasprof1_idx` (`respuestasprof_idrespuestasprof`);

--
-- Indices de la tabla `notaxexamen`
--
ALTER TABLE `notaxexamen`
  ADD PRIMARY KEY (`codexamen`),
  ADD KEY `fk_notaxexamen_examenresuelto1_idx` (`examenresuelto_idexamenresuelto`);

--
-- Indices de la tabla `preguntas`
--
ALTER TABLE `preguntas`
  ADD PRIMARY KEY (`numpregunta`),
  ADD KEY `fk_preguntas_EXAMEN1_idx` (`examen_codexamen`);

--
-- Indices de la tabla `profesor`
--
ALTER TABLE `profesor`
  ADD PRIMARY KEY (`idporfesor`),
  ADD KEY `fk_PROFESOR_administrador1_idx` (`administrador_idadministrador`);

--
-- Indices de la tabla `respuestas`
--
ALTER TABLE `respuestas`
  ADD PRIMARY KEY (`preguntas_numpregunta`,`alumno_codalumno`),
  ADD KEY `fk_preguntas_has_ALUMNO_ALUMNO1_idx` (`alumno_codalumno`),
  ADD KEY `fk_preguntas_has_ALUMNO_preguntas1_idx` (`preguntas_numpregunta`);

--
-- Indices de la tabla `respuestasprof`
--
ALTER TABLE `respuestasprof`
  ADD PRIMARY KEY (`idrespuestasprof`),
  ADD KEY `fk_respuestasprof_preguntas1_idx` (`preguntas_numpregunta`);

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
  ADD CONSTRAINT `fk_NOTA_respuestas1` FOREIGN KEY (`respuestas_preguntas_numpregunta`,`respuestas_ALUMNO_codalumno`) REFERENCES `respuestas` (`preguntas_numpregunta`, `alumno_codalumno`) ON DELETE NO ACTION ON UPDATE NO ACTION;

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
