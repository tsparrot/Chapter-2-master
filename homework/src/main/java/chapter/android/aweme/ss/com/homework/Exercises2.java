package chapter.android.aweme.ss.com.homework;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * 作业2：一个抖音笔试题：统计页面所有view的个数
 * Tips：ViewGroup有两个API
 * {@link android.view.ViewGroup #getChildAt(int) #getChildCount()}
 * 用一个TextView展示出来
 */
public class Exercises2 extends AppCompatActivity {
    private static final String TAG = "tsparrot";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercise2);

        TextView centertv = findViewById(R.id.tv_center);
        ViewGroup viewgroup = findViewById(R.id.viewtree);
        Log.d(TAG,"test");
        centertv.setText(String.valueOf(getAllChildViewCount(viewgroup)));

    }

    //考虑到ViewGroup是树形结构，可采用DFS/BFS遍历，这里采用了DFS
    public int getAllChildViewCount(View view) {
        int count = 0;
        if(view == null ) {
            return count;
        }
        else {
            //判断是否是ViewGroup，若是则递归遍历子树，进行计数
            count += 1;
            if (view instanceof ViewGroup) {
                for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
                    count += getAllChildViewCount(((ViewGroup) view).getChildAt(i));
                }
            } else {
                return 1;
            }
            return count;
        }
    }
}
