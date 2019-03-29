import java.io.*;
class MacroNew3
{
	BufferedReader br1;
	String []mdt,mnt,p;
	int mdtc,mntc;
	BufferedWriter br2;
	String ch;
	int sp,n;
	String stack[];
	String ala[];
	int mdlc;
	int i;
	
	MacroNew3()throws IOException
	{
		br1=new BufferedReader(new FileReader("input3.txt"));
		mdt=new String[100];
		mnt=new String[100];
		br2=new BufferedWriter(new FileWriter("subhi.txt",true));
		String ch;
		sp=-1;
		n=-1;
		mntc=0;
		mdtc=0;
		mdlc=0;
		i=0;
		stack=new String[100];
		ala=new String[100];
	}
	
	void display()
	{
		int k;
		for(k=0;k<mdtc;k++)
			System.out.println(mdt[k]);
		for(k=0;k<mntc;k++)
			System.out.println(mnt[k]);
	}
	public static void main(String args[])throws IOException
	{
		MacroNew3 o1=new MacroNew3();
		
		o1.entryread();
		o1.display();
		
	}
		
		String readmodule()throws IOException
		{
			String ch;
			
			
			while(sp!=-1)
			{
				//int u=1;
				int y=Integer.parseInt(stack[sp+1]);
				//System.out.println(y);
				int u= y+1;
				stack[sp+1]=String.valueOf(u);
				i=sp+2;
				//int y1=Integer.parseInt(stack[sp+1]);
				String c=mdt[y+1];
				System.out.println(c);
				
				String []p,p2;
				int k,l=0;
				String s1="";
				String s[]=c.split("#");
				int f1=1;
				
				if((c.length()>5)||(c.charAt(0)=='#'))
				{
					if(c.charAt(0)=='#')
					{
						int t=s[1].charAt(0)-48;
						s[0]=stack[i+t]+" ";
						f1=2;
					}
				
				
				for(l=f1;l<s.length;l++)
				{
					String p3[]=s[l].split(",");
					int t1=p3[0].charAt(0);
					if(t1>=48&&t1<=57)
					{
						int t=p3[0].charAt(0)-48;
					//System.out.println(p3[0]);
					
					int r=i+t;
					System.out.println("i is"+i);
					s[0]=s[0]+stack[r];
					
					}
					else
					{
						s[0]=s[0]+(char)t1;
					}
					
					if(l<(s.length-1))
						s[0]=s[0]+",";
				}
				
				System.out.println(s[0]);
				}
				
				//System.out.println(s1);
				if(s[0].length()>5)
				{
					int flag=0;
				String p1[]=s[0].split(" ");
				for(k=0;k<mntc;k++)
				{
					p=mnt[k].split(" ");
					if(p[0].equals(p1[0])==true)
					{
						flag=1;
					}
				}
				if(flag==1)
				{
					l=0;
					for(k=0;k<mdtc;k++)
					{
						p2=mdt[k].split(" ");
						
						if(p2[0].equals(p1[0])==true)
						{
							l=k;
							break;
						}
					}
					
					stackfun(l,s[0]);
					entryread();
				}
				}
				
				if(c.equals("MEND")==true)
				{
					if(mdlc==0)
					{
						y=Integer.parseInt(stack[sp]);
						n=sp-y-2;
						sp=Integer.parseInt(stack[sp]);
						entryread();
					}
					else
						return s[0];
				}
				else
					return s[0];
			
			}
			if(sp==-1)
			{
			while((ch=br1.readLine())!=null)
			{
				//System.out.println(ch);
				return ch;
			}
			}
			return "";
	}
		
		
		void entryread()throws IOException
		{
				String ch=readmodule();
				System.out.println(ch);
				if(ch=="")
					return;
				int flag=0;
				String []p,p2;
				int k,l=0;
				String p1[]=ch.split(" ");
				for(k=0;k<mntc;k++)
				{
					p=mnt[k].split(" ");
					if(p[0].equals(p1[0])==true)
					{
						flag=1;
					}
				}
				if(flag==1)
				{
					
					for(k=0;k<mdtc;k++)
					{
						p2=mdt[k].split(" ");
						if(p2[0].equals(p1[0])==true)
						{
							l=k;
							break;
						}
					}
					stackfun(l,ch);
					entryread();
				}
				else
				{
					if(ch.equals("MACRO")==true)
					{
						mdlc++;
						String c=readmodule();
						//System.out.println("hkjk::"+c);
						read1(c);
					}
					else
					{
						br2.write(ch);
						br2.newLine();
						if(ch=="END")
							return;
						else
							entryread();
					}
				}
			
			System.out.println("MDT IS:");
		for(k=0;k<mdtc;k++)
			System.out.println(mdt[k]);
		System.out.println("MNT IS:");
		for(k=0;k<mntc;k++)
			System.out.println(mnt[k]);
				br2.close();
				br1.close();
				System.exit(0);
		}
			
