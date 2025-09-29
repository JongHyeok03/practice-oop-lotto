package model;

import java.util.List;

public class LottoResultChecker {

    public static int[] checkResult(LottoTickets hadLottos, Lotto winningLotto, int bonusNum) {
        int[] resultCounts = new int[LottoRank.values().length];

        List<Lotto> purchasedLottos = hadLottos.getLottos();

        for (Lotto purchasedLotto : purchasedLottos) {
            int matchCount = purchasedLotto.countMatchingNumbers(winningLotto.getNumbers());
            boolean isBonusMatch = purchasedLotto.countMatchingNumbers(bonusNum);

            LottoRank rank = LottoRank.findRank(matchCount, isBonusMatch);

            if (rank != LottoRank.MISS) {
                int rankIndex = rank.ordinal();
                resultCounts[rankIndex]++;
            }
        }
        return resultCounts;
    }
    }

