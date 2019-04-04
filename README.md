# list-manager
WebApp used to control items on a list.
It is run on Tomcat, default address: localhost:8060

SpringBoot is used to jumpstart app and eliminate boilerplate. Check application.properties for server configuration.

Item is a JPA entity stored in database.
It holds ListIndex attribute used to control its position on the frontend.

Under localhost:8060 You can access GUI which displays list of items stored in database and control their position (listIndex).

Communication with server is done with REST protocol.

Database CRUD operations are managed by Hibernate.

Use DataInit to initialize items in the database.
