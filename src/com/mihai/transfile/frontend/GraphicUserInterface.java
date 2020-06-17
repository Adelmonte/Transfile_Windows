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

import com.mihai.transfile.middleend.Link;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JRadioButton;

public class GraphicUserInterface {

	private JFrame frame;
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private JPanel home;
	private JPanel settings;
	private JPanel client;
	private JPanel server;
	private JTextField tfIpCl;
	private JTextField tfPortCl;
	private JTextField tfPortSvr;

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
			
			JLabel lbltitle = new JLabel("ptitle");
			lbltitle.setForeground(Color.WHITE);
			lbltitle.setBounds(31, 99, 213, 14);
			home.add(lbltitle);
			
			JLabel lblPrgtitle = new JLabel("prgTitle");
			lblPrgtitle.setForeground(Color.WHITE);
			lblPrgtitle.setBounds(41, 124, 46, 14);
			home.add(lblPrgtitle);
			
			JLabel lblPrg = new JLabel("prg1");
			lblPrg.setForeground(Color.WHITE);
			lblPrg.setBounds(51, 149, 46, 14);
			home.add(lblPrg);
			
			JLabel lblPrgtitle_1 = new JLabel("prg2title");
			lblPrgtitle_1.setForeground(Color.WHITE);
			lblPrgtitle_1.setBounds(41, 189, 46, 14);
			home.add(lblPrgtitle_1);
			
			JLabel lblPrg_1 = new JLabel("prg2");
			lblPrg_1.setForeground(Color.WHITE);
			lblPrg_1.setBounds(51, 231, 46, 14);
			home.add(lblPrg_1);
			
			JLabel lblAct = new JLabel("Act");
			lblAct.setForeground(Color.WHITE);
			lblAct.setBounds(41, 359, 46, 14);
			home.add(lblAct);
		
		server = new JPanel();
		server.setBounds(0, 0, 448, 460);
		server.setBackground(new Color(28,111,166));
		layeredPane.add(server);
			server.setLayout(null);
		
			JLabel lblServer = new JLabel("server");
			lblServer.setForeground(Color.WHITE);
			lblServer.setBounds(208, 5, 31, 14);
			server.add(lblServer);
			
