package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesRunner {
    public static String readPropertyByKey(String key) {

        Properties properties=new Properties();

        File propFile=new File("src/test/resources/credentials.properties");
        try
        {
            FileInputStream inputStream=new FileInputStream(propFile);
            properties.load(inputStream);
        }catch(IOException ex){
            throw new RuntimeException("credentials.properties file was not found", ex);
        }
        String value=properties.getProperty(key);
        return value;

    }




}




