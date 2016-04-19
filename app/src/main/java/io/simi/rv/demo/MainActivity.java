package io.simi.rv.demo;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import io.simi.rv.RecyclerGroupAdapter;
import io.simi.rv.RecyclerLiteView;
import io.simi.rv.RecyclerViewHolder;
import io.simi.rv.ViewType;
import io.simi.rv.ViewTypeArray;

public class MainActivity extends AppCompatActivity implements RecyclerLiteView.OnLackDataListener {

    private List<Model> modelList = new ArrayList<>();
    private RecyclerGroupAdapter recyclerAdapter;
    private RecyclerLiteView recyclerLiteView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewTypeArray viewTypeArray = new ViewTypeArray();
        viewTypeArray.add(ViewType.Type.DEFAULT, 0, R.layout.item_lite2);
        viewTypeArray.add(ViewType.Type.SINGLE, 0, R.layout.item_lite);
        viewTypeArray.add(ViewType.Type.LOOP, 2, R.layout.item_lite3);
        viewTypeArray.add(ViewType.Type.SINGLE, 4, R.layout.item_lite);
        recyclerAdapter = new RecyclerGroupAdapter(this, modelList, viewTypeArray) {
            @Override
            public void onBindView(RecyclerViewHolder holder, int position, int layoutResId) {
                final Model model = modelList.get(position);
                switch (layoutResId) {
                    case R.layout.item_lite:
                        ((TextView) holder.getById(R.id.mTitleView)).setText("我是唯一的");
                        holder.getViewGroup().setBackgroundColor(0xFFEFEFEF);
                        break;
                    case R.layout.item_lite2:
                        ((TextView) holder.getById(R.id.mTitleView)).setText(model.getTitle());
                        ((TextView) holder.getById(R.id.mContentView)).setText(model.getContent());
                        holder.getViewGroup().setBackgroundColor(0xFFFFFFFF);
                        break;
                    case R.layout.item_lite3:
                        ((TextView) holder.getById(R.id.mTitleView)).setText("我是循环产生的");
                        holder.getViewGroup().setBackgroundColor(0xFFC7C7C7);
                        break;
                }
            }
        };
        recyclerLiteView = (RecyclerLiteView) findViewById(R.id.mRecyclerLiteView);
        recyclerLiteView.setAdapter(recyclerAdapter);
        recyclerLiteView.setOnLackDataListener(this);
        recyclerLiteView.setMinNumber(3);
        onLackData();
    }

    @Override
    public void onLackData() {
        if (recyclerLiteView.isLoading()) {
            return;
        }
        recyclerLiteView.setIsLoading(true);
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                modelList.add(new Model("真实版“盗墓笔记”：手法专业 一人曾是考古队员", "电影《盗墓笔记》中的情节，各种专业的手法，真实地发生在了广元市昭化区... 之所以手法如此专业，因为盗墓人中有一人曾是考古队员"));
                modelList.add(new Model("真实版“盗墓笔记”：手法专业 一人曾是考古队员", "电影《盗墓笔记》中的情节，各种专业的手法，真实地发生在了广元市昭化区... 之所以手法如此专业，因为盗墓人中有一人曾是考古队员"));
                modelList.add(new Model("真实版“盗墓笔记”：手法专业 一人曾是考古队员", "电影《盗墓笔记》中的情节，各种专业的手法，真实地发生在了广元市昭化区... 之所以手法如此专业，因为盗墓人中有一人曾是考古队员"));
                modelList.add(new Model("真实版“盗墓笔记”：手法专业 一人曾是考古队员", "电影《盗墓笔记》中的情节，各种专业的手法，真实地发生在了广元市昭化区... 之所以手法如此专业，因为盗墓人中有一人曾是考古队员"));
                modelList.add(new Model("真实版“盗墓笔记”：手法专业 一人曾是考古队员", "电影《盗墓笔记》中的情节，各种专业的手法，真实地发生在了广元市昭化区... 之所以手法如此专业，因为盗墓人中有一人曾是考古队员"));
                modelList.add(new Model("真实版“盗墓笔记”：手法专业 一人曾是考古队员", "电影《盗墓笔记》中的情节，各种专业的手法，真实地发生在了广元市昭化区... 之所以手法如此专业，因为盗墓人中有一人曾是考古队员"));
                modelList.add(new Model("真实版“盗墓笔记”：手法专业 一人曾是考古队员", "电影《盗墓笔记》中的情节，各种专业的手法，真实地发生在了广元市昭化区... 之所以手法如此专业，因为盗墓人中有一人曾是考古队员"));
                modelList.add(new Model("真实版“盗墓笔记”：手法专业 一人曾是考古队员", "电影《盗墓笔记》中的情节，各种专业的手法，真实地发生在了广元市昭化区... 之所以手法如此专业，因为盗墓人中有一人曾是考古队员"));
                modelList.add(new Model("真实版“盗墓笔记”：手法专业 一人曾是考古队员", "电影《盗墓笔记》中的情节，各种专业的手法，真实地发生在了广元市昭化区... 之所以手法如此专业，因为盗墓人中有一人曾是考古队员"));
                modelList.add(new Model("真实版“盗墓笔记”：手法专业 一人曾是考古队员", "电影《盗墓笔记》中的情节，各种专业的手法，真实地发生在了广元市昭化区... 之所以手法如此专业，因为盗墓人中有一人曾是考古队员"));
                modelList.add(new Model("真实版“盗墓笔记”：手法专业 一人曾是考古队员", "电影《盗墓笔记》中的情节，各种专业的手法，真实地发生在了广元市昭化区... 之所以手法如此专业，因为盗墓人中有一人曾是考古队员"));
                modelList.add(new Model("真实版“盗墓笔记”：手法专业 一人曾是考古队员", "电影《盗墓笔记》中的情节，各种专业的手法，真实地发生在了广元市昭化区... 之所以手法如此专业，因为盗墓人中有一人曾是考古队员"));
                modelList.add(new Model("真实版“盗墓笔记”：手法专业 一人曾是考古队员", "电影《盗墓笔记》中的情节，各种专业的手法，真实地发生在了广元市昭化区... 之所以手法如此专业，因为盗墓人中有一人曾是考古队员"));
                modelList.add(new Model("真实版“盗墓笔记”：手法专业 一人曾是考古队员", "电影《盗墓笔记》中的情节，各种专业的手法，真实地发生在了广元市昭化区... 之所以手法如此专业，因为盗墓人中有一人曾是考古队员"));
                modelList.add(new Model("真实版“盗墓笔记”：手法专业 一人曾是考古队员", "电影《盗墓笔记》中的情节，各种专业的手法，真实地发生在了广元市昭化区... 之所以手法如此专业，因为盗墓人中有一人曾是考古队员"));
                modelList.add(new Model("真实版“盗墓笔记”：手法专业 一人曾是考古队员", "电影《盗墓笔记》中的情节，各种专业的手法，真实地发生在了广元市昭化区... 之所以手法如此专业，因为盗墓人中有一人曾是考古队员"));
                modelList.add(new Model("真实版“盗墓笔记”：手法专业 一人曾是考古队员", "电影《盗墓笔记》中的情节，各种专业的手法，真实地发生在了广元市昭化区... 之所以手法如此专业，因为盗墓人中有一人曾是考古队员"));
                modelList.add(new Model("真实版“盗墓笔记”：手法专业 一人曾是考古队员", "电影《盗墓笔记》中的情节，各种专业的手法，真实地发生在了广元市昭化区... 之所以手法如此专业，因为盗墓人中有一人曾是考古队员"));
                modelList.add(new Model("真实版“盗墓笔记”：手法专业 一人曾是考古队员", "电影《盗墓笔记》中的情节，各种专业的手法，真实地发生在了广元市昭化区... 之所以手法如此专业，因为盗墓人中有一人曾是考古队员"));
                modelList.add(new Model("真实版“盗墓笔记”：手法专业 一人曾是考古队员", "电影《盗墓笔记》中的情节，各种专业的手法，真实地发生在了广元市昭化区... 之所以手法如此专业，因为盗墓人中有一人曾是考古队员"));
                modelList.add(new Model("真实版“盗墓笔记”：手法专业 一人曾是考古队员", "电影《盗墓笔记》中的情节，各种专业的手法，真实地发生在了广元市昭化区... 之所以手法如此专业，因为盗墓人中有一人曾是考古队员"));
                modelList.add(new Model("真实版“盗墓笔记”：手法专业 一人曾是考古队员", "电影《盗墓笔记》中的情节，各种专业的手法，真实地发生在了广元市昭化区... 之所以手法如此专业，因为盗墓人中有一人曾是考古队员"));
                modelList.add(new Model("真实版“盗墓笔记”：手法专业 一人曾是考古队员", "电影《盗墓笔记》中的情节，各种专业的手法，真实地发生在了广元市昭化区... 之所以手法如此专业，因为盗墓人中有一人曾是考古队员"));
                modelList.add(new Model("真实版“盗墓笔记”：手法专业 一人曾是考古队员", "电影《盗墓笔记》中的情节，各种专业的手法，真实地发生在了广元市昭化区... 之所以手法如此专业，因为盗墓人中有一人曾是考古队员"));
                modelList.add(new Model("真实版“盗墓笔记”：手法专业 一人曾是考古队员", "电影《盗墓笔记》中的情节，各种专业的手法，真实地发生在了广元市昭化区... 之所以手法如此专业，因为盗墓人中有一人曾是考古队员"));
                modelList.add(new Model("真实版“盗墓笔记”：手法专业 一人曾是考古队员", "电影《盗墓笔记》中的情节，各种专业的手法，真实地发生在了广元市昭化区... 之所以手法如此专业，因为盗墓人中有一人曾是考古队员"));
                modelList.add(new Model("真实版“盗墓笔记”：手法专业 一人曾是考古队员", "电影《盗墓笔记》中的情节，各种专业的手法，真实地发生在了广元市昭化区... 之所以手法如此专业，因为盗墓人中有一人曾是考古队员"));
                modelList.add(new Model("真实版“盗墓笔记”：手法专业 一人曾是考古队员", "电影《盗墓笔记》中的情节，各种专业的手法，真实地发生在了广元市昭化区... 之所以手法如此专业，因为盗墓人中有一人曾是考古队员"));
                modelList.add(new Model("真实版“盗墓笔记”：手法专业 一人曾是考古队员", "电影《盗墓笔记》中的情节，各种专业的手法，真实地发生在了广元市昭化区... 之所以手法如此专业，因为盗墓人中有一人曾是考古队员"));
                modelList.add(new Model("真实版“盗墓笔记”：手法专业 一人曾是考古队员", "电影《盗墓笔记》中的情节，各种专业的手法，真实地发生在了广元市昭化区... 之所以手法如此专业，因为盗墓人中有一人曾是考古队员"));
                modelList.add(new Model("真实版“盗墓笔记”：手法专业 一人曾是考古队员", "电影《盗墓笔记》中的情节，各种专业的手法，真实地发生在了广元市昭化区... 之所以手法如此专业，因为盗墓人中有一人曾是考古队员"));
                modelList.add(new Model("真实版“盗墓笔记”：手法专业 一人曾是考古队员", "电影《盗墓笔记》中的情节，各种专业的手法，真实地发生在了广元市昭化区... 之所以手法如此专业，因为盗墓人中有一人曾是考古队员"));
                modelList.add(new Model("真实版“盗墓笔记”：手法专业 一人曾是考古队员", "电影《盗墓笔记》中的情节，各种专业的手法，真实地发生在了广元市昭化区... 之所以手法如此专业，因为盗墓人中有一人曾是考古队员"));
                modelList.add(new Model("真实版“盗墓笔记”：手法专业 一人曾是考古队员", "电影《盗墓笔记》中的情节，各种专业的手法，真实地发生在了广元市昭化区... 之所以手法如此专业，因为盗墓人中有一人曾是考古队员"));
                modelList.add(new Model("真实版“盗墓笔记”：手法专业 一人曾是考古队员", "电影《盗墓笔记》中的情节，各种专业的手法，真实地发生在了广元市昭化区... 之所以手法如此专业，因为盗墓人中有一人曾是考古队员"));
                modelList.add(new Model("真实版“盗墓笔记”：手法专业 一人曾是考古队员", "电影《盗墓笔记》中的情节，各种专业的手法，真实地发生在了广元市昭化区... 之所以手法如此专业，因为盗墓人中有一人曾是考古队员"));
                modelList.add(new Model("真实版“盗墓笔记”：手法专业 一人曾是考古队员", "电影《盗墓笔记》中的情节，各种专业的手法，真实地发生在了广元市昭化区... 之所以手法如此专业，因为盗墓人中有一人曾是考古队员"));
                modelList.add(new Model("真实版“盗墓笔记”：手法专业 一人曾是考古队员", "电影《盗墓笔记》中的情节，各种专业的手法，真实地发生在了广元市昭化区... 之所以手法如此专业，因为盗墓人中有一人曾是考古队员"));
                modelList.add(new Model("真实版“盗墓笔记”：手法专业 一人曾是考古队员", "电影《盗墓笔记》中的情节，各种专业的手法，真实地发生在了广元市昭化区... 之所以手法如此专业，因为盗墓人中有一人曾是考古队员"));
                modelList.add(new Model("真实版“盗墓笔记”：手法专业 一人曾是考古队员", "电影《盗墓笔记》中的情节，各种专业的手法，真实地发生在了广元市昭化区... 之所以手法如此专业，因为盗墓人中有一人曾是考古队员"));
                modelList.add(new Model("真实版“盗墓笔记”：手法专业 一人曾是考古队员", "电影《盗墓笔记》中的情节，各种专业的手法，真实地发生在了广元市昭化区... 之所以手法如此专业，因为盗墓人中有一人曾是考古队员"));
                modelList.add(new Model("真实版“盗墓笔记”：手法专业 一人曾是考古队员", "电影《盗墓笔记》中的情节，各种专业的手法，真实地发生在了广元市昭化区... 之所以手法如此专业，因为盗墓人中有一人曾是考古队员"));
                recyclerAdapter.notifyDataSetChanged();
                recyclerLiteView.setIsLoading(false);
            }
        });
    }

    class Model {
        private String title;
        private String content;

        public Model(String title, String content) {
            this.title = title;
            this.content = content;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}
