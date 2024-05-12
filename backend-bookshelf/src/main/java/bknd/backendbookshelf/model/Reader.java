package bknd.backendbookshelf.model;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "reader", uniqueConstraints = @UniqueConstraint(columnNames = "email"))

public class Reader
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String username;
    String email;
    String password;
    @ManyToMany(cascade = CascadeType.MERGE)
    List<Book> books = new ArrayList<>();


}
