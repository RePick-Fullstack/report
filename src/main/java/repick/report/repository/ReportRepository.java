package repick.report.repository;


import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import repick.report.domain.Report;

import java.util.List;

public interface ReportRepository extends MongoRepository<Report, ObjectId> {
    List<Report> findTop10ByOrderByIdDesc();
}
