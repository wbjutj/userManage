package bio.dao;


import java.util.Properties;
import java.util.MissingResourceException;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.beans.PropertyVetoException;

import javax.sql.DataSource;
import org.apache.log4j.Logger;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import bio.bcc.Constant;


public class JdbcConnectionPool {
    private static JdbcConnectionPool singleton;
    private static final Logger log = Logger.getLogger(JdbcConnectionPool.class);

    private DataSource dataSource;

    private JdbcConnectionPool() {}
/*fafa* 鐢熸垚鍗曚緥杩炴帴姹? */

    public static JdbcConnectionPool getInstance() {
        synchronized (JdbcConnectionPool.class) {
            if (singleton == null) {
                singleton = new JdbcConnectionPool();
            }
            return singleton;
        }
    }
    public synchronized DataSource getPooledJdbcTemplate() {

            if (dataSource == null) {
                try {
                    createC3p0DataSource();
                    System.out.println("Success to create a new data source.");
                    log.info("Success to create a new data source.");
                } catch (PropertyVetoException e) {
                    //System.out.println(e.getMessage());
                    log.error("PropertyVetoException: " + e.getMessage());
                }
            }
            return dataSource;

    }
/**fafa
* 鍏抽棴鏁版嵁婧? */
    public synchronized void close() {
        closeDataSource();
        singleton = null;
        log.info("Close the data source.");
    }
/**
 * C3P0鏄竴涓紑婧愮殑JDBC杩炴帴姹狅紝瀹冨疄鐜颁簡鏁版嵁婧愬拰JNDI
 * 缁戝畾锛屾敮鎸丣DBC3瑙勮寖鍜孞DBC2鐨勬爣鍑嗘墿灞曘?
 * 鐩墠浣跨敤瀹冪殑寮?簮椤圭洰鏈塇ibernate锛孲pring绛夈?
 */
/**fafa
* 鍒╃敤prop瀵煎叆鏁版嵁婧愮殑灞炴?甯搁噺 鏍规嵁灞炴?甯搁噺瀵?鏁版嵁婧恈pds璁剧疆鍙傛暟
 */
    private void createC3p0DataSource()
            throws PropertyVetoException {
        Properties prop = loadProperties(Constant.JDBC_PROPERTIES_FILE);
        if (prop == null) {
            log.error("Failed to load jdbc properties file, prop is null!");
            throw new IllegalArgumentException("Failed to load jdbc properties file, prop is null!");
        }
        ComboPooledDataSource cpds = new ComboPooledDataSource();
         if(prop.getProperty("jdbc.driverClass")!=null){
            cpds.setDriverClass(prop.getProperty("jdbc.driverClass"));  //throw exception
        }
        if(prop.getProperty("jdbc.user")!=null){
            System.out.println(prop.getProperty("jdbc.user"));
            cpds.setUser(prop.getProperty("jdbc.user"));
        }
        if(prop.getProperty("jdbc.password")!=null){
             System.out.println(prop.getProperty("jdbc.password"));
            cpds.setPassword(prop.getProperty("jdbc.password"));
        }

        if(prop.getProperty("jdbc.jdbcUrl")!=null){
            cpds.setJdbcUrl(prop.getProperty("jdbc.jdbcUrl"));
        }
        if(prop.getProperty("pool.initialPoolSize")!=null){
            cpds.setInitialPoolSize(Integer.parseInt(prop.getProperty("pool.initialPoolSize")));
        }
        if(prop.getProperty("pool.minPoolSize")!=null){
            System.out.println(prop.getProperty("pool.minPoolSize"));
            cpds.setMinPoolSize(Integer.parseInt(prop.getProperty("pool.minPoolSize")));
        }
        if(prop.getProperty("pool.maxPoolSize")!=null){
            System.out.println(prop.getProperty("pool.maxPoolSize"));
            cpds.setMaxPoolSize(Integer.parseInt(prop.getProperty("pool.maxPoolSize")));
        }

        if(prop.getProperty("pool.acquireIncrement")!=null){
            cpds.setAcquireIncrement(Integer.parseInt(prop.getProperty("pool.acquireIncrement")));
        }
        if(prop.getProperty("pool.acquireIncrement")!=null){
            cpds.setMaxIdleTime(Integer.parseInt(prop.getProperty("pool.maxIdleTime")));
        }
        if(prop.getProperty("pool.maxStatements")!=null){
            cpds.setMaxStatements(Integer.parseInt(prop.getProperty("pool.maxStatements")));
        }
        dataSource = cpds;
    }

/**fafa
* 鏍规嵁鏂囦欢鐨勮矾寰?渚濇嵁鏂囦欢鐢熸垚 灞炴?绫? */
    private Properties loadProperties(String propFile) {
        FileInputStream in = null;
        Properties prop = null;
        try {
            in = new FileInputStream(propFile);
            prop = new Properties();
            prop.load(in);
        } catch (FileNotFoundException e) {
            log.error("Can not find properties file: " + propFile);
            throw new MissingResourceException("Properties file missing!", " ", propFile);
            //e.printStackTrace();
        } catch (IOException e) {
            log.error("IOException: loading properties file: " + propFile);
            throw new MissingResourceException("Properties file missing!", " ", propFile);
            //e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                    in = null;
                } catch (IOException e) {
                    //e.printStackTrace();
                    log.warn("Failed to close properties file!");
                }
            }
        }
        return prop;
    }
/**fafa
* 鍏抽棴鏁版嵁婧? */
    private void closeDataSource() {
      try{
        if (dataSource != null) {
            ((ComboPooledDataSource) dataSource).close();
            dataSource = null;
        }
    }catch(Exception e){
        System.out.println(e.getLocalizedMessage());
    }
}
}
