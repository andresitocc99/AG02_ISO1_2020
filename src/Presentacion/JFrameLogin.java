package Presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Choice;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

import Dominio.GestorUsuario;

public class JFrameLogin extends JFrame  {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JTextField textFieldLog;
	private JTextField textFieldPass;
	private JTextPane textPaneEstado;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameLogin frame = new JFrameLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public JFrameLogin() {
		setTitle("SIGEDIT LOGIN");
		this.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 438, 385);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Choice tipoLogin= new Choice();
		tipoLogin.addItem("Cliente");
		tipoLogin.addItem("ClienteVIP");
		tipoLogin.addItem("Técnico");
		tipoLogin.setBounds(86, 164, 134, 28);
		contentPane.add(tipoLogin);

		JLabel lblIntroduzcaElLogin = new JLabel("Introduzca el login y el password para acceder al sistema");
		lblIntroduzcaElLogin.setBounds(6, 19, 386, 43);
		contentPane.add(lblIntroduzcaElLogin);

		textFieldLog = new JTextField();
		textFieldLog.setBounds(86, 68, 134, 28);
		contentPane.add(textFieldLog);
		textFieldLog.setColumns(10);

		JLabel lblLogin = new JLabel("Password:");
		lblLogin.setBounds(6, 122, 73, 16);
		contentPane.add(lblLogin);

		JLabel label = new JLabel("Login:");
		label.setBounds(6, 74, 61, 16);
		contentPane.add(label);

		textFieldPass = new JPasswordField();
		textFieldPass.setColumns(10);
		textFieldPass.setBounds(86, 116, 134, 28);
		contentPane.add(textFieldPass);

		JButton buttonAceptar = new JButton("Aceptar");
		buttonAceptar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				boolean existe = false;
				try {
					if (GestorUsuario.login(textFieldLog.getText(), textFieldPass.getText(), tipoLogin.getSelectedItem()) != 0)
						existe = true;
					if (existe) {
						textPaneEstado.setText("El login ha  sido correcto");
						if(tipoLogin.getSelectedItem().equals("Cliente")) {
							JFrameCliente frame = new JFrameCliente();
							frame.setVisible(true);
						} else if(tipoLogin.getSelectedItem().equals("Técnico")) {
							JFrameTecnico frameTecnico= new JFrameTecnico();
							frameTecnico.setVisible(true);
						}else {
							
						}
						
					} else {
						textPaneEstado.setText("El login ha sido incorrecto");
					}
				} catch (Exception e) {
					textPaneEstado.setText("Ha ocurrido un error, vuelva a intentarlo" + e.toString());
				}

			}
		});
		buttonAceptar.setBounds(264, 69, 148, 29);
		contentPane.add(buttonAceptar);

		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setForeground(Color.RED);
		lblEstado.setBounds(6, 208, 61, 16);
		contentPane.add(lblEstado);

		textPaneEstado = new JTextPane();
		textPaneEstado.setToolTipText(
				"Panel para mostrar el restultado de la comprobación de login o las excepciones lanzadas");
		textPaneEstado.setEditable(false);
		textPaneEstado.setBounds(6, 235, 406, 102);
		contentPane.add(textPaneEstado);
		
		
		JLabel lblTipoUsuario = new JLabel("Tipo usuario:");
		lblTipoUsuario.setBounds(6, 164, 73, 16);
		contentPane.add(lblTipoUsuario);
		
		JButton buttonLimpiar = new JButton("Limpiar");
		buttonLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textPaneEstado.setText("");
				textFieldPass.setText("");
				textFieldLog.setText("");
			}
		});
		buttonLimpiar.setBounds(264, 117, 148, 29);
		contentPane.add(buttonLimpiar);

		JButton btnNuevoUsuario = new JButton("Nuevo Cliente");
		btnNuevoUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrameNuevoCliente frame = new JFrameNuevoCliente();
				frame.setVisible(true);
			}
		});
		btnNuevoUsuario.setBounds(264, 170, 148, 29);
		contentPane.add(btnNuevoUsuario);
	}

}
