package auth.domain.model;

import app.domain.model.Client;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.*;
import java.util.Objects;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class User implements Serializable {

    private Email id;
    private Password password;
    private String name;
    private Set<UserRole> roles = new HashSet<>();
    private final Map<String, Client> userMap = new HashMap<>();

    public User(Email id, Password pwd, String name)
    {
        if(StringUtils.isBlank((pwd.toString())) || StringUtils.isBlank((id.getEmail())) || StringUtils.isBlank(name))
            throw new IllegalArgumentException("User cannot have an id, password or name as null/blank.");

        this.id = id;
        this.password = pwd;
        this.name = name.trim();
    }

    public User(){}

    public Email getId() {
        return id;
    }

    public Password getPassword(){
        return password;
    }

    public Map<String, Client> getUserMap() {
        return userMap;
    }

    public void addUserMap(String u, Client c ) {

        this.userMap.put(u, c);

    }

    public String getName() {
        return name;
    }

    public boolean hasId(Email id)
    {
        return this.id.equals(id);
    }

    public boolean hasPassword(String pwd)
    {
        return this.password.checkPassword(pwd);
    }

    public boolean addRole(UserRole role)
    {
        if (role != null)
            return this.roles.add(role);
        return false;
    }

    public boolean removeRole(UserRole role)
    {
        if (role != null)
            return this.roles.remove(role);
        return false;
    }

    public boolean hasRole(UserRole role)
    {
        return this.roles.contains(role);
    }

    public boolean hasRole(String roleId)
    {
        for(UserRole role: this.roles)
        {
            if (role.hasId(roleId))
                return true;
        }
        return false;
    }

    public List<UserRole> getRoles()
    {
        List<UserRole> list = new ArrayList<>();
        for(UserRole role: this.roles)
            list.add(role);
        return Collections.unmodifiableList(list);
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 23 * hash + this.id.hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        // Inspired in https://www.sitepoint.com/implement-javas-equals-method-correctly/

        // self check
        if (this == o)
            return true;
        // null check
        if (o == null)
            return false;
        // type check and cast
        if (getClass() != o.getClass())
            return false;
        // field comparison
        User obj = (User) o;
        return Objects.equals(this.id, obj.id);
    }

    @Override
    public String toString()
    {
        return String.format("%s - %s - %s", this.id.toString(), this.name, this.password);
    }

    public void setId(Email e){
        this.id=e;
    }

    public void setPassword(Password p){
        this.password=p;
    }
}
