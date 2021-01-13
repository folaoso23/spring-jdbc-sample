FROM openjdk:11
ADD . /spring-jdbc-example
# RUN ls /spring-jdbc-example
RUN ./spring-jdbc-example/gradlew build
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]