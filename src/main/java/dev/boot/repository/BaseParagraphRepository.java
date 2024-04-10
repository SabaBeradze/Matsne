package dev.boot.repository;

import dev.boot.domain.BaseParagraph;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface BaseParagraphRepository extends CrudRepository<BaseParagraph,Long> {
}
