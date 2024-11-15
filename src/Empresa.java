import javax.swing.text.Keymap;
import java.util.HashMap;
import java.util.Map;

public class Empresa {
    private String nombre; // Nombre de la empresa
    private double facturacionEmpresa; // Dinero vendido
    private Map<String, Concesionario> grupo; // KeyMap con sede (ciudad) y concesionario

    public Empresa(String nombre) {
        this.nombre = nombre;
        this.facturacionEmpresa = 0.0;
        this.grupo = new HashMap<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getFacturacionEmpresa() {
        return facturacionEmpresa;
    }

    public void setFacturacionEmpresa(double facturacionEmpresa) {
        this.facturacionEmpresa = facturacionEmpresa;
    }

    public Map<String, Concesionario> getGrupo() {
        return grupo;
    }

    public void agregarConcesionario(String ciudad, Concesionario concesionario) {
        grupo.put(ciudad, concesionario);
    }

    public Concesionario obtenerConcesionario(String ciudad) {
        return grupo.get(ciudad);
    }

    public void incrementarFacturacion(double monto) {
        this.facturacionEmpresa += monto;
    }
}
