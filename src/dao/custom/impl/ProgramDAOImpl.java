package dao.custom.impl;

import dao.custom.ProgramDAO;
import entity.Program;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.FactoryConfiguration;

import java.util.List;

public class ProgramDAOImpl implements ProgramDAO {
    @Override
    public boolean add(Program entity) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        session.refresh(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Program entity) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        return true;
    }

    @Override
    public boolean delete(String s) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Program program = session.get(Program.class, s);
        session.delete(program);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public Program find(String s) throws Exception {
        return null;
    }

    @Override
    public List<Program> selectAll() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        List<Program> list = null;
        Query program = session.createQuery("from Program");
        list = program.list();
        transaction.commit();
        session.close();
        return list;
    }
}
