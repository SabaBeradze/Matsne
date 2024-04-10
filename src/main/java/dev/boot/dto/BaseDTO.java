package dev.boot.dto;

import dev.boot.domain.Base;

import java.time.LocalDate;

public class BaseDTO {
    private final Base base;

    public BaseDTO() {
        this(new Base());
    }

    public BaseDTO(Base base) {
        this.base = base;
    }

    public Base toBase() {
        return base;
    }

    public long getId(){
         return base.getId();
    }
    public String getContent(){
        return base.getContent();
    }
    public LocalDate getStartDate(){
        return base.getStartDate();
    }
    public LocalDate getEndDate(){
        return base.getEndDate();
    }
    public void setId(long Id){
         base.setId(Id);
    }
    public void setContent(String content){
        base.setContent(content);
    }
    public void setStartDate(LocalDate date){
        base.setStartDate(date);
    }
    public void setEndDate(LocalDate date){
        base.setEndDate(date);
    }
}
