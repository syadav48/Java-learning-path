    package leetcode.leet75.arrstr;

    import java.util.Arrays;

    public class ProductExceptItself {
        public int multiply(int[] nums, int index){
            int res = 1;
            for (int i = 0; i < nums.length; i++) {
                if(i != index){
                   res = res*nums[i];
                }
            }
            return res;
        }
        public int[] productExceptSelf(int[] nums) {
            int[] res = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                res[i] = multiply(nums, i);
            }
            return res;
        };
//        result[i] = (product of all elements left of i)
//          × (product of all elements right of i)
        public int[] productExceptSelfOpt(int[] nums) {
            int n = nums.length;
            int[] res = new int[n];
            res[0] = 1;
            for (int i = 1; i < n; i++) {
                res[i] = res[i - 1] * nums[i - 1];
            }
            System.out.println(Arrays.toString(res) + "leftofi");
            int right = 1;
            for (int i = n - 1; i >= 0; i--) {
                res[i] = res[i] * right;
                right *= nums[i];
                System.out.println(right + "res:" + Arrays.toString(res) + "right");
            }
            return res;
        };
        public static void main(String[] args) {
            ProductExceptItself exceptItself = new ProductExceptItself();
            int[] nums = {1,2,3,4};
            System.out.println(Arrays.toString(exceptItself.productExceptSelfOpt(nums)));
        }
    }
