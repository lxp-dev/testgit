package com.pengsheng.eims.basic.mgr.impl;

import com.pengsheng.eims.basic.dao.GetMachineValuesDao;
import com.pengsheng.eims.basic.mgr.GetMachineValuesMgr;
import com.pengsheng.eims.basic.persistence.ApparatusPo;
import com.pengsheng.eims.basic.persistence.NidekPo;
import com.pengsheng.eims.basic.persistence.TOPConPo;

public class GetMachineValuesMgrImpl implements GetMachineValuesMgr{
	private GetMachineValuesDao getMachineValuesDao;

	public ApparatusPo getNIDEK(String str,ApparatusPo po) {
		ApparatusPo appPo = null;
		char cstr[] = str.toCharArray();
		
		String nstr = "";
		
		for(int i=0; i<cstr.length; i++){
			if(po.getNidek().toCharArray()[0] == cstr[i]) {
				nstr = nstr + "\n";
			}else{
				nstr = nstr + cstr[i];
			}
		}
		
		String[] strlist = null; 
		
		strlist = nstr.split("\n");
		appPo = this.getNidekPo(strlist, "nidek");
		ApparatusPo po2 = getMachineValuesDao.selectGetMachineValues(null);
		appPo.setNidek(po2.getNidek());
		appPo.setTopcon(po2.getTopcon());
		return appPo;
	}

	public ApparatusPo getTOPCON(String str,ApparatusPo po) {
		ApparatusPo appPo = null;
		char cstr[] = str.toCharArray();
		
		String nstr = "";
		
		for(int i=0; i<cstr.length; i++){
			if(po.getTopcon().toCharArray()[0] == cstr[i]) {
				nstr = nstr + "\n";
			}else{
				nstr = nstr + cstr[i];
			}
		}
		
		String[] strlist = null; 
		
		strlist = nstr.split("\n");
		appPo = this.getTopconPo(strlist, "topcon");
		ApparatusPo po2 = getMachineValuesDao.selectGetMachineValues(null);
		appPo.setNidek(po2.getNidek());
		appPo.setTopcon(po2.getTopcon());
		return appPo;
	}
	
	/**
	 * 解析球镜柱镜轴向
	 * 
	 * @param str
	 * @param position
	 *            球镜：1，柱镜：2，轴向：3
	 * @return
	 */
	private static String getSphCylAxis(String str, int position) {

		String rtnStr = "";
		
		switch (position) {

		case 1:
			
			rtnStr = str.substring(2, 8);
			System.out.println("球径"+rtnStr);
			break;

		case 2:

			rtnStr = str.substring(8, 14);
			System.out.println("柱径"+rtnStr);
			break;

		case 3:

			rtnStr = str.substring(14, 17);
			System.out.println("轴向"+rtnStr);
			break;

		}

		return rtnStr;

	}
	/**
	 * 解析棱镜下加
	 * 
	 * @param str
	 * @return
	 */
	private static String getPrismAdd(String str) {

		return str.substring(2, 7);

	}
	

	/**
	 * 若值为0.00，则转为null
	 * 
	 * @param str
	 * @return
	 */
	private static String isZero(String str) {

		if (Float.parseFloat(str) == 0) {

			return null;

		}

		return str;

	}

	/**
	 * 解析棱镜基底
	 * 
	 * @param str
	 * @return
	 */
	private static String getPrismBase(String str) {

		return str.substring(7, 8);

	}
	/**
	 * 解析焦度计字符串
	 * 
	 * @param str
	 * @return
	 */
	public static NidekPo getNidekPo(String[] str, String type) {
		NidekPo np = new NidekPo();

		double tempPrismOD = 0.0D;
		double tempPrismOS = 0.0D;
		String tempbaseOD = "";
		String tempbaseOS = "";
		
		for (String temp : str) {
			if (temp.startsWith(" R")) {
				np.setSphOD(getSphCylAxis(temp, 1));
				np.setCylOD(getSphCylAxis(temp, 2));
				np.setAxisOD(isZero(getSphCylAxis(temp, 3)));
			}

			if (temp.startsWith(" L")) {
				np.setSphOS(getSphCylAxis(temp, 1));
				np.setCylOS(getSphCylAxis(temp, 2));
				np.setAxisOS(isZero(getSphCylAxis(temp, 3)));
			}

			if (temp.startsWith("AR")) {
				np.setAddOD(isZero(getPrismAdd(temp)));
			}

			if (temp.startsWith("AL")) {
				np.setAddOS(isZero(getPrismAdd(temp)));
			}

			if (temp.startsWith("PR")) {
				if (temp.matches("^[\\w\\.]*[IO][\\W]{1}$")) {
					np.setPrismOD1(isZero(getPrismAdd(temp)));

					if (np.getPrismOD1() == null) {
						np.setBaseOD1(null);
					} else {
						np.setBaseOD1(getPrismBase(temp));
					}

				} else if (temp.matches("^[\\w\\.]*[UD][\\W]{1}$")) {
					tempPrismOD = Double
							.parseDouble((getPrismAdd(temp) == null) ? "0"
									: getPrismAdd(temp));
					tempbaseOD = getPrismBase(temp);

					np.setPrismOD2(isZero(getPrismAdd(temp)));

					if (np.getPrismOD2() == null) {
						np.setBaseOD2(null);
					} else {
						np.setBaseOD2(getPrismBase(temp));
					}

				}

			}

			if (temp.startsWith("PL")) {
				if (temp.matches("^[\\w\\.]*[IO][\\W]{1}$")) {
					np.setPrismOS1(isZero(getPrismAdd(temp)));

					if (np.getPrismOS1() == null) {
						np.setBaseOS1(null);
					} else {
						np.setBaseOS1(getPrismBase(temp));
					}

				} else if (temp.matches("^[\\w\\.]*[UD][\\W]{1}$")) {
					tempPrismOS = Double
							.parseDouble((getPrismAdd(temp) == null) ? "0"
									: getPrismAdd(temp));
					tempbaseOS = getPrismBase(temp);

					np.setPrismOS2(isZero(getPrismAdd(temp)));

					if (np.getPrismOS2() == null) {
						np.setBaseOS2(null);
					} else {
						np.setBaseOS2(getPrismBase(temp));
					}

				}

			}

			if (temp.startsWith("PD")) {
				String RPD = temp.substring(6, 10);
				String LPD = temp.substring(10, 14);

				np.setRpd(RPD);
				np.setLpd(LPD);
			}

			if (temp.matches("^NP.*[UD].$")) {
				np.setGxcc(temp.substring(3, 7));
			}

		}

		if ((np.getGxcc() == null) || ("".equals(np.getGxcc()))) {
			if (tempbaseOD.equals(tempbaseOS)) {
				np.setGxcc(String.valueOf(Math.abs(tempPrismOD - tempPrismOS)));
			} else if (!(tempbaseOD.equals(tempbaseOS))) {
				np.setGxcc(String.valueOf(Math.abs(tempPrismOD + tempPrismOS)));
			}

		}

		return np;
	}

