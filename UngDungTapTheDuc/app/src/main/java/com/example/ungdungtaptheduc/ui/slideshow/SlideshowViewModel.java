package com.example.ungdungtaptheduc.ui.slideshow;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SlideshowViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SlideshowViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Chúng tôi mong muốn giúp bạn kỷ luật bản thân của chính mình\n\n" +
                "Lời khuyên:Hãy lấy sức khỏe làm chủ đạo thay vì có bắp cuồn cuộn, 6 " +
                "múi các thứ để cua gái! Điều đó chắc chắn sẽ làm bạn nản lòng!!!");
    }

    public LiveData<String> getText() {
        return mText;
    }
}