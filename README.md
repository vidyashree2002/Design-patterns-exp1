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

## USECASE 2

## NotificationSystem

## Discription

The notification system facilitates user interaction by validating email addresses and retrieving user data from a cache. It creates notification messages and  delivers through a third-party service. The system efficiently handles errors related to invalid emails or missing user data. Overall, it streamlines the process of sending notifications to users.

## function that the code performs  
The server creates a message that should be sent to a user
UserService then checks for the presence of email in cache and validates it
If the email is validated then the message is passed on to a ThirdParty service which then handles the pipelines in which the message should be sent to the user.  
This entire logic is then encapulated within notificationservice class and continuely executes the other classes.

## walk-through the code 

--> Server : This class represents the message or notification content that will be sent to the user. Encapsulation: The message is kept private, and the class provides a getter (getMessage()) to access the message. This ensures controlled access to the message.
Constructor: The constructor initializes the Server object with a message that gets passed when creating an instance.

--> CacheService: The CacheService is used to simulate a simple cache of users, mapping their email addresses to usernames. This allows for quick retrieval of user data, mimicking what would happen in a real system using an in-memory cache.
Methods:getUserFromCache() Retrieves the username from the cache based on the provided email. If the email is not found in the cache, it returns null.
Encapsulation: The cache (a HashMap object) is encapsulated within the class and is accessed through methods, preventing direct manipulation from outside.

-->ThirdPartyService: This class simulates a third-party service responsible for sending notifications to the user.
Method:sendUser() Accepts the user's email and the notification message and prints them out to simulate the notification being sent. In a real-world system, this might involve sending an email, SMS, or push notification.

--> UserService : This class is responsible for validating the user's email and retrieving user information from the cache.
Methods:getUserEmail() Fetches the user's email from the cache using the CacheService. If the email is not found, it throws an exception.
isValidEmail(): Checks whether the provided email has a valid format (contains "@", ".", and ".com").
Dependency: This class uses CacheService for user data, demonstrating dependency injection through the constructor.

--> NotificationSystem :The core class that handles the process of sending notifications. It interacts with both UserService (to get user info) and ThirdPartyService (to send the notification).
Method: sendNotification(): This method checks if the provided email is valid using UserService. If valid, it retrieves the user's email and sends a notification via ThirdPartyService. If the email is invalid, it throws an exception.
Abstraction: The class abstracts away the details of user validation, cache retrieval, and third-party interactions, focusing on the main task of sending a notification.

--> Main: The entry point of the application. It sets up the necessary services and simulates the process of sending notifications by prompting the user to enter an email.
It initializes the core components: CacheService, UserService, ThirdPartyService, and NotificationSystem.
It prompts the user for their email input via the console.
It passes the email to the NotificationSystem, which validates the email, retrieves user info from the cache, and sends a notification if all checks pass.
If any errors (like invalid email format or missing user data) occur, the program catches and displays the relevant error message to the user.

--> Installation
Clone the repository.
Compile the Java files using javac.
Run the Main class using java Main.

## commands 
To create .class file of all the .java files ---- javac -d out src/filename.java;    - (-d directs to create .class file in "out" folder inside src folder)
To run the .class file for final execution ------ java -cp out d/../Main             -(-cp sets the classpath to the out directory where the .class files are located)

