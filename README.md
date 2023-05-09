# job-board-parse-app

## 📔 Summary:
Web app on Java17, Gradle and Spring Boot
for parsing public free job board api -
arbeitnow, working with H2 DB.
Implemented methods: All jobs
with pagination and sorting,
most n recent jobs,
statistics for cities and amount of jobs.

## 📑 Used public API:
https://www.arbeitnow.com/api/job-board-api 

## 🔨 Used Tech stack:
- Java17
- Gradle
- Spring Boot 3.0.6
- Spring Data JPA
- H2 DB
- Hibernate
- Spring Doc
- Swagger
- Lombok
- Cron job
- REST, DTO and other patterns

# REST endpoints:
/jobs - get all vacancies
/jobs/{id} - get vacancy by id
/jobs/top-viewed - get top n (by default 10) most viewed vacancies in descending order
/jobs/recent - get top n (by default 10) recent vacancies in descending order
/jobs/city - get method to achieve list of cities with number of vacancies in each


## 🖥️ BackEnd Project SetUp:
- Clone this repo.
- Create application.properties file in src/main/resources folder
  with data as in application.properties.sample file
  and fill in your data(login, password, url, driver)
  in src/main/resources/application.properties file.
- Start app from: src/main/java/com/example/arbeitnowapiapp/ArbeitnowApiAppApplication.java file.
- Open your H2 DB - http://localhost:8080/h2-console and check parsed data
    (default username: sa, password: empty field).
- Enter Swagger to check REST endpoints (see below instruction).
- Enjoy the app.

## 💻 Entering Swagger UI throw SpringDoc:
- Start app as in previous chapter.
- Enter http://localhost:8080/swagger-ui.html
  and you`ll see all the needed Swagger UI functional and REST endpoints ;)

## Swagger path
You can start Swagger UI from this url:
http://localhost:8080/swagger-ui.html

## Video Presentation
You can check how the app work in this video presentation:
https://www.loom.com/share/ff91fdcc8dca4a07b043ebaecce684a1

_____
Good luck. With :hearts: love from :ukraine: Ukraine! :smiley: