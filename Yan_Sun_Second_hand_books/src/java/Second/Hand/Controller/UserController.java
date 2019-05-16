/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Second.Hand.Controller;

import Pojos.Book;
import Pojos.User;
import Second.Hand.Dao.BookDao;
import Second.Hand.Dao.UserDao;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author sunyan
 */
public class UserController extends AbstractController {
    
    public UserController() 
    {
    }
    
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request,HttpServletResponse response) throws Exception 
    {   
        HttpSession session=request.getSession();
        String url=request.getRequestURI();
        
        
        if(url.endsWith("login.htm"))
        {
            UserDao ud=(UserDao)getApplicationContext().getBean("userdao");
            String username=request.getParameter("uname");
            String pwd=request.getParameter("psw");
            if(ud.Login(username, pwd))
            {
                User u=ud.getUser(username);
                String query ="from Book";
                BookDao bd=(BookDao)getApplicationContext().getBean("bookdao");
                List books=bd.getBooks(query);
//                System.out.println("total books number:"+books.size());
                request.setAttribute("bookList", books);
                session.setAttribute("loginuser", u);
                return new ModelAndView("Homepage","bookList", books);
            }
            else
            {
                String error="Oops! Please try again later!";
                return new ModelAndView("Errorpage","error",error);
            }
        }
        
        if(url.endsWith("addbook.htm"))
        {
            String from="add";
            request.setAttribute("from", from);
            return new ModelAndView("BookDetailPage");
        }
        
        if(url.endsWith("updatebook.htm"))
        {
            String from="update";
            request.setAttribute("from", from);
            Book thisBook=(Book)request.getAttribute("thisbook");
            request.setAttribute("thisBook", thisBook);
            return new ModelAndView("BookDetailPage");
        }
        
        if(url.endsWith("userpage.htm"))
        {
            User u=(User)session.getAttribute("loginuser");
            BookDao bd=(BookDao)getApplicationContext().getBean("bookdao");
            List myBooks=bd.getMyBooks(u);
            request.setAttribute("mybooks", myBooks);
            return new ModelAndView("Userpage");
        }
    
        if(url.endsWith("home.htm"))
        {
            String query ="from Book";
            BookDao bd=(BookDao)getApplicationContext().getBean("bookdao");
            List books=bd.getBooks(query);
            request.setAttribute("bookList", books);
            return new ModelAndView("Homepage");
        }
        
        if(url.endsWith("tocart.htm"))
        {
            User u=(User)session.getAttribute("loginuser");
//            String query ="from Book where cartOwner=:id and status=:status";
//            BookDao bd=(BookDao)getApplicationContext().getBean("bookdao");
//            List cart=bd.getBooks(query, u);
//            request.setAttribute("cart", cart);
            return new ModelAndView("Cart");
        }
    
        if(url.endsWith("register.htm"))
        {
            return new ModelAndView("Registerpage");
        }
        
        if(url.endsWith("deleteItem.htm"))
        {
            User u=(User)session.getAttribute("loginuser");
            BookDao bd=(BookDao)getApplicationContext().getBean("bookdao");
            List cart=u.getCart();
            long bookid=Long.parseLong(request.getParameter("bookid"));
            if(bd.getSingleBook(bookid)!=null)
            {
                Book book=bd.getSingleBook(bookid);
                cart.remove(book);
                return new ModelAndView("Cart");
            }
            else
            {
            String error="Book was not deleted from your cart successfully!";
            return new ModelAndView("Errorpage","error",error);
            }
            
            
//            //User downer=new User();
//            //long bookid=Long.parseLong(request.getParameter("bookid"));
//            bd.deleteBookFromCart(u, bookid);
//            String query ="from Book where cartOwner=:id and status=:status";
//            //List cart=bd.getBooks(query, u);
//            //session.setAttribute("cart", cart);
//            request.setAttribute("cart", cart);
            
        }
        if(url.endsWith("addcart.htm"))
        {
            BookDao bd=(BookDao)getApplicationContext().getBean("bookdao");
            long bookid=Long.parseLong(request.getParameter("bookid"));
            String bookname=request.getParameter("bookname");
            User u=(User)session.getAttribute("loginuser");
            List cart=u.getCart();
            
            if(bd.getSingleBook(bookid)!=null)
            {
                Book book=bd.getSingleBook(bookid);
                cart.add(book);
                return new ModelAndView("Cart");
            }
            else
            {
                String error=bookname+" was not added to your cart successfully!";
                return new ModelAndView("Errorpage","error",error);
            }
        }
        if(url.endsWith("checkout.htm"))
        {
           User u=(User)session.getAttribute("loginuser");
           List cart=u.getCart();
           double total=0;
           for(int i=0;i<cart.size();i++)
           {
           Book k=(Book)cart.get(i);
           total+=k.getPrice();
           }
           session.setAttribute("total",total);
           return new ModelAndView("Orderpage","total",total);
        }
    return new ModelAndView("Errorpage");
    }
    
}
