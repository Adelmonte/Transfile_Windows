/* Lucrare de licență: titlu, Student: Mihai-Alexandru Muntean
 * Clasa Link
 * Este o clasă de legătură între backend-ul aplicației și frontend-ul ei.
 */
package com.mihai.transfile.middleend;

import com.mihai.transfile.backend.cryption.KeyCryption;
import com.mihai.transfile.backend.cryption.Selector;
import com.mihai.transfile.backend.memory.Values;
import com.mihai.transfile.backend.transfer.Client;
import com.mihai.transfile.backend.transfer.Server;
import java.io.File;
import java.io.IOException;
import javax.crypto.Cipher;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

public class Link 
{
     public static void serverCall()
    {
        //start server
//Values.setAlgorithm(Values.padding(Main.cererePanelS("Dati Algoritmul").toUpperCase()," ",8));
				
	/*!!!!!!!*/	Values.setAlgorithm("NOTHING ");
				
	Values.setKey(KeyCryption.cryptKey(Values.getAlgorithm()));
	// server Windows
			
	//File F = new File("C:/Users/Mihai/Desktop/"+p);
	File F = new File (Values.getServerPath());
			
	String s=F.getName();
	String path = F.getParent();
	F.renameTo(new File(path + "/a"+s));
	File m = new File(path + "/a"+s);
			
	File OUT =new File(path+"/"+s);
		
	try
	{
            OUT.createNewFile();
	}
	catch (IOException e)
	{
            e.printStackTrace();
	}
			
	Selector.algorithmSelector(m, OUT, Cipher.ENCRYPT_MODE);
	System.out.println(F.getAbsolutePath());
			
	Server t= new Server(Values.getPortServer(),OUT);
	t.start();
	try
	{
            t.join();
	}
	catch(InterruptedException e)
	{
            e.printStackTrace();
	}
	OUT.delete();
	m.renameTo(new File(path + "/"+s));
    }

    public static boolean clientCall()
    {
        boolean state=false;
        String host = Values.getIpv4(); 
        int port = Values.getPortClient();
        File file = new File("C:\\TransfileDownloads");
        if (!file.exists())
        {
        	file.mkdir();
        }
        Client cl = new Client(port,host,file);//port, ip-ul tel, parent folder
        cl.start();
        try
        {
            cl.join();
            state=true;
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        } 
        return state;
    }





    /***/

    public static String getClientFilePath()
    {
        return Values.getClientPath();
    }

    public static boolean clientSettingIPv4(String ipv4)
    {
        boolean err;
        err=Values.setIpv4(ipv4);
        return err;
    }
    
    public static boolean serverSettingPort(String port)
    {
        boolean err=false;
        err=Values.setPortServer(port);
        return err;
    }
    
    public static boolean clientSettingPort(String port)
    {
        boolean err=false;
        err=Values.setPortClient(port);
        return err;
    }

    public static String getServerFilePath()
    {
        return Values.getServerPath();
    }

    public static void radioButtonSettings(String prot, String alg)
    {
        prot="FTP"; /**********************************/
        if (prot.equals("FTP"))
        {
            Values.setAlgorithm("NOTHING");
        }
        else
            if (prot.equals("FTPS"))
            {
                Values.setAlgorithm(alg);
            }
    }

    public static void setServerPath(String path)
    {
        Values.setServerPath(path);
    }
    
}
