package com.fullness.ec.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.firewall.DefaultHttpFirewall;

import jakarta.servlet.DispatcherType;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

  @Autowired private AccountUserDetailsService service;
  @Autowired private PasswordEncoder encoder;
  /**
   * Spring Securityの認証時に使うサービスとパスワードエンコーダーを登録
   * 今回はDIしている`AccountUserDetailsService`クラスと`PasswordEncoder`クラスを登録
   * @param userDetailsService
   * @param passwordEncoder
   */
  @Bean
  public AuthenticationManager authenticationManager(UserDetailsService userDetailsService,PasswordEncoder passwordEncoder) {
    DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
    authenticationProvider.setUserDetailsService(service);
    authenticationProvider.setPasswordEncoder(encoder);
    return new ProviderManager(authenticationProvider);
  }
  
   /**
   * Spring Securityカスタマイズ
   * 今回はpublic配下のURLは認証対象外とすることと、デフォルトのHttpFirewallを使用することを設定
   */
  @Bean
  public WebSecurityCustomizer webCustomizer() {
    DefaultHttpFirewall firewall = new DefaultHttpFirewall();
    return (web) -> web
      .httpFirewall(firewall)
      .ignoring().requestMatchers("/public/**");
  }
  /**
   * Spring Securityの設定
   * 今回はログイン画面、ログアウト画面、認証対象外のURLを設定
   * @param http
   * @return
   * @throws Exception
   */
  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    // ログイン設定
    http.formLogin(login -> login
      .loginProcessingUrl("/auth") // 認証処理を起動するURL
      .loginPage("/admin/login") // ログイン画面のURL
      .usernameParameter("username") // 認証リクエストのユーザーパラメーターのキー名の指定
      .passwordParameter("password") // 認証リクエストのパスワードパスワードのキー名の指定
      .defaultSuccessUrl("/menu") // ログイン成功時のURL
      .failureUrl("/admin/login") // ログイン失敗時のURL
      .permitAll() // ログイン画面は認証対象外
    );
    
    // ログアウト設定
    http.logout(logout -> logout
      .logoutUrl("/logout") // ログアウト処理をするURL
      .logoutSuccessUrl("/admin/login") // ログアウト成功時のURL
      .invalidateHttpSession(true) // ログアウト時はセッションを破棄する
      .deleteCookies("JSESSIONID") // ログアウト時はクッキーを削除する
      .clearAuthentication(true) // ログアウト時は認証情報をクリアする
      .permitAll()
    );
    // 認証設定
    http.authorizeHttpRequests(authz -> authz
      .dispatcherTypeMatchers(DispatcherType.ERROR).permitAll() // エラー画面は認証対象外
      .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll() // 静的リソースは認証対象外
      .requestMatchers("/admin/login").permitAll() // ログイン画面は認証対象外
      .requestMatchers("/menu","/logout","/session/**").authenticated() // 認証対象
      .anyRequest().permitAll() // その他は認証対象
      // .authenticated()
    );
    return http.build();
  }
}
