package infinity1087.android.com.examplehr.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import infinity1087.android.com.examplehr.R;
import infinity1087.android.com.examplehr.RoundedTransformation;


/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment {

    ImageView img_btn_veggie, img_btn_milk, img_button_fruits, img_btn_waffers;

    public CategoryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_category, container, false);

        img_btn_veggie = view.findViewById(R.id.img_veggie);
        img_btn_milk = view.findViewById(R.id.img_milk);
        img_btn_waffers = view.findViewById(R.id.img_waffers);
        img_button_fruits = view.findViewById(R.id.img_fruits);
        Picasso.get().load("http://image.barodaweb.net/api/EGreen/Magic/200/ProductGroup-Vegetables/a1.jpg/100").error(R.drawable.veg).transform(new RoundedTransformation(20, 0)).into(img_btn_veggie);
        // TODO do the same for other 3 buttons image just replace the url also read below commented lines

        // and if you want to make the images like normal adjust the alpha value in the xml file of the activity
        // alpha is for opacity

        // i dont know the image urls for this so commenting them as milk ,fruits url etc

        Picasso.get().load("milk url").error(R.drawable.milk).transform(new RoundedTransformation(20, 0)).into(img_btn_milk);
        Picasso.get().load("fruits url").error(R.drawable.fruits).transform(new RoundedTransformation(20, 0)).into(img_button_fruits);
        Picasso.get().load("waffers url").error(R.drawable.waffer).transform(new RoundedTransformation(20, 0)).into(img_btn_waffers);


        return view;

    }

}
