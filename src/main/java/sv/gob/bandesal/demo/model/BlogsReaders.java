package sv.gob.bandesal.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(BlogsReadersId.class)
public class BlogsReaders {
	
	@Id
	@Column(name = "R_ID")
	private Integer rId;
	
	@Id
	@Column(name = "B_ID")
	private Integer bId;

	@Override
	public String toString() {
		return "BlogsReaders [rId=" + rId + ", bId=" + bId + "]";
	}

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
