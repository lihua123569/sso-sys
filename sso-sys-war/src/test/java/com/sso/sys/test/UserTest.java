package com.sso.sys.test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

import com.sso.sys.common.plugs.vcode.generator.Generator;
import com.sso.sys.common.plugs.vcode.generator.Gif2VCGenerator;
import com.sso.sys.common.plugs.vcode.generator.Gif3VCGenerator;
import com.sso.sys.common.plugs.vcode.generator.GifVCGenerator;
import com.sso.sys.common.plugs.vcode.generator.PngVCGenerator;

public class UserTest {

	
	//生成验证码图片到本地磁盘 draw image and save to disk
	
	@Test
	public void  d() throws FileNotFoundException, IOException{
	        String path = ".";//图片存储路径 path for image save 
	        Integer height = 40;//image 高度。  image height. count as pixel
	        Integer width = 200;//image 宽度。 image width. count as pixel
	        Integer count = 5;  // validation code length.
	        String validCode = null; //验证码
	        Generator generator = new PngVCGenerator(width, height, count);
	        generator.write2out(new FileOutputStream(path + "/1.png")).close();
	        validCode = generator.text(); //get the validation code as 'String'
	        System.out.println(validCode);
	        generator = new GifVCGenerator(width, height, count);//   gif
	        generator.write2out(new FileOutputStream(path + "/1.gif")).close();
	        validCode = generator.text();
	        System.out.println(validCode);
	        generator = new Gif2VCGenerator(width, height, count);//   gif
	        generator.write2out(new FileOutputStream(path + "/2.gif")).close();
	        validCode = generator.text();
	        System.out.println(validCode);
	        generator = new Gif3VCGenerator(width, height, count);//   gif
	        generator.write2out(new FileOutputStream(path + "/3.gif")).close();
	        validCode = generator.text();
	        System.out.println(validCode);
	}
	
}
