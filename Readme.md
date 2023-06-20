How to start application with docker
0.Установить и запустить docker
1.Запустить docker-compose.yaml (Команда для старта в terminal: docker-compose up -d) (для остановки: docker-compose stop)
2.Открыть браузер URL: http://localhost:5000, для использования pgadmin4(username: artur@asiptsou.by, password: 123)
3. Работа с pgadmin4:
   Register new server (name: App)
   Host name/address: db
   Port: 5432
   Database: digitaldb
   Username: root
   Password: 123
4. Установить или использовать десктопную версию Postman для отправки запросов(File collection: digital.postman_collection.json)

Зависимости:

spring-boot-starter-data-jpa: Это стартер Spring Boot, который предоставляет зависимости для поддержки работы с базой данных с использованием Java Persistence API (JPA).

spring-boot-starter-web: Это стартер Spring Boot, который предоставляет зависимости для разработки веб-приложений, включая поддержку HTTP-сервера и веб-фреймворка.

liquibase-core: Зависимость для Liquibase, инструмента управления версиями баз данных. Она позволяет создавать и обновлять схемы баз данных с помощью удобного и мощного DSL.

postgresql: Зависимость для драйвера базы данных PostgreSQL. Она предоставляет необходимые классы и функции для взаимодействия с базой данных PostgreSQL.

lombok: Это библиотека, упрощающая разработку Java-кода путем автоматической генерации методов доступа, конструкторов, геттеров и сеттеров, а также других стандартных методов.

spring-boot-starter-test: Это стартер Spring Boot для модульного тестирования. Он предоставляет зависимости и инструменты для написания и выполнения тестовых сценариев в Spring Boot приложениях.

mapstruct: Библиотека для генерации автоматического преобразования Java-объектов между различными слоями или компонентами приложения.

hibernate-validator: Зависимость для Hibernate Validator, реализации JSR 380 - стандарта валидации объектов в Java.

Плагины:

maven-compiler-plugin: Плагин Maven для компиляции исходного кода Java. Он настраивает параметры компиляции, такие как версия языка Java, и позволяет настраивать процессоры аннотаций, в данном случае используется для MapStruct и Lombok.

spring-boot-maven-plugin: Плагин Spring Boot для сборки и запуска приложений. Он настраивает параметры сборки, такие как имя финального исполняемого файла, и позволяет исключать некоторые зависимости из финального JAR-файла, в данном случае исключается зависимость Lombok.