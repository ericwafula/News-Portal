# News Portal
#### A rest REST API for querying and retrieving scoped news and information.
#### By **Eric Wafula**
## Description
A rest REST API for querying and retrieving scoped news and information.
## Setup/Installation Requirements
* git clone https://github.com/ericwafula/News-Portal.git
* cd your/path/to/News-Portal
* open with Intellij or editor of choice eg. Eclipse
* Launch Postgres via terminal with the command: psql

##### DATABASE SETUP
* CREATE TABLE users (id serial PRIMARY KEY, position text, role text, department text);
* CREATE TABLE departments (id serial PRIMARY KEY, name text, description text, employee_count int);
* CREATE TABLE news (id serial PRIMARY KEY, general text, department text);
* CREATE TABLE departments_users (id serial PRIMARY KEY, deptid int, userid int);
* CREATE TABLE departments_news (id serial PRIMARY KEY, deptid int, userid int, newsid int);

##### TEST DATABASE SETUP
* CREATE DATABASE news_portal_test WITH TEMPLATE news_portal;

Make sure you have gradle, spark, PostgreSQL, GSON and Postman installed.
## Known Bugs
There are no known bugs at the moment
## Technologies Used
Java, Spark, Postman, PostgreSQL, GSON
## Support and contact details
ericwathome007@gmail.com
### License
*[MIT](license.txt)*
Copyright (c) 2021 **Eric Wafula**