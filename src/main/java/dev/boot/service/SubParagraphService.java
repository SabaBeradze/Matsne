package dev.boot.service;

import dev.boot.repository.SubParagraphRepository;
import dev.boot.dto.SubParagraphDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class SubParagraphService {
    private final SubParagraphRepository repository;

    public SubParagraphDTO save(SubParagraphDTO entity) {
        return new SubParagraphDTO(repository.save(entity.toSubParagraph()));
    }

    public Optional<SubParagraphDTO> findById(Long aLong) {
        return repository.findById(aLong).map(SubParagraphDTO::new);
    }

    public Iterable<SubParagraphDTO> findAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .map(SubParagraphDTO::new)
                .collect(Collectors.toSet());
    }

    public void deleteById(Long aLong) {
        repository.deleteById(aLong);
    }
}
