/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Pojos.Book;
import Pojos.User;
import com.lowagie.text.Paragraph;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.view.document.AbstractPdfView;

/**
 *
 * @author sunyan
 */
public class PdfView extends AbstractPdfView{

    private double total;
    private List items;
    public PdfView(double total,List items) {
        this.total=total;
        this.items=items;
    }

    @Override
    protected void buildPdfDocument(Map<String, Object> map, com.lowagie.text.Document pdfdoc,com.lowagie.text.pdf.PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session=request.getSession();
        
        
        String date=new Date().toString();
        User u=(User)session.getAttribute("loginuser");
        
        Paragraph p1=new Paragraph("Hi, "+u.getfName());
        Paragraph p6=new Paragraph("This is you order detail:");
        Paragraph p2=new Paragraph("Order created at:"+date);
        pdfdoc.add(p1);
        pdfdoc.add(p6);
        pdfdoc.add(p2);
        for(Object i:items)
        {
            Book b=(Book)i;
            Paragraph p3=new Paragraph("Book name:"+b.getName()+"   Price:"+b.getPrice());
            Paragraph p4=new Paragraph("--------------------------------------------------------------------------------------------------------------");
            pdfdoc.add(p3);
            pdfdoc.add(p4);
        }
        
        
        Paragraph p5=new Paragraph("Total Price:"+String.valueOf(total));
        pdfdoc.add(p5);
    }
    
}
