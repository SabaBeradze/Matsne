package dev.boot.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;


@Entity
@SequenceGenerator(name = "gen_norm", sequenceName = "seq_5", allocationSize = 1)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class NormativeAct {
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_norm")
    private long Id;
    private long prev_Id;
    private String header;
    private String sentence;

    @OneToMany(mappedBy = "normativeAct",cascade = CascadeType.ALL)

    private Set<Article> articleSet;

    private LocalDate startDate;
    private LocalDate endDate;


//ENUMIA DA
}
