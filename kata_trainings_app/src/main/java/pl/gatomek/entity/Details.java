package pl.gatomek.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table( name="details")
public class Details {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne( fetch = FetchType.LAZY, mappedBy = "details")
    private Training training;

    private Integer points;

    public Details() {
    }

    public Details(Integer points) {
        setPoints( points);
    }
}
