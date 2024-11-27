import java.util.ArrayList;

public class Concesionario {
    private final int tamanyo;
    private double facturacionLocal;
    private final ArrayList<Coche> listadoCoches;

    public Concesionario(int tamanyo) {
        this.tamanyo = tamanyo;
        this.facturacionLocal = 0;
        this.listadoCoches = new ArrayList<>();
    }

    public boolean adquirirCoche(Coche coche) {
        if (listadoCoches.size() < tamanyo) {
            listadoCoches.add(coche);
            return true;
        } else {
            System.out.println("Concesionario lleno, no se puede introducir el coche");
            return false;
        }
    }

    public boolean venderCoche(String matricula) {
        for (Coche coche : listadoCoches) {
            if (coche.getMatricula().equals(matricula)) {
                listadoCoches.remove(coche);
                facturacionLocal += coche.getPrecio();
                return true;
            }
        }
        System.out.println("ERROR: Matrícula no encontrada.");
        return false;
    }

    public ArrayList<Coche> buscarMarca(String marca) {
        ArrayList<Coche> resultados = new ArrayList<>();
        for (Coche coche : listadoCoches) {
            if (coche.getMarca().equalsIgnoreCase(marca)) {
                resultados.add(coche);
            }
        }
        return resultados;
    }

    public ArrayList<Coche> buscarModelo(String modelo) {
        ArrayList<Coche> resultados = new ArrayList<>();
        for (Coche coche : listadoCoches) {
            if (coche.getModelo().equalsIgnoreCase(modelo)) {
                resultados.add(coche);
            }
        }
        return resultados;
    }

    public ArrayList<Coche> getListadoCoches() {
        return listadoCoches;
    }

    public double getFacturacionLocal() {
        return facturacionLocal;
    }
}