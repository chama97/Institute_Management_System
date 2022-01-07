package bo;

import bo.custom.impl.ProgramBOImpl;
import bo.custom.impl.ReserveDetailBOImpl;
import bo.custom.impl.StudentBOImpl;
import bo.custom.impl.UserBOImpl;

public class BOFactory {

    private static BOFactory boFactory;

    private BOFactory(){}

    public static BOFactory getInstance(){
        return (null == boFactory) ? boFactory = new BOFactory() : boFactory;
    }

    public <T extends SuperBO> T getBO(BOType boType){
        switch (boType){
            case STUDENT:
                return (T) new StudentBOImpl();
            case PROGRAM:
                return (T) new ProgramBOImpl();
            case RESERVE:
                return (T) new ReserveDetailBOImpl();
            case USER:
                return (T) new UserBOImpl();
            default:
                return null;
        }
    }

    public enum BOType {
        STUDENT, PROGRAM, RESERVE ,USER
    }
}
