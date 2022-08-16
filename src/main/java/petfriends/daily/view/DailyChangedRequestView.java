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
public class DailyChangedRequestView {

	private Long id;					// 일지ID
	private String contents;			// 작성내용
	private WalkingPlace walkingPlace;	// 산책장소
}
