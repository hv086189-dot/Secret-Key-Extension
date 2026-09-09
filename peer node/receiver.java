import java.net.*;
import java.io.*;
import javax.swing.*;

class receiver implements Runnable
{
	int portno=0;
	
	receiver(int port)
	{
		portno=port;
		Thread t=new Thread(this);
		t.start();
	}
	
	public void run()
	{
		try
		{
			ServerSocket ss=new ServerSocket();
			ss.setReuseAddress(true);
			ss.bind(new InetSocketAddress(portno));
			while(true)
			{
				Socket soc=ss.accept();
				DataInputStream din=new DataInputStream(soc.getInputStream());
				peernode.senderid=din.readInt();
				peernode.sendermsg=din.readUTF();
				peernode.messageAvailable=true;
				din.close();
				soc.close();
				
				SwingUtilities.invokeLater(new Runnable()
				{
					public void run()
					{
						JOptionPane.showMessageDialog(null,
							"You have a message from sender ID: "+peernode.senderid
							+"\nClick VIEW RECEIVED MSG to decrypt it.");
					}
				});
				
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
			JOptionPane.showMessageDialog(null,
				"Receiver could not listen on port "+portno+"\n"
				+e.getClass().getSimpleName()+": "+e.getMessage());
		}
	}
}
