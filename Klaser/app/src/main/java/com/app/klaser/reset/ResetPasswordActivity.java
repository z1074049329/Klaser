package com.app.klaser.reset;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.app.klaser.R;
import com.app.klaser.login.LoginActivity;

/**
 * 重置密码
 */
public class ResetPasswordActivity extends AppCompatActivity {
    private EditText passwordEdit;
    private EditText passwordAgainEdit;
    private Button resetBtn;
    private Toolbar toolbar;
    private Context resetContext = this;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resetpassword);
        initView();
        back();
        resetSuccess();
    }

    private void initView() {
        passwordEdit = (EditText) findViewById(R.id.reset_password_edit);
        passwordAgainEdit = (EditText) findViewById(R.id.reset_password_again_edit);
        resetBtn = (Button) findViewById(R.id.reset_reset_btn);
        toolbar = (Toolbar) findViewById(R.id.reset_tb);
    }

    private void back() {
        //跳转到忘记密码页面
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(resetContext, ForgetPasswordActivity.class);
                startActivity(intent);
                ResetPasswordActivity.this.finish();
            }
        });
    }

    private void resetSuccess() {
        resetBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (check()){
                    Intent intent = new Intent(resetContext, LoginActivity.class);
                    startActivity(intent);
                    ResetPasswordActivity.this.finish();
                }
            }
        });
    }

    private boolean check() {
        boolean flag = true;
        String strPasswordEdit = passwordEdit.getText().toString().trim();
        String strPasswordAgainEdit = passwordAgainEdit.getText().toString().trim();
        if (!strPasswordEdit.equals(strPasswordAgainEdit)) {
            flag = false;
        }
        return flag;

    }
}
