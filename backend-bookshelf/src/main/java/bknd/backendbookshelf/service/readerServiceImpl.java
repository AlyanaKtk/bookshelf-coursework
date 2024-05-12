package bknd.backendbookshelf.service;

import bknd.backendbookshelf.model.Reader;
import bknd.backendbookshelf.repository.ReaderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
