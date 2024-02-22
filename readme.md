# ProxiExplore case-study

Couchbase is a project where I illustrated the Geospatial Query structure using spring reactive couchbase.
Microservice architecture is used, you can find the Couchbase Geospatial Query in places-service.
Medium article I wrote about Couchbase indexing See](https://medium.com/@taahagokce/couchbase-geopoint-spring-reactive-couchbase-0cc2b6e4be5d)


## Requirements

- [JDK 21](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html)
- [Maven 3.8.1](https://maven.apache.org)
- [Couchbase 7.2](https://docs.couchbase.com/server/current/release-notes/relnotes.html)

## Running the application locally

```shell
mvn spring-boot:run
```
You can find the necessary `Dockerfile` in the `docker` folder to use Couchbase via `Docker`.

## Getting started
- First of all, you need to make Couchbase working. Then, you need to add the Couchbase connection information to the relevant fields in the `places-service.yml` files under config-server. [See](https://docs.spring.io/spring-boot/docs/current/reference/html/application-properties.html#appendix.application-properties.data)

- Since it is a microservice project, `Spring Cloud Config` was used to manage the config files of the services more easily. Microservices need config files to run, so you need to run `config-server` first. [See](https://docs.spring.io/spring-cloud-config/docs/current/reference/html/)

- `Service Discovery` was used to enable microservices to communicate with each other more effectively, so `Eureka Server`, where microservices will register, is our second service that needs to be run. [See](https://spring.io/guides/gs/service-registration-and-discovery/)

- Our last step is to run `places-service` and `api-gateway-service`.

- In order to benefit from `Couchbase's` full text search feature, a `Geopoint` index must be created. [See](https://docs.couchbase.com/server/current/fts/fts-supported-queries-geopoint-spatial.html)

-  To configure `Couchbase`, you must create a specific scope and collections on Bucket and define these addresses in the `places-service.yml` file.

## Tech Stack
**Spring:** Spring framework, Spring Cloud, Spring Data, Reactive Couchbase

**Unit Test:** JUnit 5, Mockito, EasyRandom

**Database:** Couchbase

## Authors
Your feedback is very important to me, thank you for reviewing.

Nice have a work day.

- [@Tahagokce](https://github.com/Tahagokce)

