package pl.gatomek.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table( name="review")
public class Review {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    private String author;
    private String comment;

    public Review() {}

    public Review (String author, String comment) {
        setAuthor( author);
        setComment( comment);
    }
}
