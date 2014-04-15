Flujo ingreso usuario story

Narrative:
Como fisico cuantico
Quiero ingresar a la calculadora
Para inicar a hacer calculos matematicos
					 
Scenario:  Ingreso a calculadora sin usuario
Given ingreso a la pagina principal de la calculadora
Then deberia ver un banner de bienvenida a calculadora

Scenario: Bienvenida personalizada
Given ingreso a la pagina principal de la calculadora
When ingreso el nombre jubel
Then debo ver el mensaje Bienvenido Jubel
