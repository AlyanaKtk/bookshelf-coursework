package bknd.backendbookshelf.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class bookDTO {
    private Long book_id;
    private String title;
    private String author;
}
