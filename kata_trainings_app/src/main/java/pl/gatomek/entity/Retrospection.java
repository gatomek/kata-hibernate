package pl.gatomek.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "retrospection")
public class Retrospection {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;

    @ManyToOne( fetch = FetchType.LAZY)
    private Training training;

    public Retrospection() {
    }

    public Retrospection( String text) {
        setText( text);
    }

    @Override
    public String toString() {
        return "Retrospection{" +
                "id=" + id +
                ", text='" + text + '\'' +
                '}';
    }
}
