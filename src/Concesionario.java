import java.util.ArrayList;
import java.util.List;

public class Concesionario {
    private final int tamanyo;
    private double facturacionLocal;
    private ArrayList<Coche> listadoCoches;

    public Concesionario(int tamanyo) {
        this.tamanyo = tamanyo;
        this.facturacionLocal = 0;
        this.listadoCoches = new ArrayList<>();
    }

    public void adquirirCoche(Coche coche) {
        if (listadoCoches.size() < tamanyo) {
            listadoCoches.add(coche);
        } else {
            System.out.println("Concesionario lleno, no se puede introducir el coche");
        }
    }

    public void venderCoche(String matricula) {
        Coche cocheVendido = null;
        for (Coche coche : listadoCoches) {
            if (coche.getMatricula().equals(matricula)) {
                cocheVendido = coche;
                break;
            }
        }
        if (cocheVendido != null) {
            listadoCoches.remove(cocheVendido);
            facturacionLocal += cocheVendido.getPrecio();
        }
    }
    public ArrayList<Coche> buscarMarca(String marca){
        ArrayList<Coche> resultado = new ArrayList<>();
        for (Coche coche : listadoCoches) {
            if (coche.getMarca().equalsIgnoreCase(marca)) {
                resultado.add(coche);
            }
        }
        return resultado;
    }
    public ArrayList<Coche> buscarModelo(String modelo){
        ArrayList<Coche> resultado = new ArrayList<>();
        for (Coche coche : listadoCoches) {
            if (coche.getModelo().equalsIgnoreCase(modelo)) {
                resultado.add(coche);
            }
        }
        return resultado;
    }

    public double getFacturacionLocal() {
        return facturacionLocal;
    }

    public List<Coche> getListadoCoches() {
        return listadoCoches;
    }

    @Override
    public String toString() {
        return "Concesionario{" +
                "facturacionLocal=" + facturacionLocal +
                ", listadoCoches=" + listadoCoches +
                '}';
    }
}
