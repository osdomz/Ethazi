DROP DATABASE IF EXISTS agencia_de_viajes;
CREATE DATABASE agencia_de_viajes CHARACTER SET utf8mb4;
USE agencia_de_viajes;

-- tablas

CREATE TABLE personas (
	dni VARCHAR(9) PRIMARY KEY,
	nombre VARCHAR(25),
	apellido1 VARCHAR(25),
	apellido2 VARCHAR(25),
	edad INT(3),
	telefono VARCHAR(30),
	email VARCHAR(30)
);

CREATE TABLE personas_modificados (
	dni VARCHAR(9) PRIMARY KEY,
	nombre VARCHAR(25),
	apellido1 VARCHAR(25),
	apellido2 VARCHAR(25),
	edad INT(3),
	telefono VARCHAR(30),
	email VARCHAR(30),
	fch_modificacion VARCHAR(20)
);

CREATE TABLE personas_eliminados (
	dni VARCHAR(9) PRIMARY KEY,
	nombre VARCHAR(25),
	apellido1 VARCHAR(25),
	apellido2 VARCHAR(25),
	edad INT(3),
	telefono VARCHAR(30),
	email VARCHAR(30),
	fch_eliminacion VARCHAR(20)
);

CREATE TABLE socios (
	dni VARCHAR(9) PRIMARY KEY,
	numSocio INT,
	CONSTRAINT fk1 FOREIGN KEY (dni) REFERENCES personas (dni)
);

CREATE TABLE clientes (
	dni VARCHAR(9) PRIMARY KEY,
	numCliente INT,
	CONSTRAINT fk2 FOREIGN KEY (dni) REFERENCES personas (dni)
);

CREATE TABLE vuelos (
	codV VARCHAR(10) PRIMARY KEY,
	aerolinea VARCHAR(30),
	origen VARCHAR(30),
	destino VARCHAR(30),
	clase VARCHAR(30),
	fechaSalida DATE,
	fechaLlegada DATE,
	precio DOUBLE
);

CREATE TABLE hoteles (
	codH VARCHAR(10) PRIMARY KEY,
	nombre VARCHAR(25),
	direccion VARCHAR(30),
	numEstrellas INT,
	tiempo VARCHAR (3),
	precio DOUBLE
);

CREATE TABLE reservasv (
	dni VARCHAR(9),
	codV VARCHAR(10),
	numRV INT,
	fechaRV DATE,
	PRIMARY KEY (dni,codV),
	CONSTRAINT fk3 FOREIGN KEY (dni) REFERENCES personas (dni),
	CONSTRAINT fk4 FOREIGN KEY (codV) REFERENCES vuelos (codV)
);

CREATE TABLE reservash (
	dni VARCHAR(9),
	codH VARCHAR(10),
	numRH INT,
	fechaRH DATE,
	PRIMARY KEY (dni,codH),
	CONSTRAINT fk5 FOREIGN KEY (dni) REFERENCES personas (dni),
	CONSTRAINT fk6 FOREIGN KEY (codH) REFERENCES hoteles (codH)
);

-- datos

INSERT INTO personas VALUES ('12345011A','Marcos','Magaña','Perez',32,1234567,'marcosmagaña@email.local');
INSERT INTO personas VALUES ('12345012A','Ruben','López','Martinez',26,1234467,'rubenlopez@email.local');
INSERT INTO personas VALUES ('12345013A','Alberto','Soria','Carrasco',38,1232567,'albertosoria@email.local');
INSERT INTO personas VALUES ('12345014A','Maria','Solís','Jerez',20,12345767,'mariasolis@email.local');
INSERT INTO personas VALUES ('12345015A','Felipe','Rosas','Marquez',28,1234567,'rosasmarquez@email.local');
INSERT INTO personas VALUES ('12345016A','Carlos','Parra','Jimenez',25,1236567,'soriajimenez@email.local');
INSERT INTO personas VALUES ('12345017A','Emmanuel','Magaña','Perez',42,1544567,'magañaperez@email.local');
INSERT INTO personas VALUES ('12345018A','Josh','Layton','Suarez',20,1544567,'joshlai@email.local');
INSERT INTO personas VALUES ('12345019A','Baron','Humbert','Vin',37,1544567,'humvin@email.local');
INSERT INTO personas VALUES ('12345020A','Nicolas','Barreto','Sanclemente',22,1544567,'nibasan@email.local');
INSERT INTO personas VALUES ('12345021A','Emmanuel','Polania','Muñoz',19,1544567,'emmapola@email.local');
INSERT INTO personas VALUES ('12345022A','Juan','Villamizar','Quintero',23,1544567,'villajuan@email.local');
INSERT INTO personas VALUES ('12345023A','Daniela','Rodriguez','Parra',30,1544567,'roroparra@email.local');
INSERT INTO personas VALUES ('12345024A','Mariapaula','Guzman','Perez',20,1544567,'maripau@email.local');

