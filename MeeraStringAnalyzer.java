import java.util.*;
public class MeeraStringAnalyzer {
    private static int dp(String s, List<String> substrings, Map<String, Integer> memo) {
        if (memo.containsKey(s)) {
            return memo.get(s);
        }
        int maxRemovals = 0;
        for (String sub : substrings) {
            int pos = s.indexOf(sub);
            if (pos != -1) {
                String newString = s.substring(0, pos) + s.substring(pos + sub.length());    
                maxRemovals = Math.max(maxRemovals, 1 + dp(newString, substrings, memo));
            }
        }
        memo.put(s, maxRemovals);
        return maxRemovals;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine(); 
        List<String> substrings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            substrings.add(sc.next());
        }
        String mainString = sc.next();
        Map<String, Integer> memo = new HashMap<>();
        System.out.println(dp(mainString, substrings, memo));
    }
}
