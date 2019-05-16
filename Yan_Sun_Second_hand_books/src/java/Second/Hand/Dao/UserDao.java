/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Second.Hand.Dao;

import Pojos.User;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author sunyan
 */
public class UserDao extends Dao{
    
    public boolean Login(String username,String pwd) throws Exception
    {  
    try{
            beginTransaction();
            Session session = getSession();
            Query q = session.createQuery("from User where email=:username and pwd=:password");
            q.setString("username", username);
            q.setString("password", pwd);
            Object l=q.uniqueResult();
            commit();
            if(l!=null)
                return true;
            else
                return false;
        } 
    catch(HibernateException e)
        {
            System.out.println("HibernateException:"+e.getMessage());
            try 
            {
                rollbackTransaction();
                close();
            } 
            catch (Exception ex) 
            {
                System.out.println("Exception:"+ex.getMessage());
            }
           return false;
        }
    }
    
    public int createUser(User user) throws Exception 
    {
	int result = 0;
        try {
            beginTransaction();
            getSession().save(user);
            commit();
            result = 1;
        } catch (HibernateException e) {
            System.out.println("HibernateException:"+e.getLocalizedMessage());
            try 
            {
                close();
            } 
            catch (Exception ex) 
            {
                System.out.println("Exception:"+ex.getMessage());
            }
        }
        return result;
    }
    
    public User getUser(String email)
    {
        try {
            beginTransaction();
            Session session = getSession();
            Query q = session.createQuery("from User where email=:username");
            q.setString("username", email);
            Object user=q.uniqueResult();
            commit();
            return (User) user;
            } 
        catch (Exception ex) {
            System.out.println("Exception:"+ex.getMessage());
            return null;
        }
    }
}
