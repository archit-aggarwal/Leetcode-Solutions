class Solution {
    public List<String> simplifiedFractions(int n) {
        List<String> ans = new ArrayList<>();
        for (int denominator = 2; denominator <= n; ++denominator) {
            for (int numerator = 1; numerator < denominator; ++numerator) {
                if (gcd(numerator, denominator) == 1) {
                    ans.add(numerator + "/" + denominator);
                }
            }
        }
        return ans;
    }
    private int gcd(int x, int y) {
        return x == 0 ? y : gcd(y % x, x);
    }
}