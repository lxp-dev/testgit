package com.pengsheng.eims.basic.persistence;

public class ForeignRecipelPo {
	
    private String bfrid;        //外来处方编号
    private String bfrname;      //外来处方名称
    
	public String getBfrid() {
		return bfrid;
	}
	public void setBfrid(String bfrid) {
		this.bfrid = bfrid;
	}
	public String getBfrname() {
		return bfrname;
	}
	public void setBfrname(String bfrname) {
		this.bfrname = bfrname;
	}
    
}
