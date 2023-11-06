FROM openjdk:11-jre-slim
EXPOSE 8082
<<<<<<< HEAD
ADD target/5nids2-g9-projet1-1.0.jar 5nids2-g9-projet1-1.0.jar
ENTRYPOINT ["java","-jar","/5nids2-g9-projet1-1.0.jar"]
=======
ADD target/5nids2-g9-projet1-1.0.jar -5nids2-g9-projet1-1.0.jar
ENTRYPOINT ["java","-jar","/5nids2-G9-projet1-1.0.jar"]
>>>>>>> 32842a92e00ea6e954a1d8269a23f9312b158bb1
