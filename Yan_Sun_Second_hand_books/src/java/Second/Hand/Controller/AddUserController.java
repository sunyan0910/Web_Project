/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Second.Hand.Controller;


import Pojos.User;
import Second.Hand.Dao.BookDao;
import Second.Hand.Dao.UserDao;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author sunyan
 */
public class AddUserController extends AbstractController {
    
    public AddUserController() {
    }
    
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request,HttpServletResponse response) throws Exception {
        
        BookDao bd=(BookDao)getApplicationContext().getBean("bookdao");
        UserDao ud=(UserDao)getApplicationContext().getBean("userdao");
        String fName=request.getParameter("fName");
        String lName=request.getParameter("lName");
        String pwd=request.getParameter("pwd");
        String email=request.getParameter("email");
        if(ud.getUser(email)==null)
        {
            User u=new User();
            Date date=new Date();
            String registerDate=date.toString();
            u.setDate(registerDate);
            u.setfName(fName);
            u.setlName(lName);
            u.setPwd(pwd);
            u.setEmail(email);
            
            if(ud.createUser(u)==1)
            {
                SendEmail(u);
                return new ModelAndView("Welcome_page");
            }
            else
            {
                String error="Fail to register, please try again later!";
                return new ModelAndView("Errorpage","error",error);
            }
        }
        else
        {
        String error="You have already registered";
        return new ModelAndView("Errorpage","error",error);
        }
    }
    public void SendEmail(User user) throws EmailException 
    {
	Email email = new SimpleEmail();
	email.setHostName("smtp.googlemail.com");
	email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator("sun.yan3@husky.neu.edu", "2224246323Ishida"));
        email.setSSLOnConnect(true);
	email.setFrom("sun.yan3@husky.neu.edu");
	email.setSubject("Registered Sucessfully!");
	email.setMsg("Hi,"+user.getfName()+":\n\n"
                + "You have registered successfully!\n"
                + "Thank you for your time.\n\n\n\n"
                + "Second Hand Book Store ^_^"
        );
	email.addTo(user.getEmail());
	email.send();
    }
}
