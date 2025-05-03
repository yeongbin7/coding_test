import java.util.*;

public class EmoticonDiscountEvent {
    static class JoinedUserAndSaledAmount {
        int joinedUser;
        int saledAmount;

        public JoinedUserAndSaledAmount(int joinedUser, int saledAmount) {
            this.joinedUser = joinedUser;
            this.saledAmount = saledAmount;
        }
    }

    public int[] solution(int[][] users, int[] emoticons) {
        int[] discountRatios = {10, 20, 30, 40};
        List<JoinedUserAndSaledAmount> list = new ArrayList<>();

        int[] emoticonRatio = new int[emoticons.length];

        dfs(0, discountRatios, emoticonRatio, emoticons, users, list);

        list.sort((o1, o2) -> {
            if (o1.joinedUser == o2. joinedUser) {
                return Integer.compare(o2.saledAmount, o1.saledAmount);
            }
            return Integer.compare(o2.joinedUser, o1.joinedUser);
        });

        int[] answer = {list.get(0).joinedUser, list.get(0).saledAmount};
        return answer;
    }

    private void dfs(int depth, int[] discountRatios, int[] emoticonRatio, int[] emoticons, int[][] users, List<JoinedUserAndSaledAmount> list) {
        if (depth == emoticons.length) {
            int joinedUser = 0;
            int saledAmount = 0;
            for (int[] user : users) {
                int userRatio = user[0];
                int money = user[1];
                int buiedAmount = 0;

                for (int i = 0; i < emoticonRatio.length; i++) {
                    if (userRatio <= emoticonRatio[i]) {
                        buiedAmount += emoticons[i] * (100 - emoticonRatio[i]) / 100;
                    }
                }

                if (buiedAmount >= money) {
                    joinedUser++;
                } else {
                    saledAmount += buiedAmount;
                }

            }
            list.add(new JoinedUserAndSaledAmount(joinedUser, saledAmount));
            return;
        }

        for (int ratio : discountRatios) {
            emoticonRatio[depth] = ratio;
            dfs(depth + 1, discountRatios, emoticonRatio, emoticons, users, list);
        }
    }
}