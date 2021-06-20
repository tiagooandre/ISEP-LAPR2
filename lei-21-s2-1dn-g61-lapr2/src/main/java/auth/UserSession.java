package auth;

import auth.domain.model.Email;
import auth.domain.model.Password;
import auth.domain.model.User;
import auth.mappers.UserRoleMapper;
import auth.mappers.dto.UserRoleDTO;

import java.util.Collections;
import java.util.List;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class UserSession {

    private User user = null;

    public UserSession()
    {
        this.user = null;
    }

    public UserSession(User user)
    {
        if (user == null)
            throw new IllegalArgumentException("Argument cannot be null.");
        this.user = user;
    }

    public void doLogout()
    {
        this.user = null;
    }

    public boolean isLoggedIn()
    {
        return this.user != null;
    }

    public boolean isLoggedInWithRole(String roleId)
    {
        if (isLoggedIn())
        {
            return this.user.hasRole(roleId);
        }
        return false;
    }

    public String getUserName()
    {
        if (isLoggedIn())
            this.user.getName();
        return null;
    }

    public Email getUserId()
    {
        if (isLoggedIn())
            return this.user.getId();
        return null;
    }

    public Password getUserPassword()
    {
        if (isLoggedIn())
            return this.user.getPassword();
        return null;
    }

    public List<UserRoleDTO> getUserRoles()
    {
        if (isLoggedIn()) {
            UserRoleMapper mapper = new UserRoleMapper();
            return mapper.toDTO(this.user.getRoles());
        }
        return Collections.emptyList();
    }

    public void changeEmail(Email e){
        this.user.setId(e);
    }

    public void changePassword(Password p){
        this.user.setPassword(p);
    }
}
