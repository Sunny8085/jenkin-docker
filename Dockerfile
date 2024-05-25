FROM openjdk:17
EXPOSE 8080
ADD target/spring_crud_jenkins.jar spring_crud_jenkins.jar
ENTRYPOINT [ "java","-jar","/spring_crud_jenkins.jar"]
