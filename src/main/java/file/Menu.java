package file;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Menu {

	public static void main(String[] args)throws IOException {
		Scanner s = new Scanner(System.in);
		String nowPath = new String();
		while(true) {
			String op = s.next();
			switch(op) {
			//创建文件
			case "create":
				String pathCreate = s.next();		//创建新文件的路径
				String nameCreate = s.next();		//创建新文件的名字
				CreateFile create=new CreateFile(pathCreate,nameCreate);	//创建新文件
				create.createFile(pathCreate,nameCreate);
				break;
			//删除文件
			case "delete":
				File dir = new File(s.next());
				if(dir.exists()&&dir.isDirectory()) {		//如果文件存在且为目录
					DeleteFile delete=new DeleteFile(dir);
					delete.deleteFile(dir);
					System.out.println("删除成功！");
				}
				else
					System.out.println("找不到文件路径"+dir);
				break;
			//进入文件
			case "cd":
				nowPath = s.next();
				File test=new File(nowPath);		//测试当前路径是否存在
				if(!test.exists())
					System.out.println("路径有错误！");
				break;
			//内容罗列
			case "ls":
				File dirList=new File(nowPath);
				if(dirList.isDirectory()&&dirList.exists()) {		//测试当前路径是否有文件
					ListFile list=new ListFile(dirList);
					list.listFile(dirList);
				}
				else
					System.out.println("默认路径为空！");
				break;
			//拷贝文件
			case "cp":
				String src = s.next();
				String des = s.next();
				CopyFile copy=new CopyFile(src,des);
				copy.copyFile(src,des);
				break;
			//文件加密
			case "encrypt":
				String pathEn = s.next();		//加密地址
				EncryptFile encrypt=new EncryptFile(pathEn);
				encrypt.encryptFile(pathEn);
				break;
			//文件解密
			case "decrypt":
				String pathDe = s.next();		//解密地址
				DecryptFile decrypt=new DecryptFile(pathDe);
				decrypt.decryptFile(pathDe);
				break;
			//说明
			case "help":
				System.out.println("帮助文档：");
				System.out.println("创建文件（夹）：create + 文件路径 + 文件名称");
				System.out.println("删除文件（夹）：delete + 文件路径");
				System.out.println("进入文件（夹）：cd + 文件路径");
				System.out.println("当前文件夹内容罗列：ls");
				System.out.println("复制文件（夹）：cp + 原路径 + 目的路径");
				System.out.println("文件加密：encrypt + 文件路径");
				System.out.println("文件解密：decrypt + 文件路径");
				System.out.println("退出：exit");
				break;
			//退出
			case "exit":
				System.exit(0);
				s.close();
				break;
				
			default:
				break;
			}
		}

	}

}
