package ccgp.dao;

import ccgp.domain.Ccgp;
import ccgp.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.ArrayList;

public class HebeiDao {
    QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
    public Logger logger = LogManager.getLogger(HebeiDao.class.getName());
    public void save(ArrayList<Ccgp> list) {
        if (list!=null&&list.size()>0) {
            for (Ccgp ccgp : list) {
                Object[] params= {
                        ccgp.getTitle(),
                        ccgp.getTime(),
                        ccgp.getArea(),
                        ccgp.getHref(),
                        ccgp.getStatus(),
                };
                String sql="INSERT INTO hebei (title,TIME,AREA,href,STATUS) VALUES (?,?,?,?,?)";
                try {
                    qr.insert(sql, new ScalarHandler<Object>(), params);
                } catch (SQLException e) {
                    if (e.getErrorCode() == 1062){
                        logger.warn("已存在记录,链接："+ccgp.getHref());
                    }else {
                        logger.error(e.getMessage());
                    }
                }
            }
        }
    }
}
