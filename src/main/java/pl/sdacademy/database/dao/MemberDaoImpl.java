package pl.sdacademy.database.dao;

import org.hibernate.Session;
import pl.sdacademy.database.entity.Member;
import pl.sdacademy.database.entity.Run;
import pl.sdacademy.database.utils.HibernateUtils;

import javax.persistence.NoResultException;
import java.util.List;

public class MemberDaoImpl implements MemberDao {

    public void saveOrUpdate(Member member) {
        Session session = HibernateUtils.getInstance()
                .getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.saveOrUpdate(member);
        session.getTransaction().commit();
        session.close();
    }

    public Member findBy(Long id) {
        try {
            Session session = HibernateUtils.getInstance().getSessionFactory()
                    .getCurrentSession();
            Member member = (Member) session
                    .createQuery("from Run where id=:id")
                    .setParameter("id", id).getSingleResult();
            session.getTransaction().commit();
            session.clear();

            return member;
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<Member> findAll() {
        Session session = HibernateUtils.getInstance().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Member> memberList = session.createQuery("from Member").list();
        session.getTransaction().commit();
        session.close();

        return memberList;
    }

    public void delete(Long id) {
        Session session = HibernateUtils.getInstance().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session
                .createQuery("delete Member where id=:id").setParameter("id", id)
                .executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    public void delete(Member member) {
        Session session = HibernateUtils.getInstance().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.delete(member);
        session.getTransaction().commit();
        session.close();
    }
}
