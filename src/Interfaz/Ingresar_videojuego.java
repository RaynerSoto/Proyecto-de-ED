package Interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultEditorKit.BeepAction;

import org.omg.CORBA.PRIVATE_MEMBER;
import org.w3c.dom.NodeList;

import com.sun.xml.internal.bind.v2.runtime.reflect.ListIterator;

import Logica.Compañia;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import Logica.Genero;
import Logica.Juegos;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class Ingresar_videojuego extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField Videojuego_text;
	private JComboBox Genero1_comboBox;
	private JComboBox genero2_comboBox;
	private JSpinner Gastos;
	private JSpinner Beneficios;
	private Compañia comp;
	private Interfaz_principal inter;
	private JTable table;

	/**
	 * Launch the application.
	/**
	 * Create the dialog.
	 * @param interfaz_principal 
	 * @param comp 
	 */
	public Ingresar_videojuego(Interfaz_principal interfaz_principal,Compañia compa) {
		setTitle("Ingresar Videojuego");
		this.inter = interfaz_principal;
		this.comp = compa;
		setModal(true);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 444, 478);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Nombre");
			lblNewLabel.setBounds(10, 11, 110, 30);
			contentPanel.add(lblNewLabel);
		}
		{
			Videojuego_text = new JTextField();
			Videojuego_text.setBounds(121, 16, 144, 20);
			contentPanel.add(Videojuego_text);
			Videojuego_text.setColumns(10);
		}
		
		Genero1_comboBox = new JComboBox();
		Genero1_comboBox.setModel(new DefaultComboBoxModel(Genero.values()));
		Genero1_comboBox.setBounds(121, 57, 144, 20);
		contentPanel.add(Genero1_comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("Genero\r\n");
		lblNewLabel_1.setBounds(10, 52, 98, 30);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Genero Secundario");
		lblNewLabel_2.setBounds(10, 93, 110, 30);
		contentPanel.add(lblNewLabel_2);
		
		genero2_comboBox = new JComboBox();
		genero2_comboBox.setModel(new DefaultComboBoxModel(Genero.values()));
		genero2_comboBox.setBounds(121, 98, 144, 20);
		contentPanel.add(genero2_comboBox);
		
		JLabel lblNewLabel_3 = new JLabel("Gastos");
		lblNewLabel_3.setBounds(10, 134, 110, 30);
		contentPanel.add(lblNewLabel_3);
		
		Gastos = new JSpinner();
		Gastos.setModel(new SpinnerNumberModel(new Double(1), new Double(1), null, new Double(1)));
		Gastos.setBounds(121, 139, 144, 25);
		contentPanel.add(Gastos);
		
		JLabel lblNewLabel_4 = new JLabel("Beneficios");
		lblNewLabel_4.setBounds(10, 175, 110, 30);
		contentPanel.add(lblNewLabel_4);
		
		Beneficios = new JSpinner();
		Beneficios.setModel(new SpinnerNumberModel(new Double(1), new Double(1), null, new Double(1)));
		Beneficios.setBounds(121, 180, 144, 25);
		contentPanel.add(Beneficios);
		
		JButton btnNewButton = new JButton("A\u00F1adir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Videojuego_text.getText().isEmpty()) {
					JOptionPane.showMessageDialog(Ingresar_videojuego.this,"Datos del nombre vacíos","Error",JOptionPane.ERROR_MESSAGE);
				}
				else {
					if(Genero1_comboBox.getSelectedItem().toString().equals(genero2_comboBox.getSelectedItem().toString())== true) {
						JOptionPane.showMessageDialog(Ingresar_videojuego.this,"Géneros iguales","Error",JOptionPane.ERROR_MESSAGE);
					}
					else {
						String nombre = Videojuego_text.getText();
						String genero1 = Genero1_comboBox.getSelectedItem().toString();
						String genero2 = genero2_comboBox.getSelectedItem().toString();
						double gastos = (Double)Gastos.getValue();
						double beneficios = (Double)Beneficios.getValue();
						Juegos juego = new Juegos(nombre, genero1, genero2, gastos, beneficios);
						if(comp.juegos_iguales(juego) == false) {
							comp.ingresar_videojuegos(juego);
							actualizar_tabla();
						}
						else {
							JOptionPane.showMessageDialog(Ingresar_videojuego.this,"Juegos ingresados iguales","Error",JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			}
		});
		btnNewButton.setBounds(316, 15, 108, 39);
		contentPanel.add(btnNewButton);
		
		table = new JTable();
		table.setBounds(10, 227, 408, 201);
		contentPanel.add(table);
		
		JButton btnNewButton_1 = new JButton("Finalizar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(316, 126, 108, 38);
		contentPanel.add(btnNewButton_1);
		actualizar_tabla();
	}
	public void actualizar_tabla() {
		String[] encabezado = {"Nombre","Género Principal","Género Secundario","Beneficios"};
		Object[][] tabla = new Object[comp.Videojuegos.size()][encabezado.length];
		Queue<Juegos>cola = new ArrayDeque<Juegos>();
		Iterator<Juegos>iterador = comp.Videojuegos.listIterator();
		int contador = 0;
		while(iterador.hasNext()) {
			cola.offer(iterador.next());
			contador++;
		}
		for(int i = 0; i<contador;i++) {
			Juegos juego = cola.poll();
			tabla[i][0] = juego.getNombre();
		    tabla[i][1] = juego.getGenero_principal();
			tabla[i][2] = juego.getGenero_secundario();
			tabla[i][3] = juego.getBeneficios();
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
		encabezado.toString();
	}
}
