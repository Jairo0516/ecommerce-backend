# This repo is ecommerce dev

Uario de autenticación: cualquier correo
Contraseña: ECOMMERCE2024



[![Build Status](https://travis-ci.org/codecentric/springboot-sample-app.svg?branch=master)](https://travis-ci.org/codecentric/springboot-sample-app)
[![Coverage Status](https://coveralls.io/repos/github/codecentric/springboot-sample-app/badge.svg?branch=master)](https://coveralls.io/github/codecentric/springboot-sample-app?branch=master)
[![License](http://img.shields.io/:license-apache-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)

La Base de datos conectada esta publicada en un RDS, esta estara activa, para sus respectivas validaciones.

Solo hay que correr el proyecto, recomendaciones:
  -  Version de java requerida   <java.version>17</java.version>


## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `de.codecentric.springbootsample.Application` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

## Deploying the application to OpenShift

The easiest way to deploy the sample application to OpenShift is to use the [OpenShift CLI](https://docs.openshift.org/latest/cli_reference/index.html):

```shell
oc new-app codecentric/springboot-maven3-centos~https://github.com/codecentric/springboot-sample-app
```

This will create:

* An ImageStream called "springboot-maven3-centos"
* An ImageStream called "springboot-sample-app"
* A BuildConfig called "springboot-sample-app"
* DeploymentConfig called "springboot-sample-app"
* Service called "springboot-sample-app"

If you want to access the app from outside your OpenShift installation, you have to expose the springboot-sample-app service:

```shell
oc expose springboot-sample-app --hostname=www.example.com
```

## Copyright

Released under the Apache License 2.0. See the [LICENSE](https://github.com/codecentric/springboot-sample-app/blob/master/LICENSE) file.
