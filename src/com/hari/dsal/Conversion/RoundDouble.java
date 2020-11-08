package com.hari.dsal.Conversion;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class RoundDouble {
	private static DecimalFormat df = new DecimalFormat("0.00");

    public static void main(String[] args) {
    	// Way 1
        double input = 1205.6358;

        System.out.println("salary : " + input);

        // DecimalFormat, default is RoundingMode.HALF_EVEN
        System.out.println("salary : " + df.format(input));      //1205.64

        df.setRoundingMode(RoundingMode.DOWN);
        System.out.println("salary : " + df.format(input));      //1205.63

        df.setRoundingMode(RoundingMode.UP);
        System.out.println("salary : " + df.format(input));      //1205.64
        
        
        // Way 2
        System.out.println("double : " + input);

        BigDecimal bd = new BigDecimal(input).setScale(2, RoundingMode.HALF_UP);
        double salary = bd.doubleValue();

        System.out.println("salary : " + salary);
        
        //way 3
        System.out.println("salary : " + input);

        double salary1 = Math.round(input * 100.0) / 100.0;

        System.out.println("salary : " + salary1);
    }
}
