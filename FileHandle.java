package hotel1;
import java.io.*;
public class FileHandle{
File f;
BufferedWriter bw;
public FileHandle(String path)
{
f  =  new File(path); //Can Be given as command input.
}
public void SaveName(String name) throws IOException
{
	try{
		FileOutputStream fout = new FileOutputStream(f,true);
		bw = new BufferedWriter(new OutputStreamWriter(fout));
		bw.write(name);
		bw.newLine();
	}catch(IOException ie){
	System.out.println("Error occured. Closing");
	}
	finally{
	bw.close();
	}
}

public boolean isOldCustomer(String name) throws FileNotFoundException, IOException
{
	BufferedReader br = new BufferedReader(new FileReader(f));
	String names;
	do
	{
	 names = br.readLine();
	if(names != null)
	 if(names.equals(name))	
	   return true;	
	}while(names != null);
    return false;
}

public void clearRecords() 
{
    BufferedWriter b = null;
    try{
		FileOutputStream fout = new FileOutputStream(f);
		b = new BufferedWriter(new OutputStreamWriter(fout));
		b.write("");

	}catch(Exception ie){
	System.out.println("Error occured. Closing");
	}
	finally{
	try{
            b.close();
        }catch(IOException ie)
        {}
	}
}
}
