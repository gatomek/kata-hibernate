package pl.gatomek;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pl.gatomek.entity.Training;

import java.util.List;

public class GetTrainings {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit");

    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        List<Training> trainings = em.createQuery("select t from Training t", Training.class).getResultList();
        trainings.forEach( System.out::println);


        em.getTransaction().commit();
        em.close();
    }
}
