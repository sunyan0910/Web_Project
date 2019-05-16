/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Second.Hand.Controller;

import Second.Hand.Dao.BookDao;
import Pojos.Book;
import Pojos.User;
import java.util.Date;
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
public class BookController extends AbstractController {
    
    public BookController() {
    }
    
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request,HttpServletResponse response) throws Exception {
        HttpSession session=request.getSession();
        String url=request.getRequestURI();
        User user=(User) session.getAttribute("loginuser");
//        System.out.println("User email:"+user.getEmail());
        
        
        if(url.endsWith("submitbook.htm"))
        {
            String name=request.getParameter("name");
            String category=request.getParameter("category");
            String description=request.getParameter("description");
            double price=Double.parseDouble(request.getParameter("price"));
            String author=request.getParameter("author");
            Book book=new Book(name,price,author,description,category);
            String date=new Date().toString();
            book.setOwner(user);
            book.setStatus("Available");
            book.setDate(date);
            BookDao bd=(BookDao)getApplicationContext().getBean("bookdao");
            if(bd.AddBook(book)==1)
            {
                //session.setAttribute("user", user);
                String from="add";
                request.setAttribute("from", from);
                return new ModelAndView("BookDetailPage");
            }
            else
            {
                String error="Your book didn't add successflly!";
                return new ModelAndView("Errorpage","error",error);
            }
        }
        else if(url.endsWith("submitupdatebook.htm"))
        {
            Book b=(Book)session.getAttribute("thisbook");
            long bookid=b.getBookId();
            String name=request.getParameter("name");
            String category=request.getParameter("category");
            String description=request.getParameter("description");
            double price=Double.parseDouble(request.getParameter("price"));
            String author=request.getParameter("author");
            BookDao bd=(BookDao)getApplicationContext().getBean("bookdao");
            if(bd.UpdateBook(name, author, description, category, price,bookid)==1)
            {
                String query ="from Book";
                List books=bd.getBooks(query);
                
                return new ModelAndView("Homepage","bookList",books);
            }
            else
            {
                String error="Your book didn't update successflly!";
                return new ModelAndView("Errorpage","error",error);
            }
        }
        else
        {
        return new ModelAndView("Errorpage");
        }
    }
    
}
