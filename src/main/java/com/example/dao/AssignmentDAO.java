package com.example.dao;

import com.example.model.AssignmentSubmission;
import com.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AssignmentDAO {

    public void save(AssignmentSubmission sub) {
        Transaction tx = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(sub);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e; // rethrow so Struts can catch
        } finally {
            if (session != null) session.close();
        }
    }

    @SuppressWarnings("unchecked")
    public List<AssignmentSubmission> findAll() {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            return session.createQuery("from AssignmentSubmission order by id desc").list();
        } finally {
            if (session != null) session.close();
        }
    }
}
