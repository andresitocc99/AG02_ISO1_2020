package Presentacion;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dominio.GestorIncidencia;
import Dominio.Incidencia;
import Dominio.Usuario;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class JFrameCliente extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextPane textPaneEstado;
	private JList list = new JList();

public JFrameCliente() {
	setTitle("Interfaz Cliente");
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	setBounds(100, 100, 450, 330);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	this.setResizable(false);
	
	
	// BOTON ABRIR INCIDENCIA
	JButton buttonAbrirIncidencia = new JButton("Abrir Incidencia");
	buttonAbrirIncidencia.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			
		}
	});
	
	buttonAbrirIncidencia.setBounds(185, 20, 148, 29);
	contentPane.add(buttonAbrirIncidencia);
	
	JCheckBox elegirValorar = new JCheckBox();
	contentPane.add(elegirValorar);
	elegirValorar.setBounds(180,95,25,25);
	// BOTON CERRAR INCIDENCIA
	
	JButton buttonCerrarIncidencia = new JButton("Cerrar Incidencia");
	buttonCerrarIncidencia.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			try {
				int IncidenciaCerrada=0;
				IncidenciaCerrada=GestorIncidencia.cerrarIncidencia((long)list.getSelectedValue(), JFrameLogin.textFieldLog.getText());
				if(IncidenciaCerrada==1) {
					Vector<Incidencia> V= GestorIncidencia.leerIncidenciasCliente(JFrameLogin.textFieldLog.getText());
					DefaultListModel modelo = new DefaultListModel();
					for (int i = 0; i <= V.size() - 1; i++) {
						modelo.addElement(V.get(i).getID_Incidencia());
					}
					list.setModel(modelo);
					if(elegirValorar.isSelected()) {
						JFrameValorar JFrameValorar = new JFrameValorar();
						JFrameValorar.setVisible(true);
					} 
					textPaneEstado.setText("Incidencia cerrada correctamente");
				}
			} catch (Exception e) {
				textPaneEstado.setText("Selecciona una incidencia!");
			}
		}
	});
	buttonCerrarIncidencia.setBounds(185, 60, 148, 29);
	contentPane.add(buttonCerrarIncidencia);
	
	JButton btnEliminarCliente = new JButton("Eliminar Cliente");
	btnEliminarCliente.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			boolean eliminado = false;
				try {
					Usuario u = new Usuario (JFrameLogin.textFieldLog.getText());
					if (u.delete()==1)
						eliminado=true;
					if (eliminado) {
						textPaneEstado.setText("Usuario borrado correctamente");
					}
					else {
						textPaneEstado.setText("No se ha podido borrar el usuario");
					}
					
				} catch (Exception e) {
					textPaneEstado.setText("No se ha podido eliminar el usuario. ¿Tal vez ya no existe?");
				}
			
			
		}
	});
	btnEliminarCliente.setBounds(20, 235, 148, 28);
	contentPane.add(btnEliminarCliente);
	
	list.setBounds(20,10,150,150);
	contentPane.add(list);
	Vector<Incidencia> V= GestorIncidencia.leerIncidenciasCliente(JFrameLogin.textFieldLog.getText());
	JButton buttonListaIncidencia = new JButton("Leer lista incidencias");
	buttonListaIncidencia.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			DefaultListModel modelo = new DefaultListModel();
			for (int i = 0; i <= V.size() - 1; i++) {
				modelo.addElement(V.get(i).getID_Incidencia());
			}
			textPaneEstado.setText("Lista de incidencias leida correctamente!");
			list.setModel(modelo);
		}
	});
	buttonListaIncidencia.setBounds(20,170,150,40);
	contentPane.add(buttonListaIncidencia);
	
	textPaneEstado = new JTextPane();
	textPaneEstado.setToolTipText(
			"Panel para dar feedback al usuario despues de realizar una acción");
	textPaneEstado.setEditable(false);
	textPaneEstado.setText("Bienvenido a SIGEDIT, ahora mismo estás logueado como cliente");
	textPaneEstado.setBounds(190, 150, 170, 102);
	contentPane.add(textPaneEstado);
	
	JLabel textValorar= new JLabel();
	textValorar.setBounds(210,95,195,29);
	textValorar.setText("Deseo valorar la atención recibida");
	contentPane.add(textValorar);
	
}

}