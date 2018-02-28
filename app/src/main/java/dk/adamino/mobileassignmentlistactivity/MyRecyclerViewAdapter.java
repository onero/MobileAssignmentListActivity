package dk.adamino.mobileassignmentlistactivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;

import dk.adamino.mobileassignmentlistactivity.BE.Entity;
import dk.adamino.mobileassignmentlistactivity.Model.EntityModel;

/**
 * Created by Adamino.
 */

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.RecycleHolder> {
    private EntityModel mEntityModel = EntityModel.getInstance();

    @Override
    public RecycleHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        return new RecycleHolder(layoutInflater, parent);
    }

    @Override
    public void onBindViewHolder(RecycleHolder holder, int position) {
        Entity entity = mEntityModel.getEntities().get(position);
        holder.bind(entity);
    }

    @Override
    public int getItemCount() {
        return mEntityModel.getEntities().size();
    }

    public class RecycleHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView mName;
        private ImageView mImage;
        private Entity mEntity;

        public RecycleHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.row_item, parent, false));
            itemView.setOnClickListener(this);

            mName = itemView.findViewById(R.id.txtName);
            mImage = itemView.findViewById(R.id.imgView);
        }

        public void bind(Entity entity) {
            mEntity = entity;
            mName.setText(mEntity.getName());
            InputStream imageStream = itemView.getResources().openRawResource(R.raw.monkey);
            Bitmap bitmap = BitmapFactory.decodeStream(imageStream);
            mImage.setImageBitmap(bitmap);
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(v.getContext(), mEntity.getName(), Toast.LENGTH_SHORT).show();
        }
    }
}
