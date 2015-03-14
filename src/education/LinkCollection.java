/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package education;

import sports.*;
import CustomExceptions.TerminateException;
import Storage.Connect;
import static Storage.Connect.insertData;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import testparser.Onepage;
import testparser.Testparser;

/**
 *
 * @author yousufkhan
 */
public class LinkCollection {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<String> dataLinks = new ArrayList<String>();
        boolean flag = true;
        int i = 1;

        try {
            Connection connection = EducationConnect.CreateConntection();
            try {
                Statement stmtement = EducationConnect.CreateStatement(connection);

                while (flag) {

                    try {
                        dataLinks = Onepage.getLinks("http://www.prothom-alo.com/education", "" + i);

                    } catch (Exception e) {
                        System.out.println("terminate");
                        flag = false;
                        break;
                    }

                    for (String link : dataLinks) {
                        try {
                            EducationConnect.insertData(stmtement, link);
                            connection.commit();
                            System.out.println(link);
                        } catch (Exception e) {
                            flag = false;
                        }
                    }
                    i++;

                }

                stmtement.close();
                connection.commit();
                connection.close();
            } catch (Exception e) {
                connection.close();
            }

        } catch (Exception e) {
            System.out.println("Failed to create connection.");
        }

    }

}
