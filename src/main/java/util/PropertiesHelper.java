package util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;

public class PropertiesHelper {
    private static final String PROPERTIES_NAME = "starter-configuration.properties";

    public static ClassLoader getClassLoader() {
        return PropertiesHelper.class.getClassLoader();
    }

    public static String getProperty(String propertyName) {
        Properties properties = new Properties();

        InputStream inputStream = getClassLoader().getResourceAsStream(PROPERTIES_NAME);

        try {
            properties.load(inputStream);
            return properties.getProperty(propertyName);

        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static File getFileFromProperty(String propertyName) {
        String propertyValue = getProperty(propertyName);

        URL filePath = getClassLoader().getResource(propertyValue);

        try {
            return new File(filePath.toURI());

        } catch (URISyntaxException uriSyntaxException) {
            uriSyntaxException.printStackTrace();
            return null;
        }
    }

    public static String getFilePathFromProperty(String propertyName) {
        return getFileFromProperty(propertyName).getPath();
    }
}

