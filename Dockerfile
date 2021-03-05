FROM adoptopenjdk/openjdk11:latest
ADD build/libs/*.jar genderdetector.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","genderdetector.jar"]