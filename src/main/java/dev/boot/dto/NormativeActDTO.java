package dev.boot.dto;

import dev.boot.domain.NormativeAct;
import dev.boot.domain.Article;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;
import java.util.Set;

public class NormativeActDTO {
    private final NormativeAct normativeAct;

    public NormativeActDTO(NormativeAct normativeAct) {
        this.normativeAct = normativeAct;
    }

    public NormativeActDTO() {
        this(new NormativeAct());
    }

    public NormativeAct toNormativeAct() {
        return normativeAct;
    }

    public long getId() {
        return normativeAct.getId();
    }

    public LocalDate getStartDate() {
        return normativeAct.getStartDate();
    }

    public LocalDate getEndDate() {
        return normativeAct.getEndDate();
    }

    public String getHeader() {
        return normativeAct.getHeader();
    }

    public String getSentence() {
        return normativeAct.getSentence();
    }

    public Set<Article> getArticles() {
        return normativeAct.getArticleSet();
    }

    @Schema(hidden = true)
    public void setId(long Id) {
        normativeAct.setId(Id);
    }

    public long getPrevId() {
        return normativeAct.getPrev_Id();
    }

    public void setEndDate(LocalDate localDate) {
        normativeAct.setEndDate(localDate);
    }

    public void setHeader(String header) {
        normativeAct.setHeader(header);
    }

    public void setArticles(Set<Article> articles) {
        normativeAct.setArticleSet(articles);
    }

    public void setSentence(String sentence) {
        normativeAct.setSentence(sentence);
    }

    public void setPrevId(long id) {
        normativeAct.setPrev_Id(id);
    }

    public void setStartDate(LocalDate localDate) {
        normativeAct.setStartDate(localDate);
    }

}
