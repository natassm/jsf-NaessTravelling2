/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.NewHibernateUtil;
import POJO.TblBooking;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Natasha
 */
public class DAOBooking {
    
    public void addNewBooking(TblBooking tblBooking) {
        Transaction trans = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try{
            trans = session.beginTransaction();
            session.save(tblBooking);
            trans.commit();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public List<TblBooking> showBooking() {
        Transaction trans = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        List listBooking = new ArrayList();
        
        try{
            trans = session.beginTransaction();
            Query query = session.createQuery("from TblBooking");
            listBooking = query.list();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            trans.commit();
        }
        return listBooking;
    }
    
}
