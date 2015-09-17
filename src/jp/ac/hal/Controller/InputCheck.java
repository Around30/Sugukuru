package jp.ac.hal.Controller;

public class InputCheck {

	/**
	 * 引数にNullまたは空文字があった場合trueを返す
	 * @param org
	 * @return
	 */
	public boolean checkNullChar(String... org) {
		boolean err = false;
		for (String str : org) {
			err |= (str == null || str.length() == 0);
		}
		
		return err;
	}

	/**
	 * 引数strが引数length以上の文字数だった場合trueを返す
	 * @param str
	 * @param length
	 * @return
	 */
	public boolean checkCharaLength(String str, int length) {
		boolean err = str.length() > length ? true : false ;
		
		return err;
	}
	
	/**
	 * 引数strに数字以外が含まれている場合trueを返す
	 * @param str
	 * @return
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
