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

public class DS2 extends AbstractTableData {

    private static final long serialVersionUID = 8818000311745955539L;

    // 字段名枚举
    enum FIELD_NAME {
    	departmentid,
    	departmentname,
    	goodsid,
    	goodsname,
    	categoryid,
    	categoryname,
    	supplierid,
    	suppliername,
    	brandid,
    	brandname,
    	price,
    	num,
    	salesnum,
    	salesvalue,
    	salescost,
    	maoli,
    	maolilv
    }

    private String[] columNames;

    private LinkedHashSet<LinkedHashMap<String, Object>> rowData;

    public DS2() {
        this.parameters = new Parameter[] { 
        		new Parameter("departmentid"),
        		new Parameter("begindate"),
        		new Parameter("enddate"),
        		new Parameter("categoryid"),
        		new Parameter("supplierid"),
        		new Parameter("brandid"),
        		new Parameter("goodsid"),
        		new Parameter("goodsname"),
        		new Parameter("pricemin"),
        		new Parameter("pricemax"),
        		new Parameter("iszz"),
        		new Parameter("whichcost")
        		};

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
        String departmentid = parameters[0].getValue().toString();
        String begindate = parameters[1].getValue().toString();
        String enddate = parameters[2].getValue().toString();
        String categoryid = parameters[3].getValue().toString();
        String supplierid = parameters[4].getValue().toString();
        String brandid = parameters[5].getValue().toString();
        String goodsid = parameters[6].getValue().toString();
        String goodsname = parameters[7].getValue().toString();
        String pricemin = parameters[8].getValue().toString();
        String pricemax = parameters[9].getValue().toString();
        String iszz = parameters[10].getValue().toString();
        String whichcost = parameters[11].getValue().toString();
        
        // 拼装SQL
        StringBuffer  sb = new StringBuffer();
        
        
		sb.append("if exists (select * from tempdb.dbo.sysobjects where id = object_id(N'tempdb..#stocktmp') and type='U')");
		sb.append("DROP TABLE #stocktmp ");
		sb.append("select * into #stocktmp from dbo.Strtotable('"+departmentid+"') ");
		
		sb.append("if exists (select * from tempdb.dbo.sysobjects where id = object_id(N'tempdb..#goodstemp') and type='U')");
		sb.append("DROP TABLE #goodstemp ");	
		sb.append("SELECT ");
        sb.append(" deptid                 AS departmentid, ");
        sb.append(" goodsid                AS goodsid, ");
        sb.append(" B_GC_ID                AS categoryid, ");
        sb.append(" B_GC_GoodsCategoryName AS categoryname, ");
        sb.append(" B_SP_ID                AS supplierid, ");
        sb.append(" B_SP_SupplierName      AS suppliername, ");
        sb.append(" B_BD_ID                AS brandid, ");
        sb.append(" B_BD_brandName         AS brandname, ");
        sb.append(" retailprice            AS price, ");
        sb.append(" SUM(knumber)           AS num, ");
        sb.append(" SUM(xnumber)           AS salesnum, ");
        sb.append(" SUM(salesvalue)        AS salesvalue, ");
        if("1".equals(whichcost)){
        	sb.append("SUM(costprice)                   						 AS salescost, ");
            sb.append("SUM(isnull(salesvalue,0.00)) - SUM(isnull(costprice,0.00)) 						 AS maoli ");
        }
        if("2".equals(whichcost)){
        	sb.append(" SUM(nottaxrate)                   						 AS salescost, ");
            sb.append(" SUM(isnull(salesvalue,0.00)) - SUM(isnull(nottaxrate,0.00)) 						 AS maoli ");
        }
        if("3".equals(whichcost)){
        	sb.append(" SUM(avgamount)                   						 AS salescost, ");
            sb.append(" SUM(isnull(salesvalue,0.00)) - SUM(isnull(avgamount,0.00)) 						 AS maoli ");
        }
        sb.append("into #goodstemp FROM  ( ");
        
        sb.append(" SELECT S_SE_SB_ShopCode        AS deptid, ");
        sb.append("        substring(S_SE_SD_SalesItemID,1,7)     AS goodsid, ");
        sb.append("        S_SE_SD_Sprice          AS retailprice, ");
        sb.append("        0                       AS knumber, ");
        sb.append("        SUM(S_SE_SD_Number)     AS xnumber, ");
        sb.append("        SUM(S_SE_SD_SalesValue) AS salesvalue, ");
        sb.append("        SUM(B_GI_CostPrice*S_SE_SD_Number)   			AS costprice, ");
        sb.append("        SUM(B_GI_NotTaxRate*S_SE_SD_Number)   			AS nottaxrate, ");
        sb.append("        SUM(B_GI_AverageNotTaxRate*S_SE_SD_Number)   	AS avgamount ");
        sb.append(" FROM   S_SE_SalesBasic_Today ");
        sb.append("        INNER JOIN S_SE_SalesDetail_Today ");
        sb.append("          ON S_SE_SB_SalesID = S_SE_SD_SalesID ");
        sb.append("		INNER JOIN B_GoodsInfo ");
        sb.append("         		  ON S_SE_SD_SalesItemID = B_GI_GoodsID ");
        if(!"".equals(Utility.getName(departmentid))){
        	sb.append("      inner join #stocktmp on S_SE_SB_ShopCode = #stocktmp.str2table ");
        }
        sb.append("          where 1=1 ");
        if(!"".equals(Utility.getName(begindate))){
        	sb.append("        and (CONVERT(VARCHAR(10),S_SE_SB_PosDatetime,23) >= CONVERT(VARCHAR(10),getdate(),23) and CONVERT(VARCHAR(10),getdate(),23) <= '"+enddate+"') ");
        }
        if(!"".equals(Utility.getName(enddate))){
        	sb.append("        and (CONVERT(VARCHAR(10),S_SE_SB_PosDatetime,23) <= CONVERT(VARCHAR(10),getdate(),23) and CONVERT(VARCHAR(10),getdate(),23) <= '"+enddate+"') ");
        }
        sb.append(" GROUP  BY substring(S_SE_SD_SalesItemID,1,7), ");
        sb.append("           S_SE_SB_ShopCode,S_SE_SD_Sprice ");
        
        sb.append(" UNION ALL ");
        
        sb.append(" SELECT S_SE_SB_ShopCode        AS deptid, ");
        sb.append("        substring(S_SE_SD_SalesItemID,1,7)     AS goodsid, ");
        sb.append("        S_SE_SD_Sprice          AS retailprice, ");
        sb.append("        0                       AS knumber, ");
        sb.append("        -SUM(S_SE_SD_Number)     AS xnumber, ");
        sb.append("        -SUM(S_SE_SD_SalesValue) AS salesvalue, ");
        sb.append("        -SUM(B_GI_CostPrice*S_SE_SD_Number)   			AS costprice, ");
        sb.append("        -SUM(B_GI_NotTaxRate*S_SE_SD_Number)   			AS nottaxrate, ");
        sb.append("        -SUM(B_GI_AverageNotTaxRate*S_SE_SD_Number)   	AS avgamount ");
        sb.append(" FROM   S_SE_SalesBasic_Today ");
        sb.append("        INNER JOIN S_SE_SalesDetail_Today ");
        sb.append("          ON S_SE_SB_SalesID = S_SE_SD_SalesID ");
        sb.append("		INNER JOIN B_GoodsInfo ");
        sb.append("  		  ON S_SE_SD_SalesItemID = B_GI_GoodsID ");
        if(!"".equals(Utility.getName(departmentid))){
        	sb.append("      inner join #stocktmp on S_SE_SB_ShopCode = #stocktmp.str2table ");
        }
        sb.append("          where 1=1 ");
        if(!"".equals(Utility.getName(begindate))){
        	sb.append("        and (CONVERT(VARCHAR(10),S_SE_SB_WithdrawDate,23) >= CONVERT(VARCHAR(10),getdate(),23) and CONVERT(VARCHAR(10),getdate(),23) <= '"+enddate+"') ");
        }
        if(!"".equals(Utility.getName(enddate))){
        	sb.append("        and (CONVERT(VARCHAR(10),S_SE_SB_WithdrawDate,23) <= CONVERT(VARCHAR(10),getdate(),23) and CONVERT(VARCHAR(10),getdate(),23) <= '"+enddate+"') ");
        }
        sb.append(" GROUP  BY substring(S_SE_SD_SalesItemID,1,7), ");
        sb.append("           S_SE_SB_ShopCode,S_SE_SD_Sprice ");
        
        sb.append(" UNION ALL ");
        
        sb.append("          select L_CT_CT_DepartmentID 			AS deptid, ");
        sb.append("          SUBSTRING (L_CT_CT_GoodsID,1,7) 		as goodsid, ");
        sb.append("          B_GI_RetailPrice        				AS retailprice, ");
        sb.append("          sum(L_CT_CT_GoodsQuantity) 			as knumber, ");
        sb.append("                 0                          		AS xnumber, ");
        sb.append("                 0                          		AS salesvalue, ");
        sb.append("                 0   					   		AS costprice, ");
        sb.append("                 0   					   		AS nottaxrate, ");
        sb.append("                 0   					   		AS avgamount ");
        sb.append("          from L_CT_CostingTemplate ");
        sb.append("         		LEFT JOIN B_GoodsInfo ");
        sb.append("           		  ON L_CT_CT_GoodsID = B_GI_GoodsID ");
        sb.append("					LEFT JOIN B_Departments ");
        sb.append("           		  ON B_DP_DepartmentID = L_CT_CT_DepartmentID ");
        if(!"".equals(Utility.getName(departmentid))){
        	sb.append("      inner join #stocktmp on L_CT_CT_DepartmentID = #stocktmp.str2table ");
        }
        sb.append("          where 1=1 and B_DP_Type = '1' ");
        sb.append("           		  group by SUBSTRING (L_CT_CT_GoodsID,1,7),B_GI_RetailPrice,L_CT_CT_DepartmentID ");
        
        sb.append(" UNION ALL ");
        
        sb.append("        SELECT B_WH_deptID         AS deptid, ");
        sb.append("        R_GS_BR_BrandID            AS goodsid, ");
        sb.append("        R_GS_BR_RetailPrice        AS retailprice, ");
        sb.append("        sum(isnull(R_GS_BR_Caigounum,0) + isnull(R_GS_BR_Diaobonum,0) + isnull(R_GS_BR_Xiaoshounum,0) + isnull(R_GS_BR_Pankuinum,0) + isnull(R_GS_BR_Panyingnum,0) + isnull(R_GS_BR_Lingyongnum,0) + isnull(R_GS_BR_Kehupifanum,0)) AS knumber, ");
        sb.append("        0                          AS xnumber, ");
        sb.append("        0                          AS salesvalue, ");
        sb.append("        0   					   AS costprice, ");
        sb.append("        0   					   AS nottaxrate, ");
        sb.append("        0   					   AS avgamount ");
        sb.append(" FROM   R_GS_BrandStorageRevolveRate ");
        sb.append("        INNER JOIN B_Warehouse ");
        sb.append("          ON R_GS_BR_WarehouseID = B_WH_ID ");
        sb.append("		   INNER JOIN B_Departments ");
        sb.append("           		  ON B_DP_DepartmentID = B_WH_deptID ");
        if(!"".equals(Utility.getName(departmentid))){
        	sb.append("      inner join #stocktmp on B_WH_deptID = #stocktmp.str2table ");
        }
        sb.append("          where 1=1 and B_DP_Type = '1' ");
        if(!"".equals(Utility.getName(enddate))){
        	sb.append("        and CONVERT(VARCHAR(10),R_GS_BR_Date,23) <= '"+enddate+"' ");
        }
        sb.append(" GROUP  BY R_GS_BR_BrandID, ");
        sb.append("           B_WH_deptID,R_GS_BR_RetailPrice ");
        
        sb.append(" UNION ALL ");
        
        sb.append(" SELECT R_RC_DE_ShopCode     		AS deptid, ");
        sb.append("        R_RC_DE_BrandID      		AS goodsid, ");
        sb.append("        R_RC_DE_RetailPrice         AS retailprice, ");
        sb.append("        0                        	AS knumber, ");
        sb.append("        SUM(R_RC_DE_GoodsNum)       AS xnumber, ");
        sb.append("        SUM(R_RC_DE_GoodsAmount)  	AS salesvalue, ");
        sb.append("        SUM(R_RC_DE_GoodsRateAmount)   	AS costprice, ");
        sb.append("        SUM(R_RC_DE_GoodsNotRateAmount) AS nottaxrate, ");
        sb.append("        SUM(R_RC_DE_GoodsAvgAmount)   	AS avgamount ");
        sb.append(" FROM   R_RC_DayBrandSalesEntry ");
        sb.append("		   INNER JOIN B_Departments ");
        sb.append("           		  ON B_DP_DepartmentID = R_RC_DE_ShopCode ");
        if(!"".equals(Utility.getName(departmentid))){
        	sb.append("      inner join #stocktmp on R_RC_DE_ShopCode = #stocktmp.str2table ");
        }
        sb.append("          where 1=1 and B_DP_Type = '1' ");
        if(!"".equals(Utility.getName(begindate))){
        	sb.append("        and CONVERT(VARCHAR(10),R_RC_DE_Date,23) >= '"+begindate+"' ");
        }
        if(!"".equals(Utility.getName(enddate))){
        	sb.append("        and CONVERT(VARCHAR(10),R_RC_DE_Date,23) <= '"+enddate+"' ");
        }
        sb.append(" GROUP  BY R_RC_DE_BrandID, ");
        sb.append("           R_RC_DE_ShopCode,R_RC_DE_RetailPrice ");
        
        if("1".equals(Utility.getName(iszz))){
        	sb.append("          UNION ALL ");
            
            sb.append(" SELECT R_SD_DSE_ShopCode     		AS deptid, ");
            sb.append("        substring(R_RC_DSE_GoodsID,1,7)      		AS goodsid, ");
            sb.append("        0.00        					AS retailprice, ");
            sb.append("        0                        	AS knumber, ");
            sb.append("        SUM(R_SD_DSE_GoodsNum)     	AS xnumber, ");
            sb.append("        SUM(R_SD_DSE_GoodsAmount)  	AS salesvalue, ");
            sb.append("        0.00 						AS costprice, ");
            sb.append("        0.00 						AS nottaxrate, ");
            sb.append("        0.00 						AS AvgAmount ");
            sb.append(" FROM   R_RC_DaySalesEntry_ZZ ");
            if(!"".equals(Utility.getName(departmentid))){
            	sb.append("      inner join #stocktmp on R_SD_DSE_ShopCode = #stocktmp.str2table ");
            }
            sb.append("          where 1=1 ");
            if(!"".equals(Utility.getName(begindate))){
            	sb.append("        and CONVERT(VARCHAR(10),R_SD_DSE_Date,23) >= '"+begindate+"' ");
            }
            if(!"".equals(Utility.getName(enddate))){
            	sb.append("        and CONVERT(VARCHAR(10),R_SD_DSE_Date,23) <= '"+enddate+"' ");
            }
            sb.append("          GROUP  BY substring(R_RC_DSE_GoodsID,1,7), ");
            sb.append("                    R_SD_DSE_ShopCode ");
        }
        
        sb.append("  ) TEMP ");

        sb.append(" left JOIN B_GoodsCategory ");
        sb.append("   ON B_GC_ID = substring(goodsid,1,1) ");
        sb.append(" left JOIN B_Supplier ");
        sb.append("   ON B_SP_ID = substring(goodsid,3,2) ");
        sb.append(" left JOIN B_Brand ");
        sb.append("   ON substring(goodsid,6,2) = B_BD_ID ");
        sb.append("      AND substring(goodsid,3,2) = B_BD_SupplierID ");
        sb.append("   WHERE  1 = 1 ");
        if(!"".equals(Utility.getName(categoryid))){
        	sb.append("        and substring(goodsid,1,1) = '"+categoryid+"' ");
        }
        if(!"".equals(Utility.getName(supplierid))){
        	sb.append("        and substring(goodsid,3,2) = '"+supplierid+"' ");
        }
        if(!"".equals(Utility.getName(brandid))){
        	sb.append("        and substring(goodsid,6,2) = '"+brandid+"' ");
        }
        if(!"".equals(Utility.getName(goodsid))){
        	sb.append("        and goodsid like '%'+'"+goodsid+"'+'%' ");
        }
        if(!"".equals(Utility.getName(goodsname))){
        	sb.append("        and goodsid like '%"+goodsname+"%' ");
        }
        if(!"".equals(Utility.getName(pricemin))){
        	sb.append("        and retailprice >= "+pricemin+" ");
        }
        if(!"".equals(Utility.getName(pricemax))){
        	sb.append("        and retailprice <= "+pricemax+" ");
        }
        sb.append("   GROUP  BY deptid, ");
        sb.append("  goodsid, ");
        sb.append("  B_GC_ID, ");
        sb.append("  B_GC_GoodsCategoryName, ");
        sb.append("  B_SP_ID, ");
        sb.append("  B_SP_SupplierName, ");
        sb.append("  B_BD_ID, ");
        sb.append("  B_BD_brandName, ");
        sb.append("  retailprice ");
        
        
        sb.append("  SELECT departmentid     				AS departmentid, ");
        sb.append("  B_DP_DepartmentName             AS departmentname, ");
        sb.append("  goodsid      					AS goodsid, ");
        sb.append("  categoryid                      AS categoryid, ");
        sb.append("  categoryname          			AS categoryname, ");
        sb.append("  supplierid                      AS supplierid, ");
        sb.append("  suppliername                    AS suppliername, ");
        sb.append("  brandid                         AS brandid, ");
        sb.append("  brandname                       AS brandname, ");
        sb.append("  price         					AS price, ");
        sb.append("  ISNULL(num,0)          			AS num, ");
        sb.append("  ISNULL(salesnum,0)       		AS salesnum, ");
        sb.append("  ISNULL(salesvalue,0)  			AS salesvalue, ");
        sb.append("  ISNULL(salescost,0)   			AS salescost, ");
        sb.append("  ISNULL(maoli,0) 				as maoli, ");
        sb.append(" 	case ");
        sb.append(" 		when salesvalue = 0 then 0.00 ");
        sb.append(" 		ELSE cast((maoli / salesvalue * 100) as numeric(18,2))  ");
        sb.append(" 	end   							AS maolilv ");
        sb.append("   FROM   #goodstemp ");
        sb.append("   Inner JOIN B_Departments ");
        sb.append("   ON B_DP_DepartmentID = departmentid ");
        sb.append(" where B_DP_Type = '1'  ");
        
        rowData = new LinkedHashSet<LinkedHashMap<String, Object>>();
        System.out.print(sb.toString());
        Connection conn = this.getConnection();
        try {
            Statement stmt = conn.createStatement();
            // 执行查询
            ResultSet rs = stmt.executeQuery(sb.toString());
            while (rs.next()) {
                // 填充行数据
                // 注：字段赋值的顺序，要跟枚举里的顺序一样
                LinkedHashMap<String, Object> row = new LinkedHashMap<String, Object>();
            	row.put(FIELD_NAME.departmentid.toString(),rs.getString(FIELD_NAME.departmentid.toString()));
                row.put(FIELD_NAME.departmentname.toString(),rs.getString(FIELD_NAME.departmentname.toString()));
                row.put(FIELD_NAME.goodsid.toString(),rs.getString(FIELD_NAME.goodsid.toString()));
                row.put(FIELD_NAME.categoryid.toString(),rs.getString(FIELD_NAME.categoryid.toString()));
                row.put(FIELD_NAME.categoryname.toString(),rs.getString(FIELD_NAME.categoryname.toString()));
                row.put(FIELD_NAME.supplierid.toString(),rs.getString(FIELD_NAME.supplierid.toString()));
                row.put(FIELD_NAME.suppliername.toString(),rs.getString(FIELD_NAME.suppliername.toString()));
                row.put(FIELD_NAME.brandid.toString(),rs.getString(FIELD_NAME.brandid.toString()));     
                row.put(FIELD_NAME.brandname.toString(), rs.getString(FIELD_NAME.brandname.toString()));    
                row.put(FIELD_NAME.price.toString(),rs.getString(FIELD_NAME.price.toString()));  
                row.put(FIELD_NAME.num.toString(),rs.getString(FIELD_NAME.num.toString()));   
                row.put(FIELD_NAME.salesnum.toString(),rs.getString(FIELD_NAME.salesnum.toString()));     
                row.put(FIELD_NAME.salesvalue.toString(),rs.getString(FIELD_NAME.salesvalue.toString()));  
                row.put(FIELD_NAME.salescost.toString(),rs.getString(FIELD_NAME.salescost.toString()));  
                row.put(FIELD_NAME.maoli.toString(),rs.getString(FIELD_NAME.maoli.toString())); 
                row.put(FIELD_NAME.maolilv.toString(),rs.getString(FIELD_NAME.maolilv.toString())); 
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
