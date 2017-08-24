package com.example.timelinetext.test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

@SuppressWarnings("ALL")
public class TimelineAdapter extends BaseAdapter {

    private List<Map<String, Object>> list;
    private LayoutInflater inflater;

    public TimelineAdapter(Context context, List<Map<String, Object>> list) {
        super();
        inflater = LayoutInflater.from(context);
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item_main, null);
            viewHolder.year = (TextView) convertView.findViewById(R.id.year);
            viewHolder.month = (TextView) convertView.findViewById(R.id.month);
            viewHolder.title = (TextView) convertView.findViewById(R.id.title);
            viewHolder.showdate = (TextView) convertView.findViewById(R.id.show_time);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        String yearStr = list.get(position).get("year").toString();
        String monthStr = list.get(position).get("month").toString();
        String titleStr = list.get(position).get("title").toString();
        String dateStr = list.get(position).get("date").toString();

        viewHolder.year.setText(list.get(position).get("year").toString());
        viewHolder.month.setText(list.get(position).get("month").toString());
        viewHolder.title.setText(list.get(position).get("title").toString());
        viewHolder.showdate.setText(list.get(position).get("date").toString());

        return convertView;
    }

    static class ViewHolder {
        public TextView year;
        public TextView month;
        public TextView title;
        public TextView showdate;
    }
}
