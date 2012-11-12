package edu.buffalo.cse.di.apis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;



import edu.buffalo.cse.di.util.GoogleAPIKey;

/**
 * Class to search against the google products using google product SearchAPI
 * 
 * @author sravanku@buffalo.edu
 */
public class GoogleProductSearch {

    private static final String BASE_URL 
        = "https://www.googleapis.com/shopping/search/v1/public/products?";
    
    private static final String optionalParms = "&country=US";
    private static final String outputFormat = "&alt=json";
    
    /**
     * Returns the JSONOutput
     * @param searchString
     * @return
     */
    public static String queryGoogleProductSearch(String searchString) {
        
        String completeURL = BASE_URL + "key="+GoogleAPIKey.getGoogleAPIKey() +
                optionalParms + "&q=" + searchString + outputFormat;
        
        try {
            InputStream stream = new URL(completeURL).openStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
            
            String content = "";
            String line = null;
            while ((line = reader.readLine()) != null) {
                content += line;
            }
            //System.out.println(content);
            return content;
        } catch (MalformedURLException e) {
            // TODO Add LOG statement here.
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Add LOG statement here.
            e.printStackTrace();
        }
        
        return null;
    }
    
    public static List<String> getItemNames(String query) {
        String content = queryGoogleProductSearch(query);

        JSONObject obj = (JSONObject) JSONSerializer.toJSON(content);
        JSONArray items = obj.getJSONArray("items");
        List<String> itemNames = new ArrayList<String>();
        for(int i=0; i<items.size(); i++) {
            JSONObject item = items.getJSONObject(i);
            JSONObject product = item.getJSONObject("product");
            //String title = 
            //System.out.println(item.get("product"));
            System.out.println(product.get("title"));
        }
        return itemNames;
    }
    
    public static void main(String[] args) {
        //GoogleProductSearch.queryGoogleProductSearch("iphone");
        GoogleProductSearch.getItemNames("iphone+4s");
    }
}
