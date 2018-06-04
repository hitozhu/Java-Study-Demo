package com.htzhu;

import java.io.File;

/**
 * TempTest
 *
 * @author zhuhaitao
 * @date 2018/6/1 16:11
 **/
public class TempTest {

	public static void main(String[] args) {

		File file = new File("/Users/hito/document/Java/maven/repsotory");
		readFile(file);

	}

	public static void readFile(File file) {
		if (file.isDirectory()) {
			File[] files = file.listFiles();
			for (File f : files) {
				readFile(f);
			}
		} else {
			if (file.getName().endsWith(".lastUpdated")) {
				file.delete();
				System.out.println(file.getName());
			}
		}
	}
}
