package dev.boot.repository;

import dev.boot.domain.Base;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface BaseRepository extends CrudRepository<Base,Long> {
}
