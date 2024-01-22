package hellojpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        // JPA에 일어나는 변경은 트랜잭션 안에서 일어나야 한다.

        try{
//            Member findMember = em.find(Member.class, 1L);
//            findMember.setName("chan");

            List<Member> result = em.createQuery("select m from Member as m", Member.class)
//                            .setFirstResult(1)
//                            .setMaxResults(10)
                            .getResultList();

            for(Member member : result){
                System.out.println("member = " + member.getName());
            }

            tx.commit();
        } catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}

/*
주의
엔티티 메니저 팩토리르는 하나만 생성해서 애플리케이션 전체에서 공유
엔틴티 매니저는 쓰레드간에 공유X(사용하고 버려야 한다.)
JPA의 모든 데이터 변경은 트랜잭션 안에서 실행*/
