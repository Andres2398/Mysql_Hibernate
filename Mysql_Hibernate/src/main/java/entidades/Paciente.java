package entidades;

import jakarta.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "paciente")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPaciente;

    private String nombre;
    
    private String usuario;
    
    private String contraseña;
    
    private double precio;
    
    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;

    @OneToOne(mappedBy = "paciente", cascade = CascadeType.ALL)
    private HistorialMedico historialMedico;

    @ManyToMany
    @JoinTable(
        name = "paciente_doctor",
        joinColumns = @JoinColumn(name = "id_paciente"),
        inverseJoinColumns = @JoinColumn(name = "id_doctor")
    )
    private Set<Doctor> doctores;

    // Constructor vacío (obligatorio)
    public Paciente() {
    }

    // Constructor con parámetros
    public Paciente(String nombre, Date fechaNacimiento) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
    }

    // Getters y Setters
    public Long getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Long idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public HistorialMedico getHistorialMedico() {
        return historialMedico;
    }

    public void setHistorialMedico(HistorialMedico historialMedico) {
        this.historialMedico = historialMedico;
    }

    public Set<Doctor> getDoctores() {
        return doctores;
    }

    public void setDoctores(Set<Doctor> doctores) {
        this.doctores = doctores;
    }
}
