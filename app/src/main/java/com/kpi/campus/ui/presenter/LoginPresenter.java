package com.kpi.campus.ui.presenter;

import android.os.Bundle;

import com.kpi.campus.Config;
import com.kpi.campus.model.pojo.Token;
import com.kpi.campus.ui.Navigator;

import javax.inject.Inject;

/**
 * LoginPresenter created to manage LoginActivity.
 *
 * Created by Administrator on 29.01.2016.
 */
public class LoginPresenter extends BasePresenter {

    private IView mView;
    private Navigator mNavigator;

    @Inject
    public LoginPresenter(Navigator navigator) {
        mNavigator = navigator;
    }

    public void setView(IView view) {
        mView = view;
    }

    @Override
    public void initializeViewComponent() {
    }

    public void login(String login, String password) {
        mView.showLoginProgressDialog();
        mView.showLoginButton(false);
        validateUser(login, password);
    }

    private void validateUser(String login, String password) {
        Bundle args = new Bundle();
        args.putString(Config.KEY_LOGIN, login);
        args.putString(Config.KEY_PASSWORD, password);
        mView.initLoader(args);
    }

    public void setLoaderResult(Token token) {
        mView.dismissProgressDialog();
        mView.showLoginButton(true);
        if(token != null) {
            mNavigator.startMainActivity();
        } else {
            mView.onLoginFailed();
        }
    }

    public interface IView {
        void showLoginProgressDialog();
        void dismissProgressDialog();
        void showLoginButton(boolean shouldShow);
        void onLoginFailed();
        void initLoader(Bundle args);
    }
}
