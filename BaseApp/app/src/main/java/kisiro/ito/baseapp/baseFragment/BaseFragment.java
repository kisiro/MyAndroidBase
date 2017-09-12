package kisiro.ito.baseapp.baseFragment;

//=============================================================================================
//  名前空間    ：  kisiro.ito.baseapp.baseFragment;
//
//  クラス名    ：  baseFragment
//
//  機能        ：  ベースフラグメント
//
//  備考        ：
//
//  作成者      ：  [00] 2017.09.12 P.cast I.Hiroyuki
//
//  更新者      ：  [00] 2017.09.12 P.cast I.Hiroyuki
//=============================================================================================

import android.content.Context;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kisiro.ito.baseapp.R;


public class BaseFragment extends Fragment {




    public static BaseFragment newInstance(String b, String a) {
        BaseFragment mFragment = new BaseFragment();
        return mFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_base, container, false);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();

    }
}

