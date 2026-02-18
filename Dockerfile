FROM eclipse-temurin:25
LABEL authors="dannymvp"
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} producer.jar
ENTRYPOINT ["java","-jar","/producer.jar"]
