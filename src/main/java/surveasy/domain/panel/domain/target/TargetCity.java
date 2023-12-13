package surveasy.domain.panel.domain.target;

import lombok.Getter;

@Getter
public enum TargetCity {

    SEOUL("서울특별시"),
    GYEONG_GI("경기도");

    /*
    * <item>서울특별시</item>
        <item>부산광역시</item>
        <item>대구광역시</item>
        <item>인천광역시</item>
        <item>광주광역시</item>
        <item>대전광역시</item>
        <item>울산광역시</item>
        <item>세종특별자치시</item>
        <item>경기도</item>
        <item>강원도</item>
        <item>충청북도</item>
        <item>충청남도</item>
        <item>전라북도</item>
        <item>전라남도</item>
        <item>경상북도</item>
        <item>경상남도</item>
        <item>제주특별자치도</item>
    * */

    private final String value;

    TargetCity(String value) {
        this.value = value;
    }

}