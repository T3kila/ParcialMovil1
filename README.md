# Crypto API Android Application

Este proyecto es una aplicación Android que consume una API para obtener datos sobre criptomonedas. 
La aplicación utiliza la arquitectura MVVM (Model-View-ViewModel) y Dagger Hilt para la inyección de
dependencias.

## Uso de la api 
La aplicación utiliza la API de CoinGecko, una API pública que proporciona datos en tiempo real 
sobre precios, volúmenes de comercio, y otros detalles relevantes de criptomonedas. Esta API es 
ampliamente utilizada en aplicaciones financieras y proyectos de criptomonedas para obtener 
información actualizada sobre diferentes activos digitales.

## Conexión de la Aplicación a la API
La conexión entre la aplicación y la API de CoinGecko se realizó utilizando Retrofit, una biblioteca 
de Java y Android que simplifica la comunicación con servicios web RESTful. Retrofit permite hacer
solicitudes HTTP y recibir respuestas de manera fácil y eficiente.

## Requisitos Previos

Antes de empezar, asegúrate de tener lo siguiente instalado en tu sistema:

- **Android Studio** (recomendado Android Studio Jellyfish o una versión posterior)
- **JDK 11** o superior
- **Gradle 7.0+** (generalmente integrado con Android Studio)
- **Conexión a Internet** (para descargar las dependencias y las imágenes del sistema)


### Clonar el Repositorio

Clona este repositorio en tu máquina local usando el siguiente comando dentro del git bash:


- git clone https://github.com/T3kila/ParcialMovil1
- cd 'Nombre de la carpeta creada' 

### Importacion de proyecto en android estudio

- damos clic en file>new>import 
- buscamos la ruta de donde clonamos el repositorio
- una ves importado elñ proyecto procedemos a ejecutarlo
