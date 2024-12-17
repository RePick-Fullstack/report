package repick.report.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Slice;
import repick.report.domain.CompanyReport;
import repick.report.domain.IndustryReport;
import repick.report.domain.User;

import java.util.List;

public interface UserService {
    Long userIdFromToken(String bearerToken);
    User getUserByUserId(Long id);
    Page<String> getPreferredCompaniesByUserId(Long id, int page, int size);
    Page<String> getPreferredIndustriesByUserId(Long id, int page, int size);
    Slice<CompanyReport> getCompanyReportsByUserId(Long id, int page, int size);
    Slice<IndustryReport> getIndustryReportsByUserId(Long id, int page, int size);
    Slice<CompanyReport> getBookmarkCompanyReportsByUserId(Long id, int page, int size);
    Slice<IndustryReport> getBookmarkIndustryReportsByUserId(Long id, int page, int size);

}
