package pl.gatomek;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pl.gatomek.entity.Details;

import java.util.List;

public class GetDetails {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit");

    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        List<Details> details = em.createQuery("select d from Details d", Details.class).getResultList();
        details.forEach( d -> System.out.println( d.toString()));

        em.getTransaction().commit();
        em.close();
    }
}
