package pantallass;

import javax.swing.JPanel;

import clases.CentroComercial;
import clases.Evento;
import clases.Museo;
import clases.Restaurante;
import clases.Servicio;
import excepciones.ConexionFallidaException;
import jbdc.DAO;

import java.awt.BorderLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.ListSelectionModel;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class PantallaServicios extends JPanel{
	/*
	 * BASE PARA CREAR UNA PANTALLA NUEVA
	 * 
	 * private Ventana ventana;
	
	public PantallaServicios(Ventana v) {
		this.ventana = v;
	}*/
	
	private Ventana ventana;
	
	private ArrayList<Servicio> servicios = new ArrayList<Servicio>();


	public PantallaServicios(Ventana v) {
		this.ventana = v;
		setLayout(new BorderLayout(0, 0));
		
		
		
		JPanel panelContenido = new JPanel();
		GridBagLayout gbl_panelContenido = new GridBagLayout();
		gbl_panelContenido.columnWidths = new int[]{0, 70, 0, 70, 0};
		gbl_panelContenido.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panelContenido.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panelContenido.rowWeights = new double[]{0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		panelContenido.setLayout(gbl_panelContenido);
		
		add(panelContenido, BorderLayout.CENTER);
		
		JButton btnHome = new JButton("Inicio");
		btnHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				v.irAPantallaSeleccionDestino();
			}
		});
		GridBagConstraints gbc_btnHome = new GridBagConstraints();
		gbc_btnHome.insets = new Insets(0, 0, 5, 5);
		gbc_btnHome.gridx = 1;
		gbc_btnHome.gridy = 0;
		panelContenido.add(btnHome, gbc_btnHome);
		
		JLabel lblSeccion = new JLabel("");
		lblSeccion.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeccion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblSeccion = new GridBagConstraints();
		gbc_lblSeccion.insets = new Insets(0, 0, 5, 5);
		gbc_lblSeccion.gridx = 2;
		gbc_lblSeccion.gridy = 1;
		panelContenido.add(lblSeccion, gbc_lblSeccion);
		
		JList<String> list = new JList<String>();
		list.setFixedCellHeight(100);
		list.setBackground(Color.WHITE);
		
		
		
		
		list.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (e.getValueIsAdjusting()) {
	                  
					Servicio s = servicios.get(list.getSelectedIndex());
						v.irAPantallaDetalle(s);
					
					
	                }
			}
			
		});
		
		
		
		list.setMinimumSize(new Dimension(0, 50));
		list.setVisibleRowCount(3);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.insets = new Insets(0, 0, 5, 5);
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 2;
		gbc_list.gridy = 2;
		panelContenido.add(list, gbc_list);
		
	
		
		
		
		JPanel panelBotones = new JPanel();
		add(panelBotones, BorderLayout.NORTH);
		
		JButton btnMuseo = new JButton("Museo");
		btnMuseo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					
					lblSeccion.setText("Museos");
					
					//VACIAMOS EL ARRAYLIST 
					servicios.clear();
					
					//CARGAMOS INFORMACIÓN DE BBDD EN EL ARRAYLIST
					servicios = DAO.museosPorCiudad(v.getDestinoSeleccionado().getNombre());
					
					
					
					
					DefaultListModel<String> model = new DefaultListModel<String>();
					
					for(int i=0; i<servicios.size(); i++) {
						
						
						//CREAMOS UN OBJETO DEL TIPO QUE SEA UTILIZANDO EL POLIMORFISMO
						Museo museo = (Museo)servicios.get(i);
						String tab = "&emsp;&emsp;";
						String br = "<br>";
						
						String info = "<html><h1>"+museo.getNombre()+"</h1>"
						+tab+"Direccion - "+museo.getDireccion()+br+
						tab+"Horario - "+museo.getHorario()+"</html>";
						
						/*System.out.println(info);
						JLabel labelMuseo = new JLabel(info);
						labelMuseo.setHorizontalTextPosition(JLabel.CENTER);
						labelMuseo.setVerticalTextPosition(JLabel.BOTTOM);
						panelContenido.add(labelMuseo);*/
						
						
						 model.addElement(info);
					}
					
					
					list.setModel(model);
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ConexionFallidaException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		panelBotones.add(btnMuseo);
		
		
		
		JButton btnCentroComercial = new JButton("Centro Comercial");
		btnCentroComercial.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					
					lblSeccion.setText("Centros");
					
					//VACIAMOS EL ARRAYLIST 
					servicios.clear();
					
					//CARGAMOS INFORMACIÓN DE BBDD EN EL ARRAYLIST
					servicios = DAO.centroComercialPorCiudad(v.getDestinoSeleccionado().getNombre());
					
					
					DefaultListModel<String> model = new DefaultListModel<String>();
					
					for(int i=0; i<servicios.size(); i++) {
						
						CentroComercial centro = (CentroComercial) servicios.get(i);
						String tab = "&emsp;&emsp;";
						String br = "<br>";
						
						String info = "<html><h1>"+centro.getNombre()+"</h1>"
						+tab+"Direccion - "+centro.getDireccion()+br+
						tab+"Horario - "+centro.getHorario()+"</html>";
						
						/*System.out.println(info);
						JLabel labelMuseo = new JLabel(info);
						labelMuseo.setHorizontalTextPosition(JLabel.CENTER);
						labelMuseo.setVerticalTextPosition(JLabel.BOTTOM);
						panelContenido.add(labelMuseo);*/
						
						
						 model.addElement(info);
					}
					
					
					list.setModel(model);
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ConexionFallidaException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		panelBotones.add(btnCentroComercial);
		
		JButton btnRestaurantes = new JButton("Restaurantes");
		btnRestaurantes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					
					lblSeccion.setText("Restaurantes");
					 servicios = DAO.restaurantePorCiudad(v.getDestinoSeleccionado().getNombre());
					
					
					DefaultListModel<String> model = new DefaultListModel<String>();
					
					for(int i=0; i<servicios.size(); i++) {
						
						Restaurante restaurante = (Restaurante) servicios.get(i);
						String tab = "&emsp;&emsp;";
						String br = "<br>";
						
						String info = "<html><h1>"+restaurante.getNombre()+"</h1>"
						+tab+"Direccion - "+restaurante.getDireccion()+br+
						tab+"Horario - "+restaurante.getHorario()+tab+"RangoPrecio - "+restaurante.getRangoPrecio()+"</html>";
						
						/*System.out.println(info);
						JLabel labelMuseo = new JLabel(info);
						labelMuseo.setHorizontalTextPosition(JLabel.CENTER);
						labelMuseo.setVerticalTextPosition(JLabel.BOTTOM);
						panelContenido.add(labelMuseo);*/
						
						
						 model.addElement(info);
					}
					
					
					list.setModel(model);
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ConexionFallidaException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		panelBotones.add(btnRestaurantes);
		
		
		JButton btnEvento = new JButton("Eventos");
		btnEvento.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					
					lblSeccion.setText("Eventos");
					 servicios = DAO.eventoPorCiudad(v.getDestinoSeleccionado().getNombre());
					
					
					DefaultListModel<String> model = new DefaultListModel<String>();
					
					for(int i=0; i<servicios.size(); i++) {
						
						Evento evento = (Evento) servicios.get(i);
						String tab = "&emsp;&emsp;";
						String br = "<br>";
						
						String info = "<html><h1>"+evento.getNombre()+"</h1>"
						+tab+"Direccion - "+evento.getDireccion()+br+
						tab+"Horario - "+evento.getHorario()+tab+"p - "+((Evento) evento).getPrecio()+"</html>";
						
						/*System.out.println(info);
						JLabel labelMuseo = new JLabel(info);
						labelMuseo.setHorizontalTextPosition(JLabel.CENTER);
						labelMuseo.setVerticalTextPosition(JLabel.BOTTOM);
						panelContenido.add(labelMuseo);*/
						
						
						 model.addElement(info);
					}
					list.setModel(model);
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ConexionFallidaException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		panelBotones.add(btnEvento);
		
	
	}
	
}
