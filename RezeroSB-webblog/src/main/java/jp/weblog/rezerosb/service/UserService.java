package jp.weblog.rezerosb.service;

import jp.weblog.rezerosb.model.User;

public interface UserService {
    User findByUserName(String username);

    void register(String username, String password);
}
