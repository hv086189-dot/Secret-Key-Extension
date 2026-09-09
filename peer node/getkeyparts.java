import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import java.io.*;
import java.util.*;

class getkeyparts extends JFrame implements ActionListener
{
	JRadioButton jr1,jr2,jr3,jr4,jr5,jr6;
	JButton jbok,jbclear;
	boolean kpa1=false,kpa2=false,kpa3=false,kpa4=false,kpa5=false,kpa6=false;
	int count=0;
	int keyarray[]=new int[3];
	String countx[]=new String[3];
	int index=0;
	
	String reqnode="";
	
	getkeyparts(String requester,int keyid)
	{
		super("Select KPA's");
		reqnode=requester;
		reqnode.trim();
	//	tempid=keyid;
		displayoptions();
	}
	
	
	void displayoptions()
	{
		Container cp=getContentPane();
		cp.setLayout(null);
		cp.setBackground(new Color(221,134,99));
		
		JLabel jlreq=new JLabel("Select any three KPA'S to get Key:");
		jr1=new JRadioButton("KPA1");
		jr2=new JRadioButton("KPA2");
		jr3=new JRadioButton("KPA3");
		jr4=new JRadioButton("KPA4");
		jr5=new JRadioButton("KPA5");
		jr6=new JRadioButton("KPA6");
		
		jbok=new JButton("OK");
		jbclear=new JButton("CLEAR");
		
		addcomponent(cp,jlreq,10,10,200,20);
		addcomponent(cp,jr1,10,50,200,20);
		addcomponent(cp,jr2,10,90,200,20);
		addcomponent(cp,jr3,10,130,200,20);
		addcomponent(cp,jr4,10,170,200,20);
		addcomponent(cp,jr5,10,210,200,20);
		addcomponent(cp,jr6,10,250,200,20);
		addcomponent(cp,jbok,10,290,100,30);
		addcomponent(cp,jbclear,110,290,100,30);
		this.setUndecorated(true);
		this.setBounds(100,100,250,380);
		this.setVisible(true);
		
		
		jbok.addActionListener(this);
		jbclear.addActionListener(this);
		jr1.addActionListener(this);
		jr2.addActionListener(this);
		jr3.addActionListener(this);
		jr4.addActionListener(this);
		jr5.addActionListener(this);
		jr6.addActionListener(this);
	}
	
