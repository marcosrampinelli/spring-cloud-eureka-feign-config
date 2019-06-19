# spring-cloud-eureka-feign-config
Spring Cloud project using Service Discovery (Eureka), Spring Cloud OpenFeign and Spring Cloud Config.

# Starting the projects
Just follow these instructions:

# Eureka Server

Go to command line terminal, within the **eureka-server** folder just type:

```
mvn spring-boot:run
```

It will fire up your service. To access the Eureka dashboard, browse the URL: http://localhost:8761/


# Config Server

Go to command line terminal, within the **config-server** folder just type:

```
mvn spring-boot:run
```

It will fire up your service on port 8888. Next 2 projects (**app-service-user** and **app-service-book**) are using the config server in order to read which port these apps will use. These configurations are read from a git-based repository (https://github.com/marcosrampinelli/config-git-repository).

These port configurations can be found here:

http://localhost:8888/appserviceuser/default

http://localhost:8888/appservicebook/default


# Project app-service-book

Go to command line terminal, within the **app-service-book** folder just type:

```
mvn spring-boot:run
```

It will fire up your service. A GET endpoint is exposed in order to test if everything is up and running and it can be access through this URL: http://localhost:8083/api/message

The response from the endpoint above must be "Welcome to book service!".

There is another GET endpoint exponsed which the service **app-service-user** will call:

http://localhost:8083/api/book/{bookId}

{bookId} is a String parameter that represents a fictitious id of a book. Here is an example of this call:

http://localhost:8083/api/book/1

This returns a simple JSON that has a payload containing:


```
{
    "id": "1",
    "title": "Java",
    "publisher": "Publisher name example"
}
```

The **id** returned is always the same **id** of the parameter **{bookID}**.


# Project app-service-user

Go to command line terminal, within the **app-service-user** folder just type:

```
mvn spring-boot:run
```

It will fire up your service. A GET endpoint is exposed in order to test if everything is up and running and it can be access through this URL: http://localhost:8081/api/message

The response from the endpoint above must be "Welcome to user service!".

The big trick here is to use the endpoint */api/book/{bookId}*. This endpoint will call, using OpenFeign, the endpoint exposed in **app-service-book**:

http://localhost:8081/api/book/{bookId}

{bookId} is a integer parameter that represents a fictitious id of a book. Here is an example of this call:

http://localhost:8081/api/book/1

This returns a simple JSON that has a payload containing:


```
{
    "id": "1",
    "title": "Java",
    "publisher": "Publisher name example"
}
```

The **id** returned is always the same **id** of the parameter **{bookID}**. Actually, this JSON will be sent by **app-service-book**.


# Swagger

Here are the URLs to access Swagger:

http://localhost:8081/swagger-ui.html

http://localhost:8083/swagger-ui.html
