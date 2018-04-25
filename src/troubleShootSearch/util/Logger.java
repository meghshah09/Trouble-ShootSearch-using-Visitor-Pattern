package troubleShootSearch.util;

import troubleShootSearch.enums.DebugLevel;

/**
 * @author Megh Shah & Shashwat Maru
 *
 */
public class Logger {

    private static DebugLevel debugLevel;
    // FIXME: Add switch cases for all the levels
    /**
     * 
     * @param levelIn specifies the Debug Level
     */
    public  static void setDebugValue (int levelIn) {
	switch (levelIn) {
	case 4: debugLevel = DebugLevel.SEARCHSTRATEGY;
			break;
	case 3: debugLevel = DebugLevel.PRODUCTS;
			break;
	case 2: debugLevel = DebugLevel.CONSTRUCTOR;
			break;
	case 1: debugLevel = DebugLevel.SEARCH;
			break;
                    case 0: debugLevel = DebugLevel.NONE;
                                                            break;
	default: debugLevel = DebugLevel.NONE;
			break;
	}
    }
/**
 * 
 * @param levelIn specifies the debug level
 */
    public  static void setDebugValue (DebugLevel levelIn) {
	debugLevel = levelIn;
    }
/**
 * 
 * @param message String to be printed
 * @param levelIn specifies the debug level
 */
    public  static void writeMessage (String     message  ,
                                     DebugLevel levelIn ) {
	if (levelIn == debugLevel)
	    System.out.println(message);
    }
/**
 * 
 * @return the String specifing the debug level
 */
    @Override
    public String toString() {
	return "The debug level has been set to the following " + debugLevel;
    }
}
