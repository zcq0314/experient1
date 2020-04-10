package file;

import java.io.File;

public class DeleteFile {
	File path;
	public DeleteFile(File path) {
		path = this.path;
	}
	public void deleteFile(File path) {
		File fs[] = path.listFiles();
		int listlength = fs.length;
		for(int i=0;i<listlength;i++) {
			if(fs[i].isFile())
				fs[i].delete();
			else
				deleteFile(fs[i]);
		}
		path.delete();
	}
}
