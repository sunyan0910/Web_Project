/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Second.Hand.Dao;

import Pojos.Book;
import Pojos.User;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author sunyan
 */
public class BookDao extends Dao{
    
    public int AddBook(Book book) throws Exception
    {
    int result = 0;
        try {
            beginTransaction();
            getSession().save(book);
            commit();
            result = 1;
        } catch (HibernateException e) {
            System.out.println("HibernateException:"+e.getLocalizedMessage());
            try 
            {
                rollbackTransaction();
                close();
            } 
            catch (Exception ex) 
            {
                System.out.println("Exception:"+ex.getMessage());
            }
        }
        return result;
    }
    public Book getSingleBook(long id)
    {
    try {
            beginTransaction();
            Session session = getSession();
            Criteria crit=session.createCriteria(Book.class);
            crit.add(Restrictions.eq("bookId", id));
            crit.setMaxResults(1);
            Book book=(Book)crit.uniqueResult();
            commit();
            return book;
        } catch (Exception ex) {
            System.out.println("Exception:"+ex.getMessage());
            return null;
        }
    }
    public List getBooks(String query)
    {
        try {
            beginTransaction();
            Session session = getSession();
            Query q = session.createQuery(query);
            List books=q.list();
            commit();
            return books;
        } catch (Exception ex) {
            System.out.println("Exception:"+ex.getMessage());
            return null;
        }
    }
    public List getBooks(String query,User u)
    {
        try {
            beginTransaction();
            Session session = getSession();
            Query q = session.createQuery(query);
            q.setEntity("id", u);
            q.setString("status", "Not Available");
            List books=q.list();
            commit();
            return books;
        } catch (Exception ex) {
            System.out.println("Exception:"+ex.getMessage());
            return null;
        }
    }
    public List getMyBooks(User u)
    {
        try {
            beginTransaction();
            Session session = getSession();
            //Query q = session.createQuery("from Book where owner=:id");
            Criteria crit=session.createCriteria(Book.class);
            crit.add(Restrictions.eq("owner", u));
            List books=crit.list();
            //q.setEntity("id", u);
            //List books=q.list();
            commit();
            return books;
        } catch (HibernateException ex) {
            System.out.println("Exception:"+ex.getMessage());
            return null;
        }
    }
    public int UpdateBook(String name,String author, String description, String category, double price,long id) throws Exception
    {
    int result = 0;
        try {
            beginTransaction();
            Session session = getSession();
            Query q = session.createQuery("update Book set name=:name,author=:author,descreption=:description,category=:category,price=:price where bookId=:id");
            q.setString("name", name);
            q.setString("author", author);
            q.setString("description", description);
            q.setString("category", category);
            q.setDouble("price", price);
            q.setLong("id", id);
            q.executeUpdate();
            commit();
            result = 1;
        } catch (HibernateException e) {
            System.out.println("HibernateException:"+e.getLocalizedMessage());
            try 
            {
                rollbackTransaction();
                close();
            } 
            catch (Exception ex) 
            {
                System.out.println("Exception:"+ex.getMessage());
            }
        }
        return result;
    }
    public int addBookToCart(User user,long bookid)
    {
    int result = 0;
        try {
            beginTransaction();
            Session session = getSession();
            Query q = session.createQuery("update Book set cartOwner=:user,status=:status where bookId=:bookid");
            System.out.println("cart owner:"+user.getfName());
            System.out.println("bookid:"+bookid);
            q.setLong("bookid", bookid);
            q.setString("status", "Not Available");
            q.setEntity("user", user);
            q.executeUpdate();
            commit();
            result = 1;
        } catch (HibernateException e) {
            System.out.println("HibernateException:"+e.getLocalizedMessage());
            try 
            {
                rollbackTransaction();
                close();
            } 
            catch (Exception ex) 
            {
                System.out.println("Exception:"+ex.getMessage());
            }
        }
        return result;
    }
    public int deleteBookFromCart(User cartOwner,long bookid)
    {
        int result = 0;
        try {
            beginTransaction();
            Session session = getSession();
            Query q = session.createQuery("update Book set status=:status where bookId=:id");
            q.setLong("id", bookid);
            q.setString("status","Available");
            q.executeUpdate();
            commit();
            result = 1;
        }
        catch (HibernateException e) {
            System.out.println("HibernateException:"+e.getLocalizedMessage());
            try 
            {
                rollbackTransaction();
                close();
            } 
            catch (Exception ex) 
            {
                System.out.println("Exception:"+ex.getMessage());
            }
        }
        return result;
        
    }
    public int soldBook(long bookid) throws Exception
    {
    int result = 0;
        try {
            beginTransaction();
            Session session = getSession();
            Query q = session.createQuery("update Book set status=:status where bookId=:id");
            q.setString("status", "Sold out");
            q.setLong("id", bookid);
            q.executeUpdate();
            commit();
            result = 1;
        } catch (HibernateException e) {
            System.out.println("HibernateException:"+e.getLocalizedMessage());
            try 
            {
                rollbackTransaction();
                close();
            } 
            catch (Exception ex) 
            {
                System.out.println("Exception:"+ex.getMessage());
            }
        }
        return result;
    }
}
