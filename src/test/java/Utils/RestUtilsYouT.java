package Utils;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtilsYouT {
    public static String getName(){
        String generateName= RandomStringUtils.randomAlphabetic(1);
        return("Daisy"+generateName);
    }

    public static String getStatus(){
        String generateStatus=RandomStringUtils.randomAlphabetic(1);
        return ("available"+generateStatus);
    }

    public static int getID(){
        String generateID=RandomStringUtils.randomNumeric(1);
        return Integer.parseInt((1021+generateID));
    }
}
