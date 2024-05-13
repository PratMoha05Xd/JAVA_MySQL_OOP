package dam.mp06.uf02.p11.poo.escola.model.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="Administratius")
public class Administratiu extends Persona {

    @Column(name="anysExperiencia", length=50, unique=false, nullable=true)
    private int anysExperiencia;

    public int getAnysExperiencia() {
        return anysExperiencia;
    }

    public void setAnysExperiencia(int anysExperiencia) {
        this.anysExperiencia = anysExperiencia;
    }


}
