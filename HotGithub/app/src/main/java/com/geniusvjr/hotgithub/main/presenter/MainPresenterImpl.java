package com.geniusvjr.hotgithub.main.presenter;

import com.geniusvjr.hotgithub.R;
import com.geniusvjr.hotgithub.main.MainView;

/**
 * Created by dream on 16/6/29.
 */
public class MainPresenterImpl implements MainPresenter{

    private MainView mMainView;

    public MainPresenterImpl(MainView mainView){
        this.mMainView = mainView;
    }


    @Override
    public void switchNavigation(int id) {
        switch (id) {
            case R.id.action_hotgit:
                mMainView.switch2Hotgit();
                break;
            case R.id.action_favos:
                mMainView.switch2Favorites();
                break;
            case R.id.action_custom:
                mMainView.switch2Custom();
                break;
            case R.id.action_settings:
                mMainView.switch2Settings();
                break;
            default:
                mMainView.switch2About();
                break;
        }
    }
}
