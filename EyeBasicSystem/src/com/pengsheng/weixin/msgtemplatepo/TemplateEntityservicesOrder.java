package com.pengsheng.weixin.msgtemplatepo;

public class TemplateEntityservicesOrder {
	private TemplateValue first;
	private TemplateValue keyword1;
	private TemplateValue keyword2;
	private TemplateValue keyword3;
	private TemplateValue keyword4;
	private TemplateValue keyword5;
	private TemplateValue remark;

	public TemplateValue getFirst() {
		return first == null ? new TemplateValue() : first;
	}

	public void setFirst(String value, String color) {
		TemplateValue t = new TemplateValue();
		t.setValue(value);
		t.setColor(color);
		this.first = t;
	}

	public TemplateValue getKeyword1() {
		return keyword1;
	}

	public void setKeyword1(String value, String color) {
		TemplateValue t = new TemplateValue();
		t.setValue(value);
		t.setColor(color);
		this.keyword1 = t;
	}

	public TemplateValue getKeyword2() {
		return keyword2;
	}

	public void setKeyword2(String value, String color) {
		TemplateValue t = new TemplateValue();
		t.setValue(value);
		t.setColor(color);
		this.keyword2 = t;
	}

	public TemplateValue getKeyword3() {
		return keyword3;
	}

	public void setKeyword3(String value, String color) {
		TemplateValue t = new TemplateValue();
		t.setValue(value);
		t.setColor(color);
		this.keyword3 = t;
	}

	public TemplateValue getKeyword4() {
		return keyword4;
	}

	public void setKeyword4(String value, String color) {
		TemplateValue t = new TemplateValue();
		t.setValue(value);
		t.setColor(color);
		this.keyword4 = t;
	}

	public TemplateValue getKeyword5() {
		return keyword5;
	}

	public void setKeyword5(String value, String color) {
		TemplateValue t = new TemplateValue();
		t.setValue(value);
		t.setColor(color);
		this.keyword5 = t;
	}

	public TemplateValue getRemark() {
		return remark;
	}

	public void setRemark(String value, String color) {
		TemplateValue t = new TemplateValue();
		t.setValue(value);
		t.setColor(color);
		this.remark = t;
	}
}
