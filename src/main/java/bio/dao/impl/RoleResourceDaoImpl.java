/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bio.dao.impl;

import bio.dao.RoleResourceDao;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import bio.util.DBUtil;
import bio.po.Resource;
import bio.po.Role;

/**
 *
 * @author fafa
 */
public class RoleResourceDaoImpl implements RoleResourceDao {

    private DBUtil dbutil = new DBUtil();

    public boolean delRole(String role_id) {    //顺便删除资源
        boolean flag = false;
        String sql = "delete from  Role_resource where role_id='" + role_id + "'";
        try {
            flag = dbutil.executeUpdateSQL(sql);
        } catch (Exception ex) {
            Logger.getLogger(UserRoleDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

    public boolean addRoleResource(String role_id, String resource_id) {  //父角色中有该资源
        boolean flag = false;
        RoleDaoImpl dao = new RoleDaoImpl();
        Role role = dao.viewRole(role_id);
        String role_father = role.getRole_father_id();
        if (role_father.equals("SA") || isHaveResource(role_father, resource_id)) {
            String sql = "insert into Role_resource(role_id,res_id) values (?,?)";
            try {
                Object[] params = new Object[]{role_id, resource_id};
                 flag = dbutil.executeSQLwithParams(sql, params);
            } catch (Exception ex) {
                System.out.println(ex.getLocalizedMessage());
            }
        }else{
            System.out.println("the father role doesn't have the resource");
        }
        return flag;
    }

    public boolean delRoleResource(String role_id, String resource_id) { //级联删除子角色
        boolean flag = false;
        RoleDaoImpl dao = new RoleDaoImpl();
        List<Role> list = dao.viewAllSubRole(role_id);
        
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            buffer.append(list.get(i).getRole_id()).append("','");
        }
        buffer.deleteCharAt(buffer.length() - 1);buffer.deleteCharAt(buffer.length() - 1);
        String sql = "delete  from  Role_resource  where res_id= '"+resource_id+"'and role_id in  ('" + buffer.toString() + ")";
        try {
            flag = dbutil.executeUpdateSQL(sql);
        } catch (Exception ex) {
            System.out.println(ex.getLocalizedMessage());
        }
        return flag;
    }

    public List<Resource> viewResources(String role_id) {
        String sql = "select res_id from Role_resource where role_id = '"+role_id+"'";
        List<Map> listall = null;
        List<Resource> list = new ArrayList<Resource>();
        try {
            listall = dbutil.getObjectList(sql, null);
            ResourceDaoImpl dao = new ResourceDaoImpl();
            for (int i = 0; i < listall.size(); i++) {
                Resource role = dao.viewResource((String) listall.get(i).get("res_id"));
                list.add(role);
            }
        } catch (Exception ex) {
            System.out.println(ex.getLocalizedMessage());
        }
        return list;
    }

    public boolean isHaveResource(String role_id, String resource_id) {
        boolean flag = false;
        List<Resource> list = viewResources(role_id);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getRes_id().equals(resource_id)) {
                flag = true;
            }
        }
        return flag;
    }

    public int countResourceRole(String resource_id) {
        String sql = "select * from Role_resource where res_id=?";
        int count = 0;
        try {
            Object[] params = new Object[]{resource_id};
            count = dbutil.getRowCount(sql, params);
        } catch (Exception ex) {
            Logger.getLogger(UserRoleDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }

    public boolean addRoleResource(String role_id, List<String> resource_id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean delRoleResource(String role_id, List<String> resource_id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
