package ua.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.entity.Employee;

import java.util.List;
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    @Autowired
    private SessionFactory factory;

    @Override
    public List<Employee> getAllEmployees() {
        Session session = factory.getCurrentSession();
        List<Employee> allEmployees=session.createQuery("from Employee "
                ,Employee.class).getResultList();
        return allEmployees;
    }

    @Override
    public void saveEmployee(Employee employee) {
        Session session=factory.getCurrentSession();

        session.saveOrUpdate(employee);
    }

    @Override
    public Employee getEmployee(int id) {
        Session session=factory.getCurrentSession();
       var emp= session.get(Employee.class,id);
       return emp;


    }

    @Override
    public void deleteEmployee(int id) {
        Session session=factory.getCurrentSession();
       var emp= session.get(Employee.class,id);
       session.delete(emp);
    }
}
