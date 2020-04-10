package file;

import java.io.File;

public class CreateFile {
	String path;
	String name;
	public CreateFile(String path,String name) {
		path = this.path;
		name = this.name;
	}
	public boolean createFile(String path,String name) {		//创建文件的构造函数
		File f = new File(path+File.separator+name);
		if(f.mkdir())											//判断新文件是否存在
			System.out.println("创建成功！");
		return f.mkdir();
	}
}
