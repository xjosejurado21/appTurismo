package pantallass;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import clases.Usuario;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JSpinner;
import javax.swing.JComboBox;

//Aquí necesitarás implementar la clase PantallaSeleccionDestino
public class PantallaSeleccionDestino extends JFrame {
    private Connection connection;
    private JLabel lblImagen;
    private JComboBox<String> comboDestino;

    public PantallaSeleccionDestino(Usuario user, Connection connection) {
        super("Página principal");
        this.connection = connection;
        getContentPane().setLayout(new BorderLayout(0, 0));
        
     JPanel panel = new JPanel();
     getContentPane().add(panel, BorderLayout.CENTER);
     GridBagLayout gbl_panel = new GridBagLayout();
     gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
     gbl_panel.rowHeights = new int[]{0, 0, 0, 200, 100, 0};
     gbl_panel.columnWeights = new double[]{1.0, 1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
     gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
     panel.setLayout(gbl_panel);
     
     JLabel lblInfoDestino = new JLabel("Seleccione un destino:");
     GridBagConstraints gbc_lblInfoDestino = new GridBagConstraints();
     gbc_lblInfoDestino.insets = new Insets(0, 0, 5, 5);
     gbc_lblInfoDestino.gridx = 1;
     gbc_lblInfoDestino.gridy = 1;
     panel.add(lblInfoDestino, gbc_lblInfoDestino);
     
     JLabel lblInfoFecha = new JLabel("Seleccione un mes:");
     GridBagConstraints gbc_lblInfoFecha = new GridBagConstraints();
     gbc_lblInfoFecha.insets = new Insets(0, 0, 5, 5);
     gbc_lblInfoFecha.gridx = 3;
     gbc_lblInfoFecha.gridy = 1;
     panel.add(lblInfoFecha, gbc_lblInfoFecha);
     
     JComboBox comboDestino = new JComboBox();
     GridBagConstraints gbc_comboDestino = new GridBagConstraints();
     gbc_comboDestino.insets = new Insets(0, 0, 5, 5);
     gbc_comboDestino.fill = GridBagConstraints.HORIZONTAL;
     gbc_comboDestino.gridx = 1;
     gbc_comboDestino.gridy = 2;
     panel.add(comboDestino, gbc_comboDestino);
     
     //Items
     comboDestino.addItem("Málaga");
     comboDestino.addItem("Madrid");
     comboDestino.addItem("Vigo");
     comboDestino.addItem("Cádiz");

    //Acción
     comboDestino.addItemListener(new ItemListener() {
         public void itemStateChanged(ItemEvent event) {
             if (event.getStateChange() == ItemEvent.SELECTED) {
                 Object item = event.getItem();
                 String selectedCity = item.toString();

                 String imagePath = "";

                 switch(selectedCity) {
                     case "Málaga":
                         imagePath = "C:\\Users\\imjos\\Downloads\\malaga.jpg";
                         break;
                     case "Madrid":
                         imagePath = "C:\\Users\\imjos\\Downloads\\madrid.jpg";
                         break;
                     case "Vigo":
                         imagePath = "C:\\Users\\imjos\\Downloads\\vigo.jpg";
                         break;
                     case "Cádiz":
                         imagePath = "C:\\Users\\imjos\\Downloads\\cadiz.jpg";
                         break;
                 }

                 BufferedImage myPicture;
                 try {
                     myPicture = ImageIO.read(new File(imagePath));
                     myPicture.getScaledInstance(100, 100, DO_NOTHING_ON_CLOSE);
                     lblImagen.setIcon(new ImageIcon(myPicture));
                 } catch (IOException e) {
                     e.printStackTrace();
                 }
             }
         }
     });
     
     
     
     
     
     JComboBox comboFecha = new JComboBox();
     GridBagConstraints gbc_comboFecha = new GridBagConstraints();
     gbc_comboFecha.insets = new Insets(0, 0, 5, 5);
     gbc_comboFecha.fill = GridBagConstraints.HORIZONTAL;
     gbc_comboFecha.gridx = 3;
     gbc_comboFecha.gridy = 2;
     panel.add(comboFecha, gbc_comboFecha);
     
     comboFecha.addItem("Enero");
     comboFecha.addItem("Febrero");
     comboFecha.addItem("Marzo");
     comboFecha.addItem("Abril");
     comboFecha.addItem("Mayo");
     comboFecha.addItem("Junio");
     comboFecha.addItem("Julio");
     comboFecha.addItem("Agosto");
     comboFecha.addItem("Septiembre");
     comboFecha.addItem("Octubre");
     comboFecha.addItem("Noviembre");
     comboFecha.addItem("Diciembre");
     
     setSize(800, 600);
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     setLocationRelativeTo(null);
     setVisible(true);
     getContentPane().add(panel);
     BufferedImage myPicture;
	try {
		myPicture = ImageIO.read(new File("C:\\Users\\imjos\\Downloads\\malaga.jpg"));
		myPicture.getScaledInstance(100, 100, DO_NOTHING_ON_CLOSE);
		JLabel lblImagen = new JLabel(new ImageIcon(myPicture));
	    GridBagConstraints gbc_lblImagen = new GridBagConstraints();
	     gbc_lblImagen.gridwidth = 3;
	     gbc_lblImagen.insets = new Insets(0, 0, 5, 5);
	     gbc_lblImagen.gridx = 1;
	     gbc_lblImagen.gridy = 3;
	     panel.add(lblImagen, gbc_lblImagen);
	     
	     
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
     
     JLabel lblDescripcionCiudad = new JLabel("New label");
     GridBagConstraints gbc_lblDescripcionCiudad = new GridBagConstraints();
     gbc_lblDescripcionCiudad.gridwidth = 3;
     gbc_lblDescripcionCiudad.insets = new Insets(0, 0, 0, 5);
     gbc_lblDescripcionCiudad.gridx = 1;
     gbc_lblDescripcionCiudad.gridy = 4;
     panel.add(lblDescripcionCiudad, gbc_lblDescripcionCiudad);
 }
}
