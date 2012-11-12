/**
 * 
 */
package edu.buffalo.cse.di.apis.entity;

/**
 * @author sravanku@buffalo.edu
 */
public class GoogleCustomSearchResult {
    private final String url;

    public GoogleCustomSearchResult(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
    
}
