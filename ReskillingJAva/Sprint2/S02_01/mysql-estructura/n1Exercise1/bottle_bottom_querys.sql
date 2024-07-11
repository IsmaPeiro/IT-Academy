USE bottle_bottom;

SELECT client.name, COUNT(bill.id) AS 'total bills' FROM client
LEFT JOIN bill ON client.id=bill.client_id AND bill.bill_date BETWEEN '2016-03-20 15:00:00' AND '2024-03-20 18:00:00'
WHERE client.id=1
GROUP BY client.name;

SELECT employee.name AS 'Employee', brand.name AS 'Glasses model', count(brand.name) AS 'Total sold' FROM employee
LEFT JOIN bill on employee.id=bill.employee_id and bill.bill_date BETWEEN '2023-01-01 00:00:00' AND '2023-12-31 23:59:59'
LEFT join glasses on bill.glasses_id=glasses.id
LEFT join brand on glasses.brand_id=brand.id
where employee.id=2
group by brand.name;

select supplier.name as 'Supplier name', brand.name as 'Glasses Model', count(glasses.id) as 'total sold' from supplier
right join brand on supplier.NIF=brand.supplier_nif
right join glasses on brand.id=glasses.brand_id
right join bill on glasses.id=bill.glasses_id
group by supplier.name, brand.name;