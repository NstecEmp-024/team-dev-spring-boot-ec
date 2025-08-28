package com.fullness.ec.security;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fullness.ec.entity.Account;
import com.fullness.ec.entity.AccountUserDetails;
import com.fullness.ec.repository.AccountRepository;

@Service
public class AccountUserDetailsService implements UserDetailsService {
  @Autowired 
  private AccountRepository repository;
  /**
   * 引数のユーザー名でユーザーを検索
   * ユーザー名からユーザー情報を取得する
   * @param username ユーザー名
   * @return ユーザー情報
   * @throws UsernameNotFoundException ユーザー名が見つからない場合
   */
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Account account = repository.selectByUserName(username);
    if (account == null) {//該当ユーザーなし
        // UaernameNotFoundExceptionをスローして
        // Spring securityに通知
      throw new UsernameNotFoundException("ユーザー名が見つかりません: " + username);
    }
    // テスト
           System.out.println("✅ ユーザー取得成功: " + account.getName());
        System.out.println("🔑 ハッシュ化されたパスワード: " + account.getPassword());
    // AccountデータからAccountUserDetailsを作成する
    Collection<GrantedAuthority> authorities = getAuthorities(account);
    // Spring scurityに承認データをわたす。
    return new AccountUserDetails(account, authorities);
  }

    /**
   * ユーザーアカウント権限情報を戻す
   * @param account ユーザーアカウント情報
   * @return ユーザーアカウント権限情報
   */
  private Collection<GrantedAuthority> getAuthorities(Account account) {
    return AuthorityUtils.createAuthorityList("ROLE_USER");
   }
  }

    // switch (account.getRole().getEmpName()) { // .getRole()
    //   case "admin":
    //     return AuthorityUtils.createAuthorityList(
    //       "ROLE_ADMIN",
    //       "ROLE_USER",
    //       "ROLE_GUEST"
    //     );
    //   case "user":
    //     return AuthorityUtils.createAuthorityList(
    //       "ROLE_USER",
    //       "ROLE_GUEST"
    //     );
    //   default:
    //     return AuthorityUtils.createAuthorityList("ROLE_GUEST");
    // }
  