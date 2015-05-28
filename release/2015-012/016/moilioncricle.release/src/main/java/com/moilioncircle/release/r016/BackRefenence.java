package com.moilioncircle.release.r016;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BackRefenence {
	public static void main(String[] args) {

		// 命名组
		String date = "2015.05.28";
		String regex = "(?<year>\\d{4})\\D(?<month>\\d{2})\\D(?<date>\\d{2})";

		// 反向引用 api
		Pattern ptn = Pattern.compile(regex);
		Matcher mth = ptn.matcher(date);
		mth.find();
		System.out.println("01.year=" + mth.group("year") + ":" + mth.group(1));
		System.out.println("02.month=" + mth.group("month") + ":" + mth.group(2));
		System.out.println("03.date=" + mth.group("date") + ":" + mth.group(3));

		// 反向引用 replace
		String r1 = date.replaceAll(regex, "${year}-${month}-${date}");
		System.out.println("04.${}=" + r1);
		String r2 = date.replaceAll(regex, "$1/$2/$3");
		System.out.println("05.\\#=" + r2);

		// 超过10个怎么办？
		String s13 = "1234567890JQK";
		String r13 = "(.)(.)(.)(.)(.)(.)(.)(.)(.)(.)(.)(.)(.)";
		Pattern p13 = Pattern.compile(r13);
		Matcher m13 = p13.matcher(s13);
		m13.find();
		System.out.println("06.  13=" + m13.group(13));
		System.out.println("07.1+13=" + s13.replaceAll(r13, "$1$13"));

		// `\1`和`$1`的区别
		String s3 = "one cat two cats in the yard";
		String r3 = "(cat)";

		// Matcher replace
		Pattern p = Pattern.compile(r3);
		Matcher m = p.matcher(s3);
		StringBuffer sb = new StringBuffer();
		while (m.find()) {
			m.appendReplacement(sb, "lovely $1");
		}
		m.appendTail(sb);
		System.out.println("08.matcher="+sb.toString());

		// 两个`c.t`，这里匹配两个 `cat`
		String r4 = "(c.t).*\\1";
		System.out.println("09."+s3.replaceAll(r4, "hundred dog"));

		String r5 = "(?<cat>c.t).*\\k<cat>";
		System.out.println("10."+s3.replaceAll(r5, "hundred bird"));
	}
}
