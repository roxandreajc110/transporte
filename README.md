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
## DDL


## Autor
Roxana A. Jaramillo Cobos<br>
[www.linkedin.com/in/roxanajc ](www.linkedin.com/in/roxanajc)
