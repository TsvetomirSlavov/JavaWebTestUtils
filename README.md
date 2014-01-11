JavaWebTestUtils
================

Proyecto con utlidades que simplifican la vida al desarrollador al momento de realizar pruebas con java a aplicaciones web con selenium y jbehave.
Viene con un proyecto de ejemplo que sirve además para probar el proyecto
Usa Grizzly httpServer para probar la aplicación sin tener que desplegarla en un servidor de aplicaciones
Tiene unas pruebas unitarias de los servicios rest usando jax-ws

Requerido
----------------
* PhantomJS Driver descargado y configurado en el path http://phantomjs.org/download.html

Estrucutra del proyecto
===========================
JavaWebTestUtilsProject: Proyecto contendor de los otros
JavaWebTestUtils: Proyecto de la librería que contiene las configuraciones de jbehave
Calculadora: Proyecto de ejemplo que contiene la lógica de negocio
CalculadoraApp: Proyecto de ejemplo que contiene la aplicación web

Para correrlo
-------------------
En el proyecto JavaWebTestUtisProject  ejecutar gradle build

Para importarlo en eclipse
-----------------------------
Se requiere el plugin para gradle de eclipse (help -> Eclipse Market Place -> Buscar gradle)
Importarlo como proyecto gradle haciendo path del proyecto sea JavaWebTestUtisProject.

Para usarlo en un proyecto
=============================
1. Se debe referenciar el Proyecto JavaWebTestUtils, bien sea el proyecto o el jar ya generado (recomendado el jar)
2. Se debe crear una clase que herede de PhantomJSConfig (Ver TestsConfig del proyecto CalculadoraAPP)
3. Se crean las historias en src/main/resources,  los archivos deben terminar en .story (Ver authenticarion.story)
4. Se crearn las páginas 
5. Se deben crear los pasos (Ver el paquete steps del proyecto Calculadora)
6. Se agregan los pasos candidatos creados en el paso anterior.