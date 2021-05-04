# Host: localhost  (Version 5.5.5-10.4.8-MariaDB)
# Date: 2021-05-04 15:56:57
# Generator: MySQL-Front 6.1  (Build 1.21)


#
# Structure for table "tareas"
#

DROP TABLE IF EXISTS `tareas`;
CREATE TABLE `tareas` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `tarea` varchar(100) NOT NULL,
  `prioridad` int(11) NOT NULL,
  `completado` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

#
# Data for table "tareas"
#

INSERT INTO `tareas` VALUES (1,'reunion con estudiantes de la carrera',1,1),(2,'estudiar para el examen de probabilidades',1,2),(4,'examen',2,2);
