---
layout: task
title: "Todo List API Project"
nav_order: 32
next_page: 032-basics-of-html-css-js-and-bootstrap
previous_page: 030-simple-javalin-project
---
### Create a new maven-based project, and using javalin, flyway, guice, and jdbi, create a database-backed API backend that sends/receives JSON with the following endpoints: 
- ### **```get /todo --> return all todos```**
- ### **```post /todo --> add a new todo```**
- ### **```put /todo/{todo-id} --> update the content and status of a todo```**
- ### **```delete /todo/{todo-id} --> delete a todo```**

### A TODO is an entity that has the following fields:
- ### **```title (String)```**
- ### **```description (String)```**
- ### **```done (boolean)```**
- ### **```createdOn (ZonedDateTime)```**
- ### **```updatedOn (ZonedDateTime) (On updating a TODO, the updatedOn field must be updated)```** 
- ### **```id (String) (of UUID)```** 
- ### **```ISBN (String)```**