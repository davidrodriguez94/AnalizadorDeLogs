import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

/**
 * Write a description of class AnalizadorAccesosAServidor here.
 *
 * @author (David Rodriguez)
 * @version (24/02/2018)
 */
public class AnalizadorAccesosAServidor
{
    // Array que guarda los logs
    private ArrayList <Acceso> accesos;
    /**
     * Constructor de la clase AnalizadorAccesosAServidor
     */
    public AnalizadorAccesosAServidor()
    {
        accesos = new ArrayList<>();
    }

    /**
     * Analiza el archivo de log
     */
    public void analizarArchivoDeLog(String archivo){ 
        accesos.clear();
        File archivoALeer = new File(archivo);
        try{
            Scanner sc = new Scanner(archivoALeer);
            while(sc.hasNextLine()){
                String lineaLeida = sc.nextLine();
                String[] accesosLinea = lineaLeida.split(" ");
                Acceso accesoActual = new Acceso(Integer.parseInt(accesosLinea[0]),
                                                 Integer.parseInt(accesosLinea[1]),
                                                 Integer.parseInt(accesosLinea[2]),
                                                 Integer.parseInt(accesosLinea[3]),
                                                 Integer.parseInt(accesosLinea[4]));
                accesos.add(accesoActual);
            }
            sc.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public int obtenerHoraMasAccesos(){
        int aDevolver = -1;
        if(accesos.size() > 0){
            int[] accesosPorHora = new int[24];
            for(Acceso accesoActual : accesos){
                int horaAccesoActual = accesoActual.getHora();
                accesosPorHora[horaAccesoActual] = accesosPorHora[horaAccesoActual]+1;
            }
            
            int numeroDeAccesosMasAlto = accesosPorHora[0];
            int horaDeAccessosMasAlto = 0;
            for(int i = 0; i < accesosPorHora.length; i++){
                if(accesosPorHora[i] >= numeroDeAccesosMasAlto){
                    numeroDeAccesosMasAlto = accesosPorHora[i];
                    horaDeAccessosMasAlto = i;
                }
            }
            aDevolver = horaDeAccessosMasAlto;
            System.out.println("Las horas con mas accesos son: " + aDevolver);
        }
        return aDevolver;
    }
}
