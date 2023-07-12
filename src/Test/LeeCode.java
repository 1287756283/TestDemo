package Test;

public class LeeCode {

    public static void main(String[] args) {
        double medianSortedArrays = LeeCode.findMedianSortedArrays(new int[]{1, 2}, new int[]{5, 6});
        System.out.println(medianSortedArrays);
    }

    //求两个数组的中位数
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //初始化变量
        int a = 0, b = 0;
        int n;
        //两个数组的平均长度
        n = (nums1.length + nums2.length) / 2;
        //中间是一个数据还是两个数
        int f = 0;
        //数组长度为偶数还是奇数
        if ((nums1.length + nums2.length) % 2 == 0) {
            f = 1;
        } else {
            f = 2;
        }
        int i = 0, j = 0, k = 0;
        int cuur;
        //如果nums1的长度不为0 或者 nums2的长度不为0
        while (i != nums1.length || j != nums2.length) {
            //如果nums1和nums2的长度都大于0
            if (i < nums1.length && j < nums2.length) {
                if (nums1[i] <= nums2[j]) {
                    k++;
                    cuur = nums1[i];
                    i++;
                } else {
                    k++;
                    cuur = nums2[j];
                    j++;
                }
                //如果nums1,nums2有一个长度为0
            } else {
                //如果nums1的长度为0
                if (i == nums1.length) {
                    k++;
                    cuur = nums2[j];
                    j++;
                    //如果nums2的长度为0
                } else {
                    k++;
                    cuur = nums1[i];
                    i++;
                }
            }
            //偶数，需要取两数的平均值
            if (f == 1) {
                if (k == n) {
                    a = cuur;
                } else if (k == (n + 1)) {
                    b = cuur;
                    break;
                }
            } else {
                if (k == (n + 1)) {
                    a = cuur;
                    break;
                }
            }
        }
        if (f == 1) {
            return (double) (a + b) / 2;
        } else {
            return (double) a;
        }

    }


    public String longestPalindrome(String s) {
//maxlen 记录最长回文串长度
        int maxlen = 0;

        //记录最长回文串起始位置，方便后面用substring方法
        int start = 0;
        int len = s.length();

        //当长度等于一时，默认是一个回文串
        if (len == 1) return s;

        //dp[i][j]数组的含义是区间i-j之间的字符串是否属于回文串
        boolean[][] dp = new boolean[len][len];

        for (int j = 0; j < len; j++) {
            for (int i = 0; i <= j; i++) {
                //只有当字符串两端的字符相等时，才可能会是回文
                if (s.charAt(i) == s.charAt(j)) {
                    //这时候字符串首尾两端的字符已经相等了 例如“aba”，此时必然是一个回文，这时候j-i=2；
                    if (j - i < 3) {
                        dp[i][j] = true;
                        //更新最长回文子串的长度
                        if (j - i > maxlen) {
                            start = i;
                            maxlen = j - i;
                        }

                    }
                    //如果这时候子串长度大于2，就得让i + 1，j - 1，继续看dp[i+1][j-1]，如果不理解回头看看dp数组含义
                    else {
                        dp[i][j] = dp[i + 1][j - 1];
                        if (dp[i][j] == true) {
                            if (j - i > maxlen) {
                                maxlen = j - i;
                                start = i;
                            }
                        }
                    }
                }
                //如果首位两端的字符不相等，则不可能是回文子串
                else {
                    dp[i][j] = false;
                }
            }
        }
        //System.out.println(maxlen);调试所用
        return s.substring(start, start + maxlen + 1);
    }

}
