package src_usecase2.notificationsystem.services;

import java.util.HashMap;
import java.util.Map;

public class CacheService {
    Map<String, String> map = new HashMap<>();


    public CacheService() {
        map.put("vidyashree@gmail.com" , "vidyashree");
        map.put("varsha@gmail.com" , "varshadr");
        map.put("vanditha@gmail.com" , "vandhitha");
        map.put("babitha@gmail.com" , "yashaswini");
    }

    public String getUserFromCache(String email){
        return map.get(email);
    }
}