package morse;

import java.util.Map;
import java.util.HashMap;

public class MorseDecoder {

    private static final Map<String, String> SIGNAL_TO_CHAR = new HashMap<>() {{
        put(MorseTraits.MORSE_A, MorseTraits.ALNUM_A);
        put(MorseTraits.MORSE_B, MorseTraits.ALNUM_B);
        put(MorseTraits.MORSE_C, MorseTraits.ALNUM_C);
        put(MorseTraits.MORSE_D, MorseTraits.ALNUM_D);
        put(MorseTraits.MORSE_E, MorseTraits.ALNUM_E);
        put(MorseTraits.MORSE_F, MorseTraits.ALNUM_F);
        put(MorseTraits.MORSE_G, MorseTraits.ALNUM_G);
        put(MorseTraits.MORSE_H, MorseTraits.ALNUM_H);
        put(MorseTraits.MORSE_I, MorseTraits.ALNUM_I);
        put(MorseTraits.MORSE_J, MorseTraits.ALNUM_J);
        put(MorseTraits.MORSE_K, MorseTraits.ALNUM_K);
        put(MorseTraits.MORSE_L, MorseTraits.ALNUM_L);
        put(MorseTraits.MORSE_M, MorseTraits.ALNUM_M);
        put(MorseTraits.MORSE_N, MorseTraits.ALNUM_N);
        put(MorseTraits.MORSE_O, MorseTraits.ALNUM_O);
        put(MorseTraits.MORSE_P, MorseTraits.ALNUM_P);
        put(MorseTraits.MORSE_Q, MorseTraits.ALNUM_Q);
        put(MorseTraits.MORSE_R, MorseTraits.ALNUM_R);
        put(MorseTraits.MORSE_S, MorseTraits.ALNUM_S);
        put(MorseTraits.MORSE_T, MorseTraits.ALNUM_T);
        put(MorseTraits.MORSE_U, MorseTraits.ALNUM_U);
        put(MorseTraits.MORSE_V, MorseTraits.ALNUM_V);
        put(MorseTraits.MORSE_W, MorseTraits.ALNUM_W);
        put(MorseTraits.MORSE_X, MorseTraits.ALNUM_X);
        put(MorseTraits.MORSE_Y, MorseTraits.ALNUM_Y);
        put(MorseTraits.MORSE_Z, MorseTraits.ALNUM_Z);
        put(MorseTraits.MORSE_0, MorseTraits.ALNUM_0);
        put(MorseTraits.MORSE_1, MorseTraits.ALNUM_1);
        put(MorseTraits.MORSE_2, MorseTraits.ALNUM_2);
        put(MorseTraits.MORSE_3, MorseTraits.ALNUM_3);
        put(MorseTraits.MORSE_4, MorseTraits.ALNUM_4);
        put(MorseTraits.MORSE_5, MorseTraits.ALNUM_5);
        put(MorseTraits.MORSE_6, MorseTraits.ALNUM_6);
        put(MorseTraits.MORSE_7, MorseTraits.ALNUM_7);
        put(MorseTraits.MORSE_8, MorseTraits.ALNUM_8);
        put(MorseTraits.MORSE_9, MorseTraits.ALNUM_9);
    }};

    public String decodeMessage(String message) {
        if (message.isEmpty() || message.isBlank()) {
            return null;
        }
        return parseMessage(message);
    }

    private String parseMessage(String message) {
        StringBuilder result = new StringBuilder();
        parseTokens(result, message.split(MorseTraits.ONE_SPACE));
        return result.toString();
    }

    private void parseTokens(StringBuilder decodedMessage, String[] tokens) {
        int spaces = 0;
        for(String token : tokens) {
            spaces = parseToken(decodedMessage, spaces, token);
        }
    }

    private int parseToken(StringBuilder decodedMessage, int spaces, String token) {
        if(token.isEmpty()) {
            if(spaces == 0) {
                spaces = 1;
            }
            return ++spaces;
        }
        if(spaces >= 5) {
            decodedMessage.append(' ');
        }
        return appendCharacter(decodedMessage, token);
    }

    private int appendCharacter(StringBuilder decodedMessage, String token) {
        if(SIGNAL_TO_CHAR.containsKey(token)) {
            decodedMessage.append(SIGNAL_TO_CHAR.get(token));
        } else {
            decodedMessage.append('?');
        }
        return 0;
    }

}
