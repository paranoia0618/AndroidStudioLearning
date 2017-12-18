package com.example.lxy.shop.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.Button;

import com.example.lxy.shop.R;
import com.example.lxy.shop.bean.Wares;
import com.example.lxy.shop.utils.CartProvider;
import com.example.lxy.shop.utils.ToastUtils;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by liuqiuyue on 2017/4/18.
 * 分类商品adapter
 */

public class CategoryWaresAdapter extends SimpleAdapter<Wares> {
    //购物车数据提供
    CartProvider provider;


    public CategoryWaresAdapter(Context context, List<Wares> data) {
        super(context, data, R.layout.template_category_wares);
        provider = new CartProvider(context);
    }

    @Override
    public void bindData(BaseViewHolder holder, final Wares wares) {
        //添加要显示的内容
        SimpleDraweeView draweeView = (SimpleDraweeView) holder.getView(R.id.cat_drawee_view);
        draweeView.setImageURI(Uri.parse(wares.getImgUrl()));
        holder.getTextView(R.id.cat_text_title).setText(wares.getName());
        holder.getTextView(R.id.cat_text_price).setText("" + wares.getPrice());
        Button button = holder.getButton(R.id.cat_button);
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //将所得数据put到购物车列表中

                    provider.put(wares);

                    ToastUtils.show(mContext, R.string.addSuccess);
                }
            });
        }
    }



}
