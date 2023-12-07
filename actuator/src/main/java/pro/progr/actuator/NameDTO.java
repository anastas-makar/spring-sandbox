package pro.progr.actuator;

import jakarta.validation.constraints.NotBlank;

public class NameDTO {

    @NotBlank
    private String name = "Stranger";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
