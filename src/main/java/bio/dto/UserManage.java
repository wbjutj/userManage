/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bio.dto;
import bio.dao.RoleDao;
import bio.dao.impl.DaoFactory;
import bio.web.service.*;
import bio.po.*;
import bio.dto.*;
/**
 *
 * @author fafa
 */
public class UserManage {
    private  DaoFactory daofactory = new DaoFactory();
        /*创建角色（管理员角色和用户角色）*/
    BaseRespDto  addRole(RoleDto role){
        RoleDao  dao = daofactory.CreatRoleDao();
        dao.addRole(null);
     throw new UnsupportedOperationException("Not supported yet.");  
    }
    /*修改角色权限（级联修改其所有子角色）*/
    /*modRole  需要重新设计   改为 修改资源 和 操作两类*/
    BaseRespDto  addRoleRes(String role_id, RoleDto new_role){

     throw new UnsupportedOperationException("Not supported yet.");  
    }
    /*某角色及其下属角色，用户数都为0时，删除所有角色*/
    BaseRespDto  delRole(String role_id){
     throw new UnsupportedOperationException("Not supported yet.");
    }
    /*批准用户角色（管理员和用户）*/
    BaseRespDto  assignUserRoler(String user_id, String child_user_id , String role_id ){
     throw new UnsupportedOperationException("Not supported yet."); 
    }
    /*修改用户角色（管理员和用户）*/
    BaseRespDto  modUserRoler(String user_id, String child_user_id , String role_id ){
     throw new UnsupportedOperationException("Not supported yet.");    
    }
    /*删除没有子用户的用户，*/
    BaseRespDto  delUser(String user_id , String child_user_id){
     throw new UnsupportedOperationException("Not supported yet.");   
    }
    //BaseRespDto  modUserRole( int user_id ,int child_user_idI,int new_role_id);
    /*查看子用户*/
    UserRespDto[]  viewSubUserBase(String user_id)/*所有用户*/
    {
     throw new UnsupportedOperationException("Not supported yet.");    
    }
    UserRespDto[]  viewSubAdminBase(String user_id){
     throw new UnsupportedOperationException("Not supported yet.");    
    }
    UserRespDto[]  viewSubUsersBase(String user_id){
     throw new UnsupportedOperationException("Not supported yet.");   
    }
    UserRespDto[]  viewSubUserSystem(String user_id){/*所有用户*/
     throw new UnsupportedOperationException("Not supported yet."); 
    }
    UserRespDto[]  viewSubAdminSystem(String user_id){
     throw new UnsupportedOperationException("Not supported yet.");
    }
    UserRespDto[]  viewSubUsersSystem(String user_id){
     throw new UnsupportedOperationException("Not supported yet.");
    }
    UserRespDto[]  viewSubUserDetail(String user_id)/*所有用户*/{
     throw new UnsupportedOperationException("Not supported yet.");
    }
    UserRespDto[]  viewSubAdminDetail(String user_id){
     throw new UnsupportedOperationException("Not supported yet.");
    }
    UserRespDto[]  viewSubUsersDetail(String user_id){
     throw new UnsupportedOperationException("Not supported yet.");
    }
    /*查看用户信息*/
    UserRespDto    viewUserBase(String user_id){
     throw new UnsupportedOperationException("Not supported yet.");
    }
    UserRespDto    viewUserSystem(String user_id){
     throw new UnsupportedOperationException("Not supported yet.");
    }
    UserRespDto    viewUserDetail(String user_id){
     throw new UnsupportedOperationException("Not supported yet.");
    }
    /*查看子角色*/
    RoleRespDto[]  viewSubRole(String user_id){
     throw new UnsupportedOperationException("Not supported yet.");
    }
    RoleRespDto[]  viewSubAdminRole(String user_id){
     throw new UnsupportedOperationException("Not supported yet.");
    }
    RoleRespDto[]  viewSubUserRole(String user_id){
     throw new UnsupportedOperationException("Not supported yet.");
    }
    /*查看用户角色*/
    RoleRespDto    viewRole(String user_id){
                RoleDao  dao = daofactory.CreatRoleDao();
                Role role =  dao.viewRole(user_id);
     throw new UnsupportedOperationException("Not supported yet.");

    }
    /*修改密码*/
    BaseRespDto modifyPassword(String user_id , String old_password, String new_password){
     throw new UnsupportedOperationException("Not supported yet.");
    }
    /*添加反馈信息*/
    FeedBackRespDto  addFeedBackMes(String user_id ,FeedBackDto feed_back){
     throw new UnsupportedOperationException("Not supported yet.");
    }
}
