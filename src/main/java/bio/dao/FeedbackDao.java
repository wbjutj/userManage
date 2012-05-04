/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bio.dao;

/**
 *
 * @author wj
 */
//import java.sql.Date;
import java.util.List;
import bio.po.Feedback;
public interface FeedbackDao {
    boolean addFeedback(Feedback fb);//,String fbaction,DATE actionTime);
    boolean delFeedback(String fb_id);
    boolean replyFeedback(Feedback fb);
    List<Feedback> viewFeedback(String usr_id);
    //boolean modFeedback(String );

}
