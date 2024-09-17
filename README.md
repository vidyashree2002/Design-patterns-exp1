# Design-patterns-exp1

# Load Balancer System

## description
There is a smooth communication between client and server due to the presence of Load Blancer.
A loadbalancer accepts request from a user, when the user/client want to access data/fetch any data or fetch files, the load balancer does the job of distributing the request to available servers. The load balancer checks for which server is in its active state and which server is down. This function of the Load balancer reduces traffic of requests towards one server and also efficiently redirects the request to a different avaiable server when a particular server is down.

## function that the code performs  
Functionality of Load Balancer:
Accepts requests from clients to fetch data or files.  
Distributes these requests to available servers.
Checks server status using isServerUp().
Redirects requests to available servers if a server is down.
Returns a 505 status code if all servers are down.

## walk-through the code 
-->  models: For this problem testing we are using 4 servers and 1 client/user
    we create a public(should be accessable to other class files in the same package) interface of class Server, in this we have a common method/functions that the subclasses(server1, server2, server3, server4) should implement so we enclose it within interface. The implementation is written by the subclasses and servers are created.

    The subclasses are implementating the superclass methods hence we tag it as @override for how many ever functions that the subclass implements the superclass. Override is tagged when same function name and parameters are used in differnt classes.

--> services: 
    This folder contains the actual LoadBalancer logic where try and catch is implemented for checking among the list of servers, on which    among the models will the file be returned.

    LoadBalancer: This .java file has to import models.Server, because the loadBalancer will iterate over the list of servers(class Server) to return the file. It checks for isServerUp(), that was declared in the Interface Server. isServerUp() - ture or false.
    If isServerUp() is true, (try)then the file is immediately returned as response.
    If isServerUp() is false the error is caught with the (catch)function and next server check is continued.
    if all the servers are down - then exception is thrown with a status code 505, which indicates (server error)

    FileRequestSystem: This .java file imports LoadBalancer as now on any interaction is via laodbalancer.
    We implement a run function where (try) try fetching file with the HandleRequest function that was initialised in LoadBalanacer file.
    If error encounted - (catch) is executed.

--> Main.java
    This is where the application begins and it has all the .java files imported with the package directory.
    Instances/objects are created created with the constructors of that particular class names.
    The fileRequestSystem.run() is executed and eventually all the remaining files are executed.

--> Installation
Clone the repository.
Compile the Java files using javac.
Run the Main class using java Main.

## commands 
To create .class file of all the .java files ---- javac -d out src/filename.java;    - (-d directs to create .class file in out folder inside src folder)
To run the .class file for final execution ------ java -cp out d/../Main             -(-cp sets the classpath to the out directory where the .class files are located)




