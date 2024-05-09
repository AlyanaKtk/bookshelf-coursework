package bknd.backendbookshelf.repository;

import bknd.backendbookshelf.model.Reader;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReaderRepository extends JpaRepository<Reader, Long> {
    @Override
    List<Reader> findAll();

    @Override
    Optional<Reader> findById(Long aLong);

    @Override
    boolean existsById(Long Long);

    boolean existsByEmail(String email);
}
