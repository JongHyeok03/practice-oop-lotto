package model;

public enum LottoRank {
    FIRST(6, 2_000_000_000, false),    // 6개 일치
    SECOND(5, 30_000_000, true),       // 5개 일치 + 보너스
    THIRD(5, 1_500_000, false),        // 5개 일치
    FOURTH(4, 50_000, false),          // 4개 일치
    FIFTH(3, 5_000, false),            // 3개 일치
    MISS(0, 0, false);                 // 낙첨 (0개 일치)

    private final int matchCount;
    private final int prize;
    private final boolean matchBonus;

    LottoRank(int matchCount, int prize, boolean matchBonus) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.matchBonus = matchBonus;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public boolean isMatchBonus() {
        return matchBonus;
    }

    public static LottoRank findRank(int matchCount, boolean matchBonus) {
        for (LottoRank rank : values()) {
            if (rank.matchCount == matchCount) {
                // 5개 일치일 경우, 보너스 번호 일치 여부로 2등과 3등을 구분합니다.
                if (matchCount == 5) {
                    if (rank.isMatchBonus() == matchBonus) {
                        return rank;
                    }
                    continue;
                }
                return rank;
            }
        }
        return MISS;
    }
}