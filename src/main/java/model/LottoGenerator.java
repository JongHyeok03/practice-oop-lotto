package model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoGenerator {
    public LottoGenerator() {
    }
    public Lotto makeLotto(int purchasedAmount){
        List<Integer> numbers = null;
        for (int i = 0; i < purchasedAmount; i++){
            numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        }
        return new Lotto(numbers);
    }

}
