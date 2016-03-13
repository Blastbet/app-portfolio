package com.blastbeat.nanodegree.myappportfolio;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by ilkka on 6.3.2016.
 */
public class PortfolioAppArrayAdapter extends ArrayAdapter<PortfolioApp> {

    Context mContext = null;
    int mLayoutResourceId = 0;
    PortfolioApp mData[] = null;
    Toast mToast = null;

    PortfolioAppArrayAdapter(Context context, int layoutResourceId, PortfolioApp[] data) {
        super(context, layoutResourceId, data);
        this.mContext = context;
        this.mLayoutResourceId = layoutResourceId;
        this.mData = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        AppDataHolder holder = null;

        if (convertView == null) {
            final String toastMessage = mData[position].getToastMessage();
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            convertView = inflater.inflate(mLayoutResourceId, parent, false);

            holder = new AppDataHolder();
            holder.mButton = (Button)convertView.findViewById(R.id.app_list_item_button);

            holder.mButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast toast = Toast.makeText(mContext, toastMessage, Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 16);
                    View view = toast.getView();
                    view.setPadding(20,40,20,40);
                    view.setBackgroundColor(mContext.getColor(R.color.cyanTranslucent));
                    if (mToast != null) {
                        mToast.cancel();
                    }

                    mToast = toast;
                    toast.show();
                }
            });

            if (mData[position].isHighlighted())
            {
                holder.mButton.setBackground(mContext.getDrawable(R.drawable.button_highlighted_background));
            }

            convertView.setTag(holder);
        }
        else {
            holder = (AppDataHolder) convertView.getTag();
        }

        holder.mButton.setText(mData[position].getName());
        return convertView;
    }

    static class AppDataHolder {
        Button mButton;
    }
}
