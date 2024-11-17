package pl.gatomek;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pl.gatomek.entity.Training;
import pl.gatomek.entity.User;

import java.util.List;

public class AddUserToTraining {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit");

    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        List<Training> trainings = em.createQuery("select t from Training t", Training.class).getResultList();
        Training training = trainings.getFirst();

        List<User> users = em.createQuery("select u from User u", User.class).getResultList();
        User user = users.getFirst();

        training.addUser( user);

        em.getTransaction().commit();
        em.close();
    }
}
