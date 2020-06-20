package com.mihai.transfile.frontend;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mihai.transfile.middleend.Link;

import java.awt.Font;
import java.awt.Desktop;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

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
	private JLabel lblErr;

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
			lblHome.setBounds(154, 11, 151, 32);
			home.add(lblHome);
			
			JLabel lbltitle = new JLabel("Instruc\u021Biuni pentru utilizarea aplica\u021Biei");
			lbltitle.setForeground(Color.WHITE);
			lbltitle.setBounds(10, 54, 213, 14);
			home.add(lbltitle);
			
			JLabel lblPrgtitle = new JLabel("Opera\u021Bii pentru trimiterea fi\u0219ierului");
			lblPrgtitle.setForeground(Color.WHITE);
			lblPrgtitle.setBounds(20, 79, 280, 14);
			home.add(lblPrgtitle);
						
			JLabel lblPrgtitle_1 = new JLabel("Opera\u021Bii pentru recep\u021Bionarea fi\u0219ierului");
			lblPrgtitle_1.setForeground(Color.WHITE);
			lblPrgtitle_1.setBounds(20, 273, 232, 14);
			home.add(lblPrgtitle_1);
			
			String para2="<html>"
					+ "Întâi, în meniul din stânga și se alege „Setări”. Aici, la secțiunea pentru\r\n" + 
					"        primirea fișierului, în prima casetă de introducere a textului se completează adresa Ipv4\r\n" + 
					"        validă a dispozitivului distant, iar la următorarea casetă de introducere a textului se\r\n" + 
					"        introduce un număr pentru portul digital dorit (același ca cel introdus la secțiunea de\r\n" + 
					"        trimitere a fișierului de la aplicația distantă TransFile\r\n" + 
					"        . Se selectează de la secțiunea „Setări trimitere fișier”, un protocol de\r\n" + 
					"        transfer, un algoritm de criptare și se introduce un număr de port digital\r\n" + 
					"        obligatoriu mai mare de 2000, dar mai mic de 65000).\r\n" + 
					"        Mai apoi, se apasă butonul rotund din dreapta jos, această acțiune având ca rezultat\r\n" + 
					"        afișarea unui mesaj care va conține „Setări salvate!” sau „Există o eroare!”."
					+ "</html>";
			JLabel lblPrg_1 = new JLabel("<html>\r\nÎntâi, în meniul din stânga și se alege „Setări”. Aici, la secțiunea pentru\r\n        primirea fișierului, în prima casetă de introducere a textului se completează adresa Ipv4\r\n        validă a dispozitivului distant, iar la următorarea casetă de introducere a textului se\r\n        introduce un număr pentru portul digital dorit (același ca cel introdus la secțiunea de\r\n        trimitere a fișierului de la aplicația distantă TransFile. Mai apoi, se apasă butonul din dreapta jos, această acțiune având ca rezultat afișarea unui mesaj care va conține „Setări salvate!” sau „Există o eroare!”.</html>");
			lblPrg_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblPrg_1.setForeground(Color.WHITE);
			lblPrg_1.setBounds(30, 293, 398, 112);
			home.add(lblPrg_1);
			
			String paragr="<html>"
					+ "Atenție, este obligatorie urmarea instrucțiunilor pentru trimiterea\r\n" + 
					"        mai întâi a fișierului, iar apoi cele pentru primirea fișierului!"
					+ "</html>";
			JLabel lblAct = new JLabel(paragr);
			lblAct.setForeground(Color.BLACK);
			lblAct.setBounds(20, 417, 406, 32);
			home.add(lblAct);
			
			String parag="<html>"
					+ "Întâi, în meniul din stânga se alege „Setări”. Aici, se selectează un protocol" + 
					"        de transfer, un algoritm de criptare și se introduce numărul portului digital." + 
					"        Se apasă butonul de salvare a setărilor, această acțiune având ca rezultat afișarea unui mesaj\r\n" + 
					"        care va conține „Setări salvate!” sau „Există o eroare!”. În continuare, în meniul din dreapta se selectează\r\n" + 
					"        „Trimite fișierul”. Pe ecran sunt două butoane. Se apasă butonul de selecție a unui fișier\r\n" + 
					"        și se selectează fișierul dorit. După selecție aplicația va afișa un ecran cu\r\n" + 
					"        patru butoane. Este imperios să se apese butonul cel mai de sus, pentru a confirma selecția\r\n" + 
					"        fișierului. Există posibilitatea selecției altui fișier, a deschiderii fișierului selectat\r\n" + 
					"        în aplicație externă și posibilitatea revenirii la ecranul inițial. După acești pași, se\r\n" + 
					"        apasă butonul „Trimiteți fișierul”. În continuare, se vor urma instrucțiunile pentru\r\n" + 
					"        primirea fișierului din aplicația TransFile distantă."
					+ "</html>";
			JLabel lbpar1 = new JLabel("<html>Întâi, în meniul din stânga se alege „Setări”. Aici, se selectează un protocol de transfer, un algoritm de criptare și se introduce numărul portului digital (același ca cel introdus la secțiunea de primire a fișierului de la aplicația distantă Transfile) . Se va apasa butonul de salvare a setărilor, această acțiune având ca rezultat afișarea unui mesaj care va conține „Setări salvate!” sau „Există o eroare!”. În continuare, în meniul din dreapta se selectează „Trimite fișier”. Pe ecran sunt trei butoane. Se apasă butonul „Selectează fișier” și se selectează fișierul dorit. Există și posibilitatea deschiderii fișierului selectat în aplicație externă. După acești pași, se apasă butonul „Trimiteți fișierul!”. În continuare, se vor urma instrucțiunile pentru primirea fișierului din aplicația TransFile distantă.</html>");
			lbpar1.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lbpar1.setForeground(Color.WHITE);
			lbpar1.setBounds(30, 104, 408, 151);
			home.add(lbpar1);
			
		server = new JPanel();
		server.setBounds(0, 0, 448, 460);
		server.setBackground(new Color(28,111,166));
		layeredPane.add(server);
			server.setLayout(null);
		
			JLabel lblServer = new JLabel("Calea fișierului ales este:");
			lblServer.setForeground(Color.WHITE);
			lblServer.setBounds(51, 106, 195, 14);
			lblServer.setVisible(false);
			server.add(lblServer);
			
			JButton btnServer = new JButton("Trimiteți fișierul");
			btnServer.setBackground(Color.WHITE);
			btnServer.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e) 
				{
					Link.serverCall();
				}
			});
			btnServer.setBounds(50, 310, 160, 30);
			server.add(btnServer);
			
			JLabel lblPath = new JLabel("<html>Nu ați selectat nici un fișier.</html>");
			lblPath.setForeground(Color.WHITE);
			lblPath.setBounds(61, 131, 352, 102);
			server.add(lblPath);
			
			JButton btn2 = new JButton("Selectează fișierul");
			btn2.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e) 
				{
					//selecteaza fișierul
					String path;
					JFileChooser jfc = new JFileChooser();
					jfc.setCurrentDirectory(new java.io.File("C:/Users/Mihai/Desktop"));
					jfc.setDialogTitle("Alegere Fisier");
					if (jfc.showOpenDialog(null)== JFileChooser.APPROVE_OPTION)
					{}
					File F = jfc.getSelectedFile().getAbsoluteFile();
					lblServer.setVisible(true);
					path=F.getAbsolutePath();
					lblPath.setText("<html>"+path+"</html>");
					Link.setServerPath(path);
				}
			});
			btn2.setBackground(Color.WHITE);
			btn2.setBounds(260, 310, 160, 30);
			server.add(btn2);
			
			JButton btn1 = new JButton("Vizualizați fișierul!");
			btn1.setBackground(Color.WHITE);
			btn1.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e) 
				{
					//deschide fis in aplicatie externa
					String path = Link.getServerFilePath();
					if (!path.equals(null))
					{
						File f=null;
						try
						{
							f=new File(path);
						}
						catch (Exception l)
						{
							lblPath.setText("A survenit o eroare!");
						}
						if(!Desktop.isDesktopSupported())
						{
							lblPath.setText("A survenit o eroare!");
						}
			        
						Desktop desktop = Desktop.getDesktop();
						try
						{
							if(f.exists()) desktop.open(f);
						}
						catch(IOException k)
						{
							lblPath.setText("A survenit o eroare!");
						}
					}
					else
						lblPath.setText("A survenit o eroare!");
					
				}
			});
			btn1.setBounds(51, 364, 160, 30);
			server.add(btn1);
			
			JLabel lblServer_1 = new JLabel("Trimite fișier");
			lblServer_1.setForeground(Color.WHITE);
			lblServer_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblServer_1.setBounds(163, 11, 170, 37);
			server.add(lblServer_1);
		
		client = new JPanel();
		client.setBounds(0, 0, 448, 460);
		client.setBackground(new Color(28,111,166));
		layeredPane.add(client);
			client.setLayout(null);
		
			JLabel lblClient = new JLabel("Fișierul este salvat la locația:");
			lblClient.setForeground(Color.WHITE);
			lblClient.setBounds(57, 91, 151, 14);
			lblClient.setVisible(false);
			client.add(lblClient);
			
			JLabel lblPath_1 = new JLabel("Fișierul încă nu a fost primit.");
			lblPath_1.setForeground(Color.WHITE);
			lblPath_1.setBounds(67, 116, 160, 14);
			client.add(lblPath_1);
			
			JButton btnClient = new JButton("Permiteți primirea fișierului!");
			btnClient.setFont(new Font("Tahoma", Font.PLAIN, 11));
			btnClient.setBackground(Color.WHITE);
			btnClient.setForeground(Color.BLACK);
			btnClient.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e) 
				{
					boolean err=Link.clientCall();
					lblClient.setVisible(true);
					lblPath_1.setText(Link.getClientFilePath());
				}
			});
			btnClient.setBounds(38, 319, 166, 30);
			client.add(btnClient);
			
			
			
			JButton btnn = new JButton("Vizualizați fișierul!");
			btnn.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent arg0) 
				{
					String path = Link.getClientFilePath();
					File f=new File(path);
					if (!path.equals(""))
					{
						if(!Desktop.isDesktopSupported())
						{
							lblPath_1.setText("A survenit o eroare!");
						}
			        
						Desktop desktop = Desktop.getDesktop();
						try
						{
							if(f.exists()) desktop.open(f);
						}
						catch(IOException k)
						{
							lblPath_1.setText("A survenit o eroare!");
						}
					}
					else
						lblPath_1.setText("A survenit o eroare!");
					
				}
			});
			btnn.setFont(new Font("Tahoma", Font.PLAIN, 11));
			btnn.setBackground(Color.WHITE);
			btnn.setBounds(243, 319, 160, 30);
			btnClient.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e) 
				{
					// vizualizati fisierul
				}
			});
			client.add(btnn);
			
			JLabel lblPrimireFiier = new JLabel("Recepționare fișier");
			lblPrimireFiier.setBackground(Color.WHITE);
			lblPrimireFiier.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblPrimireFiier.setForeground(Color.WHITE);
			lblPrimireFiier.setBounds(105, 29, 234, 30);
			client.add(lblPrimireFiier);
		
		settings = new JPanel();
		settings.setForeground(Color.WHITE);
		settings.setBounds(0, 0, 448, 460);
		settings.setBackground(new Color(28,111,166));
		layeredPane.add(settings);
			settings.setLayout(null);
		
			JLabel lblSett = new JLabel("Set\u0103ri");
			lblSett.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblSett.setForeground(Color.WHITE);
			lblSett.setBounds(195, 11, 80, 28);
			settings.add(lblSett);
			
			JLabel lblSetriClient = new JLabel("Set\u0103ri Client");
			lblSetriClient.setForeground(Color.WHITE);
			lblSetriClient.setBounds(39, 49, 73, 14);
			settings.add(lblSetriClient);
			
			JLabel lbIpCl = new JLabel("IP Server");
			lbIpCl.setForeground(Color.WHITE);
			lbIpCl.setBounds(49, 84, 61, 14);
			settings.add(lbIpCl);
			
			tfIpCl = new JTextField();
			tfIpCl.setText("192.168.0.100");
			tfIpCl.setColumns(10);
			tfIpCl.setBounds(131, 81, 300, 20);
			settings.add(tfIpCl);
			
			JLabel lbPortCl = new JLabel("Port digital");
			lbPortCl.setForeground(Color.WHITE);
			lbPortCl.setBounds(51, 115, 61, 14);
			settings.add(lbPortCl);
			
			tfPortCl = new JTextField();
			tfPortCl.setText("20000");
			tfPortCl.setColumns(10);
			tfPortCl.setBounds(131, 112, 300, 20);
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
			lbAlgSvr.setBounds(50, 332, 134, 14);
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
			AES.setBounds(72, 405, 223, 23);
			settings.add(AES);
			
			JLabel lbPortSvr = new JLabel("Port digital");
			lbPortSvr.setForeground(Color.WHITE);
			lbPortSvr.setBounds(50, 207, 61, 14);
			settings.add(lbPortSvr);
			
			tfPortSvr = new JTextField();
			tfPortSvr.setText("20000");
			tfPortSvr.setColumns(10);
			tfPortSvr.setBounds(131, 205, 300, 20);
			settings.add(tfPortSvr);
			
			lblErr = new JLabel("");
			lblErr.setForeground(Color.WHITE);
			lblErr.setBounds(50, 435, 46, 14);
			settings.add(lblErr);
			
			JButton btnSett = new JButton("Salvare set\u0103ri");
			btnSett.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent arg0) 
				{
					// salvare setari
					if (Link.clientSettingIPv4(tfIpCl.getText()))
		            {
		                lblErr.setText("Introduce-ti o adresa IPv4 valida!");
		            }
						
						
					if (Link.clientSettingPort(tfPortCl.getText()))
		            {
						String s = lblErr.getText();
						if (s!="")
						{
							lblErr.setText(s+"\n"+"Introduceti un numar de port valid!");
						}
						else
							lblErr.setText("Introduceti un numar de port valid!");
		            }
		        
					if (Link.serverSettingPort(tfPortSvr.getText()))
		            {
						String s = lblErr.getText();
						if (s!="")
		                {
							lblErr.setText(s+"\n"+"Introduceti un numar de port valid!");
		                }
						else
						lblErr.setText("Introduceti un numar de port valid!");
		            }
					
					String prot="", alg="";
		        
					if (FTP.isSelected())
		            {
						prot="FTP";
		            }
					else
						if (FTPS.isSelected())
						{
							if (AES.isSelected())
							{
								alg="AES";
							}			
							if (DES.isSelected())
							{
								alg="DES";
							}
							if (BF.isSelected())
							{
								alg="BLOWFISH";
							}
						}
					Link.radioButtonSettings(prot, alg);
				}
			});
			btnSett.setBounds(299, 380, 124, 48);
			settings.add(btnSett);
			
			
		
		
		/*****/
		JPanel drawer = new JPanel();	
		drawer.setBounds(0, 0, 216, 460);
		drawer.setBackground(new Color(15,23,47));
		contentPane.add(drawer);
		drawer.setLayout(null);
		
		
		/***/
		JPanel header = new JPanel();
		header.setBounds(0, 0, 216, 117);
		header.setBackground(new Color(42,88,133));
		drawer.add(header);
		header.setLayout(null);
		
		JLabel lblTransfile = new JLabel("TransFile");
		lblTransfile.setForeground(Color.WHITE);
		lblTransfile.setBounds(25, 92, 107, 14);
		header.add(lblTransfile);
		
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
		scthome.setBackground(new Color(25, 50, 150));
		scthome.setBounds(0, 140, 216, 40);
		drawer.add(scthome);
		scthome.setLayout(null);
		
		JLabel lblAcas = new JLabel("Acas\u0103");
		lblAcas.setForeground(Color.WHITE);
		lblAcas.setBounds(40, 10, 46, 14);
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
		sctserver.setBackground(new Color(50, 50, 150));
		sctserver.setBounds(0, 200, 216, 40);
		drawer.add(sctserver);
		sctserver.setLayout(null);
		
		JLabel lbServer = new JLabel("Trimite fi\u0219ier");
		lbServer.setForeground(Color.WHITE);
		lbServer.setBounds(40, 10, 94, 14);
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
		sctclient.setBackground(new Color(50, 50, 150));
		sctclient.setBounds(0, 260, 216, 40);
		drawer.add(sctclient);
		sctclient.setLayout(null);
		
		JLabel lbClient = new JLabel("Recepționare fișier");
		lbClient.setForeground(Color.WHITE);
		lbClient.setBounds(40, 10, 140, 14);
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
		sctsett.setBackground(new Color(50, 50, 150));
		sctsett.setBounds(0, 320, 216, 40);
		drawer.add(sctsett);
		sctsett.setLayout(null);
		
		JLabel lbSettings = new JLabel("Set\u0103ri");
		lbSettings.setForeground(Color.WHITE);
		lbSettings.setBounds(40, 10, 46, 14);
		sctsett.add(lbSettings);
		
		JLabel lbcopyright = new JLabel("Mihai Muntean");
		lbcopyright.setBounds(24, 435, 128, 14);
		drawer.add(lbcopyright);
		lbcopyright.setForeground(Color.WHITE);
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
