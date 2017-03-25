package com.pengsheng.eims.basic.mgr;

import java.io.File;
import java.util.List;

import com.pengsheng.eims.basic.persistence.GoodsImgLeaveMsgPo;

public interface GoodsImgLeaveMsgMgr {

	public int getGoodsImgLeaveMsgCount(GoodsImgLeaveMsgPo gpo);
	
	public List<GoodsImgLeaveMsgPo> getGoodsImgLeaveMsgList(GoodsImgLeaveMsgPo gpo,int start,int size);
	
	public GoodsImgLeaveMsgPo getGoodsImgLeaveMsgDetail(GoodsImgLeaveMsgPo gpo);
	
	public List<GoodsImgLeaveMsgPo> getGoodsImgLeaveMsgListDetail(GoodsImgLeaveMsgPo gpo);
	
	public void insertGoodsImgLeaveMsg(GoodsImgLeaveMsgPo gpo,File[] upload, String filePath, String[] fFullName,String[] ContentType);
	
	public void updateGoodsImgLeaveMsg(GoodsImgLeaveMsgPo gpo);
	
	public void deleteGoodsImgLeaveMsg(GoodsImgLeaveMsgPo gpo);
	
	public void insertGoodsImgLeaveMsgWord(GoodsImgLeaveMsgPo gpo);
	
}
