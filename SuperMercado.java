import java.util.Scanner;
public class SuperMercado {
    public static void showMenu(){
        System.out.println();
        System.out.println("1. Determinar el precio por Producto");
        System.out.println("2. Determinar el precio por Producto y día ingresado");
        System.out.println("3. Fin");
        System.out.print("¿Opción deseada (1-3) ? ");
    }
    public static double  calculaPrecio (String producto ){
        double precioProducto =0 ;

        switch (producto.toUpperCase()){
            case "ARROZ":
                precioProducto = 50 ;
                break;
            case "AZUCAR":
                precioProducto = 120 ;
                break;
            case "CAFE":
                precioProducto = 90 ;
                break;
        }
        return precioProducto;
    }
    public static Double  calculaPrecioPorDia (String producto ,Integer Dia){
        Double precioDia = 0.0;
        Double precioProducto = 0.0;

        precioProducto = calculaPrecio(producto);

        if (producto.toUpperCase().equals("ARROZ")) {
            if (Dia >= 1 && Dia <= 7) {
                precioDia = precioProducto - (10 * precioProducto / 100);
            } else if (Dia >= 8 && Dia <= 14) {
                precioDia =  precioProducto - (5 * precioProducto / 100);
            } else if (Dia >= 15 && Dia <= 21) {
                precioDia = precioProducto - (8 * precioProducto / 100);
            } else if (Dia >= 22 && Dia <= 30) {
                precioDia = precioProducto - (20 * precioProducto / 100);
            }
        } else if (producto.toUpperCase().equals("AZUCAR")) {
            if (Dia >= 1 && Dia <= 7) {
                precioDia = precioProducto - (8 * precioProducto / 100);
            } else if (Dia >= 8 && Dia <= 14) {
                precioDia = precioProducto - (12 * precioProducto / 100);
            } else if (Dia >= 15 && Dia <= 21) {
                precioDia =  precioProducto - (10 * precioProducto / 100);
            } else if (Dia >= 22 && Dia <= 30) {
                precioDia = precioProducto - (15 * precioProducto / 100);
            }
        } else if (producto.toUpperCase().equals("CAFE")) {
            if (Dia >= 1 && Dia <= 7) {
                precioDia = precioProducto - (5 * precioProducto / 100);
            } else if (Dia >= 8 && Dia <= 14) {
                precioDia = precioProducto - (8 * precioProducto / 100);
            } else if (Dia >= 15 && Dia <= 21) {
                precioDia =  precioProducto - (5 * precioProducto / 100);
            } else if (Dia >= 22 && Dia <= 30) {
                precioDia =  precioProducto - (18 * precioProducto / 100);
            }
        }
        return precioDia;
    }

    public static boolean validaProducto(String producto){
        //Negamos la condición
        if (!producto.toUpperCase().equals("ARROZ") && !producto.toUpperCase().equals("AZUCAR") && !producto.toUpperCase().equals("CAFE")) {
            return false;
        }
        return true;
    }
    public static boolean validaDia(int dia){
        if ( !(dia >= 1 && dia <= 30) ) {
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double precioProducto;
        double PrecioProducotDia;
        Integer opcion, dia;
        String producto;
        do {
            showMenu();
            Scanner menu = new Scanner(System.in);
            opcion = menu.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el producto : ");
                    producto = sc.next();
                    if (!validaProducto(producto)) {
                        System.out.println("El producto ingresado no es válido");
                        break;
                    };
                    precioProducto = calculaPrecio(producto);
                    System.out.println("El Precio del producto ingresado es :" + precioProducto);
                    break;
                case 2:
                    System.out.print("Ingrese el producto : ");
                    producto = sc.next();
                    if (!validaProducto(producto)) {
                        System.out.println("El producto ingresado no es válido");
                        break;
                    };
                    System.out.print("Ingrese el numero de día entre rango del [1..30]: ");
                    dia = sc.nextInt();
                    if (!validaDia(dia)) {
                        System.out.println("El día ingresado debe estar en el rango de 1 a 30.");
                        break;
                    }
                    ;
                    PrecioProducotDia = calculaPrecioPorDia(producto, dia);
                    System.out.println("El Total a pagar por el producto " + producto + " al día " + dia +
                            "  es: " + PrecioProducotDia);
                    break;
                case 3:
                    System.out.println("Saliendo de opciones!");
                    break;
                default:
                    System.out.println("Opción debe ser de 1 a 3");
                    break;
            }
        } while (opcion != 3);
    }


}
