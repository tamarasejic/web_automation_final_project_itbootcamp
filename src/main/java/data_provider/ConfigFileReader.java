package data_provider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
public class ConfigFileReader {

    private Properties properties;
    private final String propertyFilePath = "configs/Configuration.properties";


    public ConfigFileReader() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }

    public String getBaseUrl() {
        String url = properties.getProperty("baseUrl");
        if (url != null) return url;
        else throw new RuntimeException("baseUrl not specified in the Configuration.properties file.");
    }

    public String getAdminEmail() {
        String adminEmail = properties.getProperty("adminEmail");
        if (adminEmail != null) return adminEmail;
        else throw new RuntimeException("adminEmail not specified in the Configuration.properties file.");
    }

    public String getAdminPassword() {
        String adminPassword = properties.getProperty("adminPassword");
        if (adminPassword != null) return adminPassword;
        else throw new RuntimeException("adminPassword not specified in the Configuration.properties file.");
    }

}
