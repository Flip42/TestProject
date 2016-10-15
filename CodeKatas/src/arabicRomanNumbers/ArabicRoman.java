package arabicRomanNumbers;

public class ArabicRoman {

	public String getRoman(int num) {
//		return getRecursive(num);
		if (num < 40)
			return getOneToTen(num);
		if(num < 50)
			return "XL" + getOneToTen(num -40);
		if(num < 90)
			return "L" + getOneToTen(num -50);
		if(num < 100)
			return "XC" + getOneToTen(num -90);
		if(num == 100)
			return "C";
		return "ERROR";
	}

	private String getOneToTen(int num) {
		if (num >= 10)
			return "X" + getOneToTen(num - 10);
		if (num == 1)
			return "I";
		if (num == 2)
			return "II";
		if (num == 3)
			return "III";
		if (num == 4)
			return "IV";
		if (num == 5)
			return "V";
		if (num == 6)
			return "VI";
		if (num == 7)
			return "VII";
		if (num == 8)
			return "VIII";
		if (num == 9)
			return "IX";
		return "";
	}

//	private String getRecursive(int num) {
//		String retval = "";
//		retval += appendChar(num,10,"X");
//		retval += appendChar(num,9,"IX");
//		retval += appendChar(num,5,"V");
//		retval += appendChar(num,4,"IV");
//		return retval += appendChar(num,1,"I");
//	}
//
//	private String appendChar(int num, int value, String sign) {
//		if (num > value)
//			return sign + getRecursive(num - value);
//		return "";
//	}

}
