/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Second.Hand.Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author sunyan
 */
public class Dao {
    private static final SessionFactory sf = new  Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    private Session session = null;
    public Session getSession(){
        if (session == null || !session.isOpen()){
            session = sf.openSession();
        }
        return session;
    }
   
    
    public void beginTransaction(){
        getSession().beginTransaction();
    }
    
    public void commit(){
        getSession().getTransaction().commit();;
    }
    
    
    public void close(){
        if (session !=null)
        {
            getSession().close();
        }
    }
    
    public void rollbackTransaction(){
        getSession().getTransaction().rollback();
    }
}
