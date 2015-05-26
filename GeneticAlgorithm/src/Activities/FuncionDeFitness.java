package Activities;

import java.util.Hashtable;

public class FuncionDeFitness {

    static byte[] solucion = new byte[64];
    
    static Integer [][] actividades = {{1,3},{2,5},{2,7},{5,6},{7,8},{9,11},{12,14},{11,18},{15,16},{17,20},{21,22},{23,24},{22,23},{22,23},{12,14}};
    

    // Establecer una solucion candidata como un arreglo de bytes
    public static void establecerSolucion(byte[] nuevaSolucion) {
    	Hashtable<Integer, Integer> actividad = new Hashtable<Integer, Integer>();
    	actividad.put(1,3);
    	actividad.put(2,5);
    	actividad.put(2,7);
    	actividad.put(5,6);
    	actividad.put(7,8);
    	actividad.put(9,11);
    	actividad.put(12,14);
    	actividad.put(15,18);
        solucion = nuevaSolucion;
    }

    static void establecerSolucion(String nuevaSolucion) {
    	
        solucion = new byte[nuevaSolucion.length()];
        for (int i = 0; i < nuevaSolucion.length(); i++) {
            String caracter = nuevaSolucion.substring(i, i + 1);
            if (caracter.contains("0") || caracter.contains("1")) {
                solucion[i] = Byte.parseByte(caracter);
            } else {
                solucion[i] = 0;
            }
        }
    }

    // Calculate inidividuals fittness by comparing it to our candidate solution
    
    static int obtenerFitness(Individuo individuo) {
    	
        int fitness = 0;
        
        int estadoAnterior = 0; // Esta variable guarda la posición de la actividad anterior, 
        						//es decir guarda la última actividad que se eligió
        
        for(int i = 0; i < actividades.length; i++){
        	if(individuo.obtenerGen(i)== 1){ //Busca los genes que tengan 1 ya que se toman como a las actividades que puede asistir
        		if(estadoAnterior == 0){ // si el estadoAnterior está en 0 quiere decir que no ha asistido a ningua actividad
        			fitness ++;         // lo cual se le asigna la posición del primer 1 y se suma 1 al fitness
        			estadoAnterior = i;
        		}
        		else if (actividades[i][0] > actividades[estadoAnterior][1]){ // revisa que la actividad anterior no choque con la nueva actividad
        			fitness ++;
        			estadoAnterior = i; // Se asigna como actividad anterior para probar el siguiente
        		}
        		else{
        			fitness = 0; // si alguna actidad hace conflicto se le asiga 0 al fitness y mata el ciclo.
        			break;
        		}
        		
        	}
        }
        
        // Iterar por todos los genes del individuo y compararlo
        // con los de nuestro candidato.
        /*
        for (int i = 0; i < individuo.tamanno() && i < solucion.length; i++) {
            if (individuo.obtenerGen(i) == solucion[i]) {
                fitness++;
            }
        }*/
        return fitness;
    }
    
    // Obtener el fitness optimo
    static int obtenerMaxFitness() {
        int maxFitness = solucion.length;
        return maxFitness;
    }
}