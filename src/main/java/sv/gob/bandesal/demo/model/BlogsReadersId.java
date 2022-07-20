package sv.gob.bandesal.demo.model;

import java.io.Serializable;

public class BlogsReadersId implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer rId;
	private Integer bId;
	
	public Integer getrId() {
		return rId;
	}
	public void setrId(Integer rId) {
		this.rId = rId;
	}
	public Integer getbId() {
		return bId;
	}
	public void setbId(Integer bId) {
		this.bId = bId;
	}
	
}
