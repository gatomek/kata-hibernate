package pl.gatomek;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pl.gatomek.entity.Note;
import pl.gatomek.entity.Training;

import java.util.List;
import java.util.UUID;

public class AddNewNote {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit");

    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        List<Training> trainings = em.createQuery("select t from Training t", Training.class).getResultList();
        Training t = trainings.getFirst();

        Note n = new Note( UUID.randomUUID().toString().split( "-")[0]);
        t.addNote( n);
        em.persist( t);

        em.getTransaction().commit();
        em.close();
    }
}
