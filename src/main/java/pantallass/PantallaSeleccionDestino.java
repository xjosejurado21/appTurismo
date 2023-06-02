package pantallass;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import clases.Destino;
import clases.Usuario;
import excepciones.ConexionFallidaException;
import jbdc.DAO;

import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JSpinner;
import javax.swing.JComboBox;

//Aquí necesitarás implementar la clase PantallaSeleccionDestino
public class PantallaSeleccionDestino extends JPanel {
    
    private JLabel lblImagen;
    private JComboBox<String> comboDestino;
    private ArrayList<Destino> destinos;
    private Destino destinoSeleccionado = null;
    private Ventana ventana;
    

    public PantallaSeleccionDestino(Ventana v) {
        
    	this.ventana = v;
      /*  getContentPane().setLayout(new BorderLayout(0, 0));
        
     JPanel panel = new JPanel();
     getContentPane().add(panel, BorderLayout.CENTER);*/
     GridBagLayout gbl_panel = new GridBagLayout();
     gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
     gbl_panel.rowHeights = new int[]{0, 0, 0, 200, 100, 0, 0};
     gbl_panel.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
     gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
     setLayout(gbl_panel);
     
     JLabel lblInfoDestino = new JLabel("Seleccione un destino:");
     GridBagConstraints gbc_lblInfoDestino = new GridBagConstraints();
     gbc_lblInfoDestino.insets = new Insets(0, 0, 5, 5);
     gbc_lblInfoDestino.gridx = 1;
     gbc_lblInfoDestino.gridy = 1;
     add(lblInfoDestino, gbc_lblInfoDestino);
     
     JComboBox<String> comboDestino = new JComboBox<String>();
     GridBagConstraints gbc_comboDestino = new GridBagConstraints();
     gbc_comboDestino.insets = new Insets(0, 0, 5, 5);
     gbc_comboDestino.fill = GridBagConstraints.HORIZONTAL;
     gbc_comboDestino.gridx = 1;
     gbc_comboDestino.gridy = 2;
    add(comboDestino, gbc_comboDestino);
     
     JLabel lblImagen = new JLabel();
 	GridBagConstraints gbc_lblImagen = new GridBagConstraints();
 	 gbc_lblImagen.gridwidth = 3;
 	 gbc_lblImagen.insets = new Insets(0, 0, 5, 5);
 	 gbc_lblImagen.gridx = 1;
 	 gbc_lblImagen.gridy = 3;
 	 
 	 lblImagen.setMaximumSize(new Dimension(300,200));
 	 add(lblImagen, gbc_lblImagen);
 	 
 	 
 	  JLabel lblDescripcionCiudad = new JLabel("New label");
 	  lblDescripcionCiudad.setMinimumSize(new Dimension(500,200));
      GridBagConstraints gbc_lblDescripcionCiudad = new GridBagConstraints();
      gbc_lblDescripcionCiudad.gridwidth = 3;
      gbc_lblDescripcionCiudad.insets = new Insets(0, 0, 5, 5);
      gbc_lblDescripcionCiudad.gridx = 1;
      gbc_lblDescripcionCiudad.gridy = 4;
      add(lblDescripcionCiudad, gbc_lblDescripcionCiudad);
      
     
     
     //Items
     
     try {
    	 destinos = DAO.todosDestinos();
    	 
    	 for (int i = 0; i < destinos.size(); i++) {
			
    		 comboDestino.addItem(destinos.get(i).getNombre());	  
    		 
		}
    	 
    	 
    	 
    	//Acción
         comboDestino.addItemListener(new ItemListener() {
             public void itemStateChanged(ItemEvent event) {
                 if (event.getStateChange() == ItemEvent.SELECTED) {
                     Object item = event.getItem();
                     String ciudad = item.toString();

                     String nombreArchivo="";
                     
                     for (int i = 0; i < destinos.size(); i++) {
						
                    	 if(destinos.get(i).getNombre().equals(ciudad)) {
                    		 
                    		 try {
	                    		 //Cargar descripcion
	                    		 String texto= "<html>"+destinos.get(i).getDescripcion()+"</html>";
	                    		 
	                    		 
	                    		 lblDescripcionCiudad.setText(texto);
	                    		 
	                    		 
	                    		 //Cargar imagen
	                    		 nombreArchivo = destinos.get(i).getRuta();
	                    		 BufferedImage myPicture;
                            	 File file = new File("src\\main\\java\\recursos\\Destinos\\"+nombreArchivo);
                                 myPicture = ImageIO.read(file);
                                 myPicture.getScaledInstance(200, 200,Image.SCALE_SMOOTH);
                                 lblImagen.setIcon(new ImageIcon(myPicture));
                                 
                                 //Seleccióin destino
                                 destinoSeleccionado = destinos.get(i);
                                 
                                 
                                 
                             } catch (Exception e) {
                                 e.printStackTrace();
                             }
                    	 }
                    	 
					}

                 }
             }
         });	 
	} catch (ConexionFallidaException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
     
     
     
     
     
     
     
 

  // Asegúrate de cambiar el booleano anterior cuando el destino es seleccionado en tu aplicación.

  JButton btnContinuar = new JButton("Seleccionar destino");
  GridBagConstraints gbc_btnContinuar = new GridBagConstraints();
  gbc_btnContinuar.insets = new Insets(0, 0, 0, 5);
  gbc_btnContinuar.gridx = 3;
  gbc_btnContinuar.gridy = 5;

  // Agrega un ActionListener al botón. Este código se ejecutará cada vez que se haga clic en el botón.
  btnContinuar.addActionListener(new ActionListener() {

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(destinoSeleccionado ==null) {
			JOptionPane.showMessageDialog(null, "Por favor selecciona un destino antes de continuar.");
		}else {
			
			
			v.setDestinoSeleccionado(destinoSeleccionado);
			v.irAPantallaServicios();
			
			
		}         
	}
  });

  add(btnContinuar, gbc_btnContinuar);

  // Este es un método de ejemplo para cambiar a la siguiente pestaña. 
  // Deberás implementar algo similar en tu aplicación, de acuerdo a cómo esté estructurado tu código.
  

	
     
     
   
	
     
     
 }
}
