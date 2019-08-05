FROM openjdk:8

ADD target/checkout-0.0.1-SNAPSHOT.jar /usr/app/checkout-service.jar

WORKDIR /usr/app

EXPOSE 8083

RUN sh -c 'touch checkout-service.jar'

ENTRYPOINT ["java","-jar","checkout-service.jar"]