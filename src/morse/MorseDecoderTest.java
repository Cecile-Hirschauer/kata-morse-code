package morse;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MorseDecoderTest {
	MorseDecoder decoder = new MorseDecoder();
		
	@Test
	void should_return_null_when_signals_is_empty() {
		assertNull(decoder.decodeMessage(""));
	}
	
	@Test
	void should_return_null_when_signals_is_blank() {
		assertNull(decoder.decodeMessage(" "));
	}
	
	@Test
	void should_return_2017_when_signals_is_period_period_dash_dash_dash_space_dash_dash_dash_dash_space_period_dash_dash_dash_space_dash_dash_perid_period_period() {
		assertEquals("2017", decoder.decodeMessage("..--- ----- .---- --..."));
	}
	
	@Test
	void should_return_SOS_when_signals_is_period_period_period_space_dash_dash_dash_space_period_period_period() {
		assertEquals("sos", decoder.decodeMessage("... --- ... "));
	}
	
	@Test
	void should_return_Hello_space_World() {
		assertEquals("hello world", decoder.decodeMessage(".... . .-.. .-.. ---     .-- --- .-. .-.. -.."));
	}
	
	@Test
	void should_return_Code_space_Morse() {
		assertEquals("code morse", decoder.decodeMessage("-.-. --- -.. .     -- --- .-. ... ."));
	}	
    
	@Test
	void should_return_questions_when_code_is_garbage() {
		assertEquals("?", decoder.decodeMessage("SOS"));
	}	
}
