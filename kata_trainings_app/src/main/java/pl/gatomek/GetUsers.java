package pl.gatomek;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pl.gatomek.entity.User;

import java.util.List;

public class GetUsers {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit");

    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        List<User> users = em.createQuery("select u from User u", User.class).getResultList();
        users.forEach( System.out::println);

        em.getTransaction().commit();
        em.close();
    }

}
