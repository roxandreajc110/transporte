# Transporte

## Tecnologías/Herramientas usadas

 - Desarrollo
	 - Java 8
	-  Spring Boot
	-  JPA
	-  Maven
- Persistencia
	-  H2 (BD Embebida)
- Documentación
	-  Swagger
- Versionamiento
	- Git
 - Otros
	- Postman


## Persistencia

Para el proyecto se manejo H2 que es un base de datos embebida escrita en Java; esto con fines prácticos, ya que en un contexto productivo no debe usarse este tipo de bases de datos. La idea de manejar H2 es registrar los items favoritos de los usuarios.

Algunos datos de entrada se encuentran en la ruta ***src/main/resources/import.sql***


## Ejecución de la aplicación

Este proyecto se ejecuta por el puerto 8080.

### Generación ejecutable .jar 
(**NOTA**: De igual forma se deja en la ruta ***src/main/resources*** el jar generado para únicamente ejecutar el paso 5.)

1.  Descargar el repositorio del proyecto de la rama "**main***".
2.  Mediante el IDE Eclipse, click derecho sobre el proyecto, seleccionamos la opción “***run as***” y luego “***maven build***”, en la ventana que nos arroja llamada “***Edit Configuration***” escribimos “***package -DskipTests***” en el campo de “***Goals***” y damos Click en "***Run***".
3. El punto anterior también puede realizarse mediante linea de comando ejecutando: *"**mvn package -DskipTests**" sobre el proyecto. Tener en cuenta tener instalado maven.*
4.  Después de que se terminé de construir nuestro proyecto se generará automáticamente un **.jar**. (Este .jar podremos encontrarlo en la ruta del proyecto en la carpeta ***/target***)
5. Para ejecutar el .jar, se realiza mediante el comando : 
	**java -jar transporte-0.0.1.jar****

	
### Ejecución por IDE

1.  Descargar el repositorio del proyecto de la rama "**main***"  e importarlo en el IDE.
2. Ejecutar el main de la aplicación para este caso: 		    	    **com.co.transporte.app.TransporteApplication***

## Consumo de servicios

Se comparte una colección en postman con ejemplos de consumo de los servicios principales, esto se encuentran en la ruta ***src/main/resources/Transporte.postman_collection***

## Modelo Entidad Relación

