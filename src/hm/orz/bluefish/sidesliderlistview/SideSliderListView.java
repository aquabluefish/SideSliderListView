package hm.orz.bluefish.sidesliderlistview;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class SideSliderListView extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // ListViewのインスタンスを取得
        ListView list = (ListView)findViewById(R.id.listView1);
 
        // リストアイテムのラベルを格納するArrayListをインスタンス化
        final ArrayList<String> labelList = new ArrayList<String>();
 
        // "List Item + ??"を20個リストに追加
        for(int i=1; i<=20; i++){
            labelList.add("List Item "+i);
        }

        CustomAdapter mAdapter = new CustomAdapter(this, 0, labelList);
        list.setAdapter(mAdapter);

        list.setSelection(1);
        list.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?>adapter, View view, int pos, long id) {
                Toast.makeText(SideSliderListView.this, labelList.get(pos) +" が選択されました", Toast.LENGTH_LONG).show();
            }
        });
    }
}
