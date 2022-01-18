import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class ControlMascotas {
	Map<Integer,Mascota> mapMascotas = new TreeMap<Integer,Mascota>();
	static int contador=1;
	

	
	public Integer agregarMascota(String nombre,String raza, int edad) {
		Mascota nuevaMasc = new Mascota(nombre,raza,edad,contador);
		mapMascotas.put(contador, nuevaMasc);
		contador++;
		return nuevaMasc.getNroMascota();
	}
	
	//Buscar una mascota por su número:
	public Mascota buscarMascota(Integer nroMascota) {
		Mascota mascBuscada = mapMascotas.get(nroMascota);
		return mascBuscada;
	}
	
	//Listado de las claves (nros de ingreso)
		public ArrayList<String> listadoClaves() {
			ArrayList<String> clavesTXT = new ArrayList<String>();
			for (Iterator<Integer> it = mapMascotas.keySet().iterator(); it.hasNext(); ) {
				Integer clave = (Integer) it.next();
				clavesTXT.add(clave.toString());
			}
			return clavesTXT;
		}
	
	
	//listado de los datos (datos de las mascotas)
	public ArrayList<String> listadoObjetos() {
		ArrayList<String> objetosTXT = new ArrayList<String>();
		for (Iterator<Mascota> it = mapMascotas.values().iterator();it.hasNext(); ) {
			Mascota masc = (Mascota) it.next();
			objetosTXT.add(masc.toString()+"\n");
		}
		return objetosTXT;
	}
	
	//Listado de claves y valores (Entry)
	public ArrayList<String> listClaveValor() {
		ArrayList<String> listClaveValor = new ArrayList<String>();
		Iterator<Entry<Integer, Mascota>> it=mapMascotas.entrySet().iterator();
		while(it.hasNext()) {
			Map.Entry<Integer, Mascota> entry = (Entry<Integer, Mascota>)it.next();
			listClaveValor.add("Entry: "+entry.getKey().toString()+" = "+entry.getValue().toString()+"\n");
			contador++;
		}
		return listClaveValor;
	}

	public Map<Integer, Mascota> getMapMascotas() {
		return mapMascotas;
	}

	public void setMapMascotas(Map<Integer, Mascota> mapMascotas) {
		this.mapMascotas = mapMascotas;
	}
}
