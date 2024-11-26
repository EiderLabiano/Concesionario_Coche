import java.util.HashMap;

public class Empresa {
    private String nombre;
    private double facturacionEmpresa;
    private HashMap<String, Concesionario> grupo;

    public Empresa(String nombre) {
        this.nombre = nombre;
        this.facturacionEmpresa = 0;
        this.grupo = new HashMap<>();
    }

    public void crearSede(String ciudad, int tamanyo) {
        if (!grupo.containsKey(ciudad)) {
            Concesionario concesionario = new Concesionario(tamanyo);
            grupo.put(ciudad, concesionario);
            System.out.println("Sede creada en la ciudad: " + ciudad);
        } else {
            System.out.println("Ya existe una sede en esta ciudad.");
        }
    }

    public void facturacionTotal() {
        double total = 0;
        for (Concesionario concesionario : grupo.values()) {
            total += concesionario.getFacturacionLocal();
        }
        facturacionEmpresa = total;
    }

    public Concesionario getConcesionario(String ciudad) {
        return grupo.get(ciudad);
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "nombre='" + nombre + '\'' +
                ", facturacionEmpresa=" + facturacionEmpresa +
                ", grupo=" + grupo +
                '}';
    }
}
