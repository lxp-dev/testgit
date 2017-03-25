package com.pengsheng.weixin.dao.impl;

import java.util.ArrayList;
import java.util.List;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.weixin.dao.WeiXinOptometryAppointmentDao;
import com.pengsheng.weixin.persistence.WeiXinOptometryAppointmentPo;

public class WeiXinOptometryAppointmentDaoImpl extends BaseJdbcDaoSupport implements WeiXinOptometryAppointmentDao{

	public void deleteWeiXinOptometryAppointmentPo(WeiXinOptometryAppointmentPo po) {
		StringBuffer buffer = new StringBuffer();

		buffer.append("delete from W_OptometryAppointment where W_O_A_ID = '"+ po.getWoaid() +"'");
		
		getJdbcTemplate().update(buffer.toString());
	}

	public void insertWeiXinOptometryAppointmentPo(WeiXinOptometryAppointmentPo po) {
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("INSERT INTO W_OptometryAppointment ");
		buffer.append("            (W_O_A_ID, W_O_A_CustomerId,");
		buffer.append("             W_O_A_Name, ");
		buffer.append("             W_O_A_Mobilephone, ");
		buffer.append("             W_O_A_Content, ");		
		buffer.append("             W_O_A_Isconfirm, ");			
		buffer.append("             W_O_A_Datetime, ");
		buffer.append("             W_O_A_Hour, ");
		buffer.append("             W_O_A_Minute, ");
		buffer.append("             W_O_A_Diyu, ");
		buffer.append("             W_O_A_Wangdian, ");
		buffer.append("             W_O_A_Zhenliao, ");
		buffer.append("             W_O_A_Account, ");
		buffer.append("             W_O_A_DoctorID) ");		
		buffer.append("VALUES      ( '"+ this.uuid.generate() +"', ");
		buffer.append("              '"+ Utility.getName(po.getWoaopencustomerid()) +"', ");					
		buffer.append("              '"+ Utility.getName(po.getWoaname()) +"', ");
		buffer.append("              '"+ Utility.getName(po.getWoamobilephone()) +"', ");
		buffer.append("              '"+ Utility.getName(po.getWoacontent()) +"', ");
		buffer.append("              '0', ");
		buffer.append("              '"+ Utility.getName(po.getWoadatetime()) +"', ");
		buffer.append("              '"+ Utility.getName(po.getWoahour()) +"', ");
		buffer.append("              '"+ Utility.getName(po.getWoaminute()) +"', ");
		buffer.append("              '"+ Utility.getName(po.getWoadiyu()) +"', ");;
		buffer.append("              '"+ Utility.getName(po.getWoawangdian()) +"', ");
		buffer.append("              '"+ Utility.getName(po.getWoazhenliao()) +"', ");
		buffer.append("              '"+ Utility.getName(po.getWoaaccount()) +"', ");
		buffer.append("              '"+ Utility.getName(po.getWoadoctorid()) +"'");
		buffer.append("             ) ");
		
		getJdbcTemplate().update(buffer.toString());
	}

