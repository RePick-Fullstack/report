package repick.report.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.*;
import repick.report.domain.CompanyReport;
import repick.report.domain.IndustryReport;
import repick.report.domain.User;
import repick.report.service.ReportService;
import repick.report.service.UserService;

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

    @GetMapping("/companykeyword")
    public Page<CompanyReport> getCompanyKeyword(
            @RequestParam String keyword,
            @RequestParam int page,
            @RequestParam int size) {
        return reportService.getKeywordCompanyReports(keyword, page, size);
    }

    @GetMapping("/industrykeyword")
    public Page<IndustryReport> getIndustryKeyword(
            @RequestParam String keyword,
            @RequestParam int page,
            @RequestParam int size) {
        return reportService.getKeywordIndustryReports(keyword, page, size);
    }

    @GetMapping("/user")
    public User getUser(
            @RequestHeader String Authorization
    ) {
        Long id = userService.userIdFromToken(Authorization);
        return userService.getUserByUserId(id);
    }

    @GetMapping("/user/viewcompanyreports")
    public Slice<CompanyReport> getViewCompanyReports(
            @RequestHeader String Authorization,
            @RequestParam int page,
            @RequestParam int size
    ) {
        Long id = userService.userIdFromToken(Authorization);
        return userService.getCompanyReportsByUserId(id, page, size);
    }

    @GetMapping("/user/viewindustryreports")
    public Slice<IndustryReport> getViewIndustryReports(
            @RequestHeader String Authorization,
            @RequestParam int page,
            @RequestParam int size
    ) {
        Long id = userService.userIdFromToken(Authorization);
        return userService.getIndustryReportsByUserId(id, page, size);
    }

    @GetMapping("/user/bookmarkcompanyreports")
    public Slice<CompanyReport> getBookmarkCompanyReports(
            @RequestHeader String Authorization,
            @RequestParam int page,
            @RequestParam int size
    ) {
        Long id = userService.userIdFromToken(Authorization);
        return userService.getBookmarkCompanyReportsByUserId(id, page, size);
    }

    @GetMapping("/user/bookmarkindustryreports")
    public Slice<IndustryReport> getBookmarkIndustryReports(
            @RequestHeader String Authorization,
            @RequestParam int page,
            @RequestParam int size
    ) {
        Long id = userService.userIdFromToken(Authorization);
        return userService.getBookmarkIndustryReportsByUserId(id, page, size);
    }

    @GetMapping("/user/preferredcompanies")
    public Page<String> getPreferredCompanies(
            @RequestHeader String Authorization,
            @RequestParam int page,
            @RequestParam int size
    ) {
        Long id = userService.userIdFromToken(Authorization);
        return userService.getPreferredCompaniesByUserId(id, page, size);
    }

    @GetMapping("/user/preferredindustries")
    public Page<String> getPreferredIndustries(
            @RequestHeader String Authorization,
            @RequestParam int page,
            @RequestParam int size
    ) {
        Long id = userService.userIdFromToken(Authorization);
        return userService.getPreferredIndustriesByUserId(id, page, size);
    }
}
