package petfriends.daily.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import petfriends.daily.model.UserImage;

public interface UserImageRepository extends JpaRepository<UserImage, Long> {

}
