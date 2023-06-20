
-- multiple tables join
Select C.name AS CustomerName , D.name AS DriverName, D.Driving_License, O.Order_Id
FROM Customer C , Driver D , Orders O, Car ca
Where C.Customer_id = O.Customer_Id
AND ca.driver_id = d.driver_id
AND ca.customer_id = c.customer_id;

-- Inner join Query
Select C.name AS CustomerName , D.name AS DriverName, Ca.car_id From Customer C
Inner Join Driver D Inner Join Car Ca ON D.driver_id = Ca.Driver_id
Where C.Customer_id = 1;

-- Left Join Query
SELECT Ca.car_id , cam.miles_driven FROM Car ca
LEFT JOIN car_amortization cam ON cam.car_id = ca.car_id;

-- Right Join Query
SELECT Ca.car_id , cam.miles_driven FROM Car ca
Right JOIN car_amortization cam ON cam.car_id = ca.car_id;

-- innner join trip with trip payment
Select T.Trip_id , TP.method , TP.amount FROM
Trip T Inner Join Trip_payment TP On TP.trip_id = t.trip_id;

-- right join trip without payment
Select T.Trip_id , TP.method , TP.amount FROM
Trip T right Join Trip_payment TP On TP.trip_id = t.trip_id;

-- Count with group by
SELECT Count(customer_id) AS Total_Orders
FROM Orders GROUP BY customer_id;

-- SUM with group by
SELECT SUM(price) AS Total_Expense, customer_id
FROM Orders GROUP BY customer_id;

-- Average price
SELECT AVG(price) AS Average_Price, customer_id
FROM Orders GROUP BY customer_id;

-- Max Payment of the order
SELECT MAX(Payment) from Trip
group by customer_id;

-- Count rating of each driver
SELECT  COUNT(rating)  from Rating
GROUP BY driver_id;

-- Trip payment
SELECT SUM(amount) Total_Amount FROM Trip_Payment
GROUP By trip_id;

-- Average trip amount by payment method
Select AVG(amount) AS Average_TripPaymentAmount
FROM Trip_Payment
GROUP by method;



-- Count with group by
SELECT Count(customer_id) AS Total_Orders
FROM Orders GROUP BY customer_id
HAVING customer_id = 1;

-- SUM with group by
SELECT SUM(price) AS Total_Expense, customer_id
FROM Orders GROUP BY customer_id
HAVING SUM(price)>2000;

-- Average price
SELECT AVG(price) AS Average_Price, customer_id
FROM Orders GROUP BY customer_id;

-- Max Payment of the order
SELECT MAX(Payment) from Trip
group by customer_id
HAVING MAX(PAYMENT) <2000;

-- Count rating having rating
SELECT  COUNT(rating)  from Rating
GROUP BY driver_id
HAVING rating < 3;

-- Average trip amount by payment method
Select AVG(amount) AS Average_TripPaymentAmount
FROM Trip_Payment
GROUP by method
HAVING method = "CASH";

-- get trip payment greater than 1000
SELECT SUM(amount) Total_Amount FROM Trip_Payment
GROUP By trip_id
Having SUM(amount)>1000;
