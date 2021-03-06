package jp.ac.hal.Util;

public class InputCheck {

	/**
	 * 引数にNullまたは空文字があった場合trueを返す
	 * @param org
	 * @return
	 */
	public boolean checkNullChar(String... args) {
		boolean err = false;
		for (String str : args) {
			err |= (str == null || str.length() == 0);
		}

		return err;
	}

	/**
	 * 引数strが引数lengthより大きい文字数だった場合trueを返す
	 * @param str
	 * @param length
	 * @return
	 */
	public boolean checkCharaLength(String str, int length) {

		return str.length() > length;
	}

	/**
	 * 引数strに数字以外が含まれている場合trueを返す
	 * @param str
	 * @return
	 */
	public boolean checkNumbers(String... args) {
		boolean err = false;
		try {
			for (String str : args) {
				Integer.parseInt(str);
			}
		} catch (NumberFormatException e) {
			err = true;
		}

		return err;
	}

	/**
	 * 数字-のみ
	 * @param args
	 * @return
	 */
	public boolean addressAndPhoneValidator(String... args) {
		boolean err = false;
		String pattern = "[0-9a-zA-Z-]+";
		for (String str : args) {
			if (!str.matches(pattern)) {
				err |= true;
			}
		}

		return err;
	}
	/**
	 * メールアドレスかどうか
	 * @param args
	 * @return
	 */
	public boolean checkMailAddress(String... args){
		boolean err = false;
		for (String str : args) {
			if (!str.matches("[\\w\\.\\-]+@(?:[\\w\\-]+\\.)+[\\w\\-]+")){
				err = true;
			}
		}
		return err;
	}

}
