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

1.  Descargar el repositorio del proyecto de la rama "**main***".
2.  Mediante el IDE Eclipse, click derecho sobre el proyecto, seleccionamos la opción “***run as***” y luego “***maven build***”, en la ventana que nos arroja llamada “***Edit Configuration***” escribimos “***package -DskipTests***” en el campo de “***Goals***” y damos Click en "***Run***".
3. El punto anterior también puede realizarse mediante linea de comando ejecutando: *"**mvn package -DskipTests**" sobre el proyecto. Tener en cuenta tener instalado maven.*
4.  Después de que se terminé de construir nuestro proyecto se generará automáticamente un **.jar**. (Este .jar podremos encontrarlo en la ruta del proyecto en la carpeta ***/target***)
5. Para ejecutar el .jar, se realiza mediante el comando : 
	**java -jar transporte-0.0.1.jar****
	**NOTA**: De igual forma se deja en la ruta ***src/main/resources*** el jar generado para únicamente ejecutar el paso 5.
	
### Ejecución por IDE

1.  Descargar el repositorio del proyecto de la rama "**main***"  e importarlo en el IDE.
2. Ejecutar el main de la aplicación para este caso: 		    	    **com.co.transporte.app.TransporteApplication***

## Consumo de servicios

Se comparte una colección en postman con ejemplos de consumo de los servicios principales, esto se encuentran en la ruta ***src/main/resources/Transporte.postman_collection***


## Autor
Roxana A. Jaramillo Cobos<br>
[www.linkedin.com/in/roxanajc ](www.linkedin.com/in/roxanajc)
