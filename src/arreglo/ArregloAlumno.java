package arreglo;
import java.util.ArrayList;
import clase.Alumno;

public class ArregloAlumno {
	
	//declaramos el atributo privado alu tipo Arraylist
	private ArrayList<Alumno> alu;
	
	//CONSTRUCTOR
	public ArregloAlumno(){
		alu = new ArrayList<Alumno>(); //crear el ArrayList llamdo 'alu'
		
	}
	
	//operacionesp publicas basicas
	public void adicionar(Alumno x){
		alu.add(x);
	}
	
	public int tamanio(){
		return alu.size();
	}
	
	public Alumno obtener(int i){
		return alu.get(i);
	}
}
