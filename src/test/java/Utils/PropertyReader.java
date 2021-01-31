package Utils;

import org.testng.annotations.Test;

import java.io.*;
import java.util.Properties;

public class PropertyReader {

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




    @Test
    public void test1() throws IOException {
        Properties properties=new Properties();

        File propertiesFile=new File("src/test/resources/credentials.properties");

        FileInputStream input=new FileInputStream(propertiesFile);
        properties.load(input);

       String username= properties.getProperty("username");
        System.out.println("Username from prop file: "+username);

        String password=properties.getProperty("password");
        System.out.println("User's password:" + password);

        String environment=properties.getProperty("environment");
        System.out.println("environment "+ environment);

        String browser=properties.getProperty("browser");
        System.out.println("Browser "+ browser);

        String name=properties.getProperty("name", "this is default value");
        System.out.println(name);

    }



}
