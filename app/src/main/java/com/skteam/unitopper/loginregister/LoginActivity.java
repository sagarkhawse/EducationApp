package com.skteam.unitopper.loginregister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.skteam.unitopper.R;

public class LoginActivity extends AppCompatActivity {
    private RelativeLayout rlyt_signup,rlyt_login;
    private LinearLayout linearLayout_login, linearLayout_signup;
    private Button signUp_btn, login_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();
        initActions();
    }

    /* =====================All Views ids initialize here ======================= */
    private void initViews() {
        rlyt_signup = findViewById(R.id.rlyt_signup);
        rlyt_login = findViewById(R.id.rlyt_login);
        linearLayout_login = findViewById(R.id.linearLayout_login);
        linearLayout_signup = findViewById(R.id.linearLayout_signup);
        signUp_btn = findViewById(R.id.signUp_btn);
        login_btn = findViewById(R.id.login_btn);
    }



    /* ============================ All actions on ids ================= */
    private void initActions(){
        rlyt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLoginLayout();
            }
        });
        rlyt_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSignUpLayout();
            }
        });
        signUp_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openOtpActivty();
            }
        });
    }



    /* ========================= Visible  Login Layout Gone Signup Layout ============== */
    private void openLoginLayout() {
    linearLayout_login.setVisibility(View.VISIBLE);
    linearLayout_signup.setVisibility(View.GONE);
    rlyt_login.setVisibility(View.GONE);
    rlyt_signup.setVisibility(View.VISIBLE);
    }



    /* ========================= Visible  Signup Layout Gone Login Layout ============== */
    private void openSignUpLayout() {
        linearLayout_login.setVisibility(View.GONE);
        linearLayout_signup.setVisibility(View.VISIBLE);
        rlyt_login.setVisibility(View.VISIBLE);
        rlyt_signup.setVisibility(View.GONE);
    }


    /* ================Open Otp Activty for verification Register Process =============*/
    private void openOtpActivty() {
        Intent intent = new Intent(LoginActivity.this,OtpActivity.class);
        startActivity(intent);
    }
}
