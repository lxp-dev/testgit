package com.pengsheng.eims.basic.mgr.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.dao.BrandDao;
import com.pengsheng.eims.basic.mgr.BrandMgr;
import com.pengsheng.eims.basic.persistence.BrandPo;
import com.pengsheng.eims.basic.persistence.GoodsCategoryPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.basic.persistence.GoodsLevelPo;
import com.pengsheng.eims.basic.persistence.SupplierPo;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.system.dao.SystemParameterDao;
import com.pengsheng.eims.system.persistence.FuctionTreeNode;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.bean.UUIDHexGenerator;
import com.pengsheng.eims.util.tools.Utility;

public class BrandMgrImpl implements BrandMgr {

	private UUIDHexGenerator uuidGenerator = UUIDHexGenerator.getInstance();//获取随机生成主键Id
	private LogisticsLogDao logisticsLogDao;
	private SystemParameterDao systemParameterDao;
	
	public SystemParameterDao getSystemParameterDao() {
		return systemParameterDao;
	}
	public void setSystemParameterDao(SystemParameterDao systemParameterDao) {
		this.systemParameterDao = systemParameterDao;
	}
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}
	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

	private BrandDao brandDao;

	public BrandDao getBrandDao() {
		return brandDao;
	}

	public void setBrandDao(BrandDao brandDao) {
		this.brandDao = brandDao;
	}
	
	public List<BrandPo> getAjaxBrands_ByName(BrandPo brandPo){
		return brandDao.getAjaxBrands_ByName(brandPo);
	}
	
	/**
	 * 得到品种总数
	 */
	public int getBrandsCount(BrandPo brandPo) {
		// TODO Auto-generated method stub
		return brandDao.getBrandsCount(brandPo);
	}
	
	/**
	 * 得到品种信息
	 */
	public List<BrandPo> getBrands(BrandPo brandPo, int start, int size) {
		// TODO Auto-generated method stub
		return brandDao.getBrands(brandPo, start, size);
	}

	/**
	 * 得到所有品种信息
	 */
	public BrandPo getBrandPo(BrandPo brandPo) {
		// TODO Auto-generated method stub
		return brandDao.getBrandPo(brandPo);
	}

	/**
	 * 删除品种
	 */
	public void delBrand(BrandPo brandPo,LogisticsLogPo logPo) {
		// TODO Auto-generated method stub
		brandDao.delBrand(brandPo);
		logisticsLogDao.insertLog(logPo); //添加日志
	}

	/**
	 * 插入品种
	 */
	public void insertBrand(BrandPo brandPo, String delFileID,
			File[] upload, String filePath, String[] fFullName,
			String[] ContentType,LogisticsLogPo logPo) {

		// 上传文件
		for (int i = 0; upload != null && i < upload.length; i++) {
			File fUpload = upload[i];

			// System.out.println("上传的文件的类型：" + this.getUploadContentType()[i]);
			String uuid = uuidGenerator.generate();

			String fileFullName = uuid + "\\" + fFullName[i];

			brandPo.setSaveFileName(fileFullName);
			brandPo.setContentType(ContentType[i]);
			brandPo.setDocumentUrl(fileFullName);
			brandPo.setSaveFileName(fFullName[i]);			

			File dist = new File(filePath + "\\" + uuid);
			if (!dist.exists()) {
				dist.mkdir();
			}

			File dstFile = new File(filePath + "\\" + fileFullName);
			try {
				copy(fUpload, dstFile);
			} catch (Exception e) {
				brandPo.setSaveFileName("");
				brandPo.setContentType("");
				brandPo.setDocumentUrl("");	
				System.out.println("上传品种logo失败!");
			}
		}
		
		brandDao.insertBrand(brandPo);

		if ("1".equals(Utility.getName(brandPo.getUpdateGoodsName()))){
			brandDao.updateGoodsNameByBrand(brandPo);
		}
		
		logisticsLogDao.insertLog(logPo); //添加日志
	}

	// 自己封装的一个把源文件对象复制成目标文件对象
	private void copy(File src, File dst) throws Exception{
		InputStream in = null;
		OutputStream out = null;
		
		in = new BufferedInputStream(new FileInputStream(src));
		out = new BufferedOutputStream(new FileOutputStream(dst));
		byte[] buffer = new byte[1024];
		int len = 0;
		while ((len = in.read(buffer)) > 0) {
			out.write(buffer, 0, len);
		}
		
		if (null != in) {
			in.close();
		}
		if (null != out) {
			out.close();
		}
	}

	/**
	 * 更新品种
	 */
	public void updateBrand(BrandPo brandPo,LogisticsLogPo logPo,SystemParameterPo systemParameterPo) {

		brandDao.updateBrand(brandPo);
		
		if ("1".equals(Utility.getName(brandPo.getUpdateGoodsName()))){
			brandDao.updateGoodsNameByBrand(brandPo);
			systemParameterDao.updateGoodsViewName(systemParameterPo);
		}
		
		if ("1".equals(Utility.getName(brandPo.getUpdateGoodsDefaultDiscount()))){
			brandDao.updateGoodsNameByDefaultDiscount(brandPo);
		}
		
		logisticsLogDao.insertLog(logPo); //添加日志
	}

	/**
	 * 得到制造商
	 */
	public SupplierPo getSupplier(SupplierPo po) {
		// TODO Auto-generated method stub
		return brandDao.getSupplier(po);
	}

	/**
	 * 得到商品类型
	 */
	public List<GoodsCategoryPo> getGoodsCategorys() {
		// TODO Auto-generated method stub
		return brandDao.getGoodsCategorys();
	}
	
	/**
	 * 批量导入品种
	 */
	public void insertBrandExcel(List<BrandPo> brandList) {
		// TODO Auto-generated method stub
		for (BrandPo brandPo : brandList) {
			brandDao.insertBrand(brandPo);
		}
	}


	public int getGoodsCount(BrandPo brandPo) {
		// TODO Auto-generated method stub
		return brandDao.getGoodsCount(brandPo);
	}

	/**
	 * Description :修改品种状态（停用启用）
	 * @param：BrandPo 品种信息伴实体	 
	 * @return :品种信息的列表
	 **/
	public void updateBrandEnbled(BrandPo brandPo, LogisticsLogPo logPo){
		brandDao.brandEnbledUpdate(brandPo);
		brandDao.goodsEnbledUpdate(brandPo);
		logisticsLogDao.insertLog(logPo); //添加日志
	}
	
	/**
	 * 取所有商品(组织结构)
	 * 
	 * @return
	 */
	public List<FuctionTreeNode> getGoodsTree(String nodeId,String hrefTarget,String href,String isClosed,String fspshowsupplier){
		//System.out.println(nodeId+"((("+hrefTarget+"*****"+href+"****"+isClosed);
			if (nodeId.startsWith("T_")){			
				return brandDao.getSupplierByGoodsCategoryTree(nodeId,hrefTarget,href,isClosed);
			}else if (nodeId.startsWith("S_")){
				return brandDao.getBrandBySupplierTree(nodeId,hrefTarget,href,isClosed,fspshowsupplier);
			}else if (nodeId.startsWith("B_")){
				return new ArrayList<FuctionTreeNode>();
			}else {
				return brandDao.getGoodsCategoryTree(nodeId,hrefTarget,href,isClosed);
			}
	}
	/**
	 * 取所有商品(组织结构)
	 * 
	 * @return
	 */
	public List<FuctionTreeNode> getGoodsTreeNOSupplier(String nodeId,String hrefTarget,String href,String isClosed,String fspshowsupplier){
		//System.out.println(nodeId+"((("+hrefTarget+"*****"+href+"****"+isClosed);
			 if (nodeId.startsWith("S_")||nodeId.startsWith("T_")){
				return brandDao.getBrandBySupplierTree(nodeId,hrefTarget,href,isClosed,fspshowsupplier);
			}else if (nodeId.startsWith("B_")){
				return new ArrayList<FuctionTreeNode>();
			}else {
				return brandDao.getGoodsCategoryTree(nodeId,hrefTarget,href,isClosed);
			}
	}
	/**
	 * 更具树获取商品数量
	 * @param po
	 * @return
	 */
	public int getGoodsTreeCount(GoodsInfoPo po){
		return brandDao.getGoodsTreeCount(po);
	}
	/**
	 * 更具树形获取商品信息
	 * @param po
	 * @param start
	 * @param size
	 * @return
	 */
	public List<GoodsInfoPo> getGoodsTree(GoodsInfoPo po, int start, int size){
		return brandDao.getGoodsTree(po, start, size);
	}
	
	/**
	 * 获取商品等级LIST
	 * @param po
	 * @return
	 */
	public List<GoodsLevelPo> selectGoodsLevelList(GoodsLevelPo po){
		return brandDao.selectGoodsLevelList(po);
	}
}
