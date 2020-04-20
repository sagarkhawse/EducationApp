package com.skteam.unitopper.loginregister;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.skteam.unitopper.R;

public class ForgetPasswordBottomSheet extends BottomSheetDialogFragment {
private Context context;
private BottomSheetListner mListner;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_sheet_forget_password,container,false);
        Button continue_btn = view.findViewById(R.id.continue_btn);
        continue_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListner.onButtonClicked();
            }
        });
        return view;
    }



    public interface BottomSheetListner{
        void onButtonClicked();
    }
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    try {
        mListner =(BottomSheetListner) context;
    }catch (ClassCastException e){
        throw new ClassCastException(context.toString() + " must implement BottomSheetListner");
    }
    }
}