	void stackfun(int l,String ch)throws IOException
	{
		//System.out.println(l);
		stack[sp+(n+1)+1]=String.valueOf(sp);
		sp=sp+(n+1)+1;
		//System.out.println(l);
		stack[sp+1]=String.valueOf(l);
		//System.out.println(stack[sp+1]);
		String []p,c;
		
		p=ch.split(" ");
		c=p[1].split(",");
		n=c.length;
		//System.out.println(n);
		int k,h=0;
		i=sp+2;
		for(k=sp+2;k<=(sp+n+1);k++)
		{
			stack[k]=c[h];
			h++;
		}
		for(k=0;k<=(sp+n+1);k++)
			System.out.println(stack[k]);
	}
	
	void read1(String ch)throws IOException
	{
		String c;
		mnt[mntc]=ch;
		mdt[mdtc]=ch;
		
		mntc++;
		mdtc++;
		int h=0;
		if(sp!=-1)
		{
			String s[]=ch.split(" ");
			String s1[]=s[1].split(",");
			String l[];
			
			for(int k=0;k<s1.length;k++)
			{
				
					ala[h]=s1[k];
					h++;
			}
		}
		else
		{
		String s[]=ch.split(" ");
		String s1[]=s[1].split("&");
		String l[];
		
		for(int k=0;k<s1.length;k++)
		{
			if(k!=0)
			{
				l=s1[k].split(",");
				ala[h]=l[0];
				h++;
			}
		}
		}
		
		for(int k=0;k<h;k++)
			System.out.println(ala[k]);
		
		read2(h);
		entryread();
	}
		
	void read2(int h)throws IOException
	{
		String c=readmodule();
		//System.out.println("jhj;;"+c);
		if(c=="")
			return;
		String s[]=c.split(" ");
		//for(int k=0;k<s.length;k++)
			//System.out.println(s[k]);
		if(s.length>1)
		{
		String s1[]=s[1].split(",");
		//System.out.println(s1[0]);
		int e=s1[0].charAt(0);
		
		
		if(e>=48&&e<=57)
		{
		int m;
		
			//System.out.println(e);
			if(sp==-1)
			{
				p=s1[1].split("&");
			int g1=0;
			for(m=0;m<h;m++)
			{
				if(p[1].equals(ala[m]))
				{
					s1=c.split("&");
					s1[0]=s1[0]+"#"+m;
					mdt[mdtc]=s1[0];
					g1=1;
					mdtc++;
					break;
				}
			}
			
			if(g1==0)
			{
				s1=c.split("&");
				s1[0]=s1[0]+"#"+p[1];
				mdt[mdtc]=s1[0];
				mdtc++;
			}
				
			}
			else
			{
				int g1=0;
				p=c.split(",");
				p[0]=p[0]+",";
				for(m=0;m<h;m++)
				{
				if(s1[1].equals(ala[m]))
				{
					p[0]=p[0]+"#"+m;
					mdt[mdtc]=p[0];
					//System.out.println("bnbh"+p[0]);
					mdtc++;
					g1=1;
					break;
				}
				}
				if(g1==0)
				{
					p[0]=p[0]+"#"+s1[1];
					mdt[mdtc]=p[0];
					mdtc++;
				}
			}
		}
		else
		{
			int m;
			int f=0;
			String w="#";
			
			if(s[0].charAt(0)=='&')
			{
				String d[]=s[0].split("&");
				for(m=0;m<h;m++)
				{
					if(d[1].equals(ala[m])==true)
					{
						s[0]=w+m;
	
					}
				}
				
				
			}
			s[0]=s[0]+" ";
			int w1=0;
			if(sp==-1)
			{
			for(int g=0;g<s1.length;g++)
			{
				p=s1[g].split("&");
				for(m=0;m<h;m++)
				{
					if(p[1].equals(ala[m]))
					{
						
						s[0]=s[0]+"#"+m;
						f=1;
						w1=1;
						
					}
				}
				if((w1==0)&&(c.equals("MEND")==false)&&(c.equals("MACRO")==false))
				{
					s[0]=s[0]+"#"+p[1];
					f=1;
				}
				if(g<(s1.length-1))
					s[0]=s[0]+",";
				
			}
			}
			else
			{
				w1=0;
				for(int g=0;g<s1.length;g++)
				{
				
				for(m=0;m<h;m++)
				{
					if(s[g+1].equals(ala[m]))
					{
						
						s[0]=s[0]+"#"+m;
						f=1;
						w1=1;
						
					}
				}
				if((w1==0)&&(c.equals("MEND")==false)&&(c.equals("MACRO")==false))
				{
					s[0]=s[0]+"#"+p[1];
					f=1;
				}
					
				if(g<(s1.length-1))
					s[0]=s[0]+",";
				
				}
			}
			if(f==1)
			{
				mdt[mdtc]=s[0];
				mdtc++;
			}
		}
		}
			if(c.equals("MACRO")==true)
			{
				mdlc++;
				mdt[mdtc]=c;
				mdtc++;
				read2(h);
			}
			else
			{
				if(c.equals("MEND")==true)
				{
					mdt[mdtc]=c;
					mdtc++;
					mdlc--;
					if(mdlc==0)
						return;
					else
						read2(h);
				}
				
				else
					read2(h);
			}
		
	}				
}