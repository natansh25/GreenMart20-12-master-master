package infinity1087.android.com.examplehr.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.net.URL;
import java.util.List;

import infinity1087.android.com.examplehr.MainActivity;
import infinity1087.android.com.examplehr.Network.NetworkClass;
import infinity1087.android.com.examplehr.R;
import infinity1087.android.com.examplehr.RoundedTransformation;
import infinity1087.android.com.examplehr.appExecuter.AppExecutors;
import infinity1087.android.com.examplehr.model.MainButtonImage;
import retrofit2.http.Url;


/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment {

    ImageView img_btn_veggie, img_btn_milk, img_button_fruits, img_btn_waffers;
    String milk_url, fruits_url, veggie_url, waffers_url;

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

        getData();
        Picasso.get().load("http://image.barodaweb.net/api/EGreen/Magic/200/ProductGroup-Vegetables/a1.jpg/100").error(R.drawable.veg).transform(new RoundedTransformation(20, 0)).into(img_btn_veggie);
        // TODO do the same for other 3 buttons image just replace the url also read below commented lines
        // just add the complete url i am only fetching the image name eg gjhdf9dflhfgldf.jpg complete the url
        // for eg "http://image.barodaweb.net/api/EGreen/Magic/200/ProductGroup-Vegetables/gjhdf9dflhfgldf.jpg"
        //Picasso.get().load("https//sdfsdf/sfsdf/sfsdf" + fruits_url)   like this


        Picasso.get().load(fruits_url).error(R.drawable.milk).transform(new RoundedTransformation(20, 0)).into(img_btn_milk);
        Picasso.get().load(milk_url).error(R.drawable.fruits).transform(new RoundedTransformation(20, 0)).into(img_button_fruits);
        Picasso.get().load(waffers_url).error(R.drawable.waffer).transform(new RoundedTransformation(20, 0)).into(img_btn_waffers);


        return view;

    }

    private void getData() {

        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {

                URL url = NetworkClass.buildURl(NetworkClass.MAIN_BUTTON_URL);
                List<MainButtonImage> result = NetworkClass.fetchMainButtonData(url);

                 //TODO also i dont know which image are out of three group icon product image or group banner image from the fetched url so you can just change image. whatever u want to fetch
                // getting results
                MainButtonImage image = result.get(0);
                fruits_url = image.getGroupImage();
                // eg image.getGroupIcon or image.getGroupBannerImage or image.getGroupIcon


                MainButtonImage image2 = result.get(1);
                veggie_url = image2.getGroupImage();

                MainButtonImage image3 = result.get(2);
                waffers_url = image3.getGroupImage();

                MainButtonImage image4 = result.get(3);
                milk_url = image4.getGroupImage();



                Log.d("titu", fruits_url + "   " + veggie_url +  "  "+ milk_url + "  " + waffers_url);


            }
        });


    }

}
