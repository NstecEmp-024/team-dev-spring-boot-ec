package com.fullness.ec.entity;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class AccountUserDetails implements UserDetails {
      /** ユーザーアカウント情報 */
    private Account account;
    /** ユーザーアカウント権限情報 */
    private Collection<GrantedAuthority> authorities;
    /** 
     * コンストラクタ
     * @param account ユーザーアカウント情報
     * @param authorities ユーザーアカウント権限情報
     */
    public AccountUserDetails(Account account, Collection<GrantedAuthority> authorities) {
        this.account = account;
        this.authorities = authorities;
    }
    /** 
     * ユーザーアカウント権限情報を戻す
     * @return ユーザーアカウント権限情報
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
        // return authorities;
    }
    /** 
     * ユーザーアカウントのパスワードを戻す
     * @return ユーザーアカウントのパスワード
     */
    @Override
    public String getPassword() { return account.getPassword(); }
    /** 
     * ユーザーアカウントのユーザー名を戻す
     * @return ユーザーアカウントのユーザー名
     */
    @Override
    public String getUsername() { return account.getName(); }
    /** 
     * アカウント自体の有効期限を戻す
     * @return アカウント自体の有効期限
     */
    @Override
    public boolean isAccountNonExpired() { return true; }
    /** 
     * アカウント自体のロックを戻す
     * @return アカウント自体のロック
     */
    @Override
    public boolean isAccountNonLocked() { return true; }
    /** 
     * 認証時の有効期限を戻す
     * @return 認証時の有効期限
     */
    @Override
    public boolean isCredentialsNonExpired() { return true; }
    /** 
     * アカウントを有効にする
     * @return アカウントを有効にする
     */
    @Override
    public boolean isEnabled() { return true; }
}

