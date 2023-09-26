# BonoParcial
Julia Marcela Mejia Perez 

 ## EJECUCION 
1. Clonar el repositorio usando este codigo desde el cmd, en la carpeta que gustes  
    `git clone https://github.com/juliamejia/BonoParcial.git`  

2. Dentro de la carpeta llamada BonoParcial abrimos el cmd y ejecutamos el siguiente comando  
   `mvn clean install`  
   Se crean las dependencias indicadas en el enunciado  
   <img width="235" alt="image" src="https://github.com/juliamejia/BonoParcial/assets/98657146/9858942a-b577-4020-a2d4-c97929972733">  

3.  Dentro de la misma carpeta ejecutamos el siguiente comando:  
   `java -cp "target/classes;target/dependency/*" org.example.SparkWebServer`  
  <img width="460" alt="image" src="https://github.com/juliamejia/BonoParcial/assets/98657146/796699a1-58b0-4285-b86c-7168b446afa9">  
  <img width="374" alt="image" src="https://github.com/juliamejia/BonoParcial/assets/98657146/7c4747cd-00cb-4d9e-95d6-522fc6c36788">  

## DOCKER  
1. Usando el siguiente comando construimos la imagen  
   `docker build --tag dockersparkprimer .`  
   <img width="461" alt="image" src="https://github.com/juliamejia/BonoParcial/assets/98657146/334facc1-3100-43ac-813f-5241711df133">  

2. Usando : `docker images` comprobamos que la imagen se creó:  
   <img width="451" alt="image" src="https://github.com/juliamejia/BonoParcial/assets/98657146/99080eaf-141c-45dc-b868-d2d0d41cc6c8">  

3. Creamos las instancias de un contenedor docker  
   `docker run -d -p 34000:6000 --name firstdockercontainer dockersparkprimer`  
   `docker run -d -p 34001:6000 --name firstdockercontainer2 dockersparkprimer`  
   `docker run -d -p 34002:6000 --name firstdockercontainer3 dockersparkprimer`  

4. Nos aseguramos de que este corriendo con el comando `docker ps`:  
   <img width="458" alt="image" src="https://github.com/juliamejia/BonoParcial/assets/98657146/d5443752-9572-4688-bb32-20b5ee591121">  

5. Verificamos que esta corriendo:  
   * http://localhost:4567/magnitude/3/4  
     ![image](https://github.com/juliamejia/BonoParcial/assets/98657146/fc80cc7c-7015-443e-8f84-42985b6d7f09)  
   * http://localhost:4567/isPalindrome/radar  
     ![image](https://github.com/juliamejia/BonoParcial/assets/98657146/03af0fb1-da48-48aa-938c-e110f33b8948)  
   * http://localhost:4567/cos/0.5  
     ![image](https://github.com/juliamejia/BonoParcial/assets/98657146/4f93aef7-1568-4499-b6c5-f6434d0c07ef)  
   * http://localhost:4567/sin/0.5  
     ![image](https://github.com/juliamejia/BonoParcial/assets/98657146/43ad6dd6-cc2c-464a-930b-a17fa369a95d)  

 6. Ejecutamos el docker compose con el comando `docker-compose up -d`:  
    <img width="459" alt="image" src="https://github.com/juliamejia/BonoParcial/assets/98657146/672ad5f5-44d0-4d1e-960b-e6cb2593da40">  
    Verificamos que se crearon los servicios con el comando `docker ps`:  
    <img width="456" alt="image" src="https://github.com/juliamejia/BonoParcial/assets/98657146/803b60e3-b29a-425e-87a6-c6260b909579">  
    En  Docker Desktop dashboard:  
    <img width="449" alt="image" src="https://github.com/juliamejia/BonoParcial/assets/98657146/b722ee1b-eb42-44bb-b99a-4af3b308d210">  


    ## SUBIR LA IMAGEN A DOCKER HUB  

    1. En el motor de docker local creamos una referencia a la imagen con el nombre del repo a donde queremos subirla:  
       `docker tag dockersparkprimer juliamejia/firstsprkwebapp`  
       <img width="463" alt="image" src="https://github.com/juliamejia/BonoParcial/assets/98657146/2034404f-df2d-4275-bbcc-2dec8c82e550">  
    2. Verificamos la nueva imagen existente con `docker images`:  
       <img width="444" alt="image" src="https://github.com/juliamejia/BonoParcial/assets/98657146/91b73d70-7620-49bf-933a-ec55442ab6de">  
    3. Nos logueamos:  
       <img width="458" alt="image" src="https://github.com/juliamejia/BonoParcial/assets/98657146/f96c1f45-f7fa-4e45-9f89-854935398d6f">  
    4. Empujamos la imagen al repositorio de DockerHub con `docker push juliamejia/firstsprkwebapp:latest`  
       <img width="915" alt="image" src="https://github.com/juliamejia/BonoParcial/assets/98657146/5292cec0-6dbf-4b58-adcb-583c7f4c4cfa">  
       [Link del repositorio en DockerHub](https://hub.docker.com/r/juliamejia/firstsprkwebapp/tags)

    ## ARQUITECTURA  
    Este taller describe una arquitectura de aplicación web y contenedor que se basa en el uso de las siguientes tecnologías y componentes:
    * Micro-framework de Spark Java: Spark Java es un micro-framework web que se utiliza para desarrollar aplicaciones web pequeñas y ligeras en Java. Proporciona un         conjunto mínimo de funcionalidades para construir aplicaciones web, lo que lo hace adecuado para proyectos simples y rápidos.
    * Docker: Docker es una plataforma de contenedores que permite empaquetar una aplicación y sus dependencias en un contenedor, lo que facilita la portabilidad y la        ejecución consistente en diferentes entornos. En este caso, se utiliza Docker para crear un contenedor que contiene la aplicación web Spark Java y sus dependencias.
    * DockerHub: DockerHub es un servicio en línea que permite almacenar y distribuir imágenes de contenedores Docker. Se menciona que se creará un repositorio en DockerHub y se subirá la imagen de la aplicación web allí. Esto significa que la imagen del contenedor será accesible en línea para su posterior descarga y despliegue en otras máquinas.




  
    

       

        
       

       
       

    

    
    
    


    
    

   
   

   
   

   
 
