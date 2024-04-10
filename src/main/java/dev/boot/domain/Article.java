package dev.boot.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@SequenceGenerator(name = "gen_art", sequenceName = "seq_4", allocationSize = 1)
@Getter
@Setter
@NoArgsConstructor

public class Article  extends Base{

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_art")
    private long Id;
    @Column
    private String title;

    @OneToMany(mappedBy = "article",cascade = CascadeType.ALL)
    private Set<Paragraph> ParagraphSet;

    @ManyToOne
    @JoinColumn(name = "base_id")
    @JsonIgnore
    private Base base;

    @ManyToOne
    @JoinColumn(name = "normative_act_id")
    @JsonIgnore
    private NormativeAct normativeAct;


}
