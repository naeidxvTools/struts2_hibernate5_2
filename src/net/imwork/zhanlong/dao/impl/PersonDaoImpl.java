package net.imwork.zhanlong.dao.impl;

import net.imwork.zhanlong.dao.PersonDao;
import net.imwork.zhanlong.model.Person;
import net.imwork.zhanlong.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

/**
 * @author 展龙
 */
public class PersonDaoImpl implements PersonDao
{

    @Override
    public void savePerson(Person person)
    {
        Session session = HibernateUtil.getCurrentSession();
        session.save(person);
    }

    @Override
    public List<Person> listAllPersons()
    {
        Session session = HibernateUtil.getCurrentSession();
        // 在HQL中,Person是类的名字，不是表的名字，既然是类的名字，就要严格区分大小写。
        Query query = session.createQuery("from net.imwork.zhanlong.model.Person");
        List<Person> list = query.list();
        return list;
    }

    @Override
    public Person getSinglePersonById(int id)
    {
        Session session = HibernateUtil.getCurrentSession();

        Person person = session.get(Person.class, id);

        return person;
    }

    @Override
    public void deletePerson(int id)
    {
        Session session = HibernateUtil.getCurrentSession();
        Person person = session.get(Person.class, id);
        session.delete(person);
    }

    @Override
    public void updatePerson(Person person)
    {
        Session session = HibernateUtil.getCurrentSession();
        session.update(person);
    }
}
