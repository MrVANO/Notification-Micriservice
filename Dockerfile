# For Java 8, try this
FROM adoptopenjdk/maven-openjdk8

RUN mkdir -p /opt/app/src
COPY src /opt/app/src
WORKDIR /opt/app
COPY pom.xml /opt/app
RUN mvn clean package
# cp target/spring-boot-web.jar /opt/app/app.jar
WORKDIR /opt/app/target

# java -jar /opt/app/app.jar
ENTRYPOINT ["java","-jar","notification-microservice.jar"]