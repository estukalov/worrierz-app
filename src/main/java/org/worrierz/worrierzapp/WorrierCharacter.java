package org.worrierz.worrierzapp;

public class WorrierCharacter {
    private final String fullName;

    private final String prefixName;
    private final String clan;
    private final String lostItem;
    private final String opponentClan;
    private final String adjective;

    public WorrierCharacter(String prefixName, String fullName, String clan, String lostItem, String opponentClan, String adjective) {
        this.prefixName = prefixName;
        this.fullName = fullName;
        this.clan = clan;
        this.lostItem = lostItem;
        this.opponentClan = opponentClan;
        this.adjective = adjective;
    }

    public String getFullName() {
        return fullName;
    }

    public String getOpponentClan() {
        return opponentClan;
    }

    public String getLostItem() {
        return lostItem;
    }

    public String getClan() {
        return clan;
    }

    public String getPrefixName() {
        return prefixName;
    }

    public String getAdjective() {
        return adjective;
    }
}
