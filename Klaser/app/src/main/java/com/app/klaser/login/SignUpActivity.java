package com.app.klaser.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.app.klaser.R;

/**
 * 注册界面
 */
public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText phoneNumber;
    private EditText passWord;
    private EditText smsCode;
    private Button sendSmsCodeButton;
    private Button signUpButton;
    private Toolbar toolbar;
    private final Context signUpContext = this;

    // 调用Actvity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //关联activity_register.xml
        setContentView(R.layout.activity_sign_up);
        initView();
    }

    private void initView() {
        // 关联用户名、密码、确认密码、邮箱和注册、返回登录按钮
        phoneNumber = this.findViewById(R.id.sign_phoneNumber_edit);
        passWord = this.findViewById(R.id.sign_password_edit);
        smsCode = this.findViewById(R.id.sign_sms_code_edit);
        sendSmsCodeButton = this.findViewById(R.id.sign_send_sms_code_btn);
        signUpButton = this.findViewById(R.id.sign_sign_up_btn);
        toolbar = findViewById(R.id.sign_tb);
        toolbar.setOnClickListener(this);
        signUpButton.setOnClickListener(this);
        sendSmsCodeButton.setOnClickListener(this);
    }

    private void back() {
        //跳转到登录页面
        toolbar.setNavigationOnClickListener(view -> {
            Intent intent = new Intent(signUpContext, LoginActivity.class);
            startActivity(intent);
            SignUpActivity.this.finish();
        });
    }

    private void signUp() {
        // 立即注册按钮监听器
        String strPhoneNumber = phoneNumber.getText().toString().trim();
        String strPassWord = passWord.getText().toString().trim();
        String strSmsCode = smsCode.getText().toString().trim();

//        if (TextUtils.isEmpty(strPhoneNumber)) {
//            Toast.makeText(signUpContext, "手机号不能为空！", Toast.LENGTH_SHORT).show();
//            phoneNumber.setFocusable(true);
//        } else if (strPassWord.length() < 6 || strPassWord.length() > 12) {
//            Toast.makeText(signUpContext, "请输入大于6位的密码！", Toast.LENGTH_SHORT).show();
//        } else if (TextUtils.isEmpty(strSmsCode)) {
//            Toast.makeText(signUpContext, "请输入验证码！", Toast.LENGTH_SHORT).show();
//        } else {
//
//        }
        Toast.makeText(signUpContext, "注册成功！", Toast.LENGTH_SHORT).show();
        // 跳转到登录界面
        Intent intent = new Intent(signUpContext, LoginActivity.class);
        startActivity(intent);
    }

    private void sendSms() {
        //发送短信
        Toast.makeText(signUpContext, "验证码已发送", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sign_send_sms_code_btn:
                sendSms();
                break;
            case R.id.sign_sign_up_btn:
                signUp();
                break;
            case R.id.sign_tb:
                back();
                break;
        }
    }
}
