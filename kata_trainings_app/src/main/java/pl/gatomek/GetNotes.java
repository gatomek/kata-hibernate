package pl.gatomek;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pl.gatomek.entity.Note;

import java.util.List;

public class GetNotes {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit");

    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        List<Note> notes = em.createQuery("select n from Note n", Note.class).getResultList();
        notes.forEach(n -> System.out.println( n.getText() ));

        em.getTransaction().commit();
        em.close();
    }
}
