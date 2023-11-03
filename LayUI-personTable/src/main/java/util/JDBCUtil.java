package util;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtil {
	private static DataSource ds;
	
	public static DataSource getDataSource(){
		ds=new ComboPooledDataSource();
		return ds;
	}
}
