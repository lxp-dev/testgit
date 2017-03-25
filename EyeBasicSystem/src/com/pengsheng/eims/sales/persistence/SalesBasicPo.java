package com.pengsheng.eims.sales.persistence;

import java.util.Arrays;
import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;

public class SalesBasicPo {
	
	private String ssesbsalesid;				// 销售单号
	private String ssesbshopcode;				// 店号
	private String ssesbcustomerid;				// 顾客号
	private String ssesboptid;					// 验光号-验光基表
	private String ssesboptometryid;			// 检查结论id
	private String ssesbtakeglassdata;			// 取镜日期
	private String ssesbsalesdatetime;			// 销售日期
	private String ssesborderstype;				// 订单类型: 1-镜架成品片 2-镜架订做片 3-隐形成品片 4-隐形订做片 5-辅料
	private String ssesbballglassod;			// 右眼球镜
	private String ssesbballglassos;			// 左眼球镜
	private String ssesbpostglassod;			// 右眼柱镜
	private String ssesbpostglassos;			// 左眼柱镜
	private String ssesbaxesod;					// 右眼轴向
	private String ssesbaxesos;					// 左眼轴向
	private String ssesbaddod;					// 右眼add
	private String ssesbaddos;					// 左眼add
	private String ssesbarriseglassod;			// 右眼三棱镜
	private String ssesbarriseglassos;			// 左眼三棱镜
	private String ssesbbasisod;				// 右眼基底
	private String ssesbbasisos;				// 左眼基底
	private String ssesbprismod;				// 右眼棱镜
	private String ssesbprismos;				// 左眼棱镜
	private String ssesbinterhighod;			// 右眼远用瞳距
	private String ssesbinterhighos;			// 左眼远用瞳距
	private String ssesbinterdistanceod;		// 右眼近用瞳距
	private String ssesbinterdistanceos;		// 左眼近用瞳距
	private String ssesbfarvaod;				// 右眼远用va
	private String ssesbfarvaos;				// 左眼远用va
	private String ssesbclosevaod;				// 右眼近用va
	private String ssesbclosevaos;				// 左眼近用va
	private String ssesbcommendglasses;			// 适用镜片
	private String ssesbglassmaterial;			// 建议镜片材质
	private String ssesbrecipetype;				// 处方形式 1-远用 2-近用 3-渐进/双光 4-隐形
	private String ssesbdisposemanner;			// 处理方式
	private String ssesbdignosisre;				// 处方备注
	private String ssesbeyecurvatureod1;		// 隐形右眼曲率1
	private String ssesbeyecurvatureod2;		// 隐形右眼曲率2
	private String ssesbeyecurvatureos1;		// 隐形左眼曲率1
	private String ssesbeyecurvatureos2;		// 隐形左眼曲率2
	private String ssesbdiameterod;				// 隐形右眼直径
	private String ssesbdiameteros;				// 隐形左眼直径
	private String ssesbconlenvaod;				// 隐形右眼va
	private String ssesbconlenvaos;				// 隐形左眼va
	private String ssesbpupilheightod;			// 右眼瞳高
	private String ssesbpupilheightos;			// 右眼瞳高
	private String ssesbconrecipetype;			// 隐形处理方式
	private String ssesbseccheckdate;			// 复诊时间
	private String ssesbsubvisitunit;			// 复诊时间单位
	private String ssesbsalestype;				// 销售类型
	private String ssesbsalerid;				// 销售人员id
	private String ssesbyishiid;				// 医师id（哈医大四院）	
	private String ssesblryid;					// 录入员id
	private String ssesbposdatetime;			// 账面收银日期
	private String ssesbposid;					// 收银员id
	private String ssesbpricesum;				// 原价合计
	private String ssesbsalesvalue;				// 应收金额
	private String ssesbdiscountrate;			// 折扣率
	private String ssesbdiscountnum;			// 折扣金额
	private String ssesbpsalsvalue;				// 实缴金额
	private String ssesbarrearsvalue;			// 欠款金额
	private String ssesblocation;				// 取镜地点(门店编号)
	private String ssesbarriveddate;			// 到镜日期
	private String ssesbvalueflag;				// 收费标志(1-已收费，0-未收费)
	private String ssesbcheckoutflag;			// 欠费标志(1-欠费，0-未欠费)
	private String ssesbintransit;				// 配送标识 0：未配送(销售默认未配送)，1：已打印配送
	private String ssesbchooseflag;				// 销售类型（1-镜架成品 2-镜架订做 3-隐形成品 4-隐形订做）
	private String ssesbwithdrawdate;			// 账面退费日期
	private String ssesbwithdrawflag;			// 退费标示位
	private String ssesbwithdrawpersonid;		// 退费人员
	private String ssesbmovementtype;			// 活动类型id
	private String ssesbsupplierid;				// 制造商id
	private String ssesbsalesdatestarttime;		// 销售start日期
	private String ssesbsalesdateendtime;		// 销售end日期
	private String ssesbtakeglassstartdata;		// 取镜start日期
	private String ssesbtakeglassenddata;		// 取镜end日期
	private String posdatestarttime;		// 取镜start日期
	private String posdateendtime;		// 取镜end日期
	private String outpricestrattime;   //退款start时间
	private String outpriceendtime;     //退款end时间
	private String ssesbjfamount;		//整单总积分
	private String ssesbsalesremark;			// 销售备注	
	private String ssesbpersonName; 			// 顾客姓名
	private String ssesbphone; 					// 顾客电话
	private String ssesbaddress; 				// 顾客地址
	private String ssesbshopName; 				// 销售店名
	private String ssesbsalerName; 				// 销售人员
	private String ssesbMemberId; 				//会员卡号
	private String ssesbposName;				//收银员姓名
	private String ssesbdepartmenttype;			//门店类型
	private String ssesbdepartmentid;			//区域id
	private String ssesbmaterialsperson;		//发料人姓名
	private String ssesbmaterialsdate;			//发料时间
	private String ssesblightvertical;			//光心垂差
	private String ssesbgoodsname;				//商品名称
	private String ssesbtakeshopname;			//取镜门店名
	private String ssesbismutiluminosity;		//1、单光多光2、渐进
	private String ssesbsuppliername;			//制造商名称
	private String ssesbbrandid; 				//品种id
	private String ssesbbrandname; 				//品种名称
	private String ssesbdepid;					//判断登录是门店、加工、仓储、避免和Shopcode重复
	private String ssesbdragstype;				//委外类型
	private String ssesbpaycash;
	private String ssesbbankcard;
	private String ssesbstoredcard;
	private String chuzhikaid;
	private String ssesbrenums;
	private String isMail;						//是否邮寄
	private String ssesbopdatetime;				//验光时间	
	private String ssesbfavorableamount;		//优惠金额
	private String ssesbopsource;				//处方来源
	private String ssesbworrytype;				//加急状态	
	private String ssesbsetmealid;				//套餐ID
	private String ssesbintegral;				//总积分
	private String ssesbintegralprice;		    //积分金额
	private String ssesbexecstandard;			//执行标准
	private String ssesbisgiveyouintegral;		//执行标准
	private String[] ssesborderstypes;			//单据类型复选款数组  门店配送查询条件中使用
	private String ssesbintransittype;			//在途查询状态筛选条件  1、等于  2、大于  3、小于  4、大于等于  5、小于等于
	private String ssesbintransit2;
	private String ssesbintransittype2;
	private String ssesbupdateguitartype;		//系统参数中限制更改结款方式天数
	private String ssesbsourcesalesid;
	private String ssesbswapgoodsflag;
	private String ssesbprocessdepartment;
	private String ssesbprocessdepartmentname;
	private String inintrgral;
	private String nowintegral;
	private String integraldate;
	private String integraltype;
	private String ssesbdiscounttype;
	private String ssesbdiscountperson;
	private List<SalesDetailPo> salesDetails;//销售结帐明细表(新加)	
	private String ssesbinspectionid;
	private String ssesbshopcodewarehouseid;
	private String ssesbsetmealtitle;				//套餐ID主题名称
	private String ssesbsetmealtype;				//套餐ID分类
	private String ssesbusesetmealflag;				//套餐ID分类
	private String ssesbprocessdpt;					//加工中心
	private String ssesbprintsmflag;				//打印发料单标识
	private String ssesbsalestelphone;
	private String ssesbtaketelphone;
	private String ssesbfcustomerid;				//顾客卡の主卡
	private String ssesbfmemberId;					//顾客卡の主卡
	private String ssesbfcustomername;				//顾客卡の主卡
	/**
	 * 更改结款方式新添字段
	 */
	private String sseslpaymenttype;
	private String sseslpaymenttypename;
	private String sseslprice;
	private String ssesldatetime;	
	private String ssesboldeyesize;
	private String ssesbglasshige;
	private String ssesbglasswigth;
	private String ssesbframemiddlesize;
	private String ssesbgalssroad;
	private String ssesbdiagonalline;
	private String ssesbframeform;
	private String ssesbframedia;   // 手动填写   直径
	private String ssesbhandlestate; //已处理投诉总数
	private String ssesbunhandlestate;  // 未处理投诉总数
	private String ssesbhandlestatecount;  // 投诉总数	
	private String ssesbconsumptionid;
	private String ssesbsourceid;
	private String ssesbdueintegral;		//应得积分
	private String remark;
	private String ssesbprintserialnumber;  // 打印发料单中的流水号
	private String ssesborderby;  // 打印发料单中的查询方式	
	private String year;
	private String month;
	private String month1;
	private String nowmonth;
	private String ssesbgoodslevel;
	private String ssesbreturnbillflag;   // 下委外订单后的配镜单能否有权限可以退款	
	private String ssesbspectaclesmaterialsdpt;   // 发料部门
	private String ssesbadditionPrice;   // 附加费用金额
	private String ssesbintransitfinished;   // 是否完结
	private String ssesbhardvalueversion;	    //	加工难度系数版本
	private String djsbm;   // 单据识别码
	private String ssesbdistributionid;				// 配送单号
	private String ssesbqueryclassif;				// 按配镜单查看   按商品明细查看   	
	private String ssesbgoodsbarcode;				// 商品条码
	private String ssesbglassflag;				// 左右眼标识
	private String ssesbgoodsnum;				// 商品数量
	private String ssesbsph;				// 球镜
	private String ssesbcyl;				// 柱镜
	private String ssesbaxs;				// 轴向
	private String ssesbadditionname;   // 附加费用名称
	private String ssesbdoublezz;   // 双自片标识	
	private String ssesbgoodsvalue;   // 商品价格

