package sv.gob.bandesal.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Blogs {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_blogs")
	@SequenceGenerator(name = "seq_blogs", sequenceName = "SEQ_BLOGS", initialValue = 1, allocationSize = 1)
	private Integer id;
	private String title;
	private String description;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return title;
	}

}
