# Getting Started

1. Creacion de elementos en la base de datos.
2. Creacion de proyecto base mediante https://start.spring.io/
3. Se agrego la dependencia del driver de Oracle al pom del proyecto.
4. Se configuro el data source en el archivo application.properties
5. Creacion de entidades en el paquete sv.gob.bandesal.demo.model
6. Creacion de JpaRepository para cada una de las entidades creadas en el paso 3
7. Creacion de las clases @Service inyectando los repositorios correspondientes creados en el paso 4
8. Creacion de las paginas html y sus correspondientes @Controller. También se inyectaron las clases servicios según fue la necesitada para cada pantalla.
9. Para la pantalla de los Readers por Blogs, defini un Dto para ser populado por una Query Nativa. Con el proposito de mostrar al usuario final, los diferentes Readers por Blogs en la pantalla de mantenimiento correspondiente.
10. Inclui elementos de Bootstrap 5 y tambien se adiciono un archivo css para efectos de la pantalla login.
11. Al tener finalizadas las pantallas, active la parte de la seguridad, agregando la dependencia org.springframework.security en el archivo pom del proyecto.
12. Defini el archivo AppSecurityConfig, con el proposito de establecer un usuario de pruebas y los alcances autorización a nivel de recursos. Tambien, en esta clase definie el formulario cutom para el Login.

