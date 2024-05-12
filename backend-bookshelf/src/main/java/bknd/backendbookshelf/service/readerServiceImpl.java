package bknd.backendbookshelf.service;

import bknd.backendbookshelf.exception.BookNotFoundException;
import bknd.backendbookshelf.exception.ReaderNotFoundException;
import bknd.backendbookshelf.model.Book;
import bknd.backendbookshelf.model.Reader;
import bknd.backendbookshelf.repository.ReaderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class readerServiceImpl implements readerService{

    private final ReaderRepository readerRepository;

    public readerServiceImpl(ReaderRepository readerRepository) {
        this.readerRepository = readerRepository;
    }

    @Override
    public List<Reader> getReaders() {
        return readerRepository.findAll();
    }

    @Override
    public Reader getReader(Long id) {
        return readerRepository.findById(id).orElseThrow(() -> new ReaderNotFoundException(String.format("Reader with this Id doesn't exist")));
    }

    @Override
    public Reader saveReader(Reader reader) {
        return readerRepository.save(reader);
    }

    @Override
    public void deleteReader(Reader reader) {
        readerRepository.delete(reader);
    }

    @Override
    public boolean hasReaderWithEmail(String email) {
        return readerRepository.existsByEmail(email);
    }

    @Override
    public Reader addBook(Book book, Reader reader) {
        List<Book> books = reader.getBooks();
        books.add(book);
        reader.setBooks(books);
        return readerRepository.save(reader);
    }
}
