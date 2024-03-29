package com.codeclan_lab.coursebookingsystem.repositories.CustomerRepository;

import com.codeclan_lab.coursebookingsystem.helpers.Helper;
import com.codeclan_lab.coursebookingsystem.models.Customer;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepositoryCustom {

  @Autowired
  EntityManager entityManager;

  @Transactional
  public List<Customer> findCustomersByCourseId(Long courseId) {
    List<Customer> results = null;
    Session session = entityManager.unwrap(Session.class);
    try{
      Criteria cr = session.createCriteria(Customer.class);
      cr.createAlias("bookings", "bookingsAlias");
      cr.createAlias("bookingsAlias.course", "courseAlias");
      cr.add(Restrictions.eq("courseAlias.id", courseId));
      results = cr.list();
    } catch (HibernateException ex) {
      ex.printStackTrace();
    }
    return results;
  }

  @Transactional
  public List<Customer> findCustomersByTownAndCourseId(String town, Long courseId) {
    List<Customer> results = null;
    Session session = entityManager.unwrap(Session.class);

    town = Helper.capitalise(town);

    try{
      Criteria cr = session.createCriteria(Customer.class);
      cr.createAlias("bookings", "bookingsAlias");
      cr.createAlias("bookingsAlias.course", "courseAlias");
      cr.add(Restrictions.eq("courseAlias.id", courseId));
      cr.add(Restrictions.eq("town", town));

      results = cr.list();
    } catch (HibernateException ex) {
      ex.printStackTrace();
    }
    return results;
  }

  @Transactional
  public List<Customer> findCustomersByMinimumAgeTownAndCourseId(int age, String town, Long courseId) {
    List<Customer> results = null;
    Session session = entityManager.unwrap(Session.class);

    town = Helper.capitalise(town);

    try{
      Criteria cr = session.createCriteria(Customer.class);
      cr.createAlias("bookings", "bookingsAlias");
      cr.createAlias("bookingsAlias.course", "courseAlias");
      cr.add(Restrictions.eq("courseAlias.id", courseId));
      cr.add(Restrictions.eq("town", town));
      cr.add(Restrictions.gt("age", age));

      results = cr.list();
    } catch (HibernateException ex) {
      ex.printStackTrace();
    }
    return results;
  }

}
