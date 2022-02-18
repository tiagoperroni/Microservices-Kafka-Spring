FROM openjdk:11

EXPOSE 8080

WORKDIR /src

COPY /target/*.jar /src/client.jar

ENTRYPOINT [ "java", "-jar", "/src/client.jar" ]