	/**
	 * 委外配送
	 */
	private String ssesbfaliaodtpid;   // 所属加工区域id
	private String ssesbfaliaodtpname;   // 所属加工区域名称
	private String ssesbshouhuodate;   // 委外收货日期
	private String ssesbshouhuoren;   // 委外收货人	
	private String ssesbinwarehouseid;   // 委外收货仓位	
	private String ssesbinwarehousename;   // 委外收货仓位名称
	private String ssesbfaliaostockid;   // 所属加工区域默认的加工仓位
	private String ssesbordertype;   // 配镜单查询排序方式
	
	/**
	 * 修改时英
	 */
	private String ssesbygsid;   // 验光师ID
	private List<DepartmentsPo> smecishoplist; // 相同公司的部门
	
	private String ssesbfactposdatetime;			// 实际收银日期
	private String ssesbfactwithdrawdate;			// 实际退费日期
	private String ssesbsalescount;					// 消费次数
	private String ssesbcompanyid;                  // 所属公司
	private String ssesbweixintype;					// 判断操作是否为微信类型（目前为退款使用）
	
	private String ssesbhisflag;                  // 是否已提交收费项目
	private String ssesbhiscancelflag;            // 是否已作废
	private String ssesbnothisflag;               // 是否已传递
	private String ssesbhispayflag;               // HIS中   已收费    已退费
	private String ssesbhissaleid;                 // 向HIS传递的配镜单主键
	
	public String getSsesbhispayflag() {
		return ssesbhispayflag;
	}
	public void setSsesbhispayflag(String ssesbhispayflag) {
		this.ssesbhispayflag = ssesbhispayflag;
	}
	public String getSsesbnothisflag() {
		return ssesbnothisflag;
	}
	public void setSsesbnothisflag(String ssesbnothisflag) {
		this.ssesbnothisflag = ssesbnothisflag;
	}
	public String getSsesbhiscancelflag() {
		return ssesbhiscancelflag;
	}
	public void setSsesbhiscancelflag(String ssesbhiscancelflag) {
		this.ssesbhiscancelflag = ssesbhiscancelflag;
	}
	public String getSsesbhisflag() {
		return ssesbhisflag;
	}
	public void setSsesbhisflag(String ssesbhisflag) {
		this.ssesbhisflag = ssesbhisflag;
	}
	public String getSsesbcompanyid() {
		return ssesbcompanyid;
	}
	public void setSsesbcompanyid(String ssesbcompanyid) {
		this.ssesbcompanyid = ssesbcompanyid;
	}	
	public String getSsesbweixintype() {
		return ssesbweixintype;
	}
	public void setSsesbweixintype(String ssesbweixintype) {
		this.ssesbweixintype = ssesbweixintype;
	}

	public String getSsesbsalescount() {
		return ssesbsalescount;
	}
	public void setSsesbsalescount(String ssesbsalescount) {
		this.ssesbsalescount = ssesbsalescount;
	}
	public String getSsesbfactposdatetime() {
		return ssesbfactposdatetime;
	}
	public void setSsesbfactposdatetime(String ssesbfactposdatetime) {
		this.ssesbfactposdatetime = ssesbfactposdatetime;
	}
	public String getSsesbfactwithdrawdate() {
		return ssesbfactwithdrawdate;
	}
	public void setSsesbfactwithdrawdate(String ssesbfactwithdrawdate) {
		this.ssesbfactwithdrawdate = ssesbfactwithdrawdate;
	}
	public List<DepartmentsPo> getSmecishoplist() {
		return smecishoplist;
	}
	public void setSmecishoplist(List<DepartmentsPo> smecishoplist) {
		this.smecishoplist = smecishoplist;
	}
	public String getSsesbygsid() {
		return ssesbygsid;
	}
	public void setSsesbygsid(String ssesbygsid) {
		this.ssesbygsid = ssesbygsid;
	}
	public String getSsesbordertype() {
		return ssesbordertype;
	}
	public void setSsesbordertype(String ssesbordertype) {
		this.ssesbordertype = ssesbordertype;
	}
	public String getSsesbinwarehousename() {
		return ssesbinwarehousename;
	}
	public void setSsesbinwarehousename(String ssesbinwarehousename) {
		this.ssesbinwarehousename = ssesbinwarehousename;
	}
	public String getSsesbfaliaostockid() {
		return ssesbfaliaostockid;
	}
	public void setSsesbfaliaostockid(String ssesbfaliaostockid) {
		this.ssesbfaliaostockid = ssesbfaliaostockid;
	}
	public String getSsesbinwarehouseid() {
		return ssesbinwarehouseid;
	}
	public void setSsesbinwarehouseid(String ssesbinwarehouseid) {
		this.ssesbinwarehouseid = ssesbinwarehouseid;
	}
	public String getSsesbfaliaodtpid() {
		return ssesbfaliaodtpid;
	}
	public void setSsesbfaliaodtpid(String ssesbfaliaodtpid) {
		this.ssesbfaliaodtpid = ssesbfaliaodtpid;
	}
	public String getSsesbfaliaodtpname() {
		return ssesbfaliaodtpname;
	}
	public void setSsesbfaliaodtpname(String ssesbfaliaodtpname) {
		this.ssesbfaliaodtpname = ssesbfaliaodtpname;
	}
	public String getSsesbshouhuodate() {
		return ssesbshouhuodate;
	}
	public void setSsesbshouhuodate(String ssesbshouhuodate) {
		this.ssesbshouhuodate = ssesbshouhuodate;
	}
	public String getSsesbshouhuoren() {
		return ssesbshouhuoren;
	}
	public void setSsesbshouhuoren(String ssesbshouhuoren) {
		this.ssesbshouhuoren = ssesbshouhuoren;
	}
	public String getSsesbgoodsvalue() {
		return ssesbgoodsvalue;
	}
	public void setSsesbgoodsvalue(String ssesbgoodsvalue) {
		this.ssesbgoodsvalue = ssesbgoodsvalue;
	}
	public String getSsesbdoublezz() {
		return ssesbdoublezz;
	}
	public void setSsesbdoublezz(String ssesbdoublezz) {
		this.ssesbdoublezz = ssesbdoublezz;
	}
	public String getSsesbadditionname() {
		return ssesbadditionname;
	}
	public void setSsesbadditionname(String ssesbadditionname) {
		this.ssesbadditionname = ssesbadditionname;
	}
	public String getSsesbgoodsbarcode() {
		return ssesbgoodsbarcode;
	}
	public void setSsesbgoodsbarcode(String ssesbgoodsbarcode) {
		this.ssesbgoodsbarcode = ssesbgoodsbarcode;
	}
	public String getSsesbglassflag() {
		return ssesbglassflag;
	}
	public void setSsesbglassflag(String ssesbglassflag) {
		this.ssesbglassflag = ssesbglassflag;
	}
	public String getSsesbgoodsnum() {
		return ssesbgoodsnum;
	}
	public void setSsesbgoodsnum(String ssesbgoodsnum) {
		this.ssesbgoodsnum = ssesbgoodsnum;
	}
	public String getSsesbsph() {
		return ssesbsph;
	}
	public void setSsesbsph(String ssesbsph) {
		this.ssesbsph = ssesbsph;
	}
	public String getSsesbcyl() {
		return ssesbcyl;
	}
	public void setSsesbcyl(String ssesbcyl) {
		this.ssesbcyl = ssesbcyl;
	}
	public String getSsesbaxs() {
		return ssesbaxs;
	}
	public void setSsesbaxs(String ssesbaxs) {
		this.ssesbaxs = ssesbaxs;
	}
	public String getSsesbqueryclassif() {
		return ssesbqueryclassif;
	}
	public void setSsesbqueryclassif(String ssesbqueryclassif) {
		this.ssesbqueryclassif = ssesbqueryclassif;
	}
	public String getSsesbdistributionid() {
		return ssesbdistributionid;
	}
	public void setSsesbdistributionid(String ssesbdistributionid) {
		this.ssesbdistributionid = ssesbdistributionid;
	}
	public String getSsesbhardvalueversion() {
		return ssesbhardvalueversion;
	}
	public void setSsesbhardvalueversion(String ssesbhardvalueversion) {
		this.ssesbhardvalueversion = ssesbhardvalueversion;
	}
	public String getSsesbintransitfinished() {
		return ssesbintransitfinished;
	}
	public void setSsesbintransitfinished(String ssesbintransitfinished) {
		this.ssesbintransitfinished = ssesbintransitfinished;
	}
	public String getDjsbm() {
		return djsbm;
	}
	public void setDjsbm(String djsbm) {
		this.djsbm = djsbm;
	}

