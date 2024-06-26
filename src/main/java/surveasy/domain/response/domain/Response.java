package surveasy.domain.response.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import surveasy.domain.panel.domain.Panel;
import surveasy.domain.response.dto.request.ResponseCreateRequestDTO;
import surveasy.domain.survey.domain.Survey;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Response {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    private ResponseStatus status;

    @NotNull
    private String imgUrl;

    @NotNull
    private Integer reward;

    @NotNull
    private LocalDateTime createdAt;

    @Nullable
    private LocalDate sentAt;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "panel_id", nullable = false)
    private Panel panel;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "survey_id", nullable = false)
    private Survey survey;

    @Builder
    private Response(Panel panel, Survey survey, String imgUrl) {
        this.panel = panel;
        this.survey = survey;
        this.reward = survey.getReward();
        this.imgUrl = imgUrl;

        this.status = ResponseStatus.CREATED;
        this.createdAt = LocalDateTime.now();
    }

    public static Response of(Panel panel, Survey survey, ResponseCreateRequestDTO responseCreateRequestDTO) {
        return Response.builder()
                .panel(panel)
                .survey(survey)
                .imgUrl(responseCreateRequestDTO.getImgUrl())
                .build();
    }
}
