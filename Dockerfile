
FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY target/Dcim_Demo_Project-0.0.1-SNAPSHOT.jar Dcim_Demo_Project.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/Dcim_Demo_Project.jar"]
