

[![gradle](https://img.shields.io/badge/gradle-v8.14.4-yellow.svg)](https://gradle.org/install/)



>Developed with all ❤️ in the world by Andrew Garcia Sandoval

## Prerequisites

You will need the following things properly installed on your computer.

* [Git](http://git-scm.com/)
* [Gradle](https://gradle.org)



## Installation

We use [Gradle](http://www.gradle.org), a cross-platform build automation tool that help with our full development flow. 
If you prefer [install Gradle](http://www.gradle.org/installation) or use a [Gradle wrapper](http://www.gradle.org/docs/current/userguide/gradle_wrapper.html) inside this project.

* git clone https://github.com/andrewygarcias/QA-Automation-Technical-Test.git this repository


##  Executing the tests

the parameter **-Denvironment** can to take values like: 

   * default
   - dev
   * stg
   + pro
   
To run the test:

```bash
./gradlew clean test -Denvironment=stg aggregate
```
The test results will be recorded in the `target/site/serenity` directory.

## Simplified WebDriver configuration and other Serenity extras
The sample projects both use some Serenity features which make configuring the tests easier. In particular, Serenity uses the `serenity.conf` file in the `src/test/resources` directory to configure test execution options.  

### Environment-specific configurations
We can also configure environment-specific properties and options, so that the tests can be run in different environments. Here, we configure three environments, __dev__, _stg_ and _pro_, with different starting URLs for each:
```json
environments {
  default {
  base.url = "https://demo.applitools.com/hackathonV2.html"
  url = "https://reqres.in/api/"
}
dev {
  base.url = "https://demo.applitools.com/hackathonV2.html"
  url = "https://reqres.in/api/"
}
stg {
  base.url = "https://demo.applitools.com/hackathonV2.html"
  url = "https://reqres.in/api/"
}
pro {
  base.url = "https://demo.applitools.com/hackathonV2.html"
  url = "https://reqres.in/api/"
}
}
```
  
You use the `environment` system property to determine which environment to run against. For example to run the tests in the staging environment, you could run:
```json
gradle clean test -Denvironment=stg
```

### The project directory structure
The project has build scripts for both Maven and Gradle, and follows the standard directory structure used in most Serenity projects:
```Gherkin
## 📁 Estructura del Proyecto

```text
src
├─ main
│  ├─ java
│  │  └─ com.automation.qa
│  │     ├─ constants            | Constantes utilizadas en el proyecto
│  │     ├─ logica               | Implementación de retos de lógica
│  │     ├─ models.createuser    | Modelos / DTOs para requests y responses
│  │     ├─ question             | Questions de Screenplay para validaciones
│  │     ├─ tasks
│  │     │  ├─ api               | Tasks para pruebas de API
│  │     │  └─ e2e               | Tasks para flujos end-to-end
│  │     ├─ ui                   | Mapeo de elementos de la interfaz (Page Objects / Targets)
│  │     └─ util                 | Clases utilitarias
│  │
│  └─ resources
│     └─ schemas                 | JSON Schemas para validaciones de respuesta
│
├─ test
│  ├─ java
│  │  └─ com.automation.qa
│  │     ├─ actors               | Configuración de actores (Screenplay)
│  │     ├─ runners              | Clases runner para ejecutar los tests
│  │     ├─ stepdefinitions      | Step definitions de Cucumber
│  │     └─ TestEnvironments     | Configuración de ambientes de prueba
│  │
│  └─ resources
│     ├─ features                | Archivos .feature de Cucumber
│     │  ├─ GestionUsuario.feature
│     │  ├─ ResumenFinanciero.feature
│     │  └─ RetosLogica.feature
│     │
│     └─ serenity.conf           | Configuración de Serenity BDD
│
target
└─ site
   └─ serenity                   | Reportes generados por Serenity

Archivos de configuración
├─ build.gradle                  | Configuración de dependencias y build
├─ gradle.properties
├─ gradlew / gradlew.bat
├─ serenity.properties           | Propiedades de Serenity
└─ settings.gradle
```



## Want to learn more?
For more information about Serenity BDD, you can read the [**Serenity BDD Book**](https://serenity-bdd.github.io/theserenitybook/latest/index.html), the official online Serenity documentation source. Other sources include:
* **[Byte-sized Serenity BDD](https://www.youtube.com/channel/UCav6-dPEUiLbnu-rgpy7_bw/featured)** - tips and tricks about Serenity BDD
* [**Serenity BDD Blog**](https://johnfergusonsmart.com/category/serenity-bdd/) - regular articles about Serenity BDD
* [**The Serenity BDD Dojo**](https://serenitydojo.teachable.com) - Online training on Serenity BDD and on test automation and BDD in general. 
