package com.pengsheng.eims.util.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.pengsheng.eims.util.bean.BeanProcessor;
import com.pengsheng.eims.util.bean.UUIDHexGenerator;



public class BaseJdbcDaoSupport extends JdbcDaoSupport {

	protected UUIDHexGenerator uuid = UUIDHexGenerator.getInstance();

	private BeanProcessor beanProcessor;

	public BeanProcessor getBeanProcessor() {
		return beanProcessor;
	}

	public void setBeanProcessor(BeanProcessor beanProcessor) {
		this.beanProcessor = beanProcessor;
	}

	/**
	 * 获取�?��记录
	 */
	public Map getRsData(String sql) {
		Connection conn = null;
		Map data = null;
		ResultSet rs = null;
		java.sql.Statement stmt = null;

		try {
			if (sql.length() > 0) {
				conn = this.getJdbcTemplate().getDataSource().getConnection();
				stmt = conn.createStatement();
				if (stmt != null) {
					rs = stmt.executeQuery(sql);
					ResultSetMetaData rsmd = rs.getMetaData();
					data = new HashMap();
					if (rs.next()) {
						for (int i = 1; i <= rsmd.getColumnCount(); i++) {
							data.put(rsmd.getColumnName(i), rs.getString(i));
						}
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.err.println("System Error");
			}
		}
		if (data == null) {
			return new HashMap();
		}
		return data;
	}

	/**
	 * 获取多条记录
	 */
	public List getRsList(String sql) {
		// Connection conn = null;
		// // List list = new ArrayList();
		// ResultSet rs = null;
		// java.sql.Statement stmt = null;

		// try {
		if (sql.length() > 0) {
			return (List) this.getJdbcTemplate().query(sql,
					new ResultSetExtractor() {

						public Object extractData(ResultSet rs)
								throws SQLException, DataAccessException {
							// TODO Auto-generated method stub
							ResultSetMetaData rsmd = rs.getMetaData();
							List list = new ArrayList();
							while (rs.next()) {
								Map data = new HashMap();
								for (int i = 1; i <= rsmd.getColumnCount(); i++) {
									data.put(rsmd.getColumnName(i), rs
											.getString(i));
								}
								list.add(data);
							}
							return list;
						}

					});
		} else {
//			System.out.println("SQL语句不能为空!");
		}

		return new ArrayList();

		// conn = this.getJdbcTemplate().getDataSource().getConnection();
		// stmt = conn.createStatement();
		// if (stmt != null) {
		// rs = stmt.executeQuery(sql);
		// ResultSetMetaData rsmd = rs.getMetaData();
		//
		// while (rs.next()) {
		// Map data = new HashMap();
		// for (int i = 1; i <= rsmd.getColumnCount(); i++) {
		// data.put(rsmd.getColumnName(i), rs.getString(i));
		// }
		// // list.add(data);
		// }
		// }
		// } else {
		// System.out.println("SQL语句不能为空!");
		// }
		// } catch (Exception e) {
		// e.printStackTrace();
		// } finally {
		// try {
		// if (rs != null)
		// rs.close();
		// if (stmt != null)
		// stmt.close();
		// if (conn != null)
		// conn.close();
		// } catch (SQLException e1) {
		// e1.printStackTrace();
		// }
		// }
		//
		// return list;
	}

	/**
	 * 以List方式返回查询结果，list中每个对象为�?��PO
	 */
	public List queryForObjectList(String sql, Object[] args, final Class clazz) {
		return (List) getJdbcTemplate().query(sql, args,
				new ResultSetExtractor() {
					public Object extractData(ResultSet resultSet)
							throws SQLException, DataAccessException {
						return getBeanProcessor().toBeanList(resultSet, clazz);
					}

				});
	}

	/**
	 * 得到�?��数据，返回的Object为一个PO
	 */
	public Object queryForObject(String sql, Object[] args, final Class clazz) {
		Object obj = null;

		try {
			return getJdbcTemplate().queryForObject(sql, args, new RowMapper() {

				public Object mapRow(ResultSet rs, int arg1)
						throws SQLException {
					Object obj = (Object) getBeanProcessor().toBean(rs, clazz);
					return obj;
				}

			});
		} catch (Exception e) {

		}

		if (obj == null) {
			try {
				obj = clazz.newInstance();
				return obj;
			} catch (Exception e1) {

			}
		}

		return obj;
	}

}
