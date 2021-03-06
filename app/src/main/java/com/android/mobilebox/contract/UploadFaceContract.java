package com.android.mobilebox.contract;

import com.android.mobilebox.base.presenter.AbstractPresenter;
import com.android.mobilebox.base.view.AbstractView;
import com.android.mobilebox.core.bean.BaseResponse;
import com.android.mobilebox.core.bean.user.FaceBody;
import com.android.mobilebox.core.bean.user.OpenResult;
import com.android.mobilebox.core.bean.user.OrderBody;
import com.android.mobilebox.core.bean.user.TerminalResult;
import com.android.mobilebox.core.bean.user.UploadFaceResponse;
import com.android.mobilebox.core.bean.user.UserInfo;

import java.util.List;

import okhttp3.MultipartBody;
import retrofit2.http.Body;
import retrofit2.http.Path;

/**
 * @author yhm
 * @date 2018/2/26
 */

public interface UploadFaceContract {
    interface View extends AbstractView {

        void handleUploadFace(BaseResponse<UploadFaceResponse> uploadFaceResponse);

        void handleupdateFace(BaseResponse<UserInfo> userInfoResponse);

    }

    interface Presenter extends AbstractPresenter<View> {

        void uploadFace(MultipartBody.Part part);

        void updateFace(FaceBody faceBody);
    }
}
