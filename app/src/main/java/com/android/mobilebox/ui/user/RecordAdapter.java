package com.android.mobilebox.ui.user;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.mobilebox.R;
import com.android.mobilebox.core.bean.user.OrderResponse;
import com.android.mobilebox.ui.record.RecordDetailActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecordAdapter extends RecyclerView.Adapter<RecordAdapter.ViewHolder> {
    private Context context;
    private List<OrderResponse> mOrders;

    public RecordAdapter(Context context, List<OrderResponse> mOrders) {
        this.context = context;
        this.mOrders = mOrders;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View contentView = LayoutInflater.from(context).inflate(R.layout.item_records_layout, viewGroup, false);
        return new ViewHolder(contentView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        int index = mOrders.size() > 0 ? (mOrders.size()- 1 - i) : 0;
        OrderResponse orderResponse = mOrders.get(index);
        String operateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(orderResponse.getGmtModified()));
        viewHolder.tvOperateTime.setText(operateTime);
        viewHolder.itemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("OPERATE_TIME", operateTime);
                intent.putExtra("DEVICE_NAME", "智能柜002");
                intent.putExtra("RELEVANCE_ID", orderResponse.getRelevanceId());
                intent.putExtra("DEVICE_ID", orderResponse.getDevId());
                intent.setClass(context, RecordDetailActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mOrders == null ? 0 : mOrders.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_box_name)
        TextView tvBoxName;
        @BindView(R.id.tv_inout_num)
        TextView tvInoutNum;
        @BindView(R.id.tv_operate_time)
        TextView tvOperateTime;
        @BindView(R.id.record_item_layout)
        LinearLayout itemLayout;

        public ViewHolder(@NonNull View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

}
