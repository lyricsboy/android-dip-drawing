package com.bignerdranch.android.dipdrawing;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;

public class CircleDrawingView extends ScaledDrawingView {
	private Paint mBigBlackPaint;
	
	public CircleDrawingView(Context context) {
		this(context, null);
	}

	public CircleDrawingView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public CircleDrawingView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		mBigBlackPaint = new Paint();
		mBigBlackPaint.setColor(Color.BLACK);
		mBigBlackPaint.setStyle(Paint.Style.STROKE);
		mBigBlackPaint.setStrokeWidth(2.0f);
		mBigBlackPaint.setAntiAlias(true);
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		float cx = getScaledWidth() / 2.0f;
		float cy = getScaledHeight() / 2.0f;
		mBigBlackPaint.setColor(Color.BLACK);
		for (int radius = 200; radius >= 10; radius -= 10) {
			canvas.drawCircle(cx, cy, radius, mBigBlackPaint);
			int value = (int)(255 * ((200 - radius) / 200f));
			int color = Color.rgb(value, value, value);
			mBigBlackPaint.setColor(color);
		}
	}

}
