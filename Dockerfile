FROM openjdk:18.0.1.1-oraclelinux7
EXPOSE 8080
ADD target/creahana-project-0.0.1-SNAPSHOT.jar creahana-project-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","creahana-project-0.0.1-SNAPSHOT.jar"]