	void addcomponent(Container cp,Component c,int x,int y,int width,int height)
	{
		c.setBounds(x,y,width,height);
		cp.add(c);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if (ae.getSource()==jbok)
		{
			if (count==3)
			{
				this.dispose();
				generatekey();
				if (reqnode.equals("SENDER"))
				JOptionPane.showMessageDialog(this,"Your Secret Key is: "+peernode.finalkey);
				else
				JOptionPane.showMessageDialog(this,"Your Secret Key is: "+peernode.receiverkey);
			}	
			else
			{
				JOptionPane.showMessageDialog(this,"Select 3 KPA's first.");
			}
		}
		else
		if (ae.getSource()==jbclear)
		{
			jr1.setSelected(false);
			jr2.setSelected(false);
			jr3.setSelected(false);
			jr4.setSelected(false);
			jr5.setSelected(false);
			jr6.setSelected(false);
			count=0;
			index=0;
			kpa1=false;
			kpa2=false;
			kpa3=false;
			kpa4=false;
			kpa5=false;
			kpa6=false;
		}
		else
		if (ae.getSource()==jr1)
		{
			if (jr1.isSelected())
			{
				if (count<3)
				{
					count++;
					kpa1=true;
				}
				else
				{
					jr1.setSelected(false);
					JOptionPane.showMessageDialog(this,"you cannot select more than 3 KPA");
				}
				
			}
			else
			{
				count--;
				kpa1=false;
			}
		}
		else
		if (ae.getSource()==jr2)
		{
			if (jr2.isSelected())
			{
				if (count<3)
				{
					count++;
					kpa2=true;
				}
				else
				{
					jr2.setSelected(false);
					JOptionPane.showMessageDialog(this,"you cannot select more than 3 KPA");
				}
				
			}
			else
			{
				count--;
				kpa2=false;
			}
		}
		else
		if (ae.getSource()==jr3)
		{
			if (jr3.isSelected())
			{
				if (count<3)
				{
					count++;
					kpa3=true;
				}
				else
				{
					jr3.setSelected(false);
					JOptionPane.showMessageDialog(this,"you cannot select more than 3 KPA");
				}
				
			}
			else
			{
				count--;
				kpa3=false;
			}
		}
		else
		if (ae.getSource()==jr4)
		{
			if (jr4.isSelected())
			{
				if (count<3)
				{
					count++;
					kpa4=true;
				}
				else
				{
					jr4.setSelected(false);
					JOptionPane.showMessageDialog(this,"you cannot select more than 3 KPA");
				}
				
			}
			else
			{
				count--;
				kpa4=false;
			}
		}
		else
		if (ae.getSource()==jr5)
		{
			if (jr5.isSelected())
			{
				if (count<3)
				{
					count++;
					kpa5=true;
				}
				else
				{
					jr5.setSelected(false);
					JOptionPane.showMessageDialog(this,"you cannot select more than 3 KPA");
				}
				
			}
			else
			{
				count--;
				kpa5=false;
			}
		}
		else
		if (ae.getSource()==jr6)
		{
			if (jr6.isSelected())
			{
				if (count<3)
				{
					count++;
					kpa6=true;
				}
				else
				{
					jr6.setSelected(false);
					JOptionPane.showMessageDialog(this,"you cannot select more than 3 KPA");
				}
				
			}
			else
			{
				count--;
				kpa6=false;
			}
		}
	}
	
	
	void generatekey()
	{
		
		
		
			try
			{
				if (kpa1==true)
				{
					Socket soc=new Socket(readaddr("KPA1"),3000);
					DataOutputStream dout=new DataOutputStream(soc.getOutputStream());
					DataInputStream din=new DataInputStream(soc.getInputStream());
					dout.writeUTF("USER");
					dout.writeInt(peernode.id1);
					
					countx[index]="1";
					keyarray[index++]=din.readInt();
					din.close();
					dout.close();
					soc.close();
									
					
				}
				
				if (kpa2==true)
				{
					Socket soc=new Socket(readaddr("KPA2"),3100);
					DataOutputStream dout=new DataOutputStream(soc.getOutputStream());
					DataInputStream din=new DataInputStream(soc.getInputStream());
					dout.writeUTF("USER");
					dout.writeInt(peernode.id1);
					
					countx[index]="2";
					keyarray[index++]=din.readInt();
					din.close();
					dout.close();
					soc.close();
									
					
				}
				
				if (kpa3==true)
				{
					Socket soc=new Socket(readaddr("KPA3"),3200);
					DataOutputStream dout=new DataOutputStream(soc.getOutputStream());
					DataInputStream din=new DataInputStream(soc.getInputStream());
					dout.writeUTF("USER");
					dout.writeInt(peernode.id1);
					
					countx[index]="3";
					keyarray[index++]=din.readInt();
					din.close();
					dout.close();
					soc.close();
									
					
				}
				
				
				
				if (kpa4==true)
				{
					Socket soc=new Socket(readaddr("KPA4"),3300);
					DataOutputStream dout=new DataOutputStream(soc.getOutputStream());
					DataInputStream din=new DataInputStream(soc.getInputStream());
					dout.writeUTF("USER");
					dout.writeInt(peernode.id1);
					
					countx[index]="4";
					keyarray[index++]=din.readInt();
					din.close();
					dout.close();
					soc.close();
									
					
				}
				
				if (kpa5==true)
				{
					Socket soc=new Socket(readaddr("KPA5"),3400);
					DataOutputStream dout=new DataOutputStream(soc.getOutputStream());
					DataInputStream din=new DataInputStream(soc.getInputStream());
					dout.writeUTF("USER");
					dout.writeInt(peernode.id1);
					
					countx[index]="5";
					keyarray[index++]=din.readInt();
					din.close();
					dout.close();
					soc.close();
									
					
				}
				
				if (kpa6==true)
				{
					Socket soc=new Socket(readaddr("KPA6"),3500);
					DataOutputStream dout=new DataOutputStream(soc.getOutputStream());
					DataInputStream din=new DataInputStream(soc.getInputStream());
					dout.writeUTF("USER");
					dout.writeInt(peernode.id1);
					
					countx[index]="6";
					keyarray[index++]=din.readInt();
					din.close();
					dout.close();
					soc.close();
									
					
				}
				
				findkey(countx,keyarray);
				
				
			}
			catch(Exception e)
			{
				System.out.println(e);
				JOptionPane.showMessageDialog(this,
					"Could not get key parts from the KPA servers.\n"
					+e.getClass().getSimpleName()+": "+e.getMessage());
			}
		
		
		
	}
	
	
	void findkey(String countx[],int keys[])
	{
		try
		{
			double outputValue=0;
			for (int i=0;i<3;i++)
			{
				double xi=Double.parseDouble(countx[i]);
				double term=keys[i];

				for (int j=0;j<3;j++)
				{
					if (i!=j)
					{
						double xj=Double.parseDouble(countx[j]);
						term=term*((0-xj)/(xi-xj));
					}
				}
				outputValue+=term;
			}

			int output=(int)Math.round(outputValue);
			System.out.println("Reconstructed key: "+output);
			
			if (reqnode.equals("SENDER"))
				peernode.finalkey=output;
			else
			{
				peernode.receiverkey=output;
				String msg=peernode.decrypt(peernode.sendermsg);
				JOptionPane.showMessageDialog(this,"Message: "+msg,
					"Sender ID: "+peernode.senderid,JOptionPane.INFORMATION_MESSAGE);
			}
			
			
		}
		catch(Exception e)
		{
			System.out.println("findkey: "+e);
			JOptionPane.showMessageDialog(this,
				"Could not reconstruct or decrypt the message key.\n"
				+e.getClass().getSimpleName()+": "+e.getMessage());
		}
	}
	
	
	String readaddr(String node)
	{
		String address="";
		int ch=0;
		try
		{
			if (node.equals("KPA1"))
			{
				FileInputStream fin=new FileInputStream("kpa1.txt");
				while((ch=fin.read())!=-1)
				address+=(char)ch;
				address.trim();
				System.out.println("Address of KPA1: "+address);
			}
			else
			if (node.equals("KPA2"))
			{
				FileInputStream fin=new FileInputStream("kpa2.txt");
				while((ch=fin.read())!=-1)
				address+=(char)ch;
				address.trim();
				System.out.println("Address of KPA2: "+address);
			}
			else
			if (node.equals("KPA3"))
			{
				FileInputStream fin=new FileInputStream("kpa3.txt");
				while((ch=fin.read())!=-1)
				address+=(char)ch;
				address.trim();
				System.out.println("Address of KPA3: "+address);
			}
			else
			if (node.equals("KPA4"))
			{
				FileInputStream fin=new FileInputStream("kpa4.txt");
				while((ch=fin.read())!=-1)
				address+=(char)ch;
				address.trim();
				System.out.println("Address of KPA4: "+address);
			}
			else
			if (node.equals("KPA5"))
			{
				FileInputStream fin=new FileInputStream("kpa5.txt");
				while((ch=fin.read())!=-1)
				address+=(char)ch;
				address.trim();
				System.out.println("Address of KPA5: "+address);
			}
			else
			if (node.equals("KPA6"))
			{
				FileInputStream fin=new FileInputStream("kpa6.txt");
				while((ch=fin.read())!=-1)
				address+=(char)ch;
				address.trim();
				System.out.println("Address of KPA6: "+address);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return address.trim();
	}
	
	public static void main(String args[])
	{
		new getkeyparts("",0);
	}
}
