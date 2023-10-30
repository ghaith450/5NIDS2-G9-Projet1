FROM openjdk:11-jre-slim
EXPOSE 8082
ADD target/5NIDS2-G9-Projet1-1.0.jar -5NIDS2-G9-Projet1-1.0.jar
ENTRYPOINT ["java","-jar","/5NIDS2-G9-Projet1-1.0.jar"]