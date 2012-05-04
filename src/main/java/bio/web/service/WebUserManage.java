/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bio.web.service;
import bio.dto.*;

public interface WebUserManage {

    BaseRespDto  addRole(RoleDto role ,String father_role_id);

    BaseRespDto  modRole(String role_id, RoleDto new_role);

    BaseRespDto  delRole(String role_id);

    BaseRespDto  assignUserRoler(String user_id, String child_user_id , String role_id );

    BaseRespDto  modUserRoler(String user_id, String child_user_id , String role_id );

    BaseRespDto  delUser(String user_id , String child_user_id);

    UserRespDto[]  viewSubUserBase(String user_id);
    UserRespDto[]  viewSubAdminBase(String user_id);
    UserRespDto[]  viewSubUsersBase(String user_id);
    UserRespDto[]  viewSubUserSystem(String user_id);
    UserRespDto[]  viewSubAdminSystem(String user_id);
    UserRespDto[]  viewSubUsersSystem(String user_id);
    UserRespDto[]  viewSubUserDetail(String user_id);
    UserRespDto[]  viewSubAdminDetail(String user_id);
    UserRespDto[]  viewSubUsersDetail(String user_id);
   
    RoleRespDto[]  viewSubRole(String user_id);
    RoleRespDto[]  viewSubAdminRole(String user_id);
    RoleRespDto[]  viewSubUserRole(String user_id);

    UserRespDto    viewUserBase(String user_id);
    UserRespDto    viewUserSystem(String user_id);
    UserRespDto    viewUserDetail(String user_id);

    
    RoleRespDto    viewRole(String user_id);
    BaseRespDto modifyPassword(String user_id , String old_password, String new_password);
    FeedBackRespDto  addFeedBackMes(String user_id ,FeedBackDto feed_back);
}
