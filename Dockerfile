FROM openjdk:17-jdk
COPY target/proyecto-de-monedero-para-banco-0.0.1-SNAPSHOT.jar app.jar
CMD ["java", "-jar", "app.jar"]