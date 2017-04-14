package com.teemo.sorttest.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.teemo.sorttest.R;
import com.teemo.sorttest.adapter.ListSortAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRv;
    private List<String> mData = new ArrayList<>();
    private int[] numbers = new int[]{22, 66, 18, 1, 99, 10, 18, 30, 5, 31, 55};
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(R.layout.activity_main);

        initView();
        makeTestData();
    }

    private void makeTestData() {
        mData.add("bubbleSort");
        mData.add("fastSort");
        mData.add("take_video");
        mData.add("自定义View");
        mData.add("切换Fragment的正确姿势");
        mRv.getAdapter().notifyDataSetChanged();
    }

    private void initView() {
        SwipeRefreshLayout refreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_layout);
        mRv = (RecyclerView) findViewById(R.id.rv);

//        refreshLayout.setOnChildScrollUpCallback();

        ListSortAdapter mAdapter = new ListSortAdapter(mData);
        mRv.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new ListSortAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                switch (position) {
                    case 0:
                        bubbleSort(numbers);
                        break;
                    case 1:
                        fastSort(numbers);
                        break;
                    case 2:
                        startActivity(new Intent(mContext, MultimediaActivity.class));
                        break;
                    case 3:
                        startActivity(new Intent(mContext, VideoPlayActivity.class));
                        break;
                    case 4:
                        startActivity(new Intent(mContext, PersonalActivity.class));
                        break;
                }
            }
        });
    }

    /**
     * 冒泡排序
     * 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
     * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。
     * 针对所有的元素重复以上的步骤，除了最后一个。
     * 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
     *
     * @param numbers 需要排序的整型数组
     */
    private void bubbleSort(int[] numbers) {
        int tem;
        int size = numbers.length;
        for (int i = 0; i < size - 1; i++) {//两两相比
            for (int j = 0; j < size - i - 1; j++) {//每轮参与排序的元素个数递减1
                if (numbers[j] > numbers[j + 1]) {
                    //核心思路，大的往后排，产生最小值。上一次循环产生的最大值放到最后,下一次循环就不用再为其排序
                    tem = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = tem;
                }
            }
        }
        Log.e("TAG", convert(numbers));

    }

    /**
     * 快速排序
     *
     * @param numbers .
     */
    private void fastSort(int[] numbers) {

    }

    private String convert(int[] input) {
        StringBuffer sb = new StringBuffer();
        for (int i : input) {
            sb.append(i);
            sb.append(",");
        }
        return sb.toString();
    }
}
