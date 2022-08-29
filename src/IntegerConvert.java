
// TODO: Auto-generated Javadoc
/**
 * The Class IntegerConverter. This class provides static methods for converting
 * integer, binary and hex strings to specified numeric primitives (int, shor
 */
public class IntegerConvert {

	/**
	 * Instantiates a new integer converter.
	 */
	public IntegerConvert() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Convert string to int.
	 *
	 * @param in the String to convert
	 * @return the converted value of the string represented as an int
	 * @throws NumberFormatException the number format exception
	 */
	public static int parseInt(String in) throws NumberFormatException {
		return 0;
	}

	/**
	 * Convert string to short.
	 *
	 * @param in the String to convert
	 * @return the converted value of the string represented as a short
	 * @throws NumberFormatException the number format exception
	 */
	public static short parseShort(String in) throws NumberFormatException {
		return 0;
	}

	/**
	 * Convert string to byte.
	 *
	 * @param in the String to convert
	 * @return the byte
	 * @throws NumberFormatException the number format exception
	 */
	public static byte parseByte(String in) throws NumberFormatException {
		return 0;
	}
	
	/**
	 * Parses an unsigned binary string and returns the equivalent integer value (signed)
	 *
	 * @param in   the input binary string. Should have a leading "0b"
	 * @return  the integer value of the converted string
	 * @throws NumberFormatException the number format exception
	 */
	public static int parseBinStrToInt(String in) throws NumberFormatException {
		int result = 0; // the variable to return
		int counter = 1; // helper variable help with result; used to count up to result
		
		if (in.length() <= 2 || !in.substring(0,2).equals("0b")) {
			throw new NumberFormatException("Missing 0b or empty string.");
		}
		
		for (int i = in.length() - 1; i > 1; i--) {
			if (in.charAt(i) == '_') {
				continue;
			}
			if (counter == 0) { // if counter goes to 0 means it overflowed; ie: the input was too large
				throw new NumberFormatException("Number of valid binary characters is too large.");
			}
			
			if (in.charAt(i) == '1') {
				result += counter;
			} else if (in.charAt(i) != '0') {
				throw new NumberFormatException("Invalid character in binary string.");
			}

			counter *= 2;
		}
		return result;
	}
	
	/**
	 * Parses an unsigned binary string and returns the equivalent byte value (signed) 
	 *
	 * @param in  the input binary string. Should have a leading "0b"
	 * @return the byte value of the converted string
	 * @throws NumberFormatException the number format exception
	 */
	public static byte parseBinStrToByte(String in) throws NumberFormatException {
		byte result = 0; // the variable to return
		byte counter = 1; // helper variable help with result; used to count up to result
		
		if (in.length() <= 2 || !in.substring(0,2).equals("0b")) {
			throw new NumberFormatException("Missing 0b or empty string.");
		}
		
		for (int i = in.length() - 1; i > 1; i--) {
			if (in.charAt(i) == '_') {
				continue;
			}
			if (counter == 0) { // if counter goes to 0 means it overflowed; ie: the input was too large
				throw new NumberFormatException("Number of valid binary characters is too large.");
			}

			if (in.charAt(i) == '1') {
				result += counter;
			} else if (in.charAt(i) != '0') {
				throw new NumberFormatException("Invalid character in binary string.");
			}
			counter *= 2;
		}
		return result;
	}
	
	/**
	 * Parses an unsigned hex string and returns the equivalent integer value (signed).
	 *
	 * @param in  the input hex string. Should have a leading "0x"
	 * @return the integer value of the converted string
	 * @throws NumberFormatException the number format exception
	 */
	public static int parseHexStrToInt(String in) throws NumberFormatException {
		return 0;
	}
	
	/**
	 * Parses an unsigned hex string and returns the equivalent byte value (signed).
	 *
	 * @param in  the input hex string. Should have a leading "0x"
	 * @return the byte value of the converted string
	 * @throws NumberFormatException the number format exception
	 */
	public static byte parseHexStrToByte(String in) throws NumberFormatException {
		return 0;
	}

	/**
	 * Returns the equivalent unsigned binary string (32 bits)
	 *
	 * @param in the integer to convert
	 * @return the equivalent binary string representation (32 bits)
	 */
	public static String intToBinaryString(int in) {
		String str = "";
		long mask = 2147483648L;
		for (int i = 0; i < 32; i++) { // 32 * 1 = 32
			str += ((mask & in) > 0) ? "1" : "0";
			mask = mask >>> 1; // shift by 1 digit
		}
		return str;
	}
	
	/**
	 * Returns the equivalent unsigned binary string (8 bits)
	 *
	 * @param in the byte to convert
	 * @return the equivalent binary string representation (8 bits)
	 */
	public static String byteToBinaryString(byte in) {
		String str = "";
		int mask = 0x80;
		for (int i = 0; i < 8; i++) { // 8 * 1 = 8
			str += ((mask & in) > 0) ? "1" : "0";
			mask = mask >>> 1; // shift by 1 digit
		}
		return str;
	}
	
