package model;

public class LottoService {
    private final LottoGenerator lottoGenerator = new LottoGenerator();

    public LottoTickets purchaseLottos(int purchasedPrice) {
        LottoTickets purchasedTickets = new LottoTickets();
        int lottoCount = purchasedPrice / 1000;

        for(int i = 0; i < lottoCount; i++){
            Lotto lotto = lottoGenerator.makeLotto(lottoCount);
            lotto.sortNumbers();
            purchasedTickets.add(lotto);
        }

        return purchasedTickets;
    }
}
