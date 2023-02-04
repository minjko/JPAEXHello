package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;


public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello"); // 인수 : persistence-unit의 name 값(persistence.xml -> hello);
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            /* 회원 저장
            Member member = new Member();
            member.setId(1L);
            member.setName("HelloA");

            em.persist(member);
            */

            /* 회원 수정
            Member findMember = em.find(Member.class, 1L);
            System.out.println("findMember = " + findMember.getName());
            */

            /* 회원 삭제
            // 회원 저장 후 진행할 것(실행 안 함)
            Member findMember = em.find(Member.class, 1L);
            em.remove(findMember);
            */

            /* 회원 수정
            Member findMember = em.find(Member.class, 1L);
            findMember.setName("HelloJPA");
            */

            /* JPQL
            List<Member> result = em.createQuery("select m from Member as m", Member.class)
                    .setFirstResult(5)
                    .setMaxResults(8)
                    .getResultList();

            for (Member member : result) {
                System.out.println("member.name = " + member.getName());
                // 객체를 대상으로 하는 객체지향 쿼리이다.
            }
            */

            /*/ 비영속
            Member member = new Member();
            member.setId(101L);
            member.setName("HelloJPA");
            */

            /*/ 영속
            System.out.println("=== Before ===");
            em.persist(member);
            System.out.println("=== After ===");

            Member findMember = em.find(Member.class, 101L);
            System.out.println("findMembr = " + findMember.getId());
            */

            //* 1차 캐시
            Member findMember1 = em.find(Member.class, 101L);
            System.out.println("여기서는 조회 쿼리가 나타난다");
            Member findMember2 = em.find(Member.class, 101L);
            System.out.println("여기서는 조회 쿼리가 나타나지 않는다. 1차 캐시에서 조회하기 때문이다");


            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}