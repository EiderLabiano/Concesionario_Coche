import java.util.ArrayList;

public class Coche {
    private String marca;
    private String modelo;
    private String matricula;
    private int anyo;
    private double precio;
    private double kms;
    public Coche(String marca, String modelo, String matricula, int anyo, double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
        this.anyo = anyo;
        this.precio = precio;
        this.kms = 0;
    }
    public void Descuento(int valor){
        if (valor < 1 || valor > 50)
        {
            System.out.println("ERROR: Debe especificar un valor entre 1 y 50");
        }
        else {
            precio -= precio * valor/100;
        }
    }

    public String getMatricula() {
        return matricula;
    }

    public double getPrecio() {
        return precio;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    @Override
    public String toString() {
        return "Coche{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", matricula='" + matricula + '\'' +
                ", anyo=" + anyo +
                ", precio=" + precio +
                ", kms=" + kms +
                '}';
    }
}
