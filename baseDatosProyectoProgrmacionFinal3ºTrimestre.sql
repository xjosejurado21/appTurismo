
-- Tabla elementoConNombre
CREATE TABLE elementoConNombre (
    Nombre VARCHAR(255) NOT NULL
);

-- Tabla usuario
CREATE TABLE usuario (
    Id INT PRIMARY KEY,
    Nombre VARCHAR(255) NOT NULL,
    Email VARCHAR(255) UNIQUE NOT NULL,
    isAdmin BOOLEAN NOT NULL,
    Contrasena VARCHAR(255) NOT NULL
);

-- Tabla turista
CREATE TABLE turista (
    Destino VARCHAR(255) NOT NULL,
    fecha_llegada DATE NOT NULL,
    fecha_salida DATE NOT NULL,
    num_personas INT NOT NULL,
    Tarjeta_credito VARCHAR(255) NOT NULL
);

-- Tabla alquiler
CREATE TABLE alquiler (
    tipo VARCHAR(50) NOT NULL,
    precio FLOAT NOT NULL
);

-- Tabla servicio
CREATE TABLE servicio (
    id INT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    descripcion VARCHAR(255) NOT NULL,
    precio FLOAT NOT NULL
);

-- Tabla reservasActivas 
CREATE TABLE reservasActivas (
    id INT PRIMARY KEY,
    ServicioId INT,
    FOREIGN KEY (servicioId) REFERENCES servicio(id)
);

-- Tabla guiaTurismo
CREATE TABLE guiaTurismo (
    idiomas VARCHAR(255) NOT NULL,
    Experiencia INT NOT NULL
);

-- Tabla servicioTurismo
CREATE TABLE servicioTurismo (
    direccion VARCHAR(255) NOT NULL,
    horario VARCHAR(50) NOT NULL,
    categoria VARCHAR(50) NOT NULL,
    imagen VARCHAR(255) NOT NULL,
    contacto VARCHAR(255) NOT NULL
);

-- Tabla hotel
CREATE TABLE hotel (
    Estrellas INT NOT NULL
);

-- Tabla restaurante
CREATE TABLE restaurante (
    tipo_comida VARCHAR(50) NOT NULL,
    Mesas INT NOT NULL
);

-- Tabla centroComercial
CREATE TABLE centroComercial (
    Num_tiendas INT NOT NULL,
    Num_plantas INT NOT NULL
);

-- Tabla museo
CREATE TABLE museo (
    tema VARCHAR(50) NOT NULL,
    Num_salas INT NOT NULL
);

-- Tabla otrasActividades
CREATE TABLE otrasActividades (
    descripcion VARCHAR(255) NOT NULL,
    fecha_inicio DATE NOT NULL,
    fecha_salida DATE NOT NULL
);
