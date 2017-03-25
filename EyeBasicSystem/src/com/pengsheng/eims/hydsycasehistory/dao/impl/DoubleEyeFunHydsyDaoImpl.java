package com.pengsheng.eims.hydsycasehistory.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.hydsycasehistory.dao.DoubleEyeFunHydsyDao;
import com.pengsheng.eims.hydsycasehistory.persistence.DoubleEyeFunPo;
import com.pengsheng.eims.hydsycasehistory.persistence.OptometryBasicPo;
import com.pengsheng.eims.hydsycasehistory.persistence.OptometryPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class DoubleEyeFunHydsyDaoImpl extends BaseJdbcDaoSupport implements
		DoubleEyeFunHydsyDao {

	/**
	 * 显示双眼视功能检查
	 * 
	 * @param po
	 * @return
	 */
	public DoubleEyeFunPo getDoubleEyeFun(DoubleEyeFunPo po) {

		StringBuffer sb = new StringBuffer();
		
		sb.append("SELECT top 1  S_OP_DE_ID as sopdeid ");
		sb.append(",S_OP_DE_CustomerID as sopdecustomerid ");
		sb.append(",S_OP_DE_OptometryBasicID as sopdeoptometrybasicid ");
		sb.append(",S_OP_DE_OptometryID as sopdeoptometryid ");
		sb.append(",S_OP_DE_FarWorth as sopdefarworth ");
		sb.append(",S_OP_DE_ACA as sopdeaca ");
		sb.append(",S_OP_DE_ACAWay as sopdeacaway  ");
		sb.append(",S_OP_DE_PDWay as sopdepdway ");
		sb.append(",S_OP_DE_NDWay as sopdendway ");
		sb.append(",S_OP_DE_SolidWatch as sopdesolidwatch ");
		sb.append(",S_OP_DE_FarHeteLevel as sopdefarhetelevel ");
		sb.append(",S_OP_DE_FarHeteLevelIO  as sopdefarhetelevelio ");
		sb.append(",S_OP_DE_FarHeteUprightness as sopdefarheteuprightness ");
		sb.append(",S_OP_DE_FarHeteUprightnessUD as sopdefarheteuprightnessud ");
		sb.append(",S_OP_DE_FarAmaLevelP as sopdefaramalevelp ");
		sb.append(",S_OP_DE_FarAmaLevelPO as sopdefaramalevelpo ");
		sb.append(",S_OP_DE_FarAmaLevelPT as sopdefaramalevelpt ");
		sb.append(",S_OP_DE_FarAmaLevelN as sopdefaramaleveln ");
		sb.append(",S_OP_DE_FarAmaLevelNO as sopdefaramalevelno ");
		sb.append(",S_OP_DE_FarAmaLevelNT as sopdefaramalevelnt ");
		sb.append(",S_OP_DE_FarAmaBU as sopdefaramabu ");
		sb.append(",S_OP_DE_FarAmaBUO as sopdefaramabuo ");
		sb.append(",S_OP_DE_FarAmaLBU as sopdefaramalbu ");
		sb.append(",S_OP_DE_FarAmaLBUO as sopdefaramalbuo ");
		sb.append(",S_OP_DE_FarAmaBD as sopdefaramabd ");
		sb.append(",S_OP_DE_FarAmaBDO as sopdefaramabdo ");
		sb.append(",S_OP_DE_FarAmaLBD as sopdefaramalbd ");
		sb.append(",S_OP_DE_FarAmaLBDO as sopdefaramalbdo ");
		sb.append(",S_OP_DE_DifWatch as sopdedifwatch ");
		sb.append(",S_OP_DE_CloseHeteLevel  as sopdeclosehetelevel ");
		sb.append(",S_OP_DE_CloseHeteLevelIO as sopdeclosehetelevelio ");
		sb.append(",S_OP_DE_CloseHeteUprightness as sopdecloseheteuprightness ");
		sb.append(",S_OP_DE_CloseHeteUprightnessUD as sopdecloseheteuprightnessud ");
		sb.append(",S_OP_DE_CloseAmaLevelP  as sopdecloseamalevelp ");
		sb.append(",S_OP_DE_CloseAmaLevelPO as sopdecloseamalevelpo ");
		sb.append(",S_OP_DE_CloseAmaLevelPT as sopdecloseamalevelpt ");
		sb.append(",S_OP_DE_CloseAmaLevelN  as sopdecloseamaleveln ");
		sb.append(",S_OP_DE_CloseAmaLevelNO as sopdecloseamalevelno ");
		sb.append(",S_OP_DE_CloseAmaLevelNT as sopdecloseamalevelnt ");
		sb.append(",S_OP_DE_CloseAmaBU as sopdecloseamabu ");
		sb.append(",S_OP_DE_CloseAmaBUO as sopdecloseamabuo ");
		sb.append(",S_OP_DE_CloseAmaLBU as sopdecloseamalbu ");
		sb.append(",S_OP_DE_CloseAmaLBUO as sopdecloseamalbuo ");
		sb.append(",S_OP_DE_CloseAmaBD as sopdecloseamabd ");
		sb.append(",S_OP_DE_CloseAmaBDO as sopdecloseamabdo ");
		sb.append(",S_OP_DE_CloseAmaLBD as sopdecloseamalbd ");
		sb.append(",S_OP_DE_CloseAmaLBDO as sopdecloseamalbdo ");
		sb.append(",S_OP_DE_NPC as sopdenpc ");
		sb.append(",S_OP_DE_AccOD as sopdeaccod ");
		sb.append(",S_OP_DE_AccOS as sopdeaccos ");
		sb.append(",S_OP_DE_AccOU as sopdeaccou ");
		sb.append(",S_OP_DE_BCC as sopdebcc ");
		sb.append(",S_OP_DE_PositiveAccPRA  as sopdepositiveaccpra ");
		sb.append(",S_OP_DE_NegativeAccNRA  as sopdenegativeaccnra ");
		sb.append(",S_OP_DE_Facility as sopdefacility ");
		sb.append(",S_OP_DE_FacilityOD as sopdefacilityod ");
		sb.append(",S_OP_DE_FacilityOS as sopdefacilityos ");
		sb.append(",S_OP_DE_FacilityOU as sopdefacilityou ");
		sb.append(",S_OP_DE_AddOD as sopdeaddod ");
		sb.append(",S_OP_DE_AddOS as sopdeaddos ");
		sb.append(",S_OP_DE_Distance as sopdedistance ");
		sb.append(",S_OP_DE_Range as sopderange ");
		sb.append(",S_OP_DE_RangeO as sopderangeo  ");
		sb.append(",S_OP_DE_Account as sopdeaccount  ");
		sb.append(",S_OP_DE_Acaz as sopdeacaz  "); //sxh 2011-5-20 新加10字段
		sb.append(",S_OP_DE_Xieshi as sopdexieshi  ");
		sb.append(",S_OP_DE_Ruoshi as sopderuoshi  ");
		sb.append(",S_OP_DE_Quguangbuzheng as sopdequguangbuzheng  ");
		sb.append(",S_OP_DE_Feixieshixingshuangyanshiyichang as sopdefeixieshixingshuangyanshiyichang  ");
		sb.append(",S_OP_DE_Kuangjiayanjing as sopdekuangjiayanjing  ");
		sb.append(",S_OP_DE_Yinxingyanjing as sopdeyinxingyanjing  ");
		sb.append(",S_OP_DE_Ruoshixunlian as sopderuoshixunlian  ");
		sb.append(",S_OP_DE_Tiaojiexunlian as sopdetiaojiexunlian  ");
		sb.append(",S_OP_DE_Fucouxunlian as sopdefucouxunlian  ");
		sb.append(",S_OP_DE_ACAz1 as sopdeacaz1 ");
		sb.append(",S_OP_DE_ACAf1 as sopdeacaf1 ");		
		sb.append(",S_OP_DE_CoverOD               as sopdecoverod  ");
		sb.append(",S_OP_DE_CoverOS               as sopdecoveros  ");
		sb.append(",S_OP_DE_SumDot                as sopdesumdot  ");
		sb.append(",S_OP_DE_TestBig               as sopdetestbig  ");
		sb.append(",S_OP_DE_TestBigIO             as sopdetestbigio  ");
		sb.append(",S_OP_DE_TestSmall             as sopdetestsmall  ");
		sb.append(",S_OP_DE_TestSmallIO           as sopdetestsmallio  ");
		sb.append(",S_OP_DE_PositiveAccPRAOD      as sopdepositiveaccpraod  ");
		sb.append(",S_OP_DE_PositiveAccPRAOS      as sopdepositiveaccpraos  ");
		sb.append(",S_OP_DE_NegativeAccNRAOD      as sopdenegativeaccnraod  ");
		sb.append(",S_OP_DE_NegativeAccNRAOS      as sopdenegativeaccnraos  ");
		sb.append(",S_OP_DE_TwoSideSpec           as sopdetwosidespec  ");
		sb.append(",S_OP_DE_TwoSideTest           as sopdetwosidetest  ");
		sb.append(",S_OP_DE_EqualWatch            as sopdeequalwatch  ");
		sb.append(",isnull(S_OP_DE_InspectEyeFunFlag,'') as sopdeinspecteyefun  ");		
		sb.append(",isnull(S_OP_DE_BccOU,'') as sopdebccou  ");
		sb.append(",isnull(S_OP_DE_BccOD,'') as sopdebccod  ");
		sb.append(",isnull(S_OP_DE_BccOS,'') as sopdebccos  ");
		
		sb.append("FROM S_OP_DoubleEyeFunction  ");
		sb.append("where S_OP_DE_OptometryID= ?");
		List<String> params = new ArrayList();
		params.add(po.getSopdeoptometryid());
		return (DoubleEyeFunPo) queryForObject(sb.toString(), params.toArray(),
				DoubleEyeFunPo.class);
		
	}

	/**
	 * 新增双眼视功能检查
	 * 
	 * @param po
	 */
	public void insertDoubleEyeFun(DoubleEyeFunPo po) {

		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("insert into S_OP_DoubleEyeFunction ( ");
		sb.append("S_OP_DE_ID,                                ");
		sb.append("S_OP_DE_CustomerID	,                      ");
		sb.append("S_OP_DE_OptometryBasicID,                  ");
		sb.append("S_OP_DE_OptometryID,                       ");
		sb.append("S_OP_DE_FarWorth	,                      ");
		sb.append("S_OP_DE_ACA	,                              ");
		sb.append("S_OP_DE_ACAWay	,                          ");
		sb.append("S_OP_DE_PDWay	,                          ");
		sb.append("S_OP_DE_NDWay	,                          ");
		sb.append("S_OP_DE_SolidWatch	,                      ");
		sb.append("S_OP_DE_FarHeteLevel	,                  ");
		sb.append("S_OP_DE_FarHeteLevelIO	,                  ");
		sb.append("S_OP_DE_FarHeteUprightness	,              ");
		sb.append("S_OP_DE_FarHeteUprightnessUD	,          ");
		sb.append("S_OP_DE_FarAmaLevelP	,                  ");
		sb.append("S_OP_DE_FarAmaLevelPO	,                  ");
		sb.append("S_OP_DE_FarAmaLevelPT	,                  ");
		sb.append("S_OP_DE_FarAmaLevelN	,                  ");
		sb.append("S_OP_DE_FarAmaLevelNO	,                  ");
		sb.append("S_OP_DE_FarAmaLevelNT	,                  ");
		sb.append("S_OP_DE_FarAmaBU	,                      ");
		sb.append("S_OP_DE_FarAmaBUO	,                      ");
		sb.append("S_OP_DE_FarAmaLBU	,                      ");
		sb.append("S_OP_DE_FarAmaLBUO	,                      ");
		sb.append("S_OP_DE_FarAmaBD	,                      ");
		sb.append("S_OP_DE_FarAmaBDO	,                      ");
		sb.append("S_OP_DE_FarAmaLBD	,                      ");
		sb.append("S_OP_DE_FarAmaLBDO	,                      ");
		sb.append("S_OP_DE_DifWatch	,                      ");
		sb.append("S_OP_DE_CloseHeteLevel	,                  ");
		sb.append("S_OP_DE_CloseHeteLevelIO	,              ");
		sb.append("S_OP_DE_CloseHeteUprightness	,          ");
		sb.append("S_OP_DE_CloseHeteUprightnessUD	,          ");
		sb.append("S_OP_DE_CloseAmaLevelP	,                  ");
		sb.append("S_OP_DE_CloseAmaLevelPO	,                  ");
		sb.append("S_OP_DE_CloseAmaLevelPT	,                  ");
		sb.append("S_OP_DE_CloseAmaLevelN	,                  ");
		sb.append("S_OP_DE_CloseAmaLevelNO	,                  ");
		sb.append("S_OP_DE_CloseAmaLevelNT	,                  ");
		sb.append("S_OP_DE_CloseAmaBU	,                      ");
		sb.append("S_OP_DE_CloseAmaBUO	,                      ");
		sb.append("S_OP_DE_CloseAmaLBU	,                      ");
		sb.append("S_OP_DE_CloseAmaLBUO	,                  ");
		sb.append("S_OP_DE_CloseAmaBD	,                      ");
		sb.append("S_OP_DE_CloseAmaBDO	,                      ");
		sb.append("S_OP_DE_CloseAmaLBD	,                      ");
		sb.append("S_OP_DE_CloseAmaLBDO	,                  ");
		sb.append("S_OP_DE_NPC	,                              ");
		sb.append("S_OP_DE_AccOD	,                          ");
		sb.append("S_OP_DE_AccOS	,                          ");
		sb.append("S_OP_DE_AccOU	,                          ");
		sb.append("S_OP_DE_BCC	,                              ");
		sb.append("S_OP_DE_PositiveAccPRA	,                  ");
		sb.append("S_OP_DE_NegativeAccNRA	,                  ");
		sb.append("S_OP_DE_Facility	,                      ");
		sb.append("S_OP_DE_FacilityOD	,                      ");
		sb.append("S_OP_DE_FacilityOS	,                      ");
		sb.append("S_OP_DE_FacilityOU	,                      ");
		sb.append("S_OP_DE_AddOD	,                          ");
		sb.append("S_OP_DE_AddOS	,                          ");
		sb.append("S_OP_DE_Distance	,                      ");
		sb.append("S_OP_DE_Range	,                          ");
		sb.append("S_OP_DE_RangeO	,                          ");
		sb.append("S_OP_DE_Account	,                          ");
		sb.append("S_OP_DE_CheckDate	,                      ");
		sb.append("S_OP_DE_Checker	,                          ");
		sb.append("S_OP_DE_Acaz	,                          ");
		sb.append("S_OP_DE_Xieshi	,                          ");
		sb.append("S_OP_DE_Ruoshi	,                          ");
		sb.append("S_OP_DE_Quguangbuzheng	,                  ");
		sb.append("S_OP_DE_Feixieshixingshuangyanshiyichang,	 ");
		sb.append("S_OP_DE_Kuangjiayanjing	,                  ");
		sb.append("S_OP_DE_Yinxingyanjing	,                  ");
		sb.append("S_OP_DE_Ruoshixunlian	,                  ");
		sb.append("S_OP_DE_Tiaojiexunlian	,                  ");
		sb.append("S_OP_DE_Fucouxunlian	,                  ");
		sb.append("S_OP_DE_ACAz1	,                          ");
		sb.append("S_OP_DE_ACAf1	,                          ");
		sb.append("S_OP_DE_CoverOD	,                          ");
		sb.append("S_OP_DE_CoverOS	,                          ");
		sb.append("S_OP_DE_SumDot	,                          ");
		sb.append("S_OP_DE_TestBig	,                          ");
		sb.append("S_OP_DE_TestBigIO	,                      ");
		sb.append("S_OP_DE_TestSmall	,                      ");
		sb.append("S_OP_DE_TestSmallIO	,                      ");
		sb.append("S_OP_DE_PositiveAccPRAOD	,              ");
		sb.append("S_OP_DE_PositiveAccPRAOS	,              ");
		sb.append("S_OP_DE_NegativeAccNRAOD	,              ");
		sb.append("S_OP_DE_NegativeAccNRAOS	,              ");
		sb.append("S_OP_DE_TwoSideSpec	,                      ");
		sb.append("S_OP_DE_TwoSideTest	,                      ");
		sb.append("S_OP_DE_EqualWatch,	                       ");
		sb.append("S_OP_DE_InspectEyeFunFlag,	                       ");		
		sb.append("S_OP_DE_BccOU,                       ");
		sb.append("S_OP_DE_BccOD,	                       ");
		sb.append("S_OP_DE_BccOS	                       ");
		
		sb.append(" ) values ( ");
		sb.append("?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?, ");//20
		sb.append("?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?, ?,?, ");//22
		sb.append("?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?, ?,?,?, ? ,getDate(),?, ");//22
		sb.append("?,?,?,?,?,?,?,?,?,?,?,?");//12
		sb.append(" ,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ");//17
		sb.append(")");

		params.add(this.uuid.generate());// id
		params.add(Utility.getName(po.getSopdecustomerid()));// 顾客号
		params.add(Utility.getName(po.getSopdeoptometryBasicid()));// 验光基表ID
		params.add(Utility.getName(po.getSopdeoptometryid()));// 验光号
		params.add(Utility.getName(po.getSopdefarworth()));
		params.add(Utility.getName(po.getSopdeaca()));
		params.add(Utility.getName(po.getSopdeacaway()));
		params.add(Utility.getName(po.getSopdepdway()));
		params.add(Utility.getName(po.getSopdendway()));
		params.add(Utility.getName(po.getSopdesolidwatch()));
		params.add(Utility.getName(po.getSopdefarhetelevel()));
		params.add(Utility.getName(po.getSopdefarhetelevelio()));
		params.add(Utility.getName(po.getSopdefarheteuprightness()));
		params.add(Utility.getName(po.getSopdefarheteuprightnessud()));
		params.add(Utility.getName(po.getSopdefaramalevelp()));
		params.add(Utility.getName(po.getSopdefaramalevelpo()));
		params.add(Utility.getName(po.getSopdefaramalevelpt()));
		params.add(Utility.getName(po.getSopdefaramaleveln()));
		params.add(Utility.getName(po.getSopdefaramalevelno()));
		params.add(Utility.getName(po.getSopdefaramalevelnt()));
		params.add(Utility.getName(po.getSopdefaramabu()));
		params.add(Utility.getName(po.getSopdefaramabuo()));
		params.add(Utility.getName(po.getSopdefaramalbu()));
		params.add(Utility.getName(po.getSopdefaramalbuo()));
		params.add(Utility.getName(po.getSopdefaramabd()));
		params.add(Utility.getName(po.getSopdefaramabdo()));
		params.add(Utility.getName(po.getSopdefaramalbd()));
		params.add(Utility.getName(po.getSopdefaramalbdo()));
		params.add(Utility.getName(po.getSopdedifwatch()));
		params.add(Utility.getName(po.getSopdeclosehetelevel()));
		params.add(Utility.getName(po.getSopdeclosehetelevelio()));
		params.add(Utility.getName(po.getSopdecloseheteuprightness()));
		params.add(Utility.getName(po.getSopdecloseheteuprightnessud()));
		params.add(Utility.getName(po.getSopdecloseamalevelp()));
		params.add(Utility.getName(po.getSopdecloseamalevelpo()));
		params.add(Utility.getName(po.getSopdecloseamalevelpt()));
		params.add(Utility.getName(po.getSopdecloseamaleveln()));
		params.add(Utility.getName(po.getSopdecloseamalevelno()));
		params.add(Utility.getName(po.getSopdecloseamalevelnt()));
		params.add(Utility.getName(po.getSopdecloseamabu()));
		params.add(Utility.getName(po.getSopdecloseamabuo()));
		params.add(Utility.getName(po.getSopdecloseamalbu()));
		params.add(Utility.getName(po.getSopdecloseamalbuo()));
		params.add(Utility.getName(po.getSopdecloseamabd()));
		params.add(Utility.getName(po.getSopdecloseamabdo()));
		params.add(Utility.getName(po.getSopdecloseamalbd()));
		params.add(Utility.getName(po.getSopdecloseamalbdo()));
		params.add(Utility.getName(po.getSopdenpc()));
		params.add(Utility.getName(po.getSopdeaccod()));
		params.add(Utility.getName(po.getSopdeaccos()));
		params.add(Utility.getName(po.getSopdeaccou()));
		params.add(Utility.getName(po.getSopdebcc()));
		params.add(Utility.getName(po.getSopdepositiveaccpra()));
		params.add(Utility.getName(po.getSopdenegativeaccnra()));
		params.add(Utility.getName(po.getSopdefacility()));
		params.add(Utility.getName(po.getSopdefacilityod()));
		params.add(Utility.getName(po.getSopdefacilityos()));
		params.add(Utility.getName(po.getSopdefacilityou()));
		params.add(Utility.getName(po.getSopdeaddod()));
		params.add(Utility.getName(po.getSopdeaddos()));
		params.add(Utility.getName(po.getSopdedistance()));
		params.add(Utility.getName(po.getSopderange()));
		params.add(Utility.getName(po.getSopderangeo()));
		params.add(Utility.getName(po.getSopdeaccount()));
		params.add(Utility.getName(po.getSopdechecker()));
		params.add(Utility.getName(po.getSopdeacaz()));
		params.add(Utility.getName(po.getSopdexieshi()));
		params.add(Utility.getName(po.getSopderuoshi()));
		params.add(Utility.getName(po.getSopdequguangbuzheng()));
		params.add(Utility.getName(po.getSopdefeixieshixingshuangyanshiyichang()));
		params.add(Utility.getName(po.getSopdekuangjiayanjing()));
		params.add(Utility.getName(po.getSopdeyinxingyanjing()));
		params.add(Utility.getName(po.getSopderuoshixunlian()));
		params.add(Utility.getName(po.getSopdetiaojiexunlian()));
		params.add(Utility.getName(po.getSopdefucouxunlian()));
		params.add(Utility.getName(po.getSopdeacaz1()));
		params.add(Utility.getName(po.getSopdeacaf1()));
		params.add(Utility.getName(po.getSopdecoverod()));
		params.add(Utility.getName(po.getSopdecoveros()));
		params.add(Utility.getName(po.getSopdesumdot()));
		params.add(Utility.getName(po.getSopdetestbig()));
		params.add(Utility.getName(po.getSopdetestbigio()));
		params.add(Utility.getName(po.getSopdetestsmall()));
		params.add(Utility.getName(po.getSopdetestsmallio()));
		params.add(Utility.getName(po.getSopdepositiveaccpraod()));
		params.add(Utility.getName(po.getSopdepositiveaccpraos()));
		params.add(Utility.getName(po.getSopdenegativeaccnraod()));
		params.add(Utility.getName(po.getSopdenegativeaccnraos()));
		params.add(Utility.getName(po.getSopdetwosidespec()));
		params.add(Utility.getName(po.getSopdetwosidetest()));
		params.add(Utility.getName(po.getSopdeequalwatch()));
		params.add(Utility.getName(po.getSopdeinspecteyefun()));		
		params.add(Utility.getName(po.getSopdebccou()));
		params.add(Utility.getName(po.getSopdebccod()));
		params.add(Utility.getName(po.getSopdebccos()));

		getJdbcTemplate().update(sb.toString(), params.toArray());

	}

	/**
	 * 修改双眼视功能检查
	 * 
	 * @param po
	 */
	public void updateDoubleEyeFun(DoubleEyeFunPo po) {

		StringBuffer sb = new StringBuffer();
		sb.append("update S_OP_DoubleEyeFunction set ");
		sb.append(" S_OP_DE_FarWorth = ? ");
		sb.append(",S_OP_DE_ACA = ? ");
		sb.append(",S_OP_DE_ACAWay= ? ");
		sb.append(",S_OP_DE_PDWay = ? ");
		sb.append(",S_OP_DE_NDWay = ? ");
		sb.append(",S_OP_DE_SolidWatch = ? ");
		sb.append(",S_OP_DE_FarHeteLevel = ? ");
		sb.append(",S_OP_DE_FarHeteLevelIO = ? ");
		sb.append(",S_OP_DE_FarHeteUprightness = ? ");
		sb.append(",S_OP_DE_FarHeteUprightnessUD = ? ");
		sb.append(",S_OP_DE_FarAmaLevelP  = ? ");
		sb.append(",S_OP_DE_FarAmaLevelPO = ? ");
		sb.append(",S_OP_DE_FarAmaLevelPT = ? ");
		sb.append(",S_OP_DE_FarAmaLevelN  = ? ");
		sb.append(",S_OP_DE_FarAmaLevelNO = ? ");
		sb.append(",S_OP_DE_FarAmaLevelNT = ? ");
		sb.append(",S_OP_DE_FarAmaBU  = ? ");
		sb.append(",S_OP_DE_FarAmaBUO = ? ");
		sb.append(",S_OP_DE_FarAmaLBU = ? ");
		sb.append(",S_OP_DE_FarAmaLBUO= ? ");
		sb.append(",S_OP_DE_FarAmaBD  = ? ");
		sb.append(",S_OP_DE_FarAmaBDO = ? ");
		sb.append(",S_OP_DE_FarAmaLBD = ? ");
		sb.append(",S_OP_DE_FarAmaLBDO= ? ");
		sb.append(",S_OP_DE_DifWatch  = ? ");
		sb.append(",S_OP_DE_CloseHeteLevel = ? ");
		sb.append(",S_OP_DE_CloseHeteLevelIO  = ? ");
		sb.append(",S_OP_DE_CloseHeteUprightness  = ? ");
		sb.append(",S_OP_DE_CloseHeteUprightnessUD= ? ");
		sb.append(",S_OP_DE_CloseAmaLevelP = ? ");
		sb.append(",S_OP_DE_CloseAmaLevelPO= ? ");
		sb.append(",S_OP_DE_CloseAmaLevelPT= ? ");
		sb.append(",S_OP_DE_CloseAmaLevelN = ? ");
		sb.append(",S_OP_DE_CloseAmaLevelNO= ? ");
		sb.append(",S_OP_DE_CloseAmaLevelNT= ? ");
		sb.append(",S_OP_DE_CloseAmaBU = ? ");
		sb.append(",S_OP_DE_CloseAmaBUO = ? ");
		sb.append(",S_OP_DE_CloseAmaLBU = ? ");
		sb.append(",S_OP_DE_CloseAmaLBUO= ? ");
		sb.append(",S_OP_DE_CloseAmaBD = ? ");
		sb.append(",S_OP_DE_CloseAmaBDO = ? ");
		sb.append(",S_OP_DE_CloseAmaLBD = ? ");
		sb.append(",S_OP_DE_CloseAmaLBDO= ? ");
		sb.append(",S_OP_DE_NPC = ? ");
		sb.append(",S_OP_DE_AccOD= ? ");
		sb.append(",S_OP_DE_AccOS= ? ");
		sb.append(",S_OP_DE_AccOU= ? ");
		sb.append(",S_OP_DE_BCC = ? ");
		sb.append(",S_OP_DE_PositiveAccPRA = ? ");
		sb.append(",S_OP_DE_NegativeAccNRA = ? ");
		sb.append(",S_OP_DE_Facility = ? ");
		sb.append(",S_OP_DE_FacilityOD  = ? ");
		sb.append(",S_OP_DE_FacilityOS  = ? ");
		sb.append(",S_OP_DE_FacilityOU  = ? ");
		sb.append(",S_OP_DE_AddOD = ? ");
		sb.append(",S_OP_DE_AddOS = ? ");
		sb.append(",S_OP_DE_Distance = ? ");
		sb.append(",S_OP_DE_Range = ? ");
		sb.append(",S_OP_DE_RangeO = ?,S_OP_DE_Account = ?,S_OP_DE_CheckDate=getdate(),S_OP_DE_Checker= ? ");
		sb.append(",S_OP_DE_Acaz = ?  "); //sxh 2011-5-20 新加10字段
		sb.append(",S_OP_DE_Xieshi = ?  ");
		sb.append(",S_OP_DE_Ruoshi = ?  ");
		sb.append(",S_OP_DE_Quguangbuzheng = ?  ");
		sb.append(",S_OP_DE_Feixieshixingshuangyanshiyichang = ?  ");
		sb.append(",S_OP_DE_Kuangjiayanjing = ?  ");
		sb.append(",S_OP_DE_Yinxingyanjing = ?  ");
		sb.append(",S_OP_DE_Ruoshixunlian = ?  ");
		sb.append(",S_OP_DE_Tiaojiexunlian = ?  ");
		sb.append(",S_OP_DE_Fucouxunlian = ? ");
		sb.append(",S_OP_DE_ACAz1 = ? ");
		sb.append(",S_OP_DE_ACAf1 = ? ");
		sb.append(",S_OP_DE_CoverOD              = ? ");
		sb.append(",S_OP_DE_CoverOS              = ? ");
		sb.append(",S_OP_DE_SumDot               = ? ");
		sb.append(",S_OP_DE_TestBig              = ? ");
		sb.append(",S_OP_DE_TestBigIO            = ? ");
		sb.append(",S_OP_DE_TestSmall            = ? ");
		sb.append(",S_OP_DE_TestSmallIO          = ? ");
		sb.append(",S_OP_DE_PositiveAccPRAOD     = ? ");
		sb.append(",S_OP_DE_PositiveAccPRAOS     = ? ");
		sb.append(",S_OP_DE_NegativeAccNRAOD     = ? ");
		sb.append(",S_OP_DE_NegativeAccNRAOS     = ? ");
		sb.append(",S_OP_DE_TwoSideSpec          = ? ");
		sb.append(",S_OP_DE_TwoSideTest          = ? ");
		sb.append(",S_OP_DE_EqualWatch           = ? ");
		sb.append(",S_OP_DE_InspectEyeFunFlag           = ? ");
		sb.append("where S_OP_DE_OPTOMETRYID =?  ");

		List<String> params = new ArrayList<String>();

		params.add(Utility.getName(po.getSopdefarworth()));
		params.add(Utility.getName(po.getSopdeaca()));
		params.add(Utility.getName(po.getSopdeacaway()));
		params.add(Utility.getName(po.getSopdepdway()));
		params.add(Utility.getName(po.getSopdendway()));
		params.add(Utility.getName(po.getSopdesolidwatch()));
		params.add(Utility.getName(po.getSopdefarhetelevel()));
		params.add(Utility.getName(po.getSopdefarhetelevelio()));
		params.add(Utility.getName(po.getSopdefarheteuprightness()));
		params.add(Utility.getName(po.getSopdefarheteuprightnessud()));
		params.add(Utility.getName(po.getSopdefaramalevelp()));
		params.add(Utility.getName(po.getSopdefaramalevelpo()));
		params.add(Utility.getName(po.getSopdefaramalevelpt()));
		params.add(Utility.getName(po.getSopdefaramaleveln()));
		params.add(Utility.getName(po.getSopdefaramalevelno()));
		params.add(Utility.getName(po.getSopdefaramalevelnt()));
		params.add(Utility.getName(po.getSopdefaramabu()));
		params.add(Utility.getName(po.getSopdefaramabuo()));
		params.add(Utility.getName(po.getSopdefaramalbu()));
		params.add(Utility.getName(po.getSopdefaramalbuo()));
		params.add(Utility.getName(po.getSopdefaramabd()));
		params.add(Utility.getName(po.getSopdefaramabdo()));
		params.add(Utility.getName(po.getSopdefaramalbd()));
		params.add(Utility.getName(po.getSopdefaramalbdo()));
		params.add(Utility.getName(po.getSopdedifwatch()));
		params.add(Utility.getName(po.getSopdeclosehetelevel()));
		params.add(Utility.getName(po.getSopdeclosehetelevelio()));
		params.add(Utility.getName(po.getSopdecloseheteuprightness()));
		params.add(Utility.getName(po.getSopdecloseheteuprightnessud()));
		params.add(Utility.getName(po.getSopdecloseamalevelp()));
		params.add(Utility.getName(po.getSopdecloseamalevelpo()));
		params.add(Utility.getName(po.getSopdecloseamalevelpt()));
		params.add(Utility.getName(po.getSopdecloseamaleveln()));
		params.add(Utility.getName(po.getSopdecloseamalevelno()));
		params.add(Utility.getName(po.getSopdecloseamalevelnt()));
		params.add(Utility.getName(po.getSopdecloseamabu()));
		params.add(Utility.getName(po.getSopdecloseamabuo()));
		params.add(Utility.getName(po.getSopdecloseamalbu()));
		params.add(Utility.getName(po.getSopdecloseamalbuo()));
		params.add(Utility.getName(po.getSopdecloseamabd()));
		params.add(Utility.getName(po.getSopdecloseamabdo()));
		params.add(Utility.getName(po.getSopdecloseamalbd()));
		params.add(Utility.getName(po.getSopdecloseamalbdo()));
		params.add(Utility.getName(po.getSopdenpc()));
		params.add(Utility.getName(po.getSopdeaccod()));
		params.add(Utility.getName(po.getSopdeaccos()));
		params.add(Utility.getName(po.getSopdeaccou()));
		params.add(Utility.getName(po.getSopdebcc()));
		params.add(Utility.getName(po.getSopdepositiveaccpra()));
		params.add(Utility.getName(po.getSopdenegativeaccnra()));
		params.add(Utility.getName(po.getSopdefacility()));
		params.add(Utility.getName(po.getSopdefacilityod()));
		params.add(Utility.getName(po.getSopdefacilityos()));
		params.add(Utility.getName(po.getSopdefacilityou()));
		params.add(Utility.getName(po.getSopdeaddod()));
		params.add(Utility.getName(po.getSopdeaddos()));
		params.add(Utility.getName(po.getSopdedistance()));
		params.add(Utility.getName(po.getSopderange()));
		params.add(Utility.getName(po.getSopderangeo()));
		params.add(Utility.getName(po.getSopdeaccount()));
		params.add(Utility.getName(po.getSopdechecker()));
		params.add(Utility.getName(po.getSopdeacaz()));
		params.add(Utility.getName(po.getSopdexieshi()));
		params.add(Utility.getName(po.getSopderuoshi()));
		params.add(Utility.getName(po.getSopdequguangbuzheng()));
		params.add(Utility.getName(po.getSopdefeixieshixingshuangyanshiyichang()));
		params.add(Utility.getName(po.getSopdekuangjiayanjing()));
		params.add(Utility.getName(po.getSopdeyinxingyanjing()));
		params.add(Utility.getName(po.getSopderuoshixunlian()));
		params.add(Utility.getName(po.getSopdetiaojiexunlian()));
		params.add(Utility.getName(po.getSopdefucouxunlian()));
		params.add(Utility.getName(po.getSopdeacaz1()));
		params.add(Utility.getName(po.getSopdeacaf1()));
		
		//2014-04-06 新加13个字段
		params.add(Utility.getName(po.getSopdecoverod()));
		params.add(Utility.getName(po.getSopdecoveros()));
		params.add(Utility.getName(po.getSopdesumdot()));
		params.add(Utility.getName(po.getSopdetestbig()));
		params.add(Utility.getName(po.getSopdetestbigio()));
		params.add(Utility.getName(po.getSopdetestsmall()));
		params.add(Utility.getName(po.getSopdetestsmallio()));
		params.add(Utility.getName(po.getSopdepositiveaccpraod()));
		params.add(Utility.getName(po.getSopdepositiveaccpraos()));
		params.add(Utility.getName(po.getSopdenegativeaccnraod()));
		params.add(Utility.getName(po.getSopdenegativeaccnraos()));
		params.add(Utility.getName(po.getSopdetwosidespec()));
		params.add(Utility.getName(po.getSopdetwosidetest()));
		params.add(Utility.getName(po.getSopdeequalwatch()));
		params.add(Utility.getName(po.getSopdeinspecteyefun()));
		
		params.add(Utility.getName(po.getSopdeoptometryid()));

		getJdbcTemplate().update(sb.toString(), params.toArray());

	}

	/**
	 * 更新验光基表
	 * 
	 * @param optometryBasicPo
	 */
	public void updateOptometryBasic(OptometryBasicPo po) {
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("update S_OP_OptometryBasic set ");
		sb.append("S_OP_OB_MedicalEndTime = getdate() ");
		sb.append("where S_OP_OB_OptometryBasicID = ? ");

		params.add(po.getSopoboptometrybasicid());

		getJdbcTemplate().update(sb.toString(), params.toArray());

	}

	/**
	 * 更新验光表
	 * 
	 * @param optometryPo
	 */
	public void updateOptometry(OptometryPo po) {

		StringBuffer sb = new StringBuffer();
		sb.append("update S_OP_Optometry set");
		sb.append(" S_OP_OY_RecipeUpdateTime= getdate() ");
		sb.append(",S_OP_OY_Updateuserid    = ? ");
		sb.append("where S_OP_OY_OptometryID = ? ");

		List<String> params = new ArrayList<String>();

		params.add(po.getSopoyupdateuserid());
		params.add(po.getSopoyoptometryid());

		getJdbcTemplate().update(sb.toString(), params.toArray());
	}

	public int getDoubleEyeFunCount(OptometryPo optometryPo) {

		StringBuffer sb = new StringBuffer();
		sb.append("select count(S_OP_DE_OptometryID) from S_OP_DoubleEyeFunction where S_OP_DE_OptometryID=?");

		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(optometryPo.getSopoyoptometryid()));
		return getJdbcTemplate().queryForInt(sb.toString(), params.toArray());
	}
}
