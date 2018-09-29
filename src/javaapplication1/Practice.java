package javaapplication1;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Stephon
 */
public class Practice {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        
        System.out.println(getAFunction());
    }
    
    private static String getAFunction() throws MalformedURLException{
        try{
            URL url = new URL("http://quotesondesign.com/wp-json/posts?filter[orderby]=rand&filter[posts_per_page]=1");
            HttpURLConnection http = (HttpURLConnection)url.openConnection(); 
            http.setDoOutput(true);
            http.setRequestMethod("GET");
            http.connect();
            
            BufferedReader br = new BufferedReader(new InputStreamReader(http.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                    sb.append(line+"\n");
            }
            br.close();
            return sb.toString();
            
        }catch(IOException e){
            return e.getMessage();
        }    
    }
}
