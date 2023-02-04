FROM openjdk:11
MAINTAINER gofore.com
COPY build/libs/MyGreatRestService-1.0.0.jar my-great-rest-service-1.0.0.jar
ENTRYPOINT ["java","-jar","/my-great-rest-service-1.0.0.jar"]