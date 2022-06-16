# Тестовый проект для работы с организациями

## Сборка приложения
```
./mvnw clean package
```

## Что нужно сделать перед запуском приложения
1. Запустить postgres
2. В файле `src/main/resources/application-local.yml` указать параметры подключения к базе данных

## Запуск приложения
```
java -jar target/interview.jar
```

## Описание REST API приложения
При запущенном приложении, можно зайти на Swagger UI-страницу с описанием REST API приложения: 
http://localhost:8080/swagger-ui.html
