package dev.boot.dto;

import dev.boot.domain.SubParagraph;

public class SubParagraphDTO extends BaseDTO {

    private final SubParagraph subParagraph;
    public SubParagraphDTO() {
        this(new SubParagraph());
    }
    public SubParagraphDTO(SubParagraph paragraph) {
        this.subParagraph = paragraph;
    }
    public SubParagraph toSubParagraph() {
        return subParagraph;
    }

    public long getId(){
        return subParagraph.getId();
    }
    public void setId(long Id){
        subParagraph.setId(Id);
    }
}
