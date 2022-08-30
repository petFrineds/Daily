package petfriends.daily.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.Table;

import org.springframework.beans.BeanUtils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import petfriends.daily.dto.DailyWrited;
import petfriends.daily.dto.StarScoreGranted;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="daily")
public class Daily {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="daily_id")
    private Long id;					// 일지ID
    
    private String dailyRecordDate;		// 작성일자
    
    @Enumerated(EnumType.STRING)
    private WalkingPlace walkingPlace;	// 산책장소
    
    private String walkStartDate; 		// 산책 시작 일시분(실제)
	private String walkEndDate;			// 산책 종료 일시분(실제)
    
    private String contents;			// 산책내용(작성내용)    
    private int starScore;				// 별점    
    private String review;				// 후기
    private Long walkId;				// 산책ID
    private String dogWalkerId;			// 도그워커ID
    private String userId;				// 회원ID
    private String userName;			// 회원명
    
    @PostPersist
    public void onPostPersist(){
        DailyWrited dailyWrited = new DailyWrited();
        BeanUtils.copyProperties(this, dailyWrited);
        dailyWrited.publishAfterCommit();

    }
    
	@PostUpdate
    public void onPostUpdate(){
	
		// 별점 부여된 경우만 발행 (일지 수정인 경우는 안타게 함)
		if(this.getStarScore() != 0) {
			
			StarScoreGranted starScoreGranted = new StarScoreGranted();
	        BeanUtils.copyProperties(this, starScoreGranted);
	        starScoreGranted.publishAfterCommit();	
			
		}
    	
    }
    
    public static Daily of(
    		String contents,
    		WalkingPlace walkingPlace,
    		Long walkId,
    		String userId,
    		String userName,
    		String dogWalkerId,
    		String walkStartDate,
    		String walkEndDate) {
    	
    	return Daily.builder()
    			.contents(contents)
    			.walkingPlace(walkingPlace)
    			.walkId(walkId)
    			.userId(userId)
    			.userName(userName)
    			.dogWalkerId(dogWalkerId)
    			.walkStartDate(walkStartDate)
    			.walkEndDate(walkEndDate)
    			.build();
    	
    }
    

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDailyRecordDate() {
		return dailyRecordDate;
	}

	public void setDailyRecordDate(String dailyRecordDate) {
		this.dailyRecordDate = dailyRecordDate;
	}

	public WalkingPlace getWalkingPlace() {
		return walkingPlace;
	}

	public void setWalkingPlace(WalkingPlace walkingPlace) {
		this.walkingPlace = walkingPlace;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public Long getWalkId() {
		return walkId;
	}

	public void setWalkId(Long walkId) {
		this.walkId = walkId;
	}

	public int getStarScore() {
		return starScore;
	}

	public void setStarScore(int starScore) {
		this.starScore = starScore;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDogWalkerId() {
		return dogWalkerId;
	}

	public void setDogWalkerId(String dogWalkerId) {
		this.dogWalkerId = dogWalkerId;
	}

	public String getWalkStartDate() {
		return walkStartDate;
	}

	public void setWalkStartDate(String walkStartDate) {
		this.walkStartDate = walkStartDate;
	}

	public String getWalkEndDate() {
		return walkEndDate;
	}

	public void setWalkEndDate(String walkEndDate) {
		this.walkEndDate = walkEndDate;
	}
	
	
}