	public WeiXinOptometryAppointmentPo selectWeiXinOptometryAppointmentPo(
			WeiXinOptometryAppointmentPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("SELECT TOP 1 W_O_A_ID      				AS woaid ");
		buffer.append("             ,W_O_A_CustomerId    		AS woaopencustomerid ");
		buffer.append("             ,W_O_A_Name		       		AS woaname ");
		buffer.append("             ,W_O_A_Mobilephone    		AS woamobilephone ");
		buffer.append("             ,W_O_A_Content    			AS woacontent ");
		buffer.append("             ,W_O_A_Datetime    			AS woadatetime ");
		buffer.append("             ,W_O_A_Hour    				AS woahour ");
		buffer.append("             ,W_O_A_Minute    			AS woaminute ");
		buffer.append("             ,W_O_A_Diyu    				AS woadiyu ");
		buffer.append("             ,W_O_A_Wangdian    			AS woawangdian ");
		buffer.append("             ,fo1.F_OP_ParamName			AS woawangdianname ");
		buffer.append("             ,W_O_A_Zhenliao    			AS woazhenliao ");
		buffer.append("             ,fo2.F_OP_ParamName			AS woazhenliaoname ");
		buffer.append("             ,W_O_A_Isconfirm    		AS woaisconfirm ");
		buffer.append("             ,W_O_A_Confirmpersonid    	AS woaconfirmpersonid ");
		buffer.append("             ,p1.personName				    AS woaconfirmpersonname ");
		buffer.append("             ,W_O_A_Confirmcontent    	AS woaconfirmcontent ");
		buffer.append("             ,W_O_A_Confirmdatetime    	AS woaconfirmdatetime ");
		buffer.append("             ,W_O_A_Account		    	AS woaaccount ");
		buffer.append("             ,W_O_A_DoctorID		    	AS woadoctorid ");
		buffer.append("             ,p2.personName		    	AS woadoctorname ");

		buffer.append("FROM   W_OptometryAppointment ");
		buffer.append(" left join SYS_PersonInfo p1 on W_O_A_ID = p1.id ");
		buffer.append(" left join SYS_PersonInfo p2 on W_O_A_DoctorID = p2.id ");
		buffer.append(" left join F_OptionParam fo1 on W_O_A_Wangdian = fo1.F_OP_ParamID ");
		buffer.append(" left join F_OptionParam fo2 on W_O_A_Zhenliao = fo2.F_OP_ParamID ");
		buffer.append("WHERE  1=1 ");
		
		if(!"".equals(Utility.getName(po.getWoaid()))){
			buffer.append("AND W_O_A_ID = ? ");
			params.add(Utility.getName(po.getWoaid()));
		}
		if(!"".equals(Utility.getName(po.getWoaopencustomerid()))){
			buffer.append("AND W_O_A_CustomerId = ? ");
			params.add(Utility.getName(po.getWoaopencustomerid()));
		}		

		if(!"".equals(Utility.getName(po.getWoaisconfirm()))){
			buffer.append("AND W_O_A_Isconfirm = ? ");
			params.add(Utility.getName(po.getWoaisconfirm()));
		}		
		if(!"".equals(Utility.getName(po.getWoaname()))){
			buffer.append("AND W_O_A_Name like '%' + ? + '%' ");
			params.add(Utility.getName(po.getWoaname()));
		}	
		if(!"".equals(Utility.getName(po.getWoamobilephone()))){
			buffer.append("AND W_O_A_Mobilephone = ? ");
			params.add(Utility.getName(po.getWoamobilephone()));
		}		
		return (WeiXinOptometryAppointmentPo) queryForObject(buffer.toString(), params.toArray(), WeiXinOptometryAppointmentPo.class);
	}	

