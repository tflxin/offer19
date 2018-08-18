package com.offer66;

public class Power {
    public double Power(double base, int exponent) {

        if (base == 0 && exponent == 0) {
            return 0;
        }
        double power = 1.00;
        while (base != 0) {

            if (exponent > 0) {
                for (int i = 1; i <= exponent; i++) {
                    power *= base;
                }
                if (power > 1.7976931348623157E308) {
                    System.out.println("已经超出double类型的取值范围。");
                    return -1;
                }
            } else if (exponent < 0) {
                exponent = -exponent;
                for (int i = 1; i <= exponent; i++) {
                    power *= base;
                }
                if (power > 1.7976931348623157E308) {
                    System.out.println("已经超出double类型的取值范围。");
                    return -1;
                }
                power = 1.0 / power;
                return power;
            } else {
                return power;
            }

        }
        return power;
    }
}