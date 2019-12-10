package com.test.javaBasic;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class JavaDay04 {
	public static void main(String[] args) {
//		System.out.println(ballHight(10, 3));
//		System.out.println(2 * rabNum(10));
//		System.out.println(defValue(0));

//		�㷨������--------ð������(Bubble Sort):�����Ƚϣ����ֵ�ź���
		int[] demoArr = { 5, 9, 7, 4, 3 };
//		���󷽷�����
//		Arrays.sort(demoArr); //����
		// �ֶ�����
//		{5,9,7,4,3}  
//		
//		{5,9,7,4,3}      ��һ�� ��һ��
//		{5,7,9,4,3}      ��һ�� �ڶ���
//		{5,7,4,9,3}      ��һ�� ������
//		{5,7,4,3,9}      ��һ�� ���Ĵ�
//		
//		{5,7,4,3,9}      �ڶ��� ��һ��
//		{5,4,7,3,9}      �ڶ��� �ڶ���
//		{5,4,3,7,9}      �ڶ��� ������
//		
//		{4,5,3,7,9}      ������ ��һ��
//		{4,3,5,7,9}      ������ �ڶ���
//		
//		{3,4,5,7,9}      ������ ��һ��

		arraySort(demoArr);
		System.out.println(Arrays.toString(demoArr));

//		�㷨�����ң�����------���ַ�
		//��д���ַ�
		int[] demoArr02 = { 12, 24, 53, 23, 56, 74, 96, 235, 65, 47, 70, 1, 2, 5, 9, 7, 30 };
		arraySort(demoArr02);  //����֮ǰ ��������
		System.out.println(Arrays.toString(demoArr02));
		int value = 80; //����ѯ��ֵ
		int high = demoArr02.length - 1;  //�Ҳ�߽��±�
		int low = 0;  //���߽��±�
		int middle = 0;  //�±���ֵ
		int index = 0;  //�ӱ���ѯ��ֵ���±�
		boolean boo = false;  //���أ��жϱ���ѯ��ֵ�Ƿ��������У�
		while (low <= high) { //ѭ�����������߽��±� <=�Ҳ�߽��±꣩
			middle = (low + high) / 2;  //�±���ֵ��ֵ ���ڣ����߽�+�Ҳ�߽磩/2
			if (demoArr02[middle] == value) { //�������ѯ��ֵ�����м��±��ӦԪ��ֵ
				boo = true;                 //�򿪿���
				index = middle;             //���±���ֵ��ֵ��index
				break;                      //����ѭ��
			}
			if (demoArr02[middle] > value) {  //�������ѯ��ֵ<�м��±��ӦԪ��ֵ
				high = middle - 1;            //�µ��Ҳ�߽����ԭ��ֵ�±�-1
			}
			if (demoArr02[middle] < value) {  //�������ѯ��ֵ>�м��±��ӦԪ��ֵ
				low = middle + 1;             //�µ����߽����ԭ��ֵ�±�+1
			}
		}
		if(boo) {      //�жϿ���״̬
			System.out.println(value+"�������У��±�Ϊ"+index);
		}else {
			System.out.println(value+"����������");
		}
		//ϵͳ����ķ���ʵ�ֲ���
		System.out.println(Arrays.binarySearch(demoArr02,80));
		
		//����̨���� ʹ�ó������ֲ��򷽷����ܲ���
//		Scanner scan=new Scanner(System.in); //ʵ����Scanner����
//		int x=scan.nextInt(); //�������ͱ��� �ӿ���̨��ֵ
//		System.out.println(x);
////		Byte y=scan.nextByte();
////		System.out.println(y);
//		String s=scan.next(); //�����ַ����������ӿ���̨��ֵ
//		System.out.println(s);
//		double h=scan.nextDouble();
//		int n=scan.nextInt();
//		System.out.println(ballHight(h,n));
		
		//���������
		Random rd=new Random();  //�����������
		int target=rd.nextInt(100)+1;   //random.nextInt(n)   ����[0,n)�������
		if(target<=3) {
			System.out.println("��ϲ���SSR");
		}else if(target<=13) {
			System.out.println("��ϲ���SR");
		}else if(target<=63) {
			System.out.println("��ϲ���R");
		}else {
			System.out.println("лл�ݹ�");
		}

	}

//	case:1 һ�����h�׸߶�׹�䣬��һ�η�����h/2���ڶ��η�������һ�ε�һ�롣
//  �����n�Σ������ض�����
	public static double ballHight(double h, int n) {
		if (n == 0) {
			return h;
		} else {
			return ballHight(h, n - 1) / 2;
		}
	}
//	1:ballHight(h,n)==ballHight(h,n-1)/2     2: ballHight(h,0)==h

//case��2 ��һ�����ӣ��ӳ������3������ÿ���¶���һ�����ӣ�С���ӳ�����������
//��ÿ�����ֿ�ʼ������.���㣬��n���� ��������Ϊ���١�
//�·�            ����
//1                1 
//2                1
//3                2
//4                3
//5                5
//6                8
//	rabNum(6)==rabNum(5)  + rabNum(4)    rabNum(2)==1  rabNum(1)==1
	public static int rabNum(int month) {
		if (month == 2 || month == 1) {
			return 1;
		} else {
			return rabNum(month - 1) + rabNum(month - 2);
		}
	}

//case��3 һ���������ƣ�ÿ�α�����������ֵ����һ���ټ���1�㣬�Ժ�ÿ�α�������
//����ֵ������(��ǰ����ֵ��һ���1��)������ʮ�α���������֮�󣬷���ֵֻʣ1�㣬
//����������Ƴ�ʼֵΪ���١�
	public static int defValue(int attTime) {
//	defValue(n)==  (defValue(n+1)+1)*2  
//			defValue(10)==1	
		if (attTime == 10) {
			return 1;
		} else {
			return (defValue(attTime + 1) + 1) * 2;
		}
	}
	
	public static void arraySort(int[] demoArr) {
		for (int i = 0; i < demoArr.length - 1; i++) {
			for (int j = 0; j < demoArr.length - 1 - i; j++) {
				if (demoArr[j] > demoArr[j + 1]) {
					int temp = demoArr[j];
					demoArr[j] = demoArr[j + 1];
					demoArr[j + 1] = temp;
				}
			}
		}
	}
//	!!!debug���У�debug���ԣ������debug��ť   F6����һ��  F8:ֱ����������һ���ϵ㣨���޶ϵ㣬�������У�
//            F5:���뷽��   F7���˳�����
	
	
	
	
}
