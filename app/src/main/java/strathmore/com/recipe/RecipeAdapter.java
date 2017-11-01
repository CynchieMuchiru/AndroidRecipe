package strathmore.com.recipe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.ArrayList;

/**
 * Created by Cece on 10/10/2017.
 */

public class RecipeAdapter extends BaseAdapter{
    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<Recipe> mDataSource;

    //The one below is a constructor
    public RecipeAdapter(Context context, ArrayList<Recipe> items){
        mContext = context;
        mDataSource = items;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return mDataSource.size();
    }

    @Override
    public Object getItem(int position) {//Enables us to get the exact position of an item to be displayed in the listview
        //Returns an item to be placed in a given position from the datasource
        return mDataSource.get(position);
    }

    @Override
    public long getItemId(int position) {//Defines a unique ID for each row in the list
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Get the view for the row item. This is in terms of whether you want the image displayed first followed by text
        View rowView = mInflater.inflate(R.layout.list_item_recipe, parent, false);

        //Get the title element
        TextView titleTextView = (TextView) rowView.findViewById(R.id.recipe_list_title);
        //We are casting coz TextViews are not java and hence they have to explicitely stated

        //Get the subtitle element
        TextView subtitleTextView = (TextView) rowView.findViewById(R.id.recipe_list_subtitle);

        //Get the detail element
        TextView detailTextView = (TextView) rowView.findViewById(R.id.recipe_list_detail);

        //Get thumbnail element
        ImageView thumbnailImageView = (ImageView) rowView.findViewById(R.id.recipe_list_thumbnail);

        //1
        Recipe recipe = (Recipe) getItem(position);

        //2
        titleTextView.setText(recipe.title);
        subtitleTextView.setText(recipe.description);
        detailTextView.setText(recipe.label);

        //3


        Picasso.with(mContext).load(recipe.imageUrl).placeholder(R.mipmap.ic_launcher).into(thumbnailImageView);



        return rowView;
    }


}
