package com.moilioncircle.r005;

public class DefaultFactory extends AbstractStrategyFactory {
	private DefaultFactory() {
	}

	static DefaultFactory instance;

	public static AbstractStrategyFactory getInstance() {
		if (instance == null)
			instance = new DefaultFactory();
		return instance;
	}

	public MessageStrategy createStrategy(final MessageBody mb) {
		return new MessageStrategy() {
			MessageBody body = mb;

			public void sendMessage() {
				Object obj = body.getPayload();
				System.out.println((String) obj);
			}
		};
	}
}