The project contains a list of pre loaded Characters and their Shakespearean descriptions
The loaded characters are available in the folder `src/main/resources/someCharacters.txt`

The application by default runs on port `8080`

The Application can be run in 2 ways 

A. Using Docker
 1. Please install docker on your machine , you can use
    `https://www.docker.com/products` to get installation instructions for your platform
 2. Once docker is installed you can run the project using 
    `docker run -p 8080:8080 kshitijbahul/pokepom-service`
 3. If you need to run to on a port other than `8080`
    Change the command above to match 
     `docker run -p {PORT_YOU_WANT}:8080 kshitijbahul/pokepom-service:shared-latest`
           
B. Building the project locally
 1. To run the project locally , you will need JDK 1.8 or above
    You can use Open jdk. For more details visit `https://openjdk.java.net/install/`  
 2. Once JDK is installed you can clone the project locally 
 3. If you need to change the port on which the application will run locally 
   3.1 Navigate to `src/main/resources/`
   3.2 Uncomment and change the property `server.port` from `8080` to the port you desire   
 4. Open the directory where its cloned and run the command
    `./gradlew build`
 5. After the command is successful a jar file is generated
 6. Run the file using 
    `java -jar {PATH_TO_JAR_FILE}/pokemon-service.jar`      
 
     
The API documentation is available on 
`http://localhost:{THE_PORT_YOU_CHOOSE_TO_RUN_THE_APPLICATIOn}/swagger-ui/index.html`

PS: There is also a build.sh file available in case you want to create the docker image your self