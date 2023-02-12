package org.worrierz.worrierzapp;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.ApplicationArguments;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DictionaryHandlerTest {
    @Mock
    ApplicationArguments applicationArguments;
    @Test
    public void verifyDictionaryParsing () throws Exception {
        DictionaryHandler dictionaryHandler = new DictionaryHandler();

        dictionaryHandler.run(applicationArguments);
        assertThat(dictionaryHandler.getRandomNoun())
                .isEqualTo("TIGER");
        assertThat(dictionaryHandler.getRandomAdjective())
                .isEqualTo("ANGRY");
    }
}
