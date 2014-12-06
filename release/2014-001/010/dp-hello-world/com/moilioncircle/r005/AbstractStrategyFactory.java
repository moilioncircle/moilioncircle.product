package com.moilioncircle.r005;

public abstract class AbstractStrategyFactory {
	public abstract MessageStrategy createStrategy(MessageBody mb);
}