
package com.example.desafiomarvel.model.pojos.Quadrinhos;

import com.google.gson.annotations.Expose;


public class Series {

    @Expose
    private String name;
    @Expose
    private String resourceURI;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResourceURI() {
        return resourceURI;
    }

    public void setResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
    }

}