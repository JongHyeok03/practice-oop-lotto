package view;

import model.LottoRank;
import model.LottoTickets;

import java.text.DecimalFormat;

public class OutputView {
    public void printLottos(LottoTickets hadLottos) {
        System.out.println(hadLottos.size() + "개를 구매하셨습니다!");
        System.out.println(hadLottos);
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }

    public void printResult(int[] result, int purchasedPrice) {
        System.out.println("당첨 통계");
        System.out.println("----------");
        double totalPrice = 0;
        LottoRank[] allRanks = LottoRank.values();

        for (int i = allRanks.length - 1; i >= 0; i--) {    //
            LottoRank rank = allRanks[i];
            if (rank == LottoRank.MISS) {
                continue;
            }
            String matchRank = this.getMatchRank(rank);
            String prize = this.getPrize(rank.getPrize());
            int count = result[rank.ordinal()];
            totalPrice = totalPrice + ((double) count * rank.getPrize());
            System.out.printf("%s (%s) - %d개\n", matchRank, prize, count);
        }
        double totalYield = totalPrice / purchasedPrice;
        double percentageYield = totalYield * 100;

        System.out.println("총 수익률은 " + String.format("%.1f", percentageYield) + "%입니다.");
    }
    private String getMatchRank(LottoRank rank) {
        String base = rank.getMatchCount() + "개 일치";
        if (rank.isMatchBonus()) {
            return base + ", 보너스 볼 일치";
        }
        return base;
    }

    private String getPrize(int prize) {
        DecimalFormat df = new DecimalFormat("###,###");
        return df.format(prize) + "원";
    }
}