package bknd.backendbookshelf.controller;

import bknd.backendbookshelf.dto.bookDTO;
import bknd.backendbookshelf.model.Book;
import bknd.backendbookshelf.service.bookService;
import bknd.backendbookshelf.utils.mapBook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class mainController {


    private final bookService bookservice;
    private final mapBook mapBooker;

    public mainController(bookService bookservice, mapBook mapBooker) {
        this.bookservice = bookservice;
        this.mapBooker = mapBooker;
    }

    @GetMapping("/")
    @ResponseBody
    public String sayHello()
    {
         return "This is home page, will be redone";
    }

    @GetMapping("/allbooks")
    @ResponseBody
    public List<bookDTO> getAllBooks()
    {
        List<Book> books = bookservice.getBooks();

        return books.stream().map(mapBooker::toDTO).collect(Collectors.toList());
    }
    @PostMapping("/createbook")
    @ResponseBody
    public bookDTO createBook(@RequestBody bookDTO bookdto)
    {
        Book book = mapBooker.toBook(bookdto);
        return mapBooker.toDTO(bookservice.saveBook(book));
    }
    @DeleteMapping("deletebook/{book_id}")
    @ResponseBody
    public bookDTO deleteBook(@PathVariable(name = "book_id") Long id)
    {
        Book book = bookservice.getBook(id);
        bookservice.deleteBook(book);
        return mapBooker.toDTO(book);
    }

}
