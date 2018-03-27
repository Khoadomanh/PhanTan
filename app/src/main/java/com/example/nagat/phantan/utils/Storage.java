package com.example.nagat.phantan.utils;


import com.example.nagat.phantan.model.User;

/**
 * Class dung de luu user da dang nhap len bo nho cua apps
 */

public class Storage {
    private static Storage storage;
    private int mUserId;
    private boolean firstTimeRun;
    public final static int NON_USERID = 0;
    public static final String KEY_USER_ID = "user_id";

    /**
     * Current user info
     */
    private User mUser;




    public static Storage getInstance() {
        if (storage == null) {
            storage = new Storage();
        }
        return storage;
    }



    public void clear() {
        mUser = null;
        mUserId = NON_USERID;
        firstTimeRun = false;
    }

    /**
     * Save user id
     *
     * @param
     * @param userId
     */
    public void setUserId(int userId) {
        mUserId = userId;
        SharedPrefs.getInstance().put(KEY_USER_ID,userId);
    }

    /**
     * Get user's id
     *
     * @param
     * @return
     */
    public int getUserId() {
        if (mUserId == NON_USERID) {
            mUserId = SharedPrefs.getInstance().get(KEY_USER_ID,Integer.class);
        }
        return mUserId;
    }

    /**
     * Get user info
     *
     * @return instance of user
     */
    public User getUser() {
        return mUser;
    }

    /**
     * Save user info
     *
     * @param user
     */
    public void setUser(User user) {
        mUser = user;
    }


}
