package model;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
    // TODO: 추가 기능 구현

    public void sortNumbers() {
        this.numbers = mergeSort(this.numbers);
    }
    private List<Integer> mergeSort(List<Integer> list) {
        if (list.size() <= 1) {
            return list;
        }

        int mid = list.size() / 2;
        List<Integer> left = new ArrayList<>(list.subList(0, mid));
        List<Integer> right = new ArrayList<>(list.subList(mid, list.size()));

        List<Integer> sortedLeft = mergeSort(left);
        List<Integer> sortedRight = mergeSort(right);

        return merge(sortedLeft, sortedRight);
    }

    private List<Integer> merge(List<Integer> left, List<Integer> right) {
        List<Integer> mergedList = new ArrayList<>();
        int leftIndex = 0;
        int rightIndex = 0;

        while (leftIndex < left.size() && rightIndex < right.size()) {
            if (left.get(leftIndex) < right.get(rightIndex)) {
                mergedList.add(left.get(leftIndex));
                leftIndex++;
                continue;
            }
            if (left.get(leftIndex) >= right.get(rightIndex)) {
                mergedList.add(right.get(rightIndex));
                rightIndex++;
            }
        }
        mergedList.addAll(left.subList(leftIndex, left.size()));
        mergedList.addAll(right.subList(rightIndex, right.size()));
        return mergedList;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int countMatchingNumbers(List<Integer> winningLotto) {
        List<Integer> myNumbers = this.numbers; // 내 로또 번호

        int matchCount = 0;
        int pointerIndex = 0;
        int winningIndex = 0;

        while (pointerIndex < 6 && winningIndex < 6) {
            int myNum = myNumbers.get(pointerIndex);
            int winningNum = winningLotto.get(winningIndex);

            if (myNum == winningNum) {
                // 1. 번호가 같으면 일치 개수 증가시키고 두 포인터 모두 이동
                matchCount++;
                pointerIndex++;
                winningIndex++;
            } else if (myNum < winningNum) {
                // 2. 내 번호가 작으면 내 포인터만 이동
                pointerIndex++;
            } else { // myNum > winningNum
                // 3. 당첨 번호가 작으면 당첨 포인터만 이동
                winningIndex++;
            }
        }
        return matchCount;
    }
    public boolean countMatchingNumbers(int bonusNum) {
        return this.numbers.contains(bonusNum);
    }
    @Override
    public String toString() {
        return numbers.toString();
    }


}
