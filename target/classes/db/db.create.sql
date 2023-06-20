Drop Database Taxi;
Create Database Taxi;
USE Taxi;

CREATE TABLE Customer (

customer_id INT NOT NULL primary key,
name varchar(50) NOT NULL,
email varchar(50)

);

CREATE TABLE Driver (

driver_id INT NOT NULL primary key,
name varchar(50) NOT NULL,
email varchar(50),
driving_license varchar(50)

);

CREATE TABLE Car (

car_id INT NOT NULL primary key ,
customer_id int  NOT NULL,
driver_id int,
model varchar(50),
year varchar(50),

Foreign key(customer_id)  REFERENCES Customer (customer_id),
Foreign key(driver_id) REFERENCES Driver (driver_id)
);

CREATE TABLE Car_Amortization (

car_id INT NOT NULL primary key,
miles_driven Varchar(50)  NOT NULL,
year int,
car_depriciation int,

Foreign key(car_id) REFERENCES Car (car_id)

);

CREATE TABLE City (

city_name varchar(50) NOT NULL primary key,
country Varchar(50)  NOT NULL,
customer_id int,

Foreign key(customer_id) REFERENCES Customer (customer_id)

);

CREATE TABLE Car_Payment (

car_id int NOT NULL primary key,
price double NOT NULL,
monthly_payment double,
year int,

Foreign key(car_id) REFERENCES Car (car_id)
);

CREATE TABLE Driving_License (

driving_license varchar(50)  primary key,
category varchar(50) NOT NULL

);

CREATE TABLE Orders (

order_id int NOT NULL primary key,
customer_id int NOT NULL,
fromT varchar(50) not null,
toT varchar(50) not null,
price int,

Foreign key(customer_id) REFERENCES Customer (customer_id)
);

CREATE TABLE Trip (

trip_id int NOT NULL primary key,
customer_id int NOT NULL,
driver_id int not null,
payment int,
status int,

Foreign key(customer_id) REFERENCES Customer (customer_id),
Foreign key(driver_id) REFERENCES Driver (driver_id)
);


CREATE TABLE Rating (

customer_id int NOT NULL,
driver_id int NOT NULL,
trip_id int not null,
rating int  not null,
feedback varchar(50) not null,

Foreign key(customer_id) REFERENCES Customer (customer_id),
Foreign key(driver_id) REFERENCES Driver (driver_id),
Foreign key(trip_id) REFERENCES Trip (trip_id)

);

CREATE TABLE Trip_Payment (

trip_id int NOT NULL primary key,
method varchar(50) NOT NULL,
amount double not null,
customer_id int  not null,

Foreign key(customer_id) REFERENCES Customer (customer_id),
Foreign key(trip_id) REFERENCES Trip (trip_id)

);

CREATE TABLE Trip_Zones (

withinCityLimitZone varchar(50) NOT NULL,
outCityLimitZone varchar(50) NOT NULL,
trip_id int NOT NULL,
customer_id int  not null,

Foreign key(customer_id) REFERENCES Customer (customer_id),
Foreign key(trip_id) REFERENCES Trip (trip_id)

);
