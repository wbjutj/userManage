/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bio.dto;

/**
 *
 * @author fafa
 */
public interface UserRespDto extends  BaseRespDto{
    public String getId();

    public String getFather_id();

    public String getCluster_uid();

    public String getCluster_gid();

    public String getCluster_account();

    public String getCluster_passwd();

    public String getCluster_datapath();

    public String getStatus();

    public String getAccount();

    public String getPasswd();

    public String getName();

    public int getGender();

    public String getBirth();//Data

    public String getEmail();

    public String getCell();

    public int getDegree();

    public String getUniv();

    public String getTitle();

    public String getOrg();

    public String getDepart();

    public String getGroup();

    public String getFax();

    public String getResearch();
}
