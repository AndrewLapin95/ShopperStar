FROM openjdk:8

ADD target/distribution-0.0.1-SNAPSHOT.jar /usr/app/distribution-service.jar

WORKDIR /usr/app

EXPOSE 8084

RUN sh -c 'touch distribution-service.jar'

ENTRYPOINT ["java","-jar","distribution-service.jar"]