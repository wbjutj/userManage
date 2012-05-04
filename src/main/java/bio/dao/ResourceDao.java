/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bio.dao;

import bio.po.Resource;

/**
 *
 * @author fafa
 */
public interface ResourceDao {

    boolean addResource(Resource resource);

    boolean delResource(String resource_id);  //鎬荤郴缁熶腑鍒犻櫎璧勬簮  鑰冨療 鏄惁鏈夎鑹叉嫢鏈?  瑙掕壊瀛樺湪 鑲畾鏈夌浉搴旂殑鐢ㄦ埛

    Resource viewResource(String resource_id);

}
