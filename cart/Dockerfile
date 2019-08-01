FROM openjdk:8

ADD target/car-0.0.1-SNAPSHOT.jar /usr/app/cart-service.jar

WORKDIR /usr/app

EXPOSE 8082

RUN sh -c 'touch cart-service.jar'

ENTRYPOINT ["java","-jar","cart-service.jar"]