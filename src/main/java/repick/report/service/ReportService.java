package repick.report.service;

import org.springframework.data.domain.Page;
import repick.report.domain.CompanyReport;
import repick.report.domain.IndustryReport;
import repick.report.domain.User;

public interface ReportService {
    Page<CompanyReport> getLastTenReports(int page, int size);
    Page<IndustryReport> getIndustryReports(int page, int size);
    Page<IndustryReport> getViewIndustryReports(User user , int page, int size);
    Page<CompanyReport> getViewCompanyReports(User user , int page, int size);

    Page<IndustryReport> getKeywordIndustryReports(String keyword, int page, int size);

    Page<CompanyReport> getKeywordCompanyReports(String keyword, int page, int size);
}
