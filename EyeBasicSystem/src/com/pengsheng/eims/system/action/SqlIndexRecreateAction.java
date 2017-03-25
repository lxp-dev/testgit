package com.pengsheng.eims.system.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import com.pengsheng.eims.basic.mgr.BrandMgr;
import com.pengsheng.eims.system.mgr.SqlIndexRecreateMgr;
import com.pengsheng.eims.system.persistence.SqlIndexRecreatePo;
import com.pengsheng.eims.util.basicaction.BaseAction;

/**
 * 数据库索引重建Action
 * 
 * @author mysflying
 * @version 1.0
 */
public class SqlIndexRecreateAction extends BaseAction{

	private SqlIndexRecreateMgr sqlIndexRecreateMgr;
	private List<SqlIndexRecreatePo> sqlIndexRecreateList;
	
	/**
	 * 索引重建页面初始化
	 * 
	 * @return 
	 */
	public String initSqlIndexRecreate() {
		
		return SUCCESS;
	}
	
	/**
	 * 初始新增银行卡页面
	 * 
	 * @return
	 */
	public void execSqlIndexRecreate(){
		sqlIndexRecreateMgr.noSqlIndexCreate();	
	}
	
	public void getAjaxIndexCreateList() {

		String result="";
        try {
        	response.setContentType("text/html;charset=utf-8"); 
    		PrintWriter out;
            out = response.getWriter();
            sqlIndexRecreateList =sqlIndexRecreateMgr.noSelectSqlIndexRecreateList();
            
            if(sqlIndexRecreateList!=null){
            	Iterator it = sqlIndexRecreateList.iterator();
            	while(it.hasNext()){
            		result = result + ((SqlIndexRecreatePo)it.next()).getIndexcontent() + "<br>";
            	}
            }
            out.print(result);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	public SqlIndexRecreateMgr getSqlIndexRecreateMgr() {
		return sqlIndexRecreateMgr;
	}

	public void setSqlIndexRecreateMgr(SqlIndexRecreateMgr sqlIndexRecreateMgr) {
		this.sqlIndexRecreateMgr = sqlIndexRecreateMgr;
	}

	
}
