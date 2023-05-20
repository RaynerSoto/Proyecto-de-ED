package Trabajo_Guardar_Cargar;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Iterator;

import Logica.Compañia;
import Logica.Juegos;
import Logica.Persona;

public class Manejo_Fichero {
	Compañia comp = new Compañia("");
	
	public void guardar_archivos(Compañia comp,File file) throws IOException, NullPointerException {
		try {
			if(file.exists()) {
				file.delete();
			}
			file.createNewFile();
			RandomAccessFile raf = new RandomAccessFile(file, "rw");
			byte []arr;
			arr = Convert.toBytes(comp.getNombre());
			raf.writeInt(arr.length);
			raf.write(arr);
			if(comp.getPresidente() != null) 
			{
				raf.writeBoolean(true);
				arr = Convert.toBytes(comp.getPresidente());
				raf.writeInt(arr.length);
				raf.write(arr);
			}
			else {
				raf.writeBoolean(false);
			}
			if(comp.getVicepresindete() != null) {
				raf.writeBoolean(true);
				arr = Convert.toBytes(comp.getVicepresindete());
				raf.writeInt(arr.length);
				raf.write(arr);
			}
			else {
				raf.writeBoolean(false);
			}
			raf.writeInt(comp.Trabajadores.size());
			for(int contador = 0; contador<comp.Trabajadores.size();contador++) {
				arr = Convert.toBytes(comp.getTrabajadores().get(contador));
				raf.writeInt(arr.length);
				raf.write(arr);
			}
			raf.writeInt(comp.Videojuegos.size());
				Iterator<Juegos>juegos = comp.Videojuegos.iterator();
				Juegos jue = null;
				while(juegos.hasNext()) {
					jue = juegos.next();
					arr = Convert.toBytes(jue);
					raf.writeInt(arr.length);
					raf.write(arr);
				}
			raf.close();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public void cargar_archivos_sinsobrescribir(File file, Compañia compa) {
		try {
			if(file.exists()) {
				this.comp = compa;
				RandomAccessFile raf = new RandomAccessFile(file, "r");
				byte[]arr;
				int cantidad = raf.readInt();
				arr = new byte[cantidad];
				raf.read(arr);
				String nombre = (String)Convert.toObject(arr);
				comp.setNombre(nombre);
				boolean verdad = raf.readBoolean();
				if(verdad == true){
					cantidad = raf.readInt();
					arr = new byte[cantidad];
					raf.read(arr);
					Persona person = (Persona)Convert.toObject(arr);
					comp.setPresidente(person);
				}
				verdad = raf.readBoolean();
				if(verdad == true) {
					cantidad = raf.readInt();
					arr = new byte[cantidad];
					raf.read(arr);
					Persona person = (Persona)Convert.toObject(arr);	
					comp.setVicepresindete(person);
				}
				cantidad = raf.readInt();
				for(int contador = 0 ; contador < cantidad ;contador ++) {
					int valor = raf.readInt();
					arr = new byte[valor];
					raf.read(arr);
					comp.Trabajadores.add((Persona)Convert.toObject(arr));
				}
				cantidad = raf.readInt();
				for(int contador = 0; contador < cantidad ; contador++) {
					int valor = raf.readInt();
					arr = new byte[valor];
					raf.read(arr);
					comp.Videojuegos.addLast((Juegos)Convert.toObject(arr));
				}
				raf.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public Compañia cargar_archivos_sobrescribir(File file) {
		try {
			if(file.exists()) {
				RandomAccessFile raf = new RandomAccessFile(file, "r");
				byte[]arr;
				int cantidad = raf.readInt();
				arr = new byte[cantidad];
				raf.read(arr);
				String nombre = (String)Convert.toObject(arr);
				comp.setNombre(nombre);
				boolean verdad = raf.readBoolean();
				if(verdad == true){
					cantidad = raf.readInt();
					arr = new byte[cantidad];
					raf.read(arr);
					Persona person = (Persona)Convert.toObject(arr);
					comp.setPresidente(person);
				}
				verdad = raf.readBoolean();
				if(verdad == true) {
					cantidad = raf.readInt();
					arr = new byte[cantidad];
					raf.read(arr);
					Persona person = (Persona)Convert.toObject(arr);	
					comp.setVicepresindete(person);
				}
				cantidad = raf.readInt();
				for(int contador = 0 ; contador < cantidad ;contador ++) {
					int valor = raf.readInt();
					arr = new byte[valor];
					raf.read(arr);
					comp.Trabajadores.add((Persona)Convert.toObject(arr));
				}
				cantidad = raf.readInt();
				for(int contador = 0; contador < cantidad ; contador++) {
					int valor = raf.readInt();
					arr = new byte[valor];
					raf.read(arr);
					comp.Videojuegos.addLast((Juegos)Convert.toObject(arr));
				}
				raf.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return comp;
	}
}
