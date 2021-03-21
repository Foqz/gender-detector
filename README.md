# Gender detector
Project to determine a gender based on user's input.

## Build project
Build project with:
```bash
gradlew build
```
It will create jar file under build/libs.

## Docker commands
Build docker image with: 
```bash
docker build -t genderdetectorimage
```
Run image with:
```bash
docker run -p 8080:8080 genderdetectorimage
```
