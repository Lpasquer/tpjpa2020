package kanban;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;



@Entity
public class Fiche {

	private long id;
	private String libelle;
	private String date_butoire;
	private Utilisateur user;
	private int time;
	private List<Tag> tags = new ArrayList<Tag> ();
	private String lieu;
	private String url;
	private String notes;
	
	public Fiche() {}
	
	public Fiche(String libelle, String i, Utilisateur user, int time, String lieu,
			String url, String notes) {
		this.libelle = libelle;
		this.date_butoire = i;
		this.user = user;
		this.time = time;
		this.lieu = lieu;
		this.url = url;
		this.notes = notes;
	}
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getDate_butoire() {
		return date_butoire;
	}
	public void setDate_butoire(String date_butoire) {
		this.date_butoire = date_butoire;
	}
	
	@ManyToOne
	public Utilisateur getUser() {
		return user;
	}
	public void setUser(Utilisateur user) {
		this.user = user;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	
	@ManyToMany
	public List<Tag> getTags() {
		return tags;
	}
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	
	
}
