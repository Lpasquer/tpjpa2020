package kanban;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Tag {

	private long id;
	private String name;
	private List<Fiche> fiches = new ArrayList<Fiche>();

	public Tag(String name) {
		this.name = name;
	}
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@ManyToMany
	public List<Fiche> getFiches() {
		return fiches;
	}
	public void setFiches(List<Fiche> fiches) {
		this.fiches = fiches;
	}


}