INSERT INTO socios VALUES ('12345011A',001);
INSERT INTO socios VALUES ('12345012A',002);
INSERT INTO socios VALUES ('12345018A',003);
INSERT INTO socios VALUES ('12345019A',004);
INSERT INTO socios VALUES ('12345020A',005);

INSERT INTO clientes VALUES ('12345013A',001);
INSERT INTO clientes VALUES ('12345014A',002);
INSERT INTO clientes VALUES ('12345015A',003);
INSERT INTO clientes VALUES ('12345016A',004);
INSERT INTO clientes VALUES ('12345017A',005);
INSERT INTO clientes VALUES ('12345021A',006);
INSERT INTO clientes VALUES ('12345022A',007);
INSERT INTO clientes VALUES ('12345023A',008);
INSERT INTO clientes VALUES ('12345024A',009);

INSERT INTO vuelos VALUES ('VC001','BMI','Bilbao','Londres','Turista','2023-04-02','2023-04-10',80);
INSERT INTO vuelos VALUES ('VC002','Avianca','Donostia','Bogotá','turista','2023-06-09','2023-06-20',500);
INSERT INTO vuelos VALUES ('VC003','Iberia','Bilbao','Barcelona','turista','2023-05-08','2023-05-27',80);
INSERT INTO vuelos VALUES ('VC004','Corsairfly','Victoria','Paris','primera clase','2023-07-06','2023-07-15',180);
INSERT INTO vuelos VALUES ('VC005','Eurowings','Bilbao','Berlin','primera clase','2023-10-05','2023-10-11',170);
INSERT INTO vuelos VALUES ('VC006','Airlines','Navarra','Japon','primera clase','2023-08-08','2023-08-20',900);
INSERT INTO vuelos VALUES ('VC007','Emirates','Bilbao','Vietnam','turista','2023-09-05','2023-09-30',800);
INSERT INTO vuelos VALUES ('VC008','Brussels','Donostia','Roma','turista','2023-09-05','2023-09-30',100);
INSERT INTO vuelos VALUES ('VC009','Airlines','Navarra','Nueva York','primera clase','2023-08-08','2023-08-20',550);
INSERT INTO vuelos VALUES ('VC010','Delta','Donostia','Amsterdam','turista','2023-10-05','2023-10-11',90);
INSERT INTO vuelos VALUES ('VC011','Airlines','Victoria','Los Angeles','primera clase','2023-07-06','2023-07-15',650);
INSERT INTO vuelos VALUES ('VC012','Brussels','Navarra','Atenas','turista','2023-05-08','2023-05-27',120);
INSERT INTO vuelos VALUES ('VC013','Lufthansa','Bilbao','Berlin','turista','2023-06-09','2023-06-20',90);
INSERT INTO vuelos VALUES ('VC014','Satena','Donostia','Lima','turista','2023-04-02','2023-04-10',500);

INSERT INTO reservasv VALUES ('12345011A','VC001',001,'2023-04-02');
INSERT INTO reservasv VALUES ('12345012A','VC002',002,'2023-06-09');
INSERT INTO reservasv VALUES ('12345013A','VC003',003,'2023-05-08');
INSERT INTO reservasv VALUES ('12345014A','VC004',004,'2023-07-06');
INSERT INTO reservasv VALUES ('12345015A','VC005',005,'2023-10-05');
INSERT INTO reservasv VALUES ('12345016A','VC006',006,'2023-08-08');
INSERT INTO reservasv VALUES ('12345017A','VC007',007,'2023-09-05');
INSERT INTO reservasv VALUES ('12345018A','VC008',008,'2023-09-05');
INSERT INTO reservasv VALUES ('12345019A','VC009',009,'2023-08-08');
INSERT INTO reservasv VALUES ('12345020A','VC010',010,'2023-10-05');
INSERT INTO reservasv VALUES ('12345021A','VC011',011,'2023-07-06');
INSERT INTO reservasv VALUES ('12345022A','VC012',012,'2023-05-08');
INSERT INTO reservasv VALUES ('12345023A','VC013',013,'2023-06-09');
INSERT INTO reservasv VALUES ('12345024A','VC014',014,'2023-04-02');

