package net.moonlightflower.wc3libs.misc;

public class UnsupportedFormatException extends Exception {
	private String _msg;
	
	@Override
	public String toString() {
		return _msg;
	}
	
	public UnsupportedFormatException(String msg) {
		_msg = msg;
	}
}
