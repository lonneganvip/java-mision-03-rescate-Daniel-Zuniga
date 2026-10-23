import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char[][] estacion= new char [10][10];
        for (int fila = 0; fila < estacion.length; fila++) {
            for (int columna = 0; columna < estacion.length ; columna++) {
                estacion[fila][columna]='*';
            }
        }

        char ROBOT='R';
        estacion[0][0]=ROBOT;

        char META='M';
        estacion[9][9]=META;

        Random aleatorio= new Random();
        int n1= aleatorio.nextInt(10);
        int n2= aleatorio.nextInt(10);
        estacion[n1][n2]='B';

        for(int i = 0; i < 5; i++){
            do{
                n1= aleatorio.nextInt(10);
                n2= aleatorio.nextInt(10);
            } while(estacion[n1][n2]!='*');
            estacion[n1][n2]='X';
        }

        System.out.println("Tu robot se encuentra en la casilla 0,0");
        System.out.println("Te puedes desplazar con las letras W A S D");

        Scanner teclado = new Scanner(System.in);
        int vidas=10;
        int filaRobot=0;
        int columnaRobot=0;
        boolean printEstacion;
        estacion[filaRobot][columnaRobot] = ROBOT;
        do{
            System.out.println("Dime una letra: ");
            char desplazamiento = teclado.next().charAt(0);
            printEstacion = true;
            if(desplazamiento == 'D'){
                columnaRobot++;
            } else if(desplazamiento == 'S') {
                filaRobot++;
            }else if(desplazamiento == 'W') {
                filaRobot--;
            }else if(desplazamiento == 'A') {
                columnaRobot--;
            }else{
                System.out.println("LETRA INCORRECTA");
                continue;
            }

            if(filaRobot < 0 || filaRobot > 9 || columnaRobot < 0 || columnaRobot > 9){
                System.out.println("Fuera de límites !!!");
                printEstacion = false;
            }else{
                if(estacion[filaRobot][columnaRobot] == 'X'){
                    System.out.println("MOVIMIENTO BLOQUEADO");
                    if(desplazamiento == 'D'){
                        columnaRobot--;
                    }else if(desplazamiento == 'S') {
                        filaRobot--;
                    }else if(desplazamiento == 'W') {
                        filaRobot++;
                    }else if(desplazamiento == 'A') {
                        columnaRobot++;
                    }
                    continue;
                }
                if(estacion[filaRobot][columnaRobot] == 'B'){
                    vidas+=2;
                    System.out.println("GANAS 2 VIDAS");
                    if(desplazamiento == 'D'){
                        estacion[filaRobot][columnaRobot - 1] = '*';
                        estacion[filaRobot][columnaRobot] = ROBOT;
                    }else if(desplazamiento == 'S') {
                        estacion[filaRobot - 1][columnaRobot] = '*';
                        estacion[filaRobot][columnaRobot] = ROBOT;
                    }else if(desplazamiento == 'W') {
                        estacion[filaRobot + 1][columnaRobot] = '*';
                        estacion[filaRobot][columnaRobot] = ROBOT;
                    }else if(desplazamiento == 'A') {
                        estacion[filaRobot][columnaRobot + 1] = '*';
                        estacion[filaRobot][columnaRobot] = ROBOT;
                    }
                }
                if(estacion[filaRobot][columnaRobot] == 'M'){
                    break;
                }
                if(desplazamiento == 'D'){
                    estacion[filaRobot][columnaRobot - 1] = '*';
                    estacion[filaRobot][columnaRobot] = ROBOT;
                }else if(desplazamiento == 'S') {
                    estacion[filaRobot - 1][columnaRobot] = '*';
                    estacion[filaRobot][columnaRobot] = ROBOT;
                }else if(desplazamiento == 'W') {
                    estacion[filaRobot + 1][columnaRobot] = '*';
                    estacion[filaRobot][columnaRobot] = ROBOT;
                }else if(desplazamiento == 'A') {
                    estacion[filaRobot][columnaRobot + 1] = '*';
                    estacion[filaRobot][columnaRobot] = ROBOT;
                }
            }

            if(columnaRobot > 9){
                columnaRobot--;
            }else if(columnaRobot < 0){
                columnaRobot++;
            } else if (filaRobot > 9) {
                filaRobot--;
            } else if (filaRobot < 0) {
                filaRobot++;
            }

            if(printEstacion){
                for (int fila = 0; fila < estacion.length; fila++) {
                    for (int columna = 0; columna < estacion.length; columna++) {
                        System.out.print(estacion[fila][columna] + "  ");
                    }
                    System.out.println(" ");
                }
            }
        }while (true);
        System.out.println("RESCATE COMPLETADO");
        System.out.println("VIDAS FINALES: " +vidas);
    }
}
