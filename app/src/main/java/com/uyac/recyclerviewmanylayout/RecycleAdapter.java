package com.uyac.recyclerviewmanylayout;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;



import java.util.List;

/**
 * Created by ShaoQuanwei on 2016/10/28.
 */

public class RecycleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context context;
    private List<ImgShowModel> list;
    private final String TAG = "RecycleAdapter";
    private int itemHeigth;

    public RecycleAdapter(Context context, List<ImgShowModel> list) {
        this.context = context;
        this.list = list;
        //让高度和宽度相同
        itemHeigth = ScreenUtils.getScreenWH(context)[0]/Constants.RECYCLE_COLUMN;

    }


    @Override
    public int getItemViewType(int position) {

        Log.e(TAG, "getItemViewType: "+ list.get(position).getViewType());

        return list.get(position).getViewType();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RecyclerView.ViewHolder holder = null;

        switch (viewType)
        {
            case Constants.ITEM_RECYCLER_DATE:

                View viewData = LayoutInflater.from(context).inflate(R.layout.item_recycler_date,parent,false);
                holder = new DateViewHolder(viewData);

                break;
            case Constants.ITEM_RECYCLER_IMG:

                View viewImg = LayoutInflater.from(context).inflate(R.layout.item_recycler_img,parent,false);
                holder = new ImgViewHolder(viewImg);

                break;
        }

        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {


        ImgShowModel model = list.get(position);
        Log.e(TAG, "onBindViewHolder: "+position+"   "+model.getViewType());

        if(model.getViewType() == Constants.ITEM_RECYCLER_DATE)
        {
            Log.e(TAG, "onBindViewHolder: DateViewHolder" );

            DateViewHolder dateViewHolder = ((DateViewHolder)holder);
            dateViewHolder.tv.setText(list.get(position).getDate());

        }else if(model.getViewType() == Constants.ITEM_RECYCLER_IMG)
        {
            Log.e(TAG, "onBindViewHolder: ImgViewHolder" );

            ImgViewHolder imgViewHolder = ((ImgViewHolder)holder);

            for (int i = 0; i < Constants.RECYCLE_COLUMN; i++) {

                if(i < model.getImg().length)
                {
                    imgViewHolder.img[i].setImageResource(model.getImg()[i]);
                    imgViewHolder.img[i].setVisibility(View.VISIBLE);
                }else
                {

                    imgViewHolder.img[i].setVisibility(View.INVISIBLE);
                }

                ViewGroup.LayoutParams params = imgViewHolder.img[i].getLayoutParams();
                params.height = itemHeigth;
                imgViewHolder.img[i].setLayoutParams(params);

            }



        }

    }

    @Override
    public int getItemCount() {
        return list != null ? list.size():0;
    }


    public class DateViewHolder extends RecyclerView.ViewHolder
    {
        private TextView tv;

        public DateViewHolder(View itemView) {
            super(itemView);

            tv = (TextView) itemView.findViewById(R.id.item_recycler_date);

        }
    }

    public class ImgViewHolder extends RecyclerView.ViewHolder
    {
        private ImageView img[] = new ImageView[7];
        private int imgID[] = {R.id.item_recycler_img1,R.id.item_recycler_img2,R.id.item_recycler_img3,R.id.item_recycler_img4,R.id.item_recycler_img5,R.id.item_recycler_img6,R.id.item_recycler_img7};

        public ImgViewHolder(View itemView) {
            super(itemView);

            for (int i = 0; i < imgID.length; i++) {

                img[i] = (ImageView) itemView.findViewById(imgID[i]);
            }

        }
    }

}
