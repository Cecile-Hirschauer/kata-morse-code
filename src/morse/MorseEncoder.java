package morse;

import java.util.HashMap;
import java.util.Map;

public class MorseEncoder {
	private static final String WORD_SEPARATOR = "   ";
	private static final Map<String, String> ENGLISH_TO_MORSE = new HashMap<>() {{
        put(MorseTraits.ALNUM_A, MorseTraits.MORSE_A);
        put(MorseTraits.ALNUM_B, MorseTraits.MORSE_B);
        put(MorseTraits.ALNUM_C, MorseTraits.MORSE_C);
        put(MorseTraits.ALNUM_D, MorseTraits.MORSE_D);
        put(MorseTraits.ALNUM_E, MorseTraits.MORSE_E);
        put(MorseTraits.ALNUM_F, MorseTraits.MORSE_F);
        put(MorseTraits.ALNUM_G, MorseTraits.MORSE_G);
        put(MorseTraits.ALNUM_H, MorseTraits.MORSE_H);
        put(MorseTraits.ALNUM_I, MorseTraits.MORSE_I);
        put(MorseTraits.ALNUM_J, MorseTraits.MORSE_J);
        put(MorseTraits.ALNUM_K, MorseTraits.MORSE_K);
        put(MorseTraits.ALNUM_L, MorseTraits.MORSE_L);
        put(MorseTraits.ALNUM_M, MorseTraits.MORSE_M);
        put(MorseTraits.ALNUM_N, MorseTraits.MORSE_N);
        put(MorseTraits.ALNUM_O, MorseTraits.MORSE_O);
        put(MorseTraits.ALNUM_P, MorseTraits.MORSE_P);
        put(MorseTraits.ALNUM_Q, MorseTraits.MORSE_Q);
        put(MorseTraits.ALNUM_R, MorseTraits.MORSE_R);
        put(MorseTraits.ALNUM_S, MorseTraits.MORSE_S);
        put(MorseTraits.ALNUM_T, MorseTraits.MORSE_T);
        put(MorseTraits.ALNUM_U, MorseTraits.MORSE_U);
        put(MorseTraits.ALNUM_V, MorseTraits.MORSE_V);
        put(MorseTraits.ALNUM_W, MorseTraits.MORSE_W);
        put(MorseTraits.ALNUM_X, MorseTraits.MORSE_X);
        put(MorseTraits.ALNUM_Y, MorseTraits.MORSE_Y);
        put(MorseTraits.ALNUM_Z, MorseTraits.MORSE_Z);
        put(MorseTraits.ALNUM_0, MorseTraits.MORSE_0);
        put(MorseTraits.ALNUM_1, MorseTraits.MORSE_1);
        put(MorseTraits.ALNUM_2, MorseTraits.MORSE_2);
        put(MorseTraits.ALNUM_3, MorseTraits.MORSE_3);
        put(MorseTraits.ALNUM_4, MorseTraits.MORSE_4);
        put(MorseTraits.ALNUM_5, MorseTraits.MORSE_5);
        put(MorseTraits.ALNUM_6, MorseTraits.MORSE_6);
        put(MorseTraits.ALNUM_7, MorseTraits.MORSE_7);
        put(MorseTraits.ALNUM_8, MorseTraits.MORSE_8);
        put(MorseTraits.ALNUM_9, MorseTraits.MORSE_9);
        put(MorseTraits.ONE_SPACE, WORD_SEPARATOR);
    }};

	
	public String encodeMessage(String message) {
        if (message.isEmpty() || message.isBlank()) {
            return null;
        }
        return parseMessage(message);
    }

    private String parseMessage(String message) {
        StringBuilder result = new StringBuilder();
        parseCharacters(result, message.toLowerCase().toCharArray());
        return result.toString();
    }

    private void parseCharacters(StringBuilder encodedMessage, char[] characters) {
    	int spaces = 0;
        for(char character : characters) {
            spaces = parseCharacter(encodedMessage, spaces, character);
        }
    }

    private int parseCharacter(StringBuilder encodedMessage, int spaces, char character) {
    	if (encodedMessage.length() > 0 && !encodedMessage.isEmpty()) {
    		if(character != encodedMessage.charAt(encodedMessage.length() - 1)) {
    			encodedMessage.append(MorseTraits.ONE_SPACE);
    		}
    	
    	}
    	return appendCharacter(encodedMessage, character);
    }

    private int appendCharacter(StringBuilder encodedMessage, char character) {
    	String key = Character.toString(character);
    	if(ENGLISH_TO_MORSE.containsKey(key)) {
    		encodedMessage.append(ENGLISH_TO_MORSE.get(key));    	
    	} else {
    		encodedMessage.append('?');    	
    	}
    	return 0;
    }
		

}
