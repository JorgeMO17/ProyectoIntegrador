package vista.alumno;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

import controlador.CVentanaPrincipal;
import controlador.alumnos.ControladorAlumnos;
import controlador.area.ControladorArea;
import modelo.Alumno;
import modelo.Area;
import vista.EstructVentana;

/**
 * A�adir alumnos
 *
 */
@SuppressWarnings("serial")
public class AltaAlumnos extends JPanel implements EstructVentana{

	

	
	
	private JLabel lblId;  //"ID:"
	
	private JLabel lblNombre;  //"Nombre:"
	private JTextField txtNombre;  //Introducir nombre
	
	private JLabel lblApellidos;  //"Apellidos:"
	private JTextField txtApellidos;  //Introducir apellidos
	
	private JLabel lblExpediente;  //"Expediente:"
	private JTextArea txtAExpediente;  //"Introducir expediente"
	
	private JButton btnFinalizar;  //Bot�n "Finalizar"
	private JButton btnLimpiar;	 //Bot�n Limpiar
	private JTextField txtID;
	
	public AltaAlumnos() throws HeadlessException {
		
		inicializar();
	}

	@Override
	public void inicializar() {
		setLayout(null);

		
		
		lblId = new JLabel("ID:");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblId.setBounds(139, 47, 19, 16);
		add(lblId);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNombre.setBounds(124, 78, 54, 16);
		add(lblNombre);
		
		lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblApellidos.setBounds(125, 119, 63, 16);
		add(lblApellidos);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(198, 77, 86, 20);
		add(txtNombre);
		
		txtApellidos = new JTextField();
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(198, 118, 86, 20);
		add(txtApellidos);
		
		
		txtAExpediente = new JTextArea();
		txtAExpediente.setBounds(208, 159, 174, 22);
		add(txtAExpediente);
		
		lblExpediente = new JLabel("Expediente:");
		lblExpediente.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblExpediente.setBounds(124, 162, 76, 16);
		add(lblExpediente);
		
		
		btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setBounds(128, 193, 71, 23);
		add(btnFinalizar);
		
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(255, 205, 65, 23);
		add(btnLimpiar);
		
		txtID = new JTextField();
		txtID.setEnabled(false);
		txtID.setBounds(198, 46, 86, 20);
		add(txtID);
		txtID.setColumns(10);
		
		
	}
	
	public void setControlador(ControladorAlumnos control) {
		btnFinalizar.addActionListener(control);
		btnLimpiar.addActionListener(control);
		
	}

	public JButton getBtnFinalizar() {
		return btnFinalizar;
	}

	public JButton getBtnLimpiar() {
		return btnLimpiar;
	}
	
	public void mostrarCampos() {
		lblId.setEnabled(false);
		txtApellidos.setEnabled(false);
		lblNombre.setEnabled(true);
		txtNombre.setEnabled(true);
		lblExpediente.setEnabled(true);
		txtAExpediente.setEnabled(true);
		btnFinalizar.setEnabled(true);
		btnLimpiar.setEnabled(true);
		lblApellidos.setEnabled(true);
	}
	
	public void borrarCampos() {
		txtNombre.setText("");
		txtAExpediente.setText("");
		txtApellidos.setText("");
	}
}

