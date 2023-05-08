# job-board-parse-app

## 📔 Summary:
Web app on Java17, Gradle and Spring Boot
for parsing public free job board api -
arbeitnow with pagination and sorting.
Also implementing methods: All jobs,
top10 jobs, statistics for cities and amount of jobs.

## 📑 Used public API:
https://www.arbeitnow.com/api/job-board-api 

## 🔨 Used Tech stack:
- Java17
- Gradle
- Spring Boot 3.0.6
- Tomcat
- Hibernate
- PostgresQl
- Swagger
- Cron job
- REST, DTO and other patterns


## 🖥️ BackEnd Project SetUp:
- Clone this repo.
- Start your PostgreSQLServer
- Create DB from int_db.sql script in resources.
- Create application.properties file in src/main/resources folder
  with data as in application.properties.sample file
  and fill in your data(login, password, url, driver)
  in src/main/resources/application.properties file.
- Start app from: src/main/java/com/example/arbeitnowapiapp/ArbeitnowApiAppApplication.java file.
  Enjoy the app.

## 💻 Entering Swagger UI throw SpringDoc:
- Start app as in previous chapter.
- Enter http://localhost:8080/swagger-ui.html
  and you`ll see all the needed Swagger UI functional and REST endpoints ;)

## Swagger path
You can start Swagger UI from this url:
http://localhost:8080/swagger-ui.html

## Video Presentation
You can check how the app work in this video presentation:

_____
Good luck. With :hearts: love from :ukraine: Ukraine! :smiley: