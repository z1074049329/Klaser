package com.app.klaser.login;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.app.klaser.reset.ForgetPasswordActivity;
import com.app.klaser.home.activity.HomeActivity;
import com.app.klaser.R;

public class LoginActivity extends Activity implements View.OnClickListener{
    private EditText phoneNumber;
    private EditText passWord;
    private Button loginButton;
    private Button signUpButton;
    private Button forgetButton;
    private Intent intent;
    private final Context loginContext = this;

    // 调用Actvity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }
    private void forgetPassword() {
        // 跳转到忘记密码界面
        intent = new Intent(loginContext, ForgetPasswordActivity.class);
        startActivity(intent);
    }

    private void signUp() {
        // 跳转到注册界面
        intent = new Intent(loginContext, SignUpActivity.class);
        startActivity(intent);
    }

    private void login() {
        // 获取用户名和密码
        String strPhoneNumber = phoneNumber.getText().toString().trim();
        String strPassWord = passWord.getText().toString().trim();
        // 判断如果用户名为"123456"密码为"123456"则登录成功
        if (strPhoneNumber.equals("123456") && strPassWord.equals("123456")) {
            // 跳转到注册界面
            intent = new Intent(loginContext, HomeActivity.class);
            startActivity(intent);
            LoginActivity.this.finish();
        } else {
            Toast.makeText(loginContext, "请输入正确的用户名或密码！", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 关联用户名、密码和登录、注册按钮
     */
    private void initView() {
        phoneNumber = (EditText) this.findViewById(R.id.login_phoneNumber_Edit);
        passWord = (EditText) this.findViewById(R.id.login_password_edit);
        loginButton = (Button) this.findViewById(R.id.login_login_btn);
        signUpButton = (Button) this.findViewById(R.id.login_sign_btn);
        forgetButton = (Button) this.findViewById(R.id.login_forget_password_btn);
        loginButton.setOnClickListener(this);
        signUpButton.setOnClickListener(this);
        forgetButton.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_login_btn:
                Log.e("zrq", "onClick: 执行了");
                login();
                break;
            case R.id.login_sign_btn:
                signUp();
                break;
            case R.id.login_forget_password_btn:
                forgetPassword();
        }
    }
}
