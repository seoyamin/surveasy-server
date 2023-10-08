package surveasy.domain.panel.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import surveasy.domain.panel.domain.Panel;
import surveasy.domain.panel.dto.request.PanelInfoDAO;
import surveasy.domain.panel.dto.request.PanelInfoFirstSurveyDAO;
import surveasy.domain.panel.dto.request.PanelSignUpDTO;
import surveasy.domain.panel.dto.response.PanelTokenResponse;

@Component
@RequiredArgsConstructor
public class PanelMapper {

    public Panel toEntityExisting(PanelInfoDAO panelInfoDAO, PanelInfoFirstSurveyDAO panelInfoFirstSurveyDAO) {
        return Panel.ofExisting(panelInfoDAO, panelInfoFirstSurveyDAO);
    }

    public Panel toEntityNew(PanelSignUpDTO panelSignUpDTO) {
        return Panel.ofNew(panelSignUpDTO);
    }

    public PanelTokenResponse toPanelTokenResponse(Long panelId, String accessToken, String refreshToken) {
        return PanelTokenResponse.of(panelId, accessToken, refreshToken);
    }
}
