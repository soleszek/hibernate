package pl.sdacademy.database.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import pl.sdacademy.database.dao.MemberDao;
import pl.sdacademy.database.dao.MemberDaoImpl;
import pl.sdacademy.database.dao.RunDao;
import pl.sdacademy.database.dao.RunDaoImpl;
import pl.sdacademy.database.entity.Member;
import pl.sdacademy.database.entity.Run;
import pl.sdacademy.database.providers.DaoProvider;
import pl.sdacademy.database.utils.HibernateUtils;

import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        /*//Poczas save nie można podawać id, a poczdas update musimy podać id
        Run run = new Run();
        //run.setId(3l);
        run.setName("kjlk");
        run.setPlace("kj;k");
        run.setStartDate(new java.util.Date());
        run.setStartTime(new java.util.Date());
        DaoProvider.getInstance().getRunDao().savOrUpdate(run);

        //Poczas save nie można podawać id, a poczdas update musimy podać id
        Member member = new Member();
        //member.setId(2l);
        member.setName("Sylwester");
        member.setLastName("Oleszek");
        DaoProvider.getInstance().getMemberDao().saveOrUpdate(member);*/

        RunDao runDao = DaoProvider.getInstance().getRunDao();
        MemberDao memberDao = DaoProvider.getInstance().getMemberDao();

        for(int i = 0; i< 2; i++) {
            Run run = new Run();
            run.setName("Bieg nr " + i);
            run.setStartDate(new Date());
            run.setStartTime(new Date());
            run.setPlace("Rzeszów");
            runDao.savOrUpdate(run);

            /*for(int j=0; j<5; j++) {
                Member member = new Member();
                member.setName("Piotr " + j);
                member.setLastName("Pierwszy" + j);
                //member.setRan(run);
                memberDao.saveOrUpdate(member);
            }*/
        }

        for(int i = 0; i< 2; i++) {
            Member member = new Member();
            //member.setName("Sylwester nr " + i);
            //member.setLastName("Pierwszy " + i);
            memberDao.saveOrUpdate(member);
        }

        List<Run> runList = runDao.findAll();
        List<Member> memberList = memberDao.findAll();

        for(Member member: memberList) {
            for(int i = 0; i<3; i++) {
                int randomId = (int)(Math.random()*runList.size());
                member.getRuns().add(runList.get(randomId));
            }
            memberDao.saveOrUpdate(member);
        }


        HibernateUtils.getInstance().getSessionFactory().close();

        //Run run = runDao.findBy(1l);
        //System.out.println(run.getName());

        /*Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(run);
        session.getTransaction().commit();
        session.close();*/

        //sessionFactory.close();
    }
}
