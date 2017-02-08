public class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] secretArr = new int[secret.length()];
        int[] guessArr = new int[guess.length()];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < secret.length(); i++) {
            int sVal = Character.getNumericValue(secret.charAt(i));
            int gVal = Character.getNumericValue(guess.charAt(i));
            if (sVal == gVal) {
                bulls++;
                secretArr[i] = guessArr[i] = -1;
            } else {
                secretArr[i] = sVal;
                guessArr[i] = gVal;
                if(map.containsKey(sVal)) map.put(sVal, map.get(sVal) + 1);
                else map.put(sVal, 1);
            }
        }

        for (int g : guessArr) {
            if (g != -1 && map.containsKey(g) && map.get(g) > 0) {
                cows++;
                map.put(g, map.get(g) - 1);
            }
        }
        return bulls + "A" + cows + "B";
    }
}