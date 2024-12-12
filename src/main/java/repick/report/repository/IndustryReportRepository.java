package repick.report.repository;


import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import repick.report.domain.CompanyReport;
import repick.report.domain.IndustryReport;

import java.util.List;

@Repository
public interface IndustryReportRepository extends MongoRepository<IndustryReport, ObjectId> {
    @Query(value = "{ 'report_type': 'Industry' }", sort = "{ 'report_date': -1 }")
    Page<IndustryReport> findAllIndustry(Pageable pageable);

    @Query(value = "{ 'report_type': 'Industry','report_id': { $in: ?0 } }")
    Page<IndustryReport> findReportId(List<Integer> reportIds, Pageable pageable);
}
