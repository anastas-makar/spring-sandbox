package pro.progr.actuator;

import org.springframework.lang.NonNull;

public class NameDTO {

    @NonNull
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
