/* Lucrare de licență: Aplicație pentru transfer de fișiere
 * Student: Mihai-Alexandru Muntean

 * Clasa Values
 * Folosită pentru memorarea de informații necesare părții backend.
 */
package com.mihai.transfile.backend.memory;

import java.io.File;
import javax.swing.JFileChooser;

public class Values 
{
    
     private static String spath;

    public static String getServerPath()
    {
        return Values.spath;
    }

    public static void setServerPath(String cale)
    {
        Values.spath=cale;
    }
    
    private static String cpath;

    public static String getClientPath()
    {
        return Values.cpath;
    }

    public static void setClientPath(String cale)
    {
        Values.cpath=cale;
    }
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// JFileChooser
	
	/***/
	private static int MODE_SELECTION; 
// daca este permisa selectarea fisierelor sau a directoarelor sau ambele
	
	public static void setFileSelectionMode(int mode) 
                throws IllegalArgumentException
	{
		if ((mode == JFileChooser.FILES_AND_DIRECTORIES) || 
                        (mode == JFileChooser.FILES_ONLY) || 
                        (mode == JFileChooser.DIRECTORIES_ONLY))
			Values.MODE_SELECTION=mode;
		else
			throw new IllegalArgumentException("Argumentul trebuie"+
                                " sa fie: JFileChooser.FILES_AND_DIRECTORIES"+
                                " ori JFileChooser.FILES_ONLY ori "+
                                "JFileChooser.DIRECTORIES_ONLY");
	}
	
	public static int getFileSelectionMode()
	{
		return Values.MODE_SELECTION;
	}
	
	// Networking
	
	/***/
	private static int PORTServer;
	
	/**
	 * 
	 * @param prt an integer number from 1 to 65536
	 * @return 1 if port exists
	 * 			0 if not 
	 */
	public static boolean setPortServer(String prt) 
	{
            int port=-1;
            boolean err=false;
            try
            {
                port = Integer.parseInt(prt);
            }
            catch(NumberFormatException e)
            {
                err=true;
            }
		
		if ((port>0) && (port <65536))
		{
			Values.PORTServer = port;
		}
		else
                    err=true;
            return err;
	}
	
	public static int getPortServer()
	{
		return Values.PORTServer;
	}
        
        /***/
	private static int PORTClient;
	
	/**
	 * 
	 * @param port an integer number from 1 to 65536
	 * @return 1 if port exists
	 * 			0 if not 
	 */
	public static boolean setPortClient(String prt) 
	{
            int port=-1;
            boolean err=false;
            try
            {
                port = Integer.parseInt(prt);
            }
            catch(NumberFormatException e)
            {
                err=true;
            }
		
		if ((port>0) && (port <65536))
		{
			Values.PORTClient = port;
		}
		else
                    err=true;
            return err;
	}
	
	public static int getPortClient()
	{
		return Values.PORTClient;
	}
	
	/***/
	private static String IPv4;
	
	/**
	 * 
	 * @param ip a string contains IPv4 adress
	 * @return true if IPv4 adress is not valid
	 * 			false if is valid
	 */
	public static boolean setIpv4(String ip) 
	{
            boolean err;
		if (convergence4(ip))
		{
			Values.IPv4 = ip;
                        err = false;
		}
		else
                    err=true;
			return err;
	}
	
	public static String getIpv4()
	{
		return Values.IPv4;
	}
	
	
	/**
	 * Testeaza daca adresa Ipv4 e una valida.
	 * @param ipv4
	 * @return daca e sau nu valida adresa IPv4
	 */
	public static boolean convergence4(String ipv4)
	{
		boolean state = true;
		System.out.print(ipv4);
		System.out.println();
		
		//String[] component  = ipv4.split(".");
		if (ipv4.length()<=15)
		{
			String[] component = new String[4];
			component = splitv(ipv4,'.',component);
			for (int i=0;i<4;i++)
			{
				int number = Integer.parseInt(component[i]);
				if (number<0)
					{
					state = false;
					}
				else
					if (number>255)
					{
						state=false;
					}
					else
					{
						state=true;
					}
			}
		}
		else
			state=false;
		return state;
	}
	
	private static String[] splitv( String split, char regex,String[] array)
	{
		String loc="";
		int l=array.length;
		for (int i=0;i<=split.length();i++)
		{
			if (i==13)
			{
				array[l-1]=loc;
			}
			else
			{
				char c=split.charAt(i);
				if (c!=regex)
				{
					loc=loc+c;
				}
				else
				{
					array[l-1]=loc;
					loc="";
					l--;
				}
			}
		}
		
		return array;
	}
	
	/***/
	
	private static File FILEPATH;
	
	public static File getFilePath()
	{
		return FILEPATH;
	}
	
	public static void setFilePath(File s)
	{
		FILEPATH=s;
	}
	
	/***/
	
	/**
	 * Stocheaza algoritmul de criptare folosit.
	 */
	private static String Algorithm="";
	
	public static void setAlgorithm(String alg)
	{
            Values.padding(alg, " ", 8);
		Values.Algorithm = alg;
	}
	
	public static String getAlgorithm()
	{
		return Values.Algorithm;
	}
	
	private static String KEY;
	
	public static void setKey(String key)
	{
		Values.KEY = key;
	}
	
	public static String getKey()
	{
		return Values.KEY;
	}
	
	/***/
	 
	/**
	 * Extrage si returneaza extensia cu punct a fisierului.
	 * @param file fisierul in cauza
	 * @return extensia fisierului {@code file}
	 */
	public static String extension(File file)
	{
		String extension = ".";

		int i = file.getName().lastIndexOf('.');
		if (i > 0) 
		{
		    extension = extension + file.getName().substring(i+1);
		}
		return extension;
	}
	
	/***/
	/**
	 * Adauga lui {@code s} caracterul {@code regex} pana cand are 
         * lungimea {@code nr}.
	 * @param s string: string-ul de completat
	 * @param regex string: caracterul de completare
	 * @param nr int: lungimea stringului dorit
	 * @return string-ul rezultat
	 */
	public static String padding(String s,String regex, int nr)
	{
		while (s.length()!=nr)
		{
			s=s+regex;
		}
		return s;
	}
	
	/**
	 * Selecteaza primele {@code nr} caractere din {@code s}
	 * @param s String: string-ul de operat
	 * @param nr int: numarul de caractere al string-ului returnat
	 * @return 
	 */
	public static String unpadding(String s, int nr)
	{
			s=s.substring(0, nr);
		return s;
	}
	
	private static boolean verifyDupplicate(File folder, String  filename)
    {
        boolean p=false;
        if (folder.isDirectory())
        {
            File[] list = folder.listFiles();
            for (int i=0; i<list.length;i++)
            {
                String f1 = list[i].getName();
                if (filename.equals(f1))
                    p=true;
            }
        }
        else
            p=true;
        return p;
    }

    public static String adjustFileName(File folder, String fileName, int iteration)
    {
      
        String name="";

        if (Values.verifyDupplicate(folder, fileName))
        {
            iteration++;
            int p;
            p= fileName.lastIndexOf('.');
            int j=0;
            while (j<fileName.length())
            {
                if (j!=p)
                {
                    name= name+fileName.charAt(j);
                }
                else
                {
                    name=name+"("+iteration+").";
                }
                j++;
            }
            while (Values.verifyDupplicate(folder, name))
            {
                name=Values.adjustFileName(folder, name,iteration);
            }
        }
        else
            name=fileName;
            return name;
    }
}

