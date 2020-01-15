package com.example.ezeats;


import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import task.ImageTask;

public class DateFragment extends Fragment {
    private FragmentActivity activity;
    private ImageView ivMenu;
    private TextView tvMenuId, tvName, tvPrice, tvContent;
    private final static String TAG = "DateFrgment";
    private Menu menu;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = getActivity();
        menu = (Menu)(getArguments() != null ? getArguments().getSerializable("menu") : null);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment_date, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ivMenu = view.findViewById(R.id.ivMenu);
        tvMenuId = view.findViewById(R.id.tvMenuId);
        tvName = view.findViewById(R.id.tvName);
        tvPrice = view.findViewById(R.id.tvPrice);
        tvContent = view.findViewById(R.id.tvContent);

        final NavController navController = Navigation.findNavController(view);
        Bundle bundle = getArguments();
        if(bundle == null || bundle.getSerializable("menu") == null){
            Common.showToast(activity, R.string.textNOMenu);
            navController.popBackStack();
            return;
        }
        menu = (Menu) bundle.getSerializable("menu");
        showMenu();
    }

    private void showMenu() {
        String url = Common.URL_SERVER + "MenuServlet";
        String id = menu.getMENU_ID();
        int imageSize = getResources().getDisplayMetrics().widthPixels / 3;
        Bitmap bitmap = null;
        try {
            bitmap = new ImageTask(url, id, imageSize).execute().get();
        }catch (Exception e){
            Log.e(TAG, e.toString());
        }
        if (bitmap != null){
            ivMenu.setImageBitmap(bitmap);
        }else {
            ivMenu.setImageResource(R.drawable.no_image);
        }
        tvMenuId.setText(menu.getMENU_ID());
        tvName.setText(menu.getFOOD_NAME());
        tvPrice.setText(String.valueOf(menu.getFOOD_PRICE()));
        tvContent.setText(menu.getFOOD_CONTENT());
    }
}


