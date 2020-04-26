package $013;

/**
 * @author: suxun
 * @date: 2020/4/26 11:19
 * @description: 罗马数字转整数
 * 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 */
public class RomanToInt200426 {

    public int romanToInt(String s) {
        int result = 0;
        if (s == null || s.length() == 0) {
            return result;
        }

        byte[] bytes = s.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            byte b = bytes[i];
            if (b == 'I') {
                if (i + 1 < bytes.length) {
                    byte c = bytes[i + 1];
                    if (c == 'V') {
                        result += 4;
                        i++;
                    } else if (c == 'X') {
                        result += 9;
                        i++;
                    }
                }
            } else if (b == 'X') {
                if (i + 1 < bytes.length) {
                    byte c = bytes[i + 1];
                    if (c == 'L') {
                        result += 40;
                        i++;
                    } else if (c == 'C') {
                        result += 90;
                        i++;
                    }
                }
            } else if (b == 'C') {
                if (i + 1 < bytes.length) {
                    byte c = bytes[i + 1];
                    if (c == 'D') {
                        result += 400;
                        i++;
                    } else if (c == 'M') {
                        result += 900;
                        i++;
                    }
                }
            } else {
                result += getIntByByte(b);
            }
        }

        return result;
    }

    public static int getIntByByte(byte c) {
        int res = 0;
        switch (c) {
            case 'I':
                res = 1;
                break;
            case 'V':
                res = 5;
                break;
            case 'X':
                res = 10;
                break;
            case 'L':
                res = 50;
                break;
            case 'C':
                res = 100;
                break;
            case 'D':
                res = 500;
                break;
            case 'M':
                res = 1000;
                break;
            default:
                break;
        }
        return res;
    }

    public static void main(String[] args) {
        RomanToInt200426 romanToInt0426 = new RomanToInt200426();
        int res = romanToInt0426.romanToInt("MCMXCIV");
        System.out.println(res);
    }
}
