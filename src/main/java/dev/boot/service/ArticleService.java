package dev.boot.service;

import dev.boot.repository.ArticleRepository;
import dev.boot.dto.ArticleDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository repository;

    public ArticleDTO save(ArticleDTO entity) {
        return new ArticleDTO(repository.save(entity.toArticle()));
    }

    public Optional<ArticleDTO> findById(Long aLong) {
        return repository.findById(aLong).map(ArticleDTO::new);
    }

    public Iterable<ArticleDTO> findAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .map(ArticleDTO::new)
                .collect(Collectors.toSet());
    }


    public void deleteById(Long aLong) {
        repository.deleteById(aLong);
    }
}
