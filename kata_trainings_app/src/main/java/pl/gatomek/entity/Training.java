package pl.gatomek.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
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
    private List<Note> noteList = new ArrayList<>();

    @OneToOne( fetch = FetchType.LAZY,cascade = CascadeType.ALL, orphanRemoval = true)
    private Details details;

    @ManyToMany
    @JoinTable( joinColumns = { @JoinColumn( name="training_id") },
            inverseJoinColumns = { @JoinColumn( name="user_id") }
    )
    private Set<User> users = new HashSet<>();

    public void addNote(Note note) {
        noteList.add(note);
        note.setTraining( this);
    }

    public void addReview( Review review){
        reviewList.add( review);
    }

    public void addUser( User user) {
        users.add( user);
        user.getTrainings().add( this);
    }

    @Override
    public String toString() {
        return "Training{"
                + "id=" + id
                + ", dateTime=" + dateTime
                + ", description='" + description + "'"
                + ", users=" + users.stream().map( User::getId).toList()
                + "}";
    }
}

