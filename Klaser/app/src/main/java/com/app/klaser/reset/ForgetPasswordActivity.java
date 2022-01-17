package com.app.klaser.reset;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.app.klaser.R;
import com.app.klaser.login.LoginActivity;

/**
 * 忘记密码
 */
public class ForgetPasswordActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText phoneNumberEdit;
    private EditText smsCode;
    private Button resetButton;
    private Button smsCodeBtn;
    private Toolbar toolbar;
    private final Context ForgetContext = this;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgetpassword);
        initView();

    }

    private void back() {
        toolbar.setNavigationOnClickListener(view -> {
            Intent intent = new Intent(ForgetContext, LoginActivity.class);
            startActivity(intent);
            ForgetPasswordActivity.this.finish();
        });
    }

    private void initView() {
        phoneNumberEdit = (EditText) findViewById(R.id.forget_phoneNumber_edit);
        smsCode = (EditText) findViewById(R.id.forget_sms_code_edit);
        smsCodeBtn = (Button) findViewById(R.id.forget_send_sms_code_btn);
        resetButton = (Button) findViewById(R.id.forget_forget_reset_btn);
        toolbar = (Toolbar) findViewById(R.id.forget_tb);
        smsCodeBtn.setOnClickListener(this);
        resetButton.setOnClickListener(this);
        toolbar.setOnClickListener(this);
    }

    private void resetPassword(){
        String strPhoneNumber = phoneNumberEdit.getText().toString();
        String strSmsCode = smsCode.getText().toString();
//                if (TextUtils.isEmpty(strPhoneNumber)) {
//                    Toast.makeText(ForgetContext, "手机号不能为空", Toast.LENGTH_SHORT).show();
//                }else if (TextUtils.isEmpty(strSmsCode)) {
//                    Toast.makeText(ForgetContext, "请输入验证码！", Toast.LENGTH_SHORT).show();
//                } else {
//
//                }
        // 跳转到重置密码界面
        Intent intent = new Intent(ForgetContext, ResetPasswordActivity.class);
        startActivity(intent);
        ForgetPasswordActivity.this.finish();
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.forget_send_sms_code_btn:
                sendSmsCode();
                break;
            case R.id.forget_forget_reset_btn:
                resetPassword();
                break;
            case R.id.forget_tb:
                back();
                break;
        }
    }

    private void sendSmsCode() {
        //发送验证码
        Toast.makeText(ForgetContext, "验证码已发送", Toast.LENGTH_SHORT).show();
    }
}
