/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bio.util;

import java.sql.Connection;
import javax.sql.DataSource;
import java.sql.Statement;
import java.sql.PreparedStatement;
import bio.dao.JdbcConnectionPool;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

/**
 *
 * @author tangbx
 */
public class DBUtil {

    private Connection con;
    private Statement stmt = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    private DataSource dataSource = JdbcConnectionPool.getInstance().getPooledJdbcTemplate();

    public DBUtil() {
    }

    /**fafa
     * 从C3P0 pool中得到一个连接
     */
    public Connection getConnection() {
//trying to retrieve a conection from C3P0 pool
        try {
            if (con != null) {
                return con;
            } else {
                con = dataSource.getConnection();
                return con;
            }
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return null;
        }

    }

    /**fafa
     * 用于执行静态（没有参数） SQL 语句   并它所生成结果的对象转换为 Map类。
     */
    public Map getUniqueObject(String sql) throws Exception {
        getConnection();
        stmt = con.createStatement();
        rs = stmt.executeQuery(sql);
        if (null != rs) {
            Map temp = convertToMap(rs);
            closedb();
            return temp;
        }
        closedb();
        return null;

    }

    /**fafa
     * 用于执行动态 （带有参数）SQL 语句   并它所生成结果的对象转换为 List类。
     */
    public ArrayList getObjectList(String sql, Object[] params) throws Exception {
        ArrayList list = null;
        getConnection();
        pstmt = con.prepareStatement(sql);
        if (params != null) {
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
        }
        ResultSet rs = pstmt.executeQuery();
        list = convertToList(rs);
        closedb();
        return list;
    }
    
    /**fafa
     * 将ResultSet对象转换为 Map对象。
     */
    public Map convertToMap(ResultSet rs) throws Exception {
        ResultSetMetaData rsmd = rs.getMetaData();
        HashMap temphash = null;
        temphash = new HashMap();
        while (rs.next()) {
            for (int i = 0; i < rsmd.getColumnCount(); i++) {
                temphash.put(rsmd.getColumnName(i + 1), rs.getObject(rsmd.getColumnName(i + 1)));
            }
        }
        return temphash;
    }

    /**fafa
     * 将ResultSet对象转换为 List对象。
     */
    public ArrayList convertToList(ResultSet rs) throws Exception {
        ArrayList list = new ArrayList();
        ResultSetMetaData rsmd = rs.getMetaData();//表列的描述对象
        HashMap temphash = null;
        while (rs.next()) {
            temphash = new HashMap();
            for (int i = 0; i < rsmd.getColumnCount(); i++) {
                temphash.put(rsmd.getColumnName(i + 1), rs.getObject(rsmd.getColumnName(i + 1)));
            }
            list.add(temphash);
        }
        return list;
    }

    /**fafa
     * 统计查询后 结果表的行数
     */
    public int getRowCount(String sql, Object[] params) throws Exception {
        int count = 0;
        getConnection();
        pstmt = con.prepareStatement(sql);
        if (params != null) {
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
        }
        rs = pstmt.executeQuery();
        /*
        int size = convertToList(rs).size();
        closedb();
        return   size;
         */
        while (rs.next()) {
            count++;  //问题  count++
        }
        closedb();
        return count;

    }

    /**fafa
     * 返回执行静态查询是否存在结果
     */
    /**
     * 　sm.executeQuery(sql); // 执行数据查询语句(select)
    　　sm.executeUpdate(sql); // 执行数据更新语句(delete、update、insert、drop等)
     * @param sql
     * @return
     * @throws Exception
     */
    public boolean executeSQL(String sql) throws Exception {
        boolean res = true;
        getConnection();
        stmt = con.createStatement();
        boolean result = stmt.execute(sql);
        closedb();
        if (result == true) {
            res = false;
        }
        return res;
    }

    public boolean executeUpdateSQL(String sql) throws Exception {
        boolean res = false;
        getConnection();
        stmt = con.createStatement();
        int result = stmt.executeUpdate(sql);
        closedb();
        if (result > 0) {
            res = true;
        }
        return res;
    }

    /**fafa
     * 返回执行动态查询是否存在结果
     */
    public boolean executeSQLwithParams(String sql, Object[] params) throws Exception {
        boolean res = true;
        getConnection();
        pstmt = con.prepareStatement(sql);
        if (params != null) {
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
        }
        boolean result = pstmt.execute();
        closedb();
        if (result == true) {
            res = false;
        }
        return res;
    }

    /**fafa
     * 关闭数据库连接的相关操作
     */
    public void closedb() {
        if (null != rs) {
            try {
                rs.close();
            } catch (Exception e) {
                rs = null;
            }
        }
        if (null != stmt) {
            try {
                stmt.close();
            } catch (Exception ex) {
                stmt = null;
            }
        }
        if (null != pstmt) {
            try {
                pstmt.close();
            } catch (Exception ex) {
                pstmt = null;
            }
        }
        if (null != con) {
            try {
                con.close();
                con = null;
            } catch (Exception ex) {
                con = null;
            }
        }
    }
}
