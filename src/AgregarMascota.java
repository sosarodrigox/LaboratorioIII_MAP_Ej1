import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.ScrollPane;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AgregarMascota extends JFrame {

	private JPanel contentPane;
	protected JPanel panel;
	protected JLabel lblNewLabel;
	protected JTextField txtNombre;
	protected JLabel lblRaza;
	protected JTextField txtRaza;
	protected JLabel lblEdad;
	protected JTextField txtEdad;
	protected JLabel lblNDeMascota;
	protected JTextField txtNroMasc;
	protected JButton btnAgregar;
	protected JButton btnFinalizar;

	/**
	 * Launch the application.
	 */
	static ControlMascotas controlM = new ControlMascotas();
	protected String[][] arrayMascotas;
	protected JLabel lbl_Info;
	protected JButton btnBuscar;
	protected JButton btnClaves;
	protected JButton btnValor;
	protected JButton btnCV;
	protected JPanel panel_1;
	protected JTable tablaMascotas;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					agregarMascotas();
					AgregarMascota frame = new AgregarMascota();
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
	
	public AgregarMascota() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 732, 343);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(10, 11, 281, 282);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setBounds(24, 14, 88, 14);
		panel.add(lblNewLabel);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(122, 11, 133, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		lblRaza = new JLabel("Raza:");
		lblRaza.setBounds(24, 42, 88, 14);
		panel.add(lblRaza);
		
		txtRaza = new JTextField();
		txtRaza.setColumns(10);
		txtRaza.setBounds(122, 39, 133, 20);
		panel.add(txtRaza);
		
		lblEdad = new JLabel("Edad:");
		lblEdad.setBounds(24, 73, 88, 14);
		panel.add(lblEdad);
		
		txtEdad = new JTextField();
		txtEdad.setColumns(10);
		txtEdad.setBounds(122, 70, 133, 20);
		panel.add(txtEdad);
		
		lblNDeMascota = new JLabel("N\u00B0 de Mascota:");
		lblNDeMascota.setBounds(24, 220, 88, 14);
		panel.add(lblNDeMascota);
		
		txtNroMasc = new JTextField();
		txtNroMasc.setColumns(10);
		txtNroMasc.setBounds(105, 217, 66, 20);
		panel.add(txtNroMasc);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = txtNombre.getText();
				String raza=txtRaza.getText();
				int edad=Integer.parseInt(txtEdad.getText());
				Integer nroMascota=controlM.agregarMascota(nombre,raza,edad);
				lbl_Info.setText("Mascota agregada a la lista con Numero de mascota: "+nroMascota);
				txtNroMasc.setText(nroMascota.toString());
				muestroTabla();
			}

			protected void muestroTabla() {
				// TODO Auto-generated method stub
				int filas=controlM.getMapMascotas().size();
				String[][] arrayMasc = new String[filas][4];//4=Cant. de columnas.
				int columna=0;
				Mascota temp;
				
				for(Iterator it =controlM.getMapMascotas().entrySet().iterator();it.hasNext();) {
					Entry ee=(Entry) it.next();
					temp=(Mascota) ee.getValue();
					arrayMasc[columna][0]=String.valueOf(temp.getNombre());
					arrayMasc[columna][1]=String.valueOf(temp.getRaza());
					arrayMasc[columna][2]=String.valueOf(temp.getEdad());
					arrayMasc[columna][3]=String.valueOf(temp.getNroMascota());
					columna++;
					//Fin cargo tabla
				}
				//Muestro tabla en JFrame, busco y copio definición de tabla y 
				//reemplazo por map
				tablaMascotas.setModel(new DefaultTableModel(
						arrayMasc,
						new String[] {
							"Nombre", "Raza", "Edad", "Nro. ID"
						}
					));
			}
		});
		btnAgregar.setBounds(10, 143, 71, 23);
		panel.add(btnAgregar);
		
		btnFinalizar = new JButton("Finalizar");
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnFinalizar.setBounds(183, 248, 88, 23);
		panel.add(btnFinalizar);
		
		lbl_Info = new JLabel("New label");
		lbl_Info.setBounds(24, 98, 231, 14);
		panel.add(lbl_Info);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mascota mascotaBusc=controlM.buscarMascota(Integer.parseInt(txtNroMasc.getText()));
				if(mascotaBusc!=null) {
					JOptionPane.showMessageDialog(null, "La mascota buscada es:\n" + mascotaBusc.toString());
				}
				else {
					JOptionPane.showMessageDialog(null, "La mascota buscada no existe en el registro");
				}
			}
		});
		btnBuscar.setBounds(181, 216, 90, 23);
		panel.add(btnBuscar);
		
		btnClaves = new JButton("Key");
		btnClaves.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> listK=controlM.listadoClaves();
				JOptionPane.showMessageDialog(null, "Listado de claves: \n" + listK.toString());
			}
		});
		btnClaves.setBounds(10, 177, 71, 23);
		panel.add(btnClaves);
		
		btnValor = new JButton("Value");
		btnValor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> listV=controlM.listadoObjetos();
				JOptionPane.showMessageDialog(null, "Listado de Mascotas: \n" + listV.toString());
			}
		});
		btnValor.setBounds(103, 177, 68, 23);
		panel.add(btnValor);
		
		btnCV = new JButton("Key/Value");
		btnCV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> listKV=controlM.listClaveValor();
				JOptionPane.showMessageDialog(null, "Listado de Mascotas: \n" + listKV.toString());
			}
		});
		btnCV.setBounds(187, 177, 84, 23);
		panel.add(btnCV);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(301, 11, 405, 282);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		tablaMascotas = new JTable();
		tablaMascotas.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Nombre", "Raza", "Edad", "Nro. ID"
			}
		));
		
		tablaMascotas.setBounds(10, 11, 385, 248);
		panel_1.add(tablaMascotas);
	}
	public static void agregarMascotas() {
		controlM.agregarMascota("Ninna", "Boarder Collie", 6);
		controlM.agregarMascota("Chopol", "Mestiza", 17);
		controlM.agregarMascota("Pechu", "Mestizo", 11);
		controlM.agregarMascota("Pecha", "Pastor Aleman", 3);
		controlM.agregarMascota("Perico", "Loro", 25);
	}
}


