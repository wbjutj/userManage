/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bio.po;

/**
 *
 * @author wj
 */
import java.text.SimpleDateFormat;
import java.util.Date;
public class Feedback {
    String fb_id;
    String usr_id;
    Date fb_time;
    String fb_description;
    String fb_action;
    Date action_time;
    public Feedback(){}
    public Feedback(String fb_id,String usr_id,Date fb_time,String fb_description,String fb_action,Date action_time)
    {
        this.fb_id=fb_id;
        this.usr_id=usr_id;
        this.fb_description=fb_description;
        this.fb_time=fb_time;
        this.fb_action=fb_action;
        this.action_time=action_time;
    }
    public Feedback(String fb_id,String usr_id,Date fb_time,String fb_description)
    {
        this.fb_id=fb_id;
        this.usr_id=usr_id;
        this.fb_description=fb_description;
        this.fb_time=fb_time;
        this.fb_action=null;
        this.action_time=null;
    }
    public Feedback(String fb_id,String fb_action,Date action_time)
    {
        this.fb_id=fb_id;
        this.usr_id=null;
        this.fb_description=null;
        this.fb_time=null;
        this.fb_action=fb_action;
        this.action_time=action_time;
    }
    public String getFb_id()
    {return this.fb_id;}
    void setFb_id(String fb_id)
    {this.fb_id=fb_id;}
    public String getUsr_id()
    {return this.usr_id;}
    public void setUsr_id(String usr_id)
    {this.usr_id=usr_id;}
    public Date getFb_time()
    {return this.fb_time;}
    public void setFb_time(Date fb_time)
    {this.fb_time=fb_time;}
    public String getFb_description()
    {return this.fb_description;}
    public void setFb_description(String fb_description)
    {this.fb_description=fb_description;}
    public Date getAction_time()
    {return this.action_time;}
    public void setAction_time(Date action_time)
    {this.action_time=action_time;}
    public String getFb_action()
    {return this.fb_action;}
    public void setFb_action(String fb_action)
    {this.fb_action=fb_action;}
    public Date toDate(String date)
    {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date   d   =   null;
        try{
            System.out.println(date);
            d=(Date) sdf.parse(date);
        }
        catch(Exception ex){
            System.out.println(ex.getLocalizedMessage());
        }
        return d;
    }
}
