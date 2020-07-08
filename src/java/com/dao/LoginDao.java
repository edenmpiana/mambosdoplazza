/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.pojo.User;
import com.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author mariompi
 */
public class LoginDao {
    
    public boolean checkUserDao ( String username, String password)
    {
        
        try 
        {
        
        //openning the session that contains DB Connection
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String hql = "from User u where u.username=:username and u.password=:password";
        Query query = session.createQuery(hql);
        query.setParameter("username", username);
        query.setParameter("password", password);
        List list = query.list();
        System.out.println("list size "+list.size());
        if (list.size()==1)
        {
            return true;
        }
        else
        {
            return false;
        }
        }
        catch (HibernateException ex)
        {
            System.out.println(ex);
        }
        return  false ;    

    }
    
}
