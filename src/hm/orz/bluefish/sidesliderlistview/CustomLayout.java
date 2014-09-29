package hm.orz.bluefish.sidesliderlistview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CustomLayout extends LinearLayout {
	TextView mTitleView;
	ImageView mIconView;

	public CustomLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();

		mTitleView = (TextView) findViewById(R.id.list_textView1);
		mIconView = (ImageView) findViewById(R.id.imageView1);
	}

	public void bindView(Item item) {
		mTitleView.setText(item.title);
		mIconView.setImageResource(item.icon);
	}

}
