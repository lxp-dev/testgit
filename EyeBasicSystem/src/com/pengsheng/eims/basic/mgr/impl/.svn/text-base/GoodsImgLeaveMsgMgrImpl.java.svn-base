package com.pengsheng.eims.basic.mgr.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import com.pengsheng.eims.basic.dao.GoodsImgLeaveMsgDao;
import com.pengsheng.eims.basic.mgr.GoodsImgLeaveMsgMgr;
import com.pengsheng.eims.basic.persistence.GoodsImgLeaveMsgPo;
import com.pengsheng.eims.util.bean.UUIDHexGenerator;

public class GoodsImgLeaveMsgMgrImpl implements GoodsImgLeaveMsgMgr {

	private GoodsImgLeaveMsgDao goodsImgLeaveMsgDao;
	private UUIDHexGenerator uuidGenerator = UUIDHexGenerator.getInstance();//获取随机生成主键Id
	
	public GoodsImgLeaveMsgDao getGoodsImgLeaveMsgDao() {
		return goodsImgLeaveMsgDao;
	}

	public void setGoodsImgLeaveMsgDao(GoodsImgLeaveMsgDao goodsImgLeaveMsgDao) {
		this.goodsImgLeaveMsgDao = goodsImgLeaveMsgDao;
	}
	
	public int getGoodsImgLeaveMsgCount(GoodsImgLeaveMsgPo gpo){
		return goodsImgLeaveMsgDao.getGoodsImgLeaveMsgCount(gpo);
	}
	
	public List<GoodsImgLeaveMsgPo> getGoodsImgLeaveMsgList(GoodsImgLeaveMsgPo gpo,int start,int size){
		return goodsImgLeaveMsgDao.getGoodsImgLeaveMsgList(gpo,start,size);
	}
	
	public GoodsImgLeaveMsgPo getGoodsImgLeaveMsgDetail(GoodsImgLeaveMsgPo gpo){
		return goodsImgLeaveMsgDao.getGoodsImgLeaveMsgDetail(gpo);
	}
	
	public List<GoodsImgLeaveMsgPo> getGoodsImgLeaveMsgListDetail(GoodsImgLeaveMsgPo gpo){
		goodsImgLeaveMsgDao.updateGoodsImgLeaveMsgReadedFlag(gpo);
		return goodsImgLeaveMsgDao.getGoodsImgLeaveMsgListDetail(gpo);
	}
	
	public void insertGoodsImgLeaveMsg(GoodsImgLeaveMsgPo gpo,File[] upload, String filePath, String[] fFullName,String[] ContentType){
		
		String uuid = uuidGenerator.generate();
		for (int i = 0; upload != null && i < upload.length; i++) {
			File fUpload = upload[i];
						
			String fileFullName = uuid + "\\" + fFullName[i];
			String savepath =  uuid + "\\" + fFullName[i];
		
			gpo.setCmrlmPicUrl(savepath);
			gpo.setCmrlmPicName(fFullName[i]);
			gpo.setCmrlmPicType(ContentType[i]);
			
			File dist = new File(filePath + "\\" + uuid );
			if (!dist.exists()) {
				dist.mkdir();
			}

			File dstFile = new File(filePath + "\\" + fileFullName);
			try {
				copy(fUpload, dstFile);				
			} catch (Exception e) {
				continue;
			}
			
		}
		gpo.setCmrlmid(uuidGenerator.generate());
		
		goodsImgLeaveMsgDao.insertGoodsImgLeaveMsg(gpo);
	}
	
	public void updateGoodsImgLeaveMsg(GoodsImgLeaveMsgPo gpo){
		goodsImgLeaveMsgDao.updateGoodsImgLeaveMsg(gpo);
	}
	
	public void deleteGoodsImgLeaveMsg(GoodsImgLeaveMsgPo gpo){
		goodsImgLeaveMsgDao.deleteGoodsImgLeaveMsg(gpo);
		goodsImgLeaveMsgDao.deleteGoodsImgLeaveMsgWord(gpo);
	}
	
	public void insertGoodsImgLeaveMsgWord(GoodsImgLeaveMsgPo gpo){
		gpo.setCmrlmeid(uuidGenerator.generate());
		goodsImgLeaveMsgDao.insertGoodsImgLeaveMsgWord(gpo);
	}
	
	private void copy(File src, File dst) throws Exception {
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
	
	
}
