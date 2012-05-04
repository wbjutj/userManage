/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bio.dao.impl;
import bio.dao.FeedbackDao;
import java.util.ArrayList;
import bio.util.DBUtil;
import java.util.Date;
import java.util.List;
import bio.po.Feedback;
import java.util.Map;
import bio.util.Map2Bean;
/**
 *
 * @author wj
 */
public class FeedbackDaoImpl implements FeedbackDao {
    private DBUtil dbutil = new DBUtil();
    public boolean addFeedback(Feedback fb)//String usr_id,Date fbTime,String fbDescription)
    {
        String sql = "insert into Feedback(fb_id,usr_id,fb_Time,fb_description) values (?,?,?,?)";
        boolean flag = false;
        String fb_id=fb.getFb_id();
        String usr_id = fb.getUsr_id();//u.getUsr_id();
        Date fbTime=fb.getFb_time();
        String fbdescription=fb.getFb_description();
        try {
            Object[] params = new Object[]{fb_id,usr_id,fbTime,fbdescription};
            flag = dbutil.executeSQLwithParams(sql, params);
        } catch (Exception ex) {
            System.out.println(ex.getLocalizedMessage());
        }
        return  flag;
    }
    public boolean delFeedback(String fb_id)
    {
        boolean flag = false;
        String sql="delete from Feedback where fb_id = '" + fb_id + "'";
        try {
            flag = dbutil.executeSQL(sql);
        } catch (Exception ex) {
            System.out.println(ex.getLocalizedMessage());
        }
        return  flag;
    }
    public boolean replyFeedback(Feedback fb)
    {
        String sql = "update Feedback set fb_action = ?,action_time=? where fb_id = ?";//"insert into Feedback(usr_id,fbTime,fbDescription) values (?,?,?)";
        boolean flag = false;
        String fb_id=fb.getFb_id();
        String fb_action = fb.getFb_action();
        Date action_time=fb.getAction_time();
        try {
            Object[] params = new Object[]{fb_action,action_time,fb_id};
            flag = dbutil.executeSQLwithParams(sql, params);
        } catch (Exception ex) {
            System.out.println(ex.getLocalizedMessage());
        }
        return  flag;
    }
    public List<Feedback> viewFeedback(String usr_id)
    {
        List<Feedback> list=new ArrayList<Feedback>();
        String sql = "select * from Feedback where usr_id =?";
        List<Map>  listmap = null;
        Map2Bean m2b = new Map2Bean();
            try {
            Object[] params = new Object[]{usr_id};
            listmap = dbutil.getObjectList(sql, params);
            for(int i =0; i < listmap.size() ;i++){
                  Feedback fb = new Feedback();
                  fb = (Feedback) m2b.convertMapToBean(fb, listmap.get(i));
          //        System.out.println(usersys);
                  list.add(fb);
            }
        } catch (Exception ex) {
            System.out.println(ex.getLocalizedMessage());
        }
        return list;
    }


}
