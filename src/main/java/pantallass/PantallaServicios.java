package pantallass;

import javax.swing.JPanel;

import clases.CentroComercial;
import clases.Museo;
import clases.Restaurante;
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

public class PantallaServicios extends JPanel{
	
	
	/*
	 * BASE PARA CREAR UNA PANTALLA NUEVA
	 * 
	 * private Ventana ventana;
	
	public PantallaServicios(Ventana v) {
		this.ventana = v;
		
		
		
		
		
	}*/
	
	
	
private Ventana ventana;
	
	public PantallaServicios(Ventana v) {
		this.ventana = v;
		setLayout(new BorderLayout(0, 0));
		
		
		JPanel panelContenido = new JPanel();
		GridBagLayout gbl_panelContenido = new GridBagLayout();
		gbl_panelContenido.columnWidths = new int[]{70, 0, 70, 0};
		gbl_panelContenido.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panelContenido.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panelContenido.rowWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		panelContenido.setLayout(gbl_panelContenido);
		
		add(panelContenido, BorderLayout.CENTER);
		
		JList<String> list = new JList<String>();
		list.setFixedCellHeight(100);
		list.setBackground(Color.WHITE);
		
		
		list.setMinimumSize(new Dimension(0, 50));
		list.setVisibleRowCount(3);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.insets = new Insets(0, 0, 5, 5);
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 1;
		gbc_list.gridy = 1;
		panelContenido.add(list, gbc_list);
		
		
		JPanel panelBotones = new JPanel();
		add(panelBotones, BorderLayout.NORTH);
		
		JButton btnMuseo = new JButton("Museo");
		btnMuseo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					ArrayList<Museo> museos = DAO.museosPorCiudad(v.getDestinoSeleccionado().getNombre());
				
					
					
					
					
					DefaultListModel<String> model = new DefaultListModel<String>();
					
					for(int i=0; i<museos.size(); i++) {
						
						Museo museo = museos.get(i);
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
					
					
					ArrayList<CentroComercial> centrosComerciales = DAO.centroComercialPorCiudad(v.getDestinoSeleccionado().getNombre());
					
					
					DefaultListModel<String> model = new DefaultListModel<String>();
					
					for(int i=0; i<centrosComerciales.size(); i++) {
						
						CentroComercial centro = centrosComerciales.get(i);
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
					
					
					ArrayList<Restaurante> restaurantes = DAO.RestaurantePorCiudad(v.getDestinoSeleccionado().getNombre());
					
					
					DefaultListModel<String> model = new DefaultListModel<String>();
					
					for(int i=0; i<restaurantes.size(); i++) {
						
						Restaurante restaurante = restaurantes.get(i);
						String tab = "&emsp;&emsp;";
						String br = "<br>";
						
						String info = "<html><h1>"+restaurante.getNombre()+"</h1>"
						+tab+"Direccion - "+restaurante.getDireccion()+br+
						tab+"Horario - "+restaurante.getHorario()+"</html>";
						
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
		panelBotones.add(btnEvento);
		
		
		
		//Esta por concretar
		JButton btnTours = new JButton("Tours");
		panelBotones.add(btnTours);
		
	}
	
}
