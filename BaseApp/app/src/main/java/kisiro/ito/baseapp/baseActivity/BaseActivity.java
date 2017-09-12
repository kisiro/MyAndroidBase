package kisiro.ito.baseapp.baseActivity;

//=============================================================================================
//  名前空間    ：  kisiro.ito.baseapp.baseActivity;
//
//  クラス名    ：  BaseActivity
//
//  機能        ：  ベース画面
//
//  備考        ：
//
//  作成者      ：  [00] 2017.09.12 P.cast I.Hiroyuki
//
//  更新者      ：  [00] 2017.09.12 P.cast I.Hiroyuki
//=============================================================================================


import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Map;


import kisiro.ito.baseapp.R;

public class BaseActivity extends AppCompatActivity {

    int MY_PERMISSIONS_REQUEST = 0;
    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        pref = getSharedPreferences("dataPath", MODE_PRIVATE);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    //パーミッションの許可申請
    public void mPermission(Context context, String[] permissions) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
            requestPermissions(permissions, MY_PERMISSIONS_REQUEST);
        /*リクエストが必要なpermission一覧
            Manifest.permission_group.CALENDAR・・・ユーザーのカレンダーに関連する実行時のアクセス権のために使用します。
            Manifest.permission_group.CAMERA・・・カメラにアクセスするか、デバイスからの画像/動画をキャプチャに関連付けられたアクセス許可のために使用します。
            Manifest.permission_group.CONTACTS・・・このデバイス上の連絡先やプロフィールに関連した実行時のアクセス権のために使用します。
            Manifest.permission_group.LOCATION・・・デバイスの位置にアクセスできるようにアクセス権のために使用します。
            Manifest.permission_group.MICROPHONE・・・デバイスからマイクの音声へのアクセスに関連付けられたアクセス許可のために使用されます。
            Manifest.permission_group.PHONE・・・テレフォニー機能を関連付けられているアクセス権のために使用します。
            Manifest.permission_group.SENSORS・・・カメラにアクセスするか、デバイスからの画像/動画をキャプチャに関連付けられたアクセス許可のために使用します。
            Manifest.permission_group.SMS・・・ユーザーのSMSメッセージに関連した実行時のアクセス権のために使用します。
            Manifest.permission_group.STORAGE・・・共有外部ストレージに関連した実行時のアクセス権のために使用します。
         */
    }

    //パーミッションの確認
    public boolean mPermissonCheck(Activity activity, String permissions) {
        int permissionCheck = ContextCompat.checkSelfPermission(activity, permissions);

        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {

            // Android 6.0 のみ、該当パーミッションが許可されていない場合
            return false;
        } else {
            // 許可済みの場合、もしくはAndroid 6.0以前
            // パーミッションが必要な処理
            return true;
        }
    }

    //プリファレンスの設定
    public void mSetStringPreferences(String key, String path) {
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(key, path);
        editor.commit();
    }

    //プリファレンスの取得
    public String mGetStringPreferences(String key) {
        return pref.getString(key, null);

    }

    //プリファレンスのチェック
    public boolean mCheckStringPreferences(String key) {
        boolean csp = true;
        String str = pref.getString(key, null);
        if (str == null)
            csp = false;
        return csp;
    }

    public void mDeleteStringPreferences(String key) {

        SharedPreferences.Editor editor = pref.edit();
        Map<String, ?> keys = pref.getAll();
        if (keys.size() > 0) {
            try {
                editor.remove(key);
            } catch (NullPointerException e) {

            }
        }
        editor.commit();
    }

    //プリファレンスのリセット
    public void mResetStringPreferences() {
        SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        editor.commit();
    }
}



