package ccgp.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import ccgp.domain.Ccgp;
import ccgp.utils.JDBCUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ZycaiGouDao {
	
	QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
	private Logger logger = LogManager.getLogger(ZycaiGouDao.class.getName());
	public void Zycaigou(ArrayList<Ccgp> list) {
		for (Ccgp ccgp : list) {
			Object[] params= {
				ccgp.getTitle(),
				ccgp.getTime(),
				ccgp.getArea(),
				ccgp.getPeople(),
				ccgp.getHref(),
				ccgp.getStatus(),
			};
			String sql="INSERT INTO zhongyang (title,TIME,AREA,caigouren,href,STATUS) VALUES (?,?,?,?,?,?)";
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
	public Date getTime(String status) {
		String sql = "SELECT MAX(TIME) FROM zhongyang WHERE STATUS=?";
		Object[] params = {status};
		Date date=null;
		try {
			date = qr.query(sql, new ScalarHandler<Date>(), params );
		} catch (SQLException e) {
			logger.error(e.getMessage());
			System.out.println(e.getMessage());
		}
		return date;
	}
}
