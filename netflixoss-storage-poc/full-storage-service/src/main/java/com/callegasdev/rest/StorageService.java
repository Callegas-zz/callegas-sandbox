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
        if (product.equalsIgnoreCase("book")) {
            return client.book().toBlocking().first();
        } else if (product.equalsIgnoreCase("vinyl")) {
            return client.vinyl().toBlocking().first();
        } else {
            return "error";
        }
    }

}
