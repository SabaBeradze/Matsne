package dev.boot.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
@Getter
@Setter
@Entity
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@SequenceGenerator(name = "gen_base", sequenceName = "seq_30", allocationSize = 1)
public class Base {
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_base")
    private long Id;
    private LocalDate startDate;
    private LocalDate endDate;
    private String content;
    public Base() {}


}
