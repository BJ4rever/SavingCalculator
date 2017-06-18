package SavingCalculator;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Bhavesh Patel on 17/06/2017.
 */
public class LoadProp extends BasePage {

    static Properties prop;

    static FileInputStream input;

    public String getProperty(String key){

        prop = new Properties();

        try {
            input = new FileInputStream("src\\test\\Resources\\config.properties");
            prop.load(input);
            input.close();
        }
        catch (IOException e){
            e.getStackTrace();
        }
        return prop.getProperty(key);
    }
}
