FROM  circleci/jdk8:0.1.1
COPY target/simple-backend-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
CMD ["java","-jar","simple-backend-0.0.1-SNAPSHOT.jar"]