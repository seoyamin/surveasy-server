package surveasy.domain.survey.vo;

import lombok.Builder;
import lombok.Getter;
import surveasy.domain.response.domain.Response;
import surveasy.domain.survey.domain.SurveyStatus;
import surveasy.domain.survey.domain.option.SurveySpendTime;

@Getter
public class SurveyAppListVo {

    private final Long id;

    private final String title;

    private final Integer reward;

    private final String spendTime;

    private final String targetInput;

    private final SurveyStatus status;

    private final Integer responseCount;

    private final boolean participated;

    @Builder
    public SurveyAppListVo(Long id, String title, Integer reward, SurveySpendTime spendTime, String targetInput,
                           SurveyStatus status, Integer responseCount, Response response) {
        this.id = id;
        this.title = title;
        this.reward = reward;
        this.spendTime = spendTime.getValue();
        this.targetInput = targetInput;
        this.status = status;
        this.responseCount = responseCount;
        this.participated = (response != null);
    }
}
