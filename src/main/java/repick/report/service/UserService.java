package repick.report.service;


import org.springframework.data.domain.Page;
import repick.report.domain.CompanyReport;
import repick.report.domain.IndustryReport;
import repick.report.domain.User;

import java.util.List;

public interface UserService {
    Long userIdFromToken(String bearerToken);
    User getUserByUserId(Long id);
    Page<CompanyReport> getCompanyReportsByUserId(Long id, int page, int size);
    Page<IndustryReport> getIndustryReportsByUserId(Long id, int page, int size);

}
