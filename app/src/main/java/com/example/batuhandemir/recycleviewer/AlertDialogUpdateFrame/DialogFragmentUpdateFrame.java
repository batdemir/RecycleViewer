package com.example.batuhandemir.recycleviewer.AlertDialogUpdateFrame;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.batuhandemir.recycleviewer.R;

import java.util.HashMap;
import java.util.Map;

public class DialogFragmentUpdateFrame extends DialogFragment {

    private View view;

    private TextView txtGuncelleme;
    private ImageView imgEditPng;
    private TextView txtEdit;
    private ImageButton imgBtnLeft;
    private ImageButton imgBtnRight;
    private ImageView imgPageOne;
    private ImageView imgPageTwo;
    private ImageView imgPageThree;

    private Integer pageIndex=1;
    private HashMap<Integer, ImageView> activePageHash = new HashMap<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frame_updated_page,null);
        init();
        Register_Handler();
        getDialog().getWindow().requestFeature(getActivity().getWindow().FEATURE_NO_TITLE);
        getDialog().getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        setCancelable(true);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        getDialog().getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
    }

    private void init(){
        txtGuncelleme = view.findViewById(R.id.txtGuncelleme);
        imgEditPng = view.findViewById(R.id.imgEditPng);
        txtEdit = view.findViewById(R.id.txtEdit);
        imgBtnLeft = view.findViewById(R.id.imgBtnLeft);
        imgBtnRight = view.findViewById(R.id.imgBtnRight);
        imgPageOne = view.findViewById(R.id.imgPageOne);
        imgPageTwo = view.findViewById(R.id.imgPageTwo);
        imgPageThree = view.findViewById(R.id.imgPageThree);
    }
    private void Register_Handler(){
        click_imgBtnLeft();
        click_imgBtnRight();
        fill_activePageHash();
        set_activePage(pageIndex);
    }

    private void click_imgBtnLeft(){
        imgBtnLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pageIndex == 1)
                    pageIndex = 3;
                else
                    pageIndex --;

                set_activePage(pageIndex);
            }
        });
    }
    private void click_imgBtnRight(){
        imgBtnRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pageIndex == 3)
                    pageIndex = 1;
                else
                    pageIndex ++;

                set_activePage(pageIndex);
            }
        });
    }
    private void fill_activePageHash(){
        activePageHash.put(1,imgPageOne);
        activePageHash.put(2,imgPageTwo);
        activePageHash.put(3,imgPageThree);
    }
    private void set_activePage(int position){
        if(position == 1){
            imgEditPng.setImageDrawable(view.getContext().getDrawable(R.drawable.update_frame_list_png));
            txtEdit.setText("Tespit Modül güncellemesi ile birlikte gelen, Üretici Listesine eklenen yeni özellik !");
        }else if (position == 2){
            imgEditPng.setImageDrawable(view.getContext().getDrawable(R.drawable.update_frame_listitem_green_png));
            txtEdit.setText("Üretici Listesinde Tespit Filitresini Kullandığınızda 'Yeşil Renk' ile görünen Üreticiler 'TESPİTLERİ TAMAMLANMIŞ' anlamına gelmektedir.");
        }else if (position==3){
            imgEditPng.setImageDrawable(view.getContext().getDrawable(R.drawable.update_frame_listitem_blue_png));
            txtEdit.setText("Üretici Listesinde Tespit Filitresini Kullandığınızda 'Mavi Renk' ile görünen Üreticiler 'TESPİTLERİ YARIM KALMIŞ' anlamına gelmektedir.");
        }
        set_activePageIcon(position);
    }
    private void set_activePageIcon(int position){
        for(Map.Entry<Integer,ImageView> img : activePageHash.entrySet()){
            if(img.getKey() == position){
                img.getValue().setImageDrawable(view.getContext().getDrawable(R.drawable.update_frame_active_page_icon));
            }
        }
        for(Map.Entry<Integer,ImageView> img : activePageHash.entrySet()){
            if(img.getKey() != position){
                img.getValue().setImageDrawable(view.getContext().getDrawable(R.drawable.update_frame_deactive_page_icon));
            }
        }
    }
}

