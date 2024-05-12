package bknd.backendbookshelf.service;

import bknd.backendbookshelf.model.Book;
import bknd.backendbookshelf.model.Reader;

import java.util.List;

public interface readerService {
    List<Reader> getReaders();
    Reader getReader(Long id);
    Reader saveReader(Reader reader);
    void deleteReader(Reader reader);
    boolean hasReaderWithEmail(String email);
    Reader addBook(Book book, Reader reader);
}
