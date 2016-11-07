package com.sso.sys.common.utils.fileUtils;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 排除非法的文件 :循环删除文件夹中不符合条件的文件
 * @author Administrator
 *
 */
public class DelIllegalFiles {

    /**
     * 
     * @author zdz8207
     */
    public static void main(String[] args) {
    	String path = "E:/Win7壁纸";
//    	delIllegalFiles(path);
//        isDel();
    }



    /**
     * 排除非法的文件 :循环删除文件夹中不符合条件的文件
     * @param path
     */
    public static void delIllegalFiles(String path) {
        File f = new File(path);
        if (!f.exists()) {
            System.out.println(path + " not exists");
            return;
        }
        File fa[] = f.listFiles();
        for (int i = 0; i < fa.length; i++) {
            File fs = fa[i];
            if (fs.isDirectory()) {
                System.out.println(fs.getName() + " [目录]");
                delIllegalFiles(path+"/"+fs.getName());
            } else {
                System.out.println(fs.getName());
                if(isDel(fs.getName())){
                	fs.delete();
                }
            }
        }
    }
    /**
     * 排除文件名 有括号的文件
     * @param s
     * @return
     */
    static boolean isDel(String s){
	    String regEx = "\\(.*\\)";
	    Pattern pat = Pattern.compile(regEx);
	    Matcher mat = pat.matcher(s);
	    boolean rs = mat.find();
//	    for(int i=1;i<=mat.groupCount();i++){
//	    	System.out.println(mat.group(i));
//	    }
//	    System.out.println(rs);
		return rs;
    }
    
}