package com.bignerdranch.android.dipdrawing;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint.Align;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;

public class TextDrawingView extends ScaledDrawingView {
	private TextPaint mTextPaint;
	private Layout mTextLayout;
	
	private static final String TEXT = "You are getting sleepy!";

	public TextDrawingView(Context context) {
		this(context, null);
	}

	public TextDrawingView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public TextDrawingView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		
		// set the scale factor to the equivalent of what "sp" will be based on
		setScaleFactor(getResources().getDisplayMetrics().scaledDensity);
		
		// set up the paint for this text
		mTextPaint = new TextPaint();
		mTextPaint.setTextSize(30);
		mTextPaint.setAntiAlias(true);
		mTextPaint.setSubpixelText(true);
		mTextPaint.setTextAlign(Align.LEFT);
		
		// set up a layout that we'll use to measure and draw the text
		int desiredWidth = (int)Math.ceil(Layout.getDesiredWidth(TEXT, mTextPaint));
		mTextLayout = new StaticLayout(TEXT, mTextPaint, desiredWidth, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0, true);
	}
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		int layoutWidth = (int) (mTextLayout.getWidth() * getScaleFactor());
		int layoutHeight = (int) (mTextLayout.getHeight() * getScaleFactor());
		int width = Math.max(layoutWidth, getSuggestedMinimumWidth());
		int height = Math.max(layoutHeight, getSuggestedMinimumHeight());
		setMeasuredDimension(width, height);
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		
		// use the layout to draw the text
		// TODO: is there a way to make the text draw at the appropriate resolution and look good when scaled?
		mTextLayout.draw(canvas);
	}

}
