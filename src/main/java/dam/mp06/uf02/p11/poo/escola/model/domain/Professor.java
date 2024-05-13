package dam.mp06.uf02.p11.poo.escola.model.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="Professors")
public class Professor extends Persona {

	@Column(name="Especialitat", length=50, unique=false, nullable=true)
	private String especialitat;

	public String getEspecialitat() {
		return especialitat;
	}

	public void setEspecialitat(String especialitat) {
		this.especialitat = especialitat;
	}

}
