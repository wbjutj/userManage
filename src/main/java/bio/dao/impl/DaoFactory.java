/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bio.dao.impl;

import bio.dao.*;

/**
 *
 * @author fafa
 */
public class DaoFactory {

    public ResourceDao CreatResourceDao() {
        return new ResourceDaoImpl();
    }

    public RoleDao CreatRoleDao() {
        return new RoleDaoImpl();
    }

    public RoleResourceDao CreatRoleResourceDao() {
        return new RoleResourceDaoImpl();
    }

    public UserRoleDao CreatUserRoleDao() {
        return new UserRoleDaoImpl();
    }

    public UserSystemDao CreatUserSystemDao() {
        return new UserSystemDaoImpl();
    }
}
