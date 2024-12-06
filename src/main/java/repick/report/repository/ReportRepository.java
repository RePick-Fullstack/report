package repick.report.repository;


import org.bson.types.ObjectId;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import repick.report.domain.Report;

import java.util.List;

public interface ReportRepository extends MongoRepository<Report, ObjectId> {
    List<Report> findTop10ByOrderByIdDesc();

    @Query(value = "{ 'report_type': 'Company' }", sort = "{ 'report_date': -1 }")
    List<Report> findTop10ByReportTypeOrderByReportDateDesc(PageRequest pageRequest);
}
