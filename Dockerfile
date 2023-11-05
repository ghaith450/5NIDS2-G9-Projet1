FROM openjdk:11-jre-slim
EXPOSE 8082
RUN curl -o http://192.168.2.124:8081/repository/maven-releases/tn/esprit/spring/5nids2-g9-projet1/1.0/5nids2-g9-projet1-1.0.jar
ENTRYPOINT ["java","-jar","5nids2-G9-projet1-1.0.jar"]
