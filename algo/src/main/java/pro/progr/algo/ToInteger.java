package pro.progr.algo;

public class ToInteger {

    public String hexToDecimal(String hex) {
        var decimalVal = 0;

        for (int i = 0; i < hex.length(); i++) {
            var ch = hex.charAt(i);
            var digit = Character.digit(ch, 16);

            decimalVal = decimalVal * 16 + digit;
        }

        return String.valueOf(decimalVal);
    }

    public String decimalToBinary(int decimal) {
        StringBuilder stringBuilder = new StringBuilder();

        while (decimal > 0) {
            stringBuilder.append(decimal % 2);
            decimal /= 2;
        }

        return stringBuilder.reverse().toString();
    }

    public int[] getNearest(int[] sortedArr, int sourceIndex, int elemCount) {
        if (elemCount == 0) {
            return new int[0];
        }

        var elems = new int[elemCount];
        elems[0] = sortedArr[sourceIndex];

        var left = sourceIndex - 1;
        var right = sourceIndex + 1;

        //начинаю не с нуля, потому что первым элементом массива добавила число на sourceIndex
        for (int i = 1; i < elemCount; i++) {
            //по условию длина массива всегда такая, что в нём можно найт k элеметов
            //поэтому случай, когда left и right не в пределах массива, я не рассматриваю
            if (left < 0) {
                elems[i] = sortedArr[right];
                right++;
            } else if (right >= sortedArr.length) {
                elems[i] = sortedArr[left];
                left--;
            } else if (sortedArr[sourceIndex] - sortedArr[left] < sortedArr[right] - sortedArr[sourceIndex]) {
                elems[i] = sortedArr[left];
                left--;
            } else {
                elems[i] = sortedArr[right];
                right++;
            }
        }

        return elems;
    }
}
