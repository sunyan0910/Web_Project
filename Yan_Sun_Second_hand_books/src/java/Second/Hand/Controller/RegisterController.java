/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Second.Hand.Controller;

import Pojos.User;
import Second.Hand.Dao.UserDao;
import java.io.File;

import org.apache.commons.mail.*;
import java.sql.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 *
 * @author sunyan
 */
public class RegisterController extends SimpleFormController {
    
    public RegisterController() {

        setCommandClass(User.class);
        setCommandName("user");
        setSuccessView("Homepage");
        setFormView("Registerpage");
    }
    
    /*@Override
    protected void doSubmitAction(Object command) throws Exception {
        throw new UnsupportedOperationException("Not yet implemented");
    }*/
    
    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
        User u=(User)command;
        String locaLpath="/Users/sunyan/Desktop/images";
        UserDao ud=(UserDao)getApplicationContext().getBean("userdao");
        
        if(ud.getUser(u.getEmail())==null)
        {
//            String photoOrgininalName = u.getPhoto().getOriginalFilename();
//            String[] picNameArray = photoOrgininalName.split("\\.");
//            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//            String picNewname = picNameArray[0]+timestamp.getTime()+"";
//            u.getPhoto().transferTo(new File(locaLpath, picNewname+"."+picNameArray[picNameArray.length - 1]));
//            u.setImageName(locaLpath+"\\"+picNewname+"."+picNameArray[picNameArray.length - 1]);

            if(ud.createUser(u)==1)
            {
                HttpSession session=request.getSession();
                session.setAttribute("loginuser", u);
                SendEmail(u);
                return new ModelAndView(getSuccessView(),"user",u);
            }
            else
            {
                String error="Fail to register, please try again later!";
                return new ModelAndView("Errorpage","error",error);
            }
        }
        else
        {
            String error="You have already registered!";
            return new ModelAndView("Errorpage","error",error);
        }
    }

//    @Override
//    protected ModelAndView onSubmit(
//            HttpServletRequest request, 
//            HttpServletResponse response, 
//            Object command, 
//            BindException errors) throws Exception {
//        User user=(User)command;
//        Product product=(Product)getApplicationContext().getBean("product");
//        String message ="Welcome home, "+user.getFirstName()+" needs some "+product.getName();
//        ModelAndView mv = new ModelAndView(getSuccessView(),"message",message);
//        //Do something...
//        return mv;
//    }
    private void SendEmail(User u) throws EmailException {
	Email email = new SimpleEmail();
        email.setHostName("smtp.googlemail.com");
	email.setSmtpPort(465);
	email.setAuthenticator(new DefaultAuthenticator("sun.yan3@husky.neu.edu", "4246323Ichigo!"));
	email.setSSLOnConnect(true);
	email.setFrom("sun.yan3@husky.neu.edu");
	email.setSubject("TestMail");
	email.setMsg("This is a test mail ... :-)");
	email.addTo(u.getEmail());
	email.send();
	}
}
