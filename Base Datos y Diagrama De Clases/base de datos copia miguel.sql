


/*APP TURISMO*/

/*CREATE TABLES*/


create table usuario (
	id int primary key not null auto_increment,
	nombre varchar(60),
    email varchar(60),
    contrasenia varchar(30),
    isBusiness boolean
);

create table  destino(
	nombre varchar(50) primary key not null,
    imagen varchar(200),
    descripcion varchar(400),
    url varchar(150)
);

/*No se llego a implementar por falta de tiempo*/
create table tour(
	id int primary key not null auto_increment,
    descripcion varchar(300),
    precio int not null,
    idioma varchar(30), 
    horario_salida varchar(20),
    duracion int,
    punto_salida varchar(200),
    /*Idea agregar contacto como tabla independiente*/
    contacto varchar(20),
    url varchar(150),
    ciudad varchar(50) references destino.nombre
);

create table restaurante(
	id int primary key not null auto_increment,
    nombre varchar(50),
    descripcion varchar(300),
    horario varchar(30),
    direccion varchar(200),
    rango_precio int, /*Rango de precios, 1= barato y 3= caro*/
    url varchar(150),
    ciudad varchar(50) references destino.nombre
);

create table museo(
	id int primary key not null auto_increment,
    nombre varchar(50),
    descripcion varchar(300),
    precio int,
    horario varchar(30),
	direccion varchar(200),
    url varchar(150),
    tipo varchar(30),
    ciudad varchar(50) references destino.nombre
);

create table centro_comercial(
	id int primary key not null auto_increment,
    nombre varchar(200),
    descripcion varchar(300),
    horario varchar(30),
	direccion varchar(200),
    url varchar(150),
    num_tiendas int, 
    num_pisos int,
    ciudad varchar(50) references destino.nombre
);

create table evento(
	id int primary key not null auto_increment,
    nombre varchar(200),
    descripcion varchar(300),
    fecha date,
    precio int,
    hora varchar(30),
	direccion varchar(200),
    url varchar(150),
    artista varchar(100),
    ciudad varchar(50) references destino.nombre
);

create table otras(


	id int primary key not null auto_increment,
    nombre varchar(100),/*Nombre auxuliar*/
    descripcion varchar(300),
	horario varchar(30),
    precio int,
	direccion varchar(200),
    url varchar(150),
    ciudad varchar(50) references destino.nombre
);

/*No se llego a implementar por falta de tiempo*/
create table hotel(
	id int primary key not null auto_increment,
    descripcion varchar(300),
    direccion varchar(200),
    horario varchar(30),
    rango_precio int, /*Rango de precios, 1= barato y 3= caro*/
    num_habitaciones int,
    url varchar(150),
	ciudad varchar(50) references destino.nombre
);


/*INSERTS*/


/*Insertando los 3 Destino Correspondientes*/
insert into destino values ('Malaga', 'Malaga.jpg', 'Málaga es una ciudad y municipio español, capital de la provincia homónima, situada en la comunidad autónoma de Andalucía.Además, es la zona urbana más densamente poblada de la conurbación formada por el conjunto de localidades que se sitúan a lo largo de 160 km de la Costa del Sol.','visita.malaga.eu');
 
insert into destino values ('Cadiz', 'Cadiz.jpg', 'Cádiz es una ciudad y municipio español, capital de la provincia homónima, en la comunidad autónoma de Andalucía. Con 114 244 habitantes (INE 2021),6​ es la ciudad más poblada de la bahía de Cádiz y la tercera de la provincia tras Jerez de la Frontera y Algeciras.','turismo.cadiz.es');
 
insert into destino values ('Madrid', 'Madrid.jpg', 'Madrid es un municipio y una ciudad de España. La localidad, con categoría histórica de villa,es la capital del Estado y de la Comunidad de Madrid. En su término municipal, el más poblado de España, están empadronadas 3 280 782 personas en ella.','turismo.madrid.es');
 
