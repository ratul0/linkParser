/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entertainment;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import sports.SportsConnect;
import testparser.Onepage;

/**
 *
 * @author yousufkhan
 */
public class EntertainmentLinkCollection {
    public static void main(String[] args) {
        ArrayList<String> dataLinks = new ArrayList<String>();
        boolean flag = true;
        int i = 1;

        try {
            Connection connection = EntertainmentConnect.CreateConntection();
            try {
                Statement stmtement = EntertainmentConnect.CreateStatement(connection);

                while (flag) {

                    try {
                        dataLinks = Onepage.getLinks("http://www.prothom-alo.com/entertainment", "" + i);

                    } catch (Exception e) {
                        System.out.println("terminate");
                        flag = false;
                        break;
                    }

                    for (String link : dataLinks) {
                        try {
                            EntertainmentConnect.insertData(stmtement, link);
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
