FROM maven AS build
COPY src /home/app/src
COPY pom.xml /home/app
WORKDIR /home/app

ARG DB_USER
ENV DB_USER ${DB_USER}
ARG DB_PASSWORD
ENV DB_PASSWORD ${DB_PASSWORD}
ARG DB_URL
ENV DB_URL ${DB_URL}

RUN mvn clean install -DskipTests=true

CMD mvn spring-boot:run
