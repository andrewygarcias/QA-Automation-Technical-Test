# language: es
@logica @tests
Característica: Retos de logica de programacion

  **Como** desarrollador
  **Quiero** validar funciones de logica
  **para** verificar su correcto funcionamiento

  Esquema del escenario: Verificar si un numero es primo
    Dado que tengo el numero <numero>
    Cuando evaluo si es primo
    Entonces el resultado debe ser <resultado>
    Ejemplos:
      | numero | resultado  |
      | 2      | Verdadero  |
      | 3      | Verdadero  |
      | 5      | Verdadero  |
      | 7      | Verdadero  |
      | 13     | Verdadero  |
      | 1      | Falso      |
      | 0      | Falso      |
      | 4      | Falso      |
      | 9      | Falso      |
      | 100    | Falso      |

  Esquema del escenario: Ordenar palabras alfabeticamente
    Dado que tengo la cadena "<entrada>"
    Cuando ordeno las palabras alfabeticamente
    Entonces el resultado debe ser "<salida>"
    Ejemplos:
      | entrada            | salida             |
      | perro gato casa    | casa gato perro    |
      | Zapato manzana bus | bus manzana Zapato |
      | uno dos tres       | dos tres uno       |

  Esquema del escenario: Verificar si una cadena es palindromo
    Dado que tengo la cadena "<cadena>"
    Cuando verifico si es palindromo
    Entonces el resultado del palindromo debe ser <resultado>
    Ejemplos:
      | cadena  | resultado  |
      | radar   | Verdadero  |
      | anilina | Verdadero  |
      | oso     | Verdadero  |
      | hola    | Falso      |
      | mundo   | Falso      |

  Esquema del escenario: Generar secuencia de Fibonacci
    Dado que quiero generar los primeros <n> numeros de fibonacci
    Cuando genero la secuencia
    Entonces la secuencia debe ser "<secuencia>"
    Ejemplos:
      | n | secuencia           |
      | 1 | [0]                 |
      | 3 | [0, 1, 1]           |
      | 5 | [0, 1, 1, 2, 3]     |
      | 7 | [0, 1, 1, 2, 3, 5, 8] |

  Esquema del escenario: Encontrar par de numeros con suma objetivo
    Dado que tengo la lista "<lista>" y el objetivo <objetivo>
    Cuando busco el par con la suma objetivo
    Entonces el par encontrado debe ser "<par>"
    Ejemplos:
      | lista           | objetivo | par    |
      | 1, 2, 3, 4, 5   | 9        | (4, 5) |
      | 1, 2, 3, 4, 5   | 3        | (1, 2) |
      | 1, 2, 3, 4, 5   | 11       | None   |
      | 25, 20, 30, 40  | 50       | (20, 30) |
