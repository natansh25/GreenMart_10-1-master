package infinity1087.android.com.examplehr.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.net.URL;
import java.util.List;

import infinity1087.android.com.examplehr.Network.NetworkClass;
import infinity1087.android.com.examplehr.R;
import infinity1087.android.com.examplehr.RoundedTransformation.RoundedTransformation;
import infinity1087.android.com.examplehr.appExecuter.AppExecutors;
import infinity1087.android.com.examplehr.model.MainButtonImage;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment {

//BaseUrl
private static String CategoryBaseURL = "http://image.barodaweb.net/api/EGreen/Magic/270/";

    ImageView img_btn_veggie, img_btn_milk, img_button_fruits, img_btn_waffers,img_offer;
    TextView txt_veggie,txt_fruits,txt_milk,txt_waffer;
    String milk_url, fruits_url, veggie_url, waffers_url,txtvegurl,txtfruiturl ,txtmilkurl ,txtwafferurl;


    public CategoryFragment() {

        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

//      Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_category, container, false);
        txt_veggie = view.findViewById(R.id.txt_VegGroup);
        txt_fruits = view.findViewById(R.id.txt_fruitGroup);
        txt_milk = view.findViewById(R.id.txt_milkGroup);
        txt_waffer = view.findViewById(R.id.txt_wafferGroup);
        img_btn_veggie = view.findViewById(R.id.img_veggie);
        img_btn_milk = view.findViewById(R.id.img_milk);
        img_btn_waffers = view.findViewById(R.id.img_waffers);
        img_button_fruits = view.findViewById(R.id.img_fruits);
        img_offer = view.findViewById(R.id.img_offer);

        getData();
//      Picasso.get().load("http://image.barodaweb.net/api/EGreen/Magic/270/ProductGroup-1/46bc8c078310497c981203c9ab0c5b95.jpg/100").error(R.drawable.veg).transform(new RoundedTransformation(20, 0)).into(img_button_fruits);
        Picasso.get().load(CategoryBaseURL+"ProductGroup-1"+"/"+txtvegurl+"/100").error(R.drawable.fruit).transform(new RoundedTransformation(20,0)).into(img_button_fruits);
        Picasso.get().load(CategoryBaseURL+"ProductGroup-2"+"/"+txtfruiturl+"/100").error(R.drawable.veg).transform(new RoundedTransformation(20, 0)).into(img_btn_veggie);
        Picasso.get().load(CategoryBaseURL+"ProductGroup-3"+"/"+txtwafferurl+"/100").error(R.drawable.waffer).transform(new RoundedTransformation(20, 0)).into(img_btn_waffers);
        Picasso.get().load(CategoryBaseURL+"ProductGroup-4"+"/"+txtmilkurl+"/100").error(R.drawable.milk).transform(new RoundedTransformation(20, 0)).into(img_btn_milk);

//      Offer Banner

        Picasso.get().load("http://image.barodaweb.net/api/EGreen/Magic/1170/ProductGroup-1/cffab3047c1149a89a43fa3ce2bc42d5.jpg/10").transform(new RoundedTransformation(20,0)).into(img_offer);
        return view;

    }

    private void getData() {

        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {

                URL url = NetworkClass.buildURl(NetworkClass.MAIN_BUTTON_URL);
                List<MainButtonImage> result = NetworkClass.fetchMainButtonData(url);

                // getting results
                MainButtonImage textveg = result.get(0);
                txtvegurl = textveg.getGetProductname();

                MainButtonImage textfruit = result.get(1);
                txtfruiturl = textfruit.getGetProductname();

                MainButtonImage textwaffer = result.get(2);
                txtwafferurl = textwaffer.getGetProductname();

                MainButtonImage textMilk = result.get(3);
                txtmilkurl = textMilk.getGetProductname();

                MainButtonImage image = result.get(0);
                fruits_url = image.getGroupImage();

                MainButtonImage image2 = result.get(1);
                veggie_url = image2.getGroupImage();

                MainButtonImage image3 = result.get(2);
                waffers_url = image3.getGroupImage();

                MainButtonImage image4 = result.get(3);
                milk_url = image4.getGroupImage();

                Log.d("ti", fruits_url + "   " + veggie_url +  "  " + milk_url + "  " + waffers_url+" " + txtvegurl+"" +" "+txtfruiturl);


            }
        });


    }

}
