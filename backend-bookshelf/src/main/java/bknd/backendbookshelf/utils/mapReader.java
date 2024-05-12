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
        reader.setBooks(dto.getBooks());
        return reader;
    }
    public readerDTO toDTO(Reader reader)
    {
        readerDTO dto = new readerDTO();
        dto.setId(reader.getId());
        dto.setUsername(reader.getUsername());
        dto.setEmail(reader.getEmail());
        dto.setPassword(reader.getPassword());
        dto.setBooks(reader.getBooks());
        return dto;
    }

}
