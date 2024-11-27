public class Coche {
    private String marca;
    private String modelo;
    private String matricula;
    private int anyo;
    private double precio;
    private double kms;

    public Coche(String marca, String modelo, String matricula, int anyo, double precio, double kms) {
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
        this.anyo = anyo;
        this.precio = precio;
        this.kms = kms;
    }

    public void Descuento(int porcentaje) {
        if (porcentaje < 1 || porcentaje > 50) {
            System.out.println("ERROR: Debe especificar un valor entre 1 y 50");
        } else {
            this.precio -= this.precio * porcentaje / 100.0;
        }
    }

    @Override
    public String toString() {
        return "• " + marca + " " + modelo + "\n" +
                "• Kms: " + kms + "\n" +
                "• Precio: " + String.format("%.2f", precio) + " €\n" +
                "• Año: " + anyo + "\n" +
                "• Matrícula: " + matricula;
    }

    public String getMarca() {
        return marca;
    }
    public String getModelo() {
        return modelo;
    }
    public String getMatricula() {
        return matricula;
    }
    public double getPrecio() {
        return precio;
    }
    public double getKms() {
        return kms;
    }
    public int getAnyo() {
        return anyo;
    }
}