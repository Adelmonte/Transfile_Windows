/* Lucrare de licență: Aplicație pentru transfer de fișiere
 * Student: Mihai-Alexandru Muntean
 *
 * Clasa Client
 * Folosită în transferul de fișiere.
 */
package com.mihai.transfile.backend.transfer;


import java.io.IOException;
import java.net.Socket;
import javax.crypto.Cipher;
import com.mihai.transfile.backend.memory.Values;
import com.mihai.transfile.backend.cryption.Selector;
import java.io.InputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.Thread;


public class Client extends Thread
{
	private Socket s;
	private int port;
	private String ip;
	private InputStream IS;
	private FileOutputStream FOS;
	private File path;
	private File file;
	
	private File crypted;
	private File decrypted;
	/**
	 * Constructor.
	 * @param port numar intreg care simbolizeaza portul logic pe care se
         * face conectarea cu serverul
	 * @param ip String care reprezinta adresa IPv4 a serverului
	 * @param path instanta de tip File
	 */
	public Client(int port, String ip, File path)
	{
		super();
		this.port=port;
		this.ip=ip;
		this.s=null;
		this.FOS=null;
		this.path=path;
		this.file=null;
	}
	
	public File getResultFile()
	{
		return this.file;
	}
	
	public void run()
	{
            System.out.println("Begin!");
            this.s=this.connectSocket(this.s);
            System.out.println("S-a conectat socketul.");
		
            this.IS=this.connectInputStream(this.IS, this.s);
            System.out.println("S-a conectat Socketstream-ul la socket.");
		
            this.recCryptingAlgorithm(this.IS);
            System.out.println("S-a primit algoritmul de criptare. "+ Values.getAlgorithm());
		
            this.recCryptingKey(this.IS);
            System.out.println("S-a primit cheia de criptare. "+ Values.getKey());
		
            String s=this.composePath(this.IS,this.path);
		//Values.setFilePath(this.file);
            System.out.println("S-a citit numele fisierului: "+s);
		
            this.FOS=this.connectFileStream(this.crypted, this.FOS);
            System.out.println("S-a conectat FileStream-ul la fisierul extern.");
		
            System.out.println("Mesajul: ");
		//System.out.println(s);
            this.writeInFile(this.IS, this.FOS);
		
            System.out.println();
            System.out.println("Incepe inchiderea conexiunii.");
            this.closeFileStream(this.FOS);
            System.out.println("S-a deconectat FileStream-ul de la fisier.");
            this.closeStream(this.IS);
            System.out.println("S-a deconectat SocketStream-ul de socket.");
            this.closeSocket(this.s);
            System.out.println("S-a inchis socket-ul.");
            System.out.println("Decriptam fisierul.");
            Selector.algorithmSelector(crypted, decrypted, Cipher.DECRYPT_MODE);
            System.out.println("Fisier decriptat.");
            System.out.println("End!");
		
	}
	
	/**
	 * Citeste din {@code is} cheia de criptare si o salveaza in {@code Values.setKey()}.
	 * @param is InputStream: stream conectat la socket
	 */
	private void recCryptingKey(InputStream is)
	{
		String s;
		char seq []  = new char[16];
		try
		{
			for (int i=0;i<16;i++)
				seq[i] = (char)is.read();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		s= String.valueOf(seq);
		Values.setKey(s);
	}
	
	private void recCryptingAlgorithm(InputStream is)
	{
		String s;
		char seq []  = new char[8];
		try
		{
			seq[0] = (char)is.read();
			seq[1] = (char)is.read();
			seq[2] = (char)is.read();
			seq[3] = (char)is.read();
			seq[4] = (char)is.read();
			seq[5] = (char)is.read();
			seq[6] = (char)is.read();
			seq[7] = (char)is.read();
		    
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		s= String.valueOf(seq);
		Values.setAlgorithm(s);
	}
	
	private String composePath(InputStream is, File path)
	{
		String s = this.readFileName(is);
		crypted = new File(path.getAbsolutePath()+"/OUT.bin");
		decrypted = new File(path.getAbsolutePath()+"/"+s);
		Values.setClientPath(decrypted.getAbsolutePath());
		return s;
		
	}
	
	private String readFileName(InputStream is)
	{
		
		int length;
		String s;
		char [] array=null;
		try
		{
			length = is.read();
			array = new char[length];
			for (int i=0;i<length;i++)
			{
				array[i]=(char)is.read();
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		s= String.valueOf(array);
		s=Values.adjustFileName(this.path,s, 0);
		
		
		return s;
	}
	
	private void writeInFile(InputStream is, FileOutputStream fos)
	{
		byte[] buffer= new byte[1024];
		try
		{
			
			int ava = is.available();
            while (ava!=0)
            {
                if (ava<1024)
                {
                    is.read(buffer, 0, ava);
                    this.interrupt(5);
                    fos.write(buffer, 0, ava);
                }
                //buffer =(byte) fis.read();
                else 
                {
                    is.read(buffer, 0, buffer.length);
                    this.interrupt(5);
                    fos.write(buffer, 0, buffer.length);
                }
                ava = is.available();
            }
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	private void interrupt(int milis)
	{
		try
		{
			Client.sleep(milis);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	
	private void closeFileStream(FileOutputStream fileOutputStream)
	{
		try
		{
			fileOutputStream.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	private void writeInFile(FileOutputStream fileOutputStream,byte[] array)
	{
		try
		{
			fileOutputStream.write(array);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	private FileOutputStream connectFileStream(File F,FileOutputStream fileOutputStream)
	{
		try
		{
			fileOutputStream = new FileOutputStream(F);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		return fileOutputStream;
	}
	
	private char[] convertBytetoChar(byte[] arr)
	{
		char[] ch = new char[arr.length];
		for (int i=0;i<arr.length;i++)
		{
			ch[i]= (char) arr[i];
		}
		return ch;
	}
	
	private byte[] readStream(InputStream iS)
	{
		byte[] arr = new byte[100];
		try
		{
			
			int i=0;
			byte buff;
			//while ((iS.available()!=0)) 
			{	//buff  = (byte)IS.read();
				iS.read(arr,0,arr.length);
			//arr[i]=buff;				
			//i++;		
			}
			//iS.read(arr);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return arr;	
	}
	
	private InputStream connectInputStream(InputStream inputStream, Socket s)
	{
		try
        {
            inputStream = s.getInputStream();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
		return inputStream;
	}
	
	private void closeStream(InputStream inputStream)
	{
		try
        {
            inputStream.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
	}
	private Socket connectSocket(Socket s)
	{
		try
		{
			s= new Socket(this.ip,this.port);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return s;
	}
	
	private void closeSocket(Socket s)
	{
		try
		{
			if (!s.isClosed())
				s.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
}

