package pl.gatomek;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pl.gatomek.entity.Retrospection;

import java.util.List;

public class GetRetrospection {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit");

    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        List<Retrospection> retrospections = em.createQuery("select r from Retrospection r", Retrospection.class).getResultList();
        retrospections.forEach( r -> System.out.println( r.getText() ));

        em.getTransaction().commit();
        em.close();
    }
}
