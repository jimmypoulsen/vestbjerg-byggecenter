package GUI;

public final class Helper {
	static String uppercaseFirstCharacter(String str) {
		str = str.toLowerCase();
		String firstLetter = str.substring(0, 1).toUpperCase();
	    return firstLetter + str.substring(1);
    } 
}