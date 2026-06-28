# orm-learn — Spring Data JPA Quick Start

A beginner-friendly Spring Boot project that reads data from a MySQL database
using Spring Data JPA and Hibernate.

---

## What this project does

1. Connects to a MySQL database called `ormlearn`
2. Reads all rows from a `country` table
3. Prints them in the console log using SLF4J

---

## Pre-requisites

| Tool | Version |
|------|---------|
| Java JDK | 11 or higher |
| Maven | 3.6+ |
| MySQL Server | 8.0 |
| VS Code | Latest |

VS Code extensions needed:
- **Extension Pack for Java** (Microsoft)
- **Spring Boot Extension Pack** (VMware)

---

## Step 1 — Set up the MySQL database

Open MySQL Workbench (or the MySQL command line) and run the file **setup.sql**
that is included in this project:

```
mysql -u root -p < setup.sql
```

Or open `setup.sql` in MySQL Workbench and press the lightning bolt (Execute) button.

This creates the `ormlearn` schema, the `country` table, and inserts 4 rows.

---

## Step 2 — Update the database password

Open `src/main/resources/application.properties` and change the password line
to match your MySQL root password:

```
spring.datasource.password=YOUR_PASSWORD_HERE
```

---

## Step 3 — Run the application

**Option A — VS Code**

1. Open the project folder in VS Code (`File > Open Folder`)
2. Wait for Java to load (bottom status bar shows "Java" icon)
3. Open `OrmLearnApplication.java`
4. Click the **Run** button that appears above the `main()` method

**Option B — Terminal / Command line**

```bash
cd orm-learn
mvn spring-boot:run
```

---

## What to look for in the logs

When the app runs successfully you will see lines like:

```
Hibernate: select country0_.co_code as co_code1_0_, country0_.co_name as co_name2_0_ from country country0_
...
DEBUG  c.c.o.OrmLearnApplication  testGetAllCountries  countries=[Country [code=AU, name=Australia], ...]
```

---

## Project structure explained

```
orm-learn/
│
├── pom.xml                          ← Maven config; lists all dependencies
│
├── setup.sql                        ← Run this in MySQL first!
│
└── src/
    ├── main/
    │   ├── java/com/cognizant/ormlearn/
    │   │   │
    │   │   ├── OrmLearnApplication.java   ← main() lives here; calls testGetAllCountries()
    │   │   │
    │   │   ├── model/
    │   │   │   └── Country.java           ← maps to the "country" DB table (@Entity)
    │   │   │
    │   │   ├── repository/
    │   │   │   └── CountryRepository.java ← interface with free findAll(), save() etc.
    │   │   │
    │   │   └── service/
    │   │       └── CountryService.java    ← business logic layer; calls the repository
    │   │
    │   └── resources/
    │       └── application.properties    ← DB URL, username, password, log levels
    │
    └── test/
        └── java/com/cognizant/ormlearn/
            └── OrmLearnApplicationTests.java  ← basic context-load test
```

---

## How the layers connect

```
main()
  └── CountryService.getAllCountries()
        └── CountryRepository.findAll()          ← Spring Data generates SQL
              └── Hibernate executes SQL on MySQL
                    └── Returns List<Country> back up the chain
```

---

## Common errors

| Error | Fix |
|-------|-----|
| `Access denied for user 'root'` | Wrong password in application.properties |
| `Unknown database 'ormlearn'` | Run setup.sql first |
| `Table 'ormlearn.country' doesn't exist` | Run setup.sql first |
| `SchemaManagementException: Schema-validation` | Column names in Country.java don't match the DB — check co_code / co_name |
