package com.clover.springdemo.daoimpl;

import com.clover.springdemo.dao.CustomerDAO;
import com.clover.springdemo.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {
        Session session = sessionFactory.getCurrentSession();
        Query<Customer> theQuery = session.createQuery("select i from Customer i order by lastName", Customer.class);

        List<Customer> customers = theQuery.getResultList();

        return customers;
    }

    @Override
    public void saveCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(customer);
    }

    @Override
    public Customer getCustomer(int customerId) {
        Session session = sessionFactory.getCurrentSession();

        return session.get(Customer.class, customerId);
    }

    @Override
    public void deleteCustomer(int customerId) {
        Session session = sessionFactory.getCurrentSession();

        Query theQuery = session.createQuery("delete from Customer where id=:customerId");

        theQuery.setParameter("customerId", customerId);

        theQuery.executeUpdate();
    }

    @Override
    public List<Customer> searchCustomers(String theSearchName) {
        Session session = sessionFactory.getCurrentSession();

        Query<Customer> theQuery = null;

        if (theSearchName != null && theSearchName.trim().length() > 0) {
            theQuery = session.createQuery("from Customer i where lower(firstName) like :theName or lower(lastName) like :theName");
            theQuery.setParameter("theName", "%"+ theSearchName.toLowerCase() + "%");
        } else {
            theQuery = session.createQuery("from Customer i");
        }

        List<Customer> customers = theQuery.getResultList();

        return customers;
    }
}
