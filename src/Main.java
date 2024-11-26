import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Empresa empresa = new Empresa("AutoGroup");

        cargarDatos(empresa);

        boolean salir = false;
        while (!salir) {
            mostrarMenu();
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    crearSede(scanner, empresa);
                    break;
                case 2:
                    introducirCoche(scanner, empresa);
                    break;
                case 3:
                    venderCoche(scanner, empresa);
                    break;
                case 4:
                    buscarPorMarca(scanner, empresa);
                    break;
                case 5:
                    buscarPorModelo(scanner, empresa);
                    break;
                case 6:
                    mostrarListadoCoches(scanner, empresa);
                    break;
                case 7:
                    salir = true;
                    break;
            }
        }
        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\nMenú:");
        System.out.println("1- Crear nueva sede");
        System.out.println("2- Introducir coche en una sede");
        System.out.println("3- Vender coche");
        System.out.println("4- Buscar coches por marca");
        System.out.println("5- Buscar coches por modelo");
        System.out.println("6- Mostrar listado de coches por concesionario");
        System.out.println("7- Salir");
    }

    private static void crearSede(Scanner scanner, Empresa empresa) {
        System.out.print("Introduzca el nombre de la ciudad: ");
        String ciudad = scanner.next();
        System.out.print("Introduzca el tamaño máximo del concesionario: ");
        int tamanyo = scanner.nextInt();
        empresa.crearSede(ciudad, tamanyo);
    }

    private static void introducirCoche(Scanner scanner, Empresa empresa) {
        System.out.print("Introduzca la sede: ");
        String sede = scanner.next();
        Concesionario concesionario = empresa.getConcesionario(sede);
        if (concesionario != null) {
            System.out.print("Marca: ");
            String marca = scanner.next();
            System.out.print("Modelo: ");
            String modelo = scanner.next();
            System.out.print("Matrícula: ");
            String matricula = scanner.next();
            System.out.print("Año: ");
            int anyo = scanner.nextInt();
            System.out.print("Precio: ");
            double precio = scanner.nextDouble();
            System.out.print("Kms: ");
            int kms = scanner.nextInt();

            Coche coche = new Coche(marca, modelo, matricula, anyo, precio, kms);
            concesionario.adquirirCoche(coche);
        } else {
            System.out.println("ERROR: La sede no existe.");
        }
    }

    private static void venderCoche(Scanner scanner, Empresa empresa) {
        System.out.print("Introduzca la sede: ");
        String sede = scanner.next();
        Concesionario concesionario = empresa.getConcesionario(sede);
        if (concesionario != null) {
            System.out.print("Introduzca la matrícula del coche: ");
            String matricula = scanner.next();
            concesionario.venderCoche(matricula);
        } else {
            System.out.println("ERROR: La sede no existe.");
        }
    }

    private static void buscarPorMarca(Scanner scanner, Empresa empresa) {
        System.out.print("Introduzca la marca: ");
        String marca = scanner.next();
        empresa.getGrupo().forEach((ciudad, concesionario) -> {
            List<Coche> resultado = concesionario.buscarMarca(marca);
            mostrarResultadosBusqueda(resultado, ciudad);
        });
    }

    private static void buscarPorModelo(Scanner scanner, Empresa empresa) {
        System.out.print("Introduzca el modelo: ");
        String modelo = scanner.next();
        empresa.getGrupo().forEach((ciudad, concesionario) -> {
            List<Coche> resultado = concesionario.buscarModelo(modelo);
            mostrarResultadosBusqueda(resultado, ciudad);
        });
    }

    private static void mostrarResultadosBusqueda(List<Coche> resultado, String ciudad) {
        System.out.println(resultado.size() + " coincidencia(s) en " + ciudad + ":");
        if (resultado.isEmpty()) {
            System.out.println("No hay coches que coincidan.");
        } else {
            resultado.forEach(coche -> {
                System.out.println("• " + coche.getMarca() + " " + coche.getModelo());
                System.out.println("• Kms: " + coche.getKms());
                System.out.println("• Precio: " + coche.getPrecio() + " €");
                System.out.println("• Año: " + coche.getAnyo());
                System.out.println("• Matrícula: " + coche.getMatricula());
                System.out.println("-------------------------------------------------------------------------------------");
            });
        }
        System.out.println("**************************************************************************");
    }

    private static void mostrarListadoCoches(Scanner scanner, Empresa empresa) {
        System.out.print("Introduzca la sede: ");
        String sede = scanner.next();
        Concesionario concesionario = empresa.getConcesionario(sede);
        if (concesionario != null) {
            System.out.println("Concesionario " + sede + ":");
            concesionario.getListadoCoches().forEach(coche -> {
                System.out.println("• " + coche.getMarca() + " " + coche.getModelo());
                System.out.println("• Kms: " + coche.getKms());
                System.out.println("• Precio: " + coche.getPrecio() + " €");
                System.out.println("• Año: " + coche.getAnyo());
                System.out.println("• Matrícula: " + coche.getMatricula());
                System.out.println("-------------------------------------------------------------------------------------");
            });
            System.out.println("**************************************************************************");
        } else {
            System.out.println("ERROR: La sede no existe.");
        }
    }

    public static void cargarDatos(Empresa empresa) {
        empresa.crearSede("Madrid", 3);
        Concesionario madrid = empresa.getConcesionario("Madrid");
        madrid.adquirirCoche(new Coche("Toyota", "Auris", "2465JHN", 2019, 12000, 55000));
        madrid.adquirirCoche(new Coche("Audi", "A3", "4386TGH", 2021, 16000, 87000));

        empresa.crearSede("Barcelona", 3);
        Concesionario barcelona = empresa.getConcesionario("Barcelona");
        barcelona.adquirirCoche(new Coche("Toyota", "Auris", "2465JHN", 2019, 12000, 55000));
        barcelona.adquirirCoche(new Coche("Audi", "A3", "4386TGH", 2021, 16000, 87000));
        barcelona.adquirirCoche(new Coche("Audi", "A3", "4386TGH", 2021, 16000, 87000));

        empresa.crearSede("Valencia", 3);

        System.out.println("Datos cargados.");
    }
}
