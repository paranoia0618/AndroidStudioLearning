package com.example.lxy.shop.adapter;

import android.content.Context;

import com.example.lxy.shop.R;
import com.example.lxy.shop.bean.Category;

import java.util.List;

/**
 * Category分类商品的Adapter
 */

public class CategoryAdapter extends SimpleAdapter<Category> {

    public CategoryAdapter(Context context, List<Category> data) {
        super(context, data, R.layout.template_category_list);
    }

    //控件的绑定
    @Override
    public void bindData(BaseViewHolder holder, Category category) {
       holder.getTextView(R.id.cat_list).setText(category.getName());
    }
}
