/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bio.dao.impl;

import bio.dao.UserRoleDao;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import bio.util.DBUtil;

import bio.po.Role;
import bio.po.UserSystem;

/**
 *
 * @author fafa
 */
public class UserRoleDaoImpl implements UserRoleDao {

    private DBUtil dbutil = new DBUtil();

    public boolean delUser(String user_id) {
        boolean flag = false;
        String sql = "delete from  User_role where usr_id='" + user_id + "'";
        try {
            flag = dbutil.executeUpdateSQL(sql);
        } catch (Exception ex) {
            Logger.getLogger(UserRoleDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

    public String viewUserRole(String user_id) {
        String sql = "select  role_id  from  User_role where usr_id = '" + user_id + "'";
        String id = null; Map map=null;
        try {
           map = dbutil.getUniqueObject(sql);
        } catch (Exception ex) {
            Logger.getLogger(UserRoleDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (String) map.get("role_id");  //写死了
    }
    /* for the test */
//    public  List<UserSystem>  viewUsers(String role_id){
//        String sql = "select * from User_role where role_id=?";
//        List<UserSystem>  list = null;
//        try {
//            Object[] params = new Object[]{role_id};
//           list = dbutil.getObjectList(sql, params);
//        } catch (Exception ex) {
//            Logger.getLogger(UserRoleDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return list;
//    }
    public int countUser(String role_id) {
        String sql = "select * from User_role where role_id=?";
        int  count = 0;
        try {
            Object[] params = new Object[]{role_id};
           count = dbutil.getRowCount(sql, params);
        } catch (Exception ex) {
            Logger.getLogger(UserRoleDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    //    return viewUsers(role_id).size();
    }
    public int viewRoleType(String user_id){
        return viewRole(user_id).getRole_type();
    }
    public Role viewRole(String user_id) {
        String role_id = viewUserRole(user_id);
        Role role = new RoleDaoImpl().viewRole(role_id);
        return role;
    }

    public List<Role> viewSubRole(String user_id) {
        String role_id = viewUserRole(user_id);
        List<Role> list = new RoleDaoImpl().viewSubRole(role_id);
        return list;
    }

    public List<Role> viewSubAdminRole(String user_id) {
        String role_id = viewUserRole(user_id);
        List<Role> list = new RoleDaoImpl().viewSubAdminRole(role_id);
        return list;
    }

    public List<Role> viewSubUserRole(String user_id) {
        String role_id = viewUserRole(user_id);
        List<Role> list = new RoleDaoImpl().viewSubUserRole(role_id);
        return list;
    }


    public boolean addUserRole(String user_id, String child_user_id, String role_id) {
        boolean flag = false;
        String sql = "insert into User_role(usr_id,role_id) values (?,?)";
        UserSystem usf = new UserSystemDaoImpl().viewUser(user_id);
        UserSystem us = new UserSystemDaoImpl().viewUser(child_user_id);
        Role role = new RoleDaoImpl().viewRole(role_id);
        Role rolef = viewRole(user_id);
        try {
            if (usf.isFatherUser(us) && rolef.isFatherRole(role)) {
                Object[] params = new Object[]{child_user_id, role_id};
                flag = dbutil.executeSQLwithParams(sql, params);
            }else{
                 System.out.println("modify faile , U don't have the right");
            }
        } catch (Exception ex) {
            Logger.getLogger(UserRoleDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

    public boolean modUserRole(String user_id, String child_user_id, String newroleid) {
        boolean flag = false;
        String sql = "update User_role set role_id = ? where usr_id = ?";
        UserSystemDaoImpl dao = new UserSystemDaoImpl();
        if (dao.countSubUser(child_user_id) == 0) {
            UserSystem usf = new UserSystemDaoImpl().viewUser(user_id);
            UserSystem us = new UserSystemDaoImpl().viewUser(child_user_id);
            Role role = new RoleDaoImpl().viewRole(newroleid);
            Role rolef = viewRole(user_id);
            try {
                if (usf.isFatherUser(us) && rolef.isFatherRole(role)) {
                    Object[] params = new Object[]{newroleid, child_user_id};
                    flag = dbutil.executeSQLwithParams(sql, params);
                }else{
                 System.out.println("modify faile , U don't have the right");
                }
            } catch (Exception ex) {
                Logger.getLogger(UserRoleDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("modify faile , the user has the subusers");
        }
        return flag;
    }
}
