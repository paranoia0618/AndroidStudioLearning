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
 * 热门商品Adapter
 */

public class HotAdapter extends SimpleAdapter<Wares> {
    CartProvider provider;


    public HotAdapter(Context context, List<Wares> data) {
        super(context, data, R.layout.template_hot_wares);
        provider = new CartProvider(context);
    }

    @Override
    public void bindData(BaseViewHolder holder, final Wares wares) {
        //添加要显示的内容
        SimpleDraweeView draweeView = (SimpleDraweeView) holder.getView(R.id.drawee_view);
        draweeView.setImageURI(Uri.parse(wares.getImgUrl()));
        holder.getTextView(R.id.text_title).setText(wares.getName());
        holder.getTextView(R.id.text_price).setText("" + wares.getPrice());
        Button button = holder.getButton(R.id.bt_hot);
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



    /**
     * 更改布局的方法
     *
     * @param layoutId
     */
    public void resetLayout(int layoutId) {
        this.LayoutResId = layoutId;
        notifyItemRangeChanged(0, getDatas().size());
    }
}
