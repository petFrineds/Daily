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

	private Long id;						// 일지ID
	private int starScore;					// 별점
	private String review;					// 후기
	private Long walkId;					// 산책ID
    private Long dogwalkerScheduleId;		// 도그워커스케줄ID
    private String userId;					// 회원ID
    private String userName;				// 회원명
}
