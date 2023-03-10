public class Formatter {
    public static String formatDoubleToString(double inputNumber) {

        int roundedNumber = (int) Math.floor(inputNumber);
        int preLastDigit = roundedNumber % 100 / 10;
        int lastDigit = roundedNumber % 10;

        String rublesValue;

        if (preLastDigit == 1) {
            rublesValue = "рублей";
        } else {
            if (lastDigit == 1) {
                rublesValue = "рубль";
            } else if (lastDigit >= 2 && lastDigit <= 4) {
                rublesValue = "рубля";
            } else {
                rublesValue = "рублей";
            }
        }

        return String.format("%.2f", inputNumber) + " " + rublesValue;
    }
}
