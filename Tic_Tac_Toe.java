import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.*;
class Tic_Tac_Toe extends JFrame implements ActionListener
{ 
  public static int ch=0;
  public int i;
  int flag=0;
  static int a[][] =new int[3][3];
  JButton b[]=new JButton[10];
  Tic_Tac_Toe()
  {
    setLayout(new GridBagLayout());
    GridBagConstraints c=new GridBagConstraints();
    c.fill=GridBagConstraints.BOTH;
    b[0]=new JButton("");
    c.gridx=0;
    c.gridy=0;
    b[0].setPreferredSize(new Dimension(80, 80));
    add(b[0],c);
    b[1]=new JButton("");
    c.gridx=1;
    c.gridy=0;
    b[1].setPreferredSize(new Dimension(80, 80));
    add(b[1],c);
    b[2]=new JButton("");
    c.gridx=2;
    c.gridy=0;
    b[2].setPreferredSize(new Dimension(80, 80));
    add(b[2],c);
    b[3]=new JButton("");
    c.gridx=0;
    c.gridy=1;
    b[3].setPreferredSize(new Dimension(80, 80));
    add(b[3],c);
    b[4]=new JButton("");
    c.gridx=1;
    c.gridy=1;
    b[4].setPreferredSize(new Dimension(80, 80));
    add(b[4],c);
    b[5]=new JButton("");
    c.gridx=2;
    c.gridy=1;
    b[5].setPreferredSize(new Dimension(80, 80));
    add(b[5],c);
    b[6]=new JButton("");
    c.gridx=0;
    c.gridy=2;
    b[6].setPreferredSize(new Dimension(80, 80));
    add(b[6],c);
    b[7]=new JButton("");
    c.gridx=1;
    c.gridy=2;
    b[7].setPreferredSize(new Dimension(80,80));
    add(b[7],c);
    b[8]=new JButton("");
    c.gridx=2;
    c.gridy=2;
    b[8].setPreferredSize(new Dimension(80, 80));
    add(b[8],c);
    for(i=0;i<9;i++)
    {
      b[i].setOpaque(true);
      b[i].setBackground(Color.WHITE);
      b[i].addActionListener(this);
    }

  }
  public int findWin(int a[][])
  {  int result=0;
       if(a[0][0]+a[2][2]+a[1][1]==15)
       { 
    	   JOptionPane.showMessageDialog(null,"player o wins");
    	   for(i=0;i<9;i++)
           {
	             b[i].setIcon(null);
            }
				  for(int k=0;k<3;k++)
				  for(int j=0;j<3;j++)
				  a[k][j]=0;
				  result=1;
       }
           
           

					else if(a[0][2]+a[1][1]+a[2][0]==15)
					{  
						JOptionPane.showMessageDialog(null,"player o wins");
						for(i=0;i<9;i++)
						{
						  b[i].setIcon(null);
						}
						for(int k=0;k<3;k++)
						for(int j=0;j<3;j++)
						a[k][j]=0;
						result=1;
					}
					
					else {

						  for(i=0;i<3;i++)
						  {
							int sum1=0;int sum2=0;
							for(int j=0;j<3;j++)
							{
							  sum1+=a[i][j];
							  sum2+=a[j][i];
							}
							if(sum1==15 || sum2==15) { JOptionPane.showMessageDialog(null,"player o wins"); flag=0; ch=0;
							for(i=0;i<9;i++)
							{
							  b[i].setIcon(null);
							}
							 result=1;
							for(int k=0;k<3;k++)
							for(int j=0;j<3;j++)
							a[k][j]=0;
						  }
						}
						 
					}
          if(result==1)  ch=0;
		   return result;
  }
  public int findOWinLoc(int a[][])
  {
	  int pos=-1,x=0,y=0,sum1=0,sum2=0;
	  int flag=0;
	  if(a[0][2]+a[1][1]+a[2][0]==10)
	  { //System.out.println(ch+"1");
		if(a[0][2]==0)
		{  x=0;y=2;
		 
		}
		else if(a[1][1]==0)
		{
		  x=1;y=1;
		 
		}
		else if(a[2][0]==0)
		{  x=2;y=0;
		}
		flag=1;
	  }
	  else
		{
		  //System.out.println(ch+"2");
		  int i,j;
		  for(i=0;i<3;i++)
		  { 
			sum1=0;sum2=0;
			for( j=0;j<3;j++)
			{
			  sum1+=a[i][j];
			  sum2+=a[j][i];
			}
			if(sum1==10)
			{ 
		     // System.out.println("sum1 : "+sum1+"  ");
			  if(a[i][0]==0)
			  {
				x=i; y=0;
			  }
			  else if(a[i][1]==0)
			  {
				x=i; y=1;
			  }
			  else if(a[i][2]==0)
			  {
				x=i; y=2;
			  }
			  flag=1;
              break;
			}
			else if(sum2==10)
			{
			  //System.out.println("sum2 :"+sum2+" ");
			  if(a[0][i]==0)
			  {x=0; y=i;}

			  else if(a[1][i]==0)
			  {
				x=1; y=i;
			  }
			  else if(a[2][i]==0)
			  {
				x=2;y=i;
			  }
			  flag=1;
			  break;
			}
			
		  }
		}
	  if(flag==1)
	  { pos=3*x+y; ch=0;}
	  return pos;
 
  }
  public int findXwinLoc(int a[][])
  {
	  int pos=-1,x=0,y=0,sum1=0,sum2=0;
	  int flag=0;
	  if(a[0][2]+a[1][1]+a[2][0]==6)
	  { 
		if(a[0][2]==0)
		{  x=0;y=2;
		 
		}
		else if(a[1][1]==0)
		{
		  x=1;y=1;
		 
		}
		else if(a[2][0]==0)
		{  x=2;y=0;
		}
		flag=1;
	  }
	  else
		{
		  
		  int i,j;
		  for(i=0;i<3;i++)
		  { 
			sum1=0;sum2=0;
			for( j=0;j<3;j++)
			{
			  sum1+=a[i][j];
			  sum2+=a[j][i];
			}
			if(sum1==6)
			{ 
		     
			  if(a[i][0]==0)
			  {
				x=i; y=0;
			  }
			  else if(a[i][1]==0)
			  {
				x=i; y=1;
			  }
			  else if(a[i][2]==0)
			  {
				x=i; y=2;
			  }
			  flag=1;
              break;
			}
			else if(sum2==6)
			{
			 
			  if(a[0][i]==0)
			  {x=0; y=i;}

			  else if(a[1][i]==0)
			  {
				x=1; y=i;
			  }
			  else if(a[2][i]==0)
			  {
				x=2;y=i;
			  }
			  flag=1;
			  break;
			}
			
		  }
		}
	  if(flag==1)
	   pos=3*x+y; 
	  return pos;
  }
  public int findDraw(int a[][])
  { 
   int result=0;
    if(ch==9)
	 {  ch=0;
	  flag=0;
	  if(a[0][0]!=0) {
		JOptionPane.showMessageDialog(null,"match drawn");
		for(i=0;i<9;i++)
		{
		  b[i].setIcon(null);
		}
		for(int k=0;k<3;k++)
		for(int j=0;j<3;j++)
		a[k][j]=0;
	  }
      result=1;
	}
	 return result; 
  }

