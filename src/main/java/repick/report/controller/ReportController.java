package repick.report.controller;

import lombok.RequiredArgsConstructor;
import org.bson.json.JsonObject;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import repick.report.domain.CompanyReport;
import repick.report.domain.IndustryReport;
import repick.report.domain.User;
import repick.report.service.ReportService;
import repick.report.service.UserService;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/reports")
@RequiredArgsConstructor
public class ReportController {
    private final ReportService reportService;
    private final UserService userService;

    @GetMapping("/company")
    public Page<CompanyReport> getLastTenReports(@RequestParam int page, @RequestParam int size) {
        return reportService.getLastTenReports(page, size);
    }

    @GetMapping("/industry")
    public Page<IndustryReport> getIndustryReports(@RequestParam int page, @RequestParam int size) {
        return reportService.getIndustryReports(page, size);
    }

    @GetMapping("/user")
    public User getUser(
            @RequestHeader String Authorization
    ) {
        Long id = userService.userIdFromToken(Authorization);
        return userService.getUserByUserId(id);
    }

    @GetMapping("/user/viewcompanyreports")
    public Page<CompanyReport> getViewCompanyReports(
            @RequestHeader String Authorization,
            @RequestParam int page,
            @RequestParam int size
    ) {
        Long id = userService.userIdFromToken(Authorization);
        return userService.getCompanyReportsByUserId(id, page, size);
    }

    @GetMapping("/user/viewindustryreports")
    public Page<IndustryReport> getViewIndustryReports(
            @RequestHeader String Authorization,
            @RequestParam int page,
            @RequestParam int size
    ) {
        Long id = userService.userIdFromToken(Authorization);
        return userService.getIndustryReportsByUserId(id, page, size);
    }

}
