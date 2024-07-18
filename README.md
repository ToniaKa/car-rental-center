
<h1>job4j_cars</h1>

Проект представляет собой простой сервис аренды автомобилей. 

Основной стек технологий:
- Spring boot 3.2.7
- PostgreSQL 
- Hibernate 
- Liquibase 3.6.2

Необходимая среда:
- Java 17
- Maven 3.8
- PostgreSQL 14

Для запуска проекта необходимо:

1. Создать БД данных car_rental_service
```ql
    create database car_rental_service;
```

2. Соберите проект и запустите приложение Spring Boot
```
    mvn clean install
    mvn spring-boot:run
```
