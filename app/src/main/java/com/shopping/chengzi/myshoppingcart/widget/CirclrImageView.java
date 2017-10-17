package com.shopping.chengzi.myshoppingcart.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.shopping.chengzi.myshoppingcart.R;

/**
 * 圆形图片
 */

public class CirclrImageView extends ImageView {
    private Paint paint = new Paint();

    private int width;
    private int color;

    private Paint paintFrame;

    public CirclrImageView(Context context, AttributeSet attrs) {
      super(context, attrs);
      TypedArray type = context.obtainStyledAttributes(attrs,
              R.styleable.CirclrImageView);
      width = type.getInteger(R.styleable.CirclrImageView_widthFrame, 3);
//      color = type.getInteger(R.styleable.CirclrImageView_frameColor,0xff63b8ff);
      type.recycle();
      paintFrame = getPaintFrame(2*width);
      paint.setAntiAlias(true);
      paint.setFilterBitmap(true);
    }

    private Bitmap getCircleBitmap(Bitmap bitmapFrom) {
      int picWidth = bitmapFrom.getWidth();
      int picHeight = bitmapFrom.getHeight();
      int length = picWidth < picHeight? picWidth: picHeight;
      Bitmap bitmap = Bitmap.createBitmap(length, length, Config.ARGB_8888);
      Canvas canvas = new Canvas(bitmap);
      Rect rect = new Rect(picWidth/2-length/2, picHeight/2-length/2, picWidth/2+length/2, picHeight/2+length/2);
      Rect rect2 = new Rect(0,0,length,length);
      canvas.drawARGB(0, 0, 0, 0);
      this.paint.setColor(0xffffffff);

      canvas.drawCircle(length / 2, length / 2, length / 2, this.paint);

      this.paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
      canvas.drawBitmap(bitmapFrom, rect, rect2, this.paint);

      return bitmap;
    }

    private Paint getPaintFrame(int width) {
      Paint paintFrame = new Paint();
      paintFrame.setStyle(Paint.Style.STROKE);
      paintFrame.setStrokeWidth(width);
      paintFrame.setAntiAlias(true);
      paintFrame.setFilterBitmap(true);
      paintFrame.setColor(color);
      return paintFrame;
    }

    protected void onDraw(Canvas canvas) {

      int len = getWidth()>getHeight()? getHeight(): getWidth();

      Drawable drawable = getDrawable();
      if (drawable != null) {
        Bitmap bitmapSrc = ((BitmapDrawable)drawable).getBitmap();
        if (bitmapSrc == null)
          return;
        Bitmap bitmap = getCircleBitmap(bitmapSrc);
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        Rect rect1 = new Rect(width, width, len-width, len-width);
        this.paint.reset();
        this.paint.setFilterBitmap(true);
        this.paint.setAntiAlias(true);
        canvas.drawBitmap(bitmap, rect, rect1, this.paint);
        if(width!=0)
          canvas.drawCircle(len/2,len/2,len/2 - width, paintFrame);
        return;
      }
      super.onDraw(canvas);
    }

}