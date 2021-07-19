/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rejaluo.syslogclient;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

/**
 *
 * @author reja
 */
public class ResourceValues {

    String result = "";
    InputStream inputStream;

    String appTag = "";
    int appPort = 0;

    public String getPropValues() throws IOException {

        try {
            Properties prop = new Properties();
            String propFileName = "./config.properties";

            inputStream = new FileInputStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

            Date time = new Date(System.currentTimeMillis());
            
            this.appTag = prop.getProperty("app.tag");
            this.appPort = Integer.parseInt(prop.getProperty("app.port")); 
            System.out.println("tag: " + appTag);
            System.out.println("port: " + appPort);
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            inputStream.close();
        }
        return result;
    }
}
