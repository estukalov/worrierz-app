package org.worrierz.worrierzapp;

import java.util.*;

public enum Clan {
    ThunderClan,
    RiverClan,
    WindClan,
    ShadowClan,
    ;


    private static final Random random = new Random();
    private static final List<Clan> values = List.of(values());
    public static Clan getRandomClan() {
        return values.get(random.nextInt(values.size()));
    }

    public static Clan getRandomClanExcept(Clan excludedClan) {
        Clan randomClan;
        do {
            randomClan = getRandomClan();
        } while (randomClan.equals(excludedClan));
        return randomClan;
    }
}
