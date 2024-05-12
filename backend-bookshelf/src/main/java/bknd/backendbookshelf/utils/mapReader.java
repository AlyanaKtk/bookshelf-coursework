package bknd.backendbookshelf.utils;

import bknd.backendbookshelf.dto.readerDTO;
import bknd.backendbookshelf.model.Reader;
import org.springframework.stereotype.Service;

@Service
public class mapReader {
    public Reader toReader(readerDTO dto)
    {
        Reader reader = new Reader();
        reader.setId(dto.getId());
        reader.setUsername(dto.getUsername());
        reader.setEmail(dto.getEmail());
        reader.setPassword(dto.getPassword());
        return reader;
    }

}
