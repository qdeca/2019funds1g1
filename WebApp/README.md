This project is a Dynamic Web Project created in Eclipse, with no frameworks attached to it.

It comes with 3 jsp files, and one Login servlet class.
The link between the jsp file login.jsp and the Servlet is made with this line in the jsp file : 	<form method="post" action="Login">
and this line in the Login class : @WebServlet("/Login")

This last line requires you to load a library in your project, javax.servlet-api-3.0.1.jar (or any other version), located in WebContent/WEB-INF/lib

How to run the Web application :

- Import the project in Eclipse
- Create a new Server, let us say Tomcat 9. 
    To do that, go to the server view in Eclipse (Window -> Show View -> Servers if it isn't displayed at the bottom already)
    Then right-click on the window and select new -> server. There he will ask you for Tomcat installation directory, which will have to be downloaded ( https://tomcat.apache.org/download-90.cgi )
- Right-click on the project, then select Run As -> Run on Server, and choose the created server.

Before running the project, don't forget to check if everything is propperly loaded and there are no errors first.
