import java.util.HashMap;

public class Empresa {
    private String nombre;
    private double facturacionEmpresa;
    private HashMap<String, Concesionario> grupo;

    // Constructor: Inicializa nombre y facturacionEmpresa en 0
    public Empresa(String nombre) {
        this.nombre = nombre;
        this.facturacionEmpresa = 0;
        this.grupo = new HashMap<>();
    }

    // Método para crear una nueva sede con un concesionario
    public void crearSede(String ciudad, int tamanoMaximo) {
        if (!grupo.containsKey(ciudad)) {
            Concesionario concesionario = new Concesionario(tamanoMaximo);
            grupo.put(ciudad, concesionario);
            System.out.println("Sede creada en la ciudad: " + ciudad);
        } else {
            System.out.println("Ya existe una sede en esta ciudad.");
        }
    }

    // Método para calcular la facturación total de todos los concesionarios
    public void facturacionTotal() {
        double total = 0;
        for (Concesionario concesionario : grupo.values()) {
            total += concesionario.getFacturacionLocal();
        }
        facturacionEmpresa = total;
    }

    // Getters y Setters
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

    public HashMap<String, Concesionario> getGrupo() {
        return grupo;
    }

    public void setGrupo(HashMap<String, Concesionario> grupo) {
        this.grupo = grupo;
    }
}
