package alibi.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * Class that provides alibis according to the location entered.
 * @author tphan.
 * @version 1.0.0
 * 07.12.2018
 */
public final class LocationProvider implements AlibiProvider {

    /**
     * Location tag in criteria.
     */
    public static final String LOCATION_TAG = "Location: ";

    /**
     * Means of mapping a location to alibi.
     */
    private static final Map<String, Collection<Alibi>> LOCATION_TO_ALIBI;

    static {
        LOCATION_TO_ALIBI = new HashMap<>();
        final Collection<String> activities = new TreeSet<>();
        String location = "Muenchen";
        activities.add("bist ganz oben auf dem Olympiaturm gewesen.");
        activities.add("warst im R-Bau der Hochschule Muenchen"
                + " in der Lothstrasse.");
        activities.add("die TU Muenchen in Garching besucht.");
        activities.add("warst im Hauptgebaeude der LMU Muenchen.");
        activities.add("hast eine Mass auf dem Oktoberfest genossen.");
        activities.add("den Abdruck des Teufelsfusses"
                + " in der Frauenkirche begutachtet.");
        activities.add("bist die Kauffingerstrasse entlanggeschlendert.");
        activities.add("hast Christian Ude kennengelernt.");
        activities.add("warst in Karantaene auf der"
                + " Intensivstation des Klinikums Grosshaderns.");
        activities.add("hast dir ein Spiel in der Allianz Arena angesehen.");
        activities.add("hast die BMW-Welt erkundet.");
        activities.add("hast die Alte und die Neue Pinakothek erforscht.");
        activities.add("warst mit Freunden im Horbraeukeller.");
        activities.add("warst mit deiner Familie im Tierpark Hellabrunn.");
        activities.add("warst mit deiner Schwester im Schloss Nymphenburg.");
        addToMap(activities, location);
        location = "London";
        activities.add("bist im London Eye gewesen.");
        activities.add("hast die Garde der Koenigin geaergert.");
        activities.add("hast die Tower Bridge begutachtet.");
        activities.add("hast Oxford besucht.");
        activities.add("hast einen Abstecher zu Stone Henge gemacht.");
        addToMap(activities, location);
        location = "Malmo";
        activities.add("hast eine Saeule der Malmo Universität umarmt.");
        activities.add("warst im Turning Torso.");
        activities.add("bist über die Oresundbruecke nach"
                + " Kopenhagen gefahren.");
        activities.add("bist über die Oresundbruecke von"
                + " Kopenhagen gekommen.");
        activities.add("warst in der World Maritime University.");
        activities.add("hast dich von der Schokoladenfabrik"
                + " begeistern lassen.");
        addToMap(activities, location);
        location = "Bruessel";
        activities.add("bist im Europapark auf einen T-Rex gestossen.");
        activities.add("hast den Sitz des EU-Rats betreten.");
        activities.add("bist auf das Atomium geklettert.");
        activities.add("hast dich von der Schokoladenfabrik"
                + " begeistern lassen.");
    }

    /**
     * Puts a Collection of alibis with the associated location as the key
     * into the constant map.
     * @param activities  the activities to be added.
     * @param location    the location key.
     */
    private static void addToMap(final Collection<String> activities,
                                 final String location) {
        LOCATION_TO_ALIBI.put(location, activities.stream()
                .<Alibi>map((String activity) -> new Alibi("",
                        "", location, "",
                        activity, "", ""))
                .collect(Collectors.toList()));
        activities.clear();
    }

    @Override
    public Collection<Alibi> provideAlibi(final Collection<String> criteria) {
        Collection<String> locationCriteria = criteria.stream()
                .filter(string -> string.startsWith(LOCATION_TAG))
                .map(string -> string.substring(LOCATION_TAG.length()))
                .collect(Collectors.toList());
        Collection<Alibi> result = new TreeSet<>();
        LOCATION_TO_ALIBI.forEach(
                (location, alibis) -> addToResult(locationCriteria
                        .contains(location), alibis, result));
        return null;
    }

    /**
     * Adds a Collection of alibis to another Collection
     * if the condition is met.
     * @param condition  the if-condition.
     * @param alibis     the source Collection.
     * @param result     the result Collection.
     */
    private void addToResult(final boolean condition,
                             final Collection<Alibi> alibis,
                             final Collection<Alibi> result) {
        if (condition) {
            result.addAll(alibis);
        }
    }

}
