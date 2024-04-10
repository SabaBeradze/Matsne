package dev.boot.domain;
//ქვეპუნქტი

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@SequenceGenerator(name = "gen_sub", sequenceName = "seq_2", allocationSize = 1)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class SubParagraph extends Base {
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_sub")
    private long Id;

    @OneToMany(mappedBy = "subParagraph",cascade = CascadeType.ALL)
    private Set<BaseParagraph> baseParagraphSet;

    @ManyToOne
    @JoinColumn(name = "base_id")
    @JsonIgnore
    private Base base;

    @ManyToOne
    @JoinColumn(name = "Paragraph_Id")
    @JsonIgnore
    private Paragraph Paragraph;


}
