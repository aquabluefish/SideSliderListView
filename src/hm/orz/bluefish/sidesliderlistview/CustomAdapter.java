package hm.orz.bluefish.sidesliderlistview;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;

public class CustomAdapter extends ArrayAdapter<Item>{
    private LayoutInflater inflater;
    private int mItemLayoutResource;

    // コンストラクタ
    public CustomAdapter(Context context,int resource, ArrayList<Item> object) {
        super(context,resource, object);
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mItemLayoutResource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
    	final CustomLayout view;

        // Viewを再利用している場合は新たにViewを作らない
        if (convertView == null) {
            view = (CustomLayout)inflater.inflate(mItemLayoutResource, null);
        } else {
            view = (CustomLayout)convertView;
        }

        view.bindView(getItem(position));

        // 行毎に背景色を変える
        if(position%2==0){
        	view.mTitleView.setBackgroundColor(Color.parseColor("#aa0000"));
        }else{
            view.mTitleView.setBackgroundColor(Color.parseColor("#880000"));
        }

        // XMLで定義したアニメーションを読み込む
        Animation anim = AnimationUtils.loadAnimation(getContext(), R.anim.list_motion);
        // リストアイテムのアニメーションを開始
        view.startAnimation(anim);

        return view;
    }
}