  public void actionPerformed(ActionEvent e)
  {
    try
    {       
	        int p,f=0;
			ch++;
			System.out.println(ch);
			for(p=0;p<9;p++)
			{
			  if((e.getSource())==b[p]) break;
			}
			int x=0,y=0;
			if(ch%2==1)
			{ 
			  Image img = ImageIO.read(getClass().getResource("x.png"));
			 
			  //System.out.println(p);
			  
			  x=p/3;
			  y=p%3;
			  if(a[x][y]!=0)
			  {
				  JOptionPane.showMessageDialog(null,"You can't click a button twice"); 
				  f=1;
			  }
			  else
			  {
			 b[p].setIcon(new ImageIcon(img));
			  a[x][y]=3;
			 
			  if(ch<9)
			  ch++;
			  }
			}
			
			System.out.println(ch);
			if(ch==2)
			{
			  System.out.println(ch);
			  int t;
			  Image  img = ImageIO.read(getClass().getResource("o.jpg"));
			  if(a[1][1]==0)
			  {
				t=4;
			  }
			  else
			  {
				t=0;
			  }

			  b[t].setIcon(new ImageIcon(img));

			  a[t/3][t%3]=5;
			}
			else if(ch%2==0 && ch!=2)
			{
			  Image  img = ImageIO.read(getClass().getResource("o.jpg"));
			  int w=findOWinLoc(a);
			  if(w!=-1)
			  {
				  b[w].setIcon(new ImageIcon(img));
				  a[w/3][w%3]=5;
				  findWin(a);
			  }
			  else
			  {
			  int t=findXwinLoc(a);
			  if(t!=-1)
			  {
				  b[t].setIcon(new ImageIcon(img));
				  a[t/3][t%3]=5;
			  }
			  else
			  {
				  if(a[0][2]==0)
				  {
					  b[2].setIcon(new ImageIcon(img));
					  a[0][2]=5;  
				  }
				  else if(a[0][0]==0)
				  {
					  b[0].setIcon(new ImageIcon(img));
					  a[0][0]=5;  
				  }
				  else if(a[2][0]==0)
				  {
					  b[6].setIcon(new ImageIcon(img));
					  a[2][0]=5;
				  }
				  else if(a[2][2]==0)
				  {
					  b[8].setIcon(new ImageIcon(img));
					  a[2][2]=5; 
				  }
					  
				findWin(a);
			  }
              
			  }
			}
            findDraw(a); 
			
			   for(int i=0;i<3;i++)
			   {
				 for(int j=0;j<3;j++)
				 {
				   System.out.print(a[i][j] + " ");
				 }
				 System.out.println("");
			   }
			   if(findWin(a)==1)
				{
				    	
				}
			   if(f==1)
					ch--;
			}
			catch(Exception ex){ ex.printStackTrace();}
			}

public static void main(String args[])
{
		  for(int i=0;i<3;i++)
		  {
			for(int j=0;j<3;j++)
			a[i][j]=0;
		  }
		  Tic_Tac_Toe gui=new Tic_Tac_Toe();
		  gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  
		  gui.pack();
		  gui.setVisible(true);
		  gui.setTitle("14011A0551");
		  gui.setResizable(false);
		}
}
