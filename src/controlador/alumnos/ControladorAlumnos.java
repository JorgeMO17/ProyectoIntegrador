package controlador.alumnos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import accesoDB.AlumnoPersistencia;
import accesoDB.AreaPersistencia;
import vista.alumno.AltaAlumnos;
import vista.alumno.BajaAlumnos;
import vista.alumno.ConsultaAlumnos;
import vista.alumno.ModificacionAlumnos;


public class ControladorAlumnos implements ActionListener{
	
	private AltaAlumnos altaAL;
	private BajaAlumnos bajaAL;
	private ConsultaAlumnos consultaAL;
	private ModificacionAlumnos modificacionAL;
	private AlumnoPersistencia ap;
	
	
	public ControladorAlumnos() {}
	
	
	public void setAltaAL(AltaAlumnos altaAL) {
		this.altaAL = altaAL;
		ap = new AlumnoPersistencia();
	}


	public void setBajaAL(BajaAlumnos bajaAL) {
		this.bajaAL = bajaAL;
		ap = new AlumnoPersistencia();

	}


	public void setConsultaAL(ConsultaAlumnos consultaAL) {
		this.consultaAL = consultaAL;
		ap = new AlumnoPersistencia();

	}


	public void setModificacionAL(ModificacionAlumnos modificacionAL) {
		this.modificacionAL = modificacionAL;
		ap = new AlumnoPersistencia();

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}