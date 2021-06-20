package app.mappers;

import app.mappers.dto.OrganizationRoleDTO;
import app.domain.model.OrganizationRole;

import java.util.ArrayList;
import java.util.List;

public class RolesMapper {

    public OrganizationRoleDTO toDTO(OrganizationRole role) {
        return new OrganizationRoleDTO(role.getId(),role.getDescription());
    }

    public List<OrganizationRoleDTO> toDTO(List<OrganizationRole> roles) {
        List<OrganizationRoleDTO> rolesDTO = new ArrayList<>();
        for(OrganizationRole role : roles) {
            rolesDTO.add(this.toDTO(role));
        }
        return rolesDTO;
    }
}