/*Insertando los  5 museos en  cada uno de los destinos correspondiente:Malaga(5),Madrid(5),Cadiz(5)*/
insert into museo(nombre, descripcion, precio, horario, direccion, url, tipo, ciudad) values ("Yacimiento Arqueológico Gadir", "Atractiva presentación de un yacimiento arqueológico que muestra al visitante cómo era una de las calles de Cádiz en la época fenicia.", 19, "10:00-21:00", " Se encuentra en el C/ San Miguel, 15, 11001 Cádiz España", "turismo.cadiz.es", "HISTORIA", "Cadiz");
insert into museo(nombre, descripcion, precio, horario, direccion, url, tipo, ciudad) values ("Museo de Cádiz", "Sus sarcófagos fenicios son únicos y la colección de zurbaranes excepcional. Aunque la entrada es gratuita, había más...", 0, "10:00-21:00", " Se encuentra en Plaza Mina s/n, 11004 Cádiz España.", "www.museosdeandalucia.es", "HISTORIA", "Cadiz");
insert into museo(nombre, descripcion, precio, horario, direccion, url, tipo, ciudad) values ("MUSEO DEL TÍTERE - (Museum of the puppet)", "Una exposición diferente y curiosa a la que vale la pena acercarse. Se pueden ver auténticos tesoros provenientes de los cinco continentes, marionetas muy curiosas de países africanos, islas de la polinesia.Es un museo pequeño que se recorre en menos de una hora, parándose a leer incluso todos los carteles.", 15, "10:00-18:00", "Ubicado en la Bóvedas de Santa Elena Puerta de Tierra, 11006 Cádiz España.", "www.turismo.cadiz.es", "OTROS", "Cadiz");
insert into museo(nombre, descripcion, precio, horario, direccion, url, tipo, ciudad) values ("Cortes de Cadiz","Este museo anexo al lugar donde se aprobó la Constitución de 1812 frente a la invasión napoleónica tiene un significado histórico y mítico.", 0, "10:00-19:00", " Situado en el Calle Santa Ines 9, 11003 Cádiz España.", "turismo.cadiz.es", "HISTORIA", "Cadiz");
insert into museo(nombre, descripcion, precio, horario, direccion, url, tipo, ciudad) values ("Omorfía Art Gallery", "Es una galería heterogénea donde conviven en armonía el arte contemporáneo y tradicional. ", 12, "10:00 a 14:00", "Se encuentra en Calle San Pedro 12, Local, 11004 Cádiz España, 13.","www.omorfia.es", "ARTE", "Cadiz");

/*Insertando los  5 centros comerciales en  cada uno de los destinos correspondiente:Malaga(5),Madrid(5),Cadiz(5)*/

insert into centro_comercial (nombre, descripcion, horario, direccion, url, num_tiendas, num_pisos, ciudad) values ("Bahia Sur", "Cuenta con una amplia variedad de tiendas, restaurantes, cines y actividades de ocio para toda la familia", "10:00-22:00", "Está hubicado en parte de la antigua Estación del Norte.", "ccbahiasur.com", 160, 2, "Cadiz");
insert into centro_comercial (nombre, descripcion, horario, direccion, url, num_tiendas, num_pisos, ciudad) values ("Las Dunas"," Es un parque comercial que cuenta con una amplia variedad de tiendas, restaurantes y opciones de entretenimiento, lo que lo convierte en un lugar popular tanto para los residentes locales como para los turistas.", "10:00-22:00", "se encuentra en una ubicación privilegiada, cerca de la bahía de Cádiz.", "parquecomercial-lasdunas.com", 180, 3, "Cadiz");
insert into centro_comercial (nombre, descripcion, horario, direccion, url, num_tiendas, num_pisos, ciudad) values (" Gran Sur", "Cuenta con una gran variedad de tiendas que incluyen moda, accesorios, electrónica, hogar, belleza y mucho más. ", "10:00-22:00", "Se encuentra ubicado en  Carretera del Puerto s/n, 11540 Sanlúcar de Barrameda España", "www.centrocomercialgransur.es", 125, 2, "Cadiz");
insert into centro_comercial (nombre, descripcion, horario, direccion, url, num_tiendas, num_pisos, ciudad) values ("Bahia Mar", "El centro comercial cuenta con más de 120 tiendas, que incluyen marcas internacionales y nacionales, ofreciendo una amplia selección de moda, electrónica, hogar, belleza... ", "10:00-22:00", "Se encuentra en  la Calle Pg Industrial Guadalete, 17, 11500 El Puerto de Santa Maria,cadíz.", "centroscomerciales.cc", 120, 2, "Cadiz");
insert into centro_comercial (nombre, descripcion, horario, direccion, url, num_tiendas, num_pisos, ciudad) values ("Tres Caminos", "Es un parque comercial completo que ofrece una amplia gama de tiendas, opciones gastronómicas al aire libre.", "09:00-22:00", "Se encuentra en  Calle del Calamar, 23, 11100 Puerto Real, Cádiz.", "centroscomerciales.cc", 48, 1, "Cadiz");

/*Insertando los  5 eventos en  cada uno de los destinos correspondiente:Malaga(5),Madrid(5),Cadiz(5)*/

