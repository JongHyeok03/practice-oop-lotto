package view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;


public class InputView {

    public int readPurchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");
        String purchaseAmount = Console.readLine();
        return Integer.parseInt(purchaseAmount);
    }
    public List<Integer> readWinningNumberInput() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNum = Console.readLine();
        String[] winningNums =  winningNum.split(",");
        List<Integer> winningNumList = new ArrayList<>();
        for (String num : winningNums) winningNumList.add(Integer.parseInt(num));
        return winningNumList;
    }
    public int readBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }
}
