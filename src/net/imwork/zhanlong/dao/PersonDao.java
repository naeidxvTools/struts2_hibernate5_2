package net.imwork.zhanlong.dao;

import net.imwork.zhanlong.model.Person;

import java.util.List;

/**
 * @author 展龙
 */
public interface PersonDao
{
    /**
     * 保存person
     * @param person:
     *
     */
    void savePerson(Person person);

    /**
     * 显示所有person
     * @return 无参数
     */
    List<Person> listAllPersons();

    /**
     * 删除
     * @param id
     */
    void deletePerson(int id);

    /**
     * 得到
     * @param id
     * @return
     */
    Person getSinglePersonById(int id);

    /**
     * dd
     * @param person
     */
    void updatePerson(Person person);
}
