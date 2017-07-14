package com.callegasdev.rest;

import com.callegasdev.ribbon.RibbonMathClient;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class StorageService {

    private RibbonMathClient client;

    @Inject
    public StorageService(RibbonMathClient client) {
        this.client = client;
    }

    public String show(String product, String tittle, String author) {
        return product + " " + tittle + " " + author;
    }

}
