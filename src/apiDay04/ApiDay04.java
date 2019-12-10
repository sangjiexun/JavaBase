package com.test.apiDay04;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Arrays;

public class ApiDay04 {
	public static void main(String[] args) {
		String strDemo = "abc";
		for (int i = 0; i < strDemo.length(); i++) {
			System.out.println(strDemo.charAt(i));
			if (strDemo.charAt(i) <= 57 && strDemo.charAt(i) >= 48) {
				System.out.println("error");
				break;
			}
		}

//		BigDecimal a=new BigDecimal(int/double/long/string);
		BigDecimal a = new BigDecimal("9");
		BigDecimal b = new BigDecimal("2.2");
//		Ϊ��ֹ���ȶ�ʧ��ʹ��String������Ϊ����
//		System.out.println(a.add(b));  //�ӷ�
//		System.out.println(a.subtract(b));  //����
//		System.out.println(a.multiply(b));//�˷�
//		System.out.println(a.divide(b)); //����
//		System.out.println(a.remainder(b)); //��

		System.out.println(a.divide(b, 3, 4)); // ����
		System.out.println(BigDecimal.ROUND_HALF_UP); // ��������  4
		System.out.println(BigDecimal.ROUND_CEILING); // ���Ͻ�λ  2
		System.out.println(BigDecimal.ROUND_FLOOR); // ����λ  3

//		������λС��  1
		double demoX=13.232423535;
		DecimalFormat df1=new DecimalFormat("0.000");
		String str=df1.format(demoX);
		System.out.println(str);
//		������λС��  2	
		String str02=String.format("%.5f", demoX);
		System.out.println(str02);
//		������λС��  3
		BigDecimal c = new BigDecimal(String.valueOf(demoX)).setScale(3,BigDecimal.ROUND_HALF_UP);
		System.out.println(c);
//		I/O : java���ڲ���ϵͳ���ļ�ϵͳ��֧��
//		File�ࣺ ���������ļ�ϵͳ�� һ���ļ� ���� һ��Ŀ¼
//		File�๦�ܣ� ͨ��file ���Ի�ȡ�ļ�����Ŀ¼������ ��С  �޸����� ������ ���ǣ��������ܶ��ļ����ݽ��з���
		
//		File�ķ���   exists()   �жϵ�ǰfile�����Ƿ����
		File file01=new File("D:\\test\\NewFile.java");  //��б��   ˫��б�� ��ʾ �ļ��д�����ϵ
		if(file01.exists()) {
			System.out.println(file01.getName()); //��ȡ�ļ���
			System.out.println(file01.length()); //�ļ���С
			System.out.println(file01.lastModified()); //����޸�ʱ��
			System.out.println(file01.getPath()); //��ȡ·��
			System.out.println(file01.canRead()); //�Ƿ�ɶ�
			System.out.println(file01.canWrite());//�Ƿ��д
			System.out.println(file01.canExecute()); //�Ƿ��ִ��
		}else {
			try {
				file01.createNewFile(); //�������ļ�!!!!
				System.out.println("�ļ������ɹ�");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("�ļ�����ʧ��");
			}
		}
		
//		����Ŀ¼!!!!!
		File file02=new File("D:\\test\\1\\2");
//		System.out.println(file02.mkdir()); //������һ���ĸ�Ŀ¼�����ڣ����޷�����
//		System.out.println(file02.mkdirs());
		
//		ɾ��Ŀ¼���ļ�
//		System.out.println(file02.delete()); //ɾ�����һ��
		
//		�ж�file�����Ƿ����ļ�
		System.out.println(file01.isFile());
		
//		�ж�file�����Ƿ���Ŀ¼
		System.out.println(file02.isDirectory());
		
//		��ȡfileĿ¼�µ�����������ļ�������ʽ���� !!!���������������
		File[] file_arr=file02.listFiles();
		System.out.println(Arrays.toString(file_arr));
//		��ȡfileĿ¼�µ�����������ַ���������ʽ���أ�ֻ��ʾ������ !!!���������������
		String[] str_arr=file02.list();
		System.out.println(Arrays.toString(str_arr));
		
//		case:
//			1.�鿴D��������ж������ļ�����Ŀ¼��
//			����Ŀ¼ �����   Ŀ¼��Ŀ¼��
//			�����ļ� �����   �ļ��� �ļ���
//			File fileD=new File("D:\\apache-tomcat-8.5.34");
//			2.�Լ�ѡ��һ��FileĿ¼���� �����Ŀ¼����������
//			��������Ŀ¼��������������ֱ�������ļ��������
//			showFile(fileD);
			
//			I/O ������:����  {�ֽ���   �ַ���}
//			����ģ��������ݵ���С��λ��һ�����ֽڣ�һ�����ַ�������Ǵ��ı��ļ����Ƽ�ʹ���ַ���
			
//			�ֽ����� �ֽ�������  inputStream  �ֽ������  outputStream
//			�ֽ����������
			try {
				FileInputStream fileIn=new FileInputStream("D:\\test\\�������ļ�.txt");
				FileOutputStream fileOut =new FileOutputStream("D:\\test\\�������ļ�.txt");				
				//��ȡ�ļ�����
				int temp=0;				
				while((temp=fileIn.read())!=-1) {
					fileOut.write(temp);
				}
				fileIn.close();   //�ر�������
				fileOut.close();   //�ر������
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				FileInputStream fileIn=new FileInputStream("D:\\test\\bg01.jpg");
//				File fileN=new File("D:\\test\\bg02.jpg");
//				fileN.createNewFile();
				FileOutputStream fileOut =new FileOutputStream("D:\\test\\bg02.jpg");				
				//��ȡ�ļ�����
				int temp=0;
				
				while((temp=fileIn.read())!=-1) {
					fileOut.write(temp);
				}
				fileIn.close();   //�ر�������
				fileOut.close();   //�ر������
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public static void showFile(File file) {   //д�ɷ��� �β�Ϊfile���� ��������Ϊ�������
		if(file==null) {
			return;
		}
		File[] file_arr=file.listFiles();   //תΪfile��������

		for(File f:file_arr) {   //����������
			if(f.isDirectory()) {   //�ж��Ƿ�ΪĿ¼
				System.out.println("Ŀ¼��"+f);   //����Ŀ¼ �����  ������Ŀ¼������Ϊʵ���ٴ����б�����
				showFile(f);
			}else {
				System.out.println("�ļ���"+f);  //�����ļ� ֱ�����
			}
		}
	}
}
