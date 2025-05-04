FROM eclipse-temurin:21-jdk-alpine
EXPOSE 8081
ADD target/demo.jar demo.jar
ENTRYPOINT ["java","-jar","/demo.jar"] 
