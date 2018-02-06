package tw.jefftzeng.puzzle;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
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
    ArrayList<ImageView> imageViews = new ArrayList<ImageView>();
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


        Resources res = mContext.getResources();
        Bitmap srcBmp = BitmapFactory.decodeResource(res, R.drawable.background);
        int hScale = (int)(srcBmp.getWidth() / 3);
        int vScale = (int)(srcBmp.getHeight() / 3);
        for(int v =0; v <srcBmp.getHeight(); v+=vScale) {
            for (int h = 0; h < srcBmp.getWidth(); h += hScale) {
                Bitmap dstBmp = Bitmap.createBitmap(srcBmp, h, v, hScale, vScale);
                splitImages.add(dstBmp);

                ImageView imageView = new ImageView(mContext);
                imageView.setLayoutParams(new GridView.LayoutParams(hScale, vScale));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setPadding(8, 8, 8, 8);
                imageView.setImageBitmap(dstBmp);
                imageViews.add(imageView);
            }
        }
    }
    @Override
    public int getCount() {
        return imageViews.size();
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

        return imageViews.get(position);
    }
}
