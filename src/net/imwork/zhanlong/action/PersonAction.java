package net.imwork.zhanlong.action;

import com.opensymphony.xwork2.ActionSupport;
import net.imwork.zhanlong.model.Person;
import net.imwork.zhanlong.service.PersonService;
import net.imwork.zhanlong.service.impl.PersonServiceImpl;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.List;

/**
 * @author 展龙
 */
public class PersonAction extends ActionSupport
{
    private int id;
    private String username;
    private String password;
    private int age;
    private Date registerDate;

    private PersonService personService = new PersonServiceImpl();

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public Date getRegisterDate()
    {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate)
    {
        this.registerDate = registerDate;
    }

    public String savePerson() throws Exception
    {
        Person person = new Person();
        person.setUsername(username);
        person.setPassword(password);
        person.setAge(age);

        java.sql.Date registerDate = new java.sql.Date(new java.util.Date().getTime());
        person.setRegisterDate(registerDate);

        personService.savePerson(person);

        HttpServletRequest request = ServletActionContext.getRequest();

        request.getSession().setAttribute("p","hello");

        return SUCCESS;
    }

    public String listAllPersons() throws Exception
    {
        List<Person> list = personService.listAllPersons();

        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("list", list);
        return SUCCESS;
    }

    public String getSinglePerson()
    {
        Person person = personService.getSinglePersonById(id);

        ServletActionContext.getRequest().setAttribute("person", person);

        return SUCCESS;
    }

    public String deletePerson() throws Exception
    {
        personService.deletePerson(id);

        return "success";
    }

    public String updatePerson() throws Exception
    {
        Person person = personService.getSinglePersonById(id);
        person.setPassword(password);
        person.setAge(age);
        person.setRegisterDate(registerDate);
        personService.updatePerson(person);

        return "success";
    }
}
