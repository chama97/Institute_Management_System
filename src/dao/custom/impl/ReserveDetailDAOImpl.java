package dao.custom.impl;

import dao.custom.ReserveDetailDAO;
import entity.Program;
import entity.ReserveDetails;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.FactoryConfiguration;

import java.util.List;

public class ReserveDetailDAOImpl implements ReserveDetailDAO {
    @Override
    public boolean add(ReserveDetails entity) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(ReserveDetails entity) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public ReserveDetails find(String s) throws Exception {
        return null;
    }

    @Override
    public List<ReserveDetails> selectAll() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        List<ReserveDetails> list = null;
        Query program = session.createQuery("from ReserveDetails");
        list = program.list();
        transaction.commit();
        session.close();
        return list;
    }
}
