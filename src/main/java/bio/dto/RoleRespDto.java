/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bio.dto;

/**
 *
 * @author fafa
 */
public interface RoleRespDto extends  BaseRespDto{
    public String getId();

    public String getName();

    public int getType();

    public String getDescription();

    public String getFather_id();
}
