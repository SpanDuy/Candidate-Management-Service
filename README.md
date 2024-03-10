# Candidate-Management-Service

This repository contains the source code for the Candidate Management Service. The service is built with Java and Spring Boot, and it is packaged into a Docker container for easy deployment. Follow the instructions below to build and run the service using Docker.

### Prerequisites

- Docker installed on your machine

### Build and Run

1) Clone the repository:

```bash
git clone https://github.com/your-username/Candidate-Management-Service.git
```

2) Navigate to the project directory:

```bash
cd Candidate-Management-Service
```

3) Build the Maven project and copy dependencies:

```bash
mvn clean install dependency:copy-dependencies
```

4) Create a custom Java runtime with jlink:

```bash
jlink --add-modules java.base,java.desktop,java.instrument,java.management,java.net.http,java.prefs,java.rmi,java.scripting,java.security.jgss,java.security.sasl,java.sql.rowset,jdk.compiler,jdk.jfr,jdk.unsupported --strip-debug --no-man-pages --no-header-files --compress=2 --output javaruntime
```

5) Create a build directory and navigate to it:

```bash
mkdir build-app && cd build-app
```

6) Extract the layers from the Spring Boot JAR using jarmode=layertools:

```bash
java -Djarmode=layertools -jar ../target/api-0.0.1-SNAPSHOT.jar extract
```

7) Bring up the Docker containers using docker-compose:

```bash
docker-compose up -d
```

Now, the Candidate Management Service should be up and running in a Docker container.

### Access the Service

The service is accessible at http://localhost:8080/swagger-ui/index.html. You can use tools like curl, Postman, or your web browser to interact with the API.

### Stop and Clean Up

To stop the Docker containers, use:

```bash
docker-compose down
```

This will stop and remove the containers.