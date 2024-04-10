package dev.boot.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@SequenceGenerator(name = "gen_par", sequenceName = "seq_3", allocationSize = 1)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Paragraph  extends Base{

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_par")
    private long Id;

    @OneToMany(mappedBy = "Paragraph",cascade = CascadeType.ALL)
    private Set<SubParagraph> subParagraphSet;

    @ManyToOne
    @JoinColumn(name = "base_id")
    @JsonIgnore
    private Base base;

    @ManyToOne
    @JoinColumn(name = "article_Id")
    @JsonIgnore
    private Article article;


}
