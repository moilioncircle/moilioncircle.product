package com.moilioncircle.release.r016;

public class ReplaceMetachar {
	public static void main(String[] args) {
		// 小心点（`.`）
		// 2015.05.21 => 2015-05-21
		String date = "2015.05.21";

		// 替换
		String rp = date.replaceAll(".", "-");
		System.out.println("01.replace=" + rp);
		// 分组
		String[] sp = date.split(".");
		System.out.println("02.   spit=('" + String.join("','", sp) + "')");
		
		String[] sp2 = "c:\\window".split("\\\\");
		System.out.println("03. window=('" + String.join("','", sp2) + "')");

		// 小心钱(`$`)
		// %(price)/%(unit) => $100/kg
		String price = "%(price)/%(unit)";
		String valueUS = price
				.replaceAll("%\\(price\\)", "\\$100")
				.replaceAll("%\\(unit\\)", "kg");
		System.out.println("04.$name=" + valueUS);
	}
}
