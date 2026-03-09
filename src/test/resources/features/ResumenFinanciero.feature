# language: es
@e2e @tests
Característica: Resumen financiero

  **Como** usuario de applitools que se encuentra registrado
  **Quiero** visualizar el balance y resumen de mis transacciones
  **para** poder gestionar mi cuenta

  @ValidarResumenFinanciero
  Esquema del escenario: Validar resumen financiero
    Dado que Sandra se encuentra registrada en applitools
    Cuando ingresa la información solicitada para su login
      |<usuario>|<password>|
    Entonces Debería ver su login exitoso junto con el resumen financiero
    Ejemplos:
      |usuario  |password    |
      |testuser |testpassword|