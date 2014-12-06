package com.moilioncircle.r005;

// http://developers.slashdot.org/comments.pl?sid=33602&cid=3636102
public class HelloWorld {
	public static void main(String[] args) {
		// the simple way
		System.out.println("Hello, world!");

		// the pattern way
		MessageBody mb = new MessageBody();
		mb.configure("Hello World!");
		
		AbstractStrategyFactory asf = DefaultFactory.getInstance(); // factory & singleton
		MessageStrategy strategy = asf.createStrategy(mb); //strategy
		mb.send(strategy);

		
	}
}