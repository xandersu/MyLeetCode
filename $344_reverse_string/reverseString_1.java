package $344_reverse_string;

/**
 * @author suxun
 * @date 2020/8/2 15:52
 * @description
 */
class reverseString_1 {
    public void reverseString(char[] s) {
        int l = 0;
        int r = s.length-1;
        while(l<r){
            char temp = s[l];
            s[l]=s[r];
            s[r]=temp;
            l++;
            r--;
        }
    }
}