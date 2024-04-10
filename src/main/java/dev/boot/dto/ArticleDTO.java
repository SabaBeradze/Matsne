package dev.boot.dto;

import dev.boot.domain.Article;


public class ArticleDTO extends BaseDTO {

    private final Article article;

    public ArticleDTO() {
        this(new Article());
    }

    public ArticleDTO(Article article) {
        this.article = article;
    }

    public Article toArticle() {
        return article;
    }

    public long getId() {
        return article.getId();
    }

    public String getTitle() {
        return article.getTitle();
    }

    public void setId(long Id) {
        article.setId(Id);
    }

    public void setTitle(String title) {
        article.setTitle(title);
    }
}
