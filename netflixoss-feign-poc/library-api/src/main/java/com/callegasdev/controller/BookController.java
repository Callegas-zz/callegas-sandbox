package com.callegasdev.controller;

import com.callegasdev.Book;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by callegas on 13/07/17.
 */

@RestController
@RequestMapping("/books")
public class BookController {

    private List<Book> books = new ArrayList<>();

    @RequestMapping(value="/", method= RequestMethod.GET)
    public List<Book> getAll(){
        return books;
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public Book getOne(@PathVariable("id") Long id){
        Optional<Book> book = this.books.stream().filter(p -> p.getId().equals(id)).findFirst();
        return book.orElseThrow(() -> new RuntimeException("not found"));
    }

    @RequestMapping(value="/add/{id}/{name}/{author}/{year}", method=RequestMethod.GET)
    public String save(@PathVariable("id") Long id,
                     @PathVariable("name") String name,
                     @PathVariable("author") String author,
                     @PathVariable("year") Integer year){
        try {
            books.add(new Book(id, name, author, year));
        }catch (Exception e) {
            return "error" + e;
        }
        return "The Book "+name+" has been successfully added to library";
    }
}
