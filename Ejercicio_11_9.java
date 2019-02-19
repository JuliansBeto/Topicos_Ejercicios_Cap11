// Fig. 11.9: CampoTextoMarco.java 2 
// Demostración de la clase JTextField.
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Ejercicio_11_9 extends JFrame
{
	private JTextField campoTexto1;
	private JTextField campoTexto2;
	private JTextField campoTexto3;
	private JPasswordField campoContrasenia;
	
	public static void main (String[] args) 
	{
		Ejercicio_11_9 campoTextoMarco = new Ejercicio_11_9();
		campoTextoMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		campoTextoMarco.setSize(350,100);
		campoTextoMarco.setVisible( true );
	}
	
    public Ejercicio_11_9() 
    {
    	super( "Prueba de JTextfield y JPasswordField" );
    	setLayout( new FlowLayout() );
    	
    	campoTexto1 = new JTextField( 10 );
    	add( campoTexto1 );
    	
    	campoTexto2 = new JTextField( "Escriba el texto aqui" );
    	add( campoTexto2 ); // agrega campoTexto2 a JFrame
    	
    	campoTexto3 = new JTextField( "Campo de texto no editable", 21 );
		campoTexto3.setEditable( false ); // deshabilita la edición
		add( campoTexto3 ); // agrega campoTexto3 a JFrame
		
		campoContrasenia = new JPasswordField( "Texto oculto" );
		add( campoContrasenia ); // agrega campoContrasenia a JFrame
		
		ManejadorCampoTexto manejador = new ManejadorCampoTexto();
		campoTexto1.addActionListener( manejador );
		campoTexto2.addActionListener( manejador );
		campoTexto3.addActionListener( manejador );
		campoContrasenia.addActionListener( manejador );
    }
    
    // clase interna privada para el manejo de eventos
    private class ManejadorCampoTexto implements ActionListener
    {
    	// procesa los eventos de campo de texto
		public void actionPerformed( ActionEvent evento )
		{
			String cadena = "";
			
			if ( evento.getSource() == campoTexto1 )
				cadena = String.format( "campoTexto1: %s",
					evento.getActionCommand() );
					
			else if ( evento.getSource() == campoTexto2 )
				cadena = String.format( "campoTexto2: %s",
					evento.getActionCommand() );
					
			else if ( evento.getSource() == campoTexto3 )
				cadena = String.format( "campoTexto3: %s",
					evento.getActionCommand() );
					
			else if ( evento.getSource() == campoContrasenia )
				cadena = String.format( "campoContrasenia: %s",
					new String( campoContrasenia.getPassword() ) );
			
			JOptionPane.showMessageDialog( null, cadena );
		}
    }
    
   
}