package petfriends.daily.view;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ScoreRequestView {

	private Long id;				// 일지ID
	private int starScore;			// 별점
	private Long walkId;			// 산책ID
    private Long dogWalkerId;		// 도그워커ID
    private Long userId;			// 회원ID
}
