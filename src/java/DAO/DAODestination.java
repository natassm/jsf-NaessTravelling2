/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import POJO.NewHibernateUtil;
import POJO.TblDestination;
/**
 *
 * @author Natasha
 */
public class DAODestination {
    public void addDestination(TblDestination des){
        Transaction trans = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            session.save(des);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public List<TblDestination> retrieveTblDestination(){
        List stud = new ArrayList();
        TblDestination stud1 = new TblDestination();
        Transaction trans = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from tbl_destination");
            stud = query.list();
            stud.add(stud1.getName());
            stud.add(stud1.getPrice());
            stud.add(stud1.getFacilites());
            stud.add(stud1.getAdditionalInfo());
            trans.commit();
        } catch (Exception e) {
            
        } return stud;
    }
    
    public List<TblDestination>getByID(String tbD){
        {
            TblDestination Des = new TblDestination();
            List<TblDestination> dest = new ArrayList();
            
            Transaction trans = null;
            Session session = NewHibernateUtil.getSessionFactory().openSession();
            
            try{
                trans = session.beginTransaction();
                Query query = session.createQuery("from tbl_destination where id_destination = :id");
                query.setString("id", tbD);
                Des = (TblDestination) query.uniqueResult();
                dest = query.list();
                trans.commit();
            } catch(Exception e) {
                System.out.println("Error " + e);
            }
            return dest;
        }
    }
    
    
   
    
    public List<TblDestination> showDestination() {
        Transaction trans = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        List listDestination = new ArrayList();
        
        try{
            trans = session.beginTransaction();
            Query query = session.createQuery("from tbl_destination");
            listDestination = query.list();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            trans.commit();
        }
        return listDestination;
    }
    
    public void deleteDestination(String idDest) {
        
        Transaction trans = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        
        try{
            trans = session.beginTransaction();
            TblDestination tblDestination = (TblDestination) session.load(TblDestination.class, 
                    new String(idDest));
            session.delete(tblDestination);
            trans.commit();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    
    
    
    public void updateDestination(TblDestination tblDes) {
        Transaction trans = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        
        try{
            trans = session.beginTransaction();
            session.update(tblDes);
            trans.commit();
            
        }catch(Exception ex){
            
        }
    }
    
}
