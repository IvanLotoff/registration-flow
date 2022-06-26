FROM maven AS build
COPY src /home/app/src
COPY pom.xml /home/app
WORKDIR /home/app

RUN mvn clean install

CMD mvn spring-boot:run
