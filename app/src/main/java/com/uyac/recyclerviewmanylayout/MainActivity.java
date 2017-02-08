package com.uyac.recyclerviewmanylayout;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Context context;
    private Random mRandom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;
        mRandom = new Random();
        testRecyclerView();
    }


    private RecyclerView recyclerView;
    private RecycleAdapter mAdapter;
    private List<ImgShowModel> mList;

    private void testRecyclerView() {

        mList = new ArrayList<>();
        //添加数据
        for (int i = 0; i < 45; i++) {

            ImgShowModel model = new ImgShowModel();
            model.setDate("2016年3月"+(i+1)+"日");
            model.setViewType(Constants.ITEM_RECYCLER_DATE);
            mList.add(model);

            int itemNum = randomNum(1,4);
            for (int j = 0; j < itemNum; j++) {

                ImgShowModel imgModel = new ImgShowModel();
                imgModel.setViewType(Constants.ITEM_RECYCLER_IMG);
                int imgData[] = null;
                if( j == itemNum - 1)
                {
                    //最后一个不满7条数据的情况
                    imgData  = new int[randomNum(1,7)];
                }else
                {
                    imgData  = new int[7];
                }
                for (int k = 0; k < imgData.length; k++) {

//                    imgData[k] = imgArray[mRandom.nextInt(imgArray.length)];
                    imgData[k] = R.mipmap.ic_launcher;
                }

                imgModel.setImg(imgData);
                mList.add(imgModel);

            }
        }

        mAdapter = new RecycleAdapter(this, mList);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
//        recyclerView.setLayoutManager(new GridLayoutManager(this, 7, GridLayoutManager.VERTICAL, false));
        recyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));
//        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(7,StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setAdapter(mAdapter);

    }


    private int imgArray[] = {R.mipmap.b,R.mipmap.ic_launcher,R.mipmap.ic_yaxun_jingpin_collect,R.mipmap.star,R.mipmap.test_ic_launch};

    /**
     * @param min
     * @param max
     * @return  随机几到几
     */
    private int randomNum(int min,int max)
    {

        int r = Math.abs(max - min ) + 1;

        return  mRandom.nextInt(r)+min;
    }


}
