package com.pengsheng.eims.casehistory.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.casehistory.dao.OptometryCaseNDao;
import com.pengsheng.eims.casehistory.persistence.OptometryPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class OptometryCaseNDaoImpl extends BaseJdbcDaoSupport implements OptometryCaseNDao{
	
	public int getOptometryCaseCount(OptometryPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("SELECT count(S_OP_OY_OptometryID) ");
		buffer.append("FROM   S_OP_Optometry ");
		buffer.append("       INNER JOIN SYS_PersonInfo ");
		buffer.append("         ON S_OP_OY_PersonID = SYS_PersonInfo.ID ");
		buffer.append("       INNER JOIN B_Departments ");
		buffer.append("         ON S_OP_OY_ShopCode = B_DP_DepartmentID ");
		buffer.append("       INNER JOIN S_ME_CustomerInfo ");
		buffer.append("         ON S_ME_CI_CustomerID = S_OP_OY_CustomerID ");
		if(!"".equals(Utility.getName(po.getSopoydiffusepupil()))
				||!"".equals(Utility.getName(po.getSopoyballglassodmin()))||!"".equals(Utility.getName(po.getSopoyballglassodmax()))||!"".equals(Utility.getName(po.getSopoypostglassodmin()))||!"".equals(Utility.getName(po.getSopoypostglassodmax()))
				||!"".equals(Utility.getName(po.getSopoyfarworth()))||!"".equals(Utility.getName(po.getSopoyacamin()))||!"".equals(Utility.getName(po.getSopoyfarhetelevelmin()))||!"".equals(Utility.getName(po.getSopoyfarHeteuprightnessmin()))
				||!"".equals(Utility.getName(po.getSopoyclosehetelevelmin()))||!"".equals(Utility.getName(po.getSopoycloseheteuprightnessmin()))
				||!"".equals(Utility.getName(po.getSopoybccmin()))||!"".equals(Utility.getName(po.getSopoypramin()))||!"".equals(Utility.getName(po.getSopoynramin()))
				||!"".equals(Utility.getName(po.getSopoybccmax()))||!"".equals(Utility.getName(po.getSopoypramax()))||!"".equals(Utility.getName(po.getSopoynramax()))
				||!"".equals(Utility.getName(po.getSopoyfarworth()))||!"".equals(Utility.getName(po.getSopoyacamax()))||!"".equals(Utility.getName(po.getSopoyfarhetelevelmax()))||!"".equals(Utility.getName(po.getSopoyfarHeteuprightnessmax()))
				||!"".equals(Utility.getName(po.getSopoyclosehetelevelmax()))||!"".equals(Utility.getName(po.getSopoycloseheteuprightnessmax()))){
			buffer.append("WHERE  S_OP_OY_OptometryID IN (						    ");
			if(!"".equals(Utility.getName(po.getSopoydiffusepupil()))){
				buffer.append(" 							  SELECT S_OP_R_OptometryID ");
				buffer.append("                               FROM   S_OP_Refractive ");
				buffer.append("                               WHERE  1 = 1 ");
				
				if(!"".equals(Utility.getName(po.getSopoydiffusepupil()))){
					buffer.append("                                      AND S_OP_R_DiffusePupil = ? ");
					params.add(Utility.getName(po.getSopoydiffusepupil()));
				}
				if(!"".equals(Utility.getName(po.getSopoyballglassodmin()))||!"".equals(Utility.getName(po.getSopoyballglassodmax()))){
					buffer.append("                               UNION ALL ");
				}	
			}
			
			if(!"".equals(Utility.getName(po.getSopoyballglassodmin()))||!"".equals(Utility.getName(po.getSopoyballglassodmax()))||!"".equals(Utility.getName(po.getSopoypostglassodmin()))||!"".equals(Utility.getName(po.getSopoypostglassodmax()))){
				buffer.append("                               SELECT S_OP_IP_OptometryID ");
				buffer.append("                               FROM   S_OP_Inspection ");
				buffer.append("                               WHERE  1 = 1 ");
					if(!"".equals(Utility.getName(po.getSopoyballglassodmin()))||!"".equals(Utility.getName(po.getSopoyballglassodmax()))){
						if(!"".equals(Utility.getName(po.getSopoyballglassodmin()))&&!"".equals(Utility.getName(po.getSopoyballglassodmax()))){
							buffer.append("                                      AND Isnumeric(S_OP_IP_BallGlassOD) > 0  ");
							buffer.append("                                      AND Isnumeric(S_OP_IP_BallGlassOS) > 0  ");
							buffer.append("                                      AND (  ");
							buffer.append("                                      (CAST(isnull(S_OP_IP_BallGlassOD,0) AS FLOAT) >=  cast( ? as float) ");
							buffer.append("                                            AND CAST(isnull(S_OP_IP_BallGlassOD,0) AS FLOAT) <=  cast( ? as float))   ");
							buffer.append("                                       OR ( CAST(isnull(S_OP_IP_BallGlassOS,0) AS FLOAT) >=  cast( ? as float) ");
							buffer.append("                                            AND CAST(isnull(S_OP_IP_BallGlassOS,0) AS FLOAT) <=  cast( ? as float) ) ) ");
							params.add(Utility.getName(po.getSopoyballglassodmin()));
							params.add(Utility.getName(po.getSopoyballglassodmax()));
							params.add(Utility.getName(po.getSopoyballglassodmin()));
							params.add(Utility.getName(po.getSopoyballglassodmax()));
						}else if(!"".equals(Utility.getName(po.getSopoyballglassodmin()))&&"".equals(Utility.getName(po.getSopoyballglassodmax()))){
							buffer.append("                                      AND Isnumeric(S_OP_IP_BallGlassOD) > 0  ");
							buffer.append("                                      AND Isnumeric(S_OP_IP_BallGlassOS) > 0  ");
							buffer.append("                                      AND (  ");
							buffer.append("                                      (CAST(isnull(S_OP_IP_BallGlassOD,0) AS FLOAT) >= cast( ? as float)) ");
							buffer.append("                                       OR ( CAST(isnull(S_OP_IP_BallGlassOS,0) AS FLOAT) >=  cast( ? as float)) ) ");
							params.add(Utility.getName(po.getSopoyballglassodmin()));
							params.add(Utility.getName(po.getSopoyballglassodmin()));
						}else if("".equals(Utility.getName(po.getSopoyballglassodmin()))&&!"".equals(Utility.getName(po.getSopoyballglassodmax()))){
							buffer.append("                                      AND Isnumeric(S_OP_IP_BallGlassOD) > 0  ");
							buffer.append("                                      AND Isnumeric(S_OP_IP_BallGlassOS) > 0  ");
							buffer.append("                                      AND (  ");
							buffer.append("                                      ( ");
							buffer.append("                                            CAST(isnull(S_OP_IP_BallGlassOD,0) AS FLOAT) <=  cast( ? as float) )   ");
							buffer.append("                                       OR (  ");
							buffer.append("                                            CAST(isnull(S_OP_IP_BallGlassOS,0) AS FLOAT) <=  cast( ? as float) ) ) ");
							params.add(Utility.getName(po.getSopoyballglassodmax()));
							params.add(Utility.getName(po.getSopoyballglassodmax()));
						}
					}
			
					
					if(!"".equals(Utility.getName(po.getSopoypostglassodmin()))||!"".equals(Utility.getName(po.getSopoypostglassodmax()))){
						if(!"".equals(Utility.getName(po.getSopoypostglassodmin()))&&!"".equals(Utility.getName(po.getSopoypostglassodmax()))){
							buffer.append("                                      AND Isnumeric(S_OP_IP_PostGlassOD) > 0  ");
							buffer.append("                                      AND Isnumeric(S_OP_IP_PostGlassOS) > 0  ");
							buffer.append("                                          AND (( CAST(isnull(S_OP_IP_PostGlassOD,0) AS FLOAT) >=  cast( ? as float) ");
							buffer.append("                                                AND CAST(isnull(S_OP_IP_PostGlassOD,0) AS FLOAT) <=  cast( ? as float) ) ");
							buffer.append("                                       OR ( CAST(isnull(S_OP_IP_PostGlassOS,0) AS FLOAT) >=  cast( ? as float) ");
							buffer.append("                                            AND CAST(isnull(S_OP_IP_PostGlassOS,0) AS FLOAT) <=  cast( ? as float) ) ) ");
							params.add(Utility.getName(po.getSopoypostglassodmin()));
							params.add(Utility.getName(po.getSopoypostglassodmax()));
							params.add(Utility.getName(po.getSopoypostglassodmin()));
							params.add(Utility.getName(po.getSopoypostglassodmax()));
						}else if(!"".equals(Utility.getName(po.getSopoypostglassodmin()))&&"".equals(Utility.getName(po.getSopoypostglassodmax()))){
							buffer.append("                                      AND Isnumeric(S_OP_IP_PostGlassOD) > 0  ");
							buffer.append("                                      AND Isnumeric(S_OP_IP_PostGlassOS) > 0  ");
							buffer.append("                                          AND (( CAST(isnull(S_OP_IP_PostGlassOD,0) AS FLOAT) >=  cast( ? as float) ");
							buffer.append("                                                ) ");
							buffer.append("                                       OR ( CAST(isnull(S_OP_IP_PostGlassOS,0) AS FLOAT) >=  cast( ? as float) ) ) ");
							params.add(Utility.getName(po.getSopoypostglassodmin()));
							params.add(Utility.getName(po.getSopoypostglassodmin()));
						}else if("".equals(Utility.getName(po.getSopoypostglassodmin()))&&!"".equals(Utility.getName(po.getSopoypostglassodmax()))){
							buffer.append("                                      AND Isnumeric(S_OP_IP_PostGlassOD) > 0  ");
							buffer.append("                                      AND Isnumeric(S_OP_IP_PostGlassOS) > 0  ");
							buffer.append("                                          AND ((  ");
							buffer.append("                                                CAST(isnull(S_OP_IP_PostGlassOD,0) AS FLOAT) <=  cast( ? as float) ) ");
							buffer.append("                                       OR (  ");
							buffer.append("                                            CAST(isnull(S_OP_IP_PostGlassOS,0) AS FLOAT) <=  cast( ? as float) ) ) ");
							params.add(Utility.getName(po.getSopoypostglassodmax()));
							params.add(Utility.getName(po.getSopoypostglassodmax()));
						}
						
					}
					if(!"".equals(Utility.getName(po.getSopoyfarworth()))||!"".equals(Utility.getName(po.getSopoyacamin()))||!"".equals(Utility.getName(po.getSopoyacamax()))||!"".equals(Utility.getName(po.getSopoyfarhetelevelmin()))||!"".equals(Utility.getName(po.getSopoyfarhetelevelmax()))||!"".equals(Utility.getName(po.getSopoyfarHeteuprightnessmin()))||!"".equals(Utility.getName(po.getSopoyfarHeteuprightnessmax()))
								||!"".equals(Utility.getName(po.getSopoyclosehetelevelmin()))||!"".equals(Utility.getName(po.getSopoyclosehetelevelmax()))||!"".equals(Utility.getName(po.getSopoycloseheteuprightnessmin()))||!"".equals(Utility.getName(po.getSopoycloseheteuprightnessmax()))
								||!"".equals(Utility.getName(po.getSopoybccmin()))||!"".equals(Utility.getName(po.getSopoypramin()))||!"".equals(Utility.getName(po.getSopoynramin()))
								||!"".equals(Utility.getName(po.getSopoybccmax()))||!"".equals(Utility.getName(po.getSopoypramax()))||!"".equals(Utility.getName(po.getSopoynramax()))){
						buffer.append("                               UNION ALL ");
					}
						
			}
			
			if(!"".equals(Utility.getName(po.getSopoyfarworth()))||!"".equals(Utility.getName(po.getSopoyacamin()))||!"".equals(Utility.getName(po.getSopoyacamax()))||!"".equals(Utility.getName(po.getSopoyfarhetelevelmin()))||!"".equals(Utility.getName(po.getSopoyfarhetelevelmax()))||!"".equals(Utility.getName(po.getSopoyfarHeteuprightnessmin()))||!"".equals(Utility.getName(po.getSopoyfarHeteuprightnessmax()))
					||!"".equals(Utility.getName(po.getSopoyclosehetelevelmin()))||!"".equals(Utility.getName(po.getSopoyclosehetelevelmax()))||!"".equals(Utility.getName(po.getSopoycloseheteuprightnessmin()))||!"".equals(Utility.getName(po.getSopoycloseheteuprightnessmax()))
					||!"".equals(Utility.getName(po.getSopoybccmin()))||!"".equals(Utility.getName(po.getSopoypramin()))||!"".equals(Utility.getName(po.getSopoynramin()))
					||!"".equals(Utility.getName(po.getSopoybccmax()))||!"".equals(Utility.getName(po.getSopoypramax()))||!"".equals(Utility.getName(po.getSopoynramax()))){
				
				buffer.append("                               SELECT S_OP_DE_OptometryID ");
				buffer.append("                               FROM   S_OP_DoubleEyeFunction ");
				buffer.append("                               WHERE  1 = 1 ");
				
				if(!"".equals(Utility.getName(po.getSopoyfarworth()))){
					buffer.append("                                      AND S_OP_DE_FarWorth = ? ");
					params.add(Utility.getName(po.getSopoyfarworth()));
				}
				
				if(!"".equals(Utility.getName(po.getSopoyacamin()))){
					buffer.append("                                      AND Isnumeric(S_OP_DE_ACA) > 0  ");
					buffer.append("                                      AND S_OP_DE_ACA >= CAST(? AS FLOAT) ");
					params.add(Utility.getName(po.getSopoyacamin()));
				}
				
				if(!"".equals(Utility.getName(po.getSopoyacamax()))){
					buffer.append("                                      AND Isnumeric(S_OP_DE_ACA) > 0  ");
					buffer.append("                                      AND S_OP_DE_ACA <= CAST(? AS FLOAT) ");
					params.add(Utility.getName(po.getSopoyacamax()));
				}
				
				if(!"".equals(Utility.getName(po.getSopoyfarhetelevelmin()))){
					buffer.append("                                      AND Isnumeric(S_OP_DE_FarHeteLevel) > 0  ");
					buffer.append("                                      AND S_OP_DE_FarHeteLevel >= CAST(? AS FLOAT) ");
					params.add(Utility.getName(po.getSopoyfarhetelevelmin()));
				}
				
				if(!"".equals(Utility.getName(po.getSopoyfarhetelevelmax()))){
					buffer.append("                                      AND Isnumeric(S_OP_DE_FarHeteLevel) > 0  ");
					buffer.append("                                      AND S_OP_DE_FarHeteLevel <= CAST(? AS FLOAT) ");
					params.add(Utility.getName(po.getSopoyfarhetelevelmax()));
				}
				
				if(!"".equals(Utility.getName(po.getSopoyfarHeteuprightnessmin()))){
					buffer.append("                                      AND Isnumeric(S_OP_DE_FarHeteUprightness) > 0  ");
					buffer.append("                                      AND S_OP_DE_FarHeteUprightness >= CAST(? AS FLOAT) ");
					params.add(Utility.getName(po.getSopoyfarHeteuprightnessmin()));
				}
				
				if(!"".equals(Utility.getName(po.getSopoyfarHeteuprightnessmax()))){
					buffer.append("                                      AND Isnumeric(S_OP_DE_FarHeteUprightness) > 0  ");
					buffer.append("                                      AND S_OP_DE_FarHeteUprightness <= CAST(? AS FLOAT) ");
					params.add(Utility.getName(po.getSopoyfarHeteuprightnessmax()));
				}
				
				if(!"".equals(Utility.getName(po.getSopoyclosehetelevelmin()))){
					buffer.append("                                      AND Isnumeric(S_OP_DE_CloseHeteLevel) > 0  ");
					buffer.append("                                      AND S_OP_DE_CloseHeteLevel >= CAST(? AS FLOAT) ");
					params.add(Utility.getName(po.getSopoyclosehetelevelmin()));
				}
				
				if(!"".equals(Utility.getName(po.getSopoyclosehetelevelmax()))){
					buffer.append("                                      AND Isnumeric(S_OP_DE_CloseHeteLevel) > 0  ");
					buffer.append("                                      AND S_OP_DE_CloseHeteLevel <= CAST(? AS FLOAT) ");
					params.add(Utility.getName(po.getSopoyclosehetelevelmax()));
				}
				
				if(!"".equals(Utility.getName(po.getSopoycloseheteuprightnessmin()))){
					buffer.append("                                      AND Isnumeric(S_OP_DE_CloseHeteUprightness) > 0  ");
					buffer.append("                                      AND S_OP_DE_CloseHeteUprightness >= CAST(? AS FLOAT) ");
					params.add(Utility.getName(po.getSopoycloseheteuprightnessmin()));
				}
				
				if(!"".equals(Utility.getName(po.getSopoycloseheteuprightnessmax()))){
					buffer.append("                                      AND Isnumeric(S_OP_DE_CloseHeteUprightness) > 0  ");
					buffer.append("                                      AND S_OP_DE_CloseHeteUprightness <= CAST(? AS FLOAT) ");
					params.add(Utility.getName(po.getSopoycloseheteuprightnessmax()));
				}
				
				if(!"".equals(Utility.getName(po.getSopoybccmin()))){
					buffer.append("                                      AND Isnumeric(S_OP_DE_BCC) > 0  ");
					buffer.append("                                      AND S_OP_DE_BCC >= CAST(? AS FLOAT) ");
					params.add(Utility.getName(po.getSopoybccmin()));
				}
				
				if(!"".equals(Utility.getName(po.getSopoybccmax()))){
					buffer.append("                                      AND Isnumeric(S_OP_DE_BCC) > 0  ");
					buffer.append("                                      AND S_OP_DE_BCC <= CAST(? AS FLOAT) ");
					params.add(Utility.getName(po.getSopoybccmax()));
				}
				
				if(!"".equals(Utility.getName(po.getSopoypramin()))){
					buffer.append("                                      AND Isnumeric(S_OP_DE_PositiveAccPRA) > 0  ");
					buffer.append("                                      AND S_OP_DE_PositiveAccPRA >= CAST(? AS FLOAT) ");
					params.add(Utility.getName(po.getSopoypramin()));
				}
				
				if(!"".equals(Utility.getName(po.getSopoypramax()))){
					buffer.append("                                      AND Isnumeric(S_OP_DE_PositiveAccPRA) > 0  ");
					buffer.append("                                      AND S_OP_DE_PositiveAccPRA <= CAST(? AS FLOAT) ");
					params.add(Utility.getName(po.getSopoypramax()));
				}
				
				if(!"".equals(Utility.getName(po.getSopoynramin()))){
					buffer.append("                                      AND Isnumeric(S_OP_DE_NegativeAccNRA) > 0  ");
					buffer.append("                                      AND S_OP_DE_NegativeAccNRA >= CAST(? AS FLOAT) ");
					params.add(Utility.getName(po.getSopoynramin()));
				}
				
				if(!"".equals(Utility.getName(po.getSopoynramax()))){
					buffer.append("                                      AND Isnumeric(S_OP_DE_NegativeAccNRA) > 0  ");
					buffer.append("                                      AND S_OP_DE_NegativeAccNRA <= CAST(? AS FLOAT) ");
					params.add(Utility.getName(po.getSopoynramax()));
				}
			}
			buffer.append("   ) ");
		}
		
		if(!"".equals(Utility.getName(po.getSopoydoublecheck()))){
			if("1".equals(po.getSopoydoublecheck())){
				buffer.append(" and S_OP_OY_OptometryID In(select S_OP_DE_OptometryID from S_OP_DoubleEyeFunction)");
			}
			if("0".equals(po.getSopoydoublecheck())){
				buffer.append(" and S_OP_OY_OptometryID not In(select S_OP_DE_OptometryID from S_OP_DoubleEyeFunction)");
			}
		}
			
		if(!"".equals(Utility.getName(po.getSopoybegindate()))){
			buffer.append("                                      and convert(varchar(10),S_OP_OY_Time,23) >= ? ");
			params.add(Utility.getName(po.getSopoybegindate()));			
		}
		
		if(!"".equals(Utility.getName(po.getSopoyenddate()))){
			buffer.append("                                      and convert(varchar(10),S_OP_OY_Time,23) <= ? ");
			params.add(Utility.getName(po.getSopoyenddate()));
		}
		
		if(!"".equals(Utility.getName(po.getSopoypersonid()))){
			buffer.append("                                      and S_OP_OY_PersonID = ? ");
			params.add(Utility.getName(po.getSopoypersonid()));
		}
		if(!"".equals(Utility.getName(po.getSopoymemberid()))){
			buffer.append("                                      and S_ME_CI_MemberId like '%'+?+'%' ");
			params.add(Utility.getName(po.getSopoymemberid()));
		}
		
		if(!"".equals(Utility.getName(po.getSopoyshopcode()))){
			buffer.append("                                      and S_OP_OY_ShopCode =? ");
			params.add(Utility.getName(po.getSopoyshopcode()));
		}
		
		
		
		if(!"".equals(Utility.getName(po.getSopoyname()))){
			buffer.append("                                      and S_ME_CI_Name like '%'+?+'%' ");
			params.add(Utility.getName(po.getSopoyname()));
		}

		buffer.append("                                      and S_OP_OY_Flag = '1' ");
		
		if(po.getSmecishoplist() != null && po.getSmecishoplist().size() > 0){
			
			buffer.append(" and S_ME_CI_ShopCode in ( ? ");

			List<DepartmentsPo> dList = po.getSmecishoplist();
			params.add(Utility.getName(dList.get(0).getBdpdepartmentid()));

			for (int i = 1; i < dList.size(); i++){
				buffer.append(" ,? ");
				params.add(Utility.getName(dList.get(i).getBdpdepartmentid()));
			}
			buffer.append(" ) ");
		}
		
		return getJdbcTemplate().queryForInt(buffer.toString(),params.toArray());
	}
	
	public List<OptometryPo> getOptometryCases(OptometryPo po,
			int start, int size) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		int countPage = start + size;
		
		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * ");
		buffer.append("from( ");
		buffer.append("SELECT Row_number() OVER (ORDER BY S_OP_OY_Time ) AS rowNum, ");
		buffer.append("       S_OP_OY_OptometryID                        AS sopoyoptometryid, ");
		buffer.append("       S_OP_OY_OptometryBasicID                   AS sopoyoptometrybasicid, ");
		buffer.append("       S_OP_OY_ShopCode                           AS sopoyshopcode, ");
		buffer.append("       S_OP_OY_CustomerID                         AS sopoycustomerid, ");
		buffer.append("       S_OP_OY_PersonID                           AS sopoypersonid, ");
		buffer.append("       S_OP_OY_Time                               AS sopoytime, ");
		buffer.append("       S_OP_OY_RecipeUpdateTime                   AS sopoyrecipeupdatetime, ");
		buffer.append("       S_OP_OY_Flag                               AS sopoyflag, ");
		buffer.append("       S_OP_OY_Updateuserid                       AS sopoyupdateuserid, ");
		buffer.append("       S_ME_CI_Name                       		 AS sopoyname, ");
		buffer.append("       S_ME_CI_Phone                       		 AS sopoyphone, ");
		buffer.append("       personName                                 AS sopoypersonname, ");
		buffer.append("       B_DP_DepartmentName                        AS sopoydepartmentname, ");
		buffer.append("       S_OP_OY_isInternal                         AS sopoyisinternal, ");
		buffer.append("       S_OP_OY_OneOrMany                          AS sopoyoneormany ");
		buffer.append("FROM   S_OP_Optometry ");
		buffer.append("       INNER JOIN SYS_PersonInfo ");
		buffer.append("         ON S_OP_OY_PersonID = SYS_PersonInfo.ID ");
		buffer.append("       INNER JOIN B_Departments ");
		buffer.append("         ON S_OP_OY_ShopCode = B_DP_DepartmentID ");
		buffer.append("       INNER JOIN S_ME_CustomerInfo ");
		buffer.append("         ON S_ME_CI_CustomerID = S_OP_OY_CustomerID ");
		
		if(!"".equals(Utility.getName(po.getSopoydiffusepupil()))
				||!"".equals(Utility.getName(po.getSopoyballglassodmin()))||!"".equals(Utility.getName(po.getSopoyballglassodmax()))||!"".equals(Utility.getName(po.getSopoypostglassodmin()))||!"".equals(Utility.getName(po.getSopoypostglassodmax()))
				||!"".equals(Utility.getName(po.getSopoyfarworth()))||!"".equals(Utility.getName(po.getSopoyacamin()))||!"".equals(Utility.getName(po.getSopoyfarhetelevelmin()))||!"".equals(Utility.getName(po.getSopoyfarHeteuprightnessmin()))
				||!"".equals(Utility.getName(po.getSopoyclosehetelevelmin()))||!"".equals(Utility.getName(po.getSopoycloseheteuprightnessmin()))
				||!"".equals(Utility.getName(po.getSopoybccmin()))||!"".equals(Utility.getName(po.getSopoypramin()))||!"".equals(Utility.getName(po.getSopoynramin()))
				||!"".equals(Utility.getName(po.getSopoybccmax()))||!"".equals(Utility.getName(po.getSopoypramax()))||!"".equals(Utility.getName(po.getSopoynramax()))
				||!"".equals(Utility.getName(po.getSopoyfarworth()))||!"".equals(Utility.getName(po.getSopoyacamax()))||!"".equals(Utility.getName(po.getSopoyfarhetelevelmax()))||!"".equals(Utility.getName(po.getSopoyfarHeteuprightnessmax()))
				||!"".equals(Utility.getName(po.getSopoyclosehetelevelmax()))||!"".equals(Utility.getName(po.getSopoycloseheteuprightnessmax()))){
			buffer.append("WHERE  S_OP_OY_OptometryID IN (						    ");
			if(!"".equals(Utility.getName(po.getSopoydiffusepupil()))){
				buffer.append(" 							  SELECT S_OP_R_OptometryID ");
				buffer.append("                               FROM   S_OP_Refractive ");
				buffer.append("                               WHERE  1 = 1 ");
				
				if(!"".equals(Utility.getName(po.getSopoydiffusepupil()))){
					buffer.append("                                      AND S_OP_R_DiffusePupil = ? ");
					params.add(Utility.getName(po.getSopoydiffusepupil()));
				}
				if(!"".equals(Utility.getName(po.getSopoyballglassodmin()))||!"".equals(Utility.getName(po.getSopoyballglassodmax()))){
					buffer.append("                               UNION ALL ");
				}	
			}
			
			if(!"".equals(Utility.getName(po.getSopoyballglassodmin()))||!"".equals(Utility.getName(po.getSopoyballglassodmax()))||!"".equals(Utility.getName(po.getSopoypostglassodmin()))||!"".equals(Utility.getName(po.getSopoypostglassodmax()))){
				buffer.append("                               SELECT S_OP_IP_OptometryID ");
				buffer.append("                               FROM   S_OP_Inspection ");
				buffer.append("                               WHERE  1 = 1 ");
					if(!"".equals(Utility.getName(po.getSopoyballglassodmin()))||!"".equals(Utility.getName(po.getSopoyballglassodmax()))){
						if(!"".equals(Utility.getName(po.getSopoyballglassodmin()))&&!"".equals(Utility.getName(po.getSopoyballglassodmax()))){
							buffer.append("                                      AND Isnumeric(S_OP_IP_BallGlassOD) > 0  ");
							buffer.append("                                      AND Isnumeric(S_OP_IP_BallGlassOS) > 0  ");
							buffer.append("                                      AND (  ");
							buffer.append("                                      (CAST(S_OP_IP_BallGlassOD AS FLOAT) >= cast( ? as float) ");
							buffer.append("                                            AND CAST(S_OP_IP_BallGlassOD AS FLOAT) <=  cast( ? as float))   ");
							buffer.append("                                       OR ( CAST(S_OP_IP_BallGlassOS AS FLOAT) >=  cast( ? as float) ");
							buffer.append("                                            AND CAST(S_OP_IP_BallGlassOS AS FLOAT) <=  cast( ? as float) ) ) ");
							params.add(Utility.getName(po.getSopoyballglassodmin()));
							params.add(Utility.getName(po.getSopoyballglassodmax()));
							params.add(Utility.getName(po.getSopoyballglassodmin()));
							params.add(Utility.getName(po.getSopoyballglassodmax()));
						}else if(!"".equals(Utility.getName(po.getSopoyballglassodmin()))&&"".equals(Utility.getName(po.getSopoyballglassodmax()))){
							buffer.append("                                      AND Isnumeric(S_OP_IP_BallGlassOD) > 0  ");
							buffer.append("                                      AND Isnumeric(S_OP_IP_BallGlassOS) > 0  ");
							buffer.append("                                      AND (  ");
							buffer.append("                                      (CAST(S_OP_IP_BallGlassOD AS FLOAT) >=  cast( ? as float)) ");
							buffer.append("                                       OR ( CAST(S_OP_IP_BallGlassOS AS FLOAT) >=  cast( ? as float)) ) ");
							params.add(Utility.getName(po.getSopoyballglassodmin()));
							params.add(Utility.getName(po.getSopoyballglassodmin()));
						}else if("".equals(Utility.getName(po.getSopoyballglassodmin()))&&!"".equals(Utility.getName(po.getSopoyballglassodmax()))){
							buffer.append("                                      AND Isnumeric(S_OP_IP_BallGlassOD) > 0  ");
							buffer.append("                                      AND Isnumeric(S_OP_IP_BallGlassOS) > 0  ");
							buffer.append("                                      AND (  ");
							buffer.append("                                      ( ");
							buffer.append("                                            CAST(S_OP_IP_BallGlassOD AS FLOAT) <=  cast( ? as float) )   ");
							buffer.append("                                       OR (  ");
							buffer.append("                                            CAST(S_OP_IP_BallGlassOS AS FLOAT) <=  cast( ? as float) ) ) ");
							params.add(Utility.getName(po.getSopoyballglassodmax()));
							params.add(Utility.getName(po.getSopoyballglassodmax()));
						}
					}
			
					
					if(!"".equals(Utility.getName(po.getSopoypostglassodmin()))||!"".equals(Utility.getName(po.getSopoypostglassodmax()))){
						if(!"".equals(Utility.getName(po.getSopoypostglassodmin()))&&!"".equals(Utility.getName(po.getSopoypostglassodmax()))){
							buffer.append("                                      AND Isnumeric(S_OP_IP_PostGlassOD) > 0  ");
							buffer.append("                                      AND Isnumeric(S_OP_IP_PostGlassOS) > 0  ");
							buffer.append("                                          AND (( CAST(S_OP_IP_PostGlassOD AS FLOAT) >=  cast( ? as float) ");
							buffer.append("                                                AND CAST(S_OP_IP_PostGlassOD AS FLOAT) <=  cast( ? as float) ) ");
							buffer.append("                                       OR ( CAST(S_OP_IP_PostGlassOS AS FLOAT) >=  cast( ? as float) ");
							buffer.append("                                            AND CAST(S_OP_IP_PostGlassOS AS FLOAT) <=  cast( ? as float) ) ) ");
							params.add(Utility.getName(po.getSopoypostglassodmin()));
							params.add(Utility.getName(po.getSopoypostglassodmax()));
							params.add(Utility.getName(po.getSopoypostglassodmin()));
							params.add(Utility.getName(po.getSopoypostglassodmax()));
						}else if(!"".equals(Utility.getName(po.getSopoypostglassodmin()))&&"".equals(Utility.getName(po.getSopoypostglassodmax()))){
							buffer.append("                                      AND Isnumeric(S_OP_IP_PostGlassOD) > 0  ");
							buffer.append("                                      AND Isnumeric(S_OP_IP_PostGlassOS) > 0  ");
							buffer.append("                                          AND (( CAST(S_OP_IP_PostGlassOD AS FLOAT) >=  cast( ? as float) ");
							buffer.append("                                                ) ");
							buffer.append("                                       OR ( CAST(S_OP_IP_PostGlassOS AS FLOAT) >=  cast( ? as float) ) ) ");
							params.add(Utility.getName(po.getSopoypostglassodmin()));
							params.add(Utility.getName(po.getSopoypostglassodmin()));
						}else if("".equals(Utility.getName(po.getSopoypostglassodmin()))&&!"".equals(Utility.getName(po.getSopoypostglassodmax()))){
							buffer.append("                                      AND Isnumeric(S_OP_IP_PostGlassOD) > 0  ");
							buffer.append("                                      AND Isnumeric(S_OP_IP_PostGlassOS) > 0  ");
							buffer.append("                                          AND ((  ");
							buffer.append("                                                CAST(S_OP_IP_PostGlassOD AS FLOAT) <=  cast( ? as float) ) ");
							buffer.append("                                       OR (  ");
							buffer.append("                                            CAST(S_OP_IP_PostGlassOS AS FLOAT) <=  cast( ? as float) ) ) ");
							params.add(Utility.getName(po.getSopoypostglassodmax()));
							params.add(Utility.getName(po.getSopoypostglassodmax()));
						}
						
					}
					if(!"".equals(Utility.getName(po.getSopoyfarworth()))||!"".equals(Utility.getName(po.getSopoyacamin()))||!"".equals(Utility.getName(po.getSopoyacamax()))||!"".equals(Utility.getName(po.getSopoyfarhetelevelmin()))||!"".equals(Utility.getName(po.getSopoyfarhetelevelmax()))||!"".equals(Utility.getName(po.getSopoyfarHeteuprightnessmin()))||!"".equals(Utility.getName(po.getSopoyfarHeteuprightnessmax()))
							||!"".equals(Utility.getName(po.getSopoyclosehetelevelmin()))||!"".equals(Utility.getName(po.getSopoyclosehetelevelmax()))||!"".equals(Utility.getName(po.getSopoycloseheteuprightnessmin()))||!"".equals(Utility.getName(po.getSopoycloseheteuprightnessmax()))
							||!"".equals(Utility.getName(po.getSopoybccmin()))||!"".equals(Utility.getName(po.getSopoypramin()))||!"".equals(Utility.getName(po.getSopoynramin()))
							||!"".equals(Utility.getName(po.getSopoybccmax()))||!"".equals(Utility.getName(po.getSopoypramax()))||!"".equals(Utility.getName(po.getSopoynramax()))){
						buffer.append("                               UNION ALL ");
					}
						
			}
			
			if(!"".equals(Utility.getName(po.getSopoyfarworth()))||!"".equals(Utility.getName(po.getSopoyacamin()))||!"".equals(Utility.getName(po.getSopoyacamax()))||!"".equals(Utility.getName(po.getSopoyfarhetelevelmin()))||!"".equals(Utility.getName(po.getSopoyfarhetelevelmax()))||!"".equals(Utility.getName(po.getSopoyfarHeteuprightnessmin()))||!"".equals(Utility.getName(po.getSopoyfarHeteuprightnessmax()))
					||!"".equals(Utility.getName(po.getSopoyclosehetelevelmin()))||!"".equals(Utility.getName(po.getSopoyclosehetelevelmax()))||!"".equals(Utility.getName(po.getSopoycloseheteuprightnessmin()))||!"".equals(Utility.getName(po.getSopoycloseheteuprightnessmax()))
					||!"".equals(Utility.getName(po.getSopoybccmin()))||!"".equals(Utility.getName(po.getSopoypramin()))||!"".equals(Utility.getName(po.getSopoynramin()))
					||!"".equals(Utility.getName(po.getSopoybccmax()))||!"".equals(Utility.getName(po.getSopoypramax()))||!"".equals(Utility.getName(po.getSopoynramax()))){
				
				buffer.append("                               SELECT S_OP_DE_OptometryID ");
				buffer.append("                               FROM   S_OP_DoubleEyeFunction ");
				buffer.append("                               WHERE  1 = 1 ");
				
				if(!"".equals(Utility.getName(po.getSopoyfarworth()))){
					buffer.append("                                      AND S_OP_DE_FarWorth = ? ");
					params.add(Utility.getName(po.getSopoyfarworth()));
				}
				
				if(!"".equals(Utility.getName(po.getSopoyacamin()))){
					buffer.append("                                      AND Isnumeric(S_OP_DE_ACA) > 0  ");
					buffer.append("                                      AND S_OP_DE_ACA >= CAST(? AS FLOAT) ");
					params.add(Utility.getName(po.getSopoyacamin()));
				}
				
				if(!"".equals(Utility.getName(po.getSopoyacamax()))){
					buffer.append("                                      AND Isnumeric(S_OP_DE_ACA) > 0  ");
					buffer.append("                                      AND S_OP_DE_ACA <= CAST(? AS FLOAT) ");
					params.add(Utility.getName(po.getSopoyacamax()));
				}
				
				if(!"".equals(Utility.getName(po.getSopoyfarhetelevelmin()))){
					buffer.append("                                      AND Isnumeric(S_OP_DE_FarHeteLevel) > 0  ");
					buffer.append("                                      AND S_OP_DE_FarHeteLevel >= CAST(? AS FLOAT) ");
					params.add(Utility.getName(po.getSopoyfarhetelevelmin()));
				}
				
				if(!"".equals(Utility.getName(po.getSopoyfarhetelevelmax()))){
					buffer.append("                                      AND Isnumeric(S_OP_DE_FarHeteLevel) > 0  ");
					buffer.append("                                      AND S_OP_DE_FarHeteLevel <= CAST(? AS FLOAT) ");
					params.add(Utility.getName(po.getSopoyfarhetelevelmax()));
				}
				
				if(!"".equals(Utility.getName(po.getSopoyfarHeteuprightnessmin()))){
					buffer.append("                                      AND Isnumeric(S_OP_DE_FarHeteUprightness) > 0  ");
					buffer.append("                                      AND S_OP_DE_FarHeteUprightness >= CAST(? AS FLOAT) ");
					params.add(Utility.getName(po.getSopoyfarHeteuprightnessmin()));
				}
				
				if(!"".equals(Utility.getName(po.getSopoyfarHeteuprightnessmax()))){
					buffer.append("                                      AND Isnumeric(S_OP_DE_FarHeteUprightness) > 0  ");
					buffer.append("                                      AND S_OP_DE_FarHeteUprightness <= CAST(? AS FLOAT) ");
					params.add(Utility.getName(po.getSopoyfarHeteuprightnessmax()));
				}
				
				if(!"".equals(Utility.getName(po.getSopoyclosehetelevelmin()))){
					buffer.append("                                      AND Isnumeric(S_OP_DE_CloseHeteLevel) > 0  ");
					buffer.append("                                      AND S_OP_DE_CloseHeteLevel >= CAST(? AS FLOAT) ");
					params.add(Utility.getName(po.getSopoyclosehetelevelmin()));
				}
				
				if(!"".equals(Utility.getName(po.getSopoyclosehetelevelmax()))){
					buffer.append("                                      AND Isnumeric(S_OP_DE_CloseHeteLevel) > 0  ");
					buffer.append("                                      AND S_OP_DE_CloseHeteLevel <= CAST(? AS FLOAT) ");
					params.add(Utility.getName(po.getSopoyclosehetelevelmax()));
				}
				
				if(!"".equals(Utility.getName(po.getSopoycloseheteuprightnessmin()))){
					buffer.append("                                      AND Isnumeric(S_OP_DE_CloseHeteUprightness) > 0  ");
					buffer.append("                                      AND S_OP_DE_CloseHeteUprightness >= CAST(? AS FLOAT) ");
					params.add(Utility.getName(po.getSopoycloseheteuprightnessmin()));
				}
				
				if(!"".equals(Utility.getName(po.getSopoycloseheteuprightnessmax()))){
					buffer.append("                                      AND Isnumeric(S_OP_DE_CloseHeteUprightness) > 0  ");
					buffer.append("                                      AND S_OP_DE_CloseHeteUprightness <= CAST(? AS FLOAT) ");
					params.add(Utility.getName(po.getSopoycloseheteuprightnessmax()));
				}
				
				if(!"".equals(Utility.getName(po.getSopoybccmin()))){
					buffer.append("                                      AND Isnumeric(S_OP_DE_BCC) > 0  ");
					buffer.append("                                      AND S_OP_DE_BCC >= CAST(? AS FLOAT) ");
					params.add(Utility.getName(po.getSopoybccmin()));
				}
				
				if(!"".equals(Utility.getName(po.getSopoybccmax()))){
					buffer.append("                                      AND Isnumeric(S_OP_DE_BCC) > 0  ");
					buffer.append("                                      AND S_OP_DE_BCC <= CAST(? AS FLOAT) ");
					params.add(Utility.getName(po.getSopoybccmax()));
				}
				
				if(!"".equals(Utility.getName(po.getSopoypramin()))){
					buffer.append("                                      AND Isnumeric(S_OP_DE_PositiveAccPRA) > 0  ");
					buffer.append("                                      AND S_OP_DE_PositiveAccPRA >= CAST(? AS FLOAT) ");
					params.add(Utility.getName(po.getSopoypramin()));
				}
				
				if(!"".equals(Utility.getName(po.getSopoypramax()))){
					buffer.append("                                      AND Isnumeric(S_OP_DE_PositiveAccPRA) > 0  ");
					buffer.append("                                      AND S_OP_DE_PositiveAccPRA <= CAST(? AS FLOAT) ");
					params.add(Utility.getName(po.getSopoypramax()));
				}
				
				if(!"".equals(Utility.getName(po.getSopoynramin()))){
					buffer.append("                                      AND Isnumeric(S_OP_DE_NegativeAccNRA) > 0  ");
					buffer.append("                                      AND S_OP_DE_NegativeAccNRA >= CAST(? AS FLOAT) ");
					params.add(Utility.getName(po.getSopoynramin()));
				}
				
				if(!"".equals(Utility.getName(po.getSopoynramax()))){
					buffer.append("                                      AND Isnumeric(S_OP_DE_NegativeAccNRA) > 0  ");
					buffer.append("                                      AND S_OP_DE_NegativeAccNRA <= CAST(? AS FLOAT) ");
					params.add(Utility.getName(po.getSopoynramax()));
				}
			
			}
				buffer.append("                                      ) ");
		}
		
		if(!"".equals(Utility.getName(po.getSopoydoublecheck()))){
			if("1".equals(po.getSopoydoublecheck())){
				buffer.append(" and S_OP_OY_OptometryID In(select S_OP_DE_OptometryID from S_OP_DoubleEyeFunction)");
			}
			if("0".equals(po.getSopoydoublecheck())){
				buffer.append(" and S_OP_OY_OptometryID not In(select S_OP_DE_OptometryID from S_OP_DoubleEyeFunction)");
			}
		}	
			
		if(!"".equals(Utility.getName(po.getSopoybegindate()))){
			buffer.append("                                      and convert(varchar(10),S_OP_OY_Time,23) >= ? ");
			params.add(Utility.getName(po.getSopoybegindate()));			
		}
		
		if(!"".equals(Utility.getName(po.getSopoyenddate()))){
			buffer.append("                                      and convert(varchar(10),S_OP_OY_Time,23) <= ? ");
			params.add(Utility.getName(po.getSopoyenddate()));
		}
		
		if(!"".equals(Utility.getName(po.getSopoypersonid()))){
			buffer.append("                                      and S_OP_OY_PersonID = ? ");
			params.add(Utility.getName(po.getSopoypersonid()));
		}
		
		if(!"".equals(Utility.getName(po.getSopoymemberid()))){
			
			buffer.append("                                      and S_ME_CI_MemberId like '%'+?+'%' ");
			params.add(Utility.getName(po.getSopoymemberid()));
		}
		
		if(!"".equals(Utility.getName(po.getSopoyshopcode()))){
			buffer.append("                                      and S_OP_OY_ShopCode =? ");
			params.add(Utility.getName(po.getSopoyshopcode()));
		}
		
		if(!"".equals(Utility.getName(po.getSopoyname()))){
			buffer.append("                                      and S_ME_CI_Name like '%'+?+'%' ");
			params.add(Utility.getName(po.getSopoyname()));
		}
		
		if(po.getSmecishoplist() != null && po.getSmecishoplist().size() > 0){
			
			buffer.append(" and S_ME_CI_ShopCode in ( ? ");

			List<DepartmentsPo> dList = po.getSmecishoplist();
			params.add(Utility.getName(dList.get(0).getBdpdepartmentid()));

			for (int i = 1; i < dList.size(); i++){
				buffer.append(" ,? ");
				params.add(Utility.getName(dList.get(i).getBdpdepartmentid()));
			}
			buffer.append(" ) ");
		}
		
		buffer.append(" and S_OP_OY_Flag = '1') temp where rowNum > " + start + " and rowNum <= " + countPage);
		buffer.append(" set rowcount 0");
		
		return queryForObjectList(buffer.toString(), params.toArray(),
				OptometryPo.class);
	}

}
