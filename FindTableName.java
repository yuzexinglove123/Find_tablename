package com.yuzexing.Find_TableName;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.lang.StringUtils;

/**
 * Hello world!
 *
 */
public class FindTableName {
	public static void main(String[] args) {
		BufferedReader br = null;
		try {
			// 1.构建存储“table_name” 的容器
			StringBuilder sb = new StringBuilder();

			// 2.br
			br = new BufferedReader(new FileReader("E:\\java_file_test\\from.txt"));
			String str = null;
			while ((str = br.readLine()) != null) {
				sb.append(str);

			}
			// 3.from 后面跟的就是表名
			StringBuilder sb2 = new StringBuilder();
			String[] s_a = sb.toString().split("\\s+");
			for (int i = 0; i < s_a.length; i++) {
				if (StringUtils.equals("from".toUpperCase(), s_a[i].toUpperCase())) {
					if (i +1< s_a.length) {
						for(int j=i+1;j<s_a.length;j++){
							if(s_a[j]!="") {
								sb2.append(s_a[j] + "\n");
								break;
							}
						}
						
						
					}

				}
			}
			// 4.输出到目标文件 to.csv
			BufferedWriter bw = new BufferedWriter(new FileWriter(new File("E:\\java_file_test\\to.csv")));

			bw.write(sb2.toString());
			bw.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}
}
