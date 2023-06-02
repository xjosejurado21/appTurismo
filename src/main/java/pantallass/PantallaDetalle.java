package pantallass;

import javax.swing.JPanel;

import clases.CentroComercial;
import clases.Evento;
import clases.Museo;
import clases.Restaurante;
import clases.Servicio;
import clases.ServicioConHorario;
import clases.ServicioConPrecio;
import excepciones.ServicioYaPresenteException;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaDetalle extends JPanel {

	private Ventana ventana;

	public PantallaDetalle(Ventana v, Servicio servicio) {
		this.ventana = v;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblNombre = new JLabel("New label");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 30));
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.WEST;
		gbc_lblNombre.gridwidth = 2;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 1;
		add(lblNombre, gbc_lblNombre);
		
		JButton btnExportar = new JButton("Exportar servicio");
		btnExportar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
		        	String nombreArchivo = "ServiciosGuardados.txt";
		        	
		        	
		        	File file = new File(nombreArchivo);
		        	
		        	if(!file.exists()) {
		        		file.createNewFile();
		        	}
		        
		        		      
		        	BufferedReader reader=new BufferedReader(new FileReader(nombreArchivo));
		        	FileWriter writer = new FileWriter(file, true);
		        	
		        	
		        	
		        	String linea=""; 
		        	while(linea!=null){ 
		        	      
		        	      if(linea.contains(servicio.getNombre())) {
		        	    	  	reader.close();
		  					
		  						writer.close();
		        	    	  throw new ServicioYaPresenteException();
		        	      }
		        	      linea=reader.readLine(); //Leo la siguiente línea. Cuando no queden más, devolverá null y parará el while
		        	}
		        	
					
					if (servicio instanceof Museo) {
						Museo museo = (Museo) servicio;
						writer.write(museo.toString()+"\n\n");
						
					}

					if (servicio instanceof Evento) {
						Evento ev = (Evento) servicio;
						writer.write(ev.toString()+"\n\n");
					}
					
					
					if (servicio instanceof Restaurante) {
						Restaurante res = (Restaurante)servicio;
						writer.write(res.toString()+"\n\n");
						
						
					}
					
					if (servicio instanceof CentroComercial) {
						CentroComercial centro = (CentroComercial)servicio;
						writer.write(centro.toString()+"\n\n");
						
					}
					
					
					
					reader.close();
					writer.flush();
					writer.close();
					JOptionPane.showMessageDialog(v,
							"El servicio fue insertado con éxito");
					
					
				} catch (IOException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}catch (ServicioYaPresenteException ex){
					JOptionPane.showMessageDialog(v,
							ex.getMessage());
					
				}
		        

				
				
				
			}
		});
		
		
		
		
        
		
		
		
		GridBagConstraints gbc_btnExportar = new GridBagConstraints();
		gbc_btnExportar.insets = new Insets(0, 0, 5, 5);
		gbc_btnExportar.gridx = 3;
		gbc_btnExportar.gridy = 1;
		add(btnExportar, gbc_btnExportar);

		JLabel lblNewLabel = new JLabel("Descripción: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 2;
		add(lblNewLabel, gbc_lblNewLabel);

		JLabel lblDescripcion = new JLabel("New label");
		lblDescripcion.setHorizontalAlignment(SwingConstants.LEFT);
		lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblDescripcion = new GridBagConstraints();
		gbc_lblDescripcion.gridheight = 2;
		gbc_lblDescripcion.anchor = GridBagConstraints.WEST;
		gbc_lblDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescripcion.gridx = 2;
		gbc_lblDescripcion.gridy = 2;
		add(lblDescripcion, gbc_lblDescripcion);

		JLabel lblUrl_1 = new JLabel("URL: ");
		lblUrl_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		GridBagConstraints gbc_lblUrl_1 = new GridBagConstraints();
		gbc_lblUrl_1.anchor = GridBagConstraints.WEST;
		gbc_lblUrl_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblUrl_1.gridx = 1;
		gbc_lblUrl_1.gridy = 4;
		add(lblUrl_1, gbc_lblUrl_1);

		JLabel lblUrl = new JLabel("New label");
		lblUrl.setHorizontalAlignment(SwingConstants.LEFT);
		lblUrl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblUrl = new GridBagConstraints();
		gbc_lblUrl.anchor = GridBagConstraints.WEST;
		gbc_lblUrl.insets = new Insets(0, 0, 5, 5);
		gbc_lblUrl.gridx = 2;
		gbc_lblUrl.gridy = 4;
		add(lblUrl, gbc_lblUrl);

		JLabel lblDireccion = new JLabel("Dirección:");
		lblDireccion.setFont(new Font("Tahoma", Font.BOLD, 10));
		GridBagConstraints gbc_lblDireccion = new GridBagConstraints();
		gbc_lblDireccion.anchor = GridBagConstraints.WEST;
		gbc_lblDireccion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDireccion.gridx = 1;
		gbc_lblDireccion.gridy = 5;
		add(lblDireccion, gbc_lblDireccion);

		JLabel lblDireccionValue = new JLabel("New label");
		lblDireccionValue.setHorizontalAlignment(SwingConstants.LEFT);
		lblDireccionValue.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblDireccionValue = new GridBagConstraints();
		gbc_lblDireccionValue.anchor = GridBagConstraints.WEST;
		gbc_lblDireccionValue.insets = new Insets(0, 0, 5, 5);
		gbc_lblDireccionValue.gridx = 2;
		gbc_lblDireccionValue.gridy = 5;
		add(lblDireccionValue, gbc_lblDireccionValue);

		JLabel lblHorario_1 = new JLabel("Horario:");
		lblHorario_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		GridBagConstraints gbc_lblHorario_1 = new GridBagConstraints();
		gbc_lblHorario_1.anchor = GridBagConstraints.WEST;
		gbc_lblHorario_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblHorario_1.gridx = 1;
		gbc_lblHorario_1.gridy = 6;
		add(lblHorario_1, gbc_lblHorario_1);

		JLabel lblHorarioValue = new JLabel("New label");
		lblHorarioValue.setHorizontalAlignment(SwingConstants.LEFT);
		lblHorarioValue.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblHorarioValue = new GridBagConstraints();
		gbc_lblHorarioValue.anchor = GridBagConstraints.WEST;
		gbc_lblHorarioValue.insets = new Insets(0, 0, 5, 5);
		gbc_lblHorarioValue.gridx = 2;
		gbc_lblHorarioValue.gridy = 6;
		add(lblHorarioValue, gbc_lblHorarioValue);

		JLabel lblPrecio_1 = new JLabel("Precio:");
		lblPrecio_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		GridBagConstraints gbc_lblPrecio_1 = new GridBagConstraints();
		gbc_lblPrecio_1.anchor = GridBagConstraints.WEST;
		gbc_lblPrecio_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrecio_1.gridx = 1;
		gbc_lblPrecio_1.gridy = 7;
		add(lblPrecio_1, gbc_lblPrecio_1);

		JLabel lblPrecioValue = new JLabel("New label");
		lblPrecioValue.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrecioValue.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblPrecioValue = new GridBagConstraints();
		gbc_lblPrecioValue.anchor = GridBagConstraints.WEST;
		gbc_lblPrecioValue.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrecioValue.gridx = 2;
		gbc_lblPrecioValue.gridy = 7;
		add(lblPrecioValue, gbc_lblPrecioValue);

		JLabel lblOtros = new JLabel("Otros:");
		lblOtros.setFont(new Font("Tahoma", Font.BOLD, 10));
		GridBagConstraints gbc_lblOtros = new GridBagConstraints();
		gbc_lblOtros.anchor = GridBagConstraints.WEST;
		gbc_lblOtros.insets = new Insets(0, 0, 5, 5);
		gbc_lblOtros.gridx = 1;
		gbc_lblOtros.gridy = 8;
		add(lblOtros, gbc_lblOtros);

		JLabel lblOtrosValue = new JLabel("");
		lblOtrosValue.setHorizontalAlignment(SwingConstants.LEFT);
		lblOtrosValue.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblOtrosValue = new GridBagConstraints();
		gbc_lblOtrosValue.anchor = GridBagConstraints.WEST;
		gbc_lblOtrosValue.gridheight = 2;
		gbc_lblOtrosValue.insets = new Insets(0, 0, 5, 5);
		gbc_lblOtrosValue.gridx = 2;
		gbc_lblOtrosValue.gridy = 8;
		add(lblOtrosValue, gbc_lblOtrosValue);

		// Inicialización de campos
		lblNombre.setText(servicio.getNombre());

		// DESCRIPCIÓN
		String desc = servicio.getDescripcion();
		if (desc.length() > 209) {
			desc = desc.substring(0, 210) + "...";
		}

		int limit = 100;
		if (desc.length() > limit) {

			String sub = desc.substring(0, limit);
			int i = sub.lastIndexOf(" ");
			sub = sub.substring(0, i);
			String sub2 = desc.substring(i, desc.length() - 1);

			desc = "<html>" + sub + "<br>" + sub2 + "</html>";
		}

		lblDescripcion.setText(desc);
		lblUrl.setText(servicio.getUrl());
		lblDireccionValue.setText(servicio.getDireccion());

		if (servicio instanceof ServicioConHorario) {
			ServicioConHorario sch = (ServicioConHorario) servicio;
			lblHorarioValue.setText(sch.getHorario());
			
		}

		
		/*if (servicio instanceof ServicioConPrecio) {
			ServicioConPrecio scp = (ServicioConPrecio) servicio;
			lblHorarioValue.setText(scp.getHorario());
			lblPrecioValue.setText(String.valueOf(scp.getPrecio()));
		} */
		
		if (servicio instanceof Museo || servicio instanceof Evento) {
			if (servicio instanceof Museo) {
				
				
				Museo museo = (Museo) servicio;
				lblPrecioValue.setText(museo.getPrecio()+"€");
				lblOtrosValue.setText("Tema: " + museo.getTipo().toString());
			}

			if (servicio instanceof Evento) {
				Evento evento = (Evento) servicio;
				lblPrecioValue.setText(evento.getPrecio()+"€");
				lblOtrosValue.setText("Fecha: "+evento.getFecha()+"\n Artista: "+evento.getArtista());
			}
		}
		
		if (servicio instanceof Restaurante) {
			Restaurante res = (Restaurante)servicio;
			lblPrecio_1.setText("Rango de precio:");
			lblPrecioValue.setText("€".repeat(res.getRangoPrecio()));
			
			
		}
		
		if (servicio instanceof CentroComercial) {
			CentroComercial centro = (CentroComercial)servicio;
			
			lblPrecioValue.setText("-");
			lblOtrosValue.setText("Número de tiendas - "+centro.getNumTiendas());
			
			
		}

		

		JButton btnAtras = new JButton("Volver");
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				v.irAPantallaServicios();
			}
		});
		GridBagConstraints gbc_btnAtras = new GridBagConstraints();
		gbc_btnAtras.insets = new Insets(0, 0, 0, 5);
		gbc_btnAtras.gridx = 1;
		gbc_btnAtras.gridy = 10;
		add(btnAtras, gbc_btnAtras);
	}
}

