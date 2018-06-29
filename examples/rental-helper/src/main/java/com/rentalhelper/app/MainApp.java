package com.rentalhelper.app;

import java.util.InputMismatchException;
import java.util.Scanner;


/**
* Title: MainApp.java
*
*  Description: ���Τp���A�i�d�ߩҦ�����B��@����B�έp���@���󤧥��������C
*  Copyright: Copyright (c) 2018
*  @author Howard, Ching
*  @time 2018�~6��29�� �W��11:19:24
*  @version 1.0
*/
public class MainApp {
	public static void main(String[] args) {
		String optCase = ""; // ����N��
		boolean hasFlag = false; // �P�_����O�_�s�b
		Case selectedCase = new Case();  // ��ܨ줧����
		int monthlyPrice = 0; // �C�믲��
		int expectedMonths = 0; // �w�p����
		int actualMonths = 0; // ��گ���
		int depositMonths = 0; // �������

//		try {

			Case caseA = new Case("A", 10f, "�M��", 12000, "������", "�x�_����s�Ϥ�]���@�qxx��");
			Case caseB = new Case("B", 8f, "�M��", 8000, "������", "�s�_�����M�Ϥ��M��yy��");
			Case caseC = new Case("C", 4f, "����", 6000, "�L����", "�s�_���s���Ϥ�����aa��zz��");
			Case caseD = new Case("D", 2f, "����", 4500, "�L����", "�x�_����s�Ϥ�s���G�qww��");
			Case caseE = new Case("E", 1f, "����", 80000, "������", "�x�_���j�w�Ϸs�ͫn���@�qxx��");
			Case[] cases = {caseA, caseB, caseC, caseD, caseE};

			Scanner sc = new Scanner(System.in);

			mainLoop:while(true) {
				try {
					System.out.println("�w��ϥί��Τp����, �п�ܥ\��:");
					System.out.println("1. ���C�Ҧ��X���Ы�");
					System.out.println("2. �ЫΥX���d��");
					System.out.println("3. �����պ�");
					System.out.println("4. ���}");

					if(sc.hasNextInt()) {
						int opt = sc.nextInt();

						switch (opt) {
						case 1: //�L�X�Ҧ�����
							for (Case tempCase : cases) {
								tempCase.display();
							}
							break;
						case 2:
							System.out.println("�п�J����N��:");
							optCase = sc.next().toUpperCase();
							for (Case tempCase : cases) {
								if(tempCase.id.equals(optCase)) {
									tempCase.display();
									hasFlag = true;
								}
							}
							if(!hasFlag) {
								System.out.println("�ܩ�p�A���󤣦s�b!");
							}
							break;
						case 3: 
							System.out.println("�п�J����N��:");
							optCase = sc.next();

							for (Case tempCase : cases) {
								if(tempCase.id.equals(optCase)) {
									selectedCase = tempCase;
									hasFlag = true;
								}
							}
							if(!hasFlag) 
							{
								System.out.println("�ܩ�p�A���󤣦s�b!");
								continue;
							}
							monthlyPrice = selectedCase.price;

							System.out.println("�п�J�������(��):");
							depositMonths = sc.nextInt();

							if(depositMonths>0){

								System.out.println("�п�J�X������(��):");
								expectedMonths = sc.nextInt();

								if(expectedMonths > 0) {

									System.out.println("�п�J��گ���(��):");
									actualMonths = sc.nextInt();

									if(actualMonths >= 0 && actualMonths <= expectedMonths) {

										// �i�毲���պ�
										int total = actualMonths * monthlyPrice
												+ ((actualMonths< expectedMonths) ? depositMonths * monthlyPrice : 0 );
										float average = total / (float) actualMonths;
										System.out.println("�����`�B: " + total + " ��");
										System.out.println("�륭������: " + average + " ��");

									}else {
										System.out.println("��ƵL�ġi��گ�����������0��X�����������j");
									}
								}else {
									System.out.println("��ƵL�ġi�X�����������j��0�j");
								}
							}else {
								System.out.println("��ƵL�ġi������ƥ����j��0�j");
							}
							break;
						case 4:
							System.out.println(">>>>�i�{�������j......>>>>>");
							break mainLoop;				
						default:
							break;
						}
					}else{
						sc.next(); //��sc���в��ʡA�קK�L�a�j��
					}
					System.out.println("-------------------------------------");
				}catch(InputMismatchException imex) {
					System.out.println("��ƵL�ġi�п�J�Ʀr�j");
					continue;				
				}
			} // End of mainLoop
			sc.close(); 
//		}catch(Exception ex) {
//			System.out.println(ex.toString());
//		}
	}	
}