INSERT INTO hoteles VALUES ('HC001','Royal Thames','Londres',4,'3d',100);
INSERT INTO hoteles VALUES ('HC002','Hilton','Bogotá',2,'5d',37);
INSERT INTO hoteles VALUES ('HC003','Catalonia','Barcelona',3,'7d',50);
INSERT INTO hoteles VALUES ('HC004','Hotel Bellevue','Paris',4,'5d',120);
INSERT INTO hoteles VALUES ('HC005','Friedrichstrabe','Berlin',5,'4d',150);
INSERT INTO hoteles VALUES ('HC006','Shangri','Japon',5,'5d',300);
INSERT INTO hoteles VALUES ('HC007','Furama Resort','Vietnam',2,'6d',100);
INSERT INTO hoteles VALUES ('HC008','Via Veneto','Roma',3,'5d',115);
INSERT INTO hoteles VALUES ('HC009','Park Central Hotel','Nueva York',5,'2d',200);
INSERT INTO hoteles VALUES ('HC010','Pestana Riverside','Amsterdam',4,'4d',100);
INSERT INTO hoteles VALUES ('HC011','Skyline Hotel','Los Angeles',4,'3d',128);
INSERT INTO hoteles VALUES ('HC012','Acropolis','Atenas',3,'2d',180);
INSERT INTO hoteles VALUES ('HC013','Meininger','Berlin',4,'4d',155);
INSERT INTO hoteles VALUES ('HC014','Costa de Sol','Lima',2,'5d',38);

INSERT INTO reservash VALUES ('12345011A','HC001',001,'2023-04-02');
INSERT INTO reservash VALUES ('12345012A','HC002',002,'2023-06-09');
INSERT INTO reservash VALUES ('12345013A','HC003',003,'2023-05-08');
INSERT INTO reservash VALUES ('12345014A','HC004',004,'2023-07-06');
INSERT INTO reservash VALUES ('12345015A','HC005',005,'2023-10-05');
INSERT INTO reservash VALUES ('12345016A','HC006',006,'2023-08-08');
INSERT INTO reservash VALUES ('12345017A','HC007',007,'2023-09-05');
INSERT INTO reservash VALUES ('12345018A','HC008',008,'2023-09-05');
INSERT INTO reservash VALUES ('12345019A','HC009',009,'2023-08-08');
INSERT INTO reservash VALUES ('12345020A','HC010',010,'2023-10-05');
INSERT INTO reservash VALUES ('12345021A','HC011',011,'2023-07-06');
INSERT INTO reservash VALUES ('12345022A','HC012',012,'2023-05-08');
INSERT INTO reservash VALUES ('12345023A','HC013',013,'2023-06-09');
INSERT INTO reservash VALUES ('12345024A','HC014',014,'2023-04-02');

-- procedure

DELIMITER ;;
DROP PROCEDURE IF EXISTS reservas_vuelo;;
CREATE PROCEDURE reservas_vuelo ()
BEGIN
SELECT p.dni, p.nombre, p.apellido1 AS 'apellido', v.* 
FROM personas p, reservasv rv, vuelos v 
WHERE p.dni = rv.dni AND v.codV = rv.codV
ORDER BY v.fechaSalida, v.fechaLlegada ASC;
END;;

DELIMITER ;;
DROP PROCEDURE IF EXISTS reservas_hotel;;
CREATE PROCEDURE reservas_hotel ()
BEGIN
SELECT p.dni, p.nombre, p.apellido1 AS 'apellido', h.codH, h.nombre AS 'Hotel', h.direccion, h.numEstrellas, h.tiempo, h.precio 
FROM personas p, reservash rh, hoteles h 
WHERE p.dni = rh.dni AND h.codH = rh.codH
ORDER BY h.codH ASC;
END;;

-- TRIGGER

DELIMITER ;;
DROP TRIGGER IF EXISTS trigger_delete;;
CREATE TRIGGER trigger_delete
BEFORE DELETE
ON personas FOR EACH ROW
BEGIN
INSERT INTO personas_eliminados VALUES (old.dni,old.nombre,old.apellido1,old.apellido2,old.edad,old.telefono,old.email,SYSDATE());
END;;

DELIMITER ;;
DROP TRIGGER IF EXISTS trigger_update;;
CREATE TRIGGER trigger_update
BEFORE UPDATE
ON personas FOR EACH ROW
BEGIN
INSERT INTO personas_modificados VALUES (old.dni,old.nombre,old.apellido1,old.apellido2,old.edad,old.telefono,old.email,SYSDATE());
END;;