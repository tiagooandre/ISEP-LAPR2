package app.domain.model;

import app.mappers.dto.EmployeeDTO;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Objects;

import static java.lang.System.*;

public class OrganizationRole {

    private String id;
    private String description;
    private String className;

    public OrganizationRole(String id, String description, String className) {
        if (StringUtils.isBlank(id) || StringUtils.isBlank(description) || StringUtils.isBlank(className))
            throw new IllegalArgumentException("Organization role id and/or description and/or name or class name cannot be blank.");
        if (id.length()>15) 
            throw new IllegalArgumentException("Id cannot have more than 15 characters.");
        this.id = extractId(id);
        this.description = description;
        this.className = className;
    }

    public Employee createEmployee(EmployeeDTO empDTO) {
        Object emp1 = null;
        try {
            Class<?> c = Class.forName(className);
            Constructor[] ctorlist = c.getDeclaredConstructors();
            Constructor<?> ctl = ctorlist[0];
            Class[] pvec = ctl.getParameterTypes();
            //pvec has the Types of each attribute
            Object[] arglist = new Object[7];
            arglist[0] = this;
            arglist[1] = empDTO.getName();
            arglist[2] = empDTO.getAddress();
            arglist[3] = empDTO.getPhoneNumber();
            arglist[4] = empDTO.getEmail();
            arglist[5] = empDTO.getCodeSOC();
            arglist[6] = empDTO.getDoctorIndexNumber();
            Object[] arglist2 = Arrays.copyOf(arglist, pvec.length);
            emp1 = ctl.newInstance(arglist2);

        } catch (IllegalAccessException e) {
            out.println("I don't have access to that method.");
        } catch (InstantiationException e) {
            out.println("It wasn't possible to create an employee object.");
        } catch (InvocationTargetException e) {
            throw new IllegalArgumentException(e.getTargetException().getMessage());
        } catch (ClassNotFoundException e) {
            out.println("Class not found.");
        }
        return (Employee) emp1;
    }



    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    private String extractId(String id) {
        return id.trim().toUpperCase();
    }

    public boolean hasId(String id)
    {
        if (StringUtils.isBlank(id))
            return false;
        return this.id.equals(extractId(id));
    }

    @Override
    public boolean equals(Object o) {
        // null check
        if (o == null)
            return false;
        // self check
        if (this == o)
            return true;
        // type check and cast
        if (getClass() != o.getClass())
            return false;
        // field comparison
        OrganizationRole obj = (OrganizationRole) o;
        return Objects.equals(this.id, obj.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, className);
    }

    @Override
    public String toString() {      
        return String.format("Id: %s    Description: %s", this.id, this.description);
    }
    
}
