package com.mihai.transfile.frontend;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;

public class GraphicUserInterface {

	private JFrame frame;
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private JPanel home;
	private JPanel settings;
	private JPanel client;
	private JPanel server;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					GraphicUserInterface window = new GraphicUserInterface();
					window.frame.setVisible(true);
				}
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GraphicUserInterface() {
		
		
		initialize();
		
		contentPane = new JPanel();
		frame.setContentPane(contentPane);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		contentPane.setLayout(null);
		
		/*******/
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(212, 0, 448, 460);
		layeredPane.setLayout(new CardLayout(0, 0));
		contentPane.add(layeredPane);
		
		home = new JPanel();
		home.setBounds(0, 0, 448, 460);
		home.setBackground(new Color(28,111,166));
		home.setLayout(null);
		layeredPane.add(home);
		
			JLabel lblHome = new JLabel("Bun venit!");
			lblHome.setFont(new Font("Tahoma", Font.PLAIN, 26));
			lblHome.setForeground(Color.WHITE);
			lblHome.setBounds(170, 33, 151, 32);
			home.add(lblHome);
		
		server = new JPanel();
		server.setBounds(0, 0, 448, 460);
		server.setBackground(new Color(28,111,166));
		layeredPane.add(server);
		
			JLabel lblServer = new JLabel("server");
			server.add(lblServer);
		
		client = new JPanel();
		client.setBounds(0, 0, 448, 460);
		client.setBackground(new Color(28,111,166));
		layeredPane.add(client);
		
			JLabel lblClient = new JLabel("client");
			client.add(lblClient);
		
		settings = new JPanel();
		settings.setBounds(0, 0, 448, 460);
		settings.setBackground(new Color(28,111,166));
		layeredPane.add(settings);
		
			JLabel lblSett = new JLabel("sett");
			settings.add(lblSett);
		
		
		/*****/
		JPanel drawer = new JPanel();	
		drawer.setBounds(0, 0, 216, 460);
		drawer.setBackground(new Color(15,23,47));
		contentPane.add(drawer);
		drawer.setLayout(null);
		
		JLabel lbcopyright = new JLabel("Mihai-Alexandru Muntean");
		lbcopyright.setForeground(Color.WHITE);
		lbcopyright.setBounds(10, 435, 122, 14);
		drawer.add(lbcopyright);
		
		
		/***/
		JPanel header = new JPanel();
		header.setBounds(0, 0, 216, 117);
		header.setBackground(new Color(71,145,222));
		drawer.add(header);
		header.setLayout(null);
		
		JLabel lblTransfile = new JLabel("TransFile");
		lblTransfile.setForeground(Color.WHITE);
		lblTransfile.setBounds(10, 92, 46, 14);
		header.add(lblTransfile);
		
		/**
		Image image=null;
		try 
		{
			image = ImageIO.read(getClass().getResource("/main_icon_round.png"));
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		JLabel lblImage = new JLabel(/*new ImageIcon(image)*/);
		lblImage.setBounds(10, 11, 65, 70);
		header.add(lblImage);
		
		JPanel scthome = new JPanel();
		scthome.addMouseListener(new MouseAdapter() 
		{
			
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				boolean value=true;
				home.setVisible(value);
				
				server.setVisible(!value);
				client.setVisible(!value);
				settings.setVisible(!value);
			}
		});
		scthome.setBackground(new Color(51, 0, 153));
		scthome.setBounds(0, 140, 216, 40);
		drawer.add(scthome);
		scthome.setLayout(null);
		
		JLabel lblIcon = new JLabel("icon1");
		lblIcon.setBounds(10, 11, 46, 14);
		scthome.add(lblIcon);
		
		JLabel lblAcas = new JLabel("Acas\u0103");
		lblAcas.setForeground(Color.WHITE);
		lblAcas.setBounds(66, 11, 46, 14);
		scthome.add(lblAcas);
		
		JPanel sctserver = new JPanel();
		sctserver.addMouseListener(new MouseAdapter() 
		{
			
			@Override
			public void mouseClicked(MouseEvent e) 
			{boolean value=true;
				server.setVisible(value);
				
				home.setVisible(!value);
				client.setVisible(!value);
				settings.setVisible(!value);
			}
		});
		sctserver.setBackground(new Color(0, 51, 204));
		sctserver.setBounds(0, 200, 216, 40);
		drawer.add(sctserver);
		sctserver.setLayout(null);
		
		JLabel icon_2 = new JLabel("icon2");
		icon_2.setBounds(10, 11, 46, 14);
		sctserver.add(icon_2);
		
		JLabel lbServer = new JLabel("Trimite fi\u0219ier");
		lbServer.setForeground(Color.WHITE);
		lbServer.setBounds(66, 11, 94, 14);
		sctserver.add(lbServer);
		
		JPanel sctclient = new JPanel();
		sctclient.addMouseListener(new MouseAdapter() 
		{
			
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				boolean value=true;
				client.setVisible(value);
				
				home.setVisible(!value);
				server.setVisible(!value);
				settings.setVisible(!value);
			}
		});
		sctclient.setBackground(new Color(0, 255, 255));
		sctclient.setBounds(0, 260, 216, 40);
		drawer.add(sctclient);
		sctclient.setLayout(null);
		
		JLabel icon_3 = new JLabel("icon3");
		icon_3.setBounds(10, 11, 46, 14);
		sctclient.add(icon_3);
		
		JLabel lbClient = new JLabel("Primire fi\u0219ier");
		lbClient.setForeground(Color.WHITE);
		lbClient.setBounds(66, 11, 66, 14);
		sctclient.add(lbClient);
		
		JPanel sctsett = new JPanel();
		sctsett.addMouseListener(new MouseAdapter() 
		{
			
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				boolean value=true;
				settings.setVisible(value);
				
				home.setVisible(!value);
				server.setVisible(!value);
				client.setVisible(!value);
			}
		});
		sctsett.setBackground(new Color(102, 0, 255));
		sctsett.setBounds(0, 320, 216, 40);
		drawer.add(sctsett);
		sctsett.setLayout(null);
		
		JLabel icon_4 = new JLabel("icon4");
		icon_4.setBounds(10, 11, 46, 14);
		sctsett.add(icon_4);
		
		JLabel lbSettings = new JLabel("Set\u0103ri");
		lbSettings.setForeground(Color.WHITE);
		lbSettings.setBounds(66, 11, 46, 14);
		sctsett.add(lbSettings);
		
		JButton btnAcasa = new JButton("Acasa");
		btnAcasa.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				boolean value=true;
				settings.setVisible(value);
				
				home.setVisible(!value);
				server.setVisible(!value);
				client.setVisible(!value);
			}
		});
		btnAcasa.setBounds(35, 384, 89, 23);
		drawer.add(btnAcasa);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("TransFile");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\LucrareaLicenta\\Workspaces\\Server\\TransFile\\images\\TransFile.png"));
		frame.setEnabled(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 676, 500);
	}
}
