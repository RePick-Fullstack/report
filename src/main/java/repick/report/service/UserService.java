package repick.report.service;


import repick.report.domain.User;

public interface UserService {
    Long userIdFromToken(String bearerToken);
    User getUserByUserId(Long id);
}
