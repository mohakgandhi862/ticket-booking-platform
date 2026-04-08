package project.mohak.booking.platform.model;

import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Theatre {
    private final String id;
    private final String name;
    private final List<Screen> screens;
    private final String city;

    public Theatre(String id, String name, String city ) {
        this.id = id;
        this.name = name;
        this.city = city;
        screens = new ArrayList<>();
    }

    public void addScreen(@NonNull final Screen screen) {
        screens.add(screen);
    }
}
