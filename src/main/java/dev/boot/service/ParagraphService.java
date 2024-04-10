package dev.boot.service;

import dev.boot.repository.ParagraphRepository;
import dev.boot.dto.ParagraphDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class ParagraphService {
    private final ParagraphRepository repository;

    public ParagraphDTO save(ParagraphDTO entity) {
        return new ParagraphDTO(repository.save(entity.toParagraph()));
    }

    public Optional<ParagraphDTO> findById(Long aLong) {
        return repository.findById(aLong).map(ParagraphDTO::new);
    }

    public Iterable<ParagraphDTO> findAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .map(ParagraphDTO::new)
                .collect(Collectors.toSet());
    }

    public void deleteById(Long aLong) {
        repository.deleteById(aLong);
    }
}
