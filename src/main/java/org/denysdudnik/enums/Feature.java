package org.denysdudnik.enums;

import lombok.Getter;

import static java.util.Objects.isNull;

@Getter
public enum Feature {
    TRAILERS("Trailers"),
    COMMENTARIES("Commentaries"),
    DELETED_SCENES("Deleted scenes"),
    BEHIND_THE_SCENES("Behind the scenes");

    private final String value;

    Feature(String value) {
        this.value = value;
    }

    public static Feature getFeatureByValue(String value) {
        if (isNull(value) || value.isEmpty()) {
            return null;
        }

        Feature[] features = Feature.values();

        for (Feature feature : features) {
            if (feature.getValue().equals(value)) {
                return feature;
            }
        }

        return null;
    }
}
