
package Activities;

/**
 * @author Emmanuel Rosales Salas
 * Carnet: 2013108931
 */
public class AG {

    public static void main(String[] args) {

        // Establecer una solucion candidata
        FuncionDeFitness.establecerSolucion("111111111111111");         
       // Crear una poblacion inicial
        Poblacion poblacion = new Poblacion(50, true);
        //FuncionDeFitness.imprimaLista();
        
        // Evolve our Poblacion until we reach an optimum solution
        int contadorDeGeneraciones = 0;
        while (poblacion.obtenerFittest().obtenerFitness() < 15 && contadorDeGeneraciones <= 100) { // detiene el while después de hacer 100 generaciones ya que
        																							// llegar a la solución optima es poco probrable en las actividades.
            contadorDeGeneraciones++;
            System.out.println("Generacion: " + contadorDeGeneraciones + " Mejor: " + poblacion.obtenerFittest().obtenerFitness());
            poblacion = Algoritmo.evolucionarPoblacion(poblacion);
            
        }
        System.out.println("Solucion encontrada!");
        System.out.println("Generacion: " + contadorDeGeneraciones);
        System.out.println("Genes:");
        System.out.println(poblacion.obtenerFittest());

    }
}