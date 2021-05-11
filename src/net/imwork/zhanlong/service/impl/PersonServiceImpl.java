package net.imwork.zhanlong.service.impl;

import net.imwork.zhanlong.dao.PersonDao;
import net.imwork.zhanlong.dao.impl.PersonDaoImpl;
import net.imwork.zhanlong.model.Person;
import net.imwork.zhanlong.service.PersonService;
import net.imwork.zhanlong.util.HibernateUtil;
import org.hibernate.Transaction;

import java.util.List;

/**
 * @author 展龙
 */
public class PersonServiceImpl implements PersonService
{
    private PersonDao personDao = new PersonDaoImpl();

    @Override
    public void savePerson(Person person)
    {
        /**
         * struts2与hibernate5整合的事务应该放到service中。2021年05月04月 14：26:45
         */
        Transaction tx = null;

        try
        {
            tx = HibernateUtil.getCurrentSession().getTransaction();
            tx.begin();

            personDao.savePerson(person);

            tx.commit();

        } catch (Exception e)
        {
            if (null != tx)
            {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public List<Person> listAllPersons()
    {
        Transaction tx = null;
        List<Person> persons = null;
        try
        {
            tx = HibernateUtil.getCurrentSession().beginTransaction();
            persons = personDao.listAllPersons();

            tx.commit();
        } catch (Exception e)
        {
            if (null != tx)
            {
                tx.rollback();
            }
            e.printStackTrace();
        }

        return persons;
    }

    @Override
    public void deletePerson(int id)
    {
        Transaction tx = null;

        try
        {
            tx = HibernateUtil.getCurrentSession().beginTransaction();
            personDao.deletePerson(id);
            tx.commit();
        } catch (Exception e)
        {
            if (null != tx)
            {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public Person getSinglePersonById(int id)
    {
        Transaction tx = null;
        Person person = null;
        try
        {
            tx = HibernateUtil.getCurrentSession().beginTransaction();

            person = personDao.getSinglePersonById(id);

            tx.commit();
        } catch (Exception e)
        {
            if (null != tx)
            {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return person;
    }

    @Override
    public void updatePerson(Person person)
    {
        Transaction tx = null;

        try
        {
            tx = HibernateUtil.getCurrentSession().beginTransaction();
            personDao.updatePerson(person);
            tx.commit();
        } catch (Exception e)
        {
            if (null != tx)
            {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }
}
