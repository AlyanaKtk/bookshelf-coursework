package bknd.backendbookshelf.dto;

import bknd.backendbookshelf.model.Book;
import bknd.backendbookshelf.model.Reader;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class readerDTO {
    private Long id;
    private String username;
    private String email;
    private String password;
    List<Book> books;

}
