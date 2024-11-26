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

    public boolean crearSede(String ciudad, int tamanyo) {
        if (!grupo.containsKey(ciudad)) {
            grupo.put(ciudad, new Concesionario(tamanyo));
            return true;
        }
        System.out.println("ERROR: La sede ya existe.");
        return false;
    }

    public Concesionario getConcesionario(String ciudad) {
        return grupo.get(ciudad);
    }

    public void facturacionTotal() {
        facturacionEmpresa = grupo.values().stream()
                .mapToDouble(Concesionario::getFacturacionLocal)
                .sum();
    }

    public HashMap<String, Concesionario> getGrupo() {
        return grupo;
    }

    public double getFacturacionEmpresa() {
        return facturacionEmpresa;
    }
}
