# Use Maven to build WAR
FROM maven:3.8.8-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Use Tomcat to run WAR
FROM tomcat:9.0
COPY --from=build /app/target/CarWashBooking.war /usr/local/tomcat/webapps/CarWashBooking.war

EXPOSE 8080
CMD ["catalina.sh", "run"]