			JButton btnServer = new JButton("Server");
			btnServer.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e) 
				{
					Link.serverCall();
				}
			});
			btnServer.setBounds(180, 303, 89, 23);
			server.add(btnServer);
		
		client = new JPanel();
		client.setBounds(0, 0, 448, 460);
		client.setBackground(new Color(28,111,166));
		layeredPane.add(client);
			client.setLayout(null);
		
			JLabel lblClient = new JLabel("client");
			lblClient.setForeground(Color.WHITE);
			lblClient.setBounds(211, 5, 25, 14);
			client.add(lblClient);
			
			JButton btnClient = new JButton("btnClient");
			btnClient.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e) 
				{
					boolean err=Link.clientCall();
				}
			});
			btnClient.setBounds(128, 311, 89, 23);
			client.add(btnClient);
		
		settings = new JPanel();
		settings.setForeground(Color.WHITE);
		settings.setBounds(0, 0, 448, 460);
		settings.setBackground(new Color(28,111,166));
		layeredPane.add(settings);
			settings.setLayout(null);
		
			JLabel lblSett = new JLabel("Set\u0103ri");
			lblSett.setForeground(Color.WHITE);
			lblSett.setBounds(160, 11, 145, 21);
			settings.add(lblSett);
			
			JLabel lblSetriClient = new JLabel("Set\u0103ri Client");
			lblSetriClient.setForeground(Color.WHITE);
			lblSetriClient.setBounds(50, 49, 73, 14);
			settings.add(lblSetriClient);
			
			JLabel lbIpCl = new JLabel("IP Server");
			lbIpCl.setForeground(Color.WHITE);
			lbIpCl.setBounds(60, 84, 61, 14);
			settings.add(lbIpCl);
			
			tfIpCl = new JTextField();
			tfIpCl.setText("192.168.0.100");
			tfIpCl.setColumns(10);
			tfIpCl.setBounds(131, 81, 297, 20);
			settings.add(tfIpCl);
			
			JLabel lbPortCl = new JLabel("Port digital");
			lbPortCl.setForeground(Color.WHITE);
			lbPortCl.setBounds(60, 114, 61, 14);
			settings.add(lbPortCl);
			
			tfPortCl = new JTextField();
			tfPortCl.setText("20000");
			tfPortCl.setColumns(10);
			tfPortCl.setBounds(141, 112, 297, 20);
			settings.add(tfPortCl);
			
			JSeparator separator = new JSeparator();
			separator.setBounds(17, 149, 421, 2);
			settings.add(separator);
			
			JLabel lbSettSvr = new JLabel("Setari Server");
			lbSettSvr.setForeground(Color.WHITE);
			lbSettSvr.setBounds(39, 169, 80, 14);
			settings.add(lbSettSvr);
			
			JLabel lbProtSvr = new JLabel("Protocol de transfer");
			lbProtSvr.setForeground(Color.WHITE);
			lbProtSvr.setBounds(50, 244, 134, 14);
			settings.add(lbProtSvr);
			
			JLabel lbAlgSvr = new JLabel("Algoritm de criptare");
			lbAlgSvr.setForeground(Color.WHITE);
			lbAlgSvr.setBounds(50, 332, 103, 14);
			settings.add(lbAlgSvr);
			
			JRadioButton FTP = new JRadioButton("File Transfer Protocol");
			FTP.setForeground(Color.WHITE);
			FTP.setBackground(new Color(28,111,166));
			FTP.setBounds(72, 265, 233, 23);
			settings.add(FTP);
			
			JRadioButton FTPS = new JRadioButton("File Transfer Protocol Secured");
			FTPS.setForeground(Color.WHITE);
			FTPS.setBackground(new Color(28,111,166));
			FTPS.setBounds(72, 291, 233, 23);
			settings.add(FTPS);
			
			JRadioButton DES = new JRadioButton("Data Encryption Standard");
			DES.setForeground(Color.WHITE);
			DES.setBackground(new Color(28,111,166));
			DES.setBounds(72, 379, 181, 23);
			settings.add(DES);
			
			JRadioButton BF = new JRadioButton("BlowFish");
			BF.setForeground(Color.WHITE);
			BF.setBackground(new Color(28,111,166));
			BF.setBounds(72, 353, 86, 23);
			settings.add(BF);
			
			JRadioButton AES = new JRadioButton("Advanced Encryption Standard");
			AES.setForeground(Color.WHITE);
			AES.setBackground(new Color(28,111,166));
			AES.setBounds(72, 405, 181, 23);
			settings.add(AES);
			
			JLabel lbPortSvr = new JLabel("Port digital");
			lbPortSvr.setForeground(Color.WHITE);
			lbPortSvr.setBounds(50, 207, 61, 14);
			settings.add(lbPortSvr);
			
			tfPortSvr = new JTextField();
			tfPortSvr.setText("20000");
			tfPortSvr.setColumns(10);
			tfPortSvr.setBounds(131, 205, 297, 20);
			settings.add(tfPortSvr);
			
			JButton btnSett = new JButton("Salvare set\u0103ri");
			btnSett.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent arg0) 
				{
					// salvare setari
				}
			});
			btnSett.setBounds(271, 328, 89, 23);
			settings.add(btnSett);
			
			JLabel lblErr = new JLabel("err");
			lblErr.setForeground(Color.WHITE);
			lblErr.setBounds(50, 435, 46, 14);
			settings.add(lblErr);
		
		
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
		header.setBackground(new Color(42,88,133));
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
		sctclient.setBackground(new Color(0, 102, 153));
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
