SELECT Customers.name as Customers from Customers as Customers
left Join Orders 
on Customers.id = Orders.customerId
where customerId is null ;