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

            /* 1차 캐시
            Member findMember1 = em.find(Member.class, 101L);
            System.out.println("여기서는 조회 쿼리가 나타난다");
            Member findMember2 = em.find(Member.class, 101L);
            System.out.println("여기서는 조회 쿼리가 나타나지 않는다. 1차 캐시에서 조회하기 때문이다");
            */

            /* 동일성 보장
            Member findMember1 = em.find(Member.class, 101L);
            Member findMember2 = em.find(Member.class, 101L);
            System.out.println("result = " + (findMember1 == findMember2));
            */

            /* 트랜잭션을 지원하는 쓰기 지연
            // EntityTransaction transaction = em.getTransaction();
            // transaction.begin();

            Member member1 = new Member();
            member1.setId(150L);
            member1.setName("A");

            Member member2 = new Member();
            member2.setId(160L);
            member2.setName("B");

            em.persist(member1);
            em.persist(member2);
            System.out.println("============ 이 이후에 쿼리가 날아갈 것이다");

            // tx.commit(); 이 순간에 DB로 쿼리가 날아간다
            */

            //* 변경 감지(엔티티 수정)
            Member member = em.find(Member.class, 150L);
            member.setName("zzzzz");
            // em.persist(member); 왜 하지 않아도 될까?

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}