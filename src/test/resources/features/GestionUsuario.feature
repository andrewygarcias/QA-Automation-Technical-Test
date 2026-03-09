# language: es
@api
@tests
Característica: Gestion de usuario

  **Como** consumidor de la API de reqres
  **Quiero** crear y consultar un usuario
  **Para** validar que el servicio persiste y retorna correctamente la información

  @ValidarGuardado
  Esquema del escenario: Validar guardado de usuario
    Dado que carlos es el administrador del backoffice
    Cuando ingresa la información solicitada para crear un usuario
      |<name>|<job>|
    Entonces Debería ver que el usuario se guardo con exito con los datos ingresados
    Ejemplos:
      |name  |job    |
      |Test User |Automation Engineer|

  @ValidarConsultaUsuario
  Escenario: Validar consulta de usuario por id
    Dado que carlos es el administrador del backoffice
    Cuando consulta la información de un usuario por id 2
    Entonces Debería ver la información del usuario consultado

  @ValidarActualizaUsuario
  Escenario: Validar actualizacion de usuario por id
    Dado que carlos es el administrador del backoffice
    Cuando realice la actualizacion del usuario 2 con nombre "Updated User" y trabajo "Senior Engineer"
    Entonces Debería ver la información actualizada de manera exitosa

  @ValidarEliminaUsuario
  Escenario: Validar elimina usuario por id
    Dado que carlos es el administrador del backoffice
    Cuando realice la eliminacion de un usuario por id 2
    Entonces Debería ver que la información del usuario fue borrada con exito