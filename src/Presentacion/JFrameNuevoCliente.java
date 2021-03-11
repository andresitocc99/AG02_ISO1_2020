package Presentacion;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import Dominio.Usuario;


import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Color;

import javax.swing.JTextPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFrameNuevoCliente extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldLogin;
	private JTextField textFieldPassword;
	private JTextPane textPane;

	public JFrameNuevoCliente() {
		setTitle("Registrar un nuevo cliente");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 420, 285);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setResizable(false);
		JLabel lblLogin = new JLabel("Password:");
		lblLogin.setBounds(6, 81, 69, 16);
		contentPane.add(lblLogin);
		
		JLabel label = new JLabel("Username:");
		label.setBounds(6, 37, 69, 16);
		contentPane.add(label);
		
		textFieldLogin = new JTextField();
		textFieldLogin.setBounds(87, 31, 134, 28);
		contentPane.add(textFieldLogin);
		textFieldLogin.setColumns(10);
		
		textFieldPassword = new JPasswordField();
		textFieldPassword.setColumns(10);
		textFieldPassword.setBounds(87, 75, 134, 28);
		contentPane.add(textFieldPassword);
		
		JButton btnAltaUsuario = new JButton("Alta usuario");
		btnAltaUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean insertado = false;
				try {
					Usuario u = new Usuario(textFieldLogin.getText(), textFieldPassword.getText(),"",1);
					if(u.insert() ==1)
						insertado = true;
					
					if(insertado){
						textPane.setText("Usuario creado correctamente");
					} else {
						textPane.setText("No se ha podido insertar el usuario");
					}
					
				} catch (Exception e) {
					textPane.setText("No se ha podido crear  el usuario.¿Tal vez ya existe?");
				}
				
			}
		});
		btnAltaUsuario.setBounds(253, 76, 117, 29);
		contentPane.add(btnAltaUsuario);
		
		JLabel label_1 = new JLabel("Estado");
		label_1.setForeground(Color.RED);
		label_1.setBounds(6, 126, 61, 16);
		contentPane.add(label_1);
		
		textPane = new JTextPane();
		textPane.setToolTipText("Panel para mostrar el restultado de la comprobaci\u00F3n de login o las excepciones lanzadas");
		textPane.setEditable(false);
		textPane.setBounds(6, 154, 407, 102);
		contentPane.add(textPane);
	}
}