	public static TOPConPo getTopconPo(String[] str, String type)
	  {
	    TOPConPo np = new TOPConPo();

	    double tempPrismOD = 0.0D;
	    double tempPrismOS = 0.0D;
	    String tempbaseOD = "";
	    String tempbaseOS = "";

	    for (int i = 0; i < str.length; ++i)
	    {
	    //@CL-2800        002.10                                    *R -2.08 -0.97 13000.00000.00I 0.14D 0.15L -2.01 -0.99 13000.00000.00O 0.07D 0.1000.040.541.5*
	      if ("R".equals(str[i].trim())) {
	        np.setSphOD(str[(++i)].trim());
	        np.setCylOD(str[(++i)].trim());
	        np.setAxisOD(isZero(str[(++i)].trim()));
	        np.setAddOD(str[(++i)].trim());

	        ++i;
	        ++i;

	        if ((str[i] != null) && (!("".equals(str[i])))) {
	          np.setPrismOD1(str[i].substring(2, 6));
	          np.setBaseOD1(str[i].substring(0, 1));
	        }

	        ++i;

	        if ((str[i] != null) && (!("".equals(str[i])))) {
	          np.setPrismOD2(str[i].trim().substring(2, 6));
	          np.setBaseOD2(str[i].trim().substring(0, 1));
	        }

	        tempPrismOD = Double.parseDouble((str[i] == null) ? "0" : np
	          .getPrismOD2());

	        tempbaseOD = np.getBaseOD2();
	      }
	      else if ("L".equals(str[i])) {
	        np.setSphOS(str[(++i)].trim());
	        np.setCylOS(str[(++i)].trim());
	        np.setAxisOS(isZero(str[(++i)].trim()));
	        np.setAddOS(str[(++i)].trim());

	        ++i;
	        ++i;

	        if ((str[i] != null) && (!("".equals(str[i])))) {
	          np.setPrismOS1(isZero(str[i].substring(2, 6)));
	          np.setBaseOS1(str[i].substring(0, 1));
	        }

	        ++i;

	        if ((str[i] != null) && (!("".equals(str[i])))) {
	          np.setPrismOS2(isZero(str[i].substring(2, 6)));
	          np.setBaseOS2(str[i].substring(0, 1));
	        }

	        tempPrismOS = Double.parseDouble((str[i] == null) ? "0" : np
	          .getPrismOS2());
	        tempbaseOS = np.getBaseOS2();
	      }

	    }

	    if ((np.getGxcc() == null) || ("".equals(np.getGxcc()))) {
	      if (tempbaseOD.equals(tempbaseOS))
	        np.setGxcc(String.valueOf(Math.abs(tempPrismOD - tempPrismOS)));
	      else if (!(tempbaseOD.equals(tempbaseOS))) {
	        np.setGxcc(String.valueOf(Math.abs(tempPrismOD + tempPrismOS)));
	      }

	    }

	    int ii=0;
	    for (ii = str.length - 1; ii >= 0; --ii) {
	        if (!("*".equals(str[ii].trim())))
	          continue;
	        np.setLpd(str[(--ii)].trim());
	        np.setRpd(str[(--ii)].trim());
	        break;
	      }


	    return np;
	  }

	public ApparatusPo selectGetMachineValues(ApparatusPo po) {
		return getMachineValuesDao.selectGetMachineValues(po);
	}

	public void updateGetMachineValues(ApparatusPo po) {
		getMachineValuesDao.updateGetMachineValues(po);
	}

	public GetMachineValuesDao getGetMachineValuesDao() {
		return getMachineValuesDao;
	}

	public void setGetMachineValuesDao(GetMachineValuesDao getMachineValuesDao) {
		this.getMachineValuesDao = getMachineValuesDao;
	}
	
}
