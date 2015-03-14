/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testparser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author yousufkhan
 */
public class Onepage {

    
    public static String getArticle(String url){
        Document doc;
        String linkText = "";
        try {
            doc = Jsoup.connect(url).timeout(0).get();
            
            Elements contents = doc.getElementsByAttributeValue("itemprop", "articleBody");
            
            for (Element data : contents) {
              
              linkText = data.text();
            }
            
        } catch (IOException ex) {
            Logger.getLogger(Onepage.class.getName()).log(Level.SEVERE, null, ex);
        }
        return linkText;
        
    }
    
    public static ArrayList<String> getLinks(String urlBase,String pageNo){
        String custom = urlBase+"/article/";
        String text = urlBase+"/article/?page="+pageNo;
        ArrayList<String> dataLinks = new ArrayList<String>();
        
        Document doc;
        try {
            
            doc = Jsoup.connect(text).timeout(0).get();
            
            Elements contents = doc.getElementsByAttributeValueContaining("class", "the_news_group");
            //System.out.println(contents.isEmpty());
            if(!contents.isEmpty()){
                
                    for (Element content : contents) {
                        Elements allNews = content.getElementsByAttributeValueContaining("class", "each_news");
                        //System.out.println(allNews);
                        for(Element eachNews : allNews){
                            Elements links = eachNews.getElementsByAttributeValueContaining("class", "more_link");
                            
                            //System.out.println(links);
                            for (Element link : links) {
                              String linkHref = link.attr("href");
                                //System.out.println(custom+linkHref);
                              dataLinks.add(custom+linkHref);
                            }
                        }
                    }
                
            }
            else{
                throw new NullPointerException();
            }
            //System.out.println(contents);
            
            
        } catch (IOException ex) {
            System.out.println("test");
            Logger.getLogger(Testparser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dataLinks;
        
    }
    
    public static ArrayList<String> getTagLinks(String urlBase,String pageNo,String tagNumber){

        String custom = urlBase+"/article/";
        String text = urlBase+"/article/?tags="+tagNumber+"&page="+pageNo;
        ArrayList<String> dataLinks = new ArrayList<String>();
        
        Document doc;
        try {
            
            doc = Jsoup.connect(text).timeout(0).get();
            
            Elements contents = doc.getElementsByAttributeValueContaining("class", "the_news_group");
            //System.out.println(contents.isEmpty());
            if(!contents.isEmpty()){
                
                    for (Element content : contents) {
                        Elements allNews = content.getElementsByAttributeValueContaining("class", "each_news");
                        //System.out.println(allNews);
                        for(Element eachNews : allNews){
                            Elements links = eachNews.getElementsByAttributeValueContaining("class", "more_link");
                            
                            //System.out.println(links);
                            for (Element link : links) {
                              String linkHref = link.attr("href");
                                //System.out.println(custom+linkHref);
                              dataLinks.add(custom+linkHref);
                            }
                        }
                    }
                
            }
            else{
                throw new NullPointerException();
            }
            //System.out.println(contents);
            
            
        } catch (IOException ex) {
            System.out.println("test");
            Logger.getLogger(Testparser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dataLinks;
    }
}