	public String getSsesbadditionPrice() {
		return ssesbadditionPrice;
	}
	public void setSsesbadditionPrice(String ssesbadditionPrice) {
		this.ssesbadditionPrice = ssesbadditionPrice;
	}
	public String getSsesbframedia() {
		return ssesbframedia;
	}
	public void setSsesbframedia(String ssesbframedia) {
		this.ssesbframedia = ssesbframedia;
	}
	public String getSsesbfmemberId() {
		return ssesbfmemberId;
	}
	public void setSsesbfmemberId(String ssesbfmemberId) {
		this.ssesbfmemberId = ssesbfmemberId;
	}
	public String getSsesbfcustomername() {
		return ssesbfcustomername;
	}
	public void setSsesbfcustomername(String ssesbfcustomername) {
		this.ssesbfcustomername = ssesbfcustomername;
	}
	public String getSsesbfcustomerid() {
		return ssesbfcustomerid;
	}
	public void setSsesbfcustomerid(String ssesbfcustomerid) {
		this.ssesbfcustomerid = ssesbfcustomerid;
	}
	public String getSsesbspectaclesmaterialsdpt() {
		return ssesbspectaclesmaterialsdpt;
	}
	public void setSsesbspectaclesmaterialsdpt(String ssesbspectaclesmaterialsdpt) {
		this.ssesbspectaclesmaterialsdpt = ssesbspectaclesmaterialsdpt;
	}
	public String getSsesbreturnbillflag() {
		return ssesbreturnbillflag;
	}
	public void setSsesbreturnbillflag(String ssesbreturnbillflag) {
		this.ssesbreturnbillflag = ssesbreturnbillflag;
	}
	public String getSsesbgoodslevel() {
		return ssesbgoodslevel;
	}
	public void setSsesbgoodslevel(String ssesbgoodslevel) {
		this.ssesbgoodslevel = ssesbgoodslevel;
	}
	public String getMonth1() {
		return month1;
	}
	public void setMonth1(String month1) {
		this.month1 = month1;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getNowmonth() {
		return nowmonth;
	}
	public void setNowmonth(String nowmonth) {
		this.nowmonth = nowmonth;
	}
	public String getSsesborderby() {
		return ssesborderby;
	}
	public void setSsesborderby(String ssesborderby) {
		this.ssesborderby = ssesborderby;
	}
	public String getSsesbprintserialnumber() {
		return ssesbprintserialnumber;
	}
	public void setSsesbprintserialnumber(String ssesbprintserialnumber) {
		this.ssesbprintserialnumber = ssesbprintserialnumber;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getChuzhikaid() {
		return chuzhikaid;
	}
	public void setChuzhikaid(String chuzhikaid) {
		this.chuzhikaid = chuzhikaid;
	}
	public String getSsesbdueintegral() {
		return ssesbdueintegral;
	}
	public void setSsesbdueintegral(String ssesbdueintegral) {
		this.ssesbdueintegral = ssesbdueintegral;
	}
	public String getSsesbconsumptionid() {
		return ssesbconsumptionid;
	}
	public void setSsesbconsumptionid(String ssesbconsumptionid) {
		this.ssesbconsumptionid = ssesbconsumptionid;
	}
	public String getSsesbsourceid() {
		return ssesbsourceid;
	}
	public void setSsesbsourceid(String ssesbsourceid) {
		this.ssesbsourceid = ssesbsourceid;
	}
	public String getSsesbhandlestatecount() {
		return ssesbhandlestatecount;
	}
	public void setSsesbhandlestatecount(String ssesbhandlestatecount) {
		this.ssesbhandlestatecount = ssesbhandlestatecount;
	}
	public String getSsesbunhandlestate() {
		return ssesbunhandlestate;
	}
	public void setSsesbunhandlestate(String ssesbunhandlestate) {
		this.ssesbunhandlestate = ssesbunhandlestate;
	}
	public String getSsesbhandlestate() {
		return ssesbhandlestate;
	}
	public void setSsesbhandlestate(String ssesbhandlestate) {
		this.ssesbhandlestate = ssesbhandlestate;
	}
	public String getSsesboldeyesize() {
		return ssesboldeyesize;
	}
	public void setSsesboldeyesize(String ssesboldeyesize) {
		this.ssesboldeyesize = ssesboldeyesize;
	}
	public String getSsesbglasshige() {
		return ssesbglasshige;
	}
	public void setSsesbglasshige(String ssesbglasshige) {
		this.ssesbglasshige = ssesbglasshige;
	}
	public String getSsesbglasswigth() {
		return ssesbglasswigth;
	}
	public void setSsesbglasswigth(String ssesbglasswigth) {
		this.ssesbglasswigth = ssesbglasswigth;
	}
	public String getSsesbframemiddlesize() {
		return ssesbframemiddlesize;
	}
	public void setSsesbframemiddlesize(String ssesbframemiddlesize) {
		this.ssesbframemiddlesize = ssesbframemiddlesize;
	}
	public String getSsesbgalssroad() {
		return ssesbgalssroad;
	}
	public void setSsesbgalssroad(String ssesbgalssroad) {
		this.ssesbgalssroad = ssesbgalssroad;
	}
	public String getSsesbdiagonalline() {
		return ssesbdiagonalline;
	}
	public void setSsesbdiagonalline(String ssesbdiagonalline) {
		this.ssesbdiagonalline = ssesbdiagonalline;
	}
	public String getSsesbframeform() {
		return ssesbframeform;
	}
	public void setSsesbframeform(String ssesbframeform) {
		this.ssesbframeform = ssesbframeform;
	}
	public String getSsesbjfamount() {
		return ssesbjfamount;
	}
	public void setSsesbjfamount(String ssesbjfamount) {
		this.ssesbjfamount = ssesbjfamount;
	}
	public String getOutpricestrattime() {
		return outpricestrattime;
	}
	public void setOutpricestrattime(String outpricestrattime) {
		this.outpricestrattime = outpricestrattime;
	}
	public String getOutpriceendtime() {
		return outpriceendtime;
	}
	public void setOutpriceendtime(String outpriceendtime) {
		this.outpriceendtime = outpriceendtime;
	}
	
	public String getSsesbprintsmflag() {
		return ssesbprintsmflag;
	}
	public void setSsesbprintsmflag(String ssesbprintsmflag) {
		this.ssesbprintsmflag = ssesbprintsmflag;
	}
	public String getSsesbprocessdpt() {
		return ssesbprocessdpt;
	}
	public void setSsesbprocessdpt(String ssesbprocessdpt) {
		this.ssesbprocessdpt = ssesbprocessdpt;
	}
	public String getSsesbsalestelphone() {
		return ssesbsalestelphone;
	}
	public void setSsesbsalestelphone(String ssesbsalestelphone) {
		this.ssesbsalestelphone = ssesbsalestelphone;
	}
	public String getSsesbtaketelphone() {
		return ssesbtaketelphone;
	}
	public void setSsesbtaketelphone(String ssesbtaketelphone) {
		this.ssesbtaketelphone = ssesbtaketelphone;
	}
	public String getSsesbusesetmealflag() {
		return ssesbusesetmealflag;
	}
	public void setSsesbusesetmealflag(String ssesbusesetmealflag) {
		this.ssesbusesetmealflag = ssesbusesetmealflag;
	}
	public String getSsesbsetmealtype() {
		return ssesbsetmealtype;
	}
	public void setSsesbsetmealtype(String ssesbsetmealtype) {
		this.ssesbsetmealtype = ssesbsetmealtype;
	}
	public String getSsesbsetmealtitle() {
		return ssesbsetmealtitle;
	}
	public void setSsesbsetmealtitle(String ssesbsetmealtitle) {
		this.ssesbsetmealtitle = ssesbsetmealtitle;
	}

	public String getSsesldatetime() {
		return ssesldatetime;
	}
	public void setSsesldatetime(String ssesldatetime) {
		this.ssesldatetime = ssesldatetime;
	}
	public String getSseslpaymenttype() {
		return sseslpaymenttype;
	}
	public void setSseslpaymenttype(String sseslpaymenttype) {
		this.sseslpaymenttype = sseslpaymenttype;
	}
	public String getSseslpaymenttypename() {
		return sseslpaymenttypename;
	}
	public void setSseslpaymenttypename(String sseslpaymenttypename) {
		this.sseslpaymenttypename = sseslpaymenttypename;
	}
	public String getSseslprice() {
		return sseslprice;
	}
	public void setSseslprice(String sseslprice) {
		this.sseslprice = sseslprice;
	}
	public String getSsesbshopcodewarehouseid() {
		return ssesbshopcodewarehouseid;
	}
	public void setSsesbshopcodewarehouseid(String ssesbshopcodewarehouseid) {
		this.ssesbshopcodewarehouseid = ssesbshopcodewarehouseid;
	}
	public String getSsesbprocessdepartmentname() {
		return ssesbprocessdepartmentname;
	}
	public void setSsesbprocessdepartmentname(String ssesbprocessdepartmentname) {
		this.ssesbprocessdepartmentname = ssesbprocessdepartmentname;
	}
	public String getSsesbprocessdepartment() {
		return ssesbprocessdepartment;
	}
	public void setSsesbprocessdepartment(String ssesbprocessdepartment) {
		this.ssesbprocessdepartment = ssesbprocessdepartment;
	}
	public String getPosdatestarttime() {
		return posdatestarttime;
	}
	public void setPosdatestarttime(String posdatestarttime) {
		this.posdatestarttime = posdatestarttime;
	}
	public String getPosdateendtime() {
		return posdateendtime;
	}
	public void setPosdateendtime(String posdateendtime) {
		this.posdateendtime = posdateendtime;
	}
	public String getSsesbsourcesalesid() {
		return ssesbsourcesalesid;
	}
	public void setSsesbsourcesalesid(String ssesbsourcesalesid) {
		this.ssesbsourcesalesid = ssesbsourcesalesid;
	}
	public String getSsesbswapgoodsflag() {
		return ssesbswapgoodsflag;
	}
	public void setSsesbswapgoodsflag(String ssesbswapgoodsflag) {
		this.ssesbswapgoodsflag = ssesbswapgoodsflag;
	}
	public String getSsesbintegralprice() {
		return ssesbintegralprice;
	}
	public void setSsesbintegralprice(String ssesbintegralprice) {
		this.ssesbintegralprice = ssesbintegralprice;
	}
	public String getSsesbupdateguitartype() {
		return ssesbupdateguitartype;
	}
	public void setSsesbupdateguitartype(String ssesbupdateguitartype) {
		this.ssesbupdateguitartype = ssesbupdateguitartype;
	}
	public String getSsesbintransittype2() {
		return ssesbintransittype2;
	}
	public void setSsesbintransittype2(String ssesbintransittype2) {
		this.ssesbintransittype2 = ssesbintransittype2;
	}
	public String getSsesbintransit2() {
		return ssesbintransit2;
	}
	public void setSsesbintransit2(String ssesbintransit2) {
		this.ssesbintransit2 = ssesbintransit2;
	}
	public String getSsesbintransittype() {
		return ssesbintransittype;
	}
	public void setSsesbintransittype(String ssesbintransittype) {
		this.ssesbintransittype = ssesbintransittype;
	}
	public String[] getSsesborderstypes() {
		return ssesborderstypes;
	}
	public void setSsesborderstypes(String[] ssesborderstypes) {
		this.ssesborderstypes = ssesborderstypes;
	}
	public String getSsesbisgiveyouintegral() {
		return ssesbisgiveyouintegral;
	}
	public void setSsesbisgiveyouintegral(String ssesbisgiveyouintegral) {
		this.ssesbisgiveyouintegral = ssesbisgiveyouintegral;
	}
	public String getSsesbexecstandard() {
		return ssesbexecstandard;
	}
	public void setSsesbexecstandard(String ssesbexecstandard) {
		this.ssesbexecstandard = ssesbexecstandard;
	}
	public String getSsesbsetmealid() {
		return ssesbsetmealid;
	}
	public void setSsesbsetmealid(String ssesbsetmealid) {
		this.ssesbsetmealid = ssesbsetmealid;
	}
	public String getSsesbintegral() {
		return ssesbintegral;
	}
	public void setSsesbintegral(String ssesbintegral) {
		this.ssesbintegral = ssesbintegral;
	}	
	public String getInintrgral() {
		return inintrgral;
	}
	public void setInintrgral(String inintrgral) {
		this.inintrgral = inintrgral;
	}
	public String getNowintegral() {
		return nowintegral;
	}
	public void setNowintegral(String nowintegral) {
		this.nowintegral = nowintegral;
	}
	public String getIntegraldate() {
		return integraldate;
	}
	public void setIntegraldate(String integraldate) {
		this.integraldate = integraldate;
	}
	public String getIntegraltype() {
		return integraltype;
	}
	public void setIntegraltype(String integraltype) {
		this.integraltype = integraltype;
	}
	public String getSsesbopdatetime() {
		return ssesbopdatetime;
	}
	public void setSsesbopdatetime(String ssesbopdatetime) {
		this.ssesbopdatetime = ssesbopdatetime;
	}
	public String getSsesbworrytype() {
		return ssesbworrytype;
	}
	public void setSsesbworrytype(String ssesbworrytype) {
		this.ssesbworrytype = ssesbworrytype;
	}
	public String getSsesbopsource() {
		return ssesbopsource;
	}
	public void setSsesbopsource(String ssesbopsource) {
		this.ssesbopsource = ssesbopsource;
	}
	public String getSsesbfavorableamount() {
		return ssesbfavorableamount;
	}
	public void setSsesbfavorableamount(String ssesbfavorableamount) {
		this.ssesbfavorableamount = ssesbfavorableamount;
	}
	public String getSsesbpupilheightod() {
		return ssesbpupilheightod;
	}
	public void setSsesbpupilheightod(String ssesbpupilheightod) {
		this.ssesbpupilheightod = ssesbpupilheightod;
	}
	public String getSsesbpupilheightos() {
		return ssesbpupilheightos;
	}
	public void setSsesbpupilheightos(String ssesbpupilheightos) {
		this.ssesbpupilheightos = ssesbpupilheightos;
	}
	public String getSsesbsalesremark() {
		return ssesbsalesremark;
	}
	public void setSsesbsalesremark(String ssesbsalesremark) {
		this.ssesbsalesremark = ssesbsalesremark;
	}
	public String getIsMail() {
		return isMail;
	}
	public void setIsMail(String isMail) {
		this.isMail = isMail;
	}
	public String getSsesbrenums() {
		return ssesbrenums;
	}
	public void setSsesbrenums(String ssesbrenums) {
		this.ssesbrenums = ssesbrenums;
	}
	public String getSsesbdiscounttype() {
		return ssesbdiscounttype;
	}
	public void setSsesbdiscounttype(String ssesbdiscounttype) {
		this.ssesbdiscounttype = ssesbdiscounttype;
	}
	public String getSsesbdiscountperson() {
		return ssesbdiscountperson;
	}
	public void setSsesbdiscountperson(String ssesbdiscountperson) {
		this.ssesbdiscountperson = ssesbdiscountperson;
	}	
	public String getSsesbpaycash() {
		return ssesbpaycash;
	}
	public void setSsesbpaycash(String ssesbpaycash) {
		this.ssesbpaycash = ssesbpaycash;
	}
	public String getSsesbbankcard() {
		return ssesbbankcard;
	}
	public void setSsesbbankcard(String ssesbbankcard) {
		this.ssesbbankcard = ssesbbankcard;
	}
	public String getSsesbstoredcard() {
		return ssesbstoredcard;
	}
	public void setSsesbstoredcard(String ssesbstoredcard) {
		this.ssesbstoredcard = ssesbstoredcard;
	}
	public String getSsesbdragstype() {
		return ssesbdragstype;
	}
	public void setSsesbdragstype(String ssesbdragstype) {
		this.ssesbdragstype = ssesbdragstype;
	}
	public String getSsesbdepid() {
		return ssesbdepid;
	}
	public void setSsesbdepid(String ssesbdepid) {
		this.ssesbdepid = ssesbdepid;
	}
	public String getSsesbsuppliername() {
		return ssesbsuppliername;
	}
	public void setSsesbsuppliername(String ssesbsuppliername) {
		this.ssesbsuppliername = ssesbsuppliername;
	}
	public String getSsesbbrandid() {
		return ssesbbrandid;
	}
	public void setSsesbbrandid(String ssesbbrandid) {
		this.ssesbbrandid = ssesbbrandid;
	}
	public String getSsesbbrandname() {
		return ssesbbrandname;
	}
	public void setSsesbbrandname(String ssesbbrandname) {
		this.ssesbbrandname = ssesbbrandname;
	}
	public String getSsesbismutiluminosity() {
		return ssesbismutiluminosity;
	}
	public void setSsesbismutiluminosity(String ssesbismutiluminosity) {
		this.ssesbismutiluminosity = ssesbismutiluminosity;
	}
	public String getSsesbtakeshopname() {
		return ssesbtakeshopname;
	}
	public void setSsesbtakeshopname(String ssesbtakeshopname) {
		this.ssesbtakeshopname = ssesbtakeshopname;
	}
	public String getSsesbgoodsname() {
		return ssesbgoodsname;
	}
	public void setSsesbgoodsname(String ssesbgoodsname) {
		this.ssesbgoodsname = ssesbgoodsname;
	}
	public String getSsesblightvertical() {
		return ssesblightvertical;
	}
	public void setSsesblightvertical(String ssesblightvertical) {
		this.ssesblightvertical = ssesblightvertical;
	}
	public String getSsesbmaterialsperson() {
		return ssesbmaterialsperson;
	}
	public void setSsesbmaterialsperson(String ssesbmaterialsperson) {
		this.ssesbmaterialsperson = ssesbmaterialsperson;
	}
	public String getSsesbmaterialsdate() {
		return ssesbmaterialsdate;
	}
	public void setSsesbmaterialsdate(String ssesbmaterialsdate) {
		this.ssesbmaterialsdate = ssesbmaterialsdate;
	}
	public String getSsesbdepartmentid() {
		return ssesbdepartmentid;
	}
	public void setSsesbdepartmentid(String ssesbdepartmentid) {
		this.ssesbdepartmentid = ssesbdepartmentid;
	}
	public String getSsesbdepartmenttype() {
		return ssesbdepartmenttype;
	}
	public void setSsesbdepartmenttype(String ssesbdepartmenttype) {
		this.ssesbdepartmenttype = ssesbdepartmenttype;
	}	
	public String getSsesbinspectionid() {
		return ssesbinspectionid;
	}
	public void setSsesbinspectionid(String ssesbinspectionid) {
		this.ssesbinspectionid = ssesbinspectionid;
	}
	public String getSsesbposName() {
		return ssesbposName;
	}
	public void setSsesbposName(String ssesbposName) {
		this.ssesbposName = ssesbposName;
	}
	public String getSsesbMemberId() {
		return ssesbMemberId;
	}
	public void setSsesbMemberId(String ssesbMemberId) {
		this.ssesbMemberId = ssesbMemberId;
	}
	public String getSsesbsalesid() {
		return ssesbsalesid;
	}
	public void setSsesbsalesid(String ssesbsalesid) {
		this.ssesbsalesid = ssesbsalesid;
	}
	public String getSsesbshopcode() {
		return ssesbshopcode;
	}
	public void setSsesbshopcode(String ssesbshopcode) {
		this.ssesbshopcode = ssesbshopcode;
	}
	public String getSsesbcustomerid() {
		return ssesbcustomerid;
	}
	public void setSsesbcustomerid(String ssesbcustomerid) {
		this.ssesbcustomerid = ssesbcustomerid;
	}
	public String getSsesboptid() {
		return ssesboptid;
	}
	public void setSsesboptid(String ssesboptid) {
		this.ssesboptid = ssesboptid;
	}
	public String getSsesboptometryid() {
		return ssesboptometryid;
	}
	public void setSsesboptometryid(String ssesboptometryid) {
		this.ssesboptometryid = ssesboptometryid;
	}
	public String getSsesbtakeglassdata() {
		return ssesbtakeglassdata;
	}
	public void setSsesbtakeglassdata(String ssesbtakeglassdata) {
		this.ssesbtakeglassdata = ssesbtakeglassdata;
	}
	public String getSsesbsalesdatetime() {
		return ssesbsalesdatetime;
	}
	public void setSsesbsalesdatetime(String ssesbsalesdatetime) {
		this.ssesbsalesdatetime = ssesbsalesdatetime;
	}
	public String getSsesborderstype() {
		return ssesborderstype;
	}
	public void setSsesborderstype(String ssesborderstype) {
		this.ssesborderstype = ssesborderstype;
	}
	public String getSsesbballglassod() {
		return ssesbballglassod;
	}
	public void setSsesbballglassod(String ssesbballglassod) {
		this.ssesbballglassod = ssesbballglassod;
	}
	public String getSsesbballglassos() {
		return ssesbballglassos;
	}
	public void setSsesbballglassos(String ssesbballglassos) {
		this.ssesbballglassos = ssesbballglassos;
	}
	public String getSsesbpostglassod() {
		return ssesbpostglassod;
	}
	public void setSsesbpostglassod(String ssesbpostglassod) {
		this.ssesbpostglassod = ssesbpostglassod;
	}
	public String getSsesbpostglassos() {
		return ssesbpostglassos;
	}
	public void setSsesbpostglassos(String ssesbpostglassos) {
		this.ssesbpostglassos = ssesbpostglassos;
	}
	public String getSsesbaxesod() {
		return ssesbaxesod;
	}
	public void setSsesbaxesod(String ssesbaxesod) {
		this.ssesbaxesod = ssesbaxesod;
	}
	public String getSsesbaxesos() {
		return ssesbaxesos;
	}

	public void setSsesbaxesos(String ssesbaxesos) {
		this.ssesbaxesos = ssesbaxesos;
	}
	public String getSsesbaddod() {
		return ssesbaddod;
	}

	public void setSsesbaddod(String ssesbaddod) {
		this.ssesbaddod = ssesbaddod;
	}

	public String getSsesbaddos() {
		return ssesbaddos;
	}

	public void setSsesbaddos(String ssesbaddos) {
		this.ssesbaddos = ssesbaddos;
	}

	public String getSsesbarriseglassod() {
		return ssesbarriseglassod;
	}

	public void setSsesbarriseglassod(String ssesbarriseglassod) {
		this.ssesbarriseglassod = ssesbarriseglassod;
	}

	public String getSsesbarriseglassos() {
		return ssesbarriseglassos;
	}

	public void setSsesbarriseglassos(String ssesbarriseglassos) {
		this.ssesbarriseglassos = ssesbarriseglassos;
	}

	public String getSsesbbasisod() {
		return ssesbbasisod;
	}

	public void setSsesbbasisod(String ssesbbasisod) {
		this.ssesbbasisod = ssesbbasisod;
	}

	public String getSsesbbasisos() {
		return ssesbbasisos;
	}

	public void setSsesbbasisos(String ssesbbasisos) {
		this.ssesbbasisos = ssesbbasisos;
	}

	public String getSsesbprismod() {
		return ssesbprismod;
	}
	public void setSsesbprismod(String ssesbprismod) {
		this.ssesbprismod = ssesbprismod;
	}

	public String getSsesbprismos() {
		return ssesbprismos;
	}

	public void setSsesbprismos(String ssesbprismos) {
		this.ssesbprismos = ssesbprismos;
	}

	public String getSsesbinterhighod() {
		return ssesbinterhighod;
	}
	public void setSsesbinterhighod(String ssesbinterhighod) {
		this.ssesbinterhighod = ssesbinterhighod;
	}

	public String getSsesbinterhighos() {
		return ssesbinterhighos;
	}

	public void setSsesbinterhighos(String ssesbinterhighos) {
		this.ssesbinterhighos = ssesbinterhighos;
	}
	public String getSsesbinterdistanceod() {
		return ssesbinterdistanceod;
	}

	public void setSsesbinterdistanceod(String ssesbinterdistanceod) {
		this.ssesbinterdistanceod = ssesbinterdistanceod;
	}

	public String getSsesbinterdistanceos() {
		return ssesbinterdistanceos;
	}

	public void setSsesbinterdistanceos(String ssesbinterdistanceos) {
		this.ssesbinterdistanceos = ssesbinterdistanceos;
	}
	public String getSsesbfarvaod() {
		return ssesbfarvaod;
	}

	public void setSsesbfarvaod(String ssesbfarvaod) {
		this.ssesbfarvaod = ssesbfarvaod;
	}

	public String getSsesbfarvaos() {
		return ssesbfarvaos;
	}

	public void setSsesbfarvaos(String ssesbfarvaos) {
		this.ssesbfarvaos = ssesbfarvaos;
	}

	public String getSsesbclosevaod() {
		return ssesbclosevaod;
	}

	public void setSsesbclosevaod(String ssesbclosevaod) {
		this.ssesbclosevaod = ssesbclosevaod;
	}

	public String getSsesbclosevaos() {
		return ssesbclosevaos;
	}

	public void setSsesbclosevaos(String ssesbclosevaos) {
		this.ssesbclosevaos = ssesbclosevaos;
	}

	public String getSsesbcommendglasses() {
		return ssesbcommendglasses;
	}
	public void setSsesbcommendglasses(String ssesbcommendglasses) {
		this.ssesbcommendglasses = ssesbcommendglasses;
	}
	public String getSsesbglassmaterial() {
		return ssesbglassmaterial;
	}
	public void setSsesbglassmaterial(String ssesbglassmaterial) {
		this.ssesbglassmaterial = ssesbglassmaterial;
	}
	public String getSsesbrecipetype() {
		return ssesbrecipetype;
	}
	public void setSsesbrecipetype(String ssesbrecipetype) {
		this.ssesbrecipetype = ssesbrecipetype;
	}
	public String getSsesbdisposemanner() {
		return ssesbdisposemanner;
	}
	public void setSsesbdisposemanner(String ssesbdisposemanner) {
		this.ssesbdisposemanner = ssesbdisposemanner;
	}
	public String getSsesbdignosisre() {
		return ssesbdignosisre;
	}
	public void setSsesbdignosisre(String ssesbdignosisre) {
		this.ssesbdignosisre = ssesbdignosisre;
	}
	public String getSsesbeyecurvatureod1() {
		return ssesbeyecurvatureod1;
	}
	public void setSsesbeyecurvatureod1(String ssesbeyecurvatureod1) {
		this.ssesbeyecurvatureod1 = ssesbeyecurvatureod1;
	}
	public String getSsesbeyecurvatureod2() {
		return ssesbeyecurvatureod2;
	}
	public void setSsesbeyecurvatureod2(String ssesbeyecurvatureod2) {
		this.ssesbeyecurvatureod2 = ssesbeyecurvatureod2;
	}
	public String getSsesbeyecurvatureos1() {
		return ssesbeyecurvatureos1;
	}
	public void setSsesbeyecurvatureos1(String ssesbeyecurvatureos1) {
		this.ssesbeyecurvatureos1 = ssesbeyecurvatureos1;
	}
	public String getSsesbeyecurvatureos2() {
		return ssesbeyecurvatureos2;
	}
	public void setSsesbeyecurvatureos2(String ssesbeyecurvatureos2) {
		this.ssesbeyecurvatureos2 = ssesbeyecurvatureos2;
	}
	public String getSsesbdiameterod() {
		return ssesbdiameterod;
	}
	public void setSsesbdiameterod(String ssesbdiameterod) {
		this.ssesbdiameterod = ssesbdiameterod;
	}
	public String getSsesbdiameteros() {
		return ssesbdiameteros;
	}
	public void setSsesbdiameteros(String ssesbdiameteros) {
		this.ssesbdiameteros = ssesbdiameteros;
	}
	public String getSsesbconlenvaod() {
		return ssesbconlenvaod;
	}
	public void setSsesbconlenvaod(String ssesbconlenvaod) {
		this.ssesbconlenvaod = ssesbconlenvaod;
	}
	public String getSsesbconlenvaos() {
		return ssesbconlenvaos;
	}
	public void setSsesbconlenvaos(String ssesbconlenvaos) {
		this.ssesbconlenvaos = ssesbconlenvaos;
	}
	public String getSsesbconrecipetype() {
		return ssesbconrecipetype;
	}
	public void setSsesbconrecipetype(String ssesbconrecipetype) {
		this.ssesbconrecipetype = ssesbconrecipetype;
	}
	public String getSsesbseccheckdate() {
		return ssesbseccheckdate;
	}
	public void setSsesbseccheckdate(String ssesbseccheckdate) {
		this.ssesbseccheckdate = ssesbseccheckdate;
	}
	public String getSsesbsubvisitunit() {
		return ssesbsubvisitunit;
	}
	public void setSsesbsubvisitunit(String ssesbsubvisitunit) {
		this.ssesbsubvisitunit = ssesbsubvisitunit;
	}
	public String getSsesbsalestype() {
		return ssesbsalestype;
	}
	public void setSsesbsalestype(String ssesbsalestype) {
		this.ssesbsalestype = ssesbsalestype;
	}
	public String getSsesbsalerid() {
		return ssesbsalerid;
	}
	public void setSsesbsalerid(String ssesbsalerid) {
		this.ssesbsalerid = ssesbsalerid;
	}
	public String getSsesblryid() {
		return ssesblryid;
	}
	public void setSsesblryid(String ssesblryid) {
		this.ssesblryid = ssesblryid;
	}

	public String getSsesbposdatetime() {
		return ssesbposdatetime;
	}
	public void setSsesbposdatetime(String ssesbposdatetime) {
		this.ssesbposdatetime = ssesbposdatetime;
	}
	public String getSsesbposid() {
		return ssesbposid;
	}
	public void setSsesbposid(String ssesbposid) {
		this.ssesbposid = ssesbposid;
	}
	public String getSsesbpricesum() {
		return ssesbpricesum;
	}
	public void setSsesbpricesum(String ssesbpricesum) {
		this.ssesbpricesum = ssesbpricesum;
	}
	public String getSsesbsalesvalue() {
		return ssesbsalesvalue;
	}
	public void setSsesbsalesvalue(String ssesbsalesvalue) {
		this.ssesbsalesvalue = ssesbsalesvalue;
	}
	public String getSsesbdiscountrate() {
		return ssesbdiscountrate;
	}
	public void setSsesbdiscountrate(String ssesbdiscountrate) {
		this.ssesbdiscountrate = ssesbdiscountrate;
	}
	public String getSsesbdiscountnum() {
		return ssesbdiscountnum;
	}
	public void setSsesbdiscountnum(String ssesbdiscountnum) {
		this.ssesbdiscountnum = ssesbdiscountnum;
	}
	public String getSsesbpsalsvalue() {
		return ssesbpsalsvalue;
	}
	public void setSsesbpsalsvalue(String ssesbpsalsvalue) {
		this.ssesbpsalsvalue = ssesbpsalsvalue;
	}
	public String getSsesbarrearsvalue() {
		return ssesbarrearsvalue;
	}
	public void setSsesbarrearsvalue(String ssesbarrearsvalue) {
		this.ssesbarrearsvalue = ssesbarrearsvalue;
	}
	public String getSsesblocation() {
		return ssesblocation;
	}
	public void setSsesblocation(String ssesblocation) {
		this.ssesblocation = ssesblocation;
	}
	public String getSsesbarriveddate() {
		return ssesbarriveddate;
	}
	public void setSsesbarriveddate(String ssesbarriveddate) {
		this.ssesbarriveddate = ssesbarriveddate;
	}
	public String getSsesbvalueflag() {
		return ssesbvalueflag;
	}
	public void setSsesbvalueflag(String ssesbvalueflag) {
		this.ssesbvalueflag = ssesbvalueflag;
	}
	public String getSsesbcheckoutflag() {
		return ssesbcheckoutflag;
	}
	public void setSsesbcheckoutflag(String ssesbcheckoutflag) {
		this.ssesbcheckoutflag = ssesbcheckoutflag;
	}
	public String getSsesbintransit() {
		return ssesbintransit;
	}
	public void setSsesbintransit(String ssesbintransit) {
		this.ssesbintransit = ssesbintransit;
	}
	public String getSsesbchooseflag() {
		return ssesbchooseflag;
	}
	public void setSsesbchooseflag(String ssesbchooseflag) {
		this.ssesbchooseflag = ssesbchooseflag;
	}
	public String getSsesbwithdrawdate() {
		return ssesbwithdrawdate;
	}
	public void setSsesbwithdrawdate(String ssesbwithdrawdate) {
		this.ssesbwithdrawdate = ssesbwithdrawdate;
	}
	public String getSsesbwithdrawflag() {
		return ssesbwithdrawflag;
	}
	public void setSsesbwithdrawflag(String ssesbwithdrawflag) {
		this.ssesbwithdrawflag = ssesbwithdrawflag;
	}
	public String getSsesbwithdrawpersonid() {
		return ssesbwithdrawpersonid;
	}
	public void setSsesbwithdrawpersonid(String ssesbwithdrawpersonid) {
		this.ssesbwithdrawpersonid = ssesbwithdrawpersonid;
	}
	public String getSsesbmovementtype() {
		return ssesbmovementtype;
	}
	public void setSsesbmovementtype(String ssesbmovementtype) {
		this.ssesbmovementtype = ssesbmovementtype;
	}
	public String getSsesbsupplierid() {
		return ssesbsupplierid;
	}
	public void setSsesbsupplierid(String ssesbsupplierid) {
		this.ssesbsupplierid = ssesbsupplierid;
	}
	public String getSsesbsalesdatestarttime() {
		return ssesbsalesdatestarttime;
	}
	public void setSsesbsalesdatestarttime(String ssesbsalesdatestarttime) {
		this.ssesbsalesdatestarttime = ssesbsalesdatestarttime;
	}
	public String getSsesbsalesdateendtime() {
		return ssesbsalesdateendtime;
	}
	public void setSsesbsalesdateendtime(String ssesbsalesdateendtime) {
		this.ssesbsalesdateendtime = ssesbsalesdateendtime;
	}
	public String getSsesbtakeglassstartdata() {
		return ssesbtakeglassstartdata;
	}
	public void setSsesbtakeglassstartdata(String ssesbtakeglassstartdata) {
		this.ssesbtakeglassstartdata = ssesbtakeglassstartdata;
	}
	public String getSsesbtakeglassenddata() {
		return ssesbtakeglassenddata;
	}
	public void setSsesbtakeglassenddata(String ssesbtakeglassenddata) {
		this.ssesbtakeglassenddata = ssesbtakeglassenddata;
	}
	public String getSsesbpersonName() {
		return ssesbpersonName;
	}
	public void setSsesbpersonName(String ssesbpersonName) {
		this.ssesbpersonName = ssesbpersonName;
	}
	public String getSsesbphone() {
		return ssesbphone;
	}
	public void setSsesbphone(String ssesbphone) {
		this.ssesbphone = ssesbphone;
	}
	public String getSsesbaddress() {
		return ssesbaddress;
	}
	public void setSsesbaddress(String ssesbaddress) {
		this.ssesbaddress = ssesbaddress;
	}
	public String getSsesbshopName() {
		return ssesbshopName;
	}
	public void setSsesbshopName(String ssesbshopName) {
		this.ssesbshopName = ssesbshopName;
	}
	public String getSsesbsalerName() {
		return ssesbsalerName;
	}
	public void setSsesbsalerName(String ssesbsalerName) {
		this.ssesbsalerName = ssesbsalerName;
	}

	public List<SalesDetailPo> getSalesDetails() {
		return salesDetails;
	}

	public void setSalesDetails(List<SalesDetailPo> salesDetails) {
		this.salesDetails = salesDetails;
	}
	public String getSsesbyishiid() {
		return ssesbyishiid;
	}
	public void setSsesbyishiid(String ssesbyishiid) {
		this.ssesbyishiid = ssesbyishiid;
	}
 
	public String toString() {
		return "SalesBasicPo [chuzhikaid=" + chuzhikaid + ", djsbm=" + djsbm + ", inintrgral=" + inintrgral + ", integraldate=" + integraldate + ", integraltype=" + integraltype + ", isMail=" + isMail + ", month=" + month + ", month1=" + month1 + ", nowintegral=" + nowintegral + ", nowmonth=" + nowmonth + ", outpriceendtime=" + outpriceendtime + ", outpricestrattime=" + outpricestrattime + ", posdateendtime=" + posdateendtime + ", posdatestarttime=" + posdatestarttime + ", remark=" + remark + ", salesDetails=" + salesDetails + ", smecishoplist=" + smecishoplist + ", ssesbMemberId=" + ssesbMemberId + ", ssesbadditionPrice=" + ssesbadditionPrice + ", ssesbadditionname=" + ssesbadditionname + ", ssesbaddod=" + ssesbaddod + ", ssesbaddos=" + ssesbaddos + ", ssesbaddress=" + ssesbaddress + ", ssesbarrearsvalue=" + ssesbarrearsvalue + ", ssesbarriseglassod=" + ssesbarriseglassod + ", ssesbarriseglassos=" + ssesbarriseglassos + ", ssesbarriveddate=" + ssesbarriveddate + ", ssesbaxesod="
				+ ssesbaxesod + ", ssesbaxesos=" + ssesbaxesos + ", ssesbaxs=" + ssesbaxs + ", ssesbballglassod=" + ssesbballglassod + ", ssesbballglassos=" + ssesbballglassos + ", ssesbbankcard=" + ssesbbankcard + ", ssesbbasisod=" + ssesbbasisod + ", ssesbbasisos=" + ssesbbasisos + ", ssesbbrandid=" + ssesbbrandid + ", ssesbbrandname=" + ssesbbrandname + ", ssesbcheckoutflag=" + ssesbcheckoutflag + ", ssesbchooseflag=" + ssesbchooseflag + ", ssesbclosevaod=" + ssesbclosevaod + ", ssesbclosevaos=" + ssesbclosevaos + ", ssesbcommendglasses=" + ssesbcommendglasses + ", ssesbcompanyid=" + ssesbcompanyid + ", ssesbconlenvaod=" + ssesbconlenvaod + ", ssesbconlenvaos=" + ssesbconlenvaos + ", ssesbconrecipetype=" + ssesbconrecipetype + ", ssesbconsumptionid=" + ssesbconsumptionid + ", ssesbcustomerid=" + ssesbcustomerid + ", ssesbcyl=" + ssesbcyl + ", ssesbdepartmentid=" + ssesbdepartmentid + ", ssesbdepartmenttype=" + ssesbdepartmenttype + ", ssesbdepid=" + ssesbdepid
				+ ", ssesbdiagonalline=" + ssesbdiagonalline + ", ssesbdiameterod=" + ssesbdiameterod + ", ssesbdiameteros=" + ssesbdiameteros + ", ssesbdignosisre=" + ssesbdignosisre + ", ssesbdiscountnum=" + ssesbdiscountnum + ", ssesbdiscountperson=" + ssesbdiscountperson + ", ssesbdiscountrate=" + ssesbdiscountrate + ", ssesbdiscounttype=" + ssesbdiscounttype + ", ssesbdisposemanner=" + ssesbdisposemanner + ", ssesbdistributionid=" + ssesbdistributionid + ", ssesbdoublezz=" + ssesbdoublezz + ", ssesbdragstype=" + ssesbdragstype + ", ssesbdueintegral=" + ssesbdueintegral + ", ssesbexecstandard=" + ssesbexecstandard + ", ssesbeyecurvatureod1=" + ssesbeyecurvatureod1 + ", ssesbeyecurvatureod2=" + ssesbeyecurvatureod2 + ", ssesbeyecurvatureos1=" + ssesbeyecurvatureos1 + ", ssesbeyecurvatureos2=" + ssesbeyecurvatureos2 + ", ssesbfactposdatetime=" + ssesbfactposdatetime + ", ssesbfactwithdrawdate=" + ssesbfactwithdrawdate + ", ssesbfaliaodtpid=" + ssesbfaliaodtpid
				+ ", ssesbfaliaodtpname=" + ssesbfaliaodtpname + ", ssesbfaliaostockid=" + ssesbfaliaostockid + ", ssesbfarvaod=" + ssesbfarvaod + ", ssesbfarvaos=" + ssesbfarvaos + ", ssesbfavorableamount=" + ssesbfavorableamount + ", ssesbfcustomerid=" + ssesbfcustomerid + ", ssesbfcustomername=" + ssesbfcustomername + ", ssesbfmemberId=" + ssesbfmemberId + ", ssesbframedia=" + ssesbframedia + ", ssesbframeform=" + ssesbframeform + ", ssesbframemiddlesize=" + ssesbframemiddlesize + ", ssesbgalssroad=" + ssesbgalssroad + ", ssesbglassflag=" + ssesbglassflag + ", ssesbglasshige=" + ssesbglasshige + ", ssesbglassmaterial=" + ssesbglassmaterial + ", ssesbglasswigth=" + ssesbglasswigth + ", ssesbgoodsbarcode=" + ssesbgoodsbarcode + ", ssesbgoodslevel=" + ssesbgoodslevel + ", ssesbgoodsname=" + ssesbgoodsname + ", ssesbgoodsnum=" + ssesbgoodsnum + ", ssesbgoodsvalue=" + ssesbgoodsvalue + ", ssesbhandlestate=" + ssesbhandlestate + ", ssesbhandlestatecount=" + ssesbhandlestatecount
				+ ", ssesbhardvalueversion=" + ssesbhardvalueversion + ", ssesbhiscancelflag=" + ssesbhiscancelflag + ", ssesbhisflag=" + ssesbhisflag + ", ssesbhispayflag=" + ssesbhispayflag + ", ssesbhissaleid=" + ssesbhissaleid + ", ssesbinspectionid=" + ssesbinspectionid + ", ssesbintegral=" + ssesbintegral + ", ssesbintegralprice=" + ssesbintegralprice + ", ssesbinterdistanceod=" + ssesbinterdistanceod + ", ssesbinterdistanceos=" + ssesbinterdistanceos + ", ssesbinterhighod=" + ssesbinterhighod + ", ssesbinterhighos=" + ssesbinterhighos + ", ssesbintransit=" + ssesbintransit + ", ssesbintransit2=" + ssesbintransit2 + ", ssesbintransitfinished=" + ssesbintransitfinished + ", ssesbintransittype=" + ssesbintransittype + ", ssesbintransittype2=" + ssesbintransittype2 + ", ssesbinwarehouseid=" + ssesbinwarehouseid + ", ssesbinwarehousename=" + ssesbinwarehousename + ", ssesbisgiveyouintegral=" + ssesbisgiveyouintegral + ", ssesbismutiluminosity=" + ssesbismutiluminosity
				+ ", ssesbjfamount=" + ssesbjfamount + ", ssesblightvertical=" + ssesblightvertical + ", ssesblocation=" + ssesblocation + ", ssesblryid=" + ssesblryid + ", ssesbmaterialsdate=" + ssesbmaterialsdate + ", ssesbmaterialsperson=" + ssesbmaterialsperson + ", ssesbmovementtype=" + ssesbmovementtype + ", ssesbnothisflag=" + ssesbnothisflag + ", ssesboldeyesize=" + ssesboldeyesize + ", ssesbopdatetime=" + ssesbopdatetime + ", ssesbopsource=" + ssesbopsource + ", ssesboptid=" + ssesboptid + ", ssesboptometryid=" + ssesboptometryid + ", ssesborderby=" + ssesborderby + ", ssesborderstype=" + ssesborderstype + ", ssesborderstypes=" + Arrays.toString(ssesborderstypes) + ", ssesbordertype=" + ssesbordertype + ", ssesbpaycash=" + ssesbpaycash + ", ssesbpersonName=" + ssesbpersonName + ", ssesbphone=" + ssesbphone + ", ssesbposName=" + ssesbposName + ", ssesbposdatetime=" + ssesbposdatetime + ", ssesbposid=" + ssesbposid + ", ssesbpostglassod=" + ssesbpostglassod
				+ ", ssesbpostglassos=" + ssesbpostglassos + ", ssesbpricesum=" + ssesbpricesum + ", ssesbprintserialnumber=" + ssesbprintserialnumber + ", ssesbprintsmflag=" + ssesbprintsmflag + ", ssesbprismod=" + ssesbprismod + ", ssesbprismos=" + ssesbprismos + ", ssesbprocessdepartment=" + ssesbprocessdepartment + ", ssesbprocessdepartmentname=" + ssesbprocessdepartmentname + ", ssesbprocessdpt=" + ssesbprocessdpt + ", ssesbpsalsvalue=" + ssesbpsalsvalue + ", ssesbpupilheightod=" + ssesbpupilheightod + ", ssesbpupilheightos=" + ssesbpupilheightos + ", ssesbqueryclassif=" + ssesbqueryclassif + ", ssesbrecipetype=" + ssesbrecipetype + ", ssesbrenums=" + ssesbrenums + ", ssesbreturnbillflag=" + ssesbreturnbillflag + ", ssesbsalerName=" + ssesbsalerName + ", ssesbsalerid=" + ssesbsalerid + ", ssesbsalescount=" + ssesbsalescount + ", ssesbsalesdateendtime=" + ssesbsalesdateendtime + ", ssesbsalesdatestarttime=" + ssesbsalesdatestarttime + ", ssesbsalesdatetime=" + ssesbsalesdatetime
				+ ", ssesbsalesid=" + ssesbsalesid + ", ssesbsalesremark=" + ssesbsalesremark + ", ssesbsalestelphone=" + ssesbsalestelphone + ", ssesbsalestype=" + ssesbsalestype + ", ssesbsalesvalue=" + ssesbsalesvalue + ", ssesbseccheckdate=" + ssesbseccheckdate + ", ssesbsetmealid=" + ssesbsetmealid + ", ssesbsetmealtitle=" + ssesbsetmealtitle + ", ssesbsetmealtype=" + ssesbsetmealtype + ", ssesbshopName=" + ssesbshopName + ", ssesbshopcode=" + ssesbshopcode + ", ssesbshopcodewarehouseid=" + ssesbshopcodewarehouseid + ", ssesbshouhuodate=" + ssesbshouhuodate + ", ssesbshouhuoren=" + ssesbshouhuoren + ", ssesbsourceid=" + ssesbsourceid + ", ssesbsourcesalesid=" + ssesbsourcesalesid + ", ssesbspectaclesmaterialsdpt=" + ssesbspectaclesmaterialsdpt + ", ssesbsph=" + ssesbsph + ", ssesbstoredcard=" + ssesbstoredcard + ", ssesbsubvisitunit=" + ssesbsubvisitunit + ", ssesbsupplierid=" + ssesbsupplierid + ", ssesbsuppliername=" + ssesbsuppliername + ", ssesbswapgoodsflag="
				+ ssesbswapgoodsflag + ", ssesbtakeglassdata=" + ssesbtakeglassdata + ", ssesbtakeglassenddata=" + ssesbtakeglassenddata + ", ssesbtakeglassstartdata=" + ssesbtakeglassstartdata + ", ssesbtakeshopname=" + ssesbtakeshopname + ", ssesbtaketelphone=" + ssesbtaketelphone + ", ssesbunhandlestate=" + ssesbunhandlestate + ", ssesbupdateguitartype=" + ssesbupdateguitartype + ", ssesbusesetmealflag=" + ssesbusesetmealflag + ", ssesbvalueflag=" + ssesbvalueflag + ", ssesbweixintype=" + ssesbweixintype + ", ssesbwithdrawdate=" + ssesbwithdrawdate + ", ssesbwithdrawflag=" + ssesbwithdrawflag + ", ssesbwithdrawpersonid=" + ssesbwithdrawpersonid + ", ssesbworrytype=" + ssesbworrytype + ", ssesbygsid=" + ssesbygsid + ", ssesbyishiid=" + ssesbyishiid + ", ssesldatetime=" + ssesldatetime + ", sseslpaymenttype=" + sseslpaymenttype + ", sseslpaymenttypename=" + sseslpaymenttypename + ", sseslprice=" + sseslprice + ", year=" + year + "]";
	}


	
	
	
}
