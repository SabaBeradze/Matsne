package dev.boot.repository;

import dev.boot.domain.Paragraph;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ParagraphRepository extends CrudRepository<Paragraph,Long> {
}
