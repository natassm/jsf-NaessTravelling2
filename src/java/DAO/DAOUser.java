/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.NewHibernateUtil;
import POJO.TblUser;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Natasha
 */
public class DAOUser {
    
    public List<TblUser>getBy(String username, String password){
        {
            TblUser tblUser = new TblUser();
            List<TblUser> user = new ArrayList();
            
            Transaction trans = null;
            Session session = NewHibernateUtil.getSessionFactory().openSession();
            
            try{
                trans = session.beginTransaction();
                Query query = session.createQuery("from TblUser where "
                        + "username =:username AND password =:password");
                query.setString("username", username);
                query.setString("password", password);
                user = query.list();
                
                trans.commit();
            } catch(Exception e) {
                System.out.println("Error " + e);
            }
            return user;
        }
    }
    
    
    public void addNewUser(TblUser tblUser) {
        Transaction trans = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try{
            trans = session.beginTransaction();
            session.save(tblUser);
            trans.commit();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public List<TblUser> showUser() {
        Transaction trans = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        List listUser = new ArrayList();
        
        try{
            trans = session.beginTransaction();
            Query query = session.createQuery("from TblUser");
            listUser = query.list();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            trans.commit();
        }
        return listUser;
    }
    
    public void deleteU(String idUser) {
        
        Transaction trans = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        
        try{
            trans = session.beginTransaction();
            TblUser tblUser = (TblUser) session.load(TblUser.class, new String(idUser));
            session.delete(tblUser);
            trans.commit();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public List<TblUser> getbyID(String idUser) {
        
        TblUser user = new TblUser();
        List<TblUser> listUser = new ArrayList();
        
        Transaction trans = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try{
            trans = session.beginTransaction();
            Query query = session.createQuery("from TblUser where id_user = :id");
            query.setString("id", idUser);
//            plg = (TblKaryawan) query.uniqueResult();
            listUser = query.list();
            trans.commit();
        } catch(Exception ex){
            System.out.println("Error " + ex);
        }
        return listUser;
    }
    
    public void updateU(TblUser tblUser) {
        Transaction trans = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        
        try{
            trans = session.beginTransaction();
            session.update(tblUser);
            trans.commit();
            
        }catch(Exception ex){
            
        }
    }
    
}
