/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bio.dao.impl;

import bio.dao.RoleDao;
import java.util.ArrayList;
import java.util.List;
import bio.util.*;
import bio.po.Role;
import java.util.Map;

/**
 *
 * @author fafa
 */
public class RoleDaoImpl implements RoleDao {

    private DBUtil dbutil = new DBUtil();

    public boolean addRole(Role role) {
        boolean flag = false;
        String role_id = role.getRole_id();
        String role_name = role.getRole_name();
        int role_type = role.getRole_type();
        String role_description = role.getRole_description();
        String role_father_id = role.getRole_father_id();
        String sql = "insert into Role(role_id,role_name,role_father_id,role_description,role_type) values (?,?,?,?,?)";
        try {
            Object[] params = new Object[]{role_id, role_name, role_father_id, role_description, role_type};
            flag = dbutil.executeSQLwithParams(sql, params);
        } catch (Exception ex) {
            System.out.println(ex.getLocalizedMessage());
        }
        return flag;
    }

    public boolean delRole(String role_id) {
        boolean flag = false;
        String sql = "delete  from Role where role_id='" + role_id + "'";
        UserRoleDaoImpl urdao = new UserRoleDaoImpl();
        if (urdao.countUser(role_id) == 0) {
            try {
                flag = dbutil.executeUpdateSQL(sql);
                if (flag == true) {
                    RoleResourceDaoImpl dao = new RoleResourceDaoImpl();
                    dao.delRole(role_id);
                } else {
                    System.out.println("the role delete faile");
                }
            } catch (Exception ex) {
                System.out.println(ex.getLocalizedMessage());
            }
        } else {
            System.out.println("the role is  used");
        }
        return flag;
    }

    public boolean existRole(String role_id) {
        boolean flag = false;
        int count = 0;
        String sql = "select * from Role  where role_id='" + role_id + "'";
        try {
            count = dbutil.getRowCount(sql, null);
            if (count != 0) {
                flag = true;
            }
        } catch (Exception ex) {
            System.out.println(ex.getLocalizedMessage());
        }
        return flag;
    }

    public List<Role> viewSubRole(String role_id) {
        String sql = "select * from Role where role_father_id = '" + role_id + "'";
        List<Map> listall = null;
        List<Role> list = new ArrayList<Role>();
        try {
            listall = dbutil.getObjectList(sql, null);
            for (int i = 0; i < listall.size(); i++) {
                Role role = new Role();
                role = (Role) Map2Bean.convertMapToBean(role, listall.get(i));
                list.add(role);
            }
        } catch (Exception ex) {
            System.out.println(ex.getLocalizedMessage());
        }
        if (list.size() == 0) {
            list = null;
        }
        return list;
    }

    public List<Role> viewSubAdminRole(String role_id) {
        String sql = "select * from Role where role_father_id = ? and role_type = ?";
        List<Map> listall = null;
        List<Role> list = new ArrayList<Role>();
        try {
            Object[] params = new Object[]{role_id, 2};
            listall = dbutil.getObjectList(sql, params);
            for (int i = 0; i < listall.size(); i++) {
                Role role = new Role();
                role = (Role) Map2Bean.convertMapToBean(role, listall.get(i));
                list.add(role);
            }
        } catch (Exception ex) {
            System.out.println(ex.getLocalizedMessage());
        }
        if (list.size() == 0) {
            list = null;
        }
        return list;
    }

    public List<Role> viewSubUserRole(String role_id) {
        String sql = "select * from Role where role_father_id = ? and role_type = ?";
        List<Map> listall = null;
        List<Role> list = new ArrayList<Role>();
        try {
            Object[] params = new Object[]{role_id, 3};
            listall = dbutil.getObjectList(sql, params);
            for (int i = 0; i < listall.size(); i++) {
                Role role = new Role();
                role = (Role) Map2Bean.convertMapToBean(role, listall.get(i));
                list.add(role);
            }
        } catch (Exception ex) {
            System.out.println(ex.getLocalizedMessage());
        }
        if (list.size() == 0) {
            list = null;
        }
        return list;
    }

    public Role viewRole(String role_id) {
        String sql = "select * from Role where role_id='" + role_id + "'";
        Role role = new Role();
        try {
            Map map = dbutil.getUniqueObject(sql);
            role = (Role) Map2Bean.convertMapToBean(role, map);
        } catch (Exception ex) {
            System.out.println(ex.getLocalizedMessage());
        }
        return role;
    }

    public List<Role> viewAllSubRole(String role_id) {  //viwe all the sub role include itself
        List<Role> listall = new ArrayList<Role>();     
        List<Role> listsub = viewSubRole(role_id);
  
        if (listsub != null) {
            for (int i = 0; i < listsub.size(); i++) {
                List<Role> list = viewAllSubRole(listsub.get(i).getRole_id());
                listall.addAll(list);
            }
        }
         listall.add(viewRole(role_id));     
        return listall;//at least one role ,itself
    }
}

        //select * from Role r join User_role ur on r.role_id=ur.role_id join  user_system sys on sys.usr_id=ur.usr_id where r.role_type=2;
        //select * from role where role_id in (select role_id from user_role where usr_id in (select usr_id from user_system where usr_father_id = "a" )) and role_type=2
