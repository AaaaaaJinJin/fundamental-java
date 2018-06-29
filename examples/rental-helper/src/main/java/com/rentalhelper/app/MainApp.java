package com.rentalhelper.app;

import java.util.InputMismatchException;
import java.util.Scanner;


/**
* Title: MainApp.java
*
*  Description: 租屋小當手，可查詢所有物件、單一物件、或計算單一物件之平均租金。
* Copyright(C)2005 by Howard, Ching, IISI
*  @author Howard, Ching
*  @time 2018年6月29日 上午11:19:24
*  @version 1.0
*/
public class MainApp {
	public static void main(String[] args) {
		String optCase = ""; // 物件代號
		boolean hasFlag = false; // 判斷物件是否存在
		Case selectedCase = new Case();  // 選擇到之物件
		int monthlyPrice = 0; // 每月租金
		int expectedMonths = 0; // 預計租期
		int actualMonths = 0; // 實際租期
		int depositMonths = 0; // 押金期數

//		try {

			Case caseA = new Case("A", 10f, "套房", 12000, "王先生", "台北市文山區木柵路一段xx號");
			Case caseB = new Case("B", 8f, "套房", 8000, "陳先生", "新北市中和區中和路yy號");
			Case caseC = new Case("C", 4f, "雅房", 6000, "林先生", "新北市新店區中正路aa巷zz號");
			Case caseD = new Case("D", 2f, "雅房", 4500, "林先生", "台北市文山區木新路二段ww號");
			Case caseE = new Case("E", 1f, "店面", 80000, "黃先生", "台北市大安區新生南路一段xx號");
			Case[] cases = {caseA, caseB, caseC, caseD, caseE};

			Scanner sc = new Scanner(System.in);

			mainLoop:while(true) {
				try {
					System.out.println("歡迎使用租屋小幫手, 請選擇功能:");
					System.out.println("1. 陳列所有出租房屋");
					System.out.println("2. 房屋出租查詢");
					System.out.println("3. 租金試算");
					System.out.println("4. 離開");

					if(sc.hasNextInt()) {
						int opt = sc.nextInt();

						switch (opt) {
						case 1: //印出所有物件
							for (Case tempCase : cases) {
								tempCase.display();
							}
							break;
						case 2:
							System.out.println("請輸入物件代號:");
							optCase = sc.next().toUpperCase();
							for (Case tempCase : cases) {
								if(tempCase.getId().equals(optCase)) {
									tempCase.display();
									hasFlag = true;
								}
							}
							if(!hasFlag) {
								System.out.println("很抱歉，物件不存在!");
							}
							break;
						case 3: 
							System.out.println("請輸入物件代號:");
							optCase = sc.next();

							for (Case tempCase : cases) {
								if(tempCase.getId().equals(optCase)) {
									selectedCase = tempCase;
									hasFlag = true;
								}
							}
							if(!hasFlag) 
							{
								System.out.println("很抱歉，物件不存在!");
								continue;
							}
							monthlyPrice = selectedCase.getPrice();

							System.out.println("請輸入押金期數(月):");
							depositMonths = sc.nextInt();

							if(depositMonths>0){

								System.out.println("請輸入合約租期(月):");
								expectedMonths = sc.nextInt();

								if(expectedMonths > 0) {

									System.out.println("請輸入實際租期(月):");
									actualMonths = sc.nextInt();

									if(actualMonths >= 0 && actualMonths <= expectedMonths) {

										// 進行租金試算
										int total = actualMonths * monthlyPrice
												+ ((actualMonths< expectedMonths) ? depositMonths * monthlyPrice : 0 );
										float average = total / (float) actualMonths;
										System.out.println("租金總額: " + total + " 元");
										System.out.println("月平均租金: " + average + " 元");

									}else {
										System.out.println("資料無效【實際租期必須介於0到合約租期之間】");
									}
								}else {
									System.out.println("資料無效【合約租期必須大於0】");
								}
							}else {
								System.out.println("資料無效【押金期數必須大於0】");
							}
							break;
						case 4:
							System.out.println(">>>>【程式結束】......>>>>>");
							break mainLoop;				
						default:
							break;
						}
					}else{
						sc.next(); //把sc指標移動，避免無窮迴圈
					}
					System.out.println("-------------------------------------");
				}catch(InputMismatchException imex) {
					System.out.println("資料無效【請輸入數字】");
					continue;				
				}
			} // End of mainLoop
			sc.close(); 
//		}catch(Exception ex) {
//			System.out.println(ex.toString());
//		}
	}	
}
