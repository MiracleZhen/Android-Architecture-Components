package com.ling.shape.styleable;

/**
 * author : wangchengzhen
 * github : https://github.com/getActivity/ShapeView
 * time   : 2022/5/18
 * desc   : ShapeDrawable View 属性收集接口
 */
public interface IShapeDrawableStyleable {

    int getShapeTypeStyleable();

    int getShapeWidthStyleable();

    int getShapeHeightStyleable();

    int getSolidColorStyleable();

    int getSolidPressedColorStyleable();

    default int getSolidCheckedColorStyleable() {
        return 0;
    }

    int getSolidDisabledColorStyleable();

    int getSolidFocusedColorStyleable();

    int getSolidSelectedColorStyleable();

    int getRadiusStyleable();

    int getTopLeftRadiusStyleable();

    int getTopRightRadiusStyleable();

    int getBottomLeftRadiusStyleable();

    int getBottomRightRadiusStyleable();

    int getSolidStartColorStyleable();

    int getSolidCenterColorStyleable();

    int getSolidEndColorStyleable();

    int getStrokeStartColorStyleable();

    int getStrokeCenterColorStyleable();

    int getStrokeEndColorStyleable();

    int getUseLevelStyleable();

    int getAngleStyleable();

    int getGradientTypeStyleable();

    int getCenterXStyleable();

    int getCenterYStyleable();

    int getGradientRadiusStyleable();

    int getStrokeColorStyleable();

    int getStrokePressedColorStyleable();

    default int getStrokeCheckedColorStyleable() {
        return 0;
    }

    int getStrokeDisabledColorStyleable();

    int getStrokeFocusedColorStyleable();

    int getStrokeSelectedColorStyleable();

    int getStrokeWidthStyleable();

    int getDashWidthStyleable();

    int getDashGapStyleable();

    int getInnerRadiusStyleable();

    int getInnerRadiusRatioStyleable();

    int getThicknessStyleable();

    int getThicknessRatioStyleable();

    int getShadowSizeStyleable();

    int getShadowColorStyleable();

    int getShadowOffsetXStyleable();

    int getShadowOffsetYStyleable();
}
