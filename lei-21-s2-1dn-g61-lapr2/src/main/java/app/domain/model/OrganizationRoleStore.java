package app.domain.model;

import java.util.*;

public class OrganizationRoleStore {

    private List<OrganizationRole> organizationRoleList;

    public OrganizationRoleStore() {
        this.organizationRoleList = new ArrayList<>();
    }

    public OrganizationRole create(String id, String description, String className) {
        return new OrganizationRole(id,description, className);
    }

    public boolean addOrganizationRole(String id, String description, String className) {
        OrganizationRole role = create(id, description, className);
        if (role != null && !exists(role)) {
                return this.organizationRoleList.add(role);
        }
        return false;
    }

    public boolean remove(OrganizationRole role) {
        if (role != null)
            return this.organizationRoleList.remove(role);
        return false;
    }

    public OrganizationRole getRoleById(String id) {
        for(OrganizationRole role: this.organizationRoleList) {
            if(role.hasId(id))
                return role;
        }
        return null;
    }

    public boolean exists(String id) {
        return getRoleById(id) != null;
    }

    public boolean exists(OrganizationRole role) {
        return this.organizationRoleList.contains(role);
    }

    /**
     * @return the list of organization roles
     */
    public List<OrganizationRole> getRoles(){
        return this.organizationRoleList;
    }

}
