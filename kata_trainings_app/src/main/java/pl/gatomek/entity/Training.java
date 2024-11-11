package pl.gatomek.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table( name="training")
public class Training {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dateTime;
    private String description;

    @OneToMany( cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn( name = "training_id", nullable = false)
    private List<Review> reviewList = new ArrayList<>();

    //todo: custom implementation of toString serializing only ids from reviewList
}

