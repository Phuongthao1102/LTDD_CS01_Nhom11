package com.example.ungdungtaptheduc.ui.ChieuCaoCanNang;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class cccnViewModel extends  ViewModel{
    private MutableLiveData<String> mText;

    public cccnViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Weight & Height fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
