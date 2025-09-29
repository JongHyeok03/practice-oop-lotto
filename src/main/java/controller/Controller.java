package controller;

import lotto.Validator;
import model.Lotto;
import model.LottoResultChecker;
import model.LottoService;
import model.LottoTickets;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService = new LottoService();
    private final Validator validator = new Validator();

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;

    }
    public void run(){
        int purchasedPrice = readAndValidatePurchasePrice();
        LottoTickets hadLottos = lottoService.purchaseLottos(purchasedPrice);
        outputView.printLottos(hadLottos);
        List<Integer> winningNum = readAndValidateWinningNumbers();
        Lotto winningLotto = new Lotto(winningNum);
        winningLotto.sortNumbers();
        int bonusNum = readAndValidateBonusNumber(winningLotto);
        int[] result = LottoResultChecker.checkResult(hadLottos, winningLotto, bonusNum);
        outputView.printResult(result,purchasedPrice);
    }

    private int readAndValidateBonusNumber(Lotto winningLotto) {
        while (true) {
            try {
                int bonusNum = inputView.readBonusNumber();
                validator.validateBonusNumber(winningLotto, bonusNum);
                return bonusNum;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }


    private int readAndValidatePurchasePrice() {
        while (true) {
            try {
                int purchasedPrice = inputView.readPurchasePrice();
                validator.validatePurchasedAmount(purchasedPrice);
                return purchasedPrice;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private List<Integer> readAndValidateWinningNumbers() {
        while (true)
            try {
                List<Integer> winningNumbers = inputView.readWinningNumberInput();
                validator.validateWinningNumber(winningNumbers);
                return winningNumbers;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
}
