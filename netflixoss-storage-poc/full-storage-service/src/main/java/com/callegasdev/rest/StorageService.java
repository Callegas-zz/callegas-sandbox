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

    public String show(String product) {
        if (product == "book") {
            return client.book() + "";
        } else if (product == "vinyl") {
            return client.vinyl() + "";
        } else {
            return "error";
        }
    }

}
