package tw.jefftzeng.puzzle;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by JeffTseng on 2018/2/5.
 */

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    ArrayList<Bitmap> splitImages = new ArrayList<Bitmap>();
    int []serialArray;

    public ImageAdapter(Context c) {
        mContext = c;
        serialArray = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8};
        int temp = 0;
        for(int index = 0; index < (int) (Math.random()*900) +100; index++) {
            int a = (int)Math.random()*9;
            int b = (int)Math.random()*9;

            temp = serialArray[a];
            serialArray[a] = serialArray[b];
            serialArray[b] = temp;
        }

    }
    @Override
    public int getCount() {
        return splitImages.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ImageView imageView = null;
        Resources res = mContext.getResources();
        Bitmap bmp = BitmapFactory.decodeResource(res, R.drawable.background);
        int hScale = (int)bmp.getWidth() / 3;
        int vScale = (int)bmp.getHeight() / 3;
        for(int v =0; v <bmp.getHeight(); v+=vScale)
            for(int h =0; h <bmp.getWidth(); h+=hScale)
                splitImages.add(Bitmap.createBitmap(bmp, h, v, hScale, vScale));
        if(view == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(hScale, vScale));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        }else {
            imageView = (ImageView)view;
        }
        imageView.setImageBitmap(splitImages.get(position));
        return imageView;
    }
}
