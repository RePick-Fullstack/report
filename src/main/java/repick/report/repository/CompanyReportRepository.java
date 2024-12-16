package repick.report.repository;


import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import repick.report.domain.CompanyReport;

import java.util.List;

@Repository
public interface CompanyReportRepository extends MongoRepository<CompanyReport, ObjectId> {
    @Query(value = "{ 'report_type': 'Company' }", sort = "{ 'report_date': -1 }")
    Page<CompanyReport> findTop10ByReportTypeOrderByReportDateDesc(Pageable pageable);

    @Query(value = "{ 'report_type': 'Company','report_id': { $in: ?0 } }")
    Page<CompanyReport> findReportId(List<Integer> reportIds, Pageable pageable);

    @Query("{ $and: [ { 'report_type': 'Company' }, " +
            "{ $or: [ " +
            "  { 'company_name': { $regex: ?0, $options: 'i' } }, " +
            "  { 'report_title': { $regex: ?0, $options: 'i' } }, " +
            "  { 'securities_firm': { $regex: ?0, $options: 'i' } } " +
            "] } ] }")
    Page<CompanyReport> findByKeyword(String keyword, Pageable pageable);
}
