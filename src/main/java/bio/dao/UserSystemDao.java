/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bio.dao;
import java.util.List;
import bio.po.UserSystem;
/**
 *
 * @author fafa
 */
public interface UserSystemDao {

    boolean addUser(UserSystem user);

    boolean delUser(String user_id, String child_user_id);

    UserSystem viewUser(String user_id);

 //   int countSubUser(String user_id);  used in UserRoleDao  modify  user  role

    List<UserSystem> viewSubUser(String user_id);

    List<UserSystem> viewSubAdmin(String user_id);

    List<UserSystem> viewSubUsers(String user_id);
}
