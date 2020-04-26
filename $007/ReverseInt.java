package $007;

/**
 * @ClassName: $007.ReverseInt
 * @Description:
 * @Author: suxun
 * @Date: 2018/7/26 10:35
 * @Version: 1.0
 **/
public class ReverseInt {
	public static void main(String[] args) {
		System.out.println(reverse(1563847412));
	}

	public static int reverse(int x) {
		if (x >= -9 && x <= 9) {
			return x;
		}
		if (x == Integer.MIN_VALUE) {
			return 0;
		}
		boolean isNegativeNum = x < 0;
		x = Math.abs(x);
		int size = 1;
		int t = x;
		while ((t /= 10) >= 1) {
			++size;
		}
		int[] arr = new int[size];
		int index = 0;
		int temp;
		while (x >= 1) {
			temp = x % 10;
			arr[index++] = temp;
			x /= 10;
		}
		double v = 0;
		if (size > 10) {
			return 0;
		}
		for (int i = 0; i < arr.length; i++) {
			v += arr[i] * Math.pow(10, arr.length - 1 - i);
		}
		int result = 0;
		result += v;
		if (result != v) {
			return 0;
		}
		if (isNegativeNum) {
			result = -result;
		}
		return result;
	}
}
