#Conventional way of building the JAR
#FROM openjdk:12-alpine
#EXPOSE 8080
#COPY ./build/libs/admin-service-0.0.1-SNAPSHOT.jar .
#CMD ["java","-jar","admin-service-0.0.1-SNAPSHOT.jar"]
# I know this is a test but I wanted to try the layered Docker image with Jar files
# and not use google jib or speingboot's plugin to create docker image
FROM openjdk:12-alpine
EXPOSE 8080
#Setting an local variable
ARG JAR_EXPLODE_PATH=build/dependency
#Should change the least
COPY ${JAR_EXPLODE_PATH}/META-INF /app/META-INF
#Changes again should be minimal
COPY ${JAR_EXPLODE_PATH}/BOOT-INF/lib /app/lib
#Probably will change the most
COPY ${JAR_EXPLODE_PATH}/BOOT-INF/classes /app
ENTRYPOINT ["java","-cp","app:app/lib/*","com.kshitij.interviews.pokemon.PokemonApplication"]