package dao.custom.impl;

import dao.custom.UserDAO;
import entity.Program;
import entity.Users;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.FactoryConfiguration;

import java.util.List;

public class UserDAOImpl implements UserDAO {
    @Override
    public boolean add(Users entity) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Users entity) throws Exception {
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
        Users users = session.get(Users.class, s);
        session.delete(users);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public Users find(String s) throws Exception {
        return null;
    }

    @Override
    public List<Users> selectAll() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        List<Users> list = null;
        Query program = session.createQuery("from Users");
        list = program.list();
        transaction.commit();
        session.close();
        return list;
    }
}
