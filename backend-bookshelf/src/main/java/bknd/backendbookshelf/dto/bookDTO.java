package bknd.backendbookshelf.dto;

import bknd.backendbookshelf.model.Reader;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class bookDTO {
     Long book_id;
     String title;
     String author;

}
