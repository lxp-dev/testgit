/**
 * 
 */
package com.pengsheng.sms.server.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Tools;
import com.pengsheng.sms.server.SynchronizationSMS;
import com.pengsheng.sms.server.dao.SmsServiceDao;
import com.pengsheng.sms.server.persistence.SmsPo;

/**
 * @author Liuqian
 * 
 */
public class SmsServiceDaoImpl implements SmsServiceDao {

	private Connection conn;

	private Statement stmt;

	private PreparedStatement prepstmt;

	public static Properties mySqlDriver;

	static {
		try {
			mySqlDriver = Tools.getProperty("/sms/config/", "jdbc.properties");

			Class.forName(mySqlDriver.getProperty("jdbc.driverClassName"));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void open() throws Exception {

		try {

			conn = DriverManager.getConnection(mySqlDriver
					.getProperty("jdbc.url"), mySqlDriver
					.getProperty("jdbc.username"), mySqlDriver
					.getProperty("jdbc.password"));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			throw e;
		}
	}

	public void close() throws Exception {
		if (stmt != null) {
			stmt.close();
			stmt = null;
		}

		if (prepstmt != null) {
			prepstmt.close();
			prepstmt = null;

		}
		if (conn != null) {
			conn.close();
			conn = null;

		}
	}

	public void insertSMS(SmsPo smsPo) throws Exception {

		try {
			stmt = conn.createStatement();

			StringBuffer buffer = new StringBuffer();
			buffer.append("insert into sms2 ");
			buffer.append("(SMS_ID, ");
			buffer.append("FROM_ID,  ");
			buffer.append("PHONE,  ");
			buffer.append("CONTENT,  ");
			buffer.append("SEND_TIME,  ");
			buffer.append("SEND_FLAG ");
			buffer.append(") ");
			buffer.append("values ");
			buffer.append("(REPLACE(UUID(), '-', ''), ");
			buffer.append("'" + smsPo.getFromid() + "', ");
			buffer.append("'" + smsPo.getPhone() + "', ");
			buffer.append("'" + smsPo.getContent() + "', now(), 0 ) ");

			stmt.executeUpdate(buffer.toString());

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}
}
