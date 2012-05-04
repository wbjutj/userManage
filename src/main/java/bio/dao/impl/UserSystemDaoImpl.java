/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bio.dao.impl;

import bio.dao.UserSystemDao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import bio.po.UserSystem;
import bio.util.DBUtil;
import bio.util.Map2Bean;

/**
 *
 * @author fafa
 */
public class UserSystemDaoImpl implements UserSystemDao {

    private DBUtil dbutil = new DBUtil();

    public boolean addUser(UserSystem user) {
        String sql = "insert into User_system(usr_id,usr_father_id,usr_cluster_uid,usr_cluster_gid,usr_cluster_account,usr_cluster_passwd,usr_cluster_datapath,usr_status) values (?,?,?,?,?,?,?,?)";
        boolean flag = false;
        String usr_id =  user.getUsr_id();
        String usr_father_id = user.getUsr_father_id();
        String usr_cluster_uid = user.getUsr_cluster_uid();
        String usr_cluster_gid = user.getUsr_cluster_gid();
        String usr_cluster_account = user.getUsr_cluster_account();
        String usr_cluster_passwd = user.getUsr_cluster_passwd();
        String usr_cluster_datapath = user.getUsr_cluster_datapath();
        String usr_status = user.getUsr_status();
        try {
            Object[] params = new Object[]{usr_id,usr_father_id,usr_cluster_uid,usr_cluster_gid,usr_cluster_account,usr_cluster_passwd,usr_cluster_datapath,usr_status};
            flag = dbutil.executeSQLwithParams(sql, params);
        } catch (Exception ex) {
            System.out.println(ex.getLocalizedMessage());
        }
        return  flag;
    }

    public UserSystem viewUser(String user_id) {
        String sql = "select * from User_system where usr_id ='" + user_id + "'";
        Map2Bean m2b = new Map2Bean();
        UserSystem usersys = new UserSystem();
        try {
            Map map = dbutil.getUniqueObject(sql);
            usersys = (UserSystem) m2b.convertMapToBean(usersys, map);
        } catch (Exception ex) {
            System.out.println(ex.getLocalizedMessage());
        }
        return usersys;
    }
    /* 只有 下一层 */

    public List<UserSystem> viewSubUsers(String user_id) {
        String sql = "select * from User_system where usr_father_id =?";
        List<UserSystem> list = new ArrayList<UserSystem>();
        List<Map>  listmap = null;
        Map2Bean m2b = new Map2Bean();
            try {
            Object[] params = new Object[]{user_id};
            listmap = dbutil.getObjectList(sql, params);
            for(int i =0; i < listmap.size() ;i++){
                  UserSystem usersys = new UserSystem();
                  usersys = (UserSystem) m2b.convertMapToBean(usersys, listmap.get(i));
          //        System.out.println(usersys);
                  list.add(usersys);
            }
        } catch (Exception ex) {
            System.out.println(ex.getLocalizedMessage());
        }
        return list;
    }
    /* 只有 下一层 */
    public List<UserSystem> viewSubAdmin(String user_id) {
        List<UserSystem> list = new ArrayList<UserSystem>();
        UserSystem  us = null;
        List<UserSystem> listall = viewSubUsers(user_id);
        UserRoleDaoImpl dao = new UserRoleDaoImpl();
        for(int i=0;i<listall.size();i++){
            us = listall.get(i);
            if(dao.viewRoleType(us.getUsr_id()) == 2){
                 list.add(us);
            }
        }
        if(list.size() == 0){ list = null;}
        return list;
    }
    /* 只有 下一层 */
    public List<UserSystem> viewSubUser(String user_id) {
        List<UserSystem> list = new ArrayList<UserSystem>();
        UserSystem  us = null;
        List<UserSystem> listall = viewSubUsers(user_id);
        UserRoleDaoImpl dao = new UserRoleDaoImpl();
        for(int i=0;i<listall.size();i++){
            us = listall.get(i);
            if(dao.viewRoleType(us.getUsr_id()) == 3){
                 list.add(us);
            }
        }
        if(list.size() == 0){ list = null;}
        return list;
    }

    public boolean delUser(String user_id, String child_user_id) {
        boolean flag = false;
        String sql = "delete from User_system where usr_id = '" + child_user_id + "'";
        if (countSubUser(child_user_id)==0) {
            UserSystem us = viewUser(child_user_id);
            if (user_id.equals(us.getUsr_father_id())) {
                try {
                    flag = dbutil.executeUpdateSQL(sql);
                    if(flag == true ){
                         UserRoleDaoImpl  dao = new UserRoleDaoImpl();
                         dao.delUser(child_user_id); //是否需要错误提示？
                    }
                } catch (Exception ex) {
                    Logger.getLogger(UserSystemDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                System.out.println("delete faile , U don't have the right");
            }
        }else{
            System.out.println("delete faile , the user has the subusers");
        }
        return flag;
    }
    public int countSubUser(String user_id) {
        return viewSubUsers(user_id).size();
    }
}
