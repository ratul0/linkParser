/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package politics;


import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import testparser.Onepage;

/**
 *
 * @author yousufkhan
 */
public class PoliticsLinkCollection {
    public static void main(String[] args) {
        ArrayList<String> dataLinks = new ArrayList<String>();
        boolean flag = true;
        int i = 30;

        try {
            Connection connection = PoliticsConnect.CreateConntection();
            try {
                Statement stmtement = PoliticsConnect.CreateStatement(connection);

                while (flag) {

                    try {
                        dataLinks = Onepage.getTagLinks("http://www.prothom-alo.com/bangladesh", "" + i,"" + 235);

                    } catch (Exception e) {
                        System.out.println("terminate");
                        flag = false;
                        break;
                    }

                    for (String link : dataLinks) {
                        try {
                            PoliticsConnect.insertData(stmtement, link);
                            connection.commit();
                            System.out.println(link);
                        } catch (Exception e) {
                            flag = false;
                        }
                    }
                    i--;

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
