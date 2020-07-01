/* Lucrare de licență: Aplicație pentru transfer de fișiere
 * Student: Mihai-Alexandru Muntean

 * Clasa Server
 * Folosită în transferul de fișiere.
 */
package com.mihai.transfile.backend.transfer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import com.mihai.transfile.backend.memory.Values;

public class Server extends Thread
{
	//campuri
    //portul folosit pentru conexiune 
    private int port;
    
    //socketul server
    private ServerSocket server;
    //socketul client
    private Socket client;
     
    //stream-uri pentru comunicarea cu clientul
        
    private  FileInputStream FIS;
    private  DataOutputStream DOS;
    
    private File target;
    
    /**
     * Constructor.
     * @param logicalPort
     * @param f
     */
    public Server(int logicalPort,File f) 
	{
            super();
            this.port= logicalPort;
            this.target=f;
            this.server=null;
            this.client=null;
            this.FIS=null;
            this.DOS=null;
	}
    // metode  
    
    
    
    /**
     * metoda centrala
     */
    public void run()
    	{
            this.DOS=this.startServer(this.port,this.DOS);
            this.sendCryptingAlgorihtm(Values.getAlgorithm(), this.DOS);
            this.sendCryptingKey(Values.getKey(),this.DOS);
            System.out.println("Se trimite algoritmul de criptare. "+ Values.getAlgorithm());
            this.sendFileName(this.target,this.DOS);
            System.out.println("Se trimite numele fisierului.");
            this.FIS=this.connectFile(this.target,this.FIS);
            this.doTheProblem(this.FIS, this.DOS);
            this.connectionClosed(this.client,this.server,this.FIS,this.DOS);
            System.gc();
    	}
    
    /**
     * Scrie pe {@code dos} cheia de criptare primita prin {@code key}
     * @param key string: cheia de criptare
     * @param dos DataOutputStream: stream conectat la soket
     */
    private void sendCryptingKey(String key,DataOutputStream dos)
    {
    	Values.padding(key, " ", 16);
    	byte[] seq= key.getBytes();
    	try
    	{
    		dos.write(seq);
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
    
    /**
     * Trimite prin {@code dos} algoritmul folosit pentru criptare.
     * @param alg
     * @param dos
     */
    private void sendCryptingAlgorihtm(String alg, DataOutputStream dos)
    {
    	byte[] seq= alg.getBytes();
    	try
    	{
    		dos.write(seq);
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
    
    
    /*
     * Trimite pe dos numele fisierului tagetat.
     */
    private void sendFileName(File path,DataOutputStream dos)
    {
        String s = this.extractFileName(path);
        byte[] array =s.getBytes();
        try
        {
            dos.write(array.length);
            dos.write(array,0,array.length);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

    }

    /*
    Extrage numele fisierului din path si il returneaza ca Sting.
     */
    private String extractFileName(File path)
    {
        String s=null;
        s=path.getName();
        return s;
    }
    
    
    /**
     * Creeaza serverul si asculta cererile pentru conexiune ale clientilor.
     * @return {@code void}
    */
    private DataOutputStream startServer(int port, DataOutputStream dos)
    	{
        
            System.out.println("Initializez aplicatia server ...");
            try 
            {
            
        	//initializeaza serverul
        	this.server = new ServerSocket(port);
        	System.out.println("Ascult pentru conexiunea clientului ...");
            
        	//asculta pentru conexiunile clientilor
        	this.client = this.server.accept();
            
        	System.out.println("Clientul " + 
                    this.client.getInetAddress().getHostName() + " conectat !");
            
        	//creez stream-urile pentru scriere/citire mesaje
        	// creare stream-uri pentru trimitere/receptionare Fisiere
        	dos =  new DataOutputStream (this.client.getOutputStream());// 
        		
            } 
            catch (IOException e) 
            {            
        	System.out.println("Serverul nu a putut fi creat !");
        	e.printStackTrace();        
            }
        return dos;
        }	
       
	private FileInputStream connectFile(File f, FileInputStream fis)
	{
		try
		{
			fis=new FileInputStream(f);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return fis;
	}
    
    private void doTheProblem(FileInputStream fis, DataOutputStream dos)
	    {
	        // citim un byte
	        
	        byte array[] = new byte[4096];
	        try
	        {
	            int available = fis.available();
	            while (available !=0)
	            { 
	                try
	                {// citim din fisier
	                    if (available<1024)
	                    {
	                    	byte arr[] = new byte[available];
	                    	fis.read(arr,0,available);
	                    	this.interrupt(5);
		                	dos.write(arr,0,available);
		                	dos.flush();
	                    }
	                    else
	                    {
	                    	fis.read(array,0,array.length);
	                    	this.interrupt(5);
	                    	dos.write(array,0,array.length);
	                    	dos.flush();
	                    }
	                }
	                catch (IOException e)
	                {
	                	e.printStackTrace();
	                	
	                	break;
	                }

	                available = fis.available();
	            } // end while
	        }
	        catch (IOException e)
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
    
    /**
     * Inchide conexiunea cu clientul.
     * @return {@code void}
     */
    private void connectionClosed(Socket client, ServerSocket server, 
            FileInputStream fis, DataOutputStream dos)
    	{
        	try 
        	{
        		client.close();
        		server.close();
        		
        		//fromFile.close();
        		fis.close();
        		dos.close();
        	} 
        	catch (IOException e) 
        	{
        		e.printStackTrace();
        		
        	}
        	System.out.println("Conexiune inchisa");
    	}    
}

   

