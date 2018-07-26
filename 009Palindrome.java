/**
 * @ClassName: Palindrome
 * @Description:
 * @Author: suxun
 * @Date: 2018/7/26 9:52
 * @Version: 1.0
 **/
public class Palindrome {

	public static void main(String[] args) {

		System.out.println("result=" + isPalindrome(1004444001));
	}

	public static boolean isPalindrome(int x) {
		int size = 1;
		int t = x;
		while ((t /= 10) >= 1) {
			++size;
		}
		if (x < 0) {
			return false;
		} else if (x >= 0 && x <= 9) {
			return true;
		}
		int[] arr = new int[size];
		int index = 0;
		int temp ;
		while (x >= 1) {
			temp = x % 10;
			arr[index++] = temp;
			x /= 10;
		}

		if (arr.length == 0) {
			return false;
		}
		int length = 0;
		if (size % 2 == 0) {
			length = size / 2;
			for (int i = 0; i < length; i++) {
				int intFront = arr[i];
				int intBack = arr[size - 1 - i];
				if (intFront != intBack) {
					return false;
				}
			}
			return true;
		} else {
			length = size / 2 + 1;
			for (int i = 0; i < length; i++) {
				int intFront = arr[i];
				int intBack = arr[size - 1 - i];
				if (intFront != intBack) {
					return false;
				}
			}
			return true;
		}
	}
}
