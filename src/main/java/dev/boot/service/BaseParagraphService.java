package dev.boot.service;

import dev.boot.dto.BaseParagraphDTO;
import dev.boot.repository.BaseParagraphRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class BaseParagraphService {
    private final BaseParagraphRepository repository;
    public BaseParagraphDTO save(BaseParagraphDTO entity) {
        return new BaseParagraphDTO(repository.save(entity.toBaseParagraph()));
    }

    public Optional<BaseParagraphDTO> findById(Long aLong) {
        return repository.findById(aLong).map(BaseParagraphDTO::new);
    }

    public Iterable<BaseParagraphDTO> findAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .map(BaseParagraphDTO::new)
                .collect(Collectors.toSet());
    }

    public void deleteById(Long aLong) {
        repository.deleteById(aLong);
    }
}
