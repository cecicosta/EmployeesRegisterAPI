Instructions of how to use this API.
By Cesar Costa.

---- Cadastro de usuário ----

URL: /signup

send:
HTTP Request POST
Headers:
id: {User ID}
name: {User name}
password: {User password. Might by encrypted}

receive:
HTTP Response
Headers:
authorization: {JWT Token signed with user password}
id: {User Name}
name: {User ID}

erros:
Id already exists
Missing fields

---- Listar todos os usuários ----

URL: /employee
send:
HTTP Request GET

---- Listar todos os registros de horas de um determinado usuário ----

URL: /employee/registers
send:
HTTP Request GET
Headers:
id: {User ID}

receive:
HTTP Response
body: 
Multiple Json objects

erros:
id not found

---- Registrar horas trabalhadas ----

URL: /register/submit

send:
HTTP Request POST
Headers:
id: {User ID}
time: {yyyy-MM-dd HH:mm:ss}
X-Authorization: Bearer {JWT Token}

receive:
HTTP Response
Status: 200 Ok

erros:
Id not found
Missing headers
Invalid token
