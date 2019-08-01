FROM openjdk:8

ADD target/communication-0.0.1-SNAPSHOT.jar /usr/app/communication-service.jar

WORKDIR /usr/app

EXPOSE 8081

RUN sh -c 'touch communication-service.jar'

ENTRYPOINT ["java","-jar","communication-service.jar"]