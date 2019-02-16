### Instructions on how to use this API. ##

For testing, the application was run on the localhost and the Http request were send using Postman.

To run this application, issue the command from the root directory (where the pom.xml file is located): 

```
mvn sprint:boot:run
```

### About this implementation: ###
It uses the pattern CQRS with event source.
When a command that would cause a write operation to the data base is issued, a event will be stored with all necessary information about the command.

When a read only operation is requested by the user, the EventSourceDispatcher is them run to update the database with all events stored since the last
snapshot registered from the database (the last time when it had a consistent state).

OBS: The files *.sql in the root directory should be used to recriate the database models.

---- Sign Up new employee ----

URL: /signup

send:
HTTP POST

Headers:
id: {User ID}
name: {User name}
password: {User password. Might by encrypted}

If succeeds, receive:
HTTP Response with no erros
Headers:
authorization: {JWT Token signed with user password}
id: {User Name}
name: {User ID}

Otherwise, erros:
* Id already exists
* Missing fields

---- List all employees ----

URL: /employee

send:
HTTP GET

---- List all register from a specific employee ----

URL: /employee/registers

send:
HTTP Request GET
Headers:
id: {User ID}

If succeeds, receive:
HTTP Response with no erros
body: 
Multiple Json objects

Otherwise, erros:
* id not found

---- Create a new time register for a specific employee----

URL: /register/submit

send:
HTTP Request POST
Headers:
id: {User ID}
time: {yyyy-MM-dd HH:mm:ss}
X-Authorization: Bearer {JWT Token}

If succeeds, receive:
HTTP Response with no erros

otherwise, erros:
* Id not found
* Missing headers
* Invalid token