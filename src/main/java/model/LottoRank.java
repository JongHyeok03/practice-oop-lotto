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

    // ⭐ 일치 개수와 보너스 일치 여부로 등수를 찾아주는 메서드 (핵심 로직)
    public static LottoRank findRank(int matchCount, boolean matchBonus) {
        // 모든 등수를 순회하며 조건에 맞는 등수를 찾습니다.
        for (LottoRank rank : values()) {
            if (rank.matchCount == matchCount) {
                // 5개 일치일 경우, 보너스 번호 일치 여부로 2등과 3등을 구분합니다.
                if (matchCount == 5) {
                    if (rank.isMatchBonus() == matchBonus) {
                        return rank;
                    }
                    continue; // 5개 일치 조건이지만 보너스 여부가 다르면 다음 등수로 넘어갑니다.
                }
                return rank; // 5개 외의 다른 등수는 바로 반환합니다.
            }
        }
        return MISS; // 일치하는 등수가 없으면 낙첨(MISS)을 반환합니다.
    }
}