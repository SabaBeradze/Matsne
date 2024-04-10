package dev.boot.service;

import dev.boot.repository.BaseRepository;
import dev.boot.dto.BaseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class BaseService {
    private final BaseRepository repository;

    public BaseDTO save(BaseDTO entity) {
        return new BaseDTO(repository.save(entity.toBase()));
    }

    public Optional<BaseDTO> findById(Long aLong) {
        return repository.findById(aLong).map(BaseDTO::new);
    }

    public Iterable<BaseDTO> findAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .map(BaseDTO::new)
                .collect(Collectors.toSet());
    }

    public void deleteById(Long aLong) {
        repository.deleteById(aLong);
    }
}
