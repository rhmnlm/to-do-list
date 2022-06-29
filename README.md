<h3 align="center">To do lists server api app</h3>

  <p align="center">
    project_description
    <br />
    <a href="https://github.com/rhmnlm/to-do-lists"><strong>Explore the docs »</strong></a>
    <br />
    <br />
  </p>
</div>



<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

An example of to-do-list server application. User need to authenticate by logging
via Gmail. User can then perform CRUD on the app.

<p align="right">(<a href="#top">back to top</a>)</p>



### Built With

* [Java Spring Boot](https://spring.io/)
* [Google OAuth](https://developers.google.com/identity/protocols/oauth2)

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- GETTING STARTED -->
## Getting Started

To install the project, you should have Java and Maven installed in your environment. Any database can be used with this app.

### Prerequisites

Ensure that the Maven is using the correct Java. you can type in:
```sh
mvn -v
```
to check the version of maven and the version of Java used.
<br/>


### Installation

1. Clone the repo
   ```sh
   git clone https://github.com/rhmnlm/to-do-lists.git
   ```
2. Install maven dependencies
   ```sh
   mvn clean install
   ```
3. Change configuration in application.yml
   ```
   spring:
    security:
     oauth2:
      client:
       registration:
        google:
         clientId: YOURCLIENID
         clientSecret: YOURCLIENTSECRET
    datasource:
     url:
     schema:
     username:
     password:
   ```
4. Run the application
   ```sh
   mvn spring-boot:run
   ```
<p align="right">(<a href="#top">back to top</a>)</p>



<!-- USAGE EXAMPLES -->
## Usage
Task description:
<br/>
Task is a class which has id as the primary key. task as what is the task is being written down and Status to determine the status of the task.
<br/>
Status is an Enum with the value:-
* Active - task is active and ongoing
* Finished - task is finished
* Deleted - task is deleted. but this can be recovered if needed to.
<br/>
<br/>
<p>In the ToDOListController.java you will find all sets of APIs that you can use.</p>

1. /get-all-tasks
   <br/>
    to get all tasks including status = Deleted
2. /tasks
<br/>get all active and finished tasks
3. /task/{id}
<br/> get a spesific task by id
4. /save
<br/> create a new task. or update an existing task
5. /delete
<br/> delete a task. this will update the status to Deleted
6. /hardDelete
<br/> permanently delete the task from the database

<p align="right">(<a href="#top">back to top</a>)</p>

