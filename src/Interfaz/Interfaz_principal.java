package Interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logica.Compañia;
import Trabajo_Guardar_Cargar.Manejo_Fichero;
import Interfaz.Ingresar_Trabajador;

import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Interfaz_principal extends JFrame {

	private JPanel contentPane;
	Compañia comp = new Compañia("");
	private JMenu mnNewMenu_2;
	private JMenuItem Videojuegos_boton;
	private JMenuItem Estadisticas_generales_Boton;
	private JMenuItem Trabajadores_Boton;
	private JMenu mnNewMenu_1;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem_2;
	private JMenuItem mntmNewMenuItem_3;
	private JMenuItem mntmNewMenuItem_4;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;;
	Manejo_Fichero mane = new Manejo_Fichero();
	File file = new File("compañia.dat");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz_principal frame = new Interfaz_principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Interfaz_principal() {
		setResizable(false);
		setTitle("Empresa de Videojuegos");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 474, 464);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewMenu_1 = new JMenu("Archivo");
		
		mntmNewMenuItem_2 = new JMenuItem("Guardar");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					mane.guardar_archivos(comp, file);
					JOptionPane.showMessageDialog(Interfaz_principal.this,"Guardado con éxito","Guardado",JOptionPane.INFORMATION_MESSAGE);
				} catch (NullPointerException | IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		mntmNewMenuItem_2.setIcon(new ImageIcon(Interfaz_principal.class.getResource("/com/sun/java/swing/plaf/windows/icons/File.gif")));
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		mntmNewMenuItem_1 = new JMenuItem("Cargar");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(file.exists()) {
					if(JOptionPane.showConfirmDialog(Interfaz_principal.this,"¿Desea cargar los datos manteniendo los datos actuales?","Información",JOptionPane.YES_OPTION) == JOptionPane.YES_OPTION) {
						mane.cargar_archivos_sinsobrescribir(file, comp);
						JOptionPane.showMessageDialog(Interfaz_principal.this,"Cargado con éxito","Cargado",JOptionPane.INFORMATION_MESSAGE);

					}
					else {
						comp = mane.cargar_archivos_sobrescribir(file);
						JOptionPane.showMessageDialog(Interfaz_principal.this,"Cargado con éxito","Cargado",JOptionPane.INFORMATION_MESSAGE);

					}
					actualizar_boton_trabajadores();
					actualizar_boton_videojuego();
				}
				else {
					JOptionPane.showMessageDialog(Interfaz_principal.this,"El archivo guardado no existe","Error",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		mntmNewMenuItem_1.setIcon(new ImageIcon(Interfaz_principal.class.getResource("/com/sun/java/swing/plaf/windows/icons/Directory.gif")));
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Eliminar");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(file.exists()) {
					file.delete();
					JOptionPane.showMessageDialog(Interfaz_principal.this,"Eliminado con éxito","Eliminado",JOptionPane.INFORMATION_MESSAGE);

				}
				else {
					JOptionPane.showMessageDialog(Interfaz_principal.this,"No hay archivo guardado","Error",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		mntmNewMenuItem_5.setIcon(new ImageIcon(Interfaz_principal.class.getResource("/com/sun/java/swing/plaf/motif/icons/Error.gif")));
		mnNewMenu_1.add(mntmNewMenuItem_5);
		
		JMenu mnNewMenu = new JMenu("Ingresar");
		mnNewMenu.setIcon(new ImageIcon(Interfaz_principal.class.getResource("/javax/swing/plaf/metal/icons/ocean/menu.gif")));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Compa\u00F1\u00EDa");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ingresar_compañia();
				actualizar_boton_videojuego();
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		Videojuegos_boton = new JMenuItem("Videojuegos");
		Videojuegos_boton.setEnabled(false);
		Videojuegos_boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ingresar_videojuego();
			}
		});
		
		Trabajadores_Boton = new JMenuItem("Trabajadores");
		Trabajadores_Boton.setEnabled(false);
		Trabajadores_Boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ingresar_Trabajador ingres = new Ingresar_Trabajador(Interfaz_principal.this,comp);
				ingres.setVisible(true);
				actualizar_boton_videojuego();
			}
		});
		mnNewMenu.add(Trabajadores_Boton);
		mnNewMenu.add(Videojuegos_boton);
		mnNewMenu_2 = new JMenu("Datos");
		mnNewMenu_2.setHorizontalAlignment(SwingConstants.LEFT);
		mnNewMenu_2.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mnNewMenu_2.setSelectedIcon(new ImageIcon("D:\\Personal\\Icons\\Mix\\001.ico"));
		mnNewMenu_2.setIcon(new ImageIcon(Interfaz_principal.class.getResource("/javax/swing/plaf/metal/icons/Inform.gif")));
		menuBar.add(mnNewMenu_2);
		
		Estadisticas_generales_Boton = new JMenuItem("Compa\u00F1\u00EDa");
		Estadisticas_generales_Boton.setEnabled(false);
		Estadisticas_generales_Boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				estadisticas_validas();
			}
		});
		mnNewMenu_2.add(Estadisticas_generales_Boton);
		
		mntmNewMenuItem_3 = new JMenuItem("Soporte");
		mntmNewMenuItem_3.setHorizontalAlignment(SwingConstants.LEFT);
		mntmNewMenuItem_3.setBackground(new Color(240, 240, 240));
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Soporte sopor = new Soporte(Interfaz_principal.this);
				sopor.setVisible(true);
			}
		});
		menuBar.add(mntmNewMenuItem_3);
		mntmNewMenuItem_3.setIcon(new ImageIcon(Interfaz_principal.class.getResource("/com/sun/java/swing/plaf/windows/icons/Question.gif")));
		
		mntmNewMenuItem_4 = new JMenuItem("Salir");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		menuBar.add(mntmNewMenuItem_4);
		mntmNewMenuItem_4.setIcon(new ImageIcon(Interfaz_principal.class.getResource("/com/sun/java/swing/plaf/windows/icons/Error.gif")));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setIcon(new ImageIcon("D:\\Proyectos New\\Videojuegos\\00d6f99ca5e41648a43b07c71141d595.jpg"));
		lblNewLabel.setBounds(0, 0, 236, 394);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\Proyectos New\\Videojuegos\\1dec6eb2b3387d8442fc80774fe53bd4.jpg"));
		lblNewLabel_1.setBounds(237, 0, 233, 394);
		contentPane.add(lblNewLabel_1);
		actualizar_boton_videojuego();
		actualizar_boton_trabajadores();
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	public void estadisticas_validas() {
		Estadisticas esta = new Estadisticas(Interfaz_principal.this,comp);
		esta.setVisible(true);	
	}
	public void ingresar_compañia(){
		Ingresar_compañia ingresar = new Ingresar_compañia(Interfaz_principal.this,comp);
		ingresar.setVisible(true);
		actualizar_boton_trabajadores();
		actualizar_boton_videojuego();
	}
	public void ingresar_videojuego() {
			Ingresar_videojuego videojuego = new Ingresar_videojuego(Interfaz_principal.this,comp);
			videojuego.setVisible(true);
	}
	public void actualizar_boton_trabajadores() {
		if(comp.getNombre().isEmpty()) {
			Trabajadores_Boton.setEnabled(false);
		}
		else {
			Trabajadores_Boton.setEnabled(true);
		}
	}
	public void actualizar_boton_videojuego() {
		if(comp.getPresidente() == null || comp.getVicepresindete() == null || comp.getTrabajadores().size() == 0) {
			Videojuegos_boton.setEnabled(false);
			Estadisticas_generales_Boton.setEnabled(false);
		}
		else {
			Videojuegos_boton.setEnabled(true);
			Estadisticas_generales_Boton.setEnabled(true);
		}
	}
}
