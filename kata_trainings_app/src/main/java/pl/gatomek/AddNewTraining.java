package pl.gatomek;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pl.gatomek.entity.Details;
import pl.gatomek.entity.Training;

import java.time.LocalDateTime;

public class AddNewTraining {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit");

    private static String makeInfo( LocalDateTime dt) {
        return dt.getYear() + "-" + String.format( "%02d", dt.getMonthValue()) + "-" + String.format( "%02d", dt.getDayOfMonth());
    }

    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        LocalDateTime dt = LocalDateTime.now();
        Training training = new Training();

        // Local Date Time
        training.setDateTime( dt);

        // Info
        String info = makeInfo( dt);
        training.setDescription(info);

        // Training Details
        Details details = new Details( 30);
        training.setDetails(details);

        em.persist(training);

        em.getTransaction().commit();
        em.close();
    }
}