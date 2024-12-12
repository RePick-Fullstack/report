package repick.report.service;

import org.bson.json.JsonObject;
import org.springframework.data.domain.Page;
import repick.report.domain.CompanyReport;
import repick.report.domain.IndustryReport;

import java.util.List;

public interface ReportService {
    Page<CompanyReport> getLastTenReports(int page, int size);
    Page<IndustryReport> getIndustryReports(int page, int size);
}
