package index;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: gws
 * @Date: 02/08/2018 00:06
 * @Description:
 */
public class _22 {
    public static class Solution1 {
        public List<String> generateParenthesis(int n) {
            List<String> result = new ArrayList();
            backtrack(result, "", 0, 0, n);
            return result;
        }

        void backtrack(List<String> result, String str, int left, int right, int max) {
            if (str.length() == max * 2) {
                result.add(str);
                return;
            }

            if (left < max) {
                backtrack(result, str + "(", left + 1, right, max);
            }

            if (right < left) {
                backtrack(result, str + ")", left, right + 1, max);
            }
        }
    }

    public static class Solution2 {
        public List<String> generateParenthesis(int n) {
            List<String> result = new ArrayList();
            if (n == 0) {
                return result;
            }
            helper(result, "", n, n);
            return result;
        }

        void helper(List<String> result, String par, int left, int right) {
            if (left > 0) {
                helper(result, par + "(", left - 1, right);
            }
            if (right > left) {
                helper(result, par + ")", left, right - 1);
            }
            if (right == 0) {
                result.add(par);
            }
        }
    }
}
