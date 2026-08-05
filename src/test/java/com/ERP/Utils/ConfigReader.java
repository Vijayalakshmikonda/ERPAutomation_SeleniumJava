package com.ERP.Utils;

import java.io.FileInputStream;
import java.util.Properties;


public class ConfigReader {


    static Properties prop;


    static {


        try {


            FileInputStream fis =
            new FileInputStream(
            "./src/test/resources/config.properties");


            prop = new Properties();

            prop.load(fis);


        }
        catch(Exception e) {

            e.printStackTrace();

        }

    }



    public static String getProperty(String key) {

        String value = prop.getProperty(key);

        if(value == null) {
            throw new RuntimeException(
            "Missing property in config file: " + key);
        }

        return value.trim();

    }

}