USE pizzeria;

-- Llista quants productes de categoria 'Begudes' s'han venut en una determinada localitat.
SELECT product.name AS 'Drink name', SUM(order_has_product.quantity) AS 'Total units sold', city.name AS 'City' FROM order_has_product
RIGHT JOIN product ON order_has_product.product_id=product.product_id 
RIGHT JOIN pizzeria.order ON order_has_product.order_id=pizzeria.order.order_id
RIGHT JOIN store ON pizzeria.order.store_id=store.store_id
RIGHT JOIN address ON store.address_id=address.address_id
RIGHT JOIN city ON address.city_id=city.city_id
WHERE product_type='drink' AND city.name='Tarragona'
GROUP BY product.name;

-- Llista quantes comandes ha efectuat un determinat empleat/da.
SELECT COUNT(pizzeria.order.order_id) AS 'Total orders',CONCAT (employee.name, ' ', employee.first_last_name, ' ', second_last_name) AS 'Name of employee' FROM pizzeria.order
JOIN employee ON pizzeria.order.employee_id=employee.employee_id
WHERE employee.employee_id=1;