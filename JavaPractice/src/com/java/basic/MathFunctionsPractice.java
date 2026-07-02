package com.java.basic;

public class MathFunctionsPractice {

	public static void main(String[] args) {
		
		/**===============================================================
		 *                MATHEMATICAL FUNCTIONS / METHODS PRACTICE
		 * ===============================================================
		 * 
		 * 1) Basic math functions (abs, max, min, signum)
		 * 2) Rounding functions (ceil, floor, round, rint)
		 * 3) Exponents & Logarithms functions(pow, sqrt, cbrt, exp, expm1, log, log10, log1p)
		 * 4) Trigonometric functions (sin, cos, tan, asin, acos, atan, atan2)
		 * 5) Hyperbolic functions (sinh, cosh, tanh)
		 * 6) Geometry and Angle functions (toRadians, toDegrees, hypot)
		 * 7) Randomization function (random)
		 * 8) Built-in consonents functions (PI[pi], E[Natural Logarithms])
		 * 9) Exact/Safe Arithmetic functions (addExact, subtractExact, multiplyExact, incrementExact,
		 *                                     decrementExact, negateExact, toIntExact)
		 * 
		 * ===============================================================
		 */
		
		System.out.println("============================");
		System.out.println("MATHEMATICAL FUNCTIONS ");
		System.out.println("============================");
		
		int intNumber1 = 5;
		int intNumber2 = 3;
		int intNegNumber = -732;
		double doubleNumber1 = 6.6;
		double doubleNumber2 = 2.89;
		double doubleNegNumber = -45.5;
		System.out.println();
		System.out.println("1) Basic Math Functions ::: ");
		System.out.println("============================");
		System.out.println("abs    : " + intNegNumber + " = " + Math.abs(intNegNumber));
		System.out.println("abs    : " + doubleNegNumber + " = " + Math.abs(doubleNegNumber));
		System.out.println("max    : " + "(" + intNumber1 + " , " + intNumber2+ ") = " + Math.max(intNumber1, intNumber2));
		System.out.println("max    : " + "(" + doubleNumber1 + " , " + doubleNumber2+ ") = " + Math.max(doubleNumber1, doubleNumber2));
		System.out.println("min    : " + "(" + intNumber1 + " , " + intNumber2+ ") = " + Math.min(intNumber1, intNumber2));
		System.out.println("min    : " + "(" + doubleNumber1 + " , " + doubleNumber2+ ") = " + Math.min(doubleNumber1, doubleNumber2));
		System.out.println("signum : " + intNumber1 + " = " + Math.signum(intNumber1));
		System.out.println("signum : " + doubleNegNumber + " = " + Math.signum(doubleNegNumber));
		
		System.out.println();
		System.out.println("2) Rounding Functions ::: ");
		System.out.println("============================");
		System.out.println("ceil  : " + intNumber1 + " = " + Math.ceil(intNumber1));
		System.out.println("ceil  : " + doubleNumber1 + " = " + Math.ceil(doubleNumber1));
		System.out.println("floor : " + intNumber1 + " = " + Math.floor(intNumber1));
		System.out.println("floor : " + doubleNumber1 + " = " + Math.floor(doubleNumber1));
		System.out.println("floor : " + doubleNegNumber + " = " + Math.ceil(doubleNegNumber));
		System.out.println("round : " + intNumber1 + " = " + Math.round(intNumber1));
		System.out.println("round : " + doubleNumber1 + " = " + Math.round(doubleNumber1));
		System.out.println("rint  : " + doubleNumber1 + " = " + Math.rint(doubleNumber1));
		
		int logIntValue1 = 25;
		int logIntValue2 = 4;
		double logDoubleValue1 = 125.50;
		double logDoubleValue2 = 28.45;
		System.out.println();
		System.out.println("3) Exponents & Logarithms Functions ::: ");
		System.out.println("==========================================");
		System.out.println("pow    : " + "(" + intNumber1 + " , " + intNumber2+ ") = " + Math.pow(intNumber1, intNumber2));
		System.out.println("pow    : " + "(" + doubleNumber1 + " , " + doubleNumber2+ ") = " + Math.pow(doubleNumber1, doubleNumber2));
		System.out.println("sqrt   : " + logIntValue2 + " = " + Math.sqrt(logIntValue2));
		System.out.println("sqrt   : " + logDoubleValue2 + " = " + Math.sqrt(logDoubleValue2));
		System.out.println("cbrt   : " + logIntValue2 + " = " + Math.cbrt(logIntValue2));
		System.out.println("cbrt   : " + logDoubleValue2 + " = " + Math.cbrt(logDoubleValue2));
		System.out.println("exp    : 1" + " = " + Math.exp(1));
		System.out.println("expm1  : 1" + " = " + Math.expm1(1));
		System.out.println("log    : " + logIntValue1 + " = " + Math.log(logIntValue1));
		System.out.println("log10  : " + logIntValue1 + " = " + Math.log10(logIntValue1));
		System.out.println("log1p  : " + logIntValue1 + " = " + Math.log1p(logIntValue1));
		
		int trigIntValue1 = 0;
		int trigIntValue2 = 1;
		int trigIntValue3 = 30;
		System.out.println();
		System.out.println("4) Trigonometric Functions ::: ");
		System.out.println("==========================================");
		System.out.println("sin    : " + trigIntValue1 + " = " + Math.sin(trigIntValue1));
		System.out.println("sin    : " + trigIntValue2 + " = " + Math.sin(trigIntValue2));
		System.out.println("sin    : " + trigIntValue3 + " = " + Math.sin(trigIntValue3));
		System.out.println("cos    : " + trigIntValue1 + " = " + Math.cos(trigIntValue1));
		System.out.println("cos    : " + trigIntValue2 + " = " + Math.cos(trigIntValue2));
		System.out.println("cos    : " + trigIntValue3 + " = " + Math.cos(trigIntValue3));
		System.out.println("tan    : " + trigIntValue1 + " = " + Math.tan(trigIntValue1));
		System.out.println("tan    : " + trigIntValue2 + " = " + Math.tan(trigIntValue2));
		System.out.println("tan    : " + trigIntValue3 + " = " + Math.tan(trigIntValue3));
		System.out.println("asin   : " + trigIntValue1 + " = " + Math.asin(trigIntValue1));
		System.out.println("acos   : " + trigIntValue2 + " = " + Math.acos(trigIntValue1));
		System.out.println("atan   : " + trigIntValue3 + " = " + Math.atan(trigIntValue1));
		System.out.println("atan2  : (1,1)" + " = " + Math.atan2(1,1));  // Converts rectangular coordinates (x, y) to polar coordinate angle θ.
		
		System.out.println();
		System.out.println("5) Hyperbolic Functions ::: ");
		System.out.println("==========================================");
		System.out.println("sinh    : " + trigIntValue1 + " = " + Math.sinh(trigIntValue1));
		System.out.println("cosh    : " + trigIntValue2 + " = " + Math.cosh(trigIntValue2));
		System.out.println("tanh    : " + trigIntValue3 + " = " + Math.tanh(trigIntValue3));
		
		System.out.println();
		System.out.println("6) Geometry and Angle Functions ::: ");
		System.out.println("==========================================");
		System.out.println("toRadians   : 180" + " = " + Math.toRadians(180));
		System.out.println("toDegrees   : PI" + " = " + Math.toDegrees(Math.PI));
		System.out.println("hypot       : (3,4)" + " = " + Math.hypot(3,4));
		
		double randNumber = Math.random();
		int randIntNumber = (int) (randNumber*10);
		System.out.println();
		System.out.println("7) Randamization Functions ::: ");
		System.out.println("==========================================");
		System.out.println("random   : " + " = " + randNumber);
		System.out.println("random   : " + " = " + randIntNumber);
		System.out.println("random   : " + " = " + (randIntNumber+1));
		
		System.out.println();
		System.out.println("8) Built In Functions ::: ");
		System.out.println("==========================================");
		System.out.println("PI   : pi" + " = " + Math.PI);
		System.out.println("PI   : logarithmic" + " = " + Math.E);
		
		int exIntValue1 = 5;
		int exIntValue2 = 2;
		long exIntValue = 463635634;
		int exNegIntValue = -466;
		System.out.println();
		System.out.println("9) Exact/Safe Arithmetic Functions ::: ");
		System.out.println("==========================================");
		System.out.println("addExact       : " + "(" + exIntValue1 + " , " + exIntValue2+ ") = " + Math.addExact(exIntValue1, exIntValue2));
		System.out.println("subtractExact  : " + "(" + exIntValue1 + " , " + exIntValue2+ ") = " + Math.subtractExact(exIntValue1, exIntValue2));
		System.out.println("multiplyExact  : " + "(" + exIntValue1 + " , " + exIntValue2+ ") = " + Math.multiplyExact(exIntValue1, exIntValue2));
		System.out.println("divideExact    : " + "(" + exIntValue1 + " , " + exIntValue2+ ") = " + Math.divideExact(exIntValue1, exIntValue2));
		System.out.println("incrementExact    : " + exIntValue1 + " = " + Math.incrementExact(exIntValue1));
		System.out.println("decrementExact    : " + exIntValue2 + " = " + Math.decrementExact(exIntValue2));
		System.out.println("negateExact    : " + exNegIntValue + " = " + Math.negateExact(exNegIntValue));
		System.out.println("toIntExact    : " + exIntValue + " = " + Math.toIntExact(exIntValue));
		
		
	}

}
