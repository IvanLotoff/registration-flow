FROM maven AS build
COPY src /home/app/src
COPY pom.xml /home/app
WORKDIR /home/app

RUN mvn clean install -DskipTests=true

CMD mvn spring-boot:run
