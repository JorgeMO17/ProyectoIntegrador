package vista.proyecto_integrador;

import vista.EstructVentana;
import vista.VentanaPrincipal;
import controlador.proyecto_integrador.ControladorPI;
import modelo.Alumno;
import modelo.Grupo;
import modelo.ProyectoIntegradorPOJO;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JRadioButton;

import java.awt.Frame;
import java.awt.geom.Area;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;

public class ModifyyyPI extends JPanel implements IVpi {
	private JTextField txtUrl;
	private final ButtonGroup btnGCursos = new ButtonGroup();
	private JLabel lblNombreDelProyecto;
	private JTextField txtNamePrj;
	private JLabel lblComponentes;
	private JLabel lblUrlGithubProyecto;
	private JLabel lblNota;
	private JSpinner spnNota;
	private JLabel lblAnyo;
	private JSpinner spnAnyo;
	private JLabel lblCurso;
	private JRadioButton rdbtn1;
	private JRadioButton rdbtn2;
	private JLabel lblGrupo;
	private JLabel lblArea;
	private JComboBox<modelo.Area> cmbArea;
	private JButton btnGuardar;
	private JButton btnLimpiar;
	private JLabel lblIdentificadorunico;
	private JTextField txtIdun;
	private JButton btnQuitar;
	private JButton btnAgregar;
	private JComboBox<Grupo> cmbGrupo;
	private JList<Alumno> listComponentes;// a�adir elemento
	private JScrollPane scrollPane;
	private DefaultListModel<Alumno> modelo;
	private DefaultComboBoxModel<Area> ComboBoxModelArea;
	private DefaultComboBoxModel<Grupo> GrupoCombo;

	public ModifyyyPI() {
		super();
		inicializar();
	}

	public void cargarModifiPI(ProyectoIntegradorPOJO pj1, int curso, ArrayList<Alumno> dameLosComponentesDelPI) {
		// TODO Auto-generated method stub
		txtIdun.setText(String.valueOf(pj1.getIdProyecto()));
		txtNamePrj.setText(pj1.getNombre());
		txtUrl.setText(pj1.getUrl());
		spnNota.setValue(pj1.getNota());
		spnAnyo.setValue(pj1.getAnyo());

		if (curso == 1) {
			rdbtn1.setSelected(true);
		} else {
			rdbtn2.setSelected(true);
		}

		cmbGrupo.addItem(new Grupo(pj1.getGrupo(), curso));

		for (int i = 0; i < cmbArea.getItemCount(); i++) {

			if (cmbArea.getItemAt(i).getId_area() == pj1.getIdArea()) {
				cmbArea.setSelectedIndex(i);
			}
		}
		
		for (Alumno alumno : dameLosComponentesDelPI) {
			modelo.addElement(alumno);
		}
		
		listComponentes.setModel(modelo);
		
		

	}

