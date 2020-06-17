/* Lucrare de licență: Aplicație pentru transfer de fișiere
 * Student: Mihai-Alexandru Muntean

 * Clasa Selector
 * Folosită pentru selectarea corectă a algoritmului de codareS.
 */
package com.mihai.transfile.backend.cryption;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

import com.mihai.transfile.backend.memory.Values;

public class Selector 
{
	
	/**
	 * Pe baza diretiei de criptare transmisa prin {@code way}, criptaeaza sau decripteaza 
	 * fisierul {@code IN} cu algoritmul de criptare stabilit prin {@code Values.getAlgorithm()}.
	 * Rezultatul operatiei este stocat in fisierul {@code OUT}.
	 * @param IN {@code File}: fisierul de intrare
	 * @param OUT {@code File}: fisierul rezultat
	 * @param way {@code int}: directia operatiei de criptare: {@code Cipher.ENCRYPT} sau {@code Cipher.DECRYPT} 
	 */
	public static void algorithmSelector(File IN, File OUT, int way)
	{
		String selector = Values.getAlgorithm();
		
		if (selector.equals("NOTHING "))
		{
			Selector.xchgFile(IN, OUT);
		}
		else
			if (selector.equals("AES     "))
			{
				try 
				{
					AES.encryptDecrypt(way, IN, OUT);
				} 
				catch (InvalidKeyException | NoSuchAlgorithmException | InvalidKeySpecException | NoSuchPaddingException | IOException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			else
				if (selector.equals("DES     "))
				{
					try 
					{
						DES.encryptDecrypt(way, IN, OUT);
					} 
					catch (InvalidKeyException | NoSuchAlgorithmException | InvalidKeySpecException | NoSuchPaddingException | IOException e) 
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				else
					if (selector.equals("BLOWFISH"))
					{
						if (way==Cipher.ENCRYPT_MODE)
						{
							try 
							{
								Blowfish.criptare(IN, OUT);
							} 
							catch (Exception e) 
							{
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
						}
						else
							if (way==Cipher.DECRYPT_MODE)
							{
								try
								{
									Blowfish.decriptare(IN, OUT);
								}
								catch(Exception e)
								{
									e.printStackTrace();
								}
							}
						
					}	
	}

	
	
	/**
	 * Citeste ce este in {@code IN} ;i scrie in {@code OUT},
	 * @param IN
	 * @param OUT
	 */
	private static void xchgFile(File IN, File OUT)
    {
        try
        {
            FileOutputStream FOS = new FileOutputStream(OUT);
            FileInputStream FIS = new FileInputStream(IN);

            int p = FIS.available();
            byte[] b = new byte[2048];
            while (p!=0)
            {
                FIS.read(b);
                FOS.write(b);
                p= FIS.available();
            }

            FIS.close();
            FOS.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

