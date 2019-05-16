/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Second.Hand.Controller;

import Pojos.Book;
import Pojos.User;
import Second.Hand.Dao.BookDao;
import View.PdfView;
import com.lowagie.text.Paragraph;
import java.util.ArrayList;
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
public class OrderPdfController extends AbstractController {
    
    public OrderPdfController() {
    }
    
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request,HttpServletResponse response) throws Exception {

        HttpSession session=request.getSession();
        User u=(User)session.getAttribute("loginuser");
        BookDao bd=(BookDao)getApplicationContext().getBean("bookdao");
        u.getCart();
        for(Object i:u.getCart())
        {
            Book b=(Book)i;
            b.getBookId();
            bd.soldBook(b.getBookId());
        }
        
        PdfView pdf=new PdfView((double)session.getAttribute("total"),u.getCart());
        List cart=new ArrayList();
        u.setCart(cart);
        return new ModelAndView(pdf);
    }
    
}
