package com.skteam.unitopper.loginregister;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.skteam.unitopper.R;
import com.skteam.unitopper.common.Common;
import com.skteam.unitopper.retrofit.RetrofitApi;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements ForgetPasswordBottomSheet.BottomSheetListner {
    private static final String TAG = "LoginActivity";
    private RelativeLayout rlyt_signup, rlyt_login;
    private LinearLayout linearLayout_login, linearLayout_signup;
    private Button signUp_btn, login_btn;
    private TextView forget_password_tv;
    private CheckBox check_box_agree;
    private Spinner spinner_colleges, spinner_university;
    private TextInputEditText et_register_confirm_password, et_register_password, et_register_mobile_number,
            et_register_email, et_register_full_name;
    private TextInputEditText etNumberLogin, etPasswordLogin;
    private ProgressBar progress_bar_login;

    String str_full_name, str_email, str_mobile_number, str_password, str_confirm_password, str_university, str_college, str_device_id, str_reg_date;
    String str_mobile_number_login, str_password_login;
    private RetrofitApi mService;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();
        initActions();


    }

    /* =====================All Views ids initialize here ======================= */
    private void initViews() {
        mService = Common.getAPI();
        rlyt_signup = findViewById(R.id.rlyt_signup);
        rlyt_login = findViewById(R.id.rlyt_login);
        linearLayout_login = findViewById(R.id.linearLayout_login);
        linearLayout_signup = findViewById(R.id.linearLayout_signup);
        signUp_btn = findViewById(R.id.signUp_btn);
        login_btn = findViewById(R.id.login_btn);
        forget_password_tv = findViewById(R.id.forget_password_tv);
        check_box_agree = findViewById(R.id.check_box_agree);
        spinner_colleges = findViewById(R.id.spinner_colleges);
        spinner_university = findViewById(R.id.spinner_university);
        et_register_confirm_password = findViewById(R.id.et_register_confirm_password);
        et_register_password = findViewById(R.id.et_register_password);
        et_register_mobile_number = findViewById(R.id.et_register_mobile_number);
        et_register_email = findViewById(R.id.et_register_email);
        et_register_full_name = findViewById(R.id.et_register_full_name);
        progressBar = findViewById(R.id.progress_bar);
        etNumberLogin = findViewById(R.id.etNumberLogin);
        etPasswordLogin = findViewById(R.id.etPasswordLogin);
        progress_bar_login = findViewById(R.id.progress_bar_login);
    }


    /* ============================ All actions on ids ================= */
    private void initActions() {
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
        forget_password_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openBottomSheetDialog();
            }
        });
        signUp_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAllFieldsValidation();
            }
        });
        spinner_university.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 1:
                        populateCollegeList(getResources().getStringArray(R.array.college_name_from_rahuri));
                        break;
                    case 2:
                        populateCollegeList(getResources().getStringArray(R.array.college_names_from_akola));
                        break;
                    case 3:
                        populateCollegeList(getResources().getStringArray(R.array.college_names_from_parbhani));
                        break;
                    case 4:
                        populateCollegeList(getResources().getStringArray(R.array.college_names_from_dapoli));
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAllLoginFields();
            }
        });
    }


    /* ========================= Visible  Login Layout ,Gone Signup Layout ============== */
    private void openLoginLayout() {
        linearLayout_login.setVisibility(View.VISIBLE);
        linearLayout_signup.setVisibility(View.GONE);
        rlyt_login.setVisibility(View.GONE);
        rlyt_signup.setVisibility(View.VISIBLE);
    }


    /* ========================= Visible  Signup Layout, Gone Login Layout ============== */
    private void openSignUpLayout() {
        linearLayout_login.setVisibility(View.GONE);
        linearLayout_signup.setVisibility(View.VISIBLE);
        rlyt_login.setVisibility(View.VISIBLE);
        rlyt_signup.setVisibility(View.GONE);
    }


    /* ================Open Otp Activty for verification Register Process =============*/
    private void openOtpActivty() {
        Intent intent = new Intent(LoginActivity.this, OtpActivity.class);
        startActivity(intent);
    }


    /*==================Open forget password bottom sheet dialog for getting registered number====================*/
    private void openBottomSheetDialog() {
        ForgetPasswordBottomSheet bottomSheet = new ForgetPasswordBottomSheet();
        bottomSheet.show(getSupportFragmentManager(), "forgetpasswordbottomsheet");
    }


    /*===================Bottomsheetlistner interface method on continue button clicked from bottomsheet======================*/
    @Override
    public void onButtonClicked() {
        Intent intent = new Intent(LoginActivity.this, OtpActivity.class);
        startActivity(intent);
    }


    /*====================== Check All Fields and get string values after clicking signup button =========================*/
    private void checkAllFieldsValidation() {
        str_full_name = Objects.requireNonNull(et_register_full_name.getText()).toString().trim();
        str_email = Objects.requireNonNull(et_register_email.getText()).toString().trim();
        str_mobile_number = Objects.requireNonNull(et_register_mobile_number.getText()).toString().trim();
        str_password = Objects.requireNonNull(et_register_password.getText()).toString().trim();
        str_confirm_password = Objects.requireNonNull(et_register_confirm_password.getText()).toString().trim();
        str_university = Objects.requireNonNull(spinner_university.getSelectedItem(), "please select un").toString().trim();
        str_college = Objects.requireNonNull(spinner_colleges.getSelectedItem(), "please select college").toString().trim();
        str_reg_date = getCurrentDateTime();
        str_device_id = getDeviceId();


        if (TextUtils.isEmpty(str_full_name)) {
            et_register_full_name.setError("please enter full name");
            et_register_full_name.requestFocus();
        } else if (TextUtils.isEmpty(str_email)) {
            et_register_email.setError("please enter email");
            et_register_email.requestFocus();
        } else if (TextUtils.isEmpty(str_mobile_number)) {
            et_register_mobile_number.setError("please enter mobile number");
            et_register_mobile_number.requestFocus();
        } else if (str_mobile_number.length() != 10) {
            et_register_mobile_number.setError("please enter valid 10 digit mobile number");
            et_register_mobile_number.requestFocus();
        } else if (TextUtils.isEmpty(str_password)) {
            Toast.makeText(this, "please enter password", Toast.LENGTH_SHORT).show();
        } else if (str_password.length() < 6) {
            Toast.makeText(this, "password length must be at least 6 digit long", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(str_confirm_password)) {
            Toast.makeText(this, "please enter confirm password", Toast.LENGTH_SHORT).show();
        } else if (!str_confirm_password.equals(str_password)) {
            Toast.makeText(this, "password doesn't match", Toast.LENGTH_SHORT).show();
        } else if (str_university.equals("University")) {
            Toast.makeText(this, "please select university", Toast.LENGTH_SHORT).show();
        } else if (str_college.equals("College")) {
            Toast.makeText(this, "please select college", Toast.LENGTH_SHORT).show();
        } else if (!check_box_agree.isChecked()) {
            Toast.makeText(this, "please accept term and condition", Toast.LENGTH_SHORT).show();
        } else if (str_device_id == null) {
            str_device_id = "Null";
        } else if (str_reg_date == null) {
            str_reg_date = "Null";
        } else {
            checkIfUserAlreadyExistInDatabase();
        }
    }


    /*========================= Checking  if user email or number already exist or not in databse ================ */
    private void checkIfUserAlreadyExistInDatabase() {
        setRegisterProgressBarVisible();
        mService.checkIfUserAlreadyExist(str_mobile_number, str_email).enqueue(new Callback<User>() {
            @Override
            public void onResponse(@NonNull Call<User> call, @NonNull Response<User> response) {
                if (response.isSuccessful()) {
                    try {
                        assert response.body() != null;
                        if (TextUtils.isEmpty(response.body().getError_msg())) {
                            registerNewUser();
                        } else {
                            Log.d(TAG, "onResponse: " + response.body().getError_msg());
                            Toast.makeText(LoginActivity.this, response.body().getError_msg(), Toast.LENGTH_SHORT).show();
                            setRegisterProgressBarInVisible();
                        }
                    } catch (Exception e) {
                        Log.d(TAG, "onResponse: OnException " + e.getMessage());

                    }

                }
            }

            @Override
            public void onFailure(@NonNull Call<User> call, @NonNull Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
                setRegisterProgressBarInVisible();
            }
        });
    }


    /*===========================Retrofit Api:: Register new user store data in mysql database ===================*/
    private void registerNewUser() {
        setRegisterProgressBarVisible();
        Log.d(TAG, "registerNewUser: " + str_device_id + str_reg_date);
        mService.registerNewUser(str_full_name, str_email, str_mobile_number, str_password, str_college, str_university, str_device_id, str_reg_date).enqueue(new Callback<User>() {
            @Override
            public void onResponse(@NonNull Call<User> call, @NonNull Response<User> response) {
                if (response.isSuccessful()) {
                    try {
                        assert response.body() != null;
                        if (TextUtils.isEmpty(response.body().getError_msg())) {
                            Toast.makeText(LoginActivity.this, "User registered Successfully", Toast.LENGTH_SHORT).show();
                            setRegisterProgressBarInVisible();
                        } else {
                            Toast.makeText(LoginActivity.this, response.body().getError_msg(), Toast.LENGTH_SHORT).show();
                            setRegisterProgressBarInVisible();
                        }
                    } catch (NullPointerException e) {
                        Log.d(TAG, "onResponse: " + e.getMessage());
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<User> call, @NonNull Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
                setRegisterProgressBarInVisible();
            }
        });
    }


    /*===================== Check All field for login validation========================*/
    private void checkAllLoginFields() {
        str_mobile_number_login = Objects.requireNonNull(etNumberLogin.getText()).toString().trim();
        str_password_login = Objects.requireNonNull(etPasswordLogin.getText()).toString();

        if (TextUtils.isEmpty(str_mobile_number_login)) {
            etNumberLogin.setError("please enter mobile number");
            etNumberLogin.requestFocus();
        } else if (str_mobile_number_login.length() != 10) {
            etNumberLogin.setError("please enter valid 10 digit mobile number");
            etNumberLogin.requestFocus();
        } else if (TextUtils.isEmpty(str_password_login)) {
            Toast.makeText(this, "please enter password", Toast.LENGTH_SHORT).show();
        } else {
            loginInUser();
        }
    }


    /*=============================Retrofit Api Login User===================*/
    private void loginInUser() {
        setLoginProgressBarVisible();
        mService.userLogin(str_mobile_number_login, str_password_login).enqueue(new Callback<User>() {
            @Override
            public void onResponse(@NonNull Call<User> call, @NonNull Response<User> response) {
                if (response.isSuccessful()) {
                    try {
                        assert response.body() != null;
                        if (TextUtils.isEmpty(response.body().getError_msg())) {
                            Toast.makeText(LoginActivity.this, "Login Success", Toast.LENGTH_SHORT).show();
                            setLoginProgressBarInVisible();
                        } else {
                            setLoginProgressBarInVisible();
                            Toast.makeText(LoginActivity.this, response.body().getError_msg(), Toast.LENGTH_SHORT).show();
                        }
                    } catch (NullPointerException e) {
                        Log.d(TAG, "onResponse: " + e.getMessage());
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<User> call, @NonNull Throwable t) {
                Log.d(TAG, "onResponse: " + t.getMessage());
                setLoginProgressBarInVisible();
            }
        });
    }

    private String getCurrentDateTime() {
        return new SimpleDateFormat("yyyy-MM-dd , HH:mm:ss", Locale.getDefault()).format(new Date());
    }

    @SuppressLint("HardwareIds")
    private String getDeviceId() {
        return Settings.Secure.getString(this.getContentResolver(),
                Settings.Secure.ANDROID_ID);

    }


    /*===================Progress Bar Visibilty ==================*/
    private void setRegisterProgressBarVisible() {
        progressBar.setVisibility(View.VISIBLE);
        signUp_btn.setVisibility(View.GONE);
    }

    private void setRegisterProgressBarInVisible() {
        progressBar.setVisibility(View.GONE);
        signUp_btn.setVisibility(View.VISIBLE);
    }

    private void setLoginProgressBarVisible() {
        progress_bar_login.setVisibility(View.VISIBLE);
        login_btn.setVisibility(View.GONE);
    }

    private void setLoginProgressBarInVisible() {
        progress_bar_login.setVisibility(View.GONE);
        login_btn.setVisibility(View.VISIBLE);
    }
    /*===================Progress Bar Visibilty ==================*/


    private void populateCollegeList(String[] listArrayString) {
        List<String> list = new ArrayList<>(Arrays.asList(listArrayString));

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(LoginActivity.this, android.R.layout.simple_expandable_list_item_1, list);
        spinner_colleges.setAdapter(arrayAdapter);
    }

}
