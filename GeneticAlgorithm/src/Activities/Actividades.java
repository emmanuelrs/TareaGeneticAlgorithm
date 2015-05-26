/**
 * 
 */
package Activities;

/**
 * @author Emmanuel Rosales Salas
 *Carnet: 2013108931
 */
public class Actividades {
	
	private String nombre;
	private Integer horaInicio;
	private Integer horaFinaliza;
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(Integer horaInicio) {
		this.horaInicio = horaInicio;
	}
	public Integer getHoraFinaliza() {
		return horaFinaliza;
	}
	public void setHoraFinaliza(Integer horaFinaliza) {
		this.horaFinaliza = horaFinaliza;
	}
	public Actividades(String pNombre, Integer pInicio, Integer pFinaliza) {
		// TODO Auto-generated constructor stub
		setNombre(pNombre);
		setHoraInicio(pInicio);
		setHoraFinaliza(pFinaliza);
	}

}
