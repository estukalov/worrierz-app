package org.worrierz.worrierzapp;


public class WorrierCharacterGeneratorImpl implements WorrierCharacterGenerator {
    private final DictionaryHandler dictionaryHandler;
    public WorrierCharacterGeneratorImpl(final DictionaryHandler dictionaryHandler) {
        this.dictionaryHandler = dictionaryHandler;
    }

    public WorrierCharacter generateCharacter() {
        String firstNoun = dictionaryHandler.getRandomNoun();
        final String prefixName = firstNoun.substring(0, 1).toUpperCase() + firstNoun.substring(1).toLowerCase();
        String secondNoun = dictionaryHandler.getRandomNoun();
        final String postfixName = secondNoun.substring(0, 1).toUpperCase() + secondNoun.substring(1).toLowerCase();
        Clan clan = Clan.getRandomClan();

        //WorrierCharacter(String prefixName, String fullName, String clan, String lostItem, String opponentClan)
        return new WorrierCharacter(prefixName,
                prefixName + postfixName,
                clan.toString(),
                dictionaryHandler.getRandomNoun().toLowerCase(),
                Clan.getRandomClanExcept(clan).toString(),
                dictionaryHandler.getRandomAdjective().toLowerCase());
    }
}
