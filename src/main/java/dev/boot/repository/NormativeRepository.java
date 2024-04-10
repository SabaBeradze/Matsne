package dev.boot.repository;

import dev.boot.domain.NormativeAct;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface NormativeRepository extends CrudRepository<NormativeAct,Long> {
}
