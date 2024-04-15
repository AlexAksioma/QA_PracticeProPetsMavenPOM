package helpers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
    private static final String PROPERTIES_PATH = "src/main/resources/properties.properties";

    /**
     *
     * @param key from file .properties
     * @return value from file .properties
     */
    public static String getProperty(String key){
        Properties properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream(PROPERTIES_PATH);
            properties.load(fileInputStream);
            return properties.getProperty(key);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);

        }
    }
}
