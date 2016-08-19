package com.example.tacademy.sampleopenssl;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

public class MainActivity extends AppCompatActivity {
    LoginButton loginButton;
    CallbackManager callbackManager;//로그이 함수 갖고 올꺼면 로그인 콜백 매니져 함수 만들어줌


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        callbackManager = CallbackManager.Factory.create();
        loginButton = (LoginButton)findViewById(R.id.login_button);
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() { //(콜백매니져, 페이스북 콜백)

        @Override
        public void onSuccess(LoginResult loginResult) {
            Toast.makeText(MainActivity.this, "facebook login sucess", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCancel() {

        }

        @Override
        public void onError(FacebookException error) {

        }
    });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    callbackManager.onActivityResult(requestCode, resultCode, data); // 중요!!
        //페이스북에 로그인 성공한 정보들이 들어가 있기에 이 값을 얻어와야
        //성공하면 콜백 onSuccess 를 호출한다 .

    }
}
