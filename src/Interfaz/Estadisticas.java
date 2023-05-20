package Interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.xml.bind.JAXBException;

import org.omg.CORBA.Object;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.sun.xml.internal.bind.v2.runtime.reflect.ListIterator;

import Logica.Compañia;
import Logica.Juegos;

import javax.swing.JLabel;
import javax.swing.JSpinner;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Estadisticas extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Interfaz_principal interfaz_principal;
	private final JLabel lblNewLabel_2 = new JLabel("Cantidad de Videojuegos");
	private JSpinner spinner;
	private Compañia compa;
	private final JLabel lblNewLabel_3 = new JLabel("Cantidad de trabajadores");
	private final JSpinner spinner_1 = new JSpinner();
	private final JLabel lblNewLabel_4 = new JLabel("Presidente");
	private final JLabel lblNewLabel_5 = new JLabel("");
	private final JLabel lblNewLabel_6 = new JLabel("Vice-Presidente");
	private final JLabel lblNewLabel_7 = new JLabel("");
	private final JButton btnNewButton = new JButton("Regresar");
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the dialog.
	 * @param comp 
	 * @param interfaz_principal 
	 */
	public Estadisticas(Interfaz_principal interfaz_principal, Compañia comp){
		setTitle("Estad\u00EDsticas");
		this.compa = comp;
		this.interfaz_principal = interfaz_principal;
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre de la Empresa");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 11, 141, 43);
		contentPanel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Cantidad de empleados");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(10, 55, 141, 43);
		contentPanel.add(lblNewLabel_1);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(171, 11, 151, 43);
		
		contentPanel.add(lblNewLabel_2);
		
		spinner = new JSpinner();
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 13));
		spinner.setEnabled(false);
		spinner.setBounds(171, 67, 178, 20);
		contentPanel.add(spinner);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(10, 109, 151, 27);
		
		contentPanel.add(lblNewLabel_3);
		spinner_1.setEnabled(false);
		spinner_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		spinner_1.setBounds(170, 113, 178, 20);
		
		contentPanel.add(spinner_1);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(10, 147, 151, 27);
		
		contentPanel.add(lblNewLabel_4);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(170, 144, 179, 30);
		
		contentPanel.add(lblNewLabel_5);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_6.setBounds(10, 185, 151, 27);
		
		contentPanel.add(lblNewLabel_6);
		lblNewLabel_7.setBounds(170, 179, 179, 27);
		
		contentPanel.add(lblNewLabel_7);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(10, 227, 414, 23);
		
		contentPanel.add(btnNewButton);
		estadisticas_generales();
	}
	public void estadisticas_generales() {
		lblNewLabel_2.setText(compa.getNombre());
		spinner.setValue(compa.Videojuegos.size());
		spinner_1.setValue(compa.getTrabajadores().size());
		lblNewLabel_5.setText(compa.getPresidente().getNombre());
		lblNewLabel_7.setText(compa.getVicepresindete().getNombre());
	}
}
