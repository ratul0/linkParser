/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testparser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.nodes.Document;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author yousufkhan
 */
public class Testparser {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<String> dataLinks = new ArrayList<String>();
        BufferedWriter bw = null;
        
        for(int i=1;i<50;i++){
            try {
                    bw=new BufferedWriter(new FileWriter(new File("dataset/links/link"+i+".txt"),false));
                } catch (IOException ex) {
                    Logger.getLogger(Testparser.class.getName()).log(Level.SEVERE, null, ex);
                }
            for(String link : Onepage.getLinks("http://www.prothom-alo.com/bangladesh", ""+i)){
                
            try {
                if(bw != null){
                    bw.write(link);
                    bw.newLine();
                }
                
            } catch (IOException ex) {
                Logger.getLogger(Testparser.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            try {
                if(bw != null){
                    bw.flush();
                    bw.close();
                }
                
            } catch (IOException ex) {
                Logger.getLogger(Testparser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        

    }
    
}
