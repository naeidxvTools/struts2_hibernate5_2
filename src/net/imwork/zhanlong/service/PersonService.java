package net.imwork.zhanlong.service;

import net.imwork.zhanlong.model.Person;

import java.util.List;

/**
 * @author 展龙
 */
public interface PersonService
{
    /**
     * 保存Person
     * @param person 传入Person类型
     */
    void savePerson(Person person);

    /**
     * 显示所有Person信息
     * @return 五参数
     */
    List<Person> listAllPersons();

    /**
     * 删除一个成员
     * @param id
     */
    void deletePerson(int id);

    /**
     * 根据id查询一个人
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
