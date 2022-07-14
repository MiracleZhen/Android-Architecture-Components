package com.ling.mvp.ui.rate.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import com.ling.mvp.R
import com.ling.mvp.databinding.DialogRateUsBinding
import com.ling.mvp.ui.base.view.BaseDialogFragment
import com.ling.mvp.ui.rate.interactor.RateUsMvpInterator
import com.ling.mvp.ui.rate.presenter.RateUsMvpPresenter
import javax.inject.Inject

/**
 * author : wangchengzhen
 * time   : 2022/7/13
 * desc   : RateUsDialog
 */
class RateUsDialog : BaseDialogFragment(), RateUsDialogMvpView {

    companion object {

        private const val TAG = "RateUsDialog"

        fun newInstance(): RateUsDialog {
            return RateUsDialog()
        }
    }

    private var binding: DialogRateUsBinding? = null

    @Inject
    internal lateinit var presenter: RateUsMvpPresenter<RateUsDialogMvpView, RateUsMvpInterator>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DialogRateUsBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onAttach(this)
        binding?.btnLater?.setOnClickListener { presenter.onLaterOptionClicked() }
        binding?.btnSubmit?.setOnClickListener { presenter.onSubmitOptionClicked() }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.onDetach()
        binding = null
    }

    internal fun show(fragmentManager: FragmentManager) = super.show(fragmentManager, TAG)

    override fun showRatingSubmissionSuccessMessage() {
        Toast.makeText(context, getString(R.string.rating_submitted_successfully), Toast.LENGTH_LONG).show()
    }

    override fun dismissDialog() {
        super.dismissDialog(TAG)
    }
}
