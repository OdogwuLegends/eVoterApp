package africa.semicolon.IdealBvas.Utils;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class AppUtils {
    private static int currentId;
    private final static Map<String, String> userInformationJoinTable = new HashMap<>();
    public final static int ZERO = BigInteger.valueOf(0).intValue();
    public final static int FIVE = BigInteger.valueOf(5).intValue();
    public final static int EIGHT = BigInteger.valueOf(8).intValue();

    public static String generateId(){
        currentId += 1;
        
        int generatedId = currentId;
        return String.valueOf(generatedId);
    }
    public static void linkUserToInformation(String userId, String userInformationId){
       userInformationJoinTable.put(userId,userInformationId);
    }
    public static String getUserInformationId(String userId){
        String userInformationId = userInformationJoinTable.get(userId);
        return userInformationId;
    }

}
