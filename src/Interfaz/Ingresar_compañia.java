package Interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.naming.LimitExceededException;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logica.Compañia;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ingresar_compañia extends JDialog {
	private Compañia compa;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private Interfaz_principal interfaz_principal;
	/**
	 * Create the dialog.
	 * @param interfaz_principal 
	 * @param comp 
	 */
	public Ingresar_compañia(Interfaz_principal interfaz_principal,Compañia comp) {
		this.compa = comp;
		this.interfaz_principal = interfaz_principal;
		setModal(true);
		setTitle("Ingresar compa\u00F1\u00EDa");
		setResizable(false);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 358, 174);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 11, 67, 55);
		contentPanel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField.setBounds(124, 11, 221, 55);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				compa.setNombre(textField.getText().toString());
				dispose();
			}
		});
		btnNewButton.setBounds(10, 79, 107, 55);
		contentPanel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Limpiar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
			}
		});
		btnNewButton_1.setBounds(124, 79, 107, 55);
		contentPanel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Salir");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_2.setBounds(238, 80, 107, 53);
		contentPanel.add(btnNewButton_2);
		actualizar_text(compa);
	}
	public void actualizar_text(Compañia compa){
		textField.setText(compa.getNombre().toString());
	}
}
