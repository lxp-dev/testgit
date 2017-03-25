package com.pengsheng.fr.analysis.goodssalesanalysis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Properties;

import com.fr.base.Parameter;
import com.fr.data.AbstractTableData;
import com.fr.data.TableDataException;
import com.pengsheng.eims.util.tools.Tools;
import com.pengsheng.eims.util.tools.Utility;

public class DS1 extends AbstractTableData {

    private static final long serialVersionUID = 8818000311745955539L;

    // 字段名枚举
    enum FIELD_NAME {
    	shopCode,departmentName,groupID,groupName,xsNum,thNum,xsje,thje,costje
    }

    private String[] columNames;

    private LinkedHashSet<LinkedHashMap<String, Object>> rowData;

    public DS1() {
        this.parameters = new Parameter[] { new Parameter("typeID"),new Parameter("checkDate") };

        // 填充字段名
        columNames = new String[FIELD_NAME.values().length];
        int i = 0;
        for (FIELD_NAME fieldName : FIELD_NAME.values()) {
            columNames[i] = fieldName.toString();
            i++;
        }
    }

    @Override
    public int getColumnCount() throws TableDataException {
        return columNames.length;
    }

    @Override
    public String getColumnName(int columnIndex) throws TableDataException {
        return columNames[columnIndex];
    }

    @Override
    public int getRowCount() throws TableDataException {
        queryData();
        return rowData.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        queryData();
        int tempRowIndex = 0;
        for (LinkedHashMap<String, Object> row : rowData) {
            if (tempRowIndex == rowIndex) {
                return row.get(columNames[columnIndex]);
            }
            tempRowIndex += 1;
        }
        return null;
    }

    // 查询数据
    private void queryData() {
        // 确保只被执行一次
        if (rowData != null) {
            return;
        }

        // 传入的参数
        String typeID = parameters[0].getValue().toString();
        String checkDate = parameters[1].getValue().toString();

        // 拼装SQL
        StringBuffer  sb = new StringBuffer();
        sb.append("SELECT shopCode, ");
        sb.append("       bd.B_DP_DepartmentName  AS departmentName, ");
        
        if(Utility.getName(typeID).equals("1")){
        	sb.append("       categoryID              AS groupID, ");
            sb.append("       B_GC_GoodsCategoryName  AS groupName, ");
        }else if(Utility.getName(typeID).equals("2")){
        	sb.append("       supplierID              AS groupID, ");
            sb.append("       B_SP_SupplierName  AS groupName, ");
        }
        
        sb.append("       Isnull(SUM(xsNum), '0') AS xsNum, ");
        sb.append("       Isnull(SUM(thNum), '0') AS thNum, ");
        sb.append("       Isnull(SUM(xsje), '0')  AS xsje, ");
        sb.append("       Isnull(SUM(thje), '0')  AS thje, ");
        sb.append("       ( CASE ");
        sb.append("           WHEN Isnull('${salesCost}', '') = '1' THEN Isnull(SUM(rateAmount), 0) ");
        sb.append("           WHEN Isnull('${salesCost}', '') = '2' THEN Isnull(SUM(notrateAmount), 0) ");
        sb.append("           WHEN Isnull('${salesCost}', '') = '3' THEN Isnull(SUM(avgAmount), 0) ");
        sb.append("           ELSE Isnull(SUM(rateAmount), 0) ");
        sb.append("         END )                 AS costje ");
        sb.append("FROM   R_RC_DaySalesEntry2 ");
        sb.append("       LEFT JOIN B_GoodsInfo ");
        sb.append("         ON B_GI_GoodsID = goodsID ");
        sb.append("       LEFT JOIN B_GoodsCategory ");
        sb.append("         ON categoryID = B_GC_ID ");
        sb.append("       LEFT JOIN B_Departments bd ");
        sb.append("         ON shopCode = B_DP_DepartmentID ");
        sb.append("       LEFT JOIN B_Supplier bs ");
        sb.append("         ON supplierID = B_SP_ID ");
        sb.append("       LEFT JOIN B_Brand ");
        sb.append("         ON supplierID = B_BD_SupplierID ");
        sb.append("            AND B_BD_ID = brandid ");
        sb.append("WHERE  1 = 1 ");
        
        if(!Utility.getName(checkDate).equals("")){
        	sb.append("       AND CONVERT(VARCHAR(10), checkdate, 120) >= '"+ checkDate +"' ");
        }
        
        sb.append("GROUP  BY shopCode, ");
        sb.append("          bd.B_DP_DepartmentName, ");
        
        if(Utility.getName(typeID).equals("1")){
        	sb.append("       categoryID,B_GC_GoodsCategoryName ");
        }else if(Utility.getName(typeID).equals("2")){
        	sb.append("       supplierID,B_SP_SupplierName");
        }

        rowData = new LinkedHashSet<LinkedHashMap<String, Object>>();

        Connection conn = this.getConnection();
        try {
            Statement stmt = conn.createStatement();
            // 执行查询
            ResultSet rs = stmt.executeQuery(sb.toString());
            while (rs.next()) {
                // 填充行数据
                // 注：字段赋值的顺序，要跟枚举里的顺序一样
                LinkedHashMap<String, Object> row = new LinkedHashMap<String, Object>();
                row.put(FIELD_NAME.shopCode.toString(),rs.getString(FIELD_NAME.shopCode.toString()));
                row.put(FIELD_NAME.departmentName.toString(),rs.getString(FIELD_NAME.departmentName.toString()));
                row.put(FIELD_NAME.groupID.toString(),rs.getString(FIELD_NAME.groupID.toString()));     
                row.put(FIELD_NAME.groupName.toString(), rs.getString(FIELD_NAME.groupName.toString()));       
                row.put(FIELD_NAME.xsNum.toString(),rs.getString(FIELD_NAME.xsNum.toString()));   
                row.put(FIELD_NAME.thNum.toString(),rs.getString(FIELD_NAME.thNum.toString()));     
                row.put(FIELD_NAME.xsje.toString(),rs.getString(FIELD_NAME.xsje.toString()));  
                row.put(FIELD_NAME.costje.toString(),rs.getString(FIELD_NAME.costje.toString()));                 
                rowData.add(row);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // 获取数据库连接
    public Connection getConnection() {   
    	Connection conn = null;   
    	Properties mySqlDriver = null;   
    	
    	try {
			mySqlDriver = Tools.getProperty("/config/", "reprotJDBC.properties");

			Class.forName(mySqlDriver.getProperty("jdbc.driverClassName"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
        try {   
            Class.forName(mySqlDriver.getProperty("jdbc.driverClassName"));   
			conn = DriverManager.getConnection(mySqlDriver
					.getProperty("jdbc.url"), mySqlDriver
					.getProperty("jdbc.username"), mySqlDriver
					.getProperty("jdbc.password"));
        } catch (Exception e) {   
            e.printStackTrace();   
            return null;   
        }   
        return conn;   
    } 


    // 释放资源
    public void release() throws Exception {
        super.release();
        this.rowData = null;
    }

}
