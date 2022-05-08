package fes.aragon.modelo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Hoteles {
	private static Hoteles instancia=new Hoteles ();
	private ObservableList<Hotel> grupoHoteles=FXCollections.observableArrayList();
	private boolean modificarHotel=false;
	private int indice=-1;
	private int indiceHabitacion=-1;
	private Hoteles () {
		Hotel h=new Hotel();
		h.setNombre("dato1");
		h.setDireccion("dato2");
		h.setCorreo("demo@demo.com");
		h.setTelefono("32342342");
		Gerente g=new Gerente();
		g.setNombre("Raul");
		g.setApellidoPaterno("Demo");
		g.setApellidoMaterno("Demo");
		g.setCorreo("ikki@ikki.com");
		g.setRfc("dedadsadweasde");
		g.setTelefono("55555555");
		h.setGerente(g);
		Habitacion hab=new Habitacion();
		hab.setNumero("A1");
		hab.setCosto(23.23f);
		hab.setRefrigerador(true);
		hab.setTipo("mixto");
		h.getHabitaciones().add(hab);
		this.grupoHoteles.add(h);
		
	}
	public static Hoteles getInstancia() {
		return instancia;
	}
	public boolean isModificarHotel() {
		return modificarHotel;
	}
	public void setModificarHotel(boolean modificarHotel) {
		this.modificarHotel = modificarHotel;
	}
	public int getIndice() {
		return indice;
	}
	public void setIndice(int indice) {
		this.indice = indice;
	}
	public int getIndiceHabitacion() {
		return indiceHabitacion;
	}
	public void setIndiceHabitacion(int indiceHabitacion) {
		this.indiceHabitacion = indiceHabitacion;
	}
	public ObservableList<Hotel> getGrupoHoteles() {
		return grupoHoteles;
	}
	
	

}
