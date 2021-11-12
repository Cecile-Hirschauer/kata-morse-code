package morse;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MorseEncoderTest {
	MorseEncoder encoder = new MorseEncoder();

	@Test
	void should_return_null_when_message_is_empty() {
		assertNull(encoder.encodeMessage(""));
	}
	
	@Test
	void should_return_null_when_message_is_blank() {
		assertNull(encoder.encodeMessage(" "));
	}
	
	@Test
	void should_return_period_period_period_space_dash_dash_dash_space_period_period_period_when_message_is_SOS() {
		assertEquals("... --- ...", encoder.encodeMessage("sos"));
	}
	
	@Test
	void should_return_period_period_dash_dash_dash_space_dash_dash_dash_dash_space_period_dash_dash_dash_space_dash_dash_perid_period_period_when_message_is_2017() {
		assertEquals("..--- ----- .---- --...", encoder.encodeMessage("2017"));
	}
	
	
	@Test
	void should_return_morse_code_for_Hello_space_World() {
		assertEquals(".... . .-.. .-.. ---     .-- --- .-. .-.. -..", encoder.encodeMessage("Hello World"));
	}
	
	@Test
	void should_return_morse_code_for_CODE_space_MORSE() {
		assertEquals("-.-. --- -.. .     -- --- .-. ... .", encoder.encodeMessage("Code morse"));
	}	
	
	@Test
	void should_return_questions_when_code_is_garbage() {
		assertEquals("? ? ?", encoder.encodeMessage(";;!"));
	}

}
