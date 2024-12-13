package repick.report.repository;

import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import repick.report.domain.CompanyReport;
import repick.report.domain.IndustryReport;
import repick.report.domain.User;

import java.util.List;

public interface UserReportRepository extends MongoRepository<User, ObjectId> {
    @Query(value = "{ 'userId': ?0 }")
    User findUserByUserId(String userId);

    @Query(value = "{ 'userId': ?0 }")
    List<Integer> findViewReportsByUserId(String userId);

    @Aggregation(pipeline = {
            "{ $match: { 'userId': ?0 } }",
            "{ $lookup: { from: 'reports', localField: 'reports', foreignField: 'report_id', as: 'reportDetails' } }",
            "{ $unwind: '$reportDetails' }",
            "{ $match: { 'reportDetails.report_type': 'Company' } }",
            "{ $project: { _id: '$reportDetails._id', company_name: '$reportDetails.company_name', report_title: '$reportDetails.report_title', securities_firm: '$reportDetails.securities_firm', pdf_link: '$reportDetails.pdf_link', report_date: '$reportDetails.report_date', report_id: '$reportDetails.report_id', report_type: '$reportDetails.report_type' } }"
    })
    Slice<CompanyReport> findCompanyReportsByUserId(String userId, Pageable pageable);

    @Aggregation(pipeline = {
            "{ $match: { 'userId': ?0 } }",
            "{ $lookup: { from: 'reports', localField: 'reports', foreignField: 'report_id', as: 'reportDetails' } }",
            "{ $unwind: '$reportDetails' }",
            "{ $match: { 'reportDetails.report_type': 'Industry' } }",
            "{ $project: { _id: '$reportDetails._id', sector: '$reportDetails.sector', report_title: '$reportDetails.report_title', securities_firm: '$reportDetails.securities_firm', pdf_link: '$reportDetails.pdf_link', report_date: '$reportDetails.report_date', report_id: '$reportDetails.report_id', report_type: '$reportDetails.report_type' } }"
    })
    Slice<IndustryReport> findIndustryReportsByUserId(String userId, Pageable pageable);
}
