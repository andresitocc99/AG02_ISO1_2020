package Presentacion;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

public class JFrameValorar extends JFrame {
	
	private JPanel contentPane;
	private JTextPane textPaneEstado;
	private JList list = new JList();
	private JFrame frameValorar;
	private JFormattedTextField textFieldNota;
	
	public JFrameValorar() throws ParseException {
	frameValorar= new JFrame();
	setTitle("Valoración del servicio");
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	setBounds(100, 100, 455, 310);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	this.setResizable(false);
	
	MaskFormatter mascara = new MaskFormatter("#");
	textFieldNota = new JFormattedTextField(mascara);
	textFieldNota.setBounds(200,70,30,30);
	contentPane.add(textFieldNota);
	
	JLabel label = new JLabel("Introduzca una nota en función de la atencion recibida (1-5)");
	label.setBounds(60, 15, 420, 65);
	contentPane.add(label);
	
	JLabel lblEstado = new JLabel("Estado");
	lblEstado.setForeground(Color.RED);
	lblEstado.setBounds(6, 155, 61, 16);
	contentPane.add(lblEstado);

	textPaneEstado = new JTextPane();
	textPaneEstado.setToolTipText(
			"Panel para mostrar el restultado de la comprobación de login o las excepciones lanzadas");
	textPaneEstado.setEditable(false);
	textPaneEstado.setBounds(6, 182, 406, 50);
	contentPane.add(textPaneEstado);
	
	JButton btnValorar = new JButton("Enviar");
	btnValorar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
			int valor = Integer.parseInt(textFieldNota.getText());
			if(valor>0 && valor<6){
				dispose();
			} else {
				textPaneEstado.setText("No has introducido un número entre 1 y 5");
			}
		} catch (Exception excep) {
			textPaneEstado.setText("Debes introducir un número");
		}
		}
	});
	btnValorar.setBounds(150, 110, 148, 28);
	contentPane.add(btnValorar);
	
	
}
	
		
}