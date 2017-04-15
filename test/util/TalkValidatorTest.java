package util;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by viniciushisao on 15/04/17.
 */
public class TalkValidatorTest {
    @Test
    public void validateTalk() throws Exception {
        assertTrue(TalkValidator.validateTalk("Writing Fast Tests Against Enterprise Rails 60min") != null);
        assertTrue(TalkValidator.validateTalk("        Overdoing it in Python 45min") != null);
        assertTrue(TalkValidator.validateTalk("Lua for the Masses 30min") != null);
        assertTrue(TalkValidator.validateTalk(" Woah 30min") != null);
        assertTrue(TalkValidator.validateTalk(" 30min Woah") != null);
        assertTrue(TalkValidator.validateTalk("Rails for Python Developers lightning") != null);
        assertTrue(TalkValidator.validateTalk("Clojure Ate Scala(on my project) 45 min\n") != null);
    }
}