package Presentacion;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dominio.GestorTecnico;
import Dominio.Incidencia;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;


public class JFrameTecnico extends JFrame{
	

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextPane textPaneEstado;
	private JList list = new JList();
	
	public JFrameTecnico() {
		setTitle("Interfaz Tecnico");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(200, 200, 500, 230);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setResizable(false);

		list.setBounds(20,45,60,120);
		contentPane.add(list);
		Vector<Incidencia> V= GestorTecnico.leerIncidencias();
		
		JButton buttonListaIncidencia = new JButton("Leer lista incidencias");
		buttonListaIncidencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultListModel modelo = new DefaultListModel();
				for (int i = 0; i <= V.size() - 1; i++) {
					modelo.addElement(V.get(i).getID_Incidencia()+" "+V.get(i).getUsername());
				}
				textPaneEstado.setText("Lista de incidencias leida correctamente!");
				list.setModel(modelo);
			}
		});
		buttonListaIncidencia.setBounds(100,20,170,40);
		contentPane.add(buttonListaIncidencia);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setForeground(Color.RED);
		lblEstado.setBounds(100, 80, 61, 16);
		contentPane.add(lblEstado);

		JLabel lblIncidencia = new JLabel("Incidencias");
		lblIncidencia.setForeground(Color.RED);
		lblIncidencia.setBounds(10, 10, 80, 16);
		contentPane.add(lblIncidencia);
		
		textPaneEstado = new JTextPane();
		textPaneEstado.setToolTipText(
				"Panel para dar feedback al usuario despues de realizar una acción");
		textPaneEstado.setEditable(false);
		textPaneEstado.setText("Bienvenido a SIGEDIT, ahora mismo estás logueado como técnico");
		textPaneEstado.setBounds(100, 97, 360, 50);
		contentPane.add(textPaneEstado);
		
		JButton buttonRealizarInforme = new JButton("Realizar Informe");
		buttonRealizarInforme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		buttonRealizarInforme.setBounds(290,20,180,40);
		contentPane.add(buttonRealizarInforme);
	}

}
