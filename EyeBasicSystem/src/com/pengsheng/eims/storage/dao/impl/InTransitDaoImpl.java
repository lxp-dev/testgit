package com.pengsheng.eims.storage.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.storage.dao.InTransitDao;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class InTransitDaoImpl extends BaseJdbcDaoSupport implements
		InTransitDao {

	/**
	 * 查询部门表所有信息
	 */
	public List<DepartmentsPo> getDepartmentsList(DepartmentsPo departmentsPo) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT B_DP_DepartmentID as bdpdepartmentid ");
		buffer.append(",B_DP_DepartmentName  as bdpdepartmentname ");
		buffer.append("FROM B_Departments");

		return queryForObjectList(buffer.toString(), null, DepartmentsPo.class);
	}

	/**
	 * 查询在途状态数量
	 */
	public int getInTransitCount(SalesBasicPo po) {
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select sum(count1) as count1 from ( ");			
		buffer.append("select count(distinct S_SE_SB_SalesID) as count1 ");	
		buffer.append("from S_SE_SalesBasic ");	
		
		if(!Utility.getName(po.getSsesbsupplierid()).equals("")){
			buffer.append("inner join S_SE_SalesDetail on S_SE_SD_SalesID = S_SE_SB_SalesID ");	
		}
		
		buffer.append("left join B_Departments as aa on S_SE_SalesBasic.S_SE_SB_ShopCode = aa.B_DP_DepartmentID  ");	
		buffer.append("left join B_Departments as bb on S_SE_SalesBasic.S_SE_SB_Location = bb.B_DP_DepartmentID  ");
		buffer.append("left join S_ME_CustomerInfo on S_SE_SalesBasic.S_SE_SB_CustomerID = S_ME_CustomerInfo.S_ME_CI_CustomerID ");	
		buffer.append("where 1=1 ");
		
		if(!Utility.getName(po.getSsesbsupplierid()).equals("")){
			buffer.append("and substring(S_SE_SD_SalesItemID,3,2) = ? ");	
			params.add(po.getSsesbsupplierid());
		}
		
		if("2".equals(Utility.getName(po.getSsesbdepartmenttype()))){
			buffer.append("and S_SE_SB_ShopCode in ( ");
			buffer.append("select B_DP_DepartmentID ");
			buffer.append("from B_Departments ");
			buffer.append("where B_DP_RegID = ? ) ");
			
			params.add(po.getSsesbdepid());
		}
		//退款日期
		if(!"".equals(Utility.getName(po.getOutpricestrattime())) && !"".equals(Utility.getName(po.getOutpriceendtime()))){		
			buffer.append("and convert(varchar(10), S_SE_SB_WithdrawDate, 23) >= ? ");
			buffer.append("and convert(varchar(10), S_SE_SB_WithdrawDate, 23) <= ? ");
			params.add(po.getOutpricestrattime());
			params.add(po.getOutpriceendtime());
		}else if(!"".equals(Utility.getName(po.getOutpricestrattime())) && "".equals(Utility.getName(po.getOutpriceendtime()))){
			buffer.append("and convert(varchar(10), S_SE_SB_WithdrawDate, 23) >=  ? ");
			params.add(po.getOutpricestrattime());
		}else if("".equals(Utility.getName(po.getOutpricestrattime())) && !"".equals(Utility.getName(po.getOutpriceendtime()))){
			buffer.append("and convert(varchar(10), S_SE_SB_WithdrawDate, 23) <= ? ");
			params.add(po.getOutpriceendtime());
		}
		if(!"".equals(Utility.getName(po.getSsesbsalesid()))){	//配镜单号
			buffer.append("and S_SE_SB_SalesID like '%'+ ? + '%' ");//quyanping
			params.add(po.getSsesbsalesid());
		}

		if(!"".equals(Utility.getName(po.getDjsbm()))){
			buffer.append("and S_SE_SB_Djsbm like '%' + ? +'%'");
			params.add(po.getDjsbm());
		}
		
		if(!"".equals(Utility.getName(po.getSsesbcustomerid()))){	//顾客姓名
			buffer.append("and S_ME_CI_Name  like '%' + ? + '%'  ");
			params.add(po.getSsesbcustomerid());
		} 
		
		if(!"".equals(Utility.getName(po.getSsesbphone()))){	//顾客姓名
			buffer.append("and (S_ME_CI_Phone  like '%' + ? + '%' or S_ME_CI_Phone2  like '%' + ? + '%' or S_ME_CI_Phone3  like '%' + ? + '%') ");
			params.add(po.getSsesbphone());
			params.add(po.getSsesbphone());
			params.add(po.getSsesbphone());
		} 
		
		if(!"".equals(Utility.getName(po.getSsesbshopcode()))){	//销售门店
			buffer.append("and S_SE_SB_ShopCode = ?  ");
			params.add(po.getSsesbshopcode());
		} 
		
		if(!"".equals(Utility.getName(po.getSsesbintransit()))){	//在途状态
			if("1".equals(Utility.getName(po.getSsesbintransittype()))){
				if(!"".equals(Utility.getName(po.getSsesbintransit()))){
					buffer.append("and S_SE_SB_InTransit = cast(? as int)  ");
					params.add(po.getSsesbintransit());
				}
			}else if("2".equals(Utility.getName(po.getSsesbintransittype()))){
				if(!"".equals(Utility.getName(po.getSsesbintransit()))){
					buffer.append("and S_SE_SB_InTransit >= cast(? as int)  ");
					params.add(po.getSsesbintransit());
				}
				if("1".equals(Utility.getName(po.getSsesbintransittype2()))){
					if(!"".equals(Utility.getName(po.getSsesbintransit2()))){
						buffer.append("and S_SE_SB_InTransit <= cast(? as int)  ");
						params.add(po.getSsesbintransit2());
					}
				}else if("2".equals(Utility.getName(po.getSsesbintransittype2()))){
					if(!"".equals(Utility.getName(po.getSsesbintransit2()))){
						buffer.append("and S_SE_SB_InTransit < cast(? as int)  ");
						params.add(po.getSsesbintransit2());
					}
				}
			}else if("3".equals(Utility.getName(po.getSsesbintransittype()))){
				if(!"".equals(Utility.getName(po.getSsesbintransit()))){
					buffer.append("and S_SE_SB_InTransit > cast(? as int)  ");
					params.add(po.getSsesbintransit());
				}
				if("1".equals(Utility.getName(po.getSsesbintransittype2()))){
					if(!"".equals(Utility.getName(po.getSsesbintransit2()))){
						buffer.append("and S_SE_SB_InTransit <= cast(? as int)  ");
						params.add(po.getSsesbintransit2());
					}
				}else if("2".equals(Utility.getName(po.getSsesbintransittype2()))){
					if(!"".equals(Utility.getName(po.getSsesbintransit2()))){
						buffer.append("and S_SE_SB_InTransit < cast(? as int)  ");
						params.add(po.getSsesbintransit2());
					}
				}
			}else if("4".equals(Utility.getName(po.getSsesbintransittype()))){
				buffer.append("and S_SE_SB_InTransit <= cast(? as int)  ");
				params.add(po.getSsesbintransit());
			}else if("5".equals(Utility.getName(po.getSsesbintransittype()))){
				buffer.append("and S_SE_SB_InTransit < cast(? as int)  ");
				params.add(po.getSsesbintransit());
			}
		}
		
		if(!"".equals(Utility.getName(po.getSsesbMemberId()))){	//顾客卡号
			buffer.append("and S_ME_CI_MemberId = ?  ");
			params.add(po.getSsesbMemberId());
		} 
		//取镜日期
		if(!"".equals(Utility.getName(po.getSsesbtakeglassstartdata())) && !"".equals(Utility.getName(po.getSsesbtakeglassenddata()))){		
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) >= ? ");
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) <= ? ");
			params.add(po.getSsesbtakeglassstartdata());
			params.add(po.getSsesbtakeglassenddata());
		}else if(!"".equals(Utility.getName(po.getSsesbtakeglassstartdata())) && "".equals(Utility.getName(po.getSsesbtakeglassenddata()))){
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) >=  ? ");
			params.add(po.getSsesbtakeglassstartdata());
		}else if("".equals(Utility.getName(po.getSsesbtakeglassstartdata())) && !"".equals(Utility.getName(po.getSsesbtakeglassenddata()))){
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) <= ? ");
			params.add(po.getSsesbtakeglassenddata());
		}		
		//配镜日期
		if(!"".equals(Utility.getName(po.getSsesbsalesdatestarttime())) && !"".equals(Utility.getName(po.getSsesbsalesdateendtime()))){		
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) >= ? ");
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) <= ? ");
			params.add(po.getSsesbsalesdatestarttime());
			params.add(po.getSsesbsalesdateendtime());
		}else if(!"".equals(Utility.getName(po.getSsesbsalesdatestarttime())) && "".equals(Utility.getName(po.getSsesbsalesdateendtime()))){
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) >=  ? ");
			params.add(po.getSsesbsalesdatestarttime());
		}else if("".equals(Utility.getName(po.getSsesbsalesdatestarttime())) && !"".equals(Utility.getName(po.getSsesbsalesdateendtime()))){
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) <= ? ");
			params.add(po.getSsesbsalesdateendtime());
		}
		//收银日期
		if(!"".equals(Utility.getName(po.getPosdatestarttime())) && !"".equals(Utility.getName(po.getPosdateendtime()))){		
			buffer.append("and convert(varchar(10), S_SE_SB_PosDatetime, 23) >= ? ");
			buffer.append("and convert(varchar(10), S_SE_SB_PosDatetime, 23) <= ? ");
			params.add(po.getPosdatestarttime());
			params.add(po.getPosdateendtime());
		}else if(!"".equals(Utility.getName(po.getPosdatestarttime())) && "".equals(Utility.getName(po.getPosdateendtime()))){
			buffer.append("and convert(varchar(10), S_SE_SB_PosDatetime, 23) >=  ? ");
			params.add(po.getPosdatestarttime());
		}else if("".equals(Utility.getName(po.getPosdatestarttime())) && !"".equals(Utility.getName(po.getPosdateendtime()))){
			buffer.append("and convert(varchar(10), S_SE_SB_PosDatetime, 23) <= ? ");
			params.add(po.getPosdateendtime());
		}
		
		if(!"".equals(Utility.getName(po.getSsesbchooseflag()))){	//配镜类型
			buffer.append("and S_SE_SB_OrdersType = ?  ");
			params.add(po.getSsesbchooseflag());
		} 
		
		if(!"".equals(Utility.getName(po.getSsesbworrytype()))){	//加急状态
			if("1".equals(Utility.getName(po.getSsesbworrytype()))){
				buffer.append("and isnull(S_SE_SB_WorryType,'') = '1'  ");
			} 
			if("2".equals(Utility.getName(po.getSsesbworrytype()))){
				buffer.append("and isnull(S_SE_SB_WorryType,'') = '2'  ");
			}
		}
		
		if(!"".equals(Utility.getName(po.getSsesbcheckoutflag()))){	//欠款标志
			buffer.append("and S_SE_SB_CheckoutFlag = ?  ");
			params.add(Utility.getName(po.getSsesbcheckoutflag()));
		} 
		
		if(!"".equals(Utility.getName(po.getSsesbsetmealtype()))){	//套餐分类
			if ("1".equals(Utility.getName(po.getSsesbsetmealtype()))){
				buffer.append("and S_SE_SB_OrdersType in ('1','2')  ");
			}
			if ("3".equals(Utility.getName(po.getSsesbsetmealtype()))){
				buffer.append("and S_SE_SB_OrdersType in ('3','4')  ");
			}
			if ("5".equals(Utility.getName(po.getSsesbsetmealtype()))){
				buffer.append("and S_SE_SB_OrdersType in ('5')  ");
			}			
		} 
		
		if(!"".equals(Utility.getName(po.getSsesbsetmealtitle()))){	//套餐主题名称
			buffer.append("and S_SE_SB_SetMealName like '%' + ? + '%'  ");
			params.add(Utility.getName(po.getSsesbsetmealtitle()));
		} 
		
		if("1".equals(Utility.getName(po.getSsesbusesetmealflag()))){	//是否使用套餐
			buffer.append("and isnull(S_SE_SB_SetMealFlag,'0') = '1'  ");
		} 
		if("0".equals(Utility.getName(po.getSsesbusesetmealflag()))){	//是否使用套餐
			buffer.append("and isnull(S_SE_SB_SetMealFlag,'0') = '0'  ");
		} 
		
		if(!"".equals(Utility.getName(po.getSsesbsalerid()))){	//营业员
			buffer.append("and S_SE_SB_SalerID like '%' + ? + '%'  ");
			params.add(Utility.getName(po.getSsesbsalerid()));
		} 
		
		if ("1".equals(Utility.getName(po.getSsesbintransitfinished()))){	
			buffer.append("and S_SE_SB_InTransit not in ('13','14')  ");
		} 
		
		if(po.getSmecishoplist() != null && po.getSmecishoplist().size() > 0){
			
			buffer.append(" and S_SE_SB_ShopCode in ( ? ");

			List<DepartmentsPo> dList = po.getSmecishoplist();
			params.add(Utility.getName(dList.get(0).getBdpdepartmentid()));

			for (int i = 1; i < dList.size(); i++){
				buffer.append(" ,? ");
				params.add(Utility.getName(dList.get(i).getBdpdepartmentid()));
			}
			buffer.append(" ) ");
		}
		
		if (!"".equals(Utility.getName(po.getSsesbsalesremark()))){	
			buffer.append(" and S_SE_SB_SalesRemark like '%' + ? + '%'  ");
			params.add(Utility.getName(po.getSsesbsalesremark()));
		} 		
		
		if ("2".equals(Utility.getName(po.getSsesbintransitfinished()))){
			buffer.append(" union all  ");
			buffer.append("select count(distinct S_SE_SB_SalesID) as count1 ");	
			buffer.append("from S_SE_SalesBasic_Finished ");	
			
			if(!Utility.getName(po.getSsesbsupplierid()).equals("")){
				buffer.append("inner join S_SE_SalesDetail_Finished on S_SE_SD_SalesID = S_SE_SB_SalesID ");	
			}
			
			buffer.append("left join B_Departments as aa on S_SE_SB_ShopCode = aa.B_DP_DepartmentID  ");	
			buffer.append("left join B_Departments as bb on S_SE_SB_Location = bb.B_DP_DepartmentID  ");
			buffer.append("left join S_ME_CustomerInfo on S_SE_SB_CustomerID = S_ME_CustomerInfo.S_ME_CI_CustomerID ");	
			buffer.append("where 1=1 ");
			
			
			if(!Utility.getName(po.getSsesbsupplierid()).equals("")){
				buffer.append("and substring(S_SE_SD_SalesItemID,3,2) = ? ");	
				params.add(po.getSsesbsupplierid());
			}
			
			if("2".equals(Utility.getName(po.getSsesbdepartmenttype()))){
				buffer.append("and S_SE_SB_ShopCode in ( ");
				buffer.append("select B_DP_DepartmentID ");
				buffer.append("from B_Departments ");
				buffer.append("where B_DP_RegID = ? ) ");
				
				params.add(po.getSsesbdepid());
			}
			//退款日期
			if(!"".equals(Utility.getName(po.getOutpricestrattime())) && !"".equals(Utility.getName(po.getOutpriceendtime()))){		
				buffer.append("and convert(varchar(10), S_SE_SB_WithdrawDate, 23) >= ? ");
				buffer.append("and convert(varchar(10), S_SE_SB_WithdrawDate, 23) <= ? ");
				params.add(po.getOutpricestrattime());
				params.add(po.getOutpriceendtime());
			}else if(!"".equals(Utility.getName(po.getOutpricestrattime())) && "".equals(Utility.getName(po.getOutpriceendtime()))){
				buffer.append("and convert(varchar(10), S_SE_SB_WithdrawDate, 23) >=  ? ");
				params.add(po.getOutpricestrattime());
			}else if("".equals(Utility.getName(po.getOutpricestrattime())) && !"".equals(Utility.getName(po.getOutpriceendtime()))){
				buffer.append("and convert(varchar(10), S_SE_SB_WithdrawDate, 23) <= ? ");
				params.add(po.getOutpriceendtime());
			}
			if(!"".equals(Utility.getName(po.getSsesbsalesid()))){	//配镜单号
				buffer.append("and S_SE_SB_SalesID like '%'+ ? + '%' ");//quyanping
				params.add(po.getSsesbsalesid());
			}
			
			if(!"".equals(Utility.getName(po.getDjsbm()))){
				buffer.append("and S_SE_SB_Djsbm like '%' + ? +'%'");
				params.add(po.getDjsbm());
			}			
			
			if(!"".equals(Utility.getName(po.getSsesbcustomerid()))){	//顾客姓名
				buffer.append("and S_ME_CI_Name  like '%' + ? + '%'  ");
				params.add(po.getSsesbcustomerid());
			} 
			
			if(!"".equals(Utility.getName(po.getSsesbphone()))){	//顾客姓名
				buffer.append("and (S_ME_CI_Phone  like '%' + ? + '%' or S_ME_CI_Phone2  like '%' + ? + '%' or S_ME_CI_Phone3  like '%' + ? + '%') ");
				params.add(po.getSsesbphone());
				params.add(po.getSsesbphone());
				params.add(po.getSsesbphone());
			} 
			
			if(!"".equals(Utility.getName(po.getSsesbshopcode()))){	//销售门店
				buffer.append("and S_SE_SB_ShopCode = ?  ");
				params.add(po.getSsesbshopcode());
			} 
			
			if(!"".equals(Utility.getName(po.getSsesbintransit()))){	//在途状态
				if("1".equals(Utility.getName(po.getSsesbintransittype()))){
					if(!"".equals(Utility.getName(po.getSsesbintransit()))){
						buffer.append("and S_SE_SB_InTransit = cast(? as int)  ");
						params.add(po.getSsesbintransit());
					}
				}else if("2".equals(Utility.getName(po.getSsesbintransittype()))){
					if(!"".equals(Utility.getName(po.getSsesbintransit()))){
						buffer.append("and S_SE_SB_InTransit >= cast(? as int)  ");
						params.add(po.getSsesbintransit());
					}
					if("1".equals(Utility.getName(po.getSsesbintransittype2()))){
						if(!"".equals(Utility.getName(po.getSsesbintransit2()))){
							buffer.append("and S_SE_SB_InTransit <= cast(? as int)  ");
							params.add(po.getSsesbintransit2());
						}
					}else if("2".equals(Utility.getName(po.getSsesbintransittype2()))){
						if(!"".equals(Utility.getName(po.getSsesbintransit2()))){
							buffer.append("and S_SE_SB_InTransit < cast(? as int)  ");
							params.add(po.getSsesbintransit2());
						}
					}
				}else if("3".equals(Utility.getName(po.getSsesbintransittype()))){
					if(!"".equals(Utility.getName(po.getSsesbintransit()))){
						buffer.append("and S_SE_SB_InTransit > cast(? as int)  ");
						params.add(po.getSsesbintransit());
					}
					if("1".equals(Utility.getName(po.getSsesbintransittype2()))){
						if(!"".equals(Utility.getName(po.getSsesbintransit2()))){
							buffer.append("and S_SE_SB_InTransit <= cast(? as int)  ");
							params.add(po.getSsesbintransit2());
						}
					}else if("2".equals(Utility.getName(po.getSsesbintransittype2()))){
						if(!"".equals(Utility.getName(po.getSsesbintransit2()))){
							buffer.append("and S_SE_SB_InTransit < cast(? as int)  ");
							params.add(po.getSsesbintransit2());
						}
					}
				}else if("4".equals(Utility.getName(po.getSsesbintransittype()))){
					buffer.append("and S_SE_SB_InTransit <= cast(? as int)  ");
					params.add(po.getSsesbintransit());
				}else if("5".equals(Utility.getName(po.getSsesbintransittype()))){
					buffer.append("and S_SE_SB_InTransit < cast(? as int)  ");
					params.add(po.getSsesbintransit());
				}
			}
			
			if(!"".equals(Utility.getName(po.getSsesbMemberId()))){	//顾客卡号
				buffer.append("and S_ME_CI_MemberId = ?  ");
				params.add(po.getSsesbMemberId());
			} 
			//取镜日期
			if(!"".equals(Utility.getName(po.getSsesbtakeglassstartdata())) && !"".equals(Utility.getName(po.getSsesbtakeglassenddata()))){		
				buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) >= ? ");
				buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) <= ? ");
				params.add(po.getSsesbtakeglassstartdata());
				params.add(po.getSsesbtakeglassenddata());
			}else if(!"".equals(Utility.getName(po.getSsesbtakeglassstartdata())) && "".equals(Utility.getName(po.getSsesbtakeglassenddata()))){
				buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) >=  ? ");
				params.add(po.getSsesbtakeglassstartdata());
			}else if("".equals(Utility.getName(po.getSsesbtakeglassstartdata())) && !"".equals(Utility.getName(po.getSsesbtakeglassenddata()))){
				buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) <= ? ");
				params.add(po.getSsesbtakeglassenddata());
			}		
			//配镜日期
			if(!"".equals(Utility.getName(po.getSsesbsalesdatestarttime())) && !"".equals(Utility.getName(po.getSsesbsalesdateendtime()))){		
				buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) >= ? ");
				buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) <= ? ");
				params.add(po.getSsesbsalesdatestarttime());
				params.add(po.getSsesbsalesdateendtime());
			}else if(!"".equals(Utility.getName(po.getSsesbsalesdatestarttime())) && "".equals(Utility.getName(po.getSsesbsalesdateendtime()))){
				buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) >=  ? ");
				params.add(po.getSsesbsalesdatestarttime());
			}else if("".equals(Utility.getName(po.getSsesbsalesdatestarttime())) && !"".equals(Utility.getName(po.getSsesbsalesdateendtime()))){
				buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) <= ? ");
				params.add(po.getSsesbsalesdateendtime());
			}
			//收银日期
			if(!"".equals(Utility.getName(po.getPosdatestarttime())) && !"".equals(Utility.getName(po.getPosdateendtime()))){		
				buffer.append("and convert(varchar(10), S_SE_SB_PosDatetime, 23) >= ? ");
				buffer.append("and convert(varchar(10), S_SE_SB_PosDatetime, 23) <= ? ");
				params.add(po.getPosdatestarttime());
				params.add(po.getPosdateendtime());
			}else if(!"".equals(Utility.getName(po.getPosdatestarttime())) && "".equals(Utility.getName(po.getPosdateendtime()))){
				buffer.append("and convert(varchar(10), S_SE_SB_PosDatetime, 23) >=  ? ");
				params.add(po.getPosdatestarttime());
			}else if("".equals(Utility.getName(po.getPosdatestarttime())) && !"".equals(Utility.getName(po.getPosdateendtime()))){
				buffer.append("and convert(varchar(10), S_SE_SB_PosDatetime, 23) <= ? ");
				params.add(po.getPosdateendtime());
			}
			
			if(!"".equals(Utility.getName(po.getSsesbchooseflag()))){	//配镜类型
				buffer.append("and S_SE_SB_OrdersType = ?  ");
				params.add(po.getSsesbchooseflag());
			} 
			
			if(!"".equals(Utility.getName(po.getSsesbworrytype()))){	//加急状态
				if("1".equals(Utility.getName(po.getSsesbworrytype()))){
					buffer.append("and isnull(S_SE_SB_WorryType,'') = '1'  ");
				} 
				if("2".equals(Utility.getName(po.getSsesbworrytype()))){
					buffer.append("and isnull(S_SE_SB_WorryType,'') = '2'  ");
				}
			}
			
			if(!"".equals(Utility.getName(po.getSsesbcheckoutflag()))){	//欠款标志
				buffer.append("and S_SE_SB_CheckoutFlag = ?  ");
				params.add(Utility.getName(po.getSsesbcheckoutflag()));
			} 
			
			if(!"".equals(Utility.getName(po.getSsesbsetmealtype()))){	//套餐分类
				if ("1".equals(Utility.getName(po.getSsesbsetmealtype()))){
					buffer.append("and S_SE_SB_OrdersType in ('1','2')  ");
				}
				if ("3".equals(Utility.getName(po.getSsesbsetmealtype()))){
					buffer.append("and S_SE_SB_OrdersType in ('3','4')  ");
				}
				if ("5".equals(Utility.getName(po.getSsesbsetmealtype()))){
					buffer.append("and S_SE_SB_OrdersType in ('5')  ");
				}			
			} 
			
			if(!"".equals(Utility.getName(po.getSsesbsetmealtitle()))){	//套餐主题名称
				buffer.append("and S_SE_SB_SetMealName like '%' + ? + '%'  ");
				params.add(Utility.getName(po.getSsesbsetmealtitle()));
			} 
			
			if("1".equals(Utility.getName(po.getSsesbusesetmealflag()))){	//是否使用套餐
				buffer.append("and isnull(S_SE_SB_SetMealFlag,'0') = '1'  ");
			} 
			if("0".equals(Utility.getName(po.getSsesbusesetmealflag()))){	//是否使用套餐
				buffer.append("and isnull(S_SE_SB_SetMealFlag,'0') = '0'  ");
			} 
			
			if(!"".equals(Utility.getName(po.getSsesbsalerid()))){	//营业员
				buffer.append(" and S_SE_SB_SalerID like '%' + ? + '%'  ");
				params.add(Utility.getName(po.getSsesbsalerid()));
			} 	
			
			if(po.getSmecishoplist() != null && po.getSmecishoplist().size() > 0){
				
				buffer.append(" and S_SE_SB_ShopCode in ( ? ");

				List<DepartmentsPo> dList = po.getSmecishoplist();
				params.add(Utility.getName(dList.get(0).getBdpdepartmentid()));

				for (int i = 1; i < dList.size(); i++){
					buffer.append(" ,? ");
					params.add(Utility.getName(dList.get(i).getBdpdepartmentid()));
				}
				buffer.append(" ) ");
			}
			
			if (!"".equals(Utility.getName(po.getSsesbsalesremark()))){	
				buffer.append(" and S_SE_SB_SalesRemark like '%' + ? + '%'  ");
				params.add(Utility.getName(po.getSsesbsalesremark()));
			}
		}
		
		buffer.append(" )t  ");
		
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}

	/**
	 * 在途查询分页
	 */
	public List<SalesBasicPo> getInTransitList(SalesBasicPo po, int start,
			int size) {
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
	
		int countPage = start + size;
		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from(select ROW_NUMBER() Over ( ");
		if("1".equals(po.getSsesbordertype())){
			buffer.append("order by ssesbsalesdatetime desc ");
		}else{
			buffer.append("order by ssesbtakeglassdata desc ");
		}
		
		buffer.append(" ) as rowNum,* from ( ");
		
		buffer.append("select distinct S_SE_SB_SalesID as ssesbsalesid, ");
		buffer.append("aa.B_DP_DepartmentName as ssesbshopcode, ");
		buffer.append("S_ME_CI_Name as ssesbcustomerid, ");
		buffer.append("S_ME_CI_MemberId as ssesbMemberId, ");
		buffer.append("S_SE_SB_TakeGlassData as ssesbtakeglassdata, ");
		buffer.append("S_SE_SB_SalesDatetime as ssesbsalesdatetime, ");
		buffer.append("S_SE_SB_PosDatetime as ssesbposdatetime, ");
		buffer.append("S_SE_SB_InTransit as ssesbintransit, ");
		buffer.append("S_SE_SB_SalesValue as ssesbsalesvalue, ");
		buffer.append("S_SE_SB_PriceSum as ssesbpricesum, ");
		buffer.append("(case S_SE_SB_CheckoutFlag when '1' then S_SE_SB_ArrearsValue else 0 end) as ssesbarrearsvalue, ");
		buffer.append("bb.B_DP_DepartmentName as ssesblocation, ");
		buffer.append("case ");
		buffer.append("when S_SE_SB_OrdersType = '1' then '框镜成品' ");
		buffer.append("when S_SE_SB_OrdersType = '2' then '框镜订做' ");
		buffer.append("when S_SE_SB_OrdersType = '3' then '隐形成品' ");
		buffer.append("when S_SE_SB_OrdersType = '4' then '隐形订做' ");
		buffer.append("when S_SE_SB_OrdersType = '5' then '辅料' ");
		buffer.append("end     AS ssesbchooseflag,S_SE_SB_WorryType as ssesbworrytype ");
		
		buffer.append("from S_SE_SalesBasic ");
		
		if(!Utility.getName(po.getSsesbsupplierid()).equals("")){
			buffer.append("inner join S_SE_SalesDetail on S_SE_SD_SalesID = S_SE_SB_SalesID ");	
		}		
		
		buffer.append("left join B_Departments as aa on S_SE_SalesBasic.S_SE_SB_ShopCode = aa.B_DP_DepartmentID  ");	
		buffer.append("left join B_Departments as bb on S_SE_SalesBasic.S_SE_SB_Location = bb.B_DP_DepartmentID  ");	
		buffer.append("left join S_ME_CustomerInfo on S_SE_SalesBasic.S_SE_SB_CustomerID = S_ME_CustomerInfo.S_ME_CI_CustomerID ");	
		buffer.append("where 1=1 ");
		
		if(!Utility.getName(po.getSsesbsupplierid()).equals("")){
			buffer.append("and substring(S_SE_SD_SalesItemID,3,2) = ? ");	
			params.add(po.getSsesbsupplierid());
		}
		
		if("2".equals(Utility.getName(po.getSsesbdepartmenttype()))){
			buffer.append("and S_SE_SB_ShopCode in ( ");
			buffer.append("select B_DP_DepartmentID ");
			buffer.append("from B_Departments ");
			buffer.append("where B_DP_RegID = ? ) ");
			
			params.add(po.getSsesbdepid());
		}
		
		if(!"".equals(Utility.getName(po.getSsesbsalesid()))){	//配镜单号
			buffer.append("and S_SE_SB_SalesID like '%' + ? + '%' ");//quyanping
			params.add(po.getSsesbsalesid());
		}
		
		if(!"".equals(Utility.getName(po.getDjsbm()))){
			buffer.append("and S_SE_SB_Djsbm like '%' + ? +'%'");
			params.add(po.getDjsbm());
		}
		
		if(!"".equals(Utility.getName(po.getSsesbcustomerid()))){	//顾客姓名
			buffer.append("and S_ME_CI_Name  like '%' + ? + '%' ");
			params.add(po.getSsesbcustomerid());
		} 
		
		if(!"".equals(Utility.getName(po.getSsesbphone()))){	//顾客姓名
			buffer.append("and (S_ME_CI_Phone  like '%' + ? + '%' or S_ME_CI_Phone2  like '%' + ? + '%' or S_ME_CI_Phone3  like '%' + ? + '%') ");
			params.add(po.getSsesbphone());
			params.add(po.getSsesbphone());
			params.add(po.getSsesbphone());
		} 
		
		//取镜日期
		if(!"".equals(Utility.getName(po.getSsesbtakeglassstartdata())) && !"".equals(Utility.getName(po.getSsesbtakeglassenddata()))){		
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) >= ? ");
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) <= ? ");
			params.add(po.getSsesbtakeglassstartdata());
			params.add(po.getSsesbtakeglassenddata());
		}else if(!"".equals(Utility.getName(po.getSsesbtakeglassstartdata())) && "".equals(Utility.getName(po.getSsesbtakeglassenddata()))){
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) >=  ? ");
			params.add(po.getSsesbtakeglassstartdata());
		}else if("".equals(Utility.getName(po.getSsesbtakeglassstartdata())) && !"".equals(Utility.getName(po.getSsesbtakeglassenddata()))){
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) <= ? ");
			params.add(po.getSsesbtakeglassenddata());
		}		

		//退款日期
		if(!"".equals(Utility.getName(po.getOutpricestrattime())) && !"".equals(Utility.getName(po.getOutpriceendtime()))){		
			buffer.append("and convert(varchar(10), S_SE_SB_WithdrawDate, 23) >= ? ");
			buffer.append("and convert(varchar(10), S_SE_SB_WithdrawDate, 23) <= ? ");
			params.add(po.getOutpricestrattime());
			params.add(po.getOutpriceendtime());
		}else if(!"".equals(Utility.getName(po.getOutpricestrattime())) && "".equals(Utility.getName(po.getOutpriceendtime()))){
			buffer.append("and convert(varchar(10), S_SE_SB_WithdrawDate, 23) >=  ? ");
			params.add(po.getOutpricestrattime());
		}else if("".equals(Utility.getName(po.getOutpricestrattime())) && !"".equals(Utility.getName(po.getOutpriceendtime()))){
			buffer.append("and convert(varchar(10), S_SE_SB_WithdrawDate, 23) <= ? ");
			params.add(po.getOutpriceendtime());
		}	
		//配镜日期
		if(!"".equals(Utility.getName(po.getSsesbsalesdatestarttime())) && !"".equals(Utility.getName(po.getSsesbsalesdateendtime()))){		
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) >= ? ");
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) <= ? ");
			params.add(po.getSsesbsalesdatestarttime());
			params.add(po.getSsesbsalesdateendtime());
		}else if(!"".equals(Utility.getName(po.getSsesbsalesdatestarttime())) && "".equals(Utility.getName(po.getSsesbsalesdateendtime()))){
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) >=  ? ");
			params.add(po.getSsesbsalesdatestarttime());
		}else if("".equals(Utility.getName(po.getSsesbsalesdatestarttime())) && !"".equals(Utility.getName(po.getSsesbsalesdateendtime()))){
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) <= ? ");
			params.add(po.getSsesbsalesdateendtime());
		}
		//收银日期
		if(!"".equals(Utility.getName(po.getPosdatestarttime())) && !"".equals(Utility.getName(po.getPosdateendtime()))){		
			buffer.append("and convert(varchar(10), S_SE_SB_PosDatetime, 23) >= ? ");
			buffer.append("and convert(varchar(10), S_SE_SB_PosDatetime, 23) <= ? ");
			params.add(po.getPosdatestarttime());
			params.add(po.getPosdateendtime());
		}else if(!"".equals(Utility.getName(po.getPosdatestarttime())) && "".equals(Utility.getName(po.getPosdateendtime()))){
			buffer.append("and convert(varchar(10), S_SE_SB_PosDatetime, 23) >=  ? ");
			params.add(po.getPosdatestarttime());
		}else if("".equals(Utility.getName(po.getPosdatestarttime())) && !"".equals(Utility.getName(po.getPosdateendtime()))){
			buffer.append("and convert(varchar(10), S_SE_SB_PosDatetime, 23) <= ? ");
			params.add(po.getPosdateendtime());
		}
		
		if(!"".equals(Utility.getName(po.getSsesbshopcode()))){	//销售门店
			buffer.append("and S_SE_SB_ShopCode = ?  ");
			params.add(po.getSsesbshopcode());
		} 
		
		if(!"".equals(Utility.getName(po.getSsesbintransit()))){	//在途状态
			if("1".equals(Utility.getName(po.getSsesbintransittype()))){
				if(!"".equals(Utility.getName(po.getSsesbintransit()))){
					buffer.append("and S_SE_SB_InTransit = cast(? as int)  ");
					params.add(po.getSsesbintransit());
				}
			}else if("2".equals(Utility.getName(po.getSsesbintransittype()))){
				if(!"".equals(Utility.getName(po.getSsesbintransit()))){
					buffer.append("and S_SE_SB_InTransit >= cast(? as int)  ");
					params.add(po.getSsesbintransit());
				}
				if("1".equals(Utility.getName(po.getSsesbintransittype2()))){
					if(!"".equals(Utility.getName(po.getSsesbintransit2()))){
						buffer.append("and S_SE_SB_InTransit <= cast(? as int)  ");
						params.add(po.getSsesbintransit2());
					}
				}else if("2".equals(Utility.getName(po.getSsesbintransittype2()))){
					if(!"".equals(Utility.getName(po.getSsesbintransit2()))){
						buffer.append("and S_SE_SB_InTransit < cast(? as int)  ");
						params.add(po.getSsesbintransit2());
					}
				}
			}else if("3".equals(Utility.getName(po.getSsesbintransittype()))){
				if(!"".equals(Utility.getName(po.getSsesbintransit()))){
					buffer.append("and S_SE_SB_InTransit > cast(? as int)  ");
					params.add(po.getSsesbintransit());
				}
				if("1".equals(Utility.getName(po.getSsesbintransittype2()))){
					if(!"".equals(Utility.getName(po.getSsesbintransit2()))){
						buffer.append("and S_SE_SB_InTransit <= cast(? as int)  ");
						params.add(po.getSsesbintransit2());
					}
				}else if("2".equals(Utility.getName(po.getSsesbintransittype2()))){
					if(!"".equals(Utility.getName(po.getSsesbintransit2()))){
						buffer.append("and S_SE_SB_InTransit < cast(? as int)  ");
						params.add(po.getSsesbintransit2());
					}
				}
			}else if("4".equals(Utility.getName(po.getSsesbintransittype()))){
				buffer.append("and S_SE_SB_InTransit <= cast(? as int)  ");
				params.add(po.getSsesbintransit());
			}else if("5".equals(Utility.getName(po.getSsesbintransittype()))){
				buffer.append("and S_SE_SB_InTransit < cast(? as int)  ");
				params.add(po.getSsesbintransit());
			}
		}
		
		if(!"".equals(Utility.getName(po.getSsesbchooseflag()))){	//配镜类型
			buffer.append("and S_SE_SB_OrdersType = ?  ");
			params.add(po.getSsesbchooseflag());
		} 
		if(!"".equals(Utility.getName(po.getSsesbMemberId()))){	//顾客卡号
			buffer.append("and S_ME_CI_MemberId = ?  ");
			params.add(po.getSsesbMemberId());
		} 
		
		if(!"".equals(Utility.getName(po.getSsesbworrytype()))){	//加急状态
			if("1".equals(Utility.getName(po.getSsesbworrytype()))){
				buffer.append("and isnull(S_SE_SB_WorryType,'') = '1'  ");
			} 
			if("2".equals(Utility.getName(po.getSsesbworrytype()))){
				buffer.append("and isnull(S_SE_SB_WorryType,'') = '2'  ");
			}
		} 
		if(!"".equals(Utility.getName(po.getSsesbcheckoutflag()))){	//欠款标志
			buffer.append("and S_SE_SB_CheckoutFlag = ?  ");
			params.add(Utility.getName(po.getSsesbcheckoutflag()));
		}
		
		if(!"".equals(Utility.getName(po.getSsesbsetmealtype()))){	//套餐分类
			if ("1".equals(Utility.getName(po.getSsesbsetmealtype()))){
				buffer.append("and S_SE_SB_OrdersType in ('1','2')  ");
			}
			if ("3".equals(Utility.getName(po.getSsesbsetmealtype()))){
				buffer.append("and S_SE_SB_OrdersType in ('3','4')  ");
			}
			if ("5".equals(Utility.getName(po.getSsesbsetmealtype()))){
				buffer.append("and S_SE_SB_OrdersType in ('5')  ");
			}			
		} 
		
		if(!"".equals(Utility.getName(po.getSsesbsetmealtitle()))){	//套餐主题名称
			buffer.append("and S_SE_SB_SetMealName like '%' + ? + '%'  ");
			params.add(Utility.getName(po.getSsesbsetmealtitle()));
		} 
		
		if("1".equals(Utility.getName(po.getSsesbusesetmealflag()))){	//是否使用套餐
			buffer.append("and isnull(S_SE_SB_SetMealFlag,'0') = '1'  ");
		} 
		if("0".equals(Utility.getName(po.getSsesbusesetmealflag()))){	//是否使用套餐
			buffer.append("and isnull(S_SE_SB_SetMealFlag,'0') = '0'  ");
		} 
		
		if(!"".equals(Utility.getName(po.getSsesbsalerid()))){	//营业员
			buffer.append("and S_SE_SB_SalerID like '%' + ? + '%'  ");
			params.add(Utility.getName(po.getSsesbsalerid()));
		} 
		
		if ("1".equals(Utility.getName(po.getSsesbintransitfinished()))){	
			buffer.append("and S_SE_SB_InTransit not in ('13','14')  ");
		} 
		
		if(po.getSmecishoplist() != null && po.getSmecishoplist().size() > 0){
			
			buffer.append(" and S_SE_SB_ShopCode in ( ? ");

			List<DepartmentsPo> dList = po.getSmecishoplist();
			params.add(Utility.getName(dList.get(0).getBdpdepartmentid()));

			for (int i = 1; i < dList.size(); i++){
				buffer.append(" ,? ");
				params.add(Utility.getName(dList.get(i).getBdpdepartmentid()));
			}
			buffer.append(" ) ");
		}
		
		if (!"".equals(Utility.getName(po.getSsesbsalesremark()))){	
			buffer.append(" and S_SE_SB_SalesRemark like '%' + ? + '%'  ");
			params.add(Utility.getName(po.getSsesbsalesremark()));
		}
		
		if ("2".equals(Utility.getName(po.getSsesbintransitfinished()))){
			buffer.append(" union all ");
			
			buffer.append("select distinct S_SE_SB_SalesID as ssesbsalesid, ");
			buffer.append("aa.B_DP_DepartmentName as ssesbshopcode, ");
			buffer.append("S_ME_CI_Name as ssesbcustomerid, ");
			buffer.append("S_ME_CI_MemberId as ssesbMemberId, ");
			buffer.append("S_SE_SB_TakeGlassData as ssesbtakeglassdata, ");
			buffer.append("S_SE_SB_SalesDatetime as ssesbsalesdatetime, ");
			buffer.append("S_SE_SB_PosDatetime as ssesbposdatetime, ");
			buffer.append("S_SE_SB_InTransit as ssesbintransit, ");
			buffer.append("S_SE_SB_SalesValue as ssesbsalesvalue, ");
			buffer.append("S_SE_SB_PriceSum as ssesbpricesum, ");
			buffer.append("(case S_SE_SB_CheckoutFlag when '1' then S_SE_SB_ArrearsValue else 0 end) as ssesbarrearsvalue, ");
			buffer.append("bb.B_DP_DepartmentName as ssesblocation, ");
			buffer.append("case ");
			buffer.append("when S_SE_SB_OrdersType = '1' then '框镜成品' ");
			buffer.append("when S_SE_SB_OrdersType = '2' then '框镜订做' ");
			buffer.append("when S_SE_SB_OrdersType = '3' then '隐形成品' ");
			buffer.append("when S_SE_SB_OrdersType = '4' then '隐形订做' ");
			buffer.append("when S_SE_SB_OrdersType = '5' then '辅料' ");
			buffer.append("end     AS ssesbchooseflag,S_SE_SB_WorryType as ssesbworrytype ");
			
			buffer.append("from S_SE_SalesBasic_Finished ");
			
			if(!Utility.getName(po.getSsesbsupplierid()).equals("")){
				buffer.append("inner join S_SE_SalesDetail_Finished on S_SE_SD_SalesID = S_SE_SB_SalesID ");	
			}		
			
			buffer.append("left join B_Departments as aa on S_SE_SB_ShopCode = aa.B_DP_DepartmentID  ");	
			buffer.append("left join B_Departments as bb on S_SE_SB_Location = bb.B_DP_DepartmentID  ");	
			buffer.append("left join S_ME_CustomerInfo on S_SE_SB_CustomerID = S_ME_CustomerInfo.S_ME_CI_CustomerID ");	
			buffer.append("where 1=1 ");

			if(!Utility.getName(po.getSsesbsupplierid()).equals("")){
				buffer.append("and substring(S_SE_SD_SalesItemID,3,2) = ? ");	
				params.add(po.getSsesbsupplierid());
			}
			
			if("2".equals(Utility.getName(po.getSsesbdepartmenttype()))){
				buffer.append("and S_SE_SB_ShopCode in ( ");
				buffer.append("select B_DP_DepartmentID ");
				buffer.append("from B_Departments ");
				buffer.append("where B_DP_RegID = ? ) ");
				
				params.add(po.getSsesbdepid());
			}
			
			if(!"".equals(Utility.getName(po.getSsesbsalesid()))){	//配镜单号
				buffer.append("and S_SE_SB_SalesID like '%' + ? + '%' ");//quyanping
				params.add(po.getSsesbsalesid());
			}
			
			if(!"".equals(Utility.getName(po.getDjsbm()))){
				buffer.append("and S_SE_SB_Djsbm like '%' + ? +'%'");
				params.add(po.getDjsbm());
			}
			
			if(!"".equals(Utility.getName(po.getSsesbcustomerid()))){	//顾客姓名
				buffer.append("and S_ME_CI_Name  like '%' + ? + '%' ");
				params.add(po.getSsesbcustomerid());
			} 
			
			if(!"".equals(Utility.getName(po.getSsesbphone()))){	//顾客姓名
				buffer.append("and (S_ME_CI_Phone  like '%' + ? + '%' or S_ME_CI_Phone2  like '%' + ? + '%' or S_ME_CI_Phone3  like '%' + ? + '%') ");
				params.add(po.getSsesbphone());
				params.add(po.getSsesbphone());
				params.add(po.getSsesbphone());
			} 
			
			//取镜日期
			if(!"".equals(Utility.getName(po.getSsesbtakeglassstartdata())) && !"".equals(Utility.getName(po.getSsesbtakeglassenddata()))){		
				buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) >= ? ");
				buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) <= ? ");
				params.add(po.getSsesbtakeglassstartdata());
				params.add(po.getSsesbtakeglassenddata());
			}else if(!"".equals(Utility.getName(po.getSsesbtakeglassstartdata())) && "".equals(Utility.getName(po.getSsesbtakeglassenddata()))){
				buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) >=  ? ");
				params.add(po.getSsesbtakeglassstartdata());
			}else if("".equals(Utility.getName(po.getSsesbtakeglassstartdata())) && !"".equals(Utility.getName(po.getSsesbtakeglassenddata()))){
				buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) <= ? ");
				params.add(po.getSsesbtakeglassenddata());
			}		

			//退款日期
			if(!"".equals(Utility.getName(po.getOutpricestrattime())) && !"".equals(Utility.getName(po.getOutpriceendtime()))){		
				buffer.append("and convert(varchar(10), S_SE_SB_WithdrawDate, 23) >= ? ");
				buffer.append("and convert(varchar(10), S_SE_SB_WithdrawDate, 23) <= ? ");
				params.add(po.getOutpricestrattime());
				params.add(po.getOutpriceendtime());
			}else if(!"".equals(Utility.getName(po.getOutpricestrattime())) && "".equals(Utility.getName(po.getOutpriceendtime()))){
				buffer.append("and convert(varchar(10), S_SE_SB_WithdrawDate, 23) >=  ? ");
				params.add(po.getOutpricestrattime());
			}else if("".equals(Utility.getName(po.getOutpricestrattime())) && !"".equals(Utility.getName(po.getOutpriceendtime()))){
				buffer.append("and convert(varchar(10), S_SE_SB_WithdrawDate, 23) <= ? ");
				params.add(po.getOutpriceendtime());
			}	
			//配镜日期
			if(!"".equals(Utility.getName(po.getSsesbsalesdatestarttime())) && !"".equals(Utility.getName(po.getSsesbsalesdateendtime()))){		
				buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) >= ? ");
				buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) <= ? ");
				params.add(po.getSsesbsalesdatestarttime());
				params.add(po.getSsesbsalesdateendtime());
			}else if(!"".equals(Utility.getName(po.getSsesbsalesdatestarttime())) && "".equals(Utility.getName(po.getSsesbsalesdateendtime()))){
				buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) >=  ? ");
				params.add(po.getSsesbsalesdatestarttime());
			}else if("".equals(Utility.getName(po.getSsesbsalesdatestarttime())) && !"".equals(Utility.getName(po.getSsesbsalesdateendtime()))){
				buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) <= ? ");
				params.add(po.getSsesbsalesdateendtime());
			}
			//收银日期
			if(!"".equals(Utility.getName(po.getPosdatestarttime())) && !"".equals(Utility.getName(po.getPosdateendtime()))){		
				buffer.append("and convert(varchar(10), S_SE_SB_PosDatetime, 23) >= ? ");
				buffer.append("and convert(varchar(10), S_SE_SB_PosDatetime, 23) <= ? ");
				params.add(po.getPosdatestarttime());
				params.add(po.getPosdateendtime());
			}else if(!"".equals(Utility.getName(po.getPosdatestarttime())) && "".equals(Utility.getName(po.getPosdateendtime()))){
				buffer.append("and convert(varchar(10), S_SE_SB_PosDatetime, 23) >=  ? ");
				params.add(po.getPosdatestarttime());
			}else if("".equals(Utility.getName(po.getPosdatestarttime())) && !"".equals(Utility.getName(po.getPosdateendtime()))){
				buffer.append("and convert(varchar(10), S_SE_SB_PosDatetime, 23) <= ? ");
				params.add(po.getPosdateendtime());
			}
			
			if(!"".equals(Utility.getName(po.getSsesbshopcode()))){	//销售门店
				buffer.append("and S_SE_SB_ShopCode = ?  ");
				params.add(po.getSsesbshopcode());
			} 
			
			if(!"".equals(Utility.getName(po.getSsesbintransit()))){	//在途状态
				if("1".equals(Utility.getName(po.getSsesbintransittype()))){
					if(!"".equals(Utility.getName(po.getSsesbintransit()))){
						buffer.append("and S_SE_SB_InTransit = cast(? as int)  ");
						params.add(po.getSsesbintransit());
					}
				}else if("2".equals(Utility.getName(po.getSsesbintransittype()))){
					if(!"".equals(Utility.getName(po.getSsesbintransit()))){
						buffer.append("and S_SE_SB_InTransit >= cast(? as int)  ");
						params.add(po.getSsesbintransit());
					}
					if("1".equals(Utility.getName(po.getSsesbintransittype2()))){
						if(!"".equals(Utility.getName(po.getSsesbintransit2()))){
							buffer.append("and S_SE_SB_InTransit <= cast(? as int)  ");
							params.add(po.getSsesbintransit2());
						}
					}else if("2".equals(Utility.getName(po.getSsesbintransittype2()))){
						if(!"".equals(Utility.getName(po.getSsesbintransit2()))){
							buffer.append("and S_SE_SB_InTransit < cast(? as int)  ");
							params.add(po.getSsesbintransit2());
						}
					}
				}else if("3".equals(Utility.getName(po.getSsesbintransittype()))){
					if(!"".equals(Utility.getName(po.getSsesbintransit()))){
						buffer.append("and S_SE_SB_InTransit > cast(? as int)  ");
						params.add(po.getSsesbintransit());
					}
					if("1".equals(Utility.getName(po.getSsesbintransittype2()))){
						if(!"".equals(Utility.getName(po.getSsesbintransit2()))){
							buffer.append("and S_SE_SB_InTransit <= cast(? as int)  ");
							params.add(po.getSsesbintransit2());
						}
					}else if("2".equals(Utility.getName(po.getSsesbintransittype2()))){
						if(!"".equals(Utility.getName(po.getSsesbintransit2()))){
							buffer.append("and S_SE_SB_InTransit < cast(? as int)  ");
							params.add(po.getSsesbintransit2());
						}
					}
				}else if("4".equals(Utility.getName(po.getSsesbintransittype()))){
					buffer.append("and S_SE_SB_InTransit <= cast(? as int)  ");
					params.add(po.getSsesbintransit());
				}else if("5".equals(Utility.getName(po.getSsesbintransittype()))){
					buffer.append("and S_SE_SB_InTransit < cast(? as int)  ");
					params.add(po.getSsesbintransit());
				}
			}
			
			if(!"".equals(Utility.getName(po.getSsesbchooseflag()))){	//配镜类型
				buffer.append("and S_SE_SB_OrdersType = ?  ");
				params.add(po.getSsesbchooseflag());
			} 
			if(!"".equals(Utility.getName(po.getSsesbMemberId()))){	//顾客卡号
				buffer.append("and S_ME_CI_MemberId = ?  ");
				params.add(po.getSsesbMemberId());
			} 
			
			if(!"".equals(Utility.getName(po.getSsesbworrytype()))){	//加急状态
				if("1".equals(Utility.getName(po.getSsesbworrytype()))){
					buffer.append("and isnull(S_SE_SB_WorryType,'') = '1'  ");
				} 
				if("2".equals(Utility.getName(po.getSsesbworrytype()))){
					buffer.append("and isnull(S_SE_SB_WorryType,'') = '2'  ");
				}
			} 
			if(!"".equals(Utility.getName(po.getSsesbcheckoutflag()))){	//欠款标志
				buffer.append("and S_SE_SB_CheckoutFlag = ?  ");
				params.add(Utility.getName(po.getSsesbcheckoutflag()));
			}
			
			if(!"".equals(Utility.getName(po.getSsesbsetmealtype()))){	//套餐分类
				if ("1".equals(Utility.getName(po.getSsesbsetmealtype()))){
					buffer.append("and S_SE_SB_OrdersType in ('1','2')  ");
				}
				if ("3".equals(Utility.getName(po.getSsesbsetmealtype()))){
					buffer.append("and S_SE_SB_OrdersType in ('3','4')  ");
				}
				if ("5".equals(Utility.getName(po.getSsesbsetmealtype()))){
					buffer.append("and S_SE_SB_OrdersType in ('5')  ");
				}			
			} 
			
			if(!"".equals(Utility.getName(po.getSsesbsetmealtitle()))){	//套餐主题名称
				buffer.append("and S_SE_SB_SetMealName like '%' + ? + '%'  ");
				params.add(Utility.getName(po.getSsesbsetmealtitle()));
			} 
			
			if("1".equals(Utility.getName(po.getSsesbusesetmealflag()))){	//是否使用套餐
				buffer.append("and isnull(S_SE_SB_SetMealFlag,'0') = '1'  ");
			} 
			if("0".equals(Utility.getName(po.getSsesbusesetmealflag()))){	//是否使用套餐
				buffer.append("and isnull(S_SE_SB_SetMealFlag,'0') = '0'  ");
			} 
			
			if(!"".equals(Utility.getName(po.getSsesbsalerid()))){	//营业员
				buffer.append("and S_SE_SB_SalerID like '%' + ? + '%'  ");
				params.add(Utility.getName(po.getSsesbsalerid()));
			} 	
			
			if(po.getSmecishoplist() != null && po.getSmecishoplist().size() > 0){
				
				buffer.append(" and S_SE_SB_ShopCode in ( ? ");

				List<DepartmentsPo> dList = po.getSmecishoplist();
				params.add(Utility.getName(dList.get(0).getBdpdepartmentid()));

				for (int i = 1; i < dList.size(); i++){
					buffer.append(" ,? ");
					params.add(Utility.getName(dList.get(i).getBdpdepartmentid()));
				}
				buffer.append(" ) ");
			}
			
			if (!"".equals(Utility.getName(po.getSsesbsalesremark()))){	
				buffer.append(" and S_SE_SB_SalesRemark like '%' + ? + '%'  ");
				params.add(Utility.getName(po.getSsesbsalesremark()));
			}
			
		}
		
		buffer.append(" ) temp )temp where rowNum > "+start+" and rowNum <= "+ (start + size));
		buffer.append("set rowcount 0");
		
		return queryForObjectList(buffer.toString(), params.toArray(),
				SalesBasicPo.class);
	}
	
	/**
	 * 查询在途状态
	 * @param po
	 * @return
	 */
	public SalesBasicPo getInTransit(SalesBasicPo po){
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append(" select top 1 S_SE_SB_SalesID as ssesbsalesid,S_SE_SB_InTransit as ssesbintransit,S_SE_SB_OrdersType as ssesborderstype,S_SE_SB_CheckoutFlag as ssesbcheckoutflag from S_SE_SalesBasic inner join B_Departments on S_SE_SB_ShopCode = B_DP_DepartmentID ");
		buffer.append(" where S_SE_SB_SalesID=? ");
		
		params.add(Utility.getName(po.getSsesbsalesid()));
		
		if (!"".equals(Utility.getName(po.getSsesbcompanyid()))){
		    buffer.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getSsesbcompanyid()));	
		}
		
		if (Utility.getName(po.getSsesbreturnbillflag()).equals("1")){
			buffer.append(" and ((S_SE_SB_OrdersType in ('1') and S_SE_SB_InTransit >= 6 and S_SE_SB_InTransit < 13 ) or (S_SE_SB_OrdersType in ('2') and S_SE_SB_InTransit >= 4 and S_SE_SB_InTransit < 13 ) or (S_SE_SB_OrdersType in ('4') and S_SE_SB_InTransit >= 2 and S_SE_SB_InTransit <= 4)) ");
		}else{
			buffer.append(" and ((S_SE_SB_OrdersType in ('1','2') and S_SE_SB_InTransit >= 6 and S_SE_SB_InTransit < 13 ) or (S_SE_SB_OrdersType in ('4') and S_SE_SB_InTransit >= 2 and S_SE_SB_InTransit < 4)) ");
		}	

		return (SalesBasicPo)queryForObject(buffer.toString(),  params.toArray(), SalesBasicPo.class);
	}
	
	/**
	 * 修改基表在途状态
	 * @param SalesBasicPo
	 * @return
	 */
	public void updateSalesBasicInTransit(InTransitPo inTransitPo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append(" update top (1) S_SE_SalesBasic set S_SE_SB_InTransit=? ");
		buffer.append(" where S_SE_SB_SalesID=? ");
		
		params.add(inTransitPo.getSseitstate());		
		params.add(inTransitPo.getSseitsalesid());
		
		getJdbcTemplate().update(buffer.toString(),params.toArray());

	}
	/**
	 * 新增基表在途状态
	 * @param List<InTransitPo>
	 * @return
	 */
	public void insertInTransit(InTransitPo inTransitPo){
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append(" insert into S_SE_InTransit(S_SE_IT_ID,S_SE_IT_SalesID,S_SE_IT_State,S_SE_IT_Date,S_SE_IT_CreatePerson,S_SE_IT_Department) values(");
		buffer.append("?,?,?,getdate(),?,?)");
		
		params.add(this.uuid.generate());		
		params.add(inTransitPo.getSseitsalesid());
		params.add(inTransitPo.getSseitstate());
		params.add(inTransitPo.getSseitcreateperson());
		params.add(inTransitPo.getSseitdepartment());
		
		getJdbcTemplate().update(buffer.toString(),params.toArray());
	}
	
	/**
	 * 查询在途状态
	 * @param po
	 * @return
	 */
	public InTransitPo getInTransitPo(InTransitPo po){
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append(" select top 1 ");
		buffer.append(" 	S_SE_IT_ID as sseitid, ");
		buffer.append(" 	S_SE_IT_SalesID as sseitsalesid, ");
		buffer.append(" 	S_SE_IT_State as sseitstate, ");
		buffer.append(" 	S_SE_IT_Date as sseitdate, ");
		buffer.append(" 	S_SE_IT_CreatePerson as sseitcreateperson, ");
		buffer.append(" 	personName as sseitcreatepersonname, ");
		buffer.append(" 	S_SE_IT_Department as sseitdepartment, ");
		buffer.append(" 	S_SE_IT_YsalesID as orderssalesid ");
		buffer.append(" from S_SE_InTransit ");
		buffer.append(" left join  SYS_PersonInfo on id = S_SE_IT_CreatePerson ");
		buffer.append(" where S_SE_IT_SalesID = ? ");
		buffer.append("   and S_SE_IT_State = ? ");
		
		params.add(po.getSseitsalesid());
		params.add(po.getSseitstate());
		
		return (InTransitPo)queryForObject(buffer.toString(),  params.toArray(), InTransitPo.class);
	}
	
	/**
	 * 微信中定制类型待取镜配镜单数量
	 * @param po
	 * @return
	 */
	public int getWeiXinDingzhiDaiqujingCount(String customID){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select count(distinct S_SE_SB_SalesID) as count1 ");	
		buffer.append("from S_SE_SalesBasic ");
		buffer.append("where S_SE_SB_InTransit <= 12 ");
		
		//buffer.append("and S_SE_SB_OrdersType in ('2','4') ");
		
		buffer.append("and S_SE_SB_CustomerID in (");
		buffer.append(" SELECT S_ME_CI_CustomerID FROM S_ME_CustomerInfo ");
		buffer.append(" WHERE (S_ME_CI_CustomerID = ?) ");
		buffer.append(" or (S_ME_CI_Sourcecard = (SELECT S_ME_CI_MemberId FROM S_ME_CustomerInfo WHERE  S_ME_CI_CustomerID = ? )");
		buffer.append(" )) ");
		
		params.add(customID);
		params.add(customID);
		
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}
}
