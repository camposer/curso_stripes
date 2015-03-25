CREATE TABLE persona (
	id INTEGER NOT NULL 
		GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	nombre VARCHAR(50) NOT NULL,
	apellido VARCHAR(50) NOT NULL,
	fecha_nacimiento DATE,
	correo_electronico VARCHAR(50),
	PRIMARY KEY (id)
);

INSERT INTO persona(nombre, apellido, fecha_nacimiento, correo_electronico)
VALUES('Juan', 'Pérez', '1990-01-01', 'juan@perez.com');
INSERT INTO persona(nombre, apellido, fecha_nacimiento, correo_electronico)
VALUES('María', 'García', '2000-02-01', 'maria@garcia.com');
INSERT INTO persona(nombre, apellido, correo_electronico)
VALUES('Pedro', 'González', 'pedro@gonzalez.com');

SELECT * FROM persona;