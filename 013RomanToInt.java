/**
 * @ClassName: RomanToInt
 * @Description:
 * @Author: suxun
 * @Date: 2018/7/26 13:44
 * @Version: 1.0
 **/
public class RomanToInt {
	public static void main(String[] args) {
		System.out.println(romanToInt("MCMXCIV"));
	}

	public static int romanToInt(String s) {
		int result = 0;
		byte[] bytes = s.getBytes();
		for (int i = 0; i < bytes.length; i++) {
			byte b1 = bytes[i];
			byte b2 = 0;
			if (i < bytes.length-1) {
				b2 = bytes[i + 1];
			}
			if (b1 == 'I' && b2 == 'V') {
				result += 4;
				i++;
			} else if (b1 == 'I' && b2 == 'X') {
				result += 9;
				i++;
			} else if (b1 == 'X' && b2 == 'L') {
				result += 40;
				i++;
			} else if (b1 == 'X' && b2 == 'C') {
				result += 90;
				i++;
			} else if (b1 == 'C' && b2 == 'D') {
				result += 400;
				i++;
			} else if (b1 == 'C' && b2 == 'M') {
				result += 900;
				i++;
			} else {
				result += getIntByByte(b1);
			}
		}
		return result;
	}

	public static int getIntByByte(byte b) {
		switch (b) {
			case 'I':
				return 1;
			case 'V':
				return 5;
			case 'X':
				return 10;
			case 'L':
				return 50;
			case 'C':
				return 100;
			case 'D':
				return 500;
			case 'M':
				return 1000;
		}
		return 0;
	}
}
