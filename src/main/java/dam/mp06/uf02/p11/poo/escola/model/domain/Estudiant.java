package dam.mp06.uf02.p11.poo.escola.model.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="Estudiants")
public class Estudiant extends Persona {
	
	@Column(name="Curs", length=50, unique=false, nullable=true)
	private int curs;

	public int getCurs() {
		return curs;
	}

	public void setCurs(int curs) {
		this.curs = curs;
	}


}
