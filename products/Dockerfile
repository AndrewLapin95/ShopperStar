FROM openjdk:8

ADD target/product-0.0.1-SNAPSHOT.jar /usr/app/product-service.jar

WORKDIR /usr/app

EXPOSE 8084

RUN sh -c 'touch product-service.jar'

ENTRYPOINT ["java","-jar","product-service.jar"]