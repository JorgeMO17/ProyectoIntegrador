package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JMenuItem;

import accesoDB.PIPersistencia;
import controlador.alumnos.ControladorAlumnos;
import controlador.proyecto_integrador.ControladorPI;
import vista.VentanaPrincipal;
import vista.alumno.AltaAlumnos;
import vista.alumno.BajaAlumnos;
import vista.alumno.ConsultaAlumnos;
import vista.alumno.ModificacionAlumnos;
import vista.area.AltaArea;
import vista.area.BajaArea;
import vista.area.ConsultaArea;
import vista.area.ModificacionArea;
import vista.proyecto_integrador.BajaPI;
import vista.proyecto_integrador.ConsultaPI;
import vista.proyecto_integrador.CrearPI;
import vista.proyecto_integrador.ModificarPI;
import vista.proyecto_integrador.agregarAlumnos;

public class CVentanaPrincipal implements ActionListener {

	private VentanaPrincipal vp1;

	private CrearPI crearPII;
	private BajaPI BajaPII;
	private ConsultaPI ConsultaPII;
	private ModificarPI ModificarPII;
	private agregarAlumnos agregarAlumnosI;
	private PIPersistencia persistenciaPI;

	private ControladorPI ControladorPI;

	private AltaAlumnos vAltaAlumnos;
	private BajaAlumnos vBajaAlumnos;
	private ModificacionAlumnos vModificiacionAlumnos;
	private ConsultaAlumnos vConsultaAlumnos;

	private ControladorAlumnos controladorAlumno;

	private AltaArea altaAR;
	private BajaArea bajaAR;
	private ConsultaArea consultaAR;
	private ModificacionArea modificacionAR;
	
	public CVentanaPrincipal(VentanaPrincipal vp1) {
		this.vp1 = vp1;
		// ControladorPI = new ControladorPI();// PI
		// persistenciaPI = new PIPersistencia();
		controladorAlumno = new ControladorAlumnos();// CA

	}

	public void setCrearPII(CrearPI crearPII) {
		this.crearPII = crearPII;
	}

	public void setBajaPII(BajaPI bajaPII) {
		BajaPII = bajaPII;
	}

	public void setConsultaPII(ConsultaPI consultaPII) {
		ConsultaPII = consultaPII;
	}

	public void setModificarPII(ModificarPI modificarPII) {
		ModificarPII = modificarPII;
	}

	public void setAgregarAlumnosI(agregarAlumnos agregarAlumnosI) {
		this.agregarAlumnosI = agregarAlumnosI;
	}

	public void setPersistenciaPI(PIPersistencia persistenciaPI) {
		this.persistenciaPI = persistenciaPI;
	}

	public void setControladorPI(ControladorPI controladorPI) {
		ControladorPI = controladorPI;
	}

	public void setAltaAR(AltaArea altaAR) {
		this.altaAR = altaAR;
	}

	public void setBajaAR(BajaArea bajaAR) {
		this.bajaAR = bajaAR;
	}

	public void setConsultaAR(ConsultaArea consultaAR) {
		this.consultaAR = consultaAR;
	}

	public void setModificacionAR(ModificacionArea modificacionAR) {
		this.modificacionAR = modificacionAR;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();

		if (source instanceof JMenuItem) {
			//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			if (source.equals(vp1.getMntmAlta())) {

			
				vp1.verPanel(crearPII);

				ArrayList<modelo.Area> Areas = persistenciaPI.cargarArea();
				crearPII.cargarAreas(Areas);

			} else if (source.equals(vp1.getMntmConsultas())) {// Consultas
				ConsultaPII = new ConsultaPI();
				ConsultaPII.setControlador(ControladorPI);
				ControladorPI.setConsultaPII(ConsultaPII);

				vp1.verPanel(ConsultaPII);

			} else if (source.equals(vp1.getMntmBaja())) {// baja



				vp1.verPanel(BajaPII);
				BajaPII.agregarPI(persistenciaPI.damePI(""));

			} else if (source.equals(vp1.getMntmModificacion())) {

				ModificarPII = new ModificarPI();
				ModificarPII.setControlador(ControladorPI);
				ControladorPI.setModificarPII(ModificarPII);
				vp1.verPanel(ModificarPII);

			} else if (source.equals(vp1.getMntmConsultasA())) {// #ALUMNOS#
				System.out.println("Boton de consulta de alumnos");
				vConsultaAlumnos = new ConsultaAlumnos();// crear
				controladorAlumno.setConsultaAL(vConsultaAlumnos);
				vConsultaAlumnos.setControlador(controladorAlumno);
				vp1.verPanel(vConsultaAlumnos);
			} else if (source.equals(vp1.getMntmAltaA())) {
				System.out.println("Boton de alta de alumnos");
				vAltaAlumnos = new AltaAlumnos();// crear
				controladorAlumno.setAltaAL(vAltaAlumnos);
				vAltaAlumnos.setControlador(controladorAlumno);
				vp1.verPanel(vAltaAlumnos);
			} else if (source.equals(vp1.getMntmBajaA())) {
				System.out.println("Boton de baja de alumnos");
				vBajaAlumnos = new BajaAlumnos();// crear
				controladorAlumno.setBajaAL(vBajaAlumnos);
				vBajaAlumnos.setControlador(controladorAlumno);
				vp1.verPanel(vBajaAlumnos);
			} else if (source.equals(vp1.getMntmModificacionA())) {
				System.out.println("boton de modificacion de alumnos");
				vModificiacionAlumnos = new ModificacionAlumnos();// crear
				controladorAlumno.setModificacionAL(vModificiacionAlumnos);
				vModificiacionAlumnos.setControlador(controladorAlumno);
				vp1.verPanel(vModificiacionAlumnos);

				//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			} else if (source.equals(vp1.getMntmConsultasAR())) {// #AREA#
				vp1.verPanel(consultaAR);
			} else if (source.equals(vp1.getMntmAltaAR())) {
				vp1.verPanel(altaAR);
			} else if (source.equals(vp1.getMntmBajaAR())) {			
				vp1.verPanel(bajaAR);
			} else if (source.equals(vp1.getMntmModificacionAR())) {
				vp1.verPanel(modificacionAR);
			}
		}
	}
}