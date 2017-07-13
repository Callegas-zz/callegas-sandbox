package com.callegasdev;

import com.sun.org.apache.xpath.internal.SourceTree;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.jaxrs.JAXRSContract;

import java.util.Arrays;
import java.util.List;

/**
 * Created by callegas on 13/07/17.
 */
public class App {

    public static void main(String[] args) {

        LibraryBookApi fakeApi = Feign.builder()
                .contract(new JAXRSContract())
                .decoder(new JacksonDecoder())
                .encoder(new JacksonEncoder())
                .target(LibraryBookApi.class, "http://localhost:8080/books");


        List<BookRestModel> toAdd = Arrays.asList(
                new BookRestModel(1L, "Blood Donator", "Josh Winston", 2007),
                new BookRestModel(2L, "It's high noon", "James Mccree", 1997)
        );

        toAdd.stream().forEach(book -> fakeApi.add(book));

        fakeApi.all().stream().forEach(book -> System.out.println(book.getName()));
        System.out.println(fakeApi.getById(3L).getAuthor());
    }

}
