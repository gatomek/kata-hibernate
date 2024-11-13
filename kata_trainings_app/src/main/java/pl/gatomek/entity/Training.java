package pl.gatomek.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
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

    @OneToMany( mappedBy = "training", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Retrospection> retrospectionList = new ArrayList<>();

    //todo: custom implementation of toString serializing only ids from reviewList
    @Override
    public String toString() {
        return "Training{" +
                "id=" + id +
                ", dateTime=" + dateTime +
                ", description='" + description + '\'' +
                '}';
    }
}

