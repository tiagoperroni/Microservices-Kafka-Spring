FROM openjdk:11

EXPOSE 8081

WORKDIR /src

COPY /target/*.jar /src/order.jar

ENTRYPOINT [ "java", "-jar", "/src/order.jar" ]