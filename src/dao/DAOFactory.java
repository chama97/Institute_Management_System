package dao;

import dao.custom.impl.ProgramDAOImpl;
import dao.custom.impl.ReserveDetailDAOImpl;
import dao.custom.impl.StudentDAOImpl;
import dao.custom.impl.UserDAOImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory(){}

    public static DAOFactory getInstance(){
        return (null == daoFactory) ? daoFactory = new DAOFactory() : daoFactory;
    }

    public <T extends SuperDAO>T getDAO(DAOTypes daoType){
        switch (daoType){
            case STUDENT:
                return (T) new StudentDAOImpl();
            case PROGRAM:
                return (T) new ProgramDAOImpl();
            case RESERVE:
                return (T) new ReserveDetailDAOImpl();
            case USER:
                return (T) new UserDAOImpl();

            default:
                return null;
        }
    }
    public enum DAOTypes {
        STUDENT, PROGRAM,USER, RESERVE
    }

}
