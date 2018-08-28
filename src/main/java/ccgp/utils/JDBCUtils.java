package ccgp.utils;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

public class JDBCUtils {
	
	
	/*
	 * �������ӳ�BasicDataSource
	 */
	public static BasicDataSource dataSource = new BasicDataSource();
	//��̬�����
	static {

		dataSource.setDriverClassName("com.mysql.jdbc.Driver"); // ����Ҫ���ӵ����ݿ������
		dataSource.setUrl("jdbc:mysql://localhost/cxn_data?useUnicode=true&characterEncoding=utf-8&useSSL=false"); //ָ��Ҫ���ӵ����ݿ��ַ
		dataSource.setUsername("root"); //ָ��Ҫ�������ݵ��û���
		dataSource.setPassword(""); //ָ��Ҫ�������ݵ�����
			}
	/*
	 * �������ӳض���
	 */
	public static DataSource getDataSource(){
		return dataSource;
	}
	
}