![ModeloER](https://github.com/roxandreajc110/file/blob/main/ModeloER.PNG?raw=true)

## DDL

```
/* 
 DROP TABLE persona;
 DROP TABLE vehiculo;
 DROP TABLE vehiculo_conductor;
 * */
CREATE TABLE persona (
   id_persona integer, 
   tipo_identificacion varchar(10) not null,
   identificacion varchar(20) not null,
   nombre varchar(20) not null,
   direccion varchar(20),
   telefono varchar(10),
   representante_legal_id integer,
   empresa_contratista_id integer,
   primary key (id_persona),
   foreign key (representante_legal_id) references persona(id_persona),
   foreign key (empresa_contratista_id) references persona(id_persona)
);

CREATE TABLE vehiculo (
   id_vehiculo integer, 
   persona_juridica_id integer not null,
   placa varchar(6) not null,
   motor varchar(15) not null,
   chasis varchar(15),
   modelo varchar(20) not null, 
   fecha_matricula date not null,
   pasajeros_sentados integer not null,
   pasajeros_de_pie integer not null,
   peso_seco decimal(5,2),
   peso_bruto decimal(5,2),
   cantidad_puertas integer not null,
   marca varchar(15) not null,
   linea varchar(15),
   primary key (id_vehiculo),
   foreign key (persona_juridica_id) references persona(id_persona)
);

CREATE TABLE vehiculo_conductor (
   vehiculo_id integer not null, 
   conductor_id integer not null,
   fecha_asignacion date not null,
   primary key (vehiculo_id,conductor_id ),
   foreign key (vehiculo_id) references vehiculo(id_vehiculo),
   foreign key (conductor_id) references persona(id_persona)
);
```

## DML
```
INSERT INTO PERSONA (ID_PERSONA, TIPO_IDENTIFICACION,IDENTIFICACION,NOMBRE, DIRECCION, TELEFONO , REPRESENTANTE_LEGAL_ID , EMPRESA_CONTRATISTA_ID ) VALUES
(1, 'CC', '1018345632','Dario Murillo','Cr 100 # 15', '4313878',null,null);
INSERT INTO PERSONA (ID_PERSONA, TIPO_IDENTIFICACION,IDENTIFICACION,NOMBRE, DIRECCION, TELEFONO , REPRESENTANTE_LEGAL_ID , EMPRESA_CONTRATISTA_ID ) VALUES
(2, 'NIT', '0958562545','TRANSPORTADORA SAS','Transv. 100', '254522',1,null);
INSERT INTO PERSONA (ID_PERSONA, TIPO_IDENTIFICACION,IDENTIFICACION,NOMBRE, DIRECCION, TELEFONO , REPRESENTANTE_LEGAL_ID , EMPRESA_CONTRATISTA_ID ) VALUES
(3, 'CC', '1019765456','Ana Trujillo','Cr 110 B # 72 52', '4323412',null,2);
INSERT INTO PERSONA (ID_PERSONA, TIPO_IDENTIFICACION,IDENTIFICACION,NOMBRE, DIRECCION, TELEFONO , REPRESENTANTE_LEGAL_ID , EMPRESA_CONTRATISTA_ID ) VALUES
(4, 'CC', '10453434','Juan Martinez','Cr 200 # 34', '3143456789',null,2);
INSERT INTO PERSONA (ID_PERSONA, TIPO_IDENTIFICACION,IDENTIFICACION,NOMBRE, DIRECCION, TELEFONO , REPRESENTANTE_LEGAL_ID , EMPRESA_CONTRATISTA_ID ) VALUES
(5, 'CC', '1067553444','Maria Diaz','Cr 34 A SUR', '4567897',null,null);
INSERT INTO PERSONA (ID_PERSONA, TIPO_IDENTIFICACION,IDENTIFICACION,NOMBRE, DIRECCION, TELEFONO , REPRESENTANTE_LEGAL_ID , EMPRESA_CONTRATISTA_ID ) VALUES
(6, 'NIT', '0989002545','SERVIMOS SAS','Diagonal 85 # 34 ', '4532345',5,null);
INSERT INTO PERSONA (ID_PERSONA, TIPO_IDENTIFICACION,IDENTIFICACION,NOMBRE, DIRECCION, TELEFONO , REPRESENTANTE_LEGAL_ID , EMPRESA_CONTRATISTA_ID ) VALUES
(7, 'CC', '517687896','Camilo Vasquez','Cll 100', '565656',null,2);


INSERT INTO VEHICULO (ID_VEHICULO,PERSONA_JURIDICA_ID,PLACA,MOTOR,CHASIS,MODELO,FECHA_MATRICULA,PASAJEROS_SENTADOS,PASAJEROS_DE_PIE,PESO_SECO,PESO_BRUTO,CANTIDAD_PUERTAS,MARCA,LINEA) VALUES
(1, 2, 'AAA300', 'AS233-X3','FF453','2020', '2020-07-12',25,15,150.25,145.50,2,'Volvo','Volvo');
INSERT INTO VEHICULO (ID_VEHICULO,PERSONA_JURIDICA_ID,PLACA,MOTOR,CHASIS,MODELO,FECHA_MATRICULA,PASAJEROS_SENTADOS,PASAJEROS_DE_PIE,PESO_SECO,PESO_BRUTO,CANTIDAD_PUERTAS,MARCA,LINEA) VALUES
(2, 2, 'XDF456', 'CFV-X3','FRE45','2021', '2021-12-12',30,15,280.25,265.50,2,'Mercedes Benz','Mercedes Benz');
INSERT INTO VEHICULO (ID_VEHICULO,PERSONA_JURIDICA_ID,PLACA,MOTOR,CHASIS,MODELO,FECHA_MATRICULA,PASAJEROS_SENTADOS,PASAJEROS_DE_PIE,PESO_SECO,PESO_BRUTO,CANTIDAD_PUERTAS,MARCA,LINEA) VALUES
(3, 6, 'CFG433', 'XXD-X3','MNGH','2015', '2015-02-22',20,10,180.25,165.50,2,'BYD','BYD');


INSERT INTO vehiculo_conductor (vehiculo_id,conductor_id, fecha_asignacion) VALUES
  (1, 3, '2022-01-03');
INSERT INTO vehiculo_conductor (vehiculo_id,conductor_id, fecha_asignacion) VALUES
  (1, 4, '2022-01-03');
INSERT INTO vehiculo_conductor (vehiculo_id,conductor_id, fecha_asignacion) VALUES
  (2, 4, '2022-01-03');
INSERT INTO vehiculo_conductor (vehiculo_id,conductor_id, fecha_asignacion) VALUES
  (1, 7, '2022-01-03');


SELECT v.placa AS 'Placa vehiculo', 
p.tipo_identificacion AS 'Tipo identificación empresa', 
p.identificacion AS 'Identificación empresa', 
p.nombre AS 'Nombre empresa', 
COUNT(*) AS '# Conductores asignados'
FROM vehiculo v 
INNER JOIN vehiculo_conductor vc ON vc.vehiculo_id = v.id_vehiculo
INNER JOIN persona p ON v.persona_juridica_id = p.id_persona
GROUP BY v.placa, p.tipo_identificacion, p.identificacion, p.nombre
HAVING COUNT(*) > 2
ORDER BY v.placa;
```



## Autor
Roxana A. Jaramillo Cobos<br>
[www.linkedin.com/in/roxanajc ](www.linkedin.com/in/roxanajc)
