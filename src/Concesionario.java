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

    public int getTamanyo() {
        return tamanyo;
    }

    public double getFacturacionLocal() {
        return facturacionLocal;
    }

    public List<Coche> getListadoCoches() {
        return listadoCoches;
    }
}
