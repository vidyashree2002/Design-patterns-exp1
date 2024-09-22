package src_usecase2.notificationsystem.services;


public class ThirdPartyService {
    public void sendUser(String email , String message){
        System.out.println("Sending notification to:" + email + "message :" + message);
    }
}