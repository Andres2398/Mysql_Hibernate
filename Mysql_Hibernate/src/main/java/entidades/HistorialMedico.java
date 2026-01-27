package entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "historial_medico")
public class HistorialMedico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHistorial;

    private String tipoSangre;
    private String alergias;

    @OneToOne
    @JoinColumn(name = "id_paciente", unique = true)
    private Paciente paciente;

    // Constructor vacío
    public HistorialMedico() {
    }

    // Constructor con parámetros
    public HistorialMedico(String tipoSangre, String alergias) {
        this.tipoSangre = tipoSangre;
        this.alergias = alergias;
    }

    // Getters y Setters
    public Long getIdHistorial() {
        return idHistorial;
    }

    public void setIdHistorial(Long idHistorial) {
        this.idHistorial = idHistorial;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}
