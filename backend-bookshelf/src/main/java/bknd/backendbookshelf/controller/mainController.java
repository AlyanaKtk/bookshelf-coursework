package bknd.backendbookshelf.controller;

import bknd.backendbookshelf.dto.bookDTO;
import bknd.backendbookshelf.dto.readerDTO;
import bknd.backendbookshelf.model.Book;
import bknd.backendbookshelf.model.Reader;
import bknd.backendbookshelf.service.bookService;
import bknd.backendbookshelf.service.readerService;
import bknd.backendbookshelf.utils.mapBook;
import bknd.backendbookshelf.utils.mapReader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class mainController {


    private final bookService bookservice;
    private final mapBook mapBooker;
    private final mapReader mapReaderer;
    private final readerService readerservice;

    public mainController(bookService bookservice, mapBook mapBooker, mapReader mapReaderer, readerService readerservice) {
        this.bookservice = bookservice;
        this.mapBooker = mapBooker;
        this.mapReaderer = mapReaderer;
        this.readerservice = readerservice;
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
    //временное
    @PostMapping("/createreader")
    @ResponseBody
    public readerDTO createReader(@RequestBody readerDTO readerdto)
    {
        Reader reader = mapReaderer.toReader(readerdto);
        return mapReaderer.toDTO(readerservice.saveReader(reader));
    }
    @GetMapping("/{id}/mybooks")
    @ResponseBody
    public List<bookDTO> getReaderBooks(@PathVariable(name = "id") Long id)
    {
        Reader reader = readerservice.getReader(id);
        List<Book> books = reader.getBooks();
        return books.stream().map(mapBooker::toDTO).collect(Collectors.toList());
    }
    @PutMapping("/{id}/addbook")
    @ResponseBody
    public readerDTO addToMyBooks(@RequestBody Long book_id, @PathVariable(name = "id") Long id)
    {
        Reader reader = readerservice.getReader(id);
        Book book = bookservice.getBook(book_id);
        Reader reader2 = readerservice.addBook(book, reader);
        return mapReaderer.toDTO(reader2);
    }

}