insert into evento (nombre, descripcion, fecha, precio, hora, direccion, url, artista, ciudad) values ("Toledo y Segovia con tour opcional a Ávila", "Embárcate en una excursión de un día completo a Toledo y Segovia desde Madrid, con tickets para visitar el famoso Alcázar de Segovia. Aprovecha la oportunidad de ampliar tu viaje con una visita guiada a la ciudad de Ávila.", "2023/04/19", 51, "08:00-08:00", "Lugar de recogida:Madrid","www.getyourguide.es"," Guia Turistico", "Madrid");
insert into evento (nombre, descripcion, fecha, precio, hora, direccion, url, artista, ciudad) values ("Musical Rey Leon", "Es un exitoso musical basado en la película animada de Disney del mismo nombre. Combina música, baile, actuación y una impresionante puesta en escena para contar la historia de Simba, un joven león destinado a convertirse en rey de la Sabana africana.", "2023/08/07", 27, "3H", "DIRECCIÓN Teatro Lope de Vega, situado en Gran Vía, 57. TRÁFICO Zona de mucho tráfico. ","www.stage.es"," Rey Leon", "Madrid");
insert into evento (nombre, descripcion, fecha, precio, hora, direccion, url, artista, ciudad) values ("Juan Davila", "No te pierdas la temporada 2023 de Juan Dávila. Los mejores monólogos y espectáculos de humor en toda España. Disfruta siempre al mejor precio.", "2023/12/10", 22, "18:30-21:10", " Se encuentra en Palacio Vistalegre","juandavila.es","Juan Davila", "Madrid");
insert into evento (nombre, descripcion, fecha, precio, hora, direccion, url, artista, ciudad) values ("Espectaculo luminico spark", "Un espectáculo lumínico sin precedentes. A través de una combinación de diseño y tecnología, miles de burbujas de luz hechas con materiales biodegradables flotan en silencio, movidas por el viento, siempre cambiante.", "2023/07/06", 0, "22:00", " Se encuentra en Auditorio Cortijo de Torres","www.navidadmadrid.com"," Luces Spark", "Madrid");
insert into evento (nombre, descripcion, fecha, precio, hora, direccion, url, artista, ciudad) values ("Espectáculo de flamenco  ", "Siente la pasión de la música y la danza flamenca en un tablao legendario de Madrid. Admira un espectáculo único en un local que se inspira en las torres Bermejas de la Alhambra. Escoge entre una variedad de opciones culinarias para mejorar tu noche.", "2023/05/12", 25, "19:00-21:00", "C/MESONERO ROMANOS, Madrid","flamencotorresbermejas.com","Cantaores Flamencos", "Madrid");


/*Insertando los  5  restaurantes en  cada uno de los destinos correspondiente:Malaga(5),Madrid(5),Cadiz(5)*/
insert into restaurante(nombre,descripcion, horario, direccion, rango_precio, url, ciudad) values ('QUIMBAYA by Edwin Rodríguez','Una estrella MICHELIN: una cocina de gran delicadeza. ¡Compensa pararse!', '13:30- 16:30/20:30 - 23:30', 'Calle de Zurbano, 63, 28010 Madrid', 3, 'quimbayarestaurant.com ','Madrid');
insert into restaurante(nombre,descripcion, horario, direccion, rango_precio, url, ciudad) values ('El Invernadero de Rodrigo de la Calle','Estrella verde MICHELIN: Gastronomía y sostenibilidad', '13:30- 16:30/20:30 - 23:30', 'C. de Ponzano, 85, 28003 Madrid', 3, 'rodrigodelacalle.es', 'Madrid');
insert into restaurante(nombre,descripcion, horario, direccion, rango_precio, url, ciudad) values ('WELKHOMEclub','De Fusión', '13:00 - 02:00', 'Calle del Monte Esquinza, 15, 28010 Madrid', 1, 'welkhomeclub.com', 'Madrid');
insert into restaurante(nombre,descripcion, horario, direccion, rango_precio, url, ciudad) values ('Ganges',' Restaurante Indio', '13:00-17:00/20:30-23:00', 'Calle Bolivia, 11, 28016, Madrid, España ', 2, 'restauranteindioganges.com', 'Madrid');
insert into restaurante(nombre,descripcion, horario, direccion, rango_precio, url, ciudad) values ('BiBo Madrid by Dani García','Restaurante Andaluz ','12:00-17:00/20:00-23:00', 'P.º de la Castellana, 52, 28046 Madrid', 3, 'grupodanigarcia.com', 'Madrid');













