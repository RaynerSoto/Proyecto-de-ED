package Interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logica.Compañia;
import Logica.Persona;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import Interfaces_creadas.JTextFieldNombre;
import Interfaces_creadas.JTextFieldCarnet;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Ingresar_Trabajador extends JDialog {
	private Compañia comp;
	private Interfaz_principal interfaz;
	private final JPanel contentPanel = new JPanel();
	private JTextFieldNombre textFieldApellidos;
	private JTextFieldNombre textFieldNombre;
	private JSpinner spinner_años;
	private JSpinner spinner_salario;
	private JSpinner spinner_edad;
	private JButton btnNewButton;
	private JTextFieldCarnet textFieldCarnet;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_6;
	private JComboBox comboBox;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Ingresar_Trabajador dialog = new Ingresar_Trabajador(null,null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * @param comp 
	 * @param interfaz_principal 
	 */
	public Ingresar_Trabajador(Interfaz_principal interfaz_principal, Compañia compa) {
		this.comp = compa;
		this.interfaz = interfaz_principal;
		setTitle("Trabajadores\r\n");
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Fallout 3 new 1.ico"));
		setBounds(100, 100, 624, 606);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 11, 90, 27);
		contentPanel.add(lblNewLabel);
		
		textFieldNombre = new JTextFieldNombre();
		textFieldNombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldNombre.setColumns(2000);
		textFieldNombre.setBounds(173, 11, 228, 27);
		contentPanel.add(textFieldNombre);
		
		JLabel lblNewLabel_1 = new JLabel("Apellidos");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(10, 49, 90, 27);
		contentPanel.add(lblNewLabel_1);
		
		textFieldApellidos = new JTextFieldNombre();
		textFieldApellidos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldApellidos.setColumns(2000);
		textFieldApellidos.setBounds(173, 49, 228, 27);
		contentPanel.add(textFieldApellidos);
		
		JLabel lblNewLabel_2 = new JLabel("Carnet de Identidad");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(10, 87, 138, 27);
		contentPanel.add(lblNewLabel_2);
		
		textFieldCarnet = new JTextFieldCarnet();
		textFieldCarnet.setBounds(173, 87, 228, 27);
		contentPanel.add(textFieldCarnet);
		
		JLabel lblNewLabel_3 = new JLabel("Edad");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(10, 125, 90, 27);
		contentPanel.add(lblNewLabel_3);
		
		spinner_edad = new JSpinner();
		spinner_edad.setFont(new Font("Tahoma", Font.PLAIN, 13));
		spinner_edad.setModel(new SpinnerNumberModel(15, 15, 200, 1));
		spinner_edad.setBounds(173, 125, 228, 24);
		contentPanel.add(spinner_edad);
		
		JLabel lblNewLabel_4 = new JLabel("Salario");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(10, 163, 90, 27);
		contentPanel.add(lblNewLabel_4);
		
		spinner_salario = new JSpinner();
		spinner_salario.setModel(new SpinnerNumberModel(new Double(1), new Double(1), null, new Double(1)));
		spinner_salario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		spinner_salario.setBounds(173, 163, 228, 24);
		contentPanel.add(spinner_salario);
		
		JLabel lblNewLabel_5 = new JLabel("A\u00F1os de experiencia");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(10, 201, 125, 27);
		contentPanel.add(lblNewLabel_5);
		
		spinner_años = new JSpinner();
		spinner_años.setFont(new Font("Tahoma", Font.PLAIN, 13));
		spinner_años.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		spinner_años.setBounds(173, 201, 228, 24);
		contentPanel.add(spinner_años);
		
		btnNewButton = new JButton("A\u00F1adir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textFieldNombre.getText().isEmpty() || textFieldApellidos.getText().isEmpty() || textFieldCarnet.getText().isEmpty()) {
					JOptionPane.showMessageDialog(Ingresar_Trabajador.this,"Campos obligatorios vacios","Error",JOptionPane.ERROR_MESSAGE);
				}
				else {
					String nombre = textFieldNombre.getText();
					String apellidos = textFieldApellidos.getText();
					String carnet = textFieldCarnet.getText();
					int edad = (Integer)spinner_edad.getValue();
					double salario = (Double)spinner_salario.getValue();
					int años = (Integer)spinner_años.getValue();
					if(edad>años) {
						Persona persona = new Persona(nombre, apellidos, edad, salario, años, carnet);
						if(comp.personas_iguales(persona) == false) {
							if(comboBox.getSelectedIndex() == 0) {
								comp.setPresidente(persona);
								limpiar();
							}
							else if (comboBox.getSelectedIndex() == 1) {
								comp.setVicepresindete(persona);
								limpiar();
							}
							else {
								comp.Trabajadores.add(persona);
							}

						}
						else {
							JOptionPane.showMessageDialog(Ingresar_Trabajador.this,"Está persona ya se encuentra en la compañía","Error",JOptionPane.ERROR_MESSAGE);						
						}
					}
					else {
						JOptionPane.showMessageDialog(Ingresar_Trabajador.this,"La cantidad de años de vida no puede ser menor o igual que los años de experiencia","Error",JOptionPane.ERROR_MESSAGE);
					}
					actualizar();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(431, 11, 144, 43);
		contentPanel.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Finalizar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(431, 216, 144, 43);
		contentPanel.add(btnNewButton_1);
		
		lblNewLabel_6 = new JLabel("Puesto");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_6.setBounds(10, 239, 119, 27);
		contentPanel.add(lblNewLabel_6);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Presidente ", "Vicepresidente", "Trabajador"}));
		comboBox.setBounds(173, 242, 228, 24);
		contentPanel.add(comboBox);
		
		table = new JTable();
		table.setBounds(10, 291, 588, 265);
		contentPanel.add(table);
		actualizar();
	}
	public void limpiar() {
		textFieldNombre.setText("");
		textFieldApellidos.setText("");
		textFieldCarnet.setText("");
		spinner_años.setValue(1);
		spinner_edad.setValue(1);
		spinner_salario.setValue(1);
	}
	public void actualizar(){
		String[] encabezado = {"Nombre","Carnet de Identidad","Edad","Salario","Ocupación"};
		int total = comp.Trabajadores.size() + (comp.getPresidente() != null ? 1:0)+(comp.getVicepresindete() != null ? 1:0);
		Object [] [] tabla = new Object[total][encabezado.length];
		Persona per;
		int i = 0;
		if(comp.getPresidente() != null) {
			per = comp.presidente;
			tabla[i][0] = per.getNombre();
			tabla[i][1] = per.getCarnet_identidad();
			tabla[i][2] = per.getEdad();
			tabla[i][3] = per.getSalario();
			tabla[i][4] = "Presidente";
			i++;
		}
		if(comp.getVicepresindete() != null) {
			per = comp.getVicepresindete();
			tabla[i][0] = per.getNombre();
			tabla[i][1] = per.getCarnet_identidad();
			tabla[i][2] = per.getEdad();
			tabla[i][3] = per.getSalario();
			tabla[i][4] = "Vice-Presidente";
			i++;
		}
		for(int contador = 0 ; contador < comp.Trabajadores.size(); contador++,i++) {
			tabla[i][0] = comp.Trabajadores.get(contador).getNombre();
			tabla[i][1] = comp.Trabajadores.get(contador).getCarnet_identidad();
			tabla[i][2] = comp.Trabajadores.get(contador).getEdad();
			tabla[i][3] = comp.Trabajadores.get(contador).getSalario();
			tabla[i][4] = "Trabajador";
		}
		
		DefaultTableModel defaultTableModel = new DefaultTableModel(tabla, encabezado){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int col){
				return false;
			}
		};
		table.setModel(defaultTableModel);	
	}
}