	/**
	 * Returns the equivalent unsigned hex string (8 hex chars)
	 *
	 * @param in the integer to convert
	 * @return the equivalent hex string representation (8 hex chars)
	 */
	public static String intToHexString(int in) {
		String result = "";
		String[] keyArray = new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"}; // chart for identification
		int temp = 0;
		int numHexDigitsInAnInt = 8; // 8 * 4 = 32
		
		for (int i = 0; i < numHexDigitsInAnInt; i++) {
			temp = in & 0b1111; // get last 4 digits
			result = keyArray[temp] + result;
			in >>>= 4; // shift by 4
		}
		
		return result;
	}
	
	/**
	 * Returns the equivalent unsigned hex string (2 hex chars)
	 *
	 * @param in the integer to convert
	 * @return the equivalent hex string representation (2 hex chars)
	 */
	public static String byteToHexString(byte in) {
		String result = "";
		String[] keyArray = new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"}; // chart for identification
		int temp = 0;
		int numHexDigitsInAByte = 2; // 2 * 4 = 8
		
		for (int i = 0; i < numHexDigitsInAByte; i++) {
			temp = in & 0b1111; // get last 4 digits
			result = keyArray[temp] + result;
			in >>>= 4; // shift by 4
		}
		
		return result;
	}
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// You should write basic testing of each of your methods here.
		// I will provide a more comprehensive testing using JUnit later.
		
//		System.out.println("(Int) Expected: 85");
//		System.out.print("(Int) Actual: ");
//		System.out.println(IntegerConvert.parseBinStrToInt("0b01010101"));
//		
//		System.out.println("(Int) Expected: 31");
//		System.out.print("(Int) Actual: ");
//		System.out.println(IntegerConvert.parseBinStrToInt("0b_0_0_0_1_1_1_1_1"));
//		
//		System.out.println("---------------------------------------------------------------------------------");
//		
//		System.out.println("(Byte) Expected: 85");
//		System.out.print("(Byte) Actual: ");
//		System.out.println(IntegerConvert.parseBinStrToByte("0b01010101"));
//		
//		System.out.println("(Byte) Expected: 31");
//		System.out.print("(Byte) Actual: ");
//		System.out.println(IntegerConvert.parseBinStrToByte("0b_0_0_0_1_1_1_1_1"));
		
		
		
		
		
//		System.out.println("(Int) Expected: Missing 0b or empty string.");
//		System.out.print("(Int) Actual: ");
//		System.out.println(IntegerConvert.parseBinStrToInt("0b"));
//		
//		System.out.println("(Int) Expected: Missinsg 0b or empty string.");
//		System.out.print("(Int) Actual: ");
//		System.out.println(IntegerConvert.parseBinStrToInt("empty"));
//		
//		System.out.println("(Int) Expected: ");
//		System.out.print("(Int) Actual: ");
//		System.out.println(IntegerConvert.parseBinStrToInt("0b"));
//		
//		System.out.println("(Int) Expected: Number of valid binary characters is too large.");
//		System.out.print("(Int) Actual: ");
//		System.out.println(IntegerConvert.parseBinStrToInt("0b11111111111111111111111111111111111"));
//		
//		System.out.println("---------------------------------------------------------------------------------");
//		
//		System.out.println("(Int) Expected: Missing 0b or empty string.");
//		System.out.print("(Int) Actual: ");
//		System.out.println(IntegerConvert.parseBinStrToByte("0b"));
//		
//		System.out.println("(Int) Expected: Missinsg 0b or empty string.");
//		System.out.print("(Int) Actual: ");
//		System.out.println(IntegerConvert.parseBinStrToByte("empty"));
//		
//		System.out.println("(Int) Expected: ");
//		System.out.print("(Int) Actual: ");
//		System.out.println(IntegerConvert.parseBinStrToByte("0b"));
//		
//		System.out.println("(Int) Expected: Number of valid binary characters is too large.");
//		System.out.print("(Int) Actual: ");
//		System.out.println(IntegerConvert.parseBinStrToByte("0b11111111111111111111111111111111111"));
		
		
		
		
		System.out.println("(Int) Expected: 00000000000000000000000000001111");
		System.out.print("Actual: ");
		System.out.println(intToBinaryString(15));
		System.out.println("(Byte) Expected: 00001111");
		System.out.print("Actual: ");
		System.out.println(byteToBinaryString((byte)15));
		
		System.out.println();
		
		System.out.println("(Int) Expected: 11111111111111111111111111110001");
		System.out.print("(Int )Actual: ");
		System.out.println(intToBinaryString(-15));
		System.out.println("(Byte) Expected: 11110001");
		System.out.print("(Byte)Actual: ");
		System.out.println(byteToBinaryString((byte)-15));
		
		
		System.out.println("---------------------------------------------------------------------------------");
		
		System.out.println("(Int) Expected: 00000078");
		System.out.print("(Int) Actual: ");
		System.out.println(intToHexString(120));
		System.out.println("(Byte) Expected: 7878");
		System.out.print("(Byte) Actual: 78");
		System.out.println(byteToHexString((byte)120));
		
		System.out.println();
		
		System.out.println("(Int) Expected: ffffff88");
		System.out.print("(Int) Actual: ");
		System.out.println(intToHexString(-120));
		System.out.println("(Byte) Expected: 88");
		System.out.print("(Byte) Actual: ");
		System.out.println(byteToHexString((byte)-120));
	}

}
