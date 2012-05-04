/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bio.util;

import java.beans.PropertyDescriptor;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**
 *
 * @author hou
 */
public class Map2Bean {

    public static Object convertMapToBean(Object o, Map map) throws Exception {
        if (o == null) {
            return null;
        }
        PropertyDescriptor[] origDescriptors =
                PropertyUtils.getPropertyDescriptors(o);

        for (int i = 0; i < origDescriptors.length; i++) {
            String name = origDescriptors[i].getName();
            if (!StringUtils.equals(name, "class")) {
                if (map.get(name) != null) {
                    PropertyUtils.setProperty(o, name, org.apache.commons.beanutils.ConvertUtils.convert(map.get(name).toString(), origDescriptors[i].getPropertyType()));
                } else {
                    PropertyUtils.setProperty(o, name, null);
                }
            }
        }
        return o;
    }
}
