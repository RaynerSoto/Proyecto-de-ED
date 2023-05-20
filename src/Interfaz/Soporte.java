package Interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Soporte extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Soporte dialog = new Soporte(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * @param interfaz_principal 
	 */
	public Soporte(Interfaz_principal interfaz_principal) {
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setTitle("Soporte\r\n");
		setBounds(100, 100, 524, 267);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Desarrollado por: Rayner Alejandro Soto Mart\u00EDnez");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
			lblNewLabel.setBounds(10, 10, 414, 15);
			contentPanel.add(lblNewLabel);
		}
		
		JLabel lblDireccinDeCorreo = new JLabel("Direcci\u00F3n de correo: raynersoto01@gmail.com");
		lblDireccinDeCorreo.setVerticalAlignment(SwingConstants.TOP);
		lblDireccinDeCorreo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDireccinDeCorreo.setBounds(10, 36, 414, 15);
		contentPanel.add(lblDireccinDeCorreo);
		
		JTextPane txtpnReglasDeUso = new JTextPane();
		txtpnReglasDeUso.setEditable(false);
		txtpnReglasDeUso.setText("Reglas de uso:\r\n1-Es necesario para poder hacer uso de varias funcionalidades del llenado \r\ncompleto de datos obligatorios. Ejemplo:\r\n-Si la compa\u00F1\u00EDa no tiene nombre, no se pueden ingresar los trabajadores.\r\n-Si la compa\u00F1\u00EDa no tiene un presidente, un vicepresidente y al menos un trabajador, es imposible ingresar los videojuegos.\r\n2-Disfrute del programa y de sus diversos datos estad\u00EDsticos");
		txtpnReglasDeUso.setBounds(10, 62, 488, 121);
		contentPanel.add(txtpnReglasDeUso);
		
		JButton btnNewButton = new JButton("Cerrar\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(10, 194, 488, 23);
		contentPanel.add(btnNewButton);
	}
}
