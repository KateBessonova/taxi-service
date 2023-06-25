package connection;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class DBProperties {
    private static final Logger LOGGER = LogManager.getLogger(DBProperties.class);
    private static final String PROPERTIES = "src/main/resources//db/propertiesUtil";

    public static Properties get() {
        Properties props = new Properties();
        try (InputStream input = new FileInputStream(PROPERTIES)) {
            props.load(input);

        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
        return props;
    }
}