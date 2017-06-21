package com.callegasdev.database;
import org.hibernate.Session;
import com.callegasdev.profile.History;
import com.callegasdev.view.OperationsTracking;

public class DaoHistory {

    private OperationsTracking operationsTracking;

    public DaoHistory(OperationsTracking operationsTracking) {
        this.operationsTracking = operationsTracking;
    }

    public String save(History history) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(history);
            session.getTransaction().commit();
            session.close();
        }
        catch (Exception e){
            operationsTracking.setErrorLog("An error in com.callegasdev.database has occurred, please try again ");
            return e.toString();
        }
        return "success";
    }


}
