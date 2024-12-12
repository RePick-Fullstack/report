package repick.report.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import repick.report.domain.CompanyReport;
import repick.report.domain.IndustryReport;
import repick.report.domain.User;
import repick.report.repository.CompanyReportRepository;
import repick.report.repository.IndustryReportRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {

    private final CompanyReportRepository companyReportRepository;
    private final IndustryReportRepository industryReportRepository;

    @Override
    public Page<CompanyReport> getLastTenReports(int page, int size) {
        return companyReportRepository.findTop10ByReportTypeOrderByReportDateDesc(PageRequest.of(page, size));
    }

    @Override
    public Page<IndustryReport> getIndustryReports(int page, int size) {
        return industryReportRepository.findAllIndustry(PageRequest.of(page, size));
    }

    @Override
    public Page<IndustryReport> getViewIndustryReports(User user , int page, int size) {
        return industryReportRepository.findReportId(user.getReports(),PageRequest.of(page, size));
    }

    @Override
    public Page<CompanyReport> getViewCompanyReports(User user, int page, int size) {
        return companyReportRepository.findReportId(user.getReports(),PageRequest.of(page, size));
    }
}
