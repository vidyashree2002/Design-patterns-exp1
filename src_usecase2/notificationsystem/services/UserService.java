package src_usecase2.notificationsystem.services;


public class UserService {
    private final CacheService cacheservice;
    
    public UserService(CacheService cacheservice){
        this.cacheservice = cacheservice;
    }

    public String getUserEmail(String email) throws RuntimeException{
        String userEmail = cacheservice.getUserFromCache(email);
        if(userEmail == null){
            throw new RuntimeException("User not found in Cache");
        }
        return userEmail;

    }

    public boolean isValidEmail(String email){
        return email.contains("@")&& email.contains("." )&& email.contains(".com");
    }


    







}