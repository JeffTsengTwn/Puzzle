package tw.jefftzeng.puzzle;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Random;

import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

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
        Display display = ((WindowManager)mContext.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        Bitmap srcBmp = BitmapFactory.decodeResource(res, R.drawable.background);
        Bitmap resizeBmp = null;
        double radio = 1.0f;
        int width = (int)((float)size.x);
        radio = width/srcBmp.getWidth();
        resizeBmp = Bitmap.createScaledBitmap(srcBmp, width, (int)(radio * srcBmp.getHeight()), false);
        int vScale = (int)((double)resizeBmp.getHeight() / 3);
        int hScale = (int)((double)resizeBmp.getWidth() / 3);
        for(int v =0; v <resizeBmp.getHeight(); v+=vScale) {
            for (int h = 0; h < resizeBmp.getWidth(); h += hScale) {
                Bitmap dstBmp = Bitmap.createBitmap(resizeBmp, h, v, hScale, vScale);
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
