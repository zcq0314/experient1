package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class EncryptFile {
	String path;
	public EncryptFile(String path) {
		path = this.path;
	}
	public void encryptFile(String path) {
		try {
			File inf = new File(path);
			File outf = new File(path+".txt");
			if(!inf.isFile()||!inf.exists())
				System.out.println("文件出错！");
			if((!outf.isFile()||!outf.exists())&&inf.exists())
				outf.createNewFile();
			byte b[] = new byte[1024*1024];
			FileInputStream fin = new FileInputStream(inf);
			FileOutputStream fout = new FileOutputStream(outf);
			int len = fin.read(b);
			while(len!=-1) {
				for(int i=0;i<len;i++) {
					b[i]^= 1;
					fout.write(b);
				}
				len = fin.read(b);
			}
			fin.close();
			fout.close();
			inf.delete();
			outf.renameTo(new File(path));
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