	@Override
	public void inicializar() {

		setLayout(null);

		lblIdentificadorunico = new JLabel("Identificador \u00FAnico:");
		lblIdentificadorunico.setBounds(10, 11, 123, 14);
		add(lblIdentificadorunico);

		txtIdun = new JTextField();
		txtIdun.setEnabled(false);
		txtIdun.setBounds(153, 8, 271, 20);
		txtIdun.setHorizontalAlignment(SwingConstants.CENTER);
		add(txtIdun);
		txtIdun.setColumns(10);

		lblNombreDelProyecto = new JLabel("Nombre del proyecto:");
		lblNombreDelProyecto.setBounds(10, 36, 131, 14);
		add(lblNombreDelProyecto);

		txtNamePrj = new JTextField();
		txtNamePrj.setBounds(153, 33, 271, 20);
		txtNamePrj.setHorizontalAlignment(SwingConstants.CENTER);
		add(txtNamePrj);
		txtNamePrj.setColumns(10);

		lblComponentes = new JLabel("Componentes:");
		lblComponentes.setBounds(10, 61, 123, 14);
		add(lblComponentes);

		lblUrlGithubProyecto = new JLabel("URL GitHub Proyecto:");
		lblUrlGithubProyecto.setBounds(10, 149, 123, 14);
		add(lblUrlGithubProyecto);

		txtUrl = new JTextField();
		txtUrl.setBounds(153, 146, 271, 20);
		add(txtUrl);
		txtUrl.setColumns(10);

		lblNota = new JLabel("Nota:");
		lblNota.setBounds(71, 188, 46, 14);
		add(lblNota);

		spnNota = new JSpinner();
		spnNota.setBounds(114, 185, 61, 20);
		spnNota.setModel(new SpinnerNumberModel(0, 0, 10, 1));
		add(spnNota);

		lblAnyo = new JLabel("A\u00F1o:");
		lblAnyo.setBounds(71, 213, 46, 14);
		add(lblAnyo);

		spnAnyo = new JSpinner();
		spnAnyo.setBounds(114, 210, 61, 20);
		spnAnyo.setModel(new SpinnerNumberModel(2000, 2000, 2020, 1));
		add(spnAnyo);

		lblCurso = new JLabel("Curso:");
		lblCurso.setBounds(218, 188, 46, 14);
		add(lblCurso);

		rdbtn1 = new JRadioButton("1\u00BA");
		rdbtn1.setBounds(270, 184, 46, 23);
		btnGCursos.add(rdbtn1);
		add(rdbtn1);

		rdbtn2 = new JRadioButton("2\u00BA");
		rdbtn2.setBounds(331, 184, 46, 23);
		btnGCursos.add(rdbtn2);
		add(rdbtn2);

		lblGrupo = new JLabel("Grupo:");
		lblGrupo.setBounds(218, 213, 46, 14);
		add(lblGrupo);

		lblArea = new JLabel("Area:");
		lblArea.setBounds(10, 247, 46, 14);
		add(lblArea);

		/*
		 * ArrayList<String> places = new ArrayList<String>();// ELIMINA LUEGO ESTO
		 * places.add("Buenos Aires"); places.add("C�rdoba"); places.add("La Plata");
		 */

		cmbArea = new JComboBox();
		// cmbArea.setModel(places);//AREA COMBOBOXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX

		cmbArea.setBounds(143, 244, 281, 20);
		add(cmbArea);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(86, 275, 89, 23);
		add(btnGuardar);

		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(267, 275, 89, 23);
		//add(btnLimpiar);

		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(10, 86, 89, 23);
		add(btnAgregar);

		btnQuitar = new JButton("Quitar");
		btnQuitar.setBounds(10, 112, 89, 23);
		add(btnQuitar);

		cmbGrupo = new JComboBox();////////////// GRUPO
		cmbGrupo.setEnabled(false);
		cmbGrupo.setBounds(270, 209, 154, 22);
		add(cmbGrupo);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(152, 64, 272, 73);
		add(scrollPane);

		listComponentes = new JList();
		modelo = new DefaultListModel();

		listComponentes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(listComponentes);

	}

	@Override
	public void setControlador(ControladorPI control) {

		rdbtn1.addActionListener(control);// segun que btn hago un filtro del grupo
		rdbtn2.addActionListener(control);

		btnAgregar.addActionListener(control);
		btnGuardar.addActionListener(control);
		btnLimpiar.addActionListener(control);
		btnQuitar.addActionListener(control);
	}

	/*
	 * @author JorgeM Mis0 getters
	 */

	public JRadioButton getRdbtn1() {
		return rdbtn1;
	}

	public JRadioButton getRdbtn2() {
		return rdbtn2;
	}

	public JButton getBtnGuardar() {
		return btnGuardar;
	}

	public JButton getBtnLimpiar() {
		return btnLimpiar;
	}

	public JButton getBtnQuitar() {
		return btnQuitar;
	}

	public JButton getBtnAgregar() {
		return btnAgregar;
	}

