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
	private Long userId;				// 회원ID
	private Long dogWalkerId;			// 도그워커ID
}
