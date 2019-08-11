FROM openjdk:8

ADD target/query-0.0.1-SNAPSHOT.jar /usr/app/query-service.jar

WORKDIR /usr/app

EXPOSE 8085

RUN sh -c 'touch query-service.jar'

ENTRYPOINT ["java","-jar","query-service.jar"]