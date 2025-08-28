package com.fullness.ec.form;

//import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountForm {
    @NotBlank
    @Min(50)

    private Integer empId; // 従業員ID
    @NotBlank(message = "アカウントIDを入力してください")
    private String employeeName; // 従業員名
    private String accountName; // アカウントID
    private String password; // パスワード

    // @NotBlank(message = "従業員を選択してください")
    // private String employeeId;
}
