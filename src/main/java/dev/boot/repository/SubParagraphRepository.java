package dev.boot.repository;

import dev.boot.domain.SubParagraph;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface SubParagraphRepository extends CrudRepository<SubParagraph,Long> {
}
