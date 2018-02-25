#Backend developer test
###Appliance Control

The task is to design and implement a backend service to control an appliance such as a wash machine or an oven. The API should be REST
based and the state of the appliance should be persisted to any form of persistent storage. There is no need for any frontend but we expect there
to be a README.md file with build directions and examples of how to invoke the REST API (e.g. curl).

The project should be implemented using Java or Node.js. Feel free to use any 3rd party library that you are comfortable with. Unit tests are
expected and the assignment will be assessed based on good programming practices and design.

Please use GitHub or Bitbucket to publish your source code.


###Installation and Run

`$ mvn spring-boot:run`


###REST API description and test

`http://localhost:8080/swagger-ui.html#/`


`GET /api/program/(index)` - Set up appliance program: choose one and set by index

`GET /api/programs` - View all appliance programs: shows all programs descriptions

`GET /api/start` - Start appliance: execute chosen program

`GET /api/state` - View appliance state: show current state with timer to program end

`GET /api/stop` - Stop appliance: interrupt program execution



###NB

App creates database file at user home folder

`~/washing-machine-db`
