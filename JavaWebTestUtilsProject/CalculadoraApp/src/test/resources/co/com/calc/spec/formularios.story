Flujo ingreso a formularios de ejemplos
Los formularios fueron tomados de:
http://www.websitedatabases.com/php_form_maker/html_forms/html_form_examples.html

Narrative:
Como tester
quiero ingresar a varios formularios en HTML
y probar cada uno de los elementos
				 
Scenario:  Ingreso a la pagina de HTML form Examples
Given ingreso a la pagina principal de HTML form examples
Then deberia ver un un titulo llamado HTML Form Examples

Scenario: Ingresar a la pagina del ejemplo2 y llenar cajas de texto
Given ingreso a la pagina de ejemplo2
When se llenan los campos de texto entry1, entry2 y entry3 con los textos prueba1, prueba2 y prueba3
Then los campos de texto entry1, entry2 y entry3 deben tener los textos ingresados

Scenario: Ingresar a la pagina del ejemplo 3 y seleccionar ingredientes para la pizza
Given ingreso a la pagina de ejemplo3
When se seleccionan los checkboxes Pepperoni y Anchovies
Then las cajas de chequeo de Peperoni y Anchovies están seleccionadas

Scenario: Ingresar a la pagina del ejemplo 3 y seleccionar todos los ingredientes para la pizza
Given ingreso a la pagina de ejemplo3
When se seleccionan los checkboxes Pepperoni, Saussage y Anchovies
Then las cajas de chequeo de Peperoni, Saussage y Anchovies están seleccionadas

Scenario: Cambiar valores por defecto de un texto y checkbox
Given ingreso a la pagina de ejemplo4
When se llena el campo de texto entry1 con el valor prueba
Then el campo de texto entry1 debe mostrar el valor prueba
When se deselecciona el primer checkbox
Then el primer checkbox debe estar deseleccionado

Scenario: Concatenar un texto a un campo de texto con un valor
Given ingreso a la pagina de ejemplo4
When el campo de texto entry1 tiene el valor por defecto 'foo'
When se llena el campo de texto entry1 con el valor ' fighters'
Then el campo de texto entry1 debe mostrar el valor foo fighters

Scenario: Ingresar a la pagina del ejemplo7 y seleccionar modo de pago tarjeta de credito visa
Given ingreso a la pagina de ejemplo7
When se selecciona la opcion 'visa'
Then el valor del modo de pago es 'visa'

Scenario: Ingresar a la pagina del ejemplo9 y seleccionar la actividad 'Watch TV' con 'George', luego resetear las opciones
Given ingreso a la pagina de ejemplo9
When selecciona que actividad por texto visible 'Watch TV'
Then el campo what-to-do debe tener el valor 'Watch TV'
When clic en el boton 'Reset' por id=reset_id
Then el campo what-to-do debe tener el valor 'Read A Book'
When selecciona con quien hacer la actividad por id=3 que es 'Anna'
Then el campo who-to-do-it-with debe tener el valor 'Anna'
When clic en el boton 'Reset' por name=reset_name
Then el campo who-to-do-it-with debe tener el valor 'Alex'
