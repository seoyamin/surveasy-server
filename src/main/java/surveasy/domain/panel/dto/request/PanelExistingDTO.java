package surveasy.domain.panel.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import surveasy.domain.panel.domain.option.PanelPlatform;

@Getter
public class PanelExistingDTO {

    @NotNull
    private String uid;

    @NotNull
    private String email;

    @NotNull
    private PanelPlatform platform;
}
