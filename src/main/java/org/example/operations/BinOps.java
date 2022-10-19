package org.example.operations;

public class BinOps implements Operations {

    /**
     * Сложение бинарных чисел
     *
     * @param a бинарное число в строковом выражении
     * @param b бинарное число в строковом выражении
     * @return Сумма a и b в бинарной строке.
     * <p> Для удобства кол-во разрядов кратно 4-м
     * <p> недостающие разряды заполнены 0.
     */
    @Override
    public String sum(String a, String b) {
        checkArgs(a, b);
        int intA = Integer.parseInt(a, 2);
        int intB = Integer.parseInt(b, 2);
        String sum = Integer.toBinaryString(intA + intB);
        return sum.length() % 4 == 0 ? sum : "0".repeat(4 - sum.length() % 4) + sum;
    }

    /**
     * Умножение бинарных чисел
     *
     * @param a бинарное число в строковом выражении
     * @param b бинарное число в строковом выражении
     * @return Произведение a и b в бинарной строке.
     * <p> Для удобства кол-во разрядов кратно 4-м,
     * <p> недостающие разряды заполнены 0.
     */
    @Override
    public String mult(String a, String b) {
        checkArgs(a, b);
        int intA = Integer.parseInt(a, 2);
        int intB = Integer.parseInt(b, 2);
        String sum = Integer.toBinaryString(intA * intB);
        return sum.length() % 4 == 0 ? sum : "0".repeat(4 - sum.length() % 4) + sum;
    }

    /**
     * Проверка параметров на валидность.
     *
     * @param a бинарное число в строковом выражении
     * @param b бинарное число в строковом выражении
     * @exception IllegalArgumentException если параметры не валидны.
     */
    protected void checkArgs(String a, String b) {
        if (a == null || a.isEmpty() || a.replaceAll("[01]", "").length() != 0) {
            throw new IllegalArgumentException("Аргумент a не бинарное число: a = '" + a + "'");
        } else if (b == null || b.isEmpty() || b.replaceAll("[01]", "").length() != 0) {
            throw new IllegalArgumentException("Аргумент b не бинарное число: b = '" + b + "'");
        }
    }

    @Override
    public String sub(String a, String b) {
        return null;
    }
}
