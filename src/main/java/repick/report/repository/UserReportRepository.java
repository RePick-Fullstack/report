package repick.report.repository;

import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import repick.report.domain.IndustryReport;
import repick.report.domain.User;

import java.util.List;

public interface UserReportRepository extends MongoRepository<User, ObjectId> {
    @Query(value = "{ 'userId': ?0 }")
    User findUserByUserId(String userId);

    @Query(value = "{ 'userId': ?0 }")
    List<Integer> findViewReportsByUserId(String userId);
}
