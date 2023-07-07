package Test;

public class LeeCode {

    public static void main(String[] args) {
        double medianSortedArrays = LeeCode.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4});
        System.out.println(medianSortedArrays);
    }
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
                } else {
                    if (i == nums1.length) {
                        k++;
                        cuur = nums2[j];
                        j++;
                    } else {
                        k++;
                        cuur = nums1[i];
                        i++;
                    }
                }
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
}