	public void updateWeiXinOptometryAppointmentPo(WeiXinOptometryAppointmentPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("Update W_OptometryAppointment set ");
		buffer.append("             W_O_A_Isconfirm = ? ");
		buffer.append("             ,W_O_A_Confirmpersonid = ? ");	
		buffer.append("             ,W_O_A_Confirmcontent = ? ");
		buffer.append("             ,W_O_A_Confirmdatetime = getdate() ");
		buffer.append("where W_O_A_ID = ? ");
		
		params.add(Utility.getName(po.getWoaisconfirm()));
		params.add(Utility.getName(po.getWoaconfirmpersonid()));	
		params.add(Utility.getName(po.getWoaconfirmcontent()));
		params.add(Utility.getName(po.getWoaid()));		
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	public int selectWeiXinOptometryAppointmentCount(WeiXinOptometryAppointmentPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("SELECT count(W_O_A_ID) ");
		buffer.append("FROM   W_OptometryAppointment ");
		buffer.append(" left join SYS_PersonInfo on W_O_A_ID = SYS_PersonInfo.id ");
		buffer.append(" left join B_Departments on W_O_A_DepartmentID = B_DP_DepartmentID ");

		buffer.append("WHERE  1=1 ");
		
		if(!"".equals(Utility.getName(po.getWoaid()))){
			buffer.append("AND W_O_A_ID = ? ");
			params.add(Utility.getName(po.getWoaid()));
		}
		if(!"".equals(Utility.getName(po.getWoawangdian()))){
			buffer.append("AND W_O_A_Wangdian = ? ");
			params.add(Utility.getName(po.getWoawangdian()));
		}		
		if(!"".equals(Utility.getName(po.getWoadoctorid()))){
			buffer.append("AND W_O_A_DoctorID = ? ");
			params.add(Utility.getName(po.getWoadoctorid()));
		}
		if(!"".equals(Utility.getName(po.getWoaisconfirm()))){
			buffer.append("AND W_O_A_Isconfirm = ? ");
			params.add(Utility.getName(po.getWoaisconfirm()));
		}		
		if(!"".equals(Utility.getName(po.getWoaname()))){
			buffer.append("AND W_O_A_Name like '%' + ? + '%' ");
			params.add(Utility.getName(po.getWoaname()));
		}	
		if(!"".equals(Utility.getName(po.getWoamobilephone()))){
			buffer.append("AND W_O_A_Mobilephone = ? ");
			params.add(Utility.getName(po.getWoamobilephone()));
		}		
		if(!"".equals(Utility.getName(po.getWoastartTime()))){
			buffer.append("and convert(varchar(10), W_O_A_Datetime, 23) >= ? ");
			params.add(po.getWoastartTime());
			
		}
		if(!"".equals(Utility.getName(po.getWoaendTime()))){
			buffer.append("and convert(varchar(10), W_O_A_Datetime, 23) <= ? ");
			params.add(po.getWoaendTime());
			
		}
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}

	public List<WeiXinOptometryAppointmentPo> selectWeiXinOptometryAppointmentList(
			WeiXinOptometryAppointmentPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("SELECT	    W_O_A_ID      				AS woaid ");
		buffer.append("             ,W_O_A_CustomerId    		AS woaopencustomerid ");
		buffer.append("             ,W_O_A_Name		       		AS woaname ");
		buffer.append("             ,W_O_A_Mobilephone    		AS woamobilephone ");
		buffer.append("             ,W_O_A_Content    			AS woacontent ");
		buffer.append("             ,W_O_A_Datetime    			AS woadatetime ");
		buffer.append("             ,W_O_A_Hour    				AS woahour ");
		buffer.append("             ,W_O_A_Minute    			AS woaminute ");
		buffer.append("             ,op1.F_OP_ParamName			AS woadiyu ");
		buffer.append("             ,op2.F_OP_ParamName			AS woawangdian ");
		buffer.append("             ,op3.F_OP_ParamName			AS woazhenliao ");
		buffer.append("             ,W_O_A_Isconfirm    		AS woaisconfirm ");
		buffer.append("             ,W_O_A_Confirmpersonid    	AS woaconfirmpersonid ");
		buffer.append("             ,p1.personName				    AS woaconfirmpersonname ");
		buffer.append("             ,W_O_A_Confirmcontent    	AS woaconfirmcontent ");
		buffer.append("             ,W_O_A_Confirmdatetime    	AS woaconfirmdatetime ");
		buffer.append("             ,W_O_A_Account		    	AS woaaccount ");
		buffer.append("             ,W_O_A_DoctorID		    	AS woadoctorid ");
		buffer.append("             ,p2.personName		    	AS woadoctorname ");
		
		buffer.append("FROM   W_OptometryAppointment ");
		buffer.append(" left join SYS_PersonInfo p1 on W_O_A_ID = p1.id ");
		buffer.append(" left join SYS_PersonInfo p2 on W_O_A_DoctorID = p2.id ");
		
		buffer.append(" left join F_OptionParam op1 on W_O_A_Diyu = op1.F_OP_ParamID ");
		buffer.append(" left join F_OptionParam op2 on W_O_A_Wangdian = op2.F_OP_ParamID ");
		buffer.append(" left join F_OptionParam op3 on W_O_A_Zhenliao = op3.F_OP_ParamID ");

		buffer.append("WHERE  1=1 ");
		
		if(!"".equals(Utility.getName(po.getWoaid()))){
			buffer.append("AND W_O_A_ID = ? ");
			params.add(Utility.getName(po.getWoaid()));
		}
		if(!"".equals(Utility.getName(po.getWoaopencustomerid()))){
			buffer.append("AND W_O_A_CustomerId = ? ");
			params.add(Utility.getName(po.getWoaopencustomerid()));
		}	
		if(!"".equals(Utility.getName(po.getWoawangdian()))){
			buffer.append("AND W_O_A_Wangdian = ? ");
			params.add(Utility.getName(po.getWoawangdian()));
		}		
		if(!"".equals(Utility.getName(po.getWoadoctorid()))){
			buffer.append("AND W_O_A_DoctorID = ? ");
			params.add(Utility.getName(po.getWoadoctorid()));
		}
		if(!"".equals(Utility.getName(po.getWoaisconfirm()))){
			buffer.append("AND W_O_A_Isconfirm = ? ");
			params.add(Utility.getName(po.getWoaisconfirm()));
		}		
		if(!"".equals(Utility.getName(po.getWoaname()))){
			buffer.append("AND W_O_A_Name like '%' + ? + '%' ");
			params.add(Utility.getName(po.getWoaname()));
		}	
		if(!"".equals(Utility.getName(po.getWoamobilephone()))){
			buffer.append("AND W_O_A_Mobilephone = ? ");
			params.add(Utility.getName(po.getWoamobilephone()));
		}		
		
		buffer.append(" order by W_O_A_Datetime desc ");
		
		return queryForObjectList(buffer.toString(), params.toArray(), WeiXinOptometryAppointmentPo.class);
	}
	
	public List<WeiXinOptometryAppointmentPo> selectWeiXinOptometryAppointmentList(
			WeiXinOptometryAppointmentPo po, int start, int size) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		int countPage = start + size;
		buffer.append("set rowcount " + countPage + " \n");
		
		buffer.append("SELECT	    * from( ");
		buffer.append("SELECT	    ROW_NUMBER() Over(order by W_O_A_ID) as rowNum ");
		buffer.append("             ,W_O_A_ID      				AS woaid ");
		buffer.append("             ,W_O_A_Name		       		AS woaname ");
		buffer.append("             ,W_O_A_Mobilephone    		AS woamobilephone ");
		buffer.append("             ,W_O_A_Content    			AS woacontent ");
		buffer.append("             ,W_O_A_Datetime    			AS woadatetime ");
		buffer.append("             ,W_O_A_Isconfirm    		AS woaisconfirm ");
		buffer.append("             ,W_O_A_Confirmpersonid    	AS woaconfirmpersonid ");
		buffer.append("             ,personName				    AS woaconfirmpersonname ");
		buffer.append("             ,W_O_A_Confirmcontent    	AS woaconfirmcontent ");
		buffer.append("             ,W_O_A_Confirmdatetime    	AS woaconfirmdatetime ");
		buffer.append("             ,W_O_A_Account		    	AS woaaccount ");
		buffer.append("             ,op2.F_OP_ParamName			AS woawangdian ");
		
		
		buffer.append("FROM   W_OptometryAppointment ");
		buffer.append(" left join SYS_PersonInfo on W_O_A_ID = SYS_PersonInfo.id ");
		buffer.append(" left join F_OptionParam op2 on W_O_A_Wangdian = op2.F_OP_ParamID ");
		
		buffer.append("WHERE  1=1 ");
		
		if(!"".equals(Utility.getName(po.getWoaid()))){
			buffer.append("AND W_O_A_ID = ? ");
			params.add(Utility.getName(po.getWoaid()));
		}
		if(!"".equals(Utility.getName(po.getWoawangdian()))){
			buffer.append("AND W_O_A_Wangdian = ? ");
			params.add(Utility.getName(po.getWoawangdian()));
		}		
		if(!"".equals(Utility.getName(po.getWoadoctorid()))){
			buffer.append("AND W_O_A_DoctorID = ? ");
			params.add(Utility.getName(po.getWoadoctorid()));
		}
		if(!"".equals(Utility.getName(po.getWoaisconfirm()))){
			buffer.append("AND W_O_A_Isconfirm = ? ");
			params.add(Utility.getName(po.getWoaisconfirm()));
		}		
		if(!"".equals(Utility.getName(po.getWoaname()))){
			buffer.append("AND W_O_A_Name like '%' + ? + '%' ");
			params.add(Utility.getName(po.getWoaname()));
		}	
		if(!"".equals(Utility.getName(po.getWoamobilephone()))){
			buffer.append("AND W_O_A_Mobilephone = ? ");
			params.add(Utility.getName(po.getWoamobilephone()));
		}		
		if(!"".equals(Utility.getName(po.getWoastartTime()))){
			buffer.append("and convert(varchar(10), W_O_A_Datetime, 23) >= ? ");
			params.add(po.getWoastartTime());
			
		}
		if(!"".equals(Utility.getName(po.getWoaendTime()))){
			buffer.append("and convert(varchar(10), W_O_A_Datetime, 23) <= ? ");
			params.add(po.getWoaendTime());
			
		}
		
		buffer.append(" ) temp where rowNum > " + start + " and rowNum <= "
				+ countPage);
		
		buffer.append(" order by woadatetime desc ");
		
		buffer.append(" set rowcount 0");
		
		return queryForObjectList(buffer.toString(), params.toArray(), WeiXinOptometryAppointmentPo.class);
	}
}
