USE TIENDA;
-- 1
SELECT * FROM producto;
-- 2
SELECT nombre,precio FROM producto;
-- 3
SHOW COLUMNS FROM producto;
-- 4
SELECT nombre, precio, FORMAT((precio/1.08),2) FROM producto;
-- 5
SELECT nombre, precio AS 'Precio en euros', FORMAT((precio/1.08),2) AS 'Precio en USD' FROM producto;
-- 6
SELECT UPPER(nombre), precio FROM producto;
-- 7
SELECT LOWER(nombre), precio FROM producto;
-- 8
SELECT nombre, UPPER(substr(nombre,1,2)) FROM fabricante;
-- 9
SELECT nombre, round(precio) FROM producto;
-- 10
SELECT nombre, truncate(precio, 0) FROM producto;
-- 11
SELECT codigo_fabricante FROM producto;
-- 12
SELECT codigo_fabricante FROM producto GROUP BY codigo_fabricante;
-- 13
SELECT nombre FROM FABRICANTE ORDER BY nombre ASC;
-- 14
SELECT nombre FROM FABRICANTE ORDER BY nombre DESC;
-- 15
SELECT nombre FROM producto ORDER BY nombre ASC, precio DESC;
-- 16
SELECT * FROM fabricante LIMIT 5;
-- 17
SELECT * FROM fabricante LIMIT 3,2;
-- 18
SELECT nombre, precio FROM producto ORDER BY precio ASC LIMIT 1;
-- 19
SELECT nombre, precio FROM producto ORDER BY precio DESC LIMIT 1;
-- 20
SELECT * FROM producto WHERE codigo_fabricante=2;
-- 21
SELECT p.nombre AS 'producto', p.precio, f.nombre AS 'fabricante' FROM producto p, fabricante f;
-- 22
SELECT p.nombre AS 'producto', p.precio, f.nombre AS 'fabricante' FROM producto p, fabricante f ORDER BY f.nombre ASC;
-- 23
SELECT p.codigo AS 'código producto', p.nombre AS 'producto', p.precio, f.codigo AS 'código fabricante', f.nombre AS 'fabricante' FROM producto p, fabricante f;
-- 24
SELECT p.precio, p.nombre AS 'producto', f.nombre AS 'fabricante' FROM producto p, fabricante f WHERE p.codigo_fabricante=f.codigo ORDER BY precio ASC LIMIT 1;
-- 25
SELECT p.precio, p.nombre AS 'producto', f.nombre AS 'fabricante' FROM producto p, fabricante f WHERE p.codigo_fabricante=f.codigo ORDER BY precio DESC LIMIT 1;
-- 26
SELECT p.* FROM producto p JOIN fabricante f ON p.codigo_fabricante=f.codigo AND f.nombre='Lenovo';
-- 27
SELECT p.* FROM producto p JOIN fabricante f ON p.codigo_fabricante=f.codigo AND f.nombre='Crucial' AND p.precio>200;
-- 28
SELECT p.*, f.nombre AS 'fabricante' FROM producto p JOIN fabricante f ON p.codigo_fabricante=f.codigo WHERE f.nombre='Asus' OR f.nombre='Hewlett-Packard' OR f.nombre='Seagate';
-- 29
SELECT p.nombre AS 'producto', p.precio, f.nombre AS 'fabricante' FROM producto p JOIN fabricante f ON p.codigo_fabricante=f.codigo WHERE f.nombre IN('Asus','Hewlett-Packard','Seagate');
-- 30
SELECT p.nombre, p.precio, f.nombre AS 'fabricante' FROM producto p JOIN fabricante f ON p.codigo_fabricante=f.codigo WHERE f.nombre LIKE '%e';
-- 31
SELECT p.nombre, p.precio, f.nombre AS 'fabricante' FROM producto p JOIN fabricante f ON p.codigo_fabricante=f.codigo WHERE f.nombre LIKE '%w%';
-- 32
SELECT p.nombre AS 'producto', p.precio, f.nombre AS 'fabricante' FROM producto p JOIN fabricante f ON p.codigo_fabricante=f.codigo WHERE p.precio>=180 ORDER BY p.precio ASC, p.nombre DESC;
-- 33
SELECT f.codigo, f.nombre FROM fabricante f JOIN producto p ON f.codigo=p.codigo_fabricante GROUP BY f.codigo; 
-- 34
SELECT f.nombre AS 'fabricante', p.nombre AS 'producto' FROM fabricante f LEFT JOIN producto p ON f.codigo=p.codigo_fabricante; 
-- 35
SELECT f.nombre AS 'fabricante', p.nombre AS 'producto' FROM fabricante f LEFT JOIN producto p ON f.codigo=p.codigo_fabricante WHERE p.codigo IS NULL; 
-- 36
SELECT p.* FROM producto p, fabricante f WHERE p.codigo_fabricante=f.codigo AND f.nombre='Lenovo';
-- 37
SELECT p.* FROM producto p, fabricante f WHERE p.codigo_fabricante=f.codigo AND p.precio=(SELECT MAX(p.precio) FROM producto p, fabricante f  WHERE p.codigo_fabricante=f.codigo AND f.nombre='Lenovo');
-- 38
SELECT p.nombre FROM producto p JOIN fabricante f ON p.precio=(SELECT MAX(p.precio) FROM producto p JOIN fabricante f  ON p.codigo_fabricante=f.codigo AND f.nombre='Lenovo') AND f.nombre='Lenovo';
-- 39
SELECT p.nombre FROM producto p JOIN fabricante f ON p.precio=(SELECT MIN(p.precio) FROM producto p JOIN fabricante f  ON p.codigo_fabricante=f.codigo AND f.nombre='Hewlett-Packard') AND f.nombre='Hewlett-Packard';
-- 40
SELECT p.* FROM producto p JOIN fabricante f ON p.codigo_fabricante=f.codigo AND p.precio>=(SELECT MAX(p.precio) FROM producto p JOIN fabricante f ON p.codigo_fabricante=f.codigo AND f.nombre='Lenovo');
-- 41
SELECT p.* FROM producto p JOIN fabricante f ON p.codigo_fabricante=f.codigo AND f.nombre='Asus' AND p.precio<(SELECT AVG(p.precio) FROM producto p) ;

