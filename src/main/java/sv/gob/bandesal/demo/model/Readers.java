package sv.gob.bandesal.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Readers {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_readers")
	@SequenceGenerator(name = "seq_readers", sequenceName = "SEQ_READERS", allocationSize = 1, initialValue = 1)
	private Integer id;
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

}