	public void agregarAlumno(Alumno alumnoAdd) {
		// TODO Auto-generated method stub
		int x = modelo.getSize();
		boolean repe = false;

		for (int i = 0; i < x; i++) {
			if (modelo.getElementAt(i) == alumnoAdd) {
				repe = true;
			}
		}
		if (repe == false) {
			modelo.addElement(alumnoAdd);
		} else {
			JOptionPane.showMessageDialog(getParent(), "Alumno ya agregado", "Info", JOptionPane.INFORMATION_MESSAGE);
		}
		listComponentes.setModel(modelo);

	}

	public void borraAlum() {
		// TODO Auto-generated method stub
		if (listComponentes.getSelectedIndex() != -1) {
			modelo.removeElementAt(listComponentes.getSelectedIndex());
		}
	}

	public void cargarGrupoo(ArrayList<Grupo> grupis) {
		// TODO Auto-generated method stub

		cmbGrupo.removeAllItems();

		for (Grupo grupo : grupis) {
			cmbGrupo.addItem(grupo);
		}

		cmbGrupo.setEnabled(true);

	}

	public void cargarAreas(ArrayList<modelo.Area> areas) {
		// TODO Auto-generated method stub
		cmbArea.removeAllItems();

		for (modelo.Area area : areas) {

			if (area.getNombre().equals("")) {

			} else {
				cmbArea.addItem(area);
			}

		}
	}

	public void setTxtIdun(int id) {

		txtIdun.setText("");
	}

	public ProyectoIntegradorPOJO recogerDatosPI() {

		boolean todoOK = true;
		String nombre = "";
		String url = "";
		int nota = 0;
		int anyo = 0;
		String grupo = "";
		int Idarea = 0;

		if (txtNamePrj.getText().equals("")) {
			msgError("Nombre necesario");
			todoOK = false;
		} else {
			nombre = txtNamePrj.getText();
		}

		if (txtUrl.getText().equals("")) {
			msgError("URL necesaria");
			todoOK = false;
		} else {
			url = txtUrl.getText();
		}

		if (!rdbtn1.isSelected()) {
			if (!rdbtn2.isSelected()) {
				msgError("Selecciona un curso");
				todoOK = false;
			} else {
				anyo = 2;
			}
		} else {
			anyo = 1;
		}

		// ArrayList<Alumno> componentes;

		if (modelo.size() < 2) {
			msgError("Agrega componentes, minimo 2");
			todoOK = false;
		}

		if (todoOK) {

			nota = (int) spnNota.getValue();
			anyo = (int) spnAnyo.getValue();
			grupo = cmbGrupo.getSelectedItem().toString();
			modelo.Area are = (modelo.Area) cmbArea.getSelectedItem();
			Idarea = are.getId_area();

			ProyectoIntegradorPOJO pi = new ProyectoIntegradorPOJO(0, nombre, url, nota, anyo, grupo, Idarea);
			return pi;
		} else {
			return null;
		}
	}

	public void msgError(String string) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(getParent(), string, "ERROR", JOptionPane.ERROR_MESSAGE);
	}

	public void msgGood(String string) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(getParent(), string, "NICEE", JOptionPane.INFORMATION_MESSAGE);
	}

	public void porDefecto() {
		// TODO Auto-generated method stub

		txtNamePrj.setText("");
		txtUrl.setText("");
		txtIdun.setText("");

		// listComponentes.remove

		spnNota.setValue(0);
		spnAnyo.setValue(2000);
		rdbtn1.setSelected(false);
		rdbtn2.setSelected(false);

		cmbGrupo.removeAllItems();
		modelo.clear();
		cmbArea.setSelectedIndex(0);

		cmbGrupo.setEnabled(false);

	}

	public void ponerId(int x) {
		// TODO Auto-generated method stub

		txtIdun.setText(String.valueOf(x));

	}

	public ArrayList<Alumno> DameComponentes() {
		// TODO Auto-generated method stub

		ArrayList<Alumno> alumnoss = new ArrayList<Alumno>();

		for (int i = 0; i < modelo.size(); i++) {
			alumnoss.add(modelo.getElementAt(i));
		}

		return alumnoss;
	}

}
