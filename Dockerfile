FROM openjdk:8-jdk-alpine
EXPOSE 8082
ADD target/DEVOPS1-1.0.jar DEVOPS1-1.0.jar 
ENTRYPOINT ["java","-jar","/DEVOPS1-1.0.jar"]