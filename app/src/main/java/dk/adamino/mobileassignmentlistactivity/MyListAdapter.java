package dk.adamino.mobileassignmentlistactivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.util.List;

import dk.adamino.mobileassignmentlistactivity.BE.Entity;

/**
 * Created by Adamino.
 */

public class MyListAdapter extends BaseAdapter {
    private LayoutInflater mLayoutInflater;
    private List<Entity> mEntities;
    private final Context mContext;

    public MyListAdapter(Context context, List<Entity> entities) {
        mContext = context;
        mEntities = entities;
        mLayoutInflater = (LayoutInflater)
                mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mEntities.size();
    }

    @Override
    public Entity getItem(int position) {
        return mEntities.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        if (view == null) {
            view = mLayoutInflater.inflate(R.layout.row_item, parent, false);

            Entity currentEntity = mEntities.get(position);

            TextView name = view.findViewById(R.id.txtName);
            name.setText(currentEntity.getName());

            ImageView imageView = view.findViewById(R.id.imgView);

            InputStream imageStream = view.getResources().openRawResource(R.raw.monkey);
            Bitmap bitmap = BitmapFactory.decodeStream(imageStream);
            imageView.setImageBitmap(bitmap);
        }

        return view;
    }
}
