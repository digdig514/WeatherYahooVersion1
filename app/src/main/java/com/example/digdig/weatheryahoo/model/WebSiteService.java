package com.example.digdig.weatheryahoo.model;

/**
 * Created by digdig on 17-06-20.
 */

public interface WebSiteService {
    public void sucess(String dataInXML);
    public void failure(Exception exception);
}
