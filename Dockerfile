FROM openjdk:11.0.7-jre-slim-buster
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} receiverApp.jar
ENTRYPOINT ["java","-jar","/receiverApp.jar"]