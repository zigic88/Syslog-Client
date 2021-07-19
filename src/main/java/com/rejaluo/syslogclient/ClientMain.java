/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rejaluo.syslogclient;

import java.io.IOException;
import org.productivity.java.syslog4j.Syslog;
import org.productivity.java.syslog4j.SyslogIF;

/**
 *
 * @author reja
 */
public class ClientMain {

    public static void main(String[] args) throws IOException {
        ResourceValues resourceValues = new ResourceValues();
        resourceValues.getPropValues();
        
        // TODO Auto-generated method stub
        // Set a Specific Host, then Log to It
        SyslogIF syslog = Syslog.getInstance("udp");
        syslog.getConfig().setHost("localhost");
        syslog.getConfig().setPort(resourceValues.appPort);
        while (true) {
            syslog.info("Today is a good day! - " + resourceValues.appTag);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}
