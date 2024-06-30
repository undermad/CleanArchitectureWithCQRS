
### Java 21, Spring Boot 3.3, MySQL 8

# PackIt - Clean Architecture + CQRS

---

Hey, this application has been created according to the Mini Course created by DevMentors EN YouTube channel.
The idea of clean architecture and cqrs is well explained and I would like to recommend it to you. Video is 8h long and
step by step explain everything
you need to know about those topics to begin journey with clean architecture.

Link to video: [LINK](https://www.youtube.com/watch?v=NzcZcim9tp8&t=13126s)

There is key difference between this repository and the original mini
course [repo](https://github.com/devmentors/PackIT) that you should know about.
Original course has been created using C# and .NET, in here you can find Java and Spring Boot version with maven modular
separation between the layers.

There are some differences, especially in the infrastructure layer, but in overall everything is nearly the same.

## How to run it on your local machine.

### 1. You need to have Docker, Docker Compose and Git installed on your local machine.

If not yet, installed on your computer, just make your life easier and install it right now.
You can use Google to find the step-by-step instructions.

### 2. Clone this repository

Navigate to the folder of your choice on your local computer and run:

```shell
git clone https://github.com/undermad/CleanArchitectureWithCQRS
```

### 3. Move to the directory
```shell
cd CleanCQRS
```

### 4. Run docker compose
```shell
docker-compose up --build
```

### 5. Navigate to SWAGGER home page to discover available endpoints
http://localhost:8080/swagger-ui.html


