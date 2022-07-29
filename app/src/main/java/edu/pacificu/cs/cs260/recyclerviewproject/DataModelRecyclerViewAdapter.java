package edu.pacificu.cs.cs260.recyclerviewproject;

import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.List;

public class DataModelRecyclerViewAdapter extends RecyclerView.Adapter<DataModelRecyclerViewAdapter.ViewHolder> {
    private List<DataModel> data;

    /***
     * Constructor to build the adapter
     * @param data the data to be displayed by the views
     */
    public DataModelRecyclerViewAdapter(List<DataModel> data) {
        this.data = data;
    }

    /***
     * Creating the view holder (only called the first time the view is generated)
     *
     * @param parent
     * @param viewType
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.display_model, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.dataModel = data.get(position);
        holder.bindData();
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static class ViewHolder extends RecyclerView.ViewHolder {


        /***
         * The model (datum) CURRENTLY to be displayed by the view
         *
         * Data that this should be expected to change and the view will need to update to reflect
         * changed data.
         */
        DataModel dataModel;

        /***
         * A label from the view to display Data info about the datum
         */
        TextView tv1;
        /***
         * Another label from the view
         */
        TextView tv2;

        /***
         * Getter for the datum.
         *
         * @return
         */
        public DataModel getDataModel() {
            return dataModel;
        }

        /***
         * Setter for the datum
         *
         * @param DataModel
         */
        public void setDataModel(DataModel DataModel) {
            this.dataModel = DataModel;
        }

        /***
         * ViewHolder constructor takes a view that will be used to display a single datum
         * @param itemView
         */
        public ViewHolder(View itemView) {
            super(itemView);
        }

        /***
         * This is a function that takes the piece of data currently stored in DataModel
         * and displays it using this ViewHolder's view.
         *
         * This will be called by the onBindViewHolder method of the adapter every time
         * a view is recycled
         */
        public void bindData() {
            if (tv1 == null) {
                tv1 = (TextView) itemView.findViewById(R.id.tv1);
            }
            if (tv2 == null) {
                tv2 = (TextView) itemView.findViewById(R.id.tv2);
            }

            tv1.setText(dataModel.data1);
            tv2.setText(dataModel.data2);

        }
    }
}