package com.ling.shape.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatImageView;

import com.ling.shape.R;
import com.ling.shape.builder.ShapeDrawableBuilder;
import com.ling.shape.styleable.ShapeImageViewStyleable;

/**
 * author : wangchengzhen
 * github : https://github.com/getActivity/ShapeView
 * time   : 2022/5/19
 * desc   : 支持直接定义 Shape 背景的 ImageView
 */
public class ShapeImageView extends AppCompatImageView {

    private static final ShapeImageViewStyleable STYLEABLE = new ShapeImageViewStyleable();

    private final ShapeDrawableBuilder mShapeDrawableBuilder;

    public ShapeImageView(Context context) {
        this(context, null);
    }

    public ShapeImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ShapeImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ShapeImageView);
        mShapeDrawableBuilder = new ShapeDrawableBuilder(this, typedArray, STYLEABLE);
        typedArray.recycle();

        mShapeDrawableBuilder.intoBackground();
    }

    public ShapeDrawableBuilder getShapeDrawableBuilder() {
        return mShapeDrawableBuilder;
    }
}
