package com.callegasdev.database;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.callegasdev.profile.History;

import java.util.List;

@Component
public class ListHistory {

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<History> list() {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();

        Query query = session.createQuery("from History");
        List<History> list = query.list();

        session.getTransaction().commit();
        session.close();

        return list;

    }


}
