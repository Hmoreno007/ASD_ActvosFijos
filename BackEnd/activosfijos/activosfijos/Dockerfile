FROM openjdk:11-jdk
EXPOSE 8080
ARG JAR_FILE=target/*.war
COPY ${war} activosfijos-0.0.1-SNAPSHOT.war
ENTRYPOINT [ "java", "war", "/activosfijos-0.0.1-SNAPSHOT.war" ]
