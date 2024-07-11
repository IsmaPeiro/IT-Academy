USE universidad;
-- 1
SELECT apellido2, apellido1, nombre FROM persona WHERE tipo='alumno' ORDER BY nombre DESC, apellido2 DESC, apellido1 DESC;
-- 2
SELECT apellido2, apellido1, nombre FROM persona WHERE tipo='alumno' AND telefono IS NULL;
-- 3
SELECT * FROM persona WHERE tipo='alumno' AND fecha_nacimiento BETWEEN '1999-01-01' AND '1999-12-31';
-- 4
SELECT * FROM persona WHERE tipo='profesor' AND telefono IS NULL AND nif LIKE- '%K';
-- 5
SELECT a.* FROM asignatura a WHERE a.id_grado=7 AND a.cuatrimestre=1 AND a.curso=3;
-- 6
SELECT  per.nombre, per.apellido1, per.apellido2, d.nombre AS 'departamento' FROM persona per JOIN profesor pro ON per.id=pro.id_profesor JOIN departamento d ON pro.id_departamento=d.id ORDER BY apellido1 ASC, apellido2 ASC;
-- 7
SELECT a.nombre, c.anyo_inicio AS 'año de inicio', c.anyo_fin AS 'año de fin' FROM asignatura a JOIN curso_escolar c ON a.curso=c.id JOIN alumno_se_matricula_asignatura asm ON c.id=asm.id_curso_escolar AND a.id=asm.id_asignatura JOIN persona p ON asm.id_alumno=p.id AND p.nif='26902806M';
-- 8
SELECT d.nombre FROM departamento d JOIN profesor pro ON d.id=pro.id_departamento JOIN asignatura a ON pro.id_profesor=a.id_profesor JOIN grado g ON a.id_grado=g.id AND g.nombre='Grado en Ingeniería Informática (Plan 2015)' GROUP BY d.nombre;
-- 9
SELECT per.* FROM persona per JOIN alumno_se_matricula_asignatura asm ON per.id=asm.id_alumno JOIN curso_escolar c ON asm.id_curso_escolar=c.id AND c.anyo_inicio='2018' AND c.anyo_fin='2019' GROUP BY per.id;
-- LEFT JOIN i RIGHT JOIN
-- 1
SELECT per.nombre, per.apellido1, per.apellido2, dep.nombre AS 'departamento' FROM persona per RIGHT JOIN profesor pro ON per.id=pro.id_profesor LEFT JOIN departamento dep ON pro.id_departamento=dep.id ORDER BY dep.nombre DESC, apellido1 DESC, apellido2 DESC, nombre DESC;
-- 2
SELECT per.nombre, per.apellido1, per.apellido2, dep.nombre AS 'departamento' FROM persona per RIGHT JOIN profesor pro ON per.id=pro.id_profesor LEFT JOIN departamento dep ON pro.id_departamento=dep.id WHERE pro.id_departamento IS NULL;
-- 3
SELECT dep.nombre AS 'departamento' FROM departamento dep LEFT JOIN profesor pro ON dep.id=pro.id_departamento LEFT JOIN persona per ON pro.id_profesor=per.id WHERE per.nombre IS NULL; 
-- 4
SELECT CONCAT(per.nombre, ' ', per.apellido1, ' ', per.apellido2) AS 'profesor' FROM persona per RIGHT JOIN profesor pro ON per.id=pro.id_profesor LEFT JOIN asignatura asig ON pro.id_profesor=asig.id_profesor WHERE asig.id IS NULL GROUP BY profesor;
-- 5
SELECT nombre FROM asignatura WHERE id_profesor IS NULL;
-- 6
SELECT dep.nombre FROM departamento dep LEFT JOIN profesor pro ON dep.id=pro.id_departamento LEFT JOIN asignatura asig ON pro.id_profesor=asig.id_profesor LEFT JOIN alumno_se_matricula_asignatura asm ON asig.id=asm.id_asignatura LEFT JOIN curso_escolar cur ON asig.curso=cur.id WHERE cur.id IS NULL GROUP BY dep.nombre;
-- consultes resum
-- 1
SELECT COUNT(id) AS 'Total alumnos' FROM persona WHERE tipo='alumno';
-- 2
SELECT COUNT(id) AS 'Total alumnos nacidos en 1999' FROM persona WHERE tipo='alumno' AND fecha_nacimiento BETWEEN '1999-01-01' AND '1999-12-31';
-- 3
SELECT dep.nombre AS 'departamento', COUNT(per.id) AS 'Profesores' FROM persona per JOIN profesor pro ON per.id=pro.id_profesor JOIN departamento dep ON pro.id_departamento=dep.id GROUP BY dep.nombre ORDER BY Profesores DESC;
-- 4
SELECT dep.nombre AS 'departamento', COUNT(per.id) AS 'Profesores' FROM persona per JOIN profesor pro ON per.id=pro.id_profesor RIGHT JOIN departamento dep ON pro.id_departamento=dep.id GROUP BY dep.nombre ORDER BY Profesores DESC;
-- 5
SELECT g.nombre, COUNT(a.id) AS 'asignaturas' FROM grado g LEFT JOIN asignatura a ON g.id=a.id_grado GROUP BY g.nombre ORDER BY asignaturas DESC;
-- 6
SELECT g.nombre, COUNT(a.id) AS 'asignaturas' FROM grado g RIGHT JOIN asignatura a ON g.id=a.id_grado GROUP BY g.nombre HAVING asignaturas>40 ORDER BY asignaturas DESC;
-- 7
SELECT g.nombre, a.tipo, SUM(a.creditos) AS 'total creditos' FROM grado g JOIN asignatura a ON g.id=id_grado GROUP BY g.nombre, a.tipo;
-- 8
SELECT c.anyo_inicio, COUNT(asm.id_alumno) AS 'total alumnos' FROM curso_escolar c LEFT JOIN alumno_se_matricula_asignatura asm ON c.id=asm.id_curso_escolar GROUP BY c.anyo_inicio;
-- 9
SELECT pro.id_profesor, per.nombre, per.apellido1, per.apellido2, COUNT(a.id) AS 'asignaturas' FROM profesor pro JOIN persona per ON pro.id_profesor=per.id JOIN asignatura a ON pro.id_profesor=a.id_profesor GROUP BY pro.id_profesor, per.nombre, per.apellido1, per.apellido2 ORDER BY asignaturas DESC;
-- 10
SELECT * FROM persona WHERE tipo='alumno' AND fecha_nacimiento=(SELECT MIN(fecha_nacimiento) FROM persona WHERE tipo='alumno');
-- 11
SELECT per.nombre, per.apellido1, per.apellido2, dep.nombre AS 'departamento', a.nombre AS 'asignatura' FROM persona per JOIN profesor pro ON per.id=pro.id_profesor JOIN departamento dep ON pro.id_departamento=dep.id LEFT JOIN asignatura a ON pro.id_profesor=a.id_profesor WHERE a.nombre IS NULL;
