package com.ehealth.controller;

import com.ehealth.entities.Citizen;
import com.ehealth.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author hirwa
 */
public class CitizenDao {
    public void create(Citizen ctz){
        Session ss = HibernateUtil.getSessionFactory().openSession();
        ss.beginTransaction();
        ss.save(ctz);
        ss.getTransaction().commit();
        ss.close();
    }
    public void update(Citizen ctz){
        Session ss = HibernateUtil.getSessionFactory().openSession();
        ss.beginTransaction();
        ss.update(ctz);
        ss.getTransaction().commit();
        ss.close();
    }
    public void delete(Citizen ctz){
        Session ss = HibernateUtil.getSessionFactory().openSession();
        ss.beginTransaction();
        ss.delete(ctz);
        ss.getTransaction().commit();
        ss.close();
    }
    
    public Citizen findCitizenById(String nid){
        Session ss = HibernateUtil.getSessionFactory().openSession();
        Citizen ctz = (Citizen)ss.get(Citizen.class, nid);
        ss.close();
        return ctz;
    }
    
    public List<Citizen> findAllCitizens(){
        Session ss = HibernateUtil.getSessionFactory().openSession();
        Query query = ss.createQuery("FROM Citizen c");
        List<Citizen> citizenList = query.list();
        ss.close();
        return citizenList;
    }
}
