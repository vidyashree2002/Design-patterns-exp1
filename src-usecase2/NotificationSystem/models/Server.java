
public class Server {
   private final String message  = "The app is available for update"; //message that the user should receive initi
// it undergoes encapsulation
    public String getMessage() {   //this method gives access for other files to use. public, so it can be called outside the class as well.
        return message;           
    }

}