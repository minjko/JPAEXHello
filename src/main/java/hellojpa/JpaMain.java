package hellojpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello"); // 인수 : persistence-unit의 name 값(persistence.xml -> hello);
    }
}