package pl.gatomek.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "note")
public class Note {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;

    @ManyToOne( fetch = FetchType.LAZY)
    private Training training;

    public Note() {
    }

    public Note(String text) {
        setText( text);
    }

    @Override
    public String toString() {
        return "Note{"
                + "id=" + id
                + ", text='" + text + "'"
                + '}';
    }
}
