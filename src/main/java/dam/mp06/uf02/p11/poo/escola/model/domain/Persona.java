package dam.mp06.uf02.p11.poo.escola.model.domain;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name="Persones")
public class Persona {

	@Id
	@Column(name="PK_Persona_Id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="Nom", length=50, unique=false, nullable=false)
	private String nom;
	
	@Column(name="Cognoms", length=100, unique=false, nullable=false)
	private String cognoms;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCognoms() {
		return cognoms;
	}

	public void setCognoms(String cognoms) {
		this.cognoms = cognoms;
	}

	

}
