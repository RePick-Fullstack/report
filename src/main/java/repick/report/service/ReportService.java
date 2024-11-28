package repick.report.service;

import repick.report.domain.Report;

import java.util.List;

public interface ReportService {
    List<Report> getLastTenReports();
}
