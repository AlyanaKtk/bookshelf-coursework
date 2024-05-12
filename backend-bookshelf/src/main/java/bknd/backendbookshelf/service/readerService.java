package bknd.backendbookshelf.service;

import bknd.backendbookshelf.model.Reader;

import java.util.List;

public interface readerService {
    List<Reader> getReaders();
    Reader saveReader(Reader reader);
    void deleteReader(Reader reader);
    boolean hasReaderWithEmail(String email);
}
