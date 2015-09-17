package jp.ac.hal.Controller;

public class InputCheck {
	
	/*
	 * 空文字またはNullチェック
	 */
	public boolean checkNullChar(String... org) {
		boolean err = false;
		for (String str : org) {
			err |= (str == null || str.length() == 0);
		}
		
		return err;
	}

	/*
	 * 入力文字数チェック
	 */
	public boolean checkCharaLength(String str, int length) {
		boolean err = str.length() > length ? true : false ;
		
		return err;
	}
	
	
	/*
	 * 数字チェック
	 */
	public boolean checkNumbers(String str) {
		boolean err = false;
		try {
			Integer.parseInt(str);
		} catch (NumberFormatException e) {
			err = true;
		}
		
		return err;
	}
}
