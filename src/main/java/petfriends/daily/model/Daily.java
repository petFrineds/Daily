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
    
    private String contents;			// 작성내용    
    private int starScore;				// 별점    
    private Long walkId;				// 산책ID
    private Long dogWalkerId;			// 도그워커ID
    private Long userId;				// 회원ID
    
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
    		Long userId,
    		Long dogWalkerId) {
    	
    	return Daily.builder()
    			.contents(contents)
    			.walkingPlace(walkingPlace)
    			.walkId(walkId)
    			.userId(userId)
    			.dogWalkerId(dogWalkerId)
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

	public Long getDogWalkerId() {
		return dogWalkerId;
	}

	public void setDogWalkerId(Long dogWalkerId) {
		this.dogWalkerId = dogWalkerId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public int getStarScore() {
		return starScore;
	}

	public void setStarScore(int starScore) {
		this.starScore = starScore;
	}
	
	
}