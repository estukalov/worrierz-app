package org.worrierz.worrierzapp;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;

@Component
public class DictionaryHandler implements ApplicationRunner {
    private static final Logger logger =
            LoggerFactory.getLogger(DictionaryHandler.class);
    private final List<String> listOfNouns = new ArrayList<>();
    private final List<String> listOfAdjectives = new ArrayList<>();
    private static final int MIN_NOUN_LENGTH = 5; // no four letter nouns
    private static final int MAX_NOUN_LENGTH = 12; // keeping things reasonable
    private final Random random = new Random();

    @Override
    public void run(ApplicationArguments args) throws Exception {
        new ClassPathResource("pg29765.txt").getFile();
        try (LineIterator lineIterator = FileUtils.lineIterator(new ClassPathResource("pg29765.txt").getFile())) {
            while (lineIterator.hasNext()) {
                String potentialWord = lineIterator.nextLine();
                if (isAllCapsWord(potentialWord)) {
                    String nextLine = lineIterator.nextLine();
                    if (probablyNounDefinition(nextLine)) {
                        listOfNouns.add(potentialWord);
                    } else if (probablyAdjectiveDefinition(nextLine)) {
                        listOfAdjectives.add(potentialWord);
                    }
                }
            }

        }
    }

    public String getRandomNoun() {
        return listOfNouns.get(random.nextInt(listOfNouns.size()));
    }

    public String getRandomAdjective() {
        return listOfAdjectives.get(random.nextInt(listOfAdjectives.size()));
    }

    private boolean probablyNounDefinition(final String string) {
        final String patternString = ".*(?<!\\[.{0,80}) n\\..*";
        final Pattern pattern = Pattern.compile(patternString);
        return pattern.matcher(string).matches();
    }

    private boolean probablyAdjectiveDefinition(final String string) {
        final String patternString = ".*(?<!\\[.{0,80}) a\\..*";
        final Pattern pattern = Pattern.compile(patternString);
        return pattern.matcher(string).matches();
    }
    private boolean isAllCapsWord(final String string) {
        final String patternString = "^[A-Z]+$";
        final Pattern pattern = Pattern.compile(patternString);
        return pattern.matcher(string).matches();
    }
}
