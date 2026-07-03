package com.java.basic;

public class StringBufferBuilderExample {

	public static void main(String[] args) {

		/**===============================================================
		 *             STRING BUFFER AND STRING BUILDER EXAMPLE 
		 * ===============================================================
		 * 
		 * Sample program demonstrated how to declare and use String Buffer 
		 * and String Builder in the programmes.
		 * 
		 * ===============================================================
		 */
		
		// 1) Initialization of StringBuffer Object
		StringBuffer name = new StringBuffer("Sam");
		StringBuilder name1 = new StringBuilder("Tommy");
		System.out.println("====================================== ");
		System.out.println(" 1) INITIALIZATION OF STRINGBUFFER  ");
		System.out.println(" ------------------------------------- ");
		System.out.println(" Original = " + name);
		System.out.println(" Original = " + name1);
		
		// 2) append()
		System.out.println();
		System.out.println(" 2) APPEND()  ");
		System.out.println(" ------------- ");
		System.out.println(" Append = " + name.append(" good person"));
		System.out.println(" Append = " + name1.append(" is nice person"));
		
		// 2) insert()
		System.out.println();
		System.out.println(" 2) INSERT()  ");
		System.out.println(" ------------- ");
		System.out.println(" Insert = " + name.insert(4," is a"));
		System.out.println(" Insert = " + name1.insert(5," is a"));
		
		System.out.println();
		System.out.println();
		
		// StringBuilder (Not Thread Safe, Faster)
		long startTime = System.currentTimeMillis();
		StringBuilder builder = new StringBuilder();
		for(int i=0; i<=50000000; i++) {
			builder.append(" a");
		}
		long endTime = System.currentTimeMillis();
		long builderTime = endTime - startTime;
		System.out.println("StringBuilder time taken : " + builderTime + " ms");
		
		// StringBuffer (Thread Safe, Slower)
		startTime = System.currentTimeMillis();
		StringBuffer buffer = new StringBuffer();
		for(int i=0; i<=50000000; i++) {
			buffer.append(" a");
		}
		endTime = System.currentTimeMillis();
		long bufferTime = endTime - startTime;
		System.out.println("StringBuffer time taken  : " + bufferTime + " ms");
		
		
		
		
	}

}
