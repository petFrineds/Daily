package petfriends.daily.view;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import petfriends.daily.model.WalkingPlace;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DailyRequestView {
	private String contents;			// 작성내용
	private WalkingPlace walkingPlace;	// 산책장소
	private Long walkId;				// 산책ID
	private String userId;				// 회원ID
	private String userName;			// 회원명
	private Long dogwalkerScheduleId;	// 도그워커스케줄ID
}
