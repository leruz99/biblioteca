**Tencnologías a usar:**

- Java version: 1.8
- Gradle version: 6.8.3
- Spring Boot version: 2.2.1.RELEASE

**Archivos de solo lectura:** 

*Estos archivos no podrán ser modificados por usted*.

***-src/test/java/com/ceiba/biblioteca/PrestamoTests: en esta clase se encuentran las pruebas automatizadas encargadas de calificar la prueba, usted podrá ir ejecutando estas pruebas para ir verificando el avance y completitud de la solución. Pero no podrá modificar nada de esta clase.***

**Problema de negocio**

*El sistema busca automatizar el comportamiento de un bibliotecario cuando un usuario desea prestar un libro.*

*Un préstamo es representado en nuestro negocio por los siguientes atributos*.

***isbn: identificador único de un libro (campo alfanumérico de máximo 10 dígitos)
identificacionUsuario: número de la identificación del usuario (campo alfanumérico de maximo 10 digitos)
tipoUsuario: determina la relación que tiene el usuario con la biblioteca, corresponde a un campo que puede tener solo alguno de los siguientes dígitos numérico***
-usuario afilado
-usuario empleado de la biblioteca
-usuario invitado


**Objetivo**
*Crear una API tipo REST la cual permita llevar a cabo las siguientes funcionalidades*.
1.El Path debe ser /prestamo y el método HTTP tipo POST: permite crear un prestamo con las siguientes validaciones
Un usuario invitado solo puede tener un libro prestado en la biblioteca, si un usuario invitado intenta prestar más de un libro debería retornar un error HTTP 400 con el siguiente json.

***Para verificar si un usuario ya tiene un préstamo se debe usar el campo identificacionUsuario***

    {
     "mensaje" : "El usuario con identificación xxxxxx ya tiene un libro prestado por lo cual no se le puede realizar otro préstamo"
    }
