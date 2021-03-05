# gender detector
Project to determine a gender based on user's input.

# build project
build project with : gradlew build - it will create jar file under build/libs

# docker image commands
build docker image with : docker build -t genderdetectorimage .
run image with : docker run -p 8080:8080 genderdetectorimage
