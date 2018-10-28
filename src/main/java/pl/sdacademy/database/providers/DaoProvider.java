package pl.sdacademy.database.providers;

import pl.sdacademy.database.dao.MemberDao;
import pl.sdacademy.database.dao.MemberDaoImpl;
import pl.sdacademy.database.dao.RunDao;
import pl.sdacademy.database.dao.RunDaoImpl;

public class DaoProvider {
    private static final DaoProvider instance = new DaoProvider();

    private RunDao runDao;
    private MemberDao memberDao;

    private DaoProvider() {
        runDao = new RunDaoImpl();
        memberDao = new MemberDaoImpl();
    }

    public static DaoProvider getInstance(){
        return instance;
    }

    public RunDao getRunDao() {
        return runDao;
    }

    public MemberDao getMemberDao() {
        return memberDao;
    }
}
