package ccgp.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import ccgp.main.Sichuan;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import ccgp.domain.Ccgp;
import ccgp.utils.JDBCUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SichuanDao {

	QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
	public Logger logger = LogManager.getLogger(SichuanDao.class.getName());

	public Date getMaxTime() {
		
		String sql = "SELECT MAX(TIME) FROM sichuan";
		Object[] params = {};
		Date date=null;
		try {
			date = qr.query(sql, new ScalarHandler<Date>(), params );
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	public void save(ArrayList<Ccgp> list) {
		if (list!=null&&list.size()>0) {
			for (Ccgp ccgp : list) {
				Object[] params= {
						ccgp.getTitle(),
						ccgp.getTime(),
						ccgp.getArea(),
						ccgp.getHref(),
				};
				String sql="INSERT INTO sichuan (title,TIME,AREA,href) VALUES (?,?,?,?)";
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
