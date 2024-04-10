package dev.boot.dto;

import dev.boot.domain.Paragraph;

public class ParagraphDTO extends BaseDTO {

    private final Paragraph paragraph;
    public ParagraphDTO() {
        this(new Paragraph());
    }
    public ParagraphDTO(Paragraph paragraph) {
        this.paragraph = paragraph;
    }
    public Paragraph toParagraph() {
        return paragraph;
    }
    @Override

    public long getId(){return paragraph.getId();}
    @Override
    public void setId(long Id) {paragraph.setId(Id);}
}
