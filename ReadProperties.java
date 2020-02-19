package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {

    private Properties properties = new Properties();


    public String getConfigProperty(String propertyKey) throws IOException {
        FileInputStream inStream = new FileInputStream("src/main/resources/config.properties");
        properties.load(inStream);
        inStream.close();
        return properties.getProperty(propertyKey);
    }
}

