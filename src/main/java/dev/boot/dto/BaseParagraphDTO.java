package dev.boot.dto;

import dev.boot.domain.BaseParagraph;

public class BaseParagraphDTO extends BaseDTO {
    private final BaseParagraph baseParagraph;
    public BaseParagraphDTO() {
        this(new BaseParagraph());
    }

    public BaseParagraphDTO(BaseParagraph base) {
        this.baseParagraph = base;
    }

    public BaseParagraph toBaseParagraph() {
        return baseParagraph;
    }
    @Override
    public  long getId(){
         return baseParagraph.getId();
    }

    @Override
    public void  setId(long Id){
        baseParagraph.setId(Id);
    }
}
