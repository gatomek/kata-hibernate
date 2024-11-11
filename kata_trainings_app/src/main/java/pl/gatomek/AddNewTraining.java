package pl.gatomek;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pl.gatomek.entity.Training;

import java.time.LocalDateTime;

public class AddNewTraining {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit");

    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        LocalDateTime dt = LocalDateTime.now();
        Training t = new Training();
        t.setDateTime( dt);
        String info = dt.getYear() + "-" + String.format( "%02d", dt.getMonthValue()) + "-" + String.format( "%02d", dt.getDayOfMonth());
        t.setDescription(info);
        em.persist(t);

        em.getTransaction().commit();
        em.close();
    }
}