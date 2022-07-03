Create a project for student management

**Student** can take multiple **Courses.**

Different **Courses** may have multiple **Students.**

Implementation is many-to-many and should include 3 tables.

Using `**@ManyToMany**` annotation is strictly **PROHIBITED.**

The project should be liquibase-driven and containing Swagger

**Base entities**

Student

id: pk

name: not null, unique

Course

id: pk 

courseName: not null, unique

? - consider entity

**API**

*/students*  **POST**, **GET**

*/students/{id}* **GET**

returns

- student data
- a list of student’s courses

*/courses/{id}* **GET**

returns

- course data
- students count
