package pl.gatomek;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pl.gatomek.entity.User;

import java.time.LocalDateTime;
import java.util.UUID;

public class AddNewUser {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit");

    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        User u = new User();
        u.setName( "TGL");
        u.setLastName(UUID.randomUUID().toString().split("-")[0]);
        u.setCreated( LocalDateTime.now() );
        em.persist(u);

        em.getTransaction().commit();
        em.close();
    }
}
