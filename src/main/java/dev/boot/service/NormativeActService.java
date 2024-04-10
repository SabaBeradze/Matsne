package dev.boot.service;

import dev.boot.exception.NormativeActNofFoundException;
import dev.boot.repository.BaseRepository;
import dev.boot.repository.NormativeRepository;
import dev.omedia.boot.domain.*;
import dev.boot.dto.NormativeActDTO;
import dev.omedia.boot.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class NormativeActService {
    private final NormativeRepository repository;
    private final BaseRepository baseRepository;


    public NormativeActDTO save(NormativeActDTO entity) {
        entity.toNormativeAct().getArticleSet().forEach(article -> {
            article.setNormativeAct(entity.toNormativeAct());
            article.setBase(article);

        });
        entity.toNormativeAct().getArticleSet().forEach(article -> article.getParagraphSet().forEach(paragraph -> {
            paragraph.setArticle(article);
            paragraph.setBase(paragraph);
        }));
        entity.toNormativeAct().getArticleSet().forEach(article -> article.getParagraphSet().forEach(paragraph -> paragraph.getSubParagraphSet().forEach(subParagraph -> {
            subParagraph.setParagraph(paragraph);
            subParagraph.setBase(subParagraph);
        })));
        entity.toNormativeAct().getArticleSet().forEach(article -> article.getParagraphSet().forEach(paragraph -> paragraph.getSubParagraphSet().forEach(subParagraph -> subParagraph.getBaseParagraphSet().forEach(baseParagraph -> {
            baseParagraph.setSubParagraph(subParagraph);
            baseParagraph.setBase(baseParagraph);
        }))));

        return new NormativeActDTO(repository.save(entity.toNormativeAct()));
    }

    public NormativeActDTO update(long id, NormativeActDTO normativeActDTO) {
            Optional<NormativeActDTO> normativeActDTO1 = findById(id);
            normativeActDTO1.orElseThrow(NormativeActNofFoundException::new);
            normativeActDTO.setId(id);
            deleteById(id);
            return save(normativeActDTO);


    }

    public  NormativeActDTO update1(long prev,NormativeActDTO normativeActDTO){
        Optional<NormativeActDTO> normativeActDTO1 = findById(prev);
        normativeActDTO1.orElseThrow(NormativeActNofFoundException::new);
        normativeActDTO.setId(normativeActDTO1.get().getId());

        return update(normativeActDTO.getId(),normativeActDTO);

    }
    public Optional<NormativeActDTO> findById(Long aLong) {
        return repository.findById(aLong).map(NormativeActDTO::new);
    }

    public Iterable<NormativeActDTO> findAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .map(NormativeActDTO::new)
                .collect(Collectors.toSet());
    }

    public void delete(Long along){


    }
    private void deleteById(Long aLong) {
        repository.deleteById(aLong);
    }

}
