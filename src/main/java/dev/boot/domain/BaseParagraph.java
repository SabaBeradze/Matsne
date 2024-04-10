package dev.boot.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "gen_basepar", sequenceName = "seq_1", allocationSize = 1)

public class BaseParagraph extends Base {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_basepar")
    private long Id;


    @ManyToOne
    @JoinColumn(name = "SubParagraph_Id")
    @JsonIgnore
    private SubParagraph subParagraph;

    @ManyToOne
    @JoinColumn(name = "base_id")
    @JsonIgnore
    private Base base;


}






