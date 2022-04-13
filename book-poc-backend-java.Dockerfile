FROM maven:3.6.3 as maven
LABEL COMPANY="Jas"
LABEL MAINTAINER="jasminvalgotar@gmail.com"
LABEL APPLICATION="book-poc-backend-java"
WORKDIR /usr/src/app
COPY . /usr/src/app
RUN mvn package 

FROM tomcat:8.5-jdk15-openjdk-oracle
WORKDIR /usr/local/tomcat/webapps/
COPY --from=maven /usr/src/app/target/book-poc-java-backend-0.0.1.war /usr/local/tomcat/webapps/api.war

EXPOSE 8080
ENTRYPOINT ["catalina.sh", "run"]

# Docker run --rm -e BOOK_DB_JDBC_DRIVER={} \
# -e BOOK_DB_HOST={} \
# -e BOOK_DB_PORT={} \
# -e BOOK_DB_SCHEMA={} \
# -e BOOK_DB_USERNAME={} \
# -e BOOK_DB_PASSWORD={} \
# book-poc-backend-java:v1.0.0

# goto
# http://localhost:8080/swagger-